<template>
  <div class="container">
    <div v-for="product in getProductsList" :key="product.id" class="inner">
      <div @click="selectProducts(product)">
        <img :src="product.imgSrc" />
        <h2>{{ product.name }}</h2>
        <p>{{ product.description }}</p>
        <p>{{ product.price }}</p>
      </div>
      <button class="button">Add to cart </button>
      <button class="button">Buynow</button>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ProductsListing",
  emits: ["product-selected"],
  computed: {
    ...mapGetters(["getProductsList"]),
  },
  methods: {
    ...mapActions(["getProductsListApi"]),
    selectProducts(product) {
      console.log("from product listing", product);
      this.$emit("product-selected", product, "data");
    },
  },
  created: function () {
    this.$store.dispatch("getProductListApi", {
      success: (res) => {
        this.productsList = res.products;
        console.log(this.productsList);
      },
    });
  },
  data() {
    return {
      productsList: [],
    };
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-wrap: wrap;
  margin: 3px;
  justify-content: space-around;
  /* background-color: bisque; */
}
img {
  padding-top: 8px;
  height: 250px;
  width: 250px;
  border-radius: 10px;
}
.inner {
  /* border: 8px solid white; */
  background-color: beige;
  margin: 15px;
  height: auto;
  width: 20vw;
  border-radius: 8px;
}
.button {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
