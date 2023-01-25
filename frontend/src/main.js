import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import firebase from "firebase/compat/app";
import "firebase/compat/auth";
import "firebase/compat/database";
import "firebase/compat/firestore";
import axios from "axios";
Vue.prototype.$http = axios;
Vue.config.productionTip = false;
import "firebase/compat/database";
// import { initializeApp } from "firebase/app";
// import { createApp } from "vue";

// import firebase from "firebase";
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

firebase.initializeApp(firebaseConfig);

const auth = firebase.default.auth();
const database = firebase.default.database();
export { auth, database };

firebase.initializeApp(firebaseConfig);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
