<template>
    <div class="recipes">
       <div class="recipe-header">
          <h1>Recipe Library</h1>  
    </div> 
    <div class="recipe-row" v-for="recipe in allRecipes" v-bind:key="recipe.name">
       <p>  {{ recipe.recipeId }} </p>
       <p>  {{ recipe.name }} </p>
       <p>  {{ recipe.instructions }} </p>


    </div>
    </div>
</template>

<script>
import  applicationServices  from '@/services/ApplicationServices';

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

    methods:{
        retrieveAllRecipes() {

            applicationServices.getAllRecipes(this.$route.params.name).then(response => {
                this.allRecipes = response.data
                this.isLoading = false;
            })
        }
    }
}
</script>

<style>

</style>
