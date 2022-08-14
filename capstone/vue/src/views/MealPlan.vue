<template>
  <div>
     <meal-plans />
      <add-plan /> 

  </div>
</template>

<script>
 import AddPlan from "@/components/AddPlan.vue";
 import mealPlans from "@/components/MealPlans.vue"

export default {
     name: "meal-plans",
     components: { AddPlan, mealPlans}
  
}
</script>

<style>

</style>