<template>
    <div v-if="orderItemLocal" class="card h-100 w-100">
        <div class="embed-responsive embed-responsive-16by9">
            <img
                class="card-img-top embed-responsive-item"
                :src="orderItemLocal.imageUrl"
                alt="Card image cap"
            />
        </div>
        <div class="card-body">
            <h6>{{orderItemLocal.name}}</h6>
            <h6>Rs. {{orderItemLocal.price}}</h6>
            <h6>Qty: {{orderItemLocal.quantity}}</h6>
        </div>
    </div>
</template>
<script>
    import axios from 'axios'
    export default {
        name: "OrderBox",
        props: ["orderitem","baseURL"],
        data(){
            return{
            orderItemLocal: null,    
            }
        },
        mounted(){
            this.orderItemLocal = this.orderitem
            axios.get(`http://10.177.1.120:9000/product/${this.orderitem.productId}`).then((res) => {
                this.orderItemLocal.imageUrl = res.data.imageUrl,
                this.orderItemLocal.name = res.data.name
            }).catch(err => console.log(err))
        }
    }

</script>
<style scoped>
    .card-img-top {
        object-fit: cover;
    }
    a {
        text-decoration: none;
    }
    .card-title {
        color: #484848;
    }
</style>
