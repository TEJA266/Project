<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4> Order History</h4>      
            </div>
        </div>
        <div class="row">
<!--            display all the products in productbox component-->
            <div v-for="order of oproducts" :key="order.id"
                 class="col-12 col-xl-12 col-sm-12 pt-3 d-flex flex-row px-10 card h-100 w-100 my-3 py-3">
                 <div class="col-4 d-flex" v-for="orderitem in order.orderProductList" :key="orderitem.id">
                    <OrderBox :orderitem="orderitem" :baseURL="baseURL"/>
                 </div>
                 <h6 class="col-xl-12 align-content-end d-flex flex-column-reverse">Total: {{order.total}}</h6>
            </div>
        </div>
    </div>
</template>
<script>
    import OrderBox from "../../components/OrderBox";
    export default {
        components: {OrderBox},
        props:["oproducts","baseURL"],
        mounted(){
            console.log(this.oproducts)
        }
    }
</script>
