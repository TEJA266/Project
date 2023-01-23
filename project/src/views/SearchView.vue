<template>
    <div class="container">
       <div class="row">
           <div class="col-12 text-center">
               <h4>Matching Products</h4>      
           </div>
       </div>
       <div class="row">
<!--            display all the products in productbox component-->
           <div v-for="product of searchResults" :key="product.id"
                class="col-md-6 col-xl-4 col-12 pt-3 d-flex">
               <ProductBox :product="product"/>
           </div>
       </div>
   </div>
         
  
</template>
<script>
import axios from "axios";
import ProductBox from "../components/ProductBox";
export default{
   components: {ProductBox},
   props: ["baseURL",],
   setup() {

   },
   data(){
       return{
           searchQuery: null,
           searchResults: [],
       }
   },
   watch: {
       '$route' () {
           this.searchQuery = this.$route.query.searchQueryKey
           this.fetchData()
       }
   },
   methods: {
      async fetchData() {
     // api call to get all the Search Results
     await axios
       .get(this.baseURL + "search/query/"+`${this.searchQuery}`)
       .then((res) => {
         this.searchResults = res.data;
         
       //   this.$router.go();
         //console.log(this.searchQuery); 
       })
       .catch((err) => console.log("Category err", err));
       //console.log(this.searchQuery); 

   }},
   mounted(){
       this.searchQuery = this.$route.query.searchQueryKey
       this.fetchData()
   },
}
</script>
<style scoped>

</style>
