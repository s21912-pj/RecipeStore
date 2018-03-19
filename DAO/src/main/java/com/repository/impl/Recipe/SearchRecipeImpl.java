package com.repository.impl.Recipe;

import bslogic.model.Recipe;
import bslogic.model.RecipeComponent;
import bslogic.staticdata.SqlRecipeStaticData;
import com.repository.services.Recipe.RepositorySearchRecipeByName;
import com.repository.util.RowMapper.Recipe.RecipeRowMapper;
import com.repository.util.RowMapper.RecipeComponent.RecipeComponentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchRecipeImpl implements RepositorySearchRecipeByName{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Recipe> FindRecipeByName(String name){
        return FindModule(SqlRecipeStaticData.sSearchAllRecipesByName,name);
    }

    private List<Recipe> FindModule(String sql, String name){
        final Map<Integer,Recipe> allRecipes = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name","%"+name+"%");
        jdbcTemplate.query(sql, (RowMapper<RecipeComponent>) (rs, rowNum) -> {
            Integer recipeId = rs.getInt("r_id");
            Recipe recipe = allRecipes.get(recipeId);
            if(recipe==null){
                RecipeRowMapper recipeRowMapper = new RecipeRowMapper();
                recipe = recipeRowMapper.mapRow(rs, rowNum);
                allRecipes.put(recipeId,recipe);
            }
            RecipeComponentRowMapper recipeComponentRowMapper = new RecipeComponentRowMapper();
            RecipeComponent recipeComponent = new RecipeComponent();
            recipeComponent.setRecipe_id(recipeId);
            recipeComponent = recipeComponentRowMapper.mapRow(rs,rowNum);
            recipe.getRecipeComponents().add(recipeComponent);
          return null;
        },params.get("name"));
        List<Recipe> result = new ArrayList<>(allRecipes.values());
        return result;
    }
}
