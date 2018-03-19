package com.repository.services.Recipe;

import bslogic.model.Recipe;

import java.util.List;

public interface RepositorySearchRecipeByName {
    List<Recipe> FindRecipeByName(String name);
}
