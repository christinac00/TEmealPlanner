<template>
  <div class="recipe-details-body">
      <div class="loading" v-if="isLoading">
    <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
<div class="recipe-details-card">
    <h1 class="recipe-name">{{ recipe.name }}</h1>
</div>
<div>
    <h2 class="instructions">instructions</h2>
    <h3>{{ recipe.instructions }}</h3>
</div>
<div>
  
    <h2>Ingredients</h2>  
    <!-- <router-link><button class="edit button"> Edit Recipe </button>
</router-link> -->
</div>
  </div>
  
</template>

<script>
import applicationServices from '../services/ApplicationServices';
export default {
    name: "my-recipe-details",
    data () {
        return {
            recipe: {},
            isLoading: true,
        }
    },
    created() {
        this.retrieveDetails()
    },
    methods: {
    retrieveDetails() {
        applicationServices.getDetails(this.$route.params.recipeId).then(response =>{
            this.recipe = response.data
            this.isLoading = false;
        })
    }
    }

}
</script>
<style>


</style>