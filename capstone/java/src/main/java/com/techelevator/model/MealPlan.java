package com.techelevator.model;

public class MealPlan {
    //instance variables
    private int planId;
    private int userId;
    private String planName;
    private String dayOfWeek;

    //constructors
    public MealPlan(){}

    public MealPlan(int planId, int userId, String planName, String dayOfWeek) {
        this.planId = planId;
        this.userId = userId;
        this.planName = planName;
        this.dayOfWeek = dayOfWeek;
    }

    //getters and setters
    public int getPlanId() {
        return planId;
    }
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlanName() {
        return planName;
    }
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
