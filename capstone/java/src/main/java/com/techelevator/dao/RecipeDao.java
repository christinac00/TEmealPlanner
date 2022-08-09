package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getById(int recipeId);

    Recipe getByRecipeName(String recipeName);

    Recipe getByDietType(String dietType);

    Recipe getByIngredientId(int ingredientId);

    int create(int recipeId, String recipeName, String dietType, int ingredientId);



}
