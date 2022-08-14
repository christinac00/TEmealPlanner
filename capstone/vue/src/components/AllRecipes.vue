<template>
    <div class="recipes">
        <div class="loading" v-if="isLoading">
    <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
       <div class="recipe-header">
          <h1>Recipe Library</h1> 
          <input class="search-bar" type="text" placeholder="Search by Ingedient"> 
    </div> 

    <recipe-card v-for="recipe in allRecipes" v-bind:key="recipe.name"
      v-bind:recipe="recipe"
      />

    <!-- <div class="recipe-row" v-for="recipe in allRecipes" v-bind:key="recipe.name">
       <p>  {{ recipe.recipeId }} </p>
       <p>  {{ recipe.name }} </p>
       <p>  {{ recipe.instructions }} </p>


    </div> -->
    </div>
</template>

<script>
import  recipeService  from '@/services/RecipeService';
import RecipeCard from "@/components/RecipeCard.vue";

export default {

    name: "all-recipes",
    data() {
        return {
            allRecipes: [],
            isLoading: true,
        }
        
    },
    created() {
        this.retrieveAllRecipes();
    },
    components: { RecipeCard },

    methods:{
        retrieveAllRecipes() {

            recipeService.getAllRecipes().then(response => {
                this.allRecipes = response.data
                this.isLoading = false;
            })
        }
    }
}
</script>

<style>

</style>
