package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getById(int recipeId);

    Recipe getByRecipeName(String recipeName);

    Recipe getByDietType(String dietType);

    Recipe getByIngredientId(int ingredientId);

    boolean create(String recipeName, String dietType, int ingredientId);

    boolean updateMyRecipe(String recipeName, String dietType, int ingredientId);

}
