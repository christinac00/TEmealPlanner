package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetail extends Recipe{

    List<RecipeIngredient> ingredients = new ArrayList<>();

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
