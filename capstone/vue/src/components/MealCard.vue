<template>
  <router-link
    class="card"
    :to="{ name: 'my-meal-details', params: { planId: plan.planId } }"
    tag="div"
  >
    <!-- <img v-if="recipe.image" v-bind:src="recipe.image" /> -->
    <div class="meals-card">
      <h2 class="plan-name">{{ plan.planName }}</h2>
      <p class="plan-description">{{ plan.dayOfWeek }}</p>
      <div class="plan-card">
        <recipe-card
         v-bind:noButton="true"
          v-for="recipe in planRecipes"
          v-bind:key="recipe.name"
          v-bind:recipe="recipe"
        />
      </div>
    </div>
  </router-link>
</template>

<script>
import RecipeCard from "@/components/RecipeCard";
import RecipeService from "@/services/RecipeService";
export default {
  data() {
    return {
      planRecipes: [],
    };
  },
  name: "meal-card",
  props: {
    plan: Object,
  },
  methods: {},
  components: { RecipeCard },
  created() {
    RecipeService.getFilteredRecipes().then((response) => {
        const shuffled = response.data.sort(() => {
            0.5 - Math.random()
        })
    this.planRecipes = shuffled.slice(0,3);
    });
  },
};
</script>

<style>
.card {
  border-radius: 10px;
  padding: 10px;
  width: 95%;
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  background: #429698; /* display: flex; */
  filter: drop-shadow(10px 10px 10px rgba(0, 0, 0, 0.25));
}

.card > img {
  position: relative;
  right: -38%;
  width: 100px;
  border-radius: 60px;
}

.card .recipe-name {
  font-size: 1rem;
}

.card .recipe-description {
  font-size: 1rem;
}

.meals-card {
  display: grid;
  grid-template-areas:
    "title description"
    "recipe recipe";
}

.plan-card {
  grid-area: recipe;
  display: flex;
  flex-direction: column;
  width: 105%;
}

.plan-name {
  grid-area: title;
  text-align: center;
}

.plan-description {
  grid-area: description;
  font-family: 'Holtwood One SC', serif;
  color: #fff;
  font-size: 1.5rem;
}

</style>