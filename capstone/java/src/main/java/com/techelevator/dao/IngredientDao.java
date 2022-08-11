package com.techelevator.dao;

import com.techelevator.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    //list all ingredients
    List<Ingredient> list();

    //create a new ingredient
    Ingredient createIngredient(Ingredient newIngredient);

    //get ingredient by id
    Ingredient getIngredientById(int ingredientId);

    //update existing ingredient
    void updateIngredient(Ingredient updatedIngredient);

    //delete an ingredient
    void removeIngredient(int ingredientId);

    //search by ingredient
    List<Ingredient> searchByIngredientName(String name_like);

    //search by category
    List<Ingredient> searchByCategory(String category_like);


}
