package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredient;
import com.techelevator.model.RecipeIngredientDetail;

public interface RecipeIngredientDao {

    int update(RecipeIngredient updatedRecipe);

    RecipeIngredient addIngredientToRecipe(RecipeIngredient addedIngredient);

//    boolean updateIngredients(Ingredient ingredient);

    public void removeIngredient(int recipeId, int ingredientId);

}
