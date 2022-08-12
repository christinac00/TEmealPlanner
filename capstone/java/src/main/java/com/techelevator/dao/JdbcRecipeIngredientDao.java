package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcRecipeIngredientDao implements RecipeIngredientDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeIngredientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int update(RecipeIngredient updatedRecipe) {

        String sql = "UPDATE recipe_ingredient SET quantity= ?, unit = ? WHERE recipe_id=? AND ingredient_id = ? ;";
        int response = jdbcTemplate.update(sql, updatedRecipe.getQuantity(), updatedRecipe.getUnit(), updatedRecipe.getRecipeId(), updatedRecipe.getIngredientId());
        return response;
    }

    @Override
    public RecipeIngredient addIngredientToRecipe(RecipeIngredient addedIngredient) {
        String sql = "INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, addedIngredient.getRecipeId(), addedIngredient.getIngredientId(), addedIngredient.getQuantity(), addedIngredient.getUnit());

        return addedIngredient;

    }

//    @Override
//    public boolean updateIngredients(Ingredient ingredient) {
//        return false;
//    }



    @Override
    public void removeIngredient(int recipeId, int ingredientId){
        String sql = "DELETE FROM recipe_ingredient WHERE recipe_id=? AND ingredient_id = ?;";
        jdbcTemplate.update(sql,recipeId, ingredientId);
    }



    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }



}
