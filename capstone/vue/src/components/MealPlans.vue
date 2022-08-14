<template>
 <div class="my-plans">
  <div class="loading" v-if="isLoading">
    <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
    <div class="plans-header">
        <h1>My Meal Plan Library</h1>
    </div>
    <meal-card v-for="plan in myMealPlans" v-bind:key="plan.name"
      v-bind:plan="plan" />
</div>
</template>

<script>
import MealService from "@/services/MealService";
// import AddPlan from "@/components/AddPlan.vue"
import MealCard from "@/components/MealCard.vue"
export default {
name: "my-meal-plans",
components: { MealCard },
data() {
    return {
        myMealPlans: [],
      isLoading: true,
    }

},  
created() {
    this.retrieveMyMealPlans();
    
},

methods:{ 
    retrieveMyMealPlans() {
        
            MealService.getAllMealPlans(this.$route.params.id).then(response => {
                this.myMealPlans = response.data
                this.isLoading = false;
            })
        },
      
    
}
};

</script>

<style>

</style>