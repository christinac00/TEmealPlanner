package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private int ingredientId;
    private String recipeName;
    private String dietType;
    private String instructions; // I thought she didn't want to have cooking instructions?
    private char foodLocation;


    public Recipe(int recipeId, int ingredientId, String recipeName, String dietType, String instructions) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.recipeName = String.valueOf(recipeName);
        this.dietType = dietType;
        this.instructions = instructions;

    }

    public Recipe() {

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

    public void setIngredientId(int ingredient_id) {
        this.ingredientId = ingredient_id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
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
