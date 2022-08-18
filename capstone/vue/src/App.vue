<template>
  <div id="app">
    <header>
      <h1>
        The Te Meal Planner
      </h1>
      <input class="search-bar" type="text" placeholder="Search by Ingredient" v-model="searchTerm"> 
      <input class="search-bar" type="text" placeholder="Search by Tag" v-model="searchTag"> 
    </header>
    <nav class="left-panel">
     
      <div class="login" v-if="Object.keys($store.state.user).length === 0">
        <router-link v-bind:to="{ name: 'login' }">Login</router-link>
      </div>
      <div class="login" v-else> 
        <img id="logo" src="@/assets/TEMP-Logo-2.png" alt="">
        <router-link id="logout-setting" v-bind:to="{ name: 'logout' }">Logout</router-link>
        <section id="greeting">Hello, {{ $store.state.user.username }}!</section>
        <hr/>
      </div> 
      
      <div class="nav-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link id="browse-my-recipes" v-bind:to="{ name: 'my-recipes', params: {id: $store.state.user.id}  }">My Recipes</router-link>
        <!-- <router-link id="browse-saved" v-bind:to="{ name: 'saved' }">Saved Recipes</router-link> -->
        <!-- <router-link id="browse-shared" v-bind:to="{ name: 'shared' }">Shared Recipes</router-link> -->
        <router-link id="meal-plans" v-bind:to="{ name: 'my-meal-plans', params: {id: $store.state.user.id} }">My Meal Plans</router-link>
        <router-link id="shopping-list" v-bind:to="{ name: 'shopping-list' }">Shopping List</router-link>
      </div>
    </nav>
    <main>
    <router-view class="view" v-bind:search="searchTerm" v-bind:searchTag="searchTag"/>  
    </main>
  </div>
</template>


<script>
export default {
  name: "home",
  data () {
    return{
      searchTerm: '',
      searchTag: '',
    }
  }
};
</script>

<style>
/* importation of all fonts */
@import url('https://fonts.googleapis.com/css2?family=Hind:wght@300;400&family=Holtwood+One+SC&family=Quicksand:wght@300;400;500&display=swap');

/* organizes the homepage */
#app{
  display: grid;
  width: 100vw;
  height: 100vh;
  grid-template-areas: 
    "nav head"
    "nav main"
    "nav main";
  grid-template-rows: 1fr 4fr 30px;
  grid-template-columns: 1fr 5fr;
}

/* styling for header */
header {
flex-direction: column;
text-align: center;
grid-area: head;
background: #FCD949;
box-shadow: 0px 6px 9px rgba(0, 0, 0, 0.25); 
}

header > h1 {
   color: #5A1850;
}

h1 {
  font-family: 'Holtwood One SC', serif;
}

/* styling for navigation bar */
nav {
  display: flex;
  flex-direction: column;
  grid-area: nav;
  background: #429698;
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;
}

#logo {
  width: 220px;
  margin-left: auto;
  margin-right: auto;
}

#logout-setting {
  text-align: center;
  color: #9BC3FF;
}

#greeting {
  color: azure;
}

/* styling for divider */
hr {
  width: 20vw;
  border: 2px solid #FFE473;
}

/* styling for login */
.login {
  display: flex;
  flex-basis: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: flex-end;
  font-size: 200%;
}

/* styling for nav links */
.nav-links {
  display: flex;
  flex-basis: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  font-family: 'Holtwood One SC', serif;
  font-size: 1.25vw;
}

main {
  grid-area: main;
   overflow: auto;
}

footer {
  grid-area: foot;
  background: #fcd949;
}
button {
  color: white;
  text-decoration: none;
  font-family: Helvetica, Arial, sans-serif;
  font-size: 14px;
  text-align: center;
  padding: 0 30px;
  line-height: 30px;
  display: inline-block;
  position: relative;
  border-radius: 20px;
  background-image: linear-gradient(#335b71 45%, #03324c 55%);
  box-shadow: 0 2px 2px #888888;
  transition: color 0.3s, background-image 0.5s, ease-in-out;
}
button:hover {
  background-image: linear-gradient(#b1ccda 49%, #96b4c5 51%);
  color: #03324c;
}

/* 
header styling
background: #FCD949;
box-shadow: 0px 6px 9px rgba(0, 0, 0, 0.25); 

nav styling
background: #429698;

recent recipes styling
background: #F49494;
filter: drop-shadow(7px 6px 8px rgba(0, 0, 0, 0.25));

flashback recipes styling
background: #4C635F;
filter: drop-shadow(7px 6px 8px rgba(0, 0, 0, 0.25));

popular recipes styling
background: #5A1850;

divider styling
border: 3px solid #FFE473;
*/

</style>




