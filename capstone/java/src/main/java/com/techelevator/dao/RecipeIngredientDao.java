package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredient;
import com.techelevator.model.RecipeIngredientDetail;

public interface RecipeIngredientDao {

    //CRUD operations by ID
    RecipeIngredient addIngredientToRecipe(RecipeIngredient addedIngredient);

//    boolean updateIngredients(Ingredient ingredient);

    int updateIngredients(RecipeIngredient updatedRecipe);

    public void removeIngredient(int recipeId, int ingredientId);

    //CRUD operations by name
    RecipeIngredient addIngredientToRecipeByName(String recipeName, String ingredientName);

    RecipeIngredient updateIngredientsByName(String recipeName, String ingredientName);

    void deleteIngredientFromRecipeByName(String recipeName, String ingredientName);



}
