package com.techelevator.dao;

import com.techelevator.model.GroceryList;

import java.util.List;

public interface GroceryListDao {

    List<GroceryList> listAll();

    GroceryList getByTitle(String title);

    GroceryList getByListId(int groceryListId);

    GroceryList getRecipeGroceryList(int recipeId);

    GroceryList getGroceryListByPlanId(int planId);

    GroceryList getGroceryListByUserId(int userId);

    GroceryList createGroceryList(GroceryList newGroceryList);

    GroceryList updateGroceryList(GroceryList groceryList);

    GroceryList deleteGroceryList(GroceryList groceryList);


}
