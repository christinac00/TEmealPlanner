<template>
 <router-link class="card" :to="{ name: 'my-meal-details', params: {planId: plan.planId}}" tag="div"> 
     <!-- <img v-if="recipe.image" v-bind:src="recipe.image" /> -->
     <div>
     <h2 class="plan-name">{{ plan.name }}</h2>
    <p class="plan-description">{{ plan.day_of_week }}</p>
  </div>
  </router-link>
</template>

<script>
export default {
    name: 'meal-card',
    props: {
        plan: Object
    },
    methods: {
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 95%;
    height: 150px;
    margin: 20px;
    background-color: royalblue;
    /* display: flex; */
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