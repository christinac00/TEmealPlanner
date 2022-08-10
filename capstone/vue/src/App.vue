<template>
  <div id="app">
    <div class="navbar">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; 
    <router-link id="login-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
    <router-link id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
       <nav class="nav">
      <ul class="nav-links">
        <li><router-link id="browse-my-recipes" v-bind:to="{ name: 'my-recipes' }">My Recipes</router-link></li>
        <li><router-link id="browse-saved" v-bind:to="{ name: 'saved' }">Saved Recipes</router-link></li>
        <li><router-link id="browse-shared" v-bind:to="{ name: 'shared' }">Shared Recipes</router-link></li>
        <li><router-link id="meal-plans" v-bind:to="{ name: 'meals' }">My Meal Plans</router-link></li>
        <li><router-link id="ingredients" v-bind:to="{ name: 'ingredients' }">Ingredients</router-link></li>
        <li><router-link id="shopping-list" v-bind:to="{ name: 'shopping-list' }">Shopping List</router-link></li>
      </ul>
    </nav>
      
      
   
    <header>THE TE MEAL PLANNER</header>
    <div class="recipes">Recent Recipes</div>
    <div class="recipes">Flashback Recipes</div>
    <div class="recipes">Popular Recipes</div>

    <footer>
      <ul class="social-icons">
        <li><a href="#"><i class="fab fa-facebook fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-instagram fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-twitter fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-pinterest fa-3x"></i></a></li>
        <li><a href="#"><i class="fab fa-behance fa-3x"></i></a></li>
      </ul>
    </footer>
    <router-view />
  </div>
</template>


<script>
export default {
  name: "home"
};
</script>
<style>

nav {
position: absolute;
width: 448px;
height: 1029px;
left: 0px;
top: 0px;
 
background: #7e2d73;
}
.navbar {
  position: absolute;
width: 548px;
height: 80px;
right: 0px;
top: 0px;
text-align: center;
 
background:#2c5e97;
}
ul {
  align-items: right;
}
header {
position: absolute;
width: 992px;
height: 240px;
left: 448px;
top: 0px;
text-align: center;
 
background: #FFE473;
}
.recent-recipes{
  position: absolute;
width: 814px;
height: 198px;
left: 537px;
top: 321px;
}
.flashback-recipes{
  position: absolute;
width: 814px;
height: 199px;
left: 537px;
top: 555px;
}
.popular-recipes{
  position: absolute;
width: 814px;
height: 198px;
left: 537px;
top: 791px;
}
.recipes{
  padding: 40px 55px;
  margin: 15px 0;
  background-color: #00AFEF;
  color: #fff;
  border: solid 1px #777;

}
.social-icons {
  display: flex;
  justify-content: space-between;
  list-style-type: none;
  margin: 20px 20px;
  padding: 0;
}
</style>




