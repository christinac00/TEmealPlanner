package com.techelevator.controller;

import com.techelevator.dao.GroceryListDao;
import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.model.GroceryList;
import com.techelevator.model.MealPlan;
import com.techelevator.model.RecipeIngredientDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
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

    //getting a grocery list back by recipe id
    @RequestMapping(path = "/{recipeId}/grocery-list", method = RequestMethod.GET)
    public GroceryList getRecipeGroceries(@PathVariable int recipeId) {

        return groceryListDao.getRecipeGroceryList(recipeId);
    }


    //method below not being used yet.
    @RequestMapping(path = "/grocery-list", method = RequestMethod.GET)
    public GroceryList getGroceriesByPlanId(@PathVariable int planId) {
        return groceryListDao.getGroceryListByPlanId(planId);
    }

    //creating a grocery list
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/grocery-list", method = RequestMethod.PUT)
    public GroceryList newGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListDao.createGroceryList(groceryList);
    }

    //updating a grocery list
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{recipeId}/grocery-list", method = RequestMethod.PUT)
    public GroceryList updateGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListDao.updateGroceryList(groceryList);
    }
//    @RequestMapping(path = "/users/{userId}/grocery-list",method = RequestMethod.GET)
//    public List<RecipeIngredientDetail> getGroceryList(@PathVariable int userId){
//        for (MealPlan mealPlan:  mealPlanDao.list(userId)){
//
//        }
//    }
//        for (MealPlan mealPlan:  mealPlanDao.list(userId)
//
//        }


}


