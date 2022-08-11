package com.techelevator.dao;

import com.techelevator.model.Recipe;
import com.techelevator.model.UserRecipe;

import java.util.List;

public interface UserRecipeDao {

    List<Recipe> myRecipesList (int user_id);

    UserRecipe addUserRecipe(UserRecipe userRecipe);

    boolean modifyRecipe(UserRecipe modifiedRecipe);

}
