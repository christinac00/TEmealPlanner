package com.techelevator.dao;

import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getDetails(int recipeId);

    RecipeDetail updateRecipe(RecipeDetail recipe);

    RecipeDetail create(RecipeDetail newRecipe);

    //methods for SearchController
    List<Recipe> searchByTagName(String keyword);

    List<Recipe> searchByIngredientName(String ingredientName);
//    boolean deleteRecipe(int recipeId);



}
