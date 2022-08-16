<template>
  <router-link
    class="rcard"
    :to="{
      name: 'my-recipe-details',
      params: { recipeId: recipe.recipeId },
      query: { userId: userId },
    }"
    tag="div"
  >
    <img v-if="recipe.image" v-bind:src="recipe.image" />
    <div class="rinfo">
      <h2 class="recipe-name">{{ recipe.name }}</h2>
      <p class="recipe-description">{{ recipe.description }}</p>
    </div>
  </router-link>
</template>

<script>
export default {
  name: "recipe-card",
  props: {
    recipe: Object,
    userId: Number,
  },
  methods: {},
};
</script>

<style>
/* importation of all fonts */
@import url('https://fonts.googleapis.com/css2?family=Hind:wght@300;400&family=Holtwood+One+SC&family=Quicksand:wght@300;400;500&display=swap');

.rcard {
  display: flex;
  flex-direction: row;
  width: 95%;
  height: 150px;
  margin: 20px;
  background: #F49494;
  align-items: center;
  border-radius: 10px;
  filter: drop-shadow(7px 6px 8px rgba(0, 0, 0, 0.25));
}

.rinfo {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-grow: 1;
}
.rcard > img {
  border-radius: 10px;
  height: 100%;
  padding: 0 10px 0 0;
  margin-right: auto;
}
.rcard .recipe-name {
  font-size: 1.5rem;
  text-align: center;
  font-family: 'Holtwood One SC', serif;
  flex-shrink: 1;
}

.rcard .recipe-description {
  font-size: 1rem;
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
  flex-shrink: 1;
  text-align: center;
}




</style>