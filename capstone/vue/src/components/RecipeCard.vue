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
.rcard {
  display: flex;
  flex-direction: row;
  width: 95%;
  height: 150px;
  margin: 20px;
  background: lightcoral;
  align-items: center;
  border-radius: 10px;
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
}

.rcard .recipe-description {
  font-size: 1rem;
}
</style>