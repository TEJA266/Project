import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import productslisting from "./modules/productslisting";
export default new Vuex.Store({
  modules: { productslisting },
});
