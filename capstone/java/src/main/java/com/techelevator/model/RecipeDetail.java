package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetail extends Recipe{

    List<RecipeIngredientDetail> ingredients = new ArrayList<>();

    public List<RecipeIngredientDetail> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientDetail> ingredients) {
        this.ingredients = ingredients;
    }
}
