package com.techelevator.model;

public class Ingredient {
    //instance variables
    private String name;
    private int ingredientId;
    private String category;

    //constructors
    public Ingredient(){

    }
    public Ingredient(String name, int ingredientId, String category){
        this.name = name;
        this.ingredientId = ingredientId;
        this.category = category;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getCategory() {
        return category;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }


}
