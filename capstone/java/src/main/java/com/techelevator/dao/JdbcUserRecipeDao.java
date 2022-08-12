package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipeDetail;
import com.techelevator.model.UserRecipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserRecipeDao implements UserRecipeDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcUserRecipeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
    public List<Recipe> myRecipesList(int user_id){
        List<Recipe> result = new ArrayList<>();

        String sql = "SELECT * FROM recipe r JOIN user_recipe ur ON r.recipe_id = ur.recipe_id WHERE ur.user_id = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, user_id);
        while(rowSet.next()){

            Recipe recipe = new Recipe();
            mapRowToRecipe(rowSet, recipe);
            result.add(recipe);

        }
        return result;
    }

    //adding recipe to user: make copy of existing recipe and adds updates per user
    @Override
    public Recipe addUserRecipe(int userId, Recipe recipe) {
        String sql = "INSERT INTO user_recipe (user_id, recipe_id, isCreated, isFavorite) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, userId, recipe.getRecipeId(), true, true);



        UserRecipe userRecipe= new UserRecipe();
        userRecipe.setUser_id(userId);
        String editSql = "UPDATE recipe SET name = ?, instructions = ? WHERE recipe_id = ?";
        jdbcTemplate.queryForRowSet(editSql, recipe.getName(), recipe.getInstructions(), recipe.getRecipeId());

        return recipe;
    }


    @Override
    public boolean modifyRecipe(int userId, RecipeDetail recipeDetail){
        UserRecipe userRecipe = new UserRecipe();
        userRecipe.setUser_id(userId);

        String sql = "UPDATE recipe SET name = ? , instructions = ? WHERE recipe_id = ?";
        return jdbcTemplate.update(sql, userId, recipeDetail.getRecipeId(), false, true)==1;
    }


    private void mapRowToUserRecipe(SqlRowSet rowSet){
        UserRecipe result = new UserRecipe();
        result.setUser_id(rowSet.getInt("user_id"));
        result.setRecipe_id(rowSet.getInt("recipe_id"));
        result.setCreated(rowSet.getBoolean("isCreated"));
        result.setFavorite(rowSet.getBoolean("isFavorite"));


    }


    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }


}
