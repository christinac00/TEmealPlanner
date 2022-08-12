package com.techelevator.model;

public class Recipe {

    private int recipeId;
    private String name;



    private String image;
    private String description;
    private String instructions;


    public Recipe(int recipeId, String name, String image, String description, String instructions) {
        this.recipeId = recipeId;
        this.name = name;
        this.image = image;
        this.description = description;
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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
