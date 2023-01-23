<!-- <template> -->
<!-- <div id="app"> -->
<!-- <p>E-Commerce</p> -->
<!-- <nav-bar></nav-bar> -->
<!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav> -->
<!-- <router-view /> -->
<!-- </div> -->
<!-- </template> -->

<!-- <script>
import NavBar from "./components/NavBar.vue";
export default {
  components: {
    NavBar,
  },
  data() {},
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style> -->

<template>
  <div>
    <NavBar :cartCount="cartCount" @resetCartCount="resetCartCount" />
    <router-view
      v-if="categories && products"
      style="min-height: 60vh"
      :baseURL="baseURL"
      :categories="categories"
      :products="products"
      :rproducts="rproducts"
      :oproducts="oproducts"
      @fetchData="fetchData"
    >
    </router-view>
    <!--  footer-->
    <FooterComponent />
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import FooterComponent from "./components/FooterComponent.vue";
import axios from "axios";
export default {
  components: { NavBar, FooterComponent },
  data() {
    return {
      baseURL: "http://10.177.1.120:9000/",
      products: null,
      rproducts: null, //td
      categories: null,
      cartCount: 0,
      oproducts: null,
    };
  },
  methods: {
    async fetchData() {
      //
      // api call to get all the categories
      await axios
        .get(this.baseURL + "category/all")
        .then((res) => {
          this.categories = res.data;
        })
        .catch((err) => console.log("Category err", err));

      // api call to get the products

      await axios
        .get(this.baseURL + "product/all")
        .then((res) => {
          this.products = res.data;
        })
        .catch((err) => console.log("Product err", err));

      //api call to get all recommended products
      await axios
        .get(this.baseURL + "product/recommended")
        .then((res) => {
          this.rproducts = res.data;
        })
        .catch((err) => console.log("Product R err", err));

      //api call to get all Ordered products
      if (localStorage.getItem("userId")) {
        await axios
          .get(this.baseURL + `order/user/${localStorage.getItem("userId")}`)
          .then((res) => {
            this.oproducts = res.data;
          })
          .catch((err) => console.log("err", err));
      }

      // fetch cart item if token is present i.e logged in
      if (this.token) {
        axios
          .get(`${this.baseURL}cart/${this.user}`)
          .then((res) => {
            const result = res.data;
            this.cartCount = result.length;
          })
          .catch((err) => console.log("err", err));
      }
    },
    resetCartCount() {
      this.cartCount = 0;
    },
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.user = localStorage.getItem("userId");
    this.fetchData();
  },
};
</script>

<style>
html {
  overflow-y: scroll;
}
</style>
