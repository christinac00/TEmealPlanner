<template>
  <div class="recipe-details-body">
      <div class="loading" v-if="isLoading">
    <img src="../assets/ping_pong_loader.gif" />
    </div>
<div class="recipe-details-card">
    <h1 class="recipe-name">{{ recipe.name }}</h1>
</div>
<div>
    <h2 class="instructions">instructions</h2>
    <h3>{{ recipe.instructions }}</h3>
</div>
<div>
    <h2>Ingredients</h2>
</div>
  </div>
</template>

<script>
import applicationServices from '../services/ApplicationServices';
export default {
    name: "my-recipes-card",
    data () {
        return {
            getDetails: "",
            isLoading: true,
        }
    },
    created() {
        this.retrieveDetails()
    },
    methods: {
    retrieveDetails() {
        applicationServices.getDetails(this.$route.params.recipeId).then(response =>{
            this.getDetails = response.data
            this.isLoading = false;
        })
    }
    }

}
</script>

<style>
.recipe-details-body {
      display: flex;
  flex-direction: column;
  border: 4px solid #FA6900;
  background-color: #FFF2E6;
  justify-content: center; 
  width: 25%;
  margin: 0 auto 0 auto;
  font-family: 'Barlow Condensed', sans-serif;
  font-weight: bold;
  margin-bottom: 20px;
  padding-bottom: 20px;
}
.recipe-details-card {
    display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 0px;
}

</style>