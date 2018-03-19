package com.services.impl.Recipe;

import bslogic.model.Recipe;
import com.repository.services.Recipe.RepositoryUpdateRecipe;
import com.services.interfaces.Recipe.UpdateRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateRecipeServiceImpl implements UpdateRecipeService {

    @Autowired
    private RepositoryUpdateRecipe repositoryUpdateRecipe;
    @Override
    @Transactional
    public Recipe updateRecipeWithComponents(Recipe recipe, Integer id){
        return repositoryUpdateRecipe.updateFullRecipe(recipe,id);
    }
}
