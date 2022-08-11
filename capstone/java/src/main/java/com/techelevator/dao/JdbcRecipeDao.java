package com.techelevator.dao;

import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;
import com.techelevator.model.RecipeIngredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    private final JdbcTemplate jdbcTemplate;

    public  JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public List<Recipe> listAll() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT * FROM recipe;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Recipe recipe = new Recipe();
            mapRowToRecipe(results, recipe);
            recipes.add(recipe);
        }

        return recipes;
    }

    @Override
    public Recipe getDetails(int recipeId) {
        RecipeDetail recipeDetail = new RecipeDetail();
        String sql = "SELECT r.recipe_id, r.name, r.instructions, i.name iname, i.category, ri.quantity, ri.unit FROM recipe r LEFT OUTER JOIN recipe_ingredient ri ON ri.recipe_id = r.recipe_id LEFT OUTER JOIN ingredient i ON i.ingredient_id = ri.ingredient_id WHERE r.recipe_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeId);
        if (results.next()) {
            mapRowToRecipe(results, recipeDetail);

            mapRowToRecipeIngredient(results, recipeDetail);
            while (results.next()) {
                mapRowToRecipeIngredient(results, recipeDetail);
            }
        }
            return recipeDetail;


    }

    @Override
    public Recipe getByName(String name) {
        Recipe recipe = new Recipe();
        String sql = "SELECT * FROM recipe WHERE name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            mapRowToRecipe(results, recipe);
        }
        return recipe;
        }


    @Override
    //this method should return a Recipe object
    public Recipe create(Recipe newRecipe) {
        //the ? should be inside of parantheses () to match sql syntax for INSERT
        String insertRecipeSql = "INSERT INTO recipe (name, instructions) VALUES (?, ?) RETURNING recipe_id;";
        Integer newId = jdbcTemplate.queryForObject(insertRecipeSql, Integer.class, newRecipe.getName(), newRecipe.getInstructions());
        return getDetails(newId);
        //should we have this return the new id?
        //this should return a Recipe object based on the getDetails method
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        String sql = "UPDATE recipe SET name = ?, instructions = ? WHERE recipe_id = ?;";
        return jdbcTemplate.update(sql, recipe.getName(), recipe.getInstructions(), recipe.getRecipeId()) ==1?getDetails(recipe.getRecipeId()):null;

        }

    @Override
    public boolean deleteRecipe(int recipeId) {
        return false;
    }


    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }
    private void mapRowToRecipeIngredient(SqlRowSet results, RecipeDetail recipeDetail) {
        String name = results.getString("iname");

        if(name != null){
            RecipeIngredient ingredient = new RecipeIngredient();
            ingredient.setAmount(results.getInt("quantity"));
            ingredient.setName(name);
            ingredient.setUnit(results.getString("unit"));
            recipeDetail.getIngredients().add(ingredient);

        }


    }


}
