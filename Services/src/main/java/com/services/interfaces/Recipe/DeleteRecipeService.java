package com.services.interfaces.Recipe;



import org.springframework.transaction.annotation.Transactional;

public interface DeleteRecipeService {
    @Transactional
    void deleteRecipe(Integer id);
}
