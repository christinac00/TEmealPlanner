<template>
  <form v-on:submit.prevent>
    <label for="plan-name">Plan Name: </label>
    <input name="plan-name" type="text" v-model="plan.planName"/>
    <label for="day-of-week">What day is this plan for? </label>
    <select name="day-of-week" id="day-of-week" v-model="plan.dayOfWeek">
      <option value="">--Choose a Day from the Dropdown Menu--</option>
      <option value="monday">Monday</option>
      <option value="tuesday">Tuesday</option>
      <option value="wednesday">Wednesday</option>
      <option value="thursday">Thursday</option>
      <option value="friday">Friday</option>
      <option value="saturday">Saturday</option>
      <option value="sunday">Sunday</option>
    </select>
    <button type="submit" v-on:click.prevent="addPlan">Add Plan</button>
  </form>
</template>

<script>
import mealService from "../services/MealService";

export default {
  name: "add-plan",
  data() {
    return {
      plan: {
        planId: 0,
        userId: 0,
        planName: "",
        dayOfWeek: "",
      },
    };
  },
  methods: {
    addPlan() { 
      this.plan.userId = this.$route.params.userId
      mealService
        .newMealPlan(this.$route.params.userId, this.plan)
        .then((response) => {
          if (response.status === 201) {
            this.plan = {
              plan: {
                planId: 0,
                userId: 0,
                planName: "",
                dayOfWeek: "",
              },
            };
          }
        });
      this.$router.push({
        name: "my-meal-plans",
        params: { id: this.$route.params.userId },
      });
    },
  },
};
</script>

<style>
</style>