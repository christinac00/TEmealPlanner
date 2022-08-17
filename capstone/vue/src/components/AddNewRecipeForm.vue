<template>
  <form v-on:submit.prevent>
    <h1>{{ $route.params.userId }} {{ $route.params.recipeId }}</h1>
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
      <input type="text" name="image" v-bind:src="recipe.image" />
    </div>

    <div class="actions">
      <button class="btn addIngredient" v-on:click.prevent="addIngredient" >
        Add Ingredient
      </button>
      <button class="btn deleteIngredient" v-on:click="deleteIngredient">
        Delete Selected Ingredient(s)
      </button>
    </div>
    <form >
      <div class="field">
        <label for="ingredient-amount">Amount</label>
        <input type="text" name="ingredient-amount" v-model="ingredient.quantity" />
      </div>
      <div class="field">
        <label for="ingredient-unit">Units</label>
        <input type="text" name="ingredient-unit" v-model="ingredient.unit" />
      </div>
      <div class="field">
        <label for="ingredient-name">Ingredient Name</label>
        <input type="text" name="ingredient-name" v-model="ingredient.name" />
      </div>
    </form>

    <div>
      <table>
        <tr>
          <td>Amount </td>
          <td>Units </td>
          <td>Name </td>
          <td>Delete? </td>
        </tr>
        <tr v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.id">
          <td>
            {{ ingredient.quantity }}
          </td>
          <td>
            {{ ingredient.unit }}
          </td>
          <td>
            {{ ingredient.name }}
          </td>
          <td>
            <input type="checkbox" />
          </td>
        </tr>
      </table>
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
import recipeService from "../services/RecipeService";

export default {
  name: "add-recipe",
  data() 
  
  {
    return {
      isHidden: true,
      recipe: {
        recipeId: 0,
        name: "",
        image: "",
        description: "",
        instructions: "",
      },
      ingredient:{
        quantity:"",
        unit:"",
        name:""
      }
    };
    
  },
  created() {
    this.retrieveDetails();
  },
  methods: {
    retrieveDetails() {
      recipeService.getDetails(this.$route.params.recipeId).then((response) => {
        this.recipe = response.data;
        this.isLoading = false;
      });
    },

    saveRecipe() {
      if(!this.$route.params.recipeId){
        recipeService
        .createRecipe(this.recipe)
        .then((response) => {
          if (response.status === 201) {
            recipeService
              .createUserRecipe(
                this.$route.params.userId,
                response.data.recipeId
              )
              .then((response) => {
                if (response.status === 201) {
                  this.recipe = {
                    recipeId: 0,
                    name: "",
                    image: "",
                    description: "",
                    instructions: "",
                  };
                  this.$router.push({
                    name: "my-recipes",
                    params: { id: this.$route.params.userId },
                  });
                }
              });
          }
        })
        .catch((error) => {
          console.error(error);
        });

      }else{

        recipeService
              .updateRecipe(this.recipe)
              .then((response) => {
                if (response.status === 200) {
                  this.$router.push({
                    name: "my-recipe-details",
                    params: {
                      recipeId: this.$route.params.recipeId,
                    },
                    query: {
                      userId: this.$route.query.userId,
                    }
                  });
                }
              });
          
      }
      
    },
    cancelForm() {
      this.$router.push({
        name: "my-recipes",
        params: { id: this.$route.params.userId },
      });
    },
    deleteIngredient(){
      recipeService.deleteIngredient(this.recipe.id).then((response)=>{

        if(response.staus ===200){
          alert("Ingredient removed from recipe");
          this.$router.push({
                    name: "my-recipe-details",
                    params: {
                      recipeId: this.$route.params.recipeId,
                    },
                    query: {
                      userId: this.$route.query.userId,
                    }
                  });
        }
      })
      
    },
    addIngredient(){
        this.recipe.ingredients.push(this.ingredient)
        this.ingredient = {
          quantity:"",
          unit:"",
          name:""
        }
    }
  },
};
</script>

<style>

label{
  font-family: 'Quicksand', sans-serif;
  font-weight: 600;
  margin-right: 10px;
}

button{
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
  margin-right: 10px;
}

td{
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
  
}
form{
  display: flex;
  flex-direction: column;
  margin: 20px;

}
table{
  border-collapse: collapse;
  margin-bottom: 50px;
}


</style>