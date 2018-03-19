package com.repository.services.Recipe;

import bslogic.model.Recipe;

import java.util.List;

public interface RepositoryGetRecipe {
    List<Recipe> getAllRecipes();

    List<Recipe> getRecipeById(Integer id);

    List<Recipe> getRecipeByCaloriesCategoryId(Integer id);

    List<Recipe> getRecipeByFoodCategoryId(Integer id);
}
