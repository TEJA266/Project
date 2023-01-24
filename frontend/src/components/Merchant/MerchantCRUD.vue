<template>
  <div>
    <center v-if="!isMainRoute">
      <div class="d-flex flex-column justify-content-center align-items-center">
        <div class="p-2">
          <button
            type="button"
            class="btn btn-secondary"
            @click="$router.push('/merchant/addnewproduct')"
          >
            Introduce a new product to market
          </button>
        </div>
        <div class="p-2">
          <button
            type="button"
            class="btn btn-secondary"
            @click="$router.push('/merchant/addproduct')"
          >
            Add a new Product
          </button>
        </div>
        <div class="p-2">
          <button
            type="button"
            class="btn btn-secondary"
            @click="deleteProduct"
          >
            Delete a Product
          </button>
        </div>
        <div class="p-2">
          <button
            type="button"
            class="btn btn-secondary"
            @click="updateProduct"
          >
            Update the Stock
          </button>
        </div>
        <div class="p-2">
          <button type="button" class="btn btn-secondary" @click="viewProducts">
            View all Products
          </button>
        </div>
      </div>
    </center>
    <router-view />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
// import router from "@/router";

export default {
  methods: {
    ...mapActions([
      "addProductToList",
      "deleteProductFromList",
      "updateProductOnList",
    ]),
    addnewProduct() {
      // router.push({ name: "AddProduct" });
      this.$router.push({ path: "/merchant/addnewproduct" });
    },
    addProduct() {
      // router.push({ name: "AddProduct" });
      this.$router.push({ path: "/merchant/addproduct" });
    },
    deleteProduct() {
      // this.deleteProductFromList();
      this.$router.push({ path: "/merchant/deleteproduct" });
    },
    updateProduct() {
      // router.push({ name: "UpdateProduct" });
      this.$router.push({ path: "/merchant/updateproduct" });
    },
    viewProducts() {
      // router.push({ name: "ProductList" });
      this.$router.push({ path: "/merchant/viewproducts" });
    },
  },
  computed: {
    ...mapState(["products"]),
    isMainRoute() {
      return (
        this.$route.path.includes("addnewproduct") ||
        this.$route.path.includes("addproduct") ||
        this.$route.path.includes("deleteproduct") ||
        this.$route.path.includes("updateproduct") ||
        this.$route.path.includes("viewproducts")
      );
    },
  },
};
</script>
