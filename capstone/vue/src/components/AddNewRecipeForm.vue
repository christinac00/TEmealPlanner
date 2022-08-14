<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="recipe-name">Recipe Name</label>
      <input type="text" name="recipe-name" v-model="recipe.name" />
    </div>
    <div class="field">
      <label for="Description">Description</label>
      <input type="text" name="description" v-model="recipe.description" />
    </div>

    <div class="field">
      <label for="instructions">Instructions</label>
      <input type="text" name="instructions" v-model="recipe.instructions" />
    </div>

    <div class="field">
      <label for="image">Image URL</label>
      <input type="text" name="image" v-bind:src="recipe.image"/>
    </div>

    <div class="actions">
      <button type="submit" v-on:click.prevent="saveRecipe">Save Recipe</button>
      <button
        class="btn btn-cancel"
        v-on:click.prevent="cancelForm"
        type="cancel"
      >
        Cancel
      </button>
    </div>
  </form>
</template>

<script>
import applicationServices from "../services/ApplicationServices";

export default {
  name: "add-recipe",
  data() {
    return {
      recipe: {
        recipeId: 0,
        name: "",
        image: "",
        description: "",
        instructions: "",
      },
    };
  },
  methods: {
    saveRecipe() {
      applicationServices
        .createRecipe(this.recipe).then((response) => {
          if (response.status === 201) {
            applicationServices
              .createUserRecipe(this.$route.params.userId, response.data.recipeId)
              .then((response) => {
                if (response.status === 201) {
                  this.recipe = {
                    recipeId: 0,
                    name: "",
                    image: "",
                    description: "",
                    instructions: "",
                  };
                  this.$router.push({name:'my-recipes', params:{id: this.$route.params.userId}});
                }
              });
          } else{
              applicationServices.updateRecipe(this.$route.params.userId, response.data.recipeId).then((response)=>{
                  if(response.status === 200){
                    this.recipe = {
                        recipeId: 0,
                        name: "",
                        image: "",
                        description: "",
                        instructions: "",
                  };
                      this.$router.push({name:'my-recipe-details', params: {recipeId: this.recipe.recipeId}})
                  }
              })

          }
        })
        .catch((error) => {
          console.error(error);
        });
    },
    cancelForm(){
        this.$router.push({name:'my-recipes', params:{id: this.$route.params.userId}})
    }


  },
};
</script>

<style>
</style>