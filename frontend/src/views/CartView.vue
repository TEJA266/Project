<template>
  <div>
    <h1>CART PAGE</h1>
    <div v-for="product in cartProducts" :key="product.id">
      {{ product.productId }}, {{ product.productName }},
      {{ product.category }}, {{ product.description }}, {{ product.price }},
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["getItemsCartList"]),
  },
  mounted() {
    // console.log(this.getItemsCartList);
  },
  data() {
    return {
      cartProducts: [],
    };
  },
  created: function () {
    this.$store.dispatch("getItemsCartListApi", {
      success: (res) => {
        this.cartProducts = res;
        console.log("CARTPRODUCTS", res);
      },
    });
  },
  methods: {
    ...mapActions(["getItemsCartListApi"]),
  },
};
</script>
