<template>
  <div style="display: flex; justify-content: center; margin-top: 3vh">
    <form style="width: 40%">
      <h3 style="text-align: center">Add a new product to market</h3>
      <br />
      <div class="form-group">
        <label>Product Name</label>
        <input
          v-model="productName"
          type="text"
          class="form-control"
          placeholder="Enter product name"
          required
        />
      </div>
      <div class="form-group">
        <label>Brand</label>
        <input
          v-model="brand"
          type="text"
          class="form-control"
          placeholder="Enter brand"
          required
        />
      </div>
      <div class="form-group">
        <label>Price</label>
        <input
          v-model="price"
          type="number"
          class="form-control"
          placeholder="Enter price"
          required
        />
      </div>
      <div class="form-group">
        <label>Quantity</label>
        <input
          v-model="quantity"
          type="number"
          class="form-control"
          placeholder="Enter quantity"
          required
        />
      </div>
      <div class="form-group">
        <label>Image Link</label>
        <input
          v-model="imageLink"
          type="text"
          class="form-control"
          placeholder="Enter image link"
          required
        />
      </div>
      <div class="form-group">
        <label>Description</label>
        <textarea
          v-model="description"
          class="form-control"
          rows="3"
          required
        ></textarea>
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
      productName: "",
      brand: "",
      price: "",
      quantity: "",
      imageLink: "",
      description: "",
    };
  },
  methods: {
    submitForm() {
      // Code to handle form submission
      // You can access the form data using `this.productName`, `this.brand`, etc.
    },
    resetForm() {
      this.productName = "";
      this.brand = "";
      this.price = "";
      this.quantity = "";
      this.imageLink = "";
      this.description = "";
    },
  },
};
</script>

<!-- methods: {
submitForm() {
  // Access the form data using `this.productName`, `this.brand`, etc.
  let product = {
    name: this.productName,
    brand: this.brand,
    price: this.price,
    quantity: this.quantity,
    imageLink: this.imageLink,
    description: this.description
  }
  
  // You can send the data to the server using axios, for example
  axios.post('/api/products', product)
    .then(response => {
      // Handle success
      console.log(response.data)
    })
    .catch(error => {
      // Handle error
      console.log(error)
    })
}
} -->
