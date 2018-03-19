package com.services.impl.Recipe;

import bslogic.model.Recipe;
import com.repository.services.Recipe.RepositoryCreateRecipe;
import com.services.interfaces.Recipe.CreateRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRecipeServiceImpl implements CreateRecipeService {

    @Autowired
    private RepositoryCreateRecipe repositoryCreateRecipe;

    @Override
    public Recipe createRecipe(Recipe recipe){
        setProperCaloriesCategory(recipe);
        return repositoryCreateRecipe.createRecipeWithComponents(recipe);
    }

    private void setProperCaloriesCategory(Recipe recipe){
        if (recipe.getCalories() <= 300) {
            recipe.setCaloriesCat(1);
        } else if (recipe.getCalories() > 300 && recipe.getCalories() <= 600) {
            recipe.setCaloriesCat(2);
        } else {
            recipe.setCaloriesCat(3);
        }

    }
}
