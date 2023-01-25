import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";
import { initializeApp } from "firebase/app";
// import { createApp } from "vue";

// import firebase from "firebase/app";
// import firebase from "firebase/compat/app";

Vue.prototype.$axios = axios;
Vue.config.productionTip = false;

const firebaseConfig = {
  apiKey: "AIzaSyAIEOmwR8DJ2ZgI5np1YrfUWA2Dcz7n1IE",
  authDomain: "ecommerce-22b25.firebaseapp.com",
  projectId: "ecommerce-22b25",
  storageBucket: "ecommerce-22b25.appspot.com",
  messagingSenderId: "794859304783",
  appId: "1:794859304783:web:c060713d499673fe22773a",
};

// Initialize Firebase
// const app = initializeApp(firebaseConfig);

// </script>

initializeApp(firebaseConfig);

// const app = createApp(App);

// app.use(router);

// app.mount("#app");

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
