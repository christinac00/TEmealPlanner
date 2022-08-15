<template v-for="recipe in recipes" :key="recipe.name">
    <div class="search" >
        <div class="loading" v-if="isLoading">
            <img src="../assets/your-food-is-being-prepared.gif" />
        </div>
        <div class="recipe-header">
            <input class="search-bar" type="text" placeholder="Search Recipes">

        </div>
        

    </div>
</template>