package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private int ingredient_id;
    private String recipeName;
    private String dietType;
    private String instructions; // I thought she didn't want to have cooking instructions?
    private char foodLocation;


    public Recipe(int recipeId, int ingredient_id, String recipeName, String dietType, String instructions) {
        this.recipeId = recipeId;
        this.ingredient_id = ingredient_id;
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

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
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
