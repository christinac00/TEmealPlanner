<template>
  <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="title">HELLO!</h1>
        <img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
        <div 
        class="alert alert-danger" 
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
        <div id="form">
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
        
        <label for="password" class="sr-only">Password: </label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <h2>New Here?</h2>
        <router-link :to="{ name: 'register' }"> Create a new account </router-link>
        <button type="submit">Sign in</button>
      </div>
      </form>
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

#form {
  display: flex;
  flex-direction: column;
  margin: 10px;
}

#login{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
  background:  #429698;
  border-radius: 10px;
}

#login h1 {
  text-align: center;
  padding: 0 0 20px 0;
  color: cornsilk;
  font-family:sans-serif;
}

#login img {
 position:relative;
 right: -38%;
  width: 100px;
  border-radius: 60px;
}

.form-signin {
   border: black 3px solid;
  padding: 10px;
  border-radius: 10px;
}

label{
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif ;
  font-weight: lighter;
}

</style>