package com.techelevator.dao;

import com.techelevator.model.Recipe;
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
            recipes.add(mapRowToUser(results));
        }

        return recipes;
    }


    @Override
    public Recipe getById(int recipeId) {
        Recipe recipe = new Recipe();
        String sql = "SELECT * FROM recipe WHERE recipe_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeId);
        if (results.next()) {
            recipe= mapRowToUser(results);
        }
            return recipe;


    }

    @Override
    public Recipe getByName(String name) {
        Recipe recipe = new Recipe();
        String sql = "SELECT * FROM recipe WHERE name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            recipe = mapRowToUser(results);
        }
        return recipe;
        }

        

    @Override
    public boolean create(String name, String dietType, String instructions, Recipe recipe) {
        String insertRecipeSql = "INSERT INTO recipe (name, instructions) VALUES ?, ?, ?;";
        return jdbcTemplate.update(insertRecipeSql, recipe.getName(), recipe.getInstructions()) == 1;
        //should we have this return the new id?
    }

    @Override
    public boolean updateRecipe(String name, String dietType, String instructions, Recipe recipe) {
        String sql = "UPDATE recipe SET recipe_name = ?, instructions = ? WHERE recipe_id = ?;";
        return jdbcTemplate.update(sql, recipe.getName(), recipe.getInstructions()) == 1;

        }

    @Override
    public boolean deleteRecipe(int recipeId) {
        return false;
    }


    private Recipe mapRowToUser(SqlRowSet results) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));
        return recipe;
    }


}
