package com.techelevator.controller;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/users/{id}/meal-plans")
public class MealPlanController {
    //instance variable
    private MealPlanDao dao;

    //constructor
    public MealPlanController(MealPlanDao mealPlanDao) {this.dao = mealPlanDao;}

    //request handlers
    //create a meal plan
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public MealPlan newMealPlan(@RequestBody MealPlan mealPlan) {
        return dao.createMealPlan(mealPlan);
    }

    //get a meal plan by id
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{planId}", method = RequestMethod.GET)
    public MealPlan getPlanById(@PathVariable int planId) {
        return dao.getMealPlanById(planId);
    }

    //list all meal plans
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<MealPlan> getAllMealPlans(@PathVariable int id) throws InterruptedException {
        Thread.sleep(3000);
        return dao.list(id);
    }

    //update a meal plan
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{planId}", method = RequestMethod.PUT)
    public void updateMealPlan(@PathVariable int planId, @RequestBody MealPlan updatedMealPlan) {
        updatedMealPlan.setPlanId(planId);
        dao.updateMealPlan(updatedMealPlan, planId);
    }

    //delete a meal plan
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{planId}", method = RequestMethod.DELETE)
    public void  deleteMealPlan(@PathVariable int planId) {
        dao.deleteMealPlan(planId);
    }
}
