import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import productslisting from "./modules/productslisting";
import userDetails from "./modules/userDetails";
export default new Vuex.Store({
  modules: { productslisting, userDetails },
});
