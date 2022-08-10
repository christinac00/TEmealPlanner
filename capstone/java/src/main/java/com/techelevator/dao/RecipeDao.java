package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getByName(String name);

    Recipe getDetails(int recipeId);

    boolean create(String name, String dietType, String instructions, Recipe recipe);

    boolean updateRecipe(String name, String dietType, String instructions, Recipe recipe);

    boolean deleteRecipe(int recipeId);



}
