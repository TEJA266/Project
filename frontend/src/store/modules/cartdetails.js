export default {
  state: {
    cartList: [],
  },
  getters: {
    getCartList: (state) => state.cartList,
  },
  mutations: {
    setCartList: (state, value) => (state.cartList = value),
  },
  actions: {
    SET_CART_LIST: ({ commit }, cartList) => {
      commit("setCartList", cartList);
    },
  },
};
