package com.techelevator.model;

public class RecipeIngredientDTO {
    //instance variables
    private String recipeName;
    private String ingredientToUpdateName;
    private String ingredientName;
    private String quantity;
    private String unit;

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

    public String  getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIngredientToUpdateName() {
        return ingredientToUpdateName;
    }
    public void setIngredientToUpdateName(String ingredientToUpdateName) {
        this.ingredientToUpdateName = ingredientToUpdateName;
    }
}
