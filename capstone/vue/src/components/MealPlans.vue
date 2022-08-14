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
        my: [],
      isLoading: true,
    }

},  
created() {
    this.retrieveMyRecipes();
},

methods:{ 
    retrieveMyRecipes() {
        
            MealService.getMyRecipes(this.$route.params.id).then(response => {
                this.myRecipes = response.data
                this.isLoading = false;
            })
        }
        }
};

</script>

<style>

</style>