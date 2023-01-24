<!-- <template>
  <div>
    <center v-if="!isMainRoute">
      <button
        type="button"
        class="btn btn-secondary"
        @click="$router.push('/merchant/addproducts')"
      >
        Add Product</button
      ><br />
      <button type="button" class="btn btn-secondary" @click="deleteProduct">
        Delete Product</button
      ><br />
      <button type="button" class="btn btn-secondary" @click="updateProduct">
        Update Product</button
      ><br />
      <button type="button" class="btn btn-secondary" @click="viewProducts">
        View Products</button
      ><br />
    </center>
    <router-view />
  </div>
</template> -->
<template>
  <div>
    <center v-if="!isMainRoute">
      <div class="d-flex flex-column justify-content-center align-items-center">
        <div class="p-2">
          <button
            type="button"
            class="btn btn-secondary"
            @click="$router.push('/merchant/addproducts')"
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
    addProduct() {
      // router.push({ name: "AddProduct" });
      this.$router.push({ path: "/merchant/addproducts" });
    },
    deleteProduct() {
      // this.deleteProductFromList();
      this.$router.push({ path: "/merchant/deleteproducts" });
    },
    updateProduct() {
      // router.push({ name: "UpdateProduct" });
      this.$router.push({ path: "/merchant/updateproducts" });
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
        this.$route.path.includes("addproducts") ||
        this.$route.path.includes("deleteproducts") ||
        this.$route.path.includes("updateproducts") ||
        this.$route.path.includes("viewproducts")
      );
    },
  },
};
</script>
