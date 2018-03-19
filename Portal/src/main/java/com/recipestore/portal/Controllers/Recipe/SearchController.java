package com.recipestore.portal.Controllers.Recipe;

import bslogic.model.Recipe;
import com.services.interfaces.Recipe.SearchRecipeServiceByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchRecipeServiceByName searchRecipeServiceByName;


    @GetMapping("/recipe/search?={name}")
    public List<Recipe> FindRecipeByName(@PathVariable("name") String name){
        return searchRecipeServiceByName.FindRecipeByName(name);
    }


}
