<template>
  <div>
    <div>
      <SliderComponent />
    </div>
    <h1 style="text-align: center">Top Products</h1>
    <div
      id="productsDisplayInner"
      style="
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-items: center;
      "
    >
      <div id="product">
        <img
          src="data:image/jpeg;base64,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"
          id="image-box"
        />
        <p>iPhone 14</p>
      </div>
      <div id="product">
        <img
          src="https://adminapi.applegadgetsbd.com/storage/media/large/iPhone-14-Plus-Purple-4228.jpg"
          alt=""
          id="image-box"
        />
        <p>iPhone 14 Plus</p>
      </div>
      <div id="product">
        <img
          src="https://m.media-amazon.com/images/I/71ZDY57yTQL._SL1500_.jpg"
          alt=""
          id="image-box"
        />
        <p>iPhone 14 Pro Max</p>
      </div>
      <div id="product">
        <img
          src="https://m.media-amazon.com/images/I/71pcTYT+ICL._SX569_.jpg"
          alt=""
          id="image-box"
        />
        <p>Mac Mini</p>
      </div>
      <div id="product">
        <img
          src="https://images.news18.com/ibnlive/uploads/2022/12/fire-boltt-gladiator.jpg"
          id="image-box"
        />
        <p>Apple watch Ultra</p>
      </div>
    </div>

    <footer>
      <p>Copyright 2023 | Ram Kolisetty</p>
    </footer>
  </div>
</template>

<script>
import SliderComponent from "../components/SliderComponent.vue";

export default {
  components: {
    SliderComponent,
  },
  name: "HomeView",
};
</script>

<style>
footer {
  text-align: center;
  /* position: sticky; */
  background-color: #294738cb;
  color: azure;
  position: relative;
  z-index: 999;
  bottom: 0;
  width: 100%;
  height: 60px;
}
.image-slider {
  width: 100%;
  height: 300px;
}
.top-products {
  padding: 20px;
}
.products {
  display: flex;
  justify-content: center;
  align-items: center;

  padding: 18px;
  padding-left: 35px;
  text-align: center;
  margin: 5px;
  margin-top: 5%;

  position: relative;
  display: inline-block;
  width: 120px;
  height: 50px;
  background-color: rgba(238, 248, 238, 0.851);
  /* box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1); */
  border-radius: 5px;
  -webkit-transition: all 0.6s cubic-bezier(0.165, 0.84, 0.44, 1);
  transition: all 0.6s cubic-bezier(0.165, 0.84, 0.44, 1);
}
.products::after {
  content: "";
  border-radius: 5px;
  position: absolute;
  z-index: -1;
  top: 0;
  left: 12.5px;
  width: 100%;
  height: 100%;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
  opacity: 0;
  -webkit-transition: all 0.6s cubic-bezier(0.165, 0.84, 0.44, 1);
  transition: all 0.6s cubic-bezier(0.165, 0.84, 0.44, 1);
}
.products:hover::after {
  opacity: 1;
}

.products:hover {
  -webkit-transform: scale(1.25, 1.25);
  transform: scale(1.25, 1.25);
  padding-left: 35px;
}
.box {
  margin: 14px;
  width: 100px;
  height: 80vh;
  border-radius: 8px;
  background-color: rgb(238, 248, 238);
}
.layered.box {
  box-shadow: 0 1px 1px hsl(0deg 0% 0% / 0.075),
    0 2px 2px hsl(0deg 0% 0% / 0.075), 0 4px 4px hsl(0deg 0% 0% / 0.075),
    0 8px 8px hsl(0deg 0% 0% / 0.075), 0 16px 16px hsl(0deg 0% 0% / 0.075);
}

#product {
  height: 400px;
  width: 270px;
  text-align: center;
}

#image-box {
  height: 200px;
  width: 200px;
  border-radius: 20px;
}
</style>
