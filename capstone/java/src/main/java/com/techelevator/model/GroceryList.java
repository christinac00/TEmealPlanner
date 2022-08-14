package com.techelevator.model;

public class GroceryList {
    //not sure if this variable is necessary unless its to differentiate grocery lists of separate users --JH
    int groceryListId;
    //why do we need a title? --JH
    String title;
    int userId;
    int planId;
    //shold we include references to recipe and ingredient names? --JH
    int recipeId;
    int unit;
    String quantity;
    String name;

    public GroceryList(int groceryListId, String title, int userId, int recipeId, int unit, String quantity, int planId, String name) {
        this.groceryListId = groceryListId;
        this.title = title;
        this.userId = userId;
        this.planId = planId;
        this.recipeId = recipeId;
        this.unit = unit;
        this.quantity = quantity;
        this.name = name;
    }

    public GroceryList() {

    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(int groceryListId) {
        this.groceryListId = groceryListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
