package com.services.impl.Recipe;


import bslogic.model.Recipe;
import com.repository.services.Recipe.RepositoryDeleteRecipe;
import com.services.interfaces.Recipe.DeleteRecipeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRecipeServiceImpl implements DeleteRecipeService {

  private final RepositoryDeleteRecipe deleteRecipeLocal;

  public DeleteRecipeServiceImpl(RepositoryDeleteRecipe deleteRecipe){
      this.deleteRecipeLocal=deleteRecipe;
  }

  @Override
  @Transactional
  public void deleteRecipe(Integer id){
      deleteRecipeLocal.deleteRecipe(id);
  }

}
