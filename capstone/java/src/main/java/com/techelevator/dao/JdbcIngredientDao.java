package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcIngredientDao implements IngredientDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Ingredient createIngredient(Ingredient newIngredient) {
        String sql = "INSERT INTO ingredient (name, category) VALUES (?, ?) RETURNING ingredient_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newIngredient.getIngredientId(), newIngredient.getName(), newIngredient.getCategory());
        return getIngredientById(newId);
    }

    @Override
    public void updateIngredient(Ingredient updatedIngredient) {
        String sql = "UPDATE ingredient SET name = ?, category = ? WHERE ingredient_id = ?;";
        jdbcTemplate.update(sql, updatedIngredient.getName(), updatedIngredient.getCategory(), updatedIngredient.getIngredientId());
    }

    @Override
    public void removeIngredient(int ingredientId) {
        String sql = "DELETE FROM ingredient WHERE ingredient_id = ?;";
        jdbcTemplate.update(sql, ingredientId);
    }

    @Override
    public List<Ingredient> searchByIngredientName(String name_like) {
        String sql = "SELECT name, category FROM ingredient WHERE name ILIKE '?%' ORDER BY name;";
        return null;
    }

    @Override
    public List<Ingredient> searchByCategory(String category_like) {
        return null;
    }

    @Override
    public Ingredient getIngredientById(int ingredientId) {
        Ingredient ingredient = null;
        String sql = "SELECT * FROM ingredient WHERE ingredient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ingredientId);
        if (results.next()) {
            ingredient = mapRowToIngredient(results);
        }
        return ingredient;
    }

    @Override
    public List<Ingredient> list() {
        Ingredient ingredient = null;
        String sql = "SELECT FROM ingredient;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return null;
    }

    private Ingredient mapRowToIngredient(SqlRowSet results){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(results.getInt("ingredient_id"));
        ingredient.setName(results.getString("name"));
        ingredient.setCategory(results.getString("category"));
        return ingredient;
    }
}
