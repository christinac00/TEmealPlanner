package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getByIngredientName(String ingredientName);

    Recipe getByTagName(String tagName);


    Recipe getDetails(int recipeId);

    Recipe updateRecipe(Recipe recipe);

    Recipe create(Recipe newRecipe);


//
//    boolean deleteRecipe(int recipeId);



}
