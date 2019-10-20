package com.repository.impl.Recipe;

import bslogic.model.Recipe;
import bslogic.model.RecipeComponent;
import bslogic.staticdata.SqlComponentStaticData;
import bslogic.staticdata.SqlRecipeStaticData;
import com.repository.services.Recipe.RepositoryUpdateRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UpdateRecipeImpl implements RepositoryUpdateRecipe {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Recipe updateFullRecipe(Recipe recipe){
        return updateRecipe(recipe);
    }


    private Recipe updateRecipe(Recipe recipe) {
        jdbcTemplate.update(SqlRecipeStaticData.sUpdateRecipe, recipe.getRecipeName(), recipe.getWeight(),
                recipe.getAproxPrice(), recipe.getRaiting(), recipe.getCalories(), recipe.getCaloriesCat(),
                recipe.getFoodCat(), recipe.getRecipeId);

        jdbcTemplate.batchUpdate(SqlComponentStaticData.sUpdateComponentByRecipeId, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                RecipeComponent component = recipe.getRecipeComponents().get(i);
                ps.setString(1, component.getComponentName());
                ps.setDouble(2, component.getComponentWeight());
                ps.setDouble(3, component.getComponentCalories());
                ps.setString(4, component.getComponentDescription());
                ps.setInt(5, component.getComponent_id());
            }

            @Override
            public int getBatchSize() {
                return recipe.getRecipeComponents().size();
            }
        });
        return recipe;
    }

}
