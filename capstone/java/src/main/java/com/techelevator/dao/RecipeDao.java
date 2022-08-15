package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getByIngredientName(String ingredientName);

//    Recipe getByTagName(String keyword);

    Recipe getByTagName(String keyword, int recipeId, String name);

    Recipe getDetails(int recipeId);

    Recipe updateRecipe(Recipe recipe);

    Recipe create(Recipe newRecipe);

    Recipe getByTagName(String keyword);


//
//    boolean deleteRecipe(int recipeId);



}
