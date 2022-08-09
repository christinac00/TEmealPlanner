package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private int ingredient_id;
    private char recipeName;
    private String dietType;
    private String instructions; // I thought she didn't want to have cooking instructions?

    public Recipe(int recipeId, int ingredient_id, char recipeName, String dietType, String instructions) {
        this.recipeId = recipeId;
        this.ingredient_id = ingredient_id;
        this.recipeName = recipeName;
        this.dietType = dietType;
        this.instructions = instructions;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public char getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(char recipeName) {
        this.recipeName = recipeName;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
