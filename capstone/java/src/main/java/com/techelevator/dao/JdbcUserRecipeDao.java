package com.techelevator.dao;

import com.techelevator.model.Recipe;
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



//            UserRecipe userRecipe = mapRowToRecipe(rowSet);
//            userRecipe.setUser_id(userRecipe.getUser_id());
//            result.add(userRecipe);
        }
        return result;
    }

    @Override
    public UserRecipe addUserRecipe(UserRecipe userRecipe){
        String sql = "INSERT INTO user_recipe (user_id, recipe_id, isCreated, isFavorite) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, userRecipe.getUser_id(), userRecipe.getRecipe_id(), true, true);

        Recipe recipe = new Recipe();
        recipe.setRecipeId(userRecipe.getRecipe_id());
        String editSql = "UPDATE recipe SET name = ?, instructions = ? WHERE recipe_id = ?";

        return userRecipe;
    }


    @Override
    public boolean modifyRecipe(UserRecipe modifiedRecipe){
        String sql = "UPDATE user_recipe SET user_id = ? , recipe_id = ? , isCreated = ? , isFavorite = ? ";
        return jdbcTemplate.update(sql, modifiedRecipe.getUser_id(), modifiedRecipe.getRecipe_id(), false, true)==1;
    }


    private UserRecipe mapRowToRecipe(SqlRowSet rowSet){
        UserRecipe result = new UserRecipe();
        result.setUser_id(rowSet.getInt("user_id"));
        result.setRecipe_id(rowSet.getInt("recipe_id"));
        result.setCreated(rowSet.getBoolean("isCreated"));
        result.setFavorite(rowSet.getBoolean("isFavorite"));
        return result;

    }


    private void mapRowToRecipe(SqlRowSet results, Recipe recipe) {
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setName(results.getString("name"));
        recipe.setInstructions(results.getString("instructions"));

    }


}
