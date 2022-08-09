<template>
  <div id="app">
    <nav>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </nav>
    <header>THE TE MEAL PLANNER</header>
    <div class="recent-recipes">Recent Recipes</div>
    <div class="flashback-recipes">Flashback Recipes</div>
    <div class="popular-recipes">Popular Recipes</div>
    <router-view />
  </div>
</template>
<style>
nav {
position: absolute;
width: 448px;
height: 1029px;
left: 0px;
top: 0px;

background: #429698;
}
header {
position: absolute;
width: 992px;
height: 240px;
left: 448px;
top: 0px;

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
</style>