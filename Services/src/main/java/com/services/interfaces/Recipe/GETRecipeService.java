package com.services.interfaces.Recipe;

import bslogic.model.Recipe;


import java.util.List;

public interface GETRecipeService {
    public List<Recipe> getAllRecipesWithComponents();

    List<Recipe> getRecipeWithComponentsById(Integer id);

    List<Recipe> getRecipeWithComponentsByCaloriesCategoryId(Integer id);

    List<Recipe> getRecipesWithComponentsByFoodCategoryId(Integer id);
}
