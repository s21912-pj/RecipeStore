package com.repository.impl.Recipe;

import bslogic.model.Recipe;
import bslogic.staticdata.SqlRecipeStaticData;
import com.repository.services.Recipe.RepositoryDeleteRecipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteRecipeImpl implements RepositoryDeleteRecipe {

    private final JdbcTemplate jdbcTemplate;
    //constructor injection
    public DeleteRecipeImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void deleteRecipe(Integer id){
        deleteRecipeFromStore(id);
    }

    private void deleteRecipeFromStore(Integer id){
        jdbcTemplate.update(SqlRecipeStaticData.sDeleteRecipe, new Object[]{id});
    }

}
