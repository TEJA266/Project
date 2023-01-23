import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserLogIn from "../views/UserLogIn.vue";
import ProductsList from "../views/ProductsList.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/products",
    name: "productsList",
    component: ProductsList,
  },
  {
    path: "/products/:id",
    name: "ProductsDisplay",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/ProductDetails.vue"),
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/userlogin",
    name: "login",
    component: UserLogIn,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
