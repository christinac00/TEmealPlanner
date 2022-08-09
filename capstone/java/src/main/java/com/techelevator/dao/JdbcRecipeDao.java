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
    public Recipe getByRecipeName(String recipeName) {
        String sql = "SELECT * FROM recipe WHERE recipe_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeName);
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
    public Recipe getByIngredientId(int ingredientId) {
        String sql = "SELECT * FROM recipe WHERE ingredient_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ingredientId);
        if(results.next()) {
           return mapRowToUser(results);
        } else {
            return null;
        }

    }

    @Override
    public boolean create(String recipeName, String dietType, int ingredientId) {
        String insertRecipeSql = "INSERT INTO user_recipe (recipe_name, diet_type, ingredient_id;)";
        return jdbcTemplate.update(insertRecipeSql);
        //this is wanting an int but it's a boolean. does it have to be an int?
    }

    @Override
    public boolean updateMyRecipe(String recipeName, String dietType, int ingredientId) {
        String sql = "UPDATE user_recipe SET recipe WHERE recipe_id = ?;";
      //userRecipe is red because the users part isn't created yet
        return jdbcTemplate.update(sql, userRecipe.getRecipe(), userRecipe.getUserId());
    }

    private Recipe mapRowToUser(SqlRowSet results) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(Integer.parseInt("recipe_id"));
        recipe.setIngredientId(Integer.parseInt("ingredient_id"));
        recipe.setRecipeName("recipe_name");
        recipe.setDietType("diet_type");
        recipe.setInstructions("instructions");
        return recipe;
    }


}
