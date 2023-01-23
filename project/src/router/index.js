// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

// Vue.use(VueRouter)

// const routes = [
//   {
//     path: '/',
//     name: 'home',
//     component: HomeView
//   },
//   {
//     path: '/about',
//     name: 'about',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
//   }
// ]

// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })

// export default router

import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CategoryView from '../views/Category/CategoryView'
import ProductView from '../views/Product/ProductView'
import ShowDetails from "../views/Product/ShowDetails";
import ListProducts from "../views/Category/ListProducts";
import OrderHistory from "../views/Category/OrderHistory";
import SignUp from "../views/SignUp";
import SignIn from '../views/SignIn';
import SearchView from '../views/SearchView';
import CartView from '../views/CartView';

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
    // category detail page
  {
    path: '/category/show/:id',
    name: 'ListProducts',
    component: ListProducts
  },
  {
    path: '/category',
    name: 'CategoryView',
    component: CategoryView
  },
  {
    path: '/product',
    name: 'ProductView',
    component: ProductView
  },
  {
    path: '/product/show/:id',
    name: 'ShowDetails',
    component: ShowDetails
  },

  // sign up and signin

  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/orderhistory',
    name: 'OrderHistory',
    component: OrderHistory
  },
  {
    path: '/cart',
    name: 'CartView',
    component: CartView
  },
  {
    path: '/search',
    name: 'SearchView',
    component: SearchView
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
