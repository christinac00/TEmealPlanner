<template>
 <router-link :to="{ name: 'my-recipe-details', params: {recipeId: recipe.recipeId}}"> 
     <div class="card">
    <h2 class="recipe-name">{{ recipe.name }}</h2>
    <img v-if="recipe.image" v-bind:src="recipe.image" />
    <p class="recipe-description">{{ recipe.description }}</p>
  </div>
  </router-link>
</template>

<script>
export default {
    name: 'recipe-card',
    props: {
        recipe: Object
    },
    methods: {
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 550px;
    height: 250px;
    margin: 20px;
}
.card > img{
position:relative;
 right: -38%;
  width: 100px;
  border-radius: 60px;
}
.card .recipe-name {
    font-size: 1.5rem;
}

.card .recipe-description{
    font-size: 1rem;
}
</style>