package com.services.interfaces.Recipe;

import bslogic.model.Recipe;

public interface UpdateRecipeService {
    Recipe updateRecipeWithComponents(Recipe recipe,Integer id);
}
