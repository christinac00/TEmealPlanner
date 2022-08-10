package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private String name;
    private String instructions;



    public Recipe(int recipeId, String name, String instructions) {
        this.recipeId = recipeId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }



}
