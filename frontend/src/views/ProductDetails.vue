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
    <button @click="addToCart">Add To Cart</button>
    <button>Buy Now</button>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
import axios from "axios";
export default {
  name: "ProductDetails",
  productId() {
    console.log("id: ", this.selectedProduct.productId);
    return this.selectedProduct.productId;
  },
  userId() {
    return this.selectedProduct.userId;
  },
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
    ...mapActions(["getProductListApi", "SET_CART_LIST"]),
    addToCart() {
      const requestBody = {
        productId: this.productId,
        userId: this.userId,
        cartid: this.cartId,
      };
      axios
        .post("http://10.20.5.47:8087/addToCart/1", requestBody)
        .then((response) => {
          console.log(response);
          this.SET_CART_LIST(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
