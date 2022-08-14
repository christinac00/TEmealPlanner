import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import MyRecipes from '../views/MyRecipes.vue'
import AllRecipes from '../views/AllRecipes.vue'
 import MyRecipeDetails from '../views/MyRecipeDetails.vue'
 import MealPlan from '../views/MealPlan.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/saved-recipes",
      name: "saved-recipes",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/shared-recipes",
      name: "shared-recipes",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/users/:id/meal-plans",
      name: "my-meal-plans",
      component: MealPlan ,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/ingredients",
      name: "ingredients",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/shopping-list",
      name: "shopping-list",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/recent",
      name: "recent",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/flashback",
      name: "flashback",
      component: Register,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/popular",
      name: "popular",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/search",
      name: "search",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/users/:id/recipes",
      name: "my-recipes",
      component: MyRecipes
    },

     {
       path: "/recipes",
       name: "all-recipes",
       component: AllRecipes
     },
      {path: "/recipes/:recipeId",
       name: "my-recipe-details",
      component: MyRecipeDetails
     },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
