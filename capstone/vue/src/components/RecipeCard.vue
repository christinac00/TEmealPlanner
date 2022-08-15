<template>
 <router-link class="card" :to="{ name: 'my-recipe-details', params: {recipeId: recipe.recipeId}}" tag="div"> 
     <img v-if="recipe.image" v-bind:src="recipe.image" />
     <div>
     <h2 class="recipe-name">{{ recipe.name }}</h2>
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
    display: flex;
    flex-direction: column;
    width: 95%;
    height: 150px;
    margin: 20px;
    background: lightcoral;
    align-items: center;
}

.card > img {
  border-radius: 10px;
  
}
.card .recipe-name {
    font-size: 1.5rem;
    text-align: center;
}

.card .recipe-description{
    font-size: 1rem;
}
</style>