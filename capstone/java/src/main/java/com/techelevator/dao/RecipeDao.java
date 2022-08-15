package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getDetails(int recipeId);

    Recipe updateRecipe(Recipe recipe);

    Recipe create(Recipe newRecipe);

    //methods for SearchController
    List<Recipe> searchByTagName(String keyword);

    List<Recipe> searchByIngredientName(String ingredientName);
//    boolean deleteRecipe(int recipeId);



}
