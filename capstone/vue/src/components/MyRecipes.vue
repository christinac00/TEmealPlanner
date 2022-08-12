<template>
<div class="my-recipes">
<div class="loading" v-if="isLoading">
    <img src="../assets/ping_pong_loader.gif" />
    </div>
  
      <div class="recipe-header">
          <h1>My Recipe Library</h1>
      </div>
      <recipe-card v-for="recipe in myRecipes" v-bind:key="recipe.name"
      v-bind:recipe="recipe"
      />
      <!-- <div class="recipe-row"  v-for="recipe in myRecipes" v-bind:key="recipe.name" >
          <p> Recipes: {{ recipe.name }}</p>
          <p> Instructions: {{ recipe.instructions }}</p>
      </div> -->

  </div>
  
</template>

<script>
import RecipeCard from "@/components/RecipeCard.vue";
import applicationServices from "@/services/ApplicationServices";
export default {

name: "my-recipes",
components: { RecipeCard },
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
.my-recipes{
    width: 90%;
  margin: 50px auto;
  background: lightcoral;
}

.recipe-header{
     text-align: center;
  font-size: 20px;
  color: rgb(168, 64, 64);
  margin-bottom: 40px;
}
.recipe-row{
    display: flex;
  flex-direction: row;
  justify-content: flex-start;
  gap: 3px;
  flex-flow: wrap;
  margin-left: 40px;
}
.recipe-row #p{
    border-bottom: 10px, solid ;
}

</style>