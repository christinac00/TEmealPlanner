package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao {
    //Lists all meal plans
    List<MealPlan> list(int userId);

    //create a new meal plan
    MealPlan createMealPlan(MealPlan newMealPlan);

    //get a meal plan by name
    MealPlan getMealPlanByName(String planName, int userId);

    //get a meal plan by id
    MealPlan getMealPlanById(int planId);

    //update a meal plan
    void updateMealPlan(MealPlan updatedMealPlan, int planId);

    //delete a meal plan
    void deleteMealPlan(int planId);
}
