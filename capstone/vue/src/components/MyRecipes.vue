<template>
  <div class="my-recipes">
      <div class="recipe-header">
          <h1>My Recipe Library</h1>
      </div>
      <div class="recipe-row"  v-for="recipe in myRecipes" v-bind:key="recipe.name" >
          <p> {{ recipe.recipeId }}</p>
          <p> {{ recipe.name }}</p>
          <p> {{ recipe.instructions }}</p>
      </div>
  </div>
</template>

<script>
import applicationServices from "@/services/ApplicationServices";
export default {

name: "my-recipes",
data() {
    return {
        myRecipes: [],
      isLoading: true,
    }

},  
created() {
    this.retrieveMyRecipes();
},

methods:{ 
    retrieveMyRecipes() {
        
            applicationServices.getMyRecipes(this.$route.params.id).then(response => {
                this.myRecipes = response.data
                this.isLoading = false;
            })
        }
        }
};
</script>

<style>

</style>