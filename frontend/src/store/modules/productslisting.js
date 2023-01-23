export default {
  state: {
    productsList: [],
  },
  getters: {
    getProductsList: (state) => state.productsList,
  },
  mutations: {
    setProductsList: (state, value) => {
      state.productsList = value;
    },
  },
  actions: {
    getProductListApi: ({ commit }, { success }) => {
      fetch("https://dummyjson.com/products")
        .then((response) => response.json())
        .then((res) => {
          commit("setProductsList", res);
          success && success(res);
        });
    },
  },
};
