import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";

// import firebase from "firebase/app";
import firebase from "firebase/compat/app";

Vue.prototype.$axios = axios;
Vue.config.productionTip = false;

/* <script type="module">
  // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/9.16.0/firebase-app.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  Your web app's Firebase configuration */
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

firebase.initializeApp(firebaseConfig);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
