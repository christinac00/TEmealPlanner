<template>
  <div>
     <meal-plans />
      <add-plan /> 
      <router-link tag="add meal plan" :to="{name:'add-plan',params:{userId: $route.params.id}}">
          
      </router-link>

  </div>
</template>

<script>
 import MealPlans from "@/components/MealPlans.vue"

export default {
     name: "meal-plan",
     components: { MealPlans}
  
}
</script>

<style>

</style>