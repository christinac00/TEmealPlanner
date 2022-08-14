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
    public int updateIngredients(RecipeIngredient updatedRecipe) {

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

//    @Override
//    public boolean updateIngredients(Ingredient ingredient) {
//        return false;
//    }



    @Override
    public void removeIngredient(int recipeId, int ingredientId){
        String sql = "DELETE FROM recipe_ingredient WHERE recipe_id=? AND ingredient_id = ?;";
        jdbcTemplate.update(sql,recipeId, ingredientId);
    }

    //CRUD operations by name
    @Override
    public Boolean addIngredientToRecipeByName(RecipeIngredientDTO addedIngredient) {
        String sql = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id, quantity, unit) VALUES ((SELECT recipe_id FROM recipe WHERE name = ?), (SELECT ingredient_id FROM ingredient WHERE name = ?), ?, ?);";
        jdbcTemplate.update(sql, addedIngredient.getRecipeName(), addedIngredient.getIngredientName(), Integer.parseInt(addedIngredient.getQuantity()), addedIngredient.getUnit());
        return true;
    }

    @Override
    public Boolean updateRecipeIngredientsByName(RecipeIngredientDTO updatedIngredient) {
        String sql = "UPDATE recipe_ingredient SET ingredient_id = (SELECT ingredient_id FROM ingredient WHERE NAME = ?), quantity = ?, unit = ? WHERE recipe_id = (SELECT recipe_id FROM recipe WHERE NAME = ?) AND ingredient_id =(SELECT ingredient_id FROM recipe_ingredient WHERE ingredient_id = (SELECT ingredient_id FROM ingredient WHERE name =?));";
        jdbcTemplate.update(sql, updatedIngredient.getIngredientName(), Integer.parseInt(updatedIngredient.getQuantity()), updatedIngredient.getUnit(), updatedIngredient.getRecipeName(), updatedIngredient.getIngredientToUpdateName());
        return true;
    }

    @Override
    public Boolean deleteIngredientFromRecipeByName(RecipeIngredientDTO deletedIngredient) {
        String sql = "DELETE FROM recipe_ingredient WHERE recipe_id = (SELECT recipe_id FROM recipe WHERE name = ?) AND ingredient_id = (SELECT ingredient_id FROM ingredient WHERE name = ?);";
        jdbcTemplate.update(sql, deletedIngredient.getRecipeName(), deletedIngredient.getIngredientName());
        return true;
    }


    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }



}
