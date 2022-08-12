package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeIngredientDao;
import com.techelevator.exception.IngredientNotFoundException;
import com.techelevator.model.RecipeIngredient;
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

    //update ingredient QUANTITY
    @RequestMapping(path = "/recipes/{id}/ingredient/{ingredientId}", method = RequestMethod.PUT)
    public int update(@PathVariable int recipeId, @PathVariable int ingredientId, @RequestBody RecipeIngredient recipeIngredient){
        recipeIngredient.setRecipeId(recipeId);
        recipeIngredient.setIngredientId(ingredientId);
        return recipeIngredientDao.updateQuantity(recipeIngredient);
    }

    //delete ingredient from user's recipe
    @RequestMapping(path = "/recipes/{id}/ingredient/{ingredientId}", method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable int id) throws IngredientNotFoundException{
        recipeIngredientDao.removeIngredient(id);
    }

}
