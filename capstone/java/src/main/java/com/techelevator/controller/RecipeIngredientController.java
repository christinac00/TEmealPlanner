package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeIngredientDao;
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


    @RequestMapping(path = "/recipes/{id}/ingredient", method = RequestMethod.PUT)
    public RecipeIngredient updateQuantity(@PathVariable int recipeId, @RequestBody)


}
