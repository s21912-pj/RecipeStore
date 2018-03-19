package com.repository.impl.Recipe;

import bslogic.model.Recipe;
import bslogic.model.RecipeComponent;
import bslogic.staticdata.SqlRecipeStaticData;
import com.repository.services.Recipe.RepositoryCreateRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CreateRecipeImpl implements RepositoryCreateRecipe {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Recipe createRecipeWithComponents(Recipe recipe) {
        return createFullRecipe(recipe);
    }

    /**
     * Method to create single recipe with list of components
     *
     * @param recipe object
     * @return recipe if its necessery
     */
    private Recipe createFullRecipe(Recipe recipe) {
        List<RecipeComponent> components = recipe.getRecipeComponents();
        String sql;
		
        if (components.isEmpty()) {
            sql = SqlRecipeStaticData.sCreateRecipeWithoutComponents;
        } else {
            sql = SqlRecipeStaticData.sCreateRecipeWithComponents;
        }
		//StringBuffer do zastopienia przez StringJoiner - Java8
        StringBuffer sqlAp = new StringBuffer(sql);
        if (components.size() > 0) {
            for (int c = 1; c < components.size(); c++) {
                sqlAp.append(",(?,?,?,?,(SELECT r_id FROM rows))");
            }
        }
        jdbcTemplate.batchUpdate(sqlAp.toString(), new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, recipe.getRecipeName());
                ps.setObject(2, recipe.getWeight());
                ps.setObject(3, recipe.getAproxPrice());
                ps.setObject(4, recipe.getRaiting());
                ps.setObject(5, recipe.getCalories());
                ps.setObject(6, recipe.getUser_id());
                ps.setObject(7, recipe.getCaloriesCat());
                ps.setObject(8, recipe.getFoodCat());
                int y = 9;
                for (int x = 0; x < components.size(); x++) {
                    RecipeComponent component = components.get(i);

                    ps.setObject(y++, component.getComponentName());
                    ps.setObject(y++, component.getComponentWeight());
                    ps.setObject(y++, component.getComponentCalories());
                    ps.setObject(y++, component.getComponentDescription());
                    i += 1;
                }
            }
            @Override
            public int getBatchSize() {
                return 1;
            }
        });
        return recipe;
    }
}
