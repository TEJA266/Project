//import axios from "axios";
export default {
  state: {
    ItemsCartList: [],
  },
  getters: {
    getItemsCartList: (state) => state.ItemscartList,
  },
  mutations: {
    setItemsCartList: (state, value) => (state.setItemCartList = value),
  },
  actions: {
    getItemsCartListApi: ({ commit }, { success }) => {
      fetch("http://10.20.5.47:8082/cart/GetAllCartProducts/jash_uid")
        .then((resp) => resp.json())
        .then((res) => {
          commit("setItemsCartList", res);
          success && success(res);
        });
    },
  },
};
