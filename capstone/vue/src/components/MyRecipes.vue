<template>
  <div class="my-recipes">
      <div class="recipe-header">
          <h1>My Recipe Library</h1>
      </div>
      <div class="recipe-row">
          <div v-bind="getMyRecipes()" />
      </div>
  </div>
</template>

<script>
import ApplicationServices from "@/services/ApplicationServices";
export default {

name: "my-recipes",
data() {
    return {
        myRecipes: "",
        getMyRecipes() {
            ApplicationServices.getMyRecipes().then(response => {
                this.myRecipes = response.data
            })
        }
    }

},
};
</script>

<style>

</style>