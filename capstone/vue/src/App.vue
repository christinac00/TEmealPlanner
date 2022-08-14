<template>
  <div id="app">
    <header>
      <h1>
        The Te Meal Planner
      </h1>
    </header>
    <nav class="left-panel">
      <div class="login" v-if="Object.keys($store.state.user).length === 0">
        <router-link v-bind:to="{ name: 'login' }">Login</router-link>
      </div>
      <div class="login" v-else>
        <router-link v-bind:to="{ name: 'logout' }">Logout</router-link>
        Hello, {{ $store.state.user.username }}!
      </div> 
      <hr/>
      <div class="nav-links">
        <router-link id="home" v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link id="browse-my-recipes" v-bind:to="{ name: 'my-recipes', params: {id: $store.state.user.id}  }">My Recipes</router-link>
        <!-- <router-link id="browse-saved" v-bind:to="{ name: 'saved' }">Saved Recipes</router-link> -->
        <!-- <router-link id="browse-shared" v-bind:to="{ name: 'shared' }">Shared Recipes</router-link> -->
        <router-link id="meal-plans" v-bind:to="{ name: 'my-meal-plans' }">My Meal Plans</router-link>
        <router-link id="ingredients" v-bind:to="{ name: 'ingredients' }">Ingredients</router-link>
        <router-link id="shopping-list" v-bind:to="{ name: 'shopping-list' }">Shopping List</router-link>
      </div>
    </nav>
    <main>
    <router-view class="view"/>  
    </main>
    <footer>

    </footer>
  </div>
</template>


<script>
export default {
  name: "home"
};
</script>
<style>
#app{
  display: grid;
  width: 100vw;
  height: 100vh;
  grid-template-areas: 
    "nav head"
    "nav main"
    "foot foot";
  grid-template-rows: 150px 1fr 30px;
  grid-template-columns: 1fr 4fr;

}
#app > header {
display: flex;
flex-direction: column;
align-items: center;
grid-area: head;
background: #fcd949;
}

#app > nav {
  display: flex;
  flex-basis: 100%;
  flex-direction: column;

  grid-area: nav;
  background: #429698;
}

nav > hr {
  width: 100%;
}

.login {
  display: flex;
  flex-basis: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.nav-links {
  display: flex;
  flex-basis: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#app > main {
  grid-area: main;
   overflow: auto;
}

#app > footer {
  grid-area: foot;
  background: #fcd949;
}

</style>




