package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRecipeIngredientDao implements RecipeIngredientDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeIngredientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean updateAmount() {
        return false;
    }

    @Override
    public Recipe addIngredientToRecipe() {
        return null;
    }

    @Override
    public Recipe updateIngredients() {
        return null;
    }
}
