<template>
  <all-recipes v-bind:search="search"/>


</template>

<script>

import AllRecipes  from '../components/AllRecipes.vue'
export default {
  components: { AllRecipes },
  props: ['search'],
}
</script>

<style>

</style>