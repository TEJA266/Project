export default {
  state: {
    Details: [],
  },
  getters: {
    getDetails: (state) => state.Details,
  },
  mutations: {
    setDetails: (state, value) => (state.Details = value),
  },
  actions: {
    getProfileDetails: ({ commit }, { success }) => {
      fetch("api/getUserById/abc@123")
        .then((resp) => resp)
        .then((res) => {
          commit("setDetails", res);
          success && success(res);
        });
    },
  },
};
