<!-- <template>
  <div>
    <navbar>
      <div class="logo">Logo</div>
      <form>
        <input type="text" placeholder="Search products" />
      </form>
      <router-link to="/products">Products</router-link>
      <router-link to="/cart">Cart</router-link>
      <router-link to="/profile">Profile</router-link>
      <router-link to="/login">Log In</router-link>
      <router-link to="/signup">Sign up</router-link>
    </navbar>
  </div>
</template> -->
<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">My E-Commerce Site</a>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="form-inline my-2 my-lg-0" style="display: flex">
      <input
        class="form-control mr-sm-2"
        type="search"
        placeholder="Search"
        aria-label="Search"
      />
      <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
    <div
      class="collapse navbar-collapse"
      id="navbarNav"
      style="justify-content: end"
    >
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/products">Products</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/cart">Cart</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/profile">Profile</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/login">Log In</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {};
  },
  methods: {},
  mounted() {},
};
</script>

<style>
/* navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 23px;
  background-color: #294738;
  box-shadow: 0 -6px 10px 5px rgba(0, 0, 0, 0.5);
  position: sticky;
  z-index: 999;
  top: -10px;
  margin: 0%;
} */
.logo {
  font-size: 30px;
  font-weight: bold;
}
.extend-navbar {
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
}
.btn .bx {
  vertical-align: inherit;
  margin-top: -3px;
  font-size: 1.15rem;
}

.form-control {
  height: calc(2.5rem + 2px);
  padding: 0.5rem 1.5rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: 0.3rem;
}

.btn {
  font-size: 1rem;
  padding: 0.5rem 0.75rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: 0.25rem;
}

.bx.icon-single {
  font-size: 1.5rem;
}

.form-inline .form-control {
  border-top-right-radius: 0;
  border-bottom-right-radius: 0;
}

.form-inline .btn {
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
}

/* Small devices (landscape phones, 576px and up) */
@media (min-width: 576px) {
}

/* Medium devices (tablets, 768px and up) */
@media (min-width: 768px) {
  .form-inline .form-control {
    width: 210px;
  }
}

/* Large devices (desktops, 992px and up) */
@media (min-width: 992px) {
  .form-inline .form-control {
    width: 440px;
  }
}

/* Extra large devices (large desktops, 1200px and up) */
@media (min-width: 1200px) {
  .form-inline .form-control {
    width: 600px;
  }
}

.sub-menu.navbar-light .navbar-nav .active > .nav-link,
.sub-menu.navbar-light .navbar-nav .nav-link.active,
.sub-menu.navbar-light .navbar-nav .nav-link.show,
.sub-menu.navbar-light .navbar-nav .show > .nav-link {
  border-bottom: 3px solid #007bff;
  color: #007bff;
}

.navbar .navbar-toggler {
  border: none;
}

.navbar-light .navbar-toggler:focus {
  outline: none;
}

.navbar {
  padding: 1rem;
}

.main-menu {
  position: relative;
  z-index: 3;
}

.sub-menu {
  position: relative;
  z-index: 2;
  padding: 0 1rem;
}

/* Medium devices (tablets, 768px and up) */
@media (min-width: 768px) {
  .sub-menu {
    padding: 0 1rem;
  }

  .sub-menu.navbar-expand-md .navbar-nav .nav-link {
    padding: 1rem 1.5rem;
  }
}

.navbar.bg-light {
  background: #fff !important;
  box-shadow: 0px 2px 15px 0px rgba(0, 0, 0, 0.1);
}

.user-dropdown .nav-link {
  padding: 0.15rem 0;
}

#sidebar {
  background: #fff;
  height: 100%;
  left: -100%;
  top: 0;
  bottom: 0;
  overflow: auto;
  position: fixed;
  transition: 0.4s ease-in-out;
  width: 84%;
  z-index: 5001;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.3);
  padding: 1.25rem 1rem 1rem;
}

#sidebar.active {
  left: 0;
}

#sidebar .sidebar-header {
  background: #fff;
  border-bottom: 1px solid #e4e4e4;
  padding-bottom: 1.5rem;
}

#sidebar ul.components {
  padding: 20px 0;
  border-bottom: 1px solid #e4e4e4;
  margin-bottom: 40px;
}

#sidebar ul p {
  color: #fff;
  padding: 10px;
}

#sidebar ul li a {
  padding: 10px 16px;
  font-size: 1.1em;
  display: block;
  color: #000;
}

#sidebar ul li a:hover {
  color: #7386d5;
  background: #fff;
}

#sidebar ul li.active > a,
#sidebar a[aria-expanded="true"] {
  color: #007bff;
  background: #e6f2ff;
  border-radius: 6px;
}

a[data-toggle="collapse"] {
  position: relative;
}

#sidebar .links .dropdown-toggle::after {
  display: block;
  position: absolute;
  top: 50%;
  right: 20px;
  transform: translateY(-50%);
}

section {
  padding: 6rem;
  background: #e4e4e4;
  margin-bottom: 30px;
  position: relative;
  z-index: 1;
}

.overlay {
  background: rgba(0, 0, 0, 0.7);
  height: 100vh;
  left: 0;
  position: fixed;
  top: 0;
  -webkit-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  z-index: -1;
  width: 100%;
  opacity: 0;
}

.overlay.visible {
  opacity: 1;
  z-index: 5000;
}

/* .mobiHeader .menuActive~.overlay {
    opacity: 1;
    width: 100%;
} */

ul.social-icons {
  list-style-type: none;
  padding-left: 0;
  margin-bottom: 0;
}

ul.social-icons li {
  display: inline-block;
  margin-right: 0px;
  margin-bottom: 0;
}

#sidebar ul.social-icons li a {
  font-size: 24px;
}

.utility-nav {
  background: #e4e4e4;
  padding: 0.5rem 1rem;
}

.utility-nav p {
  margin-bottom: 0;
}

.search-bar {
  position: relative;
  z-index: 2;
  box-shadow: 0px 2px 15px 0px rgba(0, 0, 0, 0.1);
}

.search-bar .form-control {
  width: calc(100% - 45px);
}

.avatar {
  border-radius: 50%;
  width: 4.5rem;
  height: 4.5rem;
  margin-right: 8px;
}

.avatar.avatar-xs {
  width: 2.25rem;
  height: 2.25rem;
}

.user-dropdown .dropdown-menu {
  left: auto;
  right: 0;
}
</style>
