<template>
  <div class="MyFirstView">
    <h1>Product DETAILS Page</h1>
    <img
      :src="selectedProduct.imgSrc"
      style="height: 40vh; width: 30vh"
    /><br />
    {{ selectedProduct.name }}<br />
    {{ selectedProduct.price }}<br />
    <!-- {{ selectedProduct.brand }}<br /> -->
    <!-- {{ selectedProduct.category }}<br /> -->
    {{ selectedProduct.description }}<br />
    <button>Add To Cart</button>
    <button>Buy Now</button>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ProductDetails",
  data() {
    return {
      products: [],
      index: 0,
    };
  },
  computed: {
    ...mapGetters(["getProductsList"]),
    selectedProduct() {
      return (
        this.getProductsList.find((product) => product.id === this.index) || {}
      );
    },
  },
  mounted() {
    console.log("params", this.$route.params);
    this.index = this.$route.params.id;
    console.log("from product Details page", this.products);
  },
  created: function () {
    this.$store.dispatch("getProductListApi", {
      success: (res) => {
        this.products = res.products;
        console.log(this.products);
      },
    });
  },
  methods: {
    ...mapActions(["getProductListApi"]),
  },
};
</script>
