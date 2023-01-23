<template>
  <products-listing @product-selected="productSelected"
    >Our products</products-listing
  >
</template>

<script>
import ProductsListing from "@/components/ProductsListing.vue";
export default {
  components: { ProductsListing },
  name: "ProductsList",
  data() {
    return {};
  },
  methods: {
    productSelected(product, msg) {
      console.log(product, msg);
      this.$router.push(`/products/${product.id}`);
    },
  },
};
</script>
