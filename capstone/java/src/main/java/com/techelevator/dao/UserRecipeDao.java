package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;
import com.techelevator.model.UserRecipe;

import java.util.List;

public interface UserRecipeDao {

    List<Recipe> myRecipesList (int user_id);

    Recipe addUserRecipe(int userId, Recipe recipe);

    boolean modifyRecipe(int userId, RecipeDetail recipeDetail);

}
