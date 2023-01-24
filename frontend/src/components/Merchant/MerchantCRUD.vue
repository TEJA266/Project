<template>
  <div>
    <center>
      <button @click="addProduct">Add Product</button><br />
      <button @click="deleteProduct">Delete Product</button><br />
      <button @click="updateProduct">Update Product</button><br />
      <button @click="viewProducts">View Products</button><br />
    </center>
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
  },
};
</script>
