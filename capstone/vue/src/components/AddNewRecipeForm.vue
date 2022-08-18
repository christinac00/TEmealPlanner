<template>
  <form class="form" v-on:submit.prevent>
    
    <div class="field">
      <label for="recipe-name">Recipe Name</label>
      <input class="recipe-name" type="text" name="recipe-name" v-model="recipe.name" />
    </div>
    <div class="field">
      <label for="Description">Description</label>
      <textarea class="descriptionForm" v-model="recipe.description" ></textarea>
      <!-- <input class="descriptionForm" type="text" name="description" v-model="recipe.description" /> -->
    </div>

    <div class="field">
      <label for="instructions">Instructions</label>
      <textarea class="instructionsForm"  v-model="recipe.instructions"></textarea>
      <!-- <input  type="text" name="instructions" v-model="recipe.instructions" /> -->
    </div>

    <div class="field">
      <label for="image">Image URL</label>
      <input class="imgURL" type="text" name="image" v-model="recipe.image" />
    </div>

    <h2 class="addedit">Add/ Edit Ingredients</h2>
    
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

    <div class="actions">
      <button class="btn" v-on:click.prevent="addIngredient" >
        Add Ingredient
      </button>
      <button class="btn" v-on:click="deleteIngredient">
        Delete Ingredient 
      </button>
    </div>

    <div>
      
      <label>Ingredients</label>
      <table>
        <tr>
          <td class="td-headers">Amount </td>
          <td class="td-headers">Units </td>
          <td class="td-headers">Name </td>
          
        </tr>
        <tr class="col-name" v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.id">
          <td class="c1">
            {{ ingredient.quantity }}
          </td>
          <td class="c2">
            {{ ingredient.unit }}
          </td>
          <td class="c3">
            {{ ingredient.name }}
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
        ingredients: []
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
                    ingredients: []
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
                      userId: this.$route.params.userId,
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
      this.recipe.ingredients = this.recipe.ingredients.filter((ingredient)=>{
        return ingredient.name.toLowerCase() !== this.ingredient.name.toLowerCase()
      })
        this.ingredient = {
          quantity:"",
          unit:"",
          name:""
        }
      
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
.addedit{
  margin-top: 30px;
}
label{
  font-family: 'Quicksand', sans-serif;
  font-weight: 600;
  margin-right: 10px;
  margin-bottom: 5px;
  margin-top: 5px;
  display: block;
}

button{
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
  margin-right: 10px;
}

td{
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
  padding: 5px;
  text-align: center;
  
}
form{
  display: flex;
  flex-direction: column;
  margin: 15px;
  
}

table{
  border-collapse: collapse;
  margin-bottom: 50px;
}
.descriptionForm {
  height: 50px;
  width: 100%;
}
.instructionsForm{
  height: 200px;
  width: 100%;
}
.btn{
  margin-bottom: 20px;
}
.imgURL{
  width: 75%;
  height: 20px;
}
input.recipe-name{
  width: 30%;
  height: 20px;
}
.td-headers{
  font-weight: 600;
  background-color: mediumslateblue;
}
.col-name:nth-child(odd){
  background-color:floralwhite
}
input, textarea{
  background-color:floralwhite;
}

</style>