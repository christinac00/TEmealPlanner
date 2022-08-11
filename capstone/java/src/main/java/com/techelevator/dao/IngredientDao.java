package com.techelevator.dao;

import com.techelevator.model.Ingredient;

public interface IngredientDao {

    public Ingredient createIngredient(Ingredient newIngredient);

    public void updateIngredient(Ingredient updatedIngredient);

    public void removeIngredient(int ingredientId);

    public Ingredient getIngredientById(Integer ingredientId);


}
