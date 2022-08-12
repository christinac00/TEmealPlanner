package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao{
    private final JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    public JdbcMealPlanDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    //lists all meal plans for current user
    public List<MealPlan> list(int userId) {
        List<MealPlan> mealPlans = new ArrayList<>();
        String sql = "SELECT * FROM plan WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            mealPlans.add(mapRowToMealPlan(results));
        }
        return mealPlans;
    }

    @Override
    //creates new meal plan
    public MealPlan createMealPlan(MealPlan newMealPlan) {
        String sql = "INSERT INTO plan (user_id, name, day_of_week) VALUES (?, ?, ?) RETURNING plan_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newMealPlan.getUserId(), newMealPlan.getPlanName(),newMealPlan.getDayOfWeek());
        return getMealPlanById(newId);
    }

    @Override
    public MealPlan getMealPlanById(int planId) {
        String sql = "SELECT * FROM plan WHERE plan_id = ?;";
        MealPlan mealPlan = null;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, planId);
        if (results.next()) {
            mealPlan = mapRowToMealPlan(results);
        }
        return mealPlan;
    }
    @Override
    public MealPlan getMealPlanByName(String planName, int userId) {
        MealPlan mealPlan = null;
        String sql = "SELECT plan_id, name, day_of_week FROM plan WHERE name = ? AND user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, planName, userId);
        if (results.next()) {
            mealPlan = mapRowToMealPlan(results);
        }
        return mealPlan;
    }

    @Override
    public void updateMealPlan(MealPlan updatedMealPlan, int planId) {
        String sql = "UPDATE plan SET name = ?, day_of_week =? WHERE plan_id = ?;";
        jdbcTemplate.update(sql, updatedMealPlan.getPlanName(), updatedMealPlan.getDayOfWeek(), planId);
    }

    @Override
    public void deleteMealPlan(int planId) {
        String sql = "DELETE FROM plan WHERE plan_id = ?;";
        jdbcTemplate.update(sql, planId);
    }

    private MealPlan mapRowToMealPlan(SqlRowSet results) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setPlanId(results.getInt("plan_id"));
        mealPlan.setUserId(results.getInt("user_id"));
        mealPlan.setPlanName(results.getString("name"));
        mealPlan.setDayOfWeek(results.getString("day_of_week"));
        return mealPlan;
    }

}
