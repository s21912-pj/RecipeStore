package com.services.impl.Recipe;

import bslogic.model.Recipe;
import com.repository.services.Recipe.RepositorySearchRecipeByName;
import com.services.interfaces.Recipe.SearchRecipeServiceByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchRecipeByName implements SearchRecipeServiceByName{

    @Autowired
    private RepositorySearchRecipeByName searchRecipeByName;

    @Override
    public List<Recipe> FindRecipeByName(String name){
       return searchRecipeByName.FindRecipeByName(name);
    }
}
