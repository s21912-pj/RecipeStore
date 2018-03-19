package com.services.impl.Recipe;

import bslogic.model.Recipe;
import com.repository.services.Recipe.RepositoryGetRecipe;
import com.services.interfaces.Recipe.GETRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GETRecipeServiceImpl implements GETRecipeService {

    @Autowired
    private RepositoryGetRecipe repositoryGetRecipe;

    @Override
    public List<Recipe> getAllRecipesWithComponents(){
        return repositoryGetRecipe.getAllRecipes();
    }
    @Override
    public List<Recipe> getRecipeWithComponentsById(Integer id){
        return repositoryGetRecipe.getRecipeById(id);
    }
    @Override
    public List<Recipe> getRecipeWithComponentsByCaloriesCategoryId(Integer id){
        return repositoryGetRecipe.getRecipeByCaloriesCategoryId(id);
    }
    @Override
    public List<Recipe> getRecipesWithComponentsByFoodCategoryId(Integer id){
        return repositoryGetRecipe.getRecipeByFoodCategoryId(id);
    }
}
