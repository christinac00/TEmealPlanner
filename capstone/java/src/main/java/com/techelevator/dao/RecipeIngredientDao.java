package com.techelevator.dao;

import com.techelevator.model.Recipe;

public interface RecipeIngredientDao {

    boolean updateAmount();

    Recipe addIngredientToRecipe();

    Recipe updateIngredients();

}
