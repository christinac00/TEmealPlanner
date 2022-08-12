package com.techelevator.model;

public class RecipeIngredient {
     int recipeId;
     int ingredientId;
     int quantity;
     String unit;


    public RecipeIngredient(int userId, int recipeId, int quantity, String unit) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.unit = unit;
    }

    public RecipeIngredient() {

    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
