<template>
  <div id="home">
    <div id="mask" ><span id="fonthome">Welcome To Aura</span></div>
    <div id="background-div" class="page-holder bg-cover">
      <div class="container py-5">
        <header class="text-left text-white py-5">
          <!-- <h3 class="mb-4 rounded" id="heading">
            <a href="#start-shopping" class="bg-white px-2 py-2 rounded"> Start shopping</a> </h3> -->
            <!-- <p class="lead mb-0 bg-dark p-1 rounded"> Aura</p> -->
        </header>
      </div>
      <!-- <hr /> -->
    </div>

    <!--    display categories-->
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3"> Top Categories</h2>
        </div>
      </div>
      <!-- <div class="row">
        <div v-for="index in this.categorySize" :key="index"
             class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <CategoryBox :category="categories[index-1]" />
        </div>
      </div> -->
      <div class="row">
        <div v-for="(category,index) in categories" :key="category.id"
             class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <CategoryBox v-if="index < categorySize" :category="category" />
        </div>
      </div>
    </div>

  <!--    display top products-->
    <div class="container py-2">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3"> Top Products</h2>
        </div>
      </div>

      <!--      display products-->

      <!-- <div class="row">
        <div v-for="index in this.productSize" :key="index"
             class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <ProductBox :product="rproducts[index-1]" />
        </div>
      </div> -->
      <div class="row">
        <div v-for="(rproduct) in rproducts" :key="rproduct.id"
             class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <ProductBox :product="rproduct" />
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import CategoryBox from "../components/Category/CategoryBox";
import ProductBox from "../components/ProductBox";
export default {
  name: "HomeView",
  components: {ProductBox, CategoryBox},
  props: ["categories", "products","rproducts"],
  data() {
    return {
      categorySize: 0,
      productSize: 0,
      rproductSize: 0,
    }
  },
  mounted() {
    this.categorySize = Math.min(6, this.categories?.length);
    this.productSize = Math.min(8, this.products?.length);
    this.rproductSize = Math.min(6, this.rproducts?.length);
  }
};
</script>
<style>
  .page-holder {
    min-height: 100vh;
  }
  .bg-cover{
    background-size: cover !important;
  }
  #background-div {
    background: url("../assets/home.png");
    /* filter: blur(4px);
    -webkit-filter: blur(4px); */

  }
  #heading {
    font-weight: 400;
  }
  #mask{
    position:absolute;
    width:100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.397);
    text-align: center;
    display:flex;
    align-items:center;
    justify-content: center;
  }
  #fonthome{
    font-size: 800%;
    font-family: serif;
    color: #fafafa;

  }
</style>
