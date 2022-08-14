<template>
  <div class="recipe-details-body">
      <div class="loading" v-if="isLoading">
    <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
<div class="recipe-details-card">
    <h1 class="recipe-name">{{ recipe.name }}</h1>
</div>

<router-link tag="button" class="btn editRecipe" :to="{name:'add-recipe', params:{userId: $route.params.id}}" v-if="!isLoading" >Edit Recipe</router-link>
<img class="icon" v-if="recipe.image" v-bind:src="recipe.image" />

<div>
    <h2 class="description">Description</h2>
    <p class="description">{{ recipe.description }}</p>
</div>
<div>
    <h2 class="instructions">Instructions</h2>
    <p class="instruction-body">{{ recipe.instructions }}</p>
</div>
<div>
  
    <h2>Ingredients</h2>  
    <table>
        <tr>
            <td>
                amount:
            </td>
            <td>
                units:
            </td>
            <td>
                name:
            </td>
        </tr>
        <tr v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.id">
            <td>
                {{ ingredient.quantity}}

            </td>
            <td>
                {{ingredient.unit}}
            </td>
            <td>
                {{ingredient.name}}
            </td>
        </tr>
    </table>
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
.icon{
    width: 200px;
    height: 200px;
}

.instruction-body{
    font-family: sans-serif;
    white-space: pre;
}

table, tr, td {
    border: 1px solid;
}



</style>