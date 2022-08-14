<template>
 
  <div class="loading" v-if="isLoading">
    <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
    
</template>

<script>
import MealService from "@/services/MealService";
// import AddPlan from "@/components/AddPlan.vue"
export default {
name: "my-meal-plans",
components: {  },
data() {
    return {
        myMealPlans: [],
      isLoading: true,
    }

},  
created() {
    this.retrieveMyMealPlans();
    this.newMealPlan()
},

methods:{ 
    retrieveMyMealPlans() {
        
            MealService.getAllMealPlans().then(response => {
                this.myMealPlans = response.data
                this.isLoading = false;
            })
        },
        newMealPlan(){
        MealService.newMealPlan(this.$route.params.id).then(response => {
            this.myMealPlans = response.data
            this.isLoading = false;
        })
        
        }
}
};

</script>

<style>

</style>