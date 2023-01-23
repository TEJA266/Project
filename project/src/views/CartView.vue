<template>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="pt-3">
            Shopping cart
          </h3>
        </div>
      </div>
  
      <!-- loop over the cart items and display -->
  
      <div
        v-for="cartItem in cartItems"
        :key="cartItem.id"
        class="row mt-2 pt-3 justify-content-around"
      >
        <div class="col-2"></div>
        <div class="col-md-3 embed-responsive embed-responsive-16by9">
          <img
            :src="cartItem.imageUrl"
            alt=""
            class="w-100 card-image-top embed-responsive-item"
            style="object-fit: cover"
          />
        </div>
  
        <!-- display product name, quantity -->
        <div class="col-md-5 px-3">
          <div class="card-block px-3">
            <h6 class="card-title">
              <router-link
                :to="{ name: 'ShowDetails', params: { id: cartItem.productId } }"
              >
              <!-- {{ cartItem.productId }} -->
                {{cartItem.name}}
              </router-link>
            </h6>
  
            <p class="mb-0 font-weight-bold" id="item-price">
              ₹ {{ cartItem.price }} per unit
            </p>
            <div class="Quantity">
              <div class="quantity-toggle">
        <button @click="decrement(cartItem)" class="btn-primary">&mdash;</button>
        <input type="text" :value="cartItem.quantity" readonly>
        <button @click="increment(cartItem)" class="btn-primary">&#xff0b;</button>
      </div>
            <!-- <p class="mb-0" style="float:left">
              
              Quantity:{{ cartItem.quantity }}
            </p> -->
            </div>
          </div>
          <p class="mb-0" style="float:right">
            Total:
            <span class="font-weight-bold">
              ₹ {{ cartItem.price * cartItem.quantity }}
            </span>
          </p>
          <br />
          <a href="#" class="text-right" @click="deleteItem(cartItem.id)"
            >Remove from cart
          </a>
        </div>
        <div class="col-2"></div>
        <div class="col-12"><hr /></div>
      </div>
  
      <!-- display the price -->
      <div class="total-cost pt-2 text-right">
        <h5>Total : ₹{{ this.totalCost.toFixed(2) }}</h5>
      </div>
      <div>
        <button @click="placeOrder()">Place Order</button>
      </div>
    </div>
  </template>
  <script>
  import axios from "axios";
  import swal from "sweetalert";
  export default {
    data() {
      return {
        cartItems: [],
        token: null,
        user: null,
        totalCost: 0,
      };
    },
    props: ["baseURL"],
    methods: {
      // fetch All items in cart
      async listCartItems() {
        await axios
          .get(`${this.baseURL}cart/${this.user}`)
          .then((res) => {
            this.cartItems = res.data;
  
            // const result = res.data;
            // this.cartItems = result.cartItems;
            // this.totalCost = result.totalCost;
          })
          .catch((err) => console.log("err", err));
  
        // await axios.get(`${this.baseURL}/cart/${this.user.id}`).then((res) => this.cartItems = res.data).catch((err) => console.log(err));
        this.cartItems.forEach(async cartItem => {
          await axios.get(`${this.baseURL}product/${cartItem.productId}`).then((res) => {cartItem.name = res.data.name; cartItem.imageUrl = res.data.imageUrl;}).catch((err) => console.log(err));
        });
        
        this.cartItems.forEach(cartItem => {
          this.totalCost += cartItem.price * cartItem.quantity;
        })
      },
      //exp
    //   if (!this.token){
    //     save : () => {
    //   localStorage.setItem("cart", JSON.stringify(this.cartItems));
    //   },
    //   load : () => {
    //   this.cartItems = localStorage.getItem("cart");
    //   if (this.cartItems == null) { this.cartItems = {}; }
    //   else { this.cartItems = JSON.parse(this.cartItems); }
    //       return;
    //     }
    // },
      //expend
      deleteItem(itemId) {
        axios
          .delete(`${this.baseURL}cart/${itemId}`)
          .then((res) => {
            if (res.status == 200) {
              this.$router.go(0);
            }
          })
          .catch((err) => console.log("err", err));
      },
      async placeOrder(){
  
        if(this.totalCost == 0 && this.cartItems.length == 0)
        {
          swal({
              text: "Cart is empty. Please add items",
              icon: "warning",
            });
          return;
        }
  
        const orderObj = {
          "userId": this.user,
          "total": this.totalCost,
          "orderProductList": this.cartItems
        };
        orderObj.orderProductList.forEach(orderProductItem => {
          delete orderProductItem.name;
        });
        console.log(orderObj);
        await axios.post(`${this.baseURL}order/`, orderObj).then(res => {
          if(res.data.status === "fail")
          {
            swal({
              text: "Order was not placed",
              icon: "warning",
            });
          }
          else
          {
        swal({
              text: "Order Placed",
              icon: "success",
            });
        this.$router.go();    
          }
        this.cartItems = [];this.orderObj = null;this.totalCost = 0;}).catch(err => console.log(err));
        
  
      },
      increment (cartItem) {
        console.log(cartItem)
        
        cartItem.quantity = 1
  
        axios.post(`${this.baseURL}cart`, cartItem).then((res) => {
          this.totalCost += cartItem.price
          cartItem.quantity = res.data.quantity  
        }).catch(err => console.log(err))
  
        
      },
      decrement (cartItem) {
        console.log(cartItem)
        if(cartItem.quantity <= 1) {
          return alert('Negative quantity not allowed')
        } else {
  
        cartItem.quantity = -1
  
        axios.post(`${this.baseURL}cart`, cartItem).then((res) => {
          cartItem.quantity = res.data.quantity 
          this.totalCost -= cartItem.price  
        }).catch(err => console.log(err))
        }
      }
      
    },
    mounted() {
      this.token = localStorage.getItem("token");
      this.user = localStorage.getItem("userId");
      this.listCartItems();
    },
  };
  </script>
  <style scoped>
  
  .quantity-toggle {
    display: flex;}
  input {
    
      border: 0;
      width: 2.5rem;
      text-align: center;
      padding: 0 .5rem;
      border: none;
      background: transparent;
    }
  button {
      /* padding: .5rem;
      background: #f5f5f5;
      color: #888;
      font-size: 1rem;
      cursor: pointer;
      border-radius: 10px; */
      background-color: #d4af7a;
    color: black;
    }
  h4,
  h5 {
    color: #484848;
    font-size: 700;
  }
  </style>
  