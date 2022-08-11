package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredient;

public interface RecipeIngredientDao {

    int updateQuantity(RecipeIngredient updatedRecipe);

    Recipe addIngredientToRecipe(RecipeIngredient recipe);

    Ingredient updateIngredients(Ingredient ingredient);

}
