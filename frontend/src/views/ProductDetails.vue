<template>
  <div class="MyFirstView">
    <h1>Product DETAILS Page</h1>
    <img
      :src="products[index - 1].imgsrc"
      style="height: 40vh; width: 30vh"
    /><br />
    {{ products[index - 1].name }}<br />
    {{ products[index - 1].price }}<br />
    <!-- {{ products[index - 1].brand }}<br /> -->
    <!-- {{ products[index - 1].category }}<br /> -->
    {{ products[index - 1].description }}<br />
    <button>Add To Cart</button>
    <button>Buy Now</button>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ProductDetails",
  computed: {
    ...mapGetters(["getProductsList"]),
  },
  data() {
    return {
      products: [],
      index: 0,
    };
  },
  methods: {
    ...mapActions(["getProductListApi"]),
  },
  mounted() {
    console.log("params", this.$route.params);
    this.index = this.$route.params.id;
    console.log("query", this.$route.query);
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
};
</script>
