<template>
 <router-link class="card" :to="{ name: 'my-meal-details', params: {planId: plan.planId}}" tag="div"> 
     <!-- <img v-if="recipe.image" v-bind:src="recipe.image" /> -->
     <div>
     <h2 class="plan-name">{{ plan.planName }}</h2>
    <p class="plan-description">{{ plan.dayOfWeek }}</p>
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
    border-radius: 10px;
    padding: 10px;
    width: 95%;
    height: 150px;
    margin: 20px;
    background: #5A1850;    /* display: flex; */
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