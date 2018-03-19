package com.services.interfaces.Recipe;

import bslogic.model.Recipe;

import java.util.List;

public interface SearchRecipeServiceByName {
    List<Recipe> FindRecipeByName(String name);
}
