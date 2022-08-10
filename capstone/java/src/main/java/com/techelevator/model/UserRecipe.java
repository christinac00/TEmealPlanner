package com.techelevator.model;

public class UserRecipe {

    private int user_id;
    private int recipe_id;
    private boolean isCreated;
    private boolean isFavorite;

    public UserRecipe(int user_id, int recipe_id, boolean isCreated, boolean isFavorite) {
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.isCreated = isCreated;
        this.isFavorite = isFavorite;
    }

    public UserRecipe() {}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }



}
