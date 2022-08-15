package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeIngredientDao;
import com.techelevator.exception.IngredientNotFoundException;
import com.techelevator.model.*;
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







    //CRUD by name
    @RequestMapping(path = "/recipe-ingredients", method = RequestMethod.PUT)
    public Boolean updateByName(@RequestBody RecipeIngredientDTO updatedIngredient){
        return recipeIngredientDao.updateRecipeIngredientsByName(updatedIngredient);
    }

    @RequestMapping(path = "/recipe-ingredients", method = RequestMethod.POST)
    public Boolean addIngredientToRecipeByName (@RequestBody RecipeIngredientDTO addedIngredient){
        return recipeIngredientDao.addIngredientToRecipeByName(addedIngredient);

    }

    //delete ingredient from user's recipe
    @RequestMapping(path = "/recipe-ingredients", method = RequestMethod.DELETE)
    public void removeIngredientByName(@RequestBody RecipeIngredientDTO deletedIngredient) throws IngredientNotFoundException{
        recipeIngredientDao.deleteIngredientFromRecipeByName(deletedIngredient);
    }
}
