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
            Recipe recipe = mapRowToUser(results);
            recipes.add(recipe);
        }

        return recipes;
    }


    @Override
    public Recipe getById(int recipeId) {
        String sql = "SELECT * FROM recipe WHERE recipe_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeId);
        if (results.next()) {
            return mapRowToUser(results);
        } else {
            return null;
        }

    }

    @Override
    public Recipe getByName(String name) {
        String sql = "SELECT * FROM recipe WHERE name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            return mapRowToUser(results);
            } else {
                return null;
            }
        }


    @Override
    public Recipe getByDietType(String dietType) {
        String sql = "SELECT * FROM recipe WHERE diet_type = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dietType);
        if(results.next()) {
            return mapRowToUser(results);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(String name, String dietType, String instructions, Recipe recipe) {
        String insertRecipeSql = "INSERT INTO recipe (name, diet_type, instructions) VALUES ?, ?, ?;";
        return jdbcTemplate.update(insertRecipeSql, recipe.getName(), recipe.getDietType(), recipe.getInstructions()) == 1;
        //should we have this return the new id?
    }

    @Override
    public boolean updateRecipe(String name, String dietType, String instructions, Recipe recipe) {
        String sql = "UPDATE recipe SET recipe_name = ?, diet_type = ?, instructions = ? WHERE recipe_id = ?;";
        return jdbcTemplate.update(sql, recipe.getName(), recipe.getDietType(), recipe.getInstructions()) == 1;

        }

    @Override
    public boolean deleteRecipe(int recipeId) {
        return false;
    }


    private Recipe mapRowToUser(SqlRowSet results) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(Integer.parseInt("recipe_id"));
        recipe.setName("name");
        recipe.setDietType("diet_type");
        recipe.setInstructions("instructions");
        return recipe;
    }


}
