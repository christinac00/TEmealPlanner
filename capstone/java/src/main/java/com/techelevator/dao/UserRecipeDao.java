package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;
import com.techelevator.model.UserRecipe;

import java.util.List;

public interface UserRecipeDao {

    List<Recipe> myRecipesList (int user_id);


    Boolean addUserRecipe(int userId, int recipeId);

//    boolean modifyRecipe(int userId, RecipeDetail recipeDetail);

    void deleteRecipe(int userId, int recipeId);

}
