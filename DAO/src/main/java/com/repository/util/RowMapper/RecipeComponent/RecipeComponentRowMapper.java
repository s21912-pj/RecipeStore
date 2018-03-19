package com.repository.util.RowMapper.RecipeComponent;

import java.sql.ResultSet;
import java.sql.SQLException;

import bslogic.model.RecipeComponent;
import org.springframework.jdbc.core.RowMapper;



public class RecipeComponentRowMapper implements RowMapper<RecipeComponent>{

	@Override
	public RecipeComponent mapRow(ResultSet rs, int rowNum) throws SQLException {

		RecipeComponent component = new RecipeComponent();
		component.setComponent_id(rs.getInt("c_id"));
		component.setComponentName(rs.getString("c_name"));
		component.setComponentWeight(rs.getDouble("c_weight"));
		component.setComponentDescription(rs.getString("c_description"));
		//component.setRecipe_id(rs.getInt("c_recipe_id"));
		component.setComponentCalories(rs.getDouble("c_calories"));
		
		return component;
	}

	
	
}
