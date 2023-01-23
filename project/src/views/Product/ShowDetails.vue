<template>
    <div class="container">
      <div class="row pt-5">
        <div class="col-md-1"></div>
        <!--            display image-->
        <div v-if="this.product !== null" class="col-md-4 col-12">
          <img :src="product.imageUrl" class="img-fluid" />
        </div>
        <!--            display product details-->
        <div class="col-md-6 col-12 pt-3 pt-md-0">
          
          <h6 v-if="this.category !== null" class="catgory font-italic">{{ category.name }}</h6>
          <div v-if="this.product !== null">
            
          <h4>{{ product.name }}</h4>
          <h6 class="font-weight-bold">Rs. {{ product.merchantDtoList[this.currentMerchantIndex].price }}</h6>
          <p>
            {{ product.merchantDtoList[0].description }}
          </p>
          <div class="d-flex flex-row justify-content-between">
            <div class="input-group col-md-3 col-4 p-0">
              <div class="input-group-prepend">
                <span class="input-group-text">Quantity</span>
              </div>
              <input type="number" class="form-control" v-model="quantity" min="1" />
            </div>
  
            <div class="input-group col-md-3 col-4 p-0">
              <button
                class="btn"
                type="button"
                id="add-to-cart-button"
                @click="addToCart"
              >
                Add to Cart
              </button>
            </div>
          </div>
          <div class="features pt-3">
            <h5><strong>Features</strong></h5>
            <ul v-for="attribute of this.product.merchantDtoList[this.currentMerchantIndex].attributeList" :key="attribute.attributeName">
              <li>{{attribute.attributeName}} :: {{attribute.attributeValue}}</li>
              <!-- <li>random text2</li>
              <li>random text3</li>
              <li>random text 4</li>
              <li>random text 5</li> -->
              
            </ul>
            <div class="dropdown">
              <span for="merchants" class="increasesize">Merchants</span>
              <div class="form-group">
                <select autofocus class="form-control" @change="onChangeMerchant($event)" required>
                  <option selected v-for="merchant in merchants" :key="merchant.id" v-bind:value="merchant.id">{{ merchant.firstName+" "+merchant.lastName }}</option>
                </select>
              </div>
            </div>
          </div>
          </div>
  
          
        </div>
      </div>
    </div>
  </template>
  <script>
  import swal from "sweetalert";
  import axios from "axios";
  export default {
    data() {
      return {
        product: null,
        category: null,
        quantity: 1,
        currentMerchantIndex: 0,
        selectedMerchant: null,
        merchants: [],
      };
    },
    props: ["baseURL", "products", "categories"],
    methods: {
  
       fetchProductDetails() {
         console.log(this.merchants)
         axios.get("http://10.177.1.120:9000/product/"+this.id).then((res) => this.product = res.data).catch((err) => console.log(err));
        this.category = this.categories.find(category => category.id = this.product.categoryId);
        this.product.merchantDtoList.forEach(merchantDto => {
          console.log(merchantDto.merchantId);
          //working till here
          axios.get(`${this.baseURL}merchant/${merchantDto.merchantId}`)
          .then((res) => {
            console.log(this.merchants)
            this.merchants.push(res.data)
            this.selectedMerchant = this.merchants[0]
          })
          .catch(err => console.log(err))
        });
        // console.log('this: ', this)
        // console.log('merchants: ', this.merchants)
        this.selectedMerchant = this.merchants[0]
      },
  
      // add to cart
      onChangeMerchant(event)
      {
        console.log(event.target.selectedIndex);
        //printing
        this.selectedMerchant = event.target.value;
        this.currentMerchantIndex = event.target.selectedIndex;
      },
  
      addToCart() {
        if (!this.token) {
          // user is not logged in
          // show some error
          swal({
            text: "please login to add item in cart Work in progress",
            icon: "error",
          });
          return;
        }
  
        
        //console.log(cartItemObj);
  
        // add to cart
        if (this.quantity >= 1)
        { 
          const cartItemObj = {
          "productId":this.product.merchantDtoList[this.currentMerchantIndex].productId,
          "merchantId":this.product.merchantDtoList[this.currentMerchantIndex].merchantId,
          "userId":parseInt(localStorage.getItem("userId")),
          "quantity":this.quantity,
          "price":this.product.merchantDtoList[this.currentMerchantIndex].price,
        };
        console.log(cartItemObj);
        axios
          // .post(`${this.baseURL}/cart/add?token=${this.token}`, {
          //   productId: this.id,
          //   quantity: this.quantity,
          // })
          .post(`${this.baseURL}cart`, cartItemObj)
          .then((res) => {
            if (res.data.status === "pass") {
              swal({
                text: "Product added in cart",
                icon: "success",
              });
              this.$emit("fetchData");
            }
            else
            {
              swal({
                text: "Quantity exceeds stock available against the merchant",
                icon: "warning",
              })
            }
            console.log(res);
          })
          .catch((err) => console.log("err", err));
        }
        else{
        swal({
                text: "Quantity is set to 0 or less then 0",
                icon: "warning",
              })
              }
        },
      
    },
    mounted() {
      this.id = this.$route.params.id;
      this.product = this.products.find((product) => product.id == this.id);
      this.category = this.categories.find(
        (category) => category.id == this.product.categoryId
      );
      this.token = localStorage.getItem("token");
      this.fetchProductDetails();
    },
  };
  </script>
  <style>
  .category {
    font-weight: 400;
  }
  
  #add-to-cart-button {
    background-color: #d4af7a;
  }
  </style>
  