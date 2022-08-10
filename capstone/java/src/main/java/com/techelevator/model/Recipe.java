package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private String name;
    private String dietType;
    private String instructions;
    private char foodLocation;


    public Recipe(int recipeId, String name, String dietType, String instructions) {
        this.recipeId = recipeId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
