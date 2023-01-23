<template>
  <div>
    <navbar>
      <div class="logo">Logo</div>
      <form>
        <input type="text" placeholder="Search products" />
      </form>
      <router-link to="/products">Products</router-link>
      <router-link to="/cart">Cart</router-link>
      <router-link to="/profile">Profile</router-link>
    </navbar>
    <!-- <div class="image-slider"> -->
    <!-- Image Slider -->
    <!-- </div> -->
    <!-- <div class="top-products"> -->
    <!-- <h2>Top Products</h2> -->
    <!-- Display top products here -->
    <!-- </div> -->
    <!-- <footer> -->
    <!-- Footer content -->
    <!-- </footer> -->
  </div>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {};
  },
  methods: {},
  mounted() {},
};
</script>

<style>
/* navbar{
    background-color:#294738;
    padding:23px;
    position: sticky;
    z-index: 999;
    top: -10px;
    color:whitesmoke;
    box-shadow: 0 -6px 10px 5px rgba(0,0,0,0.5);
} */
navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 23px;
  background-color: #294738;
  box-shadow: 0 -6px 10px 5px rgba(0, 0, 0, 0.5);
  position: sticky;
  z-index: 999;
  top: -10px;
  margin: 0%;
}
.logo {
  font-size: 30px;
  font-weight: bold;
}
.image-slider {
  width: 100%;
  height: 300px;
}
.top-products {
  padding: 20px;
}
</style>
