<template>
  <div>
      <h1>Edit Recipe</h1>
      <add-new-recipe-form :recipeId="parseInt($route.params.recipeId)"></add-new-recipe-form>
  </div>
</template>

<script>

import AddNewRecipeForm from "@/components/AddNewRecipeForm";
export default {
    components:{
        AddNewRecipeForm
    }
}
</script>

<style>

</style>