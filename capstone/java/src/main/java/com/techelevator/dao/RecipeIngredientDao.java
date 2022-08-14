package com.techelevator.dao;

import com.techelevator.model.*;

public interface RecipeIngredientDao {

    //CRUD operations by ID
    RecipeIngredient addIngredientToRecipe(RecipeIngredient addedIngredient);

//    boolean updateIngredients(Ingredient ingredient);

    int updateIngredients(RecipeIngredient updatedRecipe);

    public void removeIngredient(int recipeId, int ingredientId);

    //CRUD operations by name
    //may add change to a boolean later
    Boolean addIngredientToRecipeByName(RecipeIngredientDTO addedIngredient);

    Boolean updateRecipeIngredientsByName(RecipeIngredientDTO updatedIngredient);

    Boolean deleteIngredientFromRecipeByName(RecipeIngredientDTO deletedIngredient);

}
