<template>
  <all-recipes v-bind:search="search" v-bind:searchTag="searchTag"/>


</template>

<script>

import AllRecipes  from '../components/AllRecipes.vue'
export default {
  components: { AllRecipes },
  props: ['search', 'searchTag'], 
}
</script>

<style>

</style>