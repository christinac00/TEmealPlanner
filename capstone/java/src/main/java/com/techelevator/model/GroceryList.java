package com.techelevator.model;

public class GroceryList {

    int groceryListId;
    String title;
    int userId;
    int planId;
    int recipeId;
    int unit;
    int quantity;
    String name;

    public GroceryList(int groceryListId, String title, int userId, int recipeId, int unit, int quantity, int planId, String name) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
