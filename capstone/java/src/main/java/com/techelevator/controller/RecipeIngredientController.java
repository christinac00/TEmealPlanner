package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeIngredientDao;
import com.techelevator.exception.IngredientNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredient;
import com.techelevator.model.RecipeIngredientDetail;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeIngredientController {

    private final RecipeDao recipeDao;
    private final IngredientDao ingredientDao;
    private final RecipeIngredientDao recipeIngredientDao;


    public RecipeIngredientController(RecipeDao recipeDao, IngredientDao ingredientDao, RecipeIngredientDao recipeIngredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
        this.recipeIngredientDao = recipeIngredientDao;
    }

    //update ingredient QUANTITY or unit
    @RequestMapping(path = "/recipes/{recipeId}/ingredient/{ingredientId}", method = RequestMethod.PUT)
    public int update(@PathVariable int recipeId, @PathVariable int ingredientId, @RequestBody RecipeIngredient recipeIngredient){
        recipeIngredient.setRecipeId(recipeId);
        recipeIngredient.setIngredientId(ingredientId);
        return recipeIngredientDao.updateIngredients(recipeIngredient);
    }

    @RequestMapping(path = "/recipes/{recipeId}/ingredient/{ingredientId}", method = RequestMethod.POST)
    public RecipeIngredient addIngredientToRecipe (@RequestBody RecipeIngredient addedIngredient){
        return recipeIngredientDao.addIngredientToRecipe(addedIngredient);



    }

    //delete ingredient from user's recipe
    @RequestMapping(path = "/recipes/{recipeId}/ingredient/{ingredientId}", method = RequestMethod.DELETE)
    public void removeIngredient(@PathVariable int recipeId,@PathVariable int ingredientId) throws IngredientNotFoundException{
        recipeIngredientDao.removeIngredient(recipeId, ingredientId);
    }

}
