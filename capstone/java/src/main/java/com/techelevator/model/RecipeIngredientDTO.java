package com.techelevator.model;

public class RecipeIngredientDTO {
    //instance variables
    private String recipeName;
    private String ingredientName;
    private int quantity;
    private String unit;

    //constructors

    //getters and setters
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    public String getIngredientName() {
        return ingredientName;
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
