<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 v-if="this.category !== null" class="pt-3"> {{this.category.name}}</h4>
                <h5 style="font-weight: 300; color: #686868"> {{msg}} </h5>
            </div>
        </div>

        <div class="row">
            <div v-for="product of this.categoryBasedProducts" :key="product.id"
                 class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
                <ProductBox :product="product" />
            </div>
        </div>
    </div>
</template>
<script>
    import axios from "axios";
    import ProductBox from "../../components/ProductBox";
    export default {
        components: {ProductBox},
        data() {
            return {
                id: null,
                categoryBasedProducts: [],
                category: null,
                msg: ''
            }
        },
        methods:{
            async fetchCategoryBasedProducts(){
                this.id = this.$route.params.id;
                await axios.get("http://10.177.1.120:9000/product/category/"+this.id).then((res) => this.categoryBasedProducts = res.data).catch((err) => console.log(err));
                console.log(this.categoryBasedProducts);
            }
        },
        props: ["categories"],
        mounted() {
            // this.id = this.$route.params.id;
            // this.category = this.categories.find(category => category.id == this.id)
            // if (this.category.products.length == 0) {
            //     this.msg = "no products found"
            // } else if (this.category.products.length == 1) {
            //     this.msg = "Only 1 product found"
            // } else {
            //     this.msg = this.category.products.length + " products found"
            // }
            this.id = this.$route.params.id;
            this.category = this.categories.find(category => category.id == this.id);
            this.fetchCategoryBasedProducts();
        }
    }
</script>
