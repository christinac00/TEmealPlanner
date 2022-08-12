package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeIngredient;
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
    public int updateQuantity(RecipeIngredient updatedRecipe) {

        String sql = "UPDATE recipe_ingredient SET quantity= ?, unit = ? WHERE recipe_id=? AND ingredient_id = ? ;";
        return jdbcTemplate.update(sql, updatedRecipe.getQuantity(), updatedRecipe.getUnit(), updatedRecipe.getRecipeId(), updatedRecipe.getIngredientId()) ==1? updatedRecipe.getQuantity():null;
    }

    @Override
    public Recipe addIngredientToRecipe(RecipeIngredient recipe) {
        String sql = "INSERT INTO recipe_ingredient (recipe_id, ingredient_id, quantity, unit) VALUES (?, ?, ?, ?);";
        jdbcTemplate.queryForRowSet(sql, recipe.getRecipeId(), recipe.getIngredientId(), recipe.getQuantity(), recipe.getUnit());
        Recipe newRecipe = new Recipe();
                newRecipe.setRecipeId(recipe.getRecipeId());
        return newRecipe;
    }

    @Override
    public Ingredient updateIngredients(Ingredient ingredient) {
        return null;
    }



    @Override
    public void removeIngredient(int id){
        String sql = "DELETE FROM recipe_ingredient WHERE ingredient_id = ?;";
        jdbcTemplate.update(sql,id);
    }



    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }



}
