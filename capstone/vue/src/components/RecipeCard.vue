<template>
  <div>
    <router-link
      class="rcard"
      :to="{
        name: 'my-recipe-details',
        params: { recipeId: recipe.recipeId },
        query: { userId: userId },
      }"
      tag="div"
    >
      <img if="recipe.image" v-bind:src="recipe.image" />
      <div class="rinfo">
        <h2 class="recipe-name">{{ recipe.name }}</h2>
        <p class="recipe-description">{{ recipe.description }}</p>
      </div>
    </router-link>
    <button
      type="submit"
      v-if="Object.keys($store.state.user).length !== 0 && !userId && !noButton"
      v-on:click="saveRecipeToMyRecipes()"
    >
      Save Recipe
    </button>
  </div>
</template>

<script>
import RecipeService from "@/services/RecipeService";
export default {
  name: "recipe-card",
  props: {
    recipe: Object,
    userId: Number,
    noButton: Boolean,
  },
  methods: {
    saveRecipeToMyRecipes() {
      RecipeService.createUserRecipe(
        this.$store.state.user.id,
        this.recipe.recipeId
      ).then((response) => {
        if (response.status == 201) {
          this.$router.push({
            name: "my-recipes",
            params: { id: this.$store.state.user.id},
          });
        }
      });
    },
  },
};
</script>

<style>
/* importation of all fonts */
@import url("https://fonts.googleapis.com/css2?family=Hind:wght@300;400&family=Holtwood+One+SC&family=Quicksand:wght@300;400;500&display=swap");

.rcard {
  display: flex;
  flex-direction: row;
  width: 90%;
  height: 175px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  background: #f49494;
  align-items: center;
  border-radius: 10px;
  filter: drop-shadow(7px 6px 8px rgba(0, 0, 0, 0.25));
}

.rcard > img {
  border-radius: 10px;
  height: 100%;
  width: auto;
  padding: 0 10px 0 0;
  margin-right: auto;
}
.rcard .recipe-name {
  font-size: 1.25rem;
  text-align: center;
  font-family: "Holtwood One SC", serif; 
  display: block;
  height: 50px;
}

.rcard .recipe-description {
  font-size: 1rem;
  font-family: "Quicksand", sans-serif;
  font-weight: 500;
  text-align: center;
  display: block;
  height: 100px;
}

button {
  margin-top: 5px;
  margin-left: 54px;
}

.rcard:hover {
   background: #f39b37;
}
</style>