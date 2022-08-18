<template>
  <div class="meal-plans">
    <div class="loading" v-if="isLoading">
      <img src="../assets/your-food-is-being-prepared.gif" />
    </div>
    <div class="planner-header">
      <h1>My Meal Plans</h1>
    </div>
    <router-link
      tag="button"
      class="btn addPlan"
      :to="{ name: 'add-plan', params: { userId: $route.params.id } }"
      v-if="!isLoading"
      >Add New Meal Plan</router-link
    >

    <meal-card
      v-for="plan in myMealPlans"
      v-bind:key="plan.name"
      v-bind:plan="plan"
    />
  </div>
</template>

<script>
import MealService from "@/services/MealService";
// import AddPlan from "@/components/AddPlan.vue"
import MealCard from "@/components/MealCard.vue";
export default {
  name: "my-meal-plans",
  components: { MealCard },
  data() {
    return {
      myMealPlans: [],
      isLoading: true,
    };
  },
  created() {
    this.retrieveMyMealPlans();
  },

  methods: {
    retrieveMyMealPlans() {
      MealService.getAllMealPlans(this.$route.params.id).then((response) => {
        this.myMealPlans = response.data;
        this.isLoading = false;
      });
    }
  },
};
</script>

<style>
.meal-plans {
  width: 90%;
  margin-left: auto;
  margin-right: auto;
  background: #f39b37;
  border-radius: 10px;
}

.planner-header {
  text-align: center;
  font-size: 20px;
  color: #256d6e;
}

.recipe-row {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  gap: 3px;
  flex-flow: wrap;
  margin-left: 40px;
}

.recipe-row #p {
  border-bottom: 10px, solid;
}

.btn
</style>