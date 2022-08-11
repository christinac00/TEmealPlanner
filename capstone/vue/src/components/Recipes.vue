<template>
    <div class="recipes">
       <div class="recipe-header">
          <h1>Recipe Library</h1>  
    </div> 
    <div class="recipe-row" v-for="recipe in recipe" v-bind:key="recipe.name">
       <p>  {{ recipe.recipeId }} </p>
       <p>  {{ recipe.name }} </p>
       <p>  {{ recipe.instructions }} </p>


    </div>
    </div>
</template>

<script>
import { applicationServices } from '@/services/ApplicationServices';

export default {

    name: "recipes",
    data() {
        return {
            recipes: [],
            isLoading: true,
        }
        
    },
    created() {
        this.retrieveRecipes();
    },

    methods:{
        retrieveRecipes() {

            applicationServices.getRecipes(this.$route.params.id).then(response => {
                this.recipes = response.data
                this.isLoading = false;
            })
        }
    }
}
</script>

<style>

</style>
