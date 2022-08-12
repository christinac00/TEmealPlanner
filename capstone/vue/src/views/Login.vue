<template>
  <div id="login" class="text-center container">
    <div id="login" class="text-center login">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div class="alert alert-danger" 
        role="alert" 
        v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username: </label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <br />
        <br />
        <label for="password" class="sr-only">Password: </label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <router-link :to="{ name: 'register' }"> Need an account? </router-link>
        <button type="submit">Sign in</button>
      </form>
    </div>
    <footer>
      The TE Meal Planner 
    </footer>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style>
.text-center {
  position: absolute;
  width: 600px;
  height: 200px;
  right: 0px;
  top: 0px;
  text-align: center;

  background: #9c425d;
}

.container {
  display: grid;
  grid-template-rows: 40px calc(100vh - 80px) 40px;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "space space space"
    "space login space"
    "space space space";
}

.login{
  grid-area: login;
}

#login{
  background: #429698;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}

</style>