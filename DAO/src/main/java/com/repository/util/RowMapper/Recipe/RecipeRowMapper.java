package com.repository.util.RowMapper.Recipe;

import bslogic.model.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RecipeRowMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(rs.getInt("r_id"));
        recipe.setRecipeName(rs.getString("r_name"));
        recipe.setAproxPrice(rs.getDouble("r_aprox_price"));
        recipe.setWeight(rs.getDouble("r_weight"));
        recipe.setRaiting(rs.getInt("r_raiting"));
        recipe.setCalories(rs.getDouble("r_calories"));
        recipe.setUser_id(rs.getInt("r_user_id"));
        recipe.setCaloriesCat(rs.getInt("r_kcategory_id"));
        recipe.setFoodCat(rs.getInt("r_fcategory_id"));
        recipe.setPublishDate(rs.getDate("r_published_date"));
        recipe.setRecipeComponents(new ArrayList<>());


        return recipe;
    }

}
