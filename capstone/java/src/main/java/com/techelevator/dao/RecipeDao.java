package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getByName(String name);

    Recipe getDetails(int recipeId);

    Recipe create(Recipe newRecipe);

    Recipe updateRecipe(Recipe recipe);

    boolean deleteRecipe(int recipeId);



}
