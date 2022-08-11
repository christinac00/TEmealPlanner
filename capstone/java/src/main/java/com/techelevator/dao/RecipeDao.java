package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> listAll();

    Recipe getByIngredientName(String ingredientName);

    Recipe getByTagName(String tagName);

<<<<<<< HEAD
    Recipe getDetails(int recipeId);
=======
    Recipe updateRecipe(Recipe recipe);
>>>>>>> 3253bea1d15fb55066a3a41f882e71c09d06d2de

//    Recipe create(Recipe newRecipe);
//
//    boolean updateRecipe(String name, String dietType, String instructions, Recipe recipe);
//
//    boolean deleteRecipe(int recipeId);



}
