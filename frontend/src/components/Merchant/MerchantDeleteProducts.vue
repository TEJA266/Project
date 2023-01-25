<template>
  <div style="display: flex; justify-content: center; margin-top: 3vh">
    <form style="width: 40%">
      <h3 style="text-align: center">Delete a product from the merchant</h3>
      <br />
      <div class="form-group">
        <label>Product Id</label>
        <input
          v-model="productId"
          type="text"
          class="form-control"
          placeholder="Enter product Id"
          required
        />
      </div>
      <button type="submit" class="btn btn-primary" @click.prevent="submitForm">
        Submit
      </button>
      <span style="visibility: hidden">uidk </span>
      <button type="reset" class="btn btn-secondary" @click="resetForm">
        Reset
      </button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      productId: "",
    };
  },
  methods: {
    submitForm() {
      // Code to handle form submission
      // You can access the form data using `this.productName`, `this.brand`, etc.
    },
    resetForm() {
      this.productId = "";
    },
  },
};
</script>
