<template>
  <div class="home">
    <div class="navbar">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; 
    <router-link id="login-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
    <router-link id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
       <nav class="left-panel">
      <ul class="nav-links">
        <li><router-link id="browse-my-recipes" v-bind:to="{ name: 'my-recipes', params: {id: $store.state.user.id}  }">My Recipes</router-link></li>
        <li><router-link id="browse-saved" v-bind:to="{ name: 'saved' }">Saved Recipes</router-link></li>
        <li><router-link id="browse-shared" v-bind:to="{ name: 'shared' }">Shared Recipes</router-link></li>
        <li><router-link id="meal-plans" v-bind:to="{ name: 'meals' }">My Meal Plans</router-link></li>
        <li><router-link id="ingredients" v-bind:to="{ name: 'ingredients' }">Ingredients</router-link></li>
        <li><router-link id="shopping-list" v-bind:to="{ name: 'shopping-list' }">Shopping List</router-link></li>
      </ul>
    </nav>
      
      
   
    <header>THE TE MEAL PLANNER</header>
    <div class="recipes">Recent Recipes
      <p>Here are some recipes you've recently viewed or added to your Meal Plan</p>
    </div>
    <div class="recipes">Recommended Recipes
      <p>Give some of these recipes a try! </p>
    </div>
    <div class="recipes">Popular Recipes
      <p>Expand your horizons by checking out these Meal Planner favorites!</p>
    </div>

    <footer>
      <ul class="social-icons">
        <li><a href="#"><i class="fab fa-facebook fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-instagram fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-twitter fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-pinterest fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-behance fa-3x"></i></a></li>
      </ul>
    </footer> 
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

