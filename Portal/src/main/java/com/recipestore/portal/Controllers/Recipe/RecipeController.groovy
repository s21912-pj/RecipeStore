package com.recipestore.portal.Controllers.Recipe

import bslogic.model.Recipe
import com.services.interfaces.Recipe.CreateRecipeService
import com.services.interfaces.Recipe.DeleteRecipeService
import com.services.interfaces.Recipe.GETRecipeService
import com.services.interfaces.Recipe.UpdateRecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipeController {


    @Autowired
    private GETRecipeService getRecipeService;
    @Autowired
    private CreateRecipeService createRecipeService;
    @Autowired
    private UpdateRecipeService updateRecipeService;
    @Autowired
    private DeleteRecipeService deleteRecipeService;

    @GetMapping("/recipes")
    List<Recipe> getFullRecipe(){
        return getRecipeService.getAllRecipesWithComponents();
    }

    @GetMapping("/recipes/category/calories/{id}")
     List<Recipe> FindRecipeByCaloriesCategoryId(@PathVariable("id") Integer id){
        return getRecipeService.getRecipeWithComponentsByCaloriesCategoryId(id);
    }
    @GetMapping("/recipes/category/food/{id}")
    List<Recipe> FindRecipeByFoodCategoryId(@PathVariable("id") Integer id){
        return getRecipeService.getRecipesWithComponentsByFoodCategoryId(id);
    }

    @GetMapping("/recipe/{id}")
   List<Recipe> getOneFullRecipe(@PathVariable("id")Integer id){
        return getRecipeService.getRecipeWithComponentsById(id);
    }

    @PostMapping("/addrecipe")
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        createRecipeService.createRecipe(recipe);
        return new ResponseEntity<Recipe>(HttpStatus.OK);
    }

    @PostMapping("recipe/{id}/update")
    ResponseEntity<Recipe> updateFullRecipe(@PathVariable("id") Integer id,@RequestBody Recipe recipe){
        updateRecipeService.updateRecipeWithComponents(recipe,id);
        return new ResponseEntity<Recipe>(HttpStatus.OK);
    }

    @DeleteMapping("/recipe/{id}/delete")
    ResponseEntity<Recipe> deleteSingleRecipe( @PathVariable("id") Integer id){
        deleteRecipeService.deleteRecipe(id);
        return new ResponseEntity<Recipe>(HttpStatus.OK)
    }

}
