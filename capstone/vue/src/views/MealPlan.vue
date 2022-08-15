<template>
  <div>
     <meal-plans />
      <add-plan /> 
      <router-link tag="add meal plan" :to="{name:'add-plan',params:{userId: $route.params.id}}">
          
      </router-link>

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