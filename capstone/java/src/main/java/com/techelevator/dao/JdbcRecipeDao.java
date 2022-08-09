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
        String sql = "select * from recipes;";

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
    public Recipe getByRecipeName(String recipeName) {
        String sql = "SELECT * FROM recipes WHERE recipe_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeName);
        if(results.next()) {
            return mapRowToUser(results);
            } else {
                return null;
            }
        }


    @Override
    public Recipe getByDietType(String dietType) {
        String sql = "SELECT recipes FROM recipe WHERE diet_type = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dietType);
        if(results.next()) {
            return mapRowToUser(results);
        } else {
            return null;
        }
    }

    @Override
    public Recipe getByIngredientId(int ingredientId) {
        String sql = "SELECT recipe WHERE ingredient_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ingredientId);
        if(results.next()) {
           return mapRowToUser(results);
        } else {
            return null;
        }

    }

    @Override
    public int create(int recipeId, String recipeName, String dietType, int ingredientId) {
        String insertRecipeSql = "insert into recipes (recipe_id, recipe_name, diet_type, ingredient_id;)";
        return jdbcTemplate.update(insertRecipeSql);
    }


    private Recipe mapRowToUser(SqlRowSet results) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(Integer.parseInt("recipe_id"));
        recipe.setIngredient_id(Integer.parseInt("ingredient_id"));
        recipe.setRecipeName("recipe_name");
        recipe.setDietType("diet_type");
        recipe.setInstructions("instructions");
        return recipe;
    }


}
