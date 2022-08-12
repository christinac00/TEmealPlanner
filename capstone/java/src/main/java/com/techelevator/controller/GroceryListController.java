package com.techelevator.controller;

import com.techelevator.dao.GroceryListDao;
import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.model.GroceryList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes/{recipeId}")
@CrossOrigin(origins = "http://localhost:8080")
public class GroceryListController {

    private final RecipeDao recipeDao;
    private final MealPlanDao mealPlanDao;
    private final IngredientDao ingredientDao;
    private final GroceryListDao groceryListDao;

    public GroceryListController(RecipeDao recipeDao, MealPlanDao mealPlanDao, IngredientDao ingredientDao, GroceryListDao groceryListDao) {
        this.recipeDao = recipeDao;
        this.mealPlanDao = mealPlanDao;
        this.ingredientDao = ingredientDao;
        this.groceryListDao = groceryListDao;
    }

    @RequestMapping(path = "/grocery-list", method = RequestMethod.GET)
    public GroceryList getRecipeGroceries(@PathVariable int recipeId) {
        return groceryListDao.getRecipeGroceryList(recipeId);
    }

    @RequestMapping(path = "/{planId}", method = RequestMethod.GET)
    public GroceryList getGroceriesByPlanId(@PathVariable int planId) {
        return groceryListDao.getGroceryListByPlanId(planId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{planId}", method = RequestMethod.PUT)
    public GroceryList newGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListDao.createGroceryList(groceryList);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{recipeId}", method = RequestMethod.PUT)
    public GroceryList updateGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListDao.updateGroceryList(groceryList);
    }



}


