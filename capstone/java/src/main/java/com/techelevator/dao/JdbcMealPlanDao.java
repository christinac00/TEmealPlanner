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
    private Principal currentUser;
    public JdbcMealPlanDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    //lists all meal plans
    public List<MealPlan> list() {
        List<MealPlan> mealPlans = new ArrayList<>();
        String sql = "SELECT * FROM plan;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            mealPlans.add(mapRowToMealPlan(results));
        }
        return mealPlans;
    }

    @Override
    //creates new meal plan
    public MealPlan createMealPlan(MealPlan newMealPlan) {
        String sql = "INSERT INTO plan (user_id, name, day_of_week) VALUES (?, ?, ?) RETURNING plan_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class);
        return null;
    }

    @Override
    public MealPlan getMealPlanByName(String planName) {
        /*String sql = "SELECT plan_id, name, day_of_week FROM plan WHERE name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, planName);
        */
        return null;
    }

    @Override
    public void updateMealPlan(MealPlan updatedMealPlan) {
        
    }

    @Override
    public void deleteMealPlan(int planId) {

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
