package com.repository.impl.Recipe;

import bslogic.model.Recipe;
import bslogic.model.RecipeComponent;
import bslogic.staticdata.SqlRecipeStaticData;
import com.repository.services.Recipe.RepositoryGetRecipe;
import com.repository.util.RowMapper.Recipe.RecipeRowMapper;
import com.repository.util.RowMapper.RecipeComponent.RecipeComponentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class GetRecipeImpl implements RepositoryGetRecipe {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Recipe> getAllRecipes(){
        return getAllOrOneRecipeWithComponents(SqlRecipeStaticData.sGetAllRecipesWithSingleQuery);
    }
    @Override
    public List<Recipe> getRecipeById(Integer id){
        return getAllOrOneRecipeWithComponents(SqlRecipeStaticData.sGetRecipesWithSingleQueryById,id);
    }
    @Override
    public List<Recipe> getRecipeByCaloriesCategoryId(Integer id){
        return getAllOrOneRecipeWithComponents(SqlRecipeStaticData.sGetRecipeWithCompByCaloriesId,id);
    }
    @Override
    public List<Recipe> getRecipeByFoodCategoryId(Integer id){
        return getAllOrOneRecipeWithComponents(SqlRecipeStaticData.sGetRecipeWithCompByFoodCategoryId,id);
    }



    private List<Recipe> getAllOrOneRecipeWithComponents(String sql, Integer id){
        final Map<Integer, Recipe> recipes = new HashMap<>();
     jdbcTemplate.query(sql, (rs, rowNum) -> {
         Integer recipeId = rs.getInt("r_id");
         Recipe recipe = recipes.get(recipeId);
         if (recipe == null) {
             RecipeRowMapper recipeRowMapper = new RecipeRowMapper();
             recipe = recipeRowMapper.mapRow(rs, rowNum);
             recipes.put(recipeId, recipe);

         }
         RecipeComponentRowMapper recipeComponentRowMapper = new RecipeComponentRowMapper();
         RecipeComponent component = new RecipeComponent();
         component.setRecipe_id(recipeId);
         component = recipeComponentRowMapper.mapRow(rs, rowNum);
         recipe.getRecipeComponents().add(component);

         return component;
     }, new Object[]{id});
        List<Recipe> result = new ArrayList<>(recipes.values());
        return result;

    }



    private List<Recipe> getAllOrOneRecipeWithComponents(String sql){
        final Map<Integer, Recipe> recipesAll = new HashMap<>();

        this.jdbcTemplate.query(sql, (rs, rowNum) -> {
            Integer recipeId = rs.getInt("r_id");
            Recipe recipe = recipesAll.get(recipeId);
            if (recipe == null) {
                RecipeRowMapper recipeRowMapper = new RecipeRowMapper();
                recipe = recipeRowMapper.mapRow(rs, rowNum);
                recipesAll.put(recipeId, recipe);
            }
            RecipeComponentRowMapper recipeComponentRowMapper = new RecipeComponentRowMapper();
            RecipeComponent component = new RecipeComponent();
            component.setRecipe_id(recipeId);
            component = recipeComponentRowMapper.mapRow(rs, rowNum);
            recipe.getRecipeComponents().add(component);
            return component;
        });
        // sort list
        List<Recipe> resultOne = new ArrayList<>(recipesAll.values());
        Collections.sort(resultOne, (r1, r2) -> r1.getRecipe_id() - r2.getRecipe_id());

        return resultOne;

    }
}
