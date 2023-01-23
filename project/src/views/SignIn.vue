<template>
    <div class="conatiner">
      <div class="row">
        <div class="col-12 justify-content-center d-flex flex-row pt-5">
          <div id="signin" class="flext-item border">
            <h2 class="pt-4 text-center">Sign-In</h2>
            <form @submit="signin" class="form-group pt-4 pl-4 pr-4">
              <div class="form-group">
                <label>Email </label>
                <input v-model="email" type="email" class="form-control" />
              </div>
              <div class="form-group">
                <label>Password </label>
                <input v-model="password" type="password" class="form-control" />
              </div>
              <div class="form-row">
                <div class="col">
                  <button class="btn btn-primary mt-2 py-0">Sign In</button>
                </div>
                <div class="col">
                  <button class="btn btn-primary mt-2 py-0"><img src="@/assets/google.png" />&nbsp;&nbsp;Login via Google</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>
  <script>
  import axios from "axios";
  import swal from "sweetalert";
  export default {
    props: ["baseURL"],
    data() {
      return {
        email: null,
        password: null,
      };
    },
    methods: {
      async signin(e) {
        e.preventDefault();
        const body = {
          email: this.email,
          password: this.password,
        };
        await axios
          .post(`${this.baseURL}user/signin`, body)
          .then((res) => {
            //console.log("HELLLOOOOO");
            //console.log(res.data);
            localStorage.setItem("token", res.data.token);
            localStorage.setItem("userId", res.data.id);
            swal({
              text: "Login successful",
              icon: "success",
            });
            this.$emit("fetchData");
            window.location.href = '/'
            // this.$router.push({ name: "Home" });
          })
          .catch((err) => console.log("err", err));
      },
    },
  };
  </script>
  <style scoped>
  .btn-primary {
    background-color: #d4af7a;
    color: black;
  }
  
  @media screen and (min-width: 992px) {
    #signin {
      width: 40%;
    }
  }
  </style>
  