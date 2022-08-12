<template>
<div class="my-recipes">
<div class="loading" v-if="isLoading">
    <img src="../assets/ping_pong_loader.gif" />
    </div>
  
      <div class="recipe-header">
          <h1>My Recipe Library</h1>
      </div>
      <div class="recipe-row"  v-for="recipe in myRecipes" v-bind:key="recipe.name" >
          <p> {{ recipe.recipeId }}</p>
          <p> {{ recipe.name }}</p>
          <p> {{ recipe.instructions }}</p>
      </div>
  </div>
  
</template>

<script>
import applicationServices from "@/services/ApplicationServices";
export default {

name: "my-recipes",
data() {
    return {
        myRecipes: [],
      isLoading: true,
    }

},  
created() {
    this.retrieveMyRecipes();
},

methods:{ 
    retrieveMyRecipes() {
        
            applicationServices.getMyRecipes(this.$route.params.id).then(response => {
                this.myRecipes = response.data
                this.isLoading = false;
            })
        }
        }
};
</script>

<style>
.recipe-family-container {
  width: 90%;
  margin: 50px auto;
}
.recipe-header {
  text-align: center;
  font-size: 20px;
  color: rgb(148, 30, 30);
  margin-bottom: 40px;
}
.recipe-row {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  gap: 3px;
  flex-flow: wrap;
  margin-left: 40px;
}
.my-recipe-card {
  width: 20%;
  margin: 50px 10px;
  transition: 0.3;
  padding: 30px 20px;
  box-shadow: 0 0 20px 0 rgba(240, 25, 25, 0.2), 0 5px 5px 0 rgba(0,0,0,0.24);
  border-radius: 10px;
}
.recipe-header {
  text-align: center;
  padding: 50px 10px;
  
}
.recipe-button {
  display: block;
  text-align: center;
  outline: 0;
  text-transform: uppercase;
  font-weight: bold;
  outline: 0;
  border-radius: 5px;
  background: purple;
  border: 0;
  padding: 10px;
  color: #fff;
  font-size: 13px;
  margin-bottom: 10px;
  text-decoration: none;
}
.recipe-button:hover {
  background-color: gray;
  transition: all 1s ease 0s;
}

</style>