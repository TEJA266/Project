<template>
  <!-- <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view />
  </div> -->
  <div id="app">
    <router-link to="/login">Login</router-link>
    <router-link to="/register">Register</router-link>
    <router-link to="/secret">Secret</router-link>
    <NavBar />
    <router-view />
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
  components: {
    NavBar,
  },
  data() {
    return {};
  },
};
</script>

<style>
#app {
  font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", "Geneva", "Verdana", "sans-serif";
  /* -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50; */
}
body {
  background-color: rgba(240, 255, 240, 0.315);
}
nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  /* color: #2c3e50; */
  text-decoration: none;
}

/* nav a.router-link-exact-active {
  color: #42b983;
  text-decoration: none;
} */
</style>
