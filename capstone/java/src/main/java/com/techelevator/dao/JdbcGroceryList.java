package com.techelevator.dao;


import com.techelevator.model.GroceryList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcGroceryList implements GroceryListDao {

   private final JdbcTemplate jdbcTemplate;

   public JdbcGroceryList(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }


    @Override
    public List<GroceryList> listAll() {

        return null;
    }

    @Override
    public GroceryList getByTitle(String title) {
        return null;
    }

    @Override
    public GroceryList getByListId(int groceryListId) {
        return null;
    }

    @Override
    public GroceryList createGroceryList(GroceryList newGroceryList) {
//        String sql = "INSERT INTO "
       return null;
    }

    @Override
    public GroceryList updateGroceryList(GroceryList groceryList) {
        return null;
    }

    @Override
    public GroceryList deleteGroceryList(GroceryList groceryList) {
        return null;
    }

    @Override
    public GroceryList getRecipeGroceryList(int recipeId) {
        GroceryList groceryList = null;
        String sql = "SELECT r.name, i.name, i.category, rp.plan_id, ri.quantity, ri.unit FROM recipe r JOIN recipe_ingredient ri ON r.recipe_id = ri.recipe_id JOIN ingredient i ON i.ingredient_id = ri.ingredient_id JOIN recipe_plan rp ON ri.recipe_id = rp.recipe_id WHERE r.recipe_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, recipeId);
        if(results.next()) {
           groceryList =  mapRowToGroceryList(results);
        }

        return groceryList;
    }


    @Override
    public GroceryList getGroceryListByPlanId(int planId) {
        GroceryList groceryList = null;
            String sql = "SELECT r.name, i.name, i.category, rp.plan_id, ri.quantity, ri.unit FROM recipe r JOIN recipe_ingredient ri ON r.recipe_id = ri.recipe_id JOIN ingredient i ON i.ingredient_id = ri.ingredient_id JOIN recipe_plan WHERE rp.plan_id = ?;";


            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, planId);
            if(results.next()) {
                groceryList = mapRowToGroceryList(results);
            }
            return groceryList;
        }

    @Override
    public GroceryList getGroceryListByUserId(int userId) {
        return null;
    }


    private GroceryList mapRowToGroceryList(SqlRowSet results) {
        GroceryList groceryList = new GroceryList();
       groceryList.setGroceryListId(groceryList.getGroceryListId());
       groceryList.setTitle(groceryList.getTitle());
       groceryList.setPlanId(results.getInt("plan_id"));
       groceryList.setQuantity(results.getString("quantity"));
       groceryList.setUnit(results.getInt("unit"));
       groceryList.setRecipeId(results.getInt("recipe_id"));
       groceryList.setName(results.getString("iname"));
       groceryList.setUserId(results.getInt("user_id"));
      return groceryList;
    }
}
