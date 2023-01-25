<template>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div
          class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden"
        >
          <div class="card-img-left d-none d-md-flex">
            <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body p-4 p-sm-5">
            <h5 class="card-title text-center mb-5 fw-light fs-5">Register</h5>
            <div>
              <div class="form-floating mb-3">
                <input
                  v-model="username"
                  type="text"
                  class="form-control"
                  id="floatingInputUsername"
                  placeholder="myusername"
                  required
                  autofocus
                />
                <label for="floatingInputUsername">Username</label>
              </div>
              <div class="form-floating mb-3">
                <input
                  v-model="email"
                  type="email"
                  class="form-control"
                  id="floatingInputEmail"
                  placeholder="name@example.com"
                />
                <label for="floatingInputEmail">Email address</label>
              </div>
              <hr />
              <div class="form-floating mb-3">
                <input
                  v-model="password"
                  type="password"
                  class="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                />
                <label for="floatingPassword">Password</label>
              </div>
              <div class="form-floating mb-3">
                <input
                  v-model="confirmpassword"
                  type="password"
                  class="form-control"
                  id="floatingPasswordConfirm"
                  placeholder="Confirm Password"
                />
                <label for="floatingPasswordConfirm">Confirm Password</label>
              </div>
              <div class="d-grid mb-2">
                <button
                  class="btn btn-lg btn-primary btn-login fw-bold text-uppercase"
                  @click="registeruser"
                >
                  Register
                </button>
              </div>
              <router-link
                class="nav-link d-block text-center mt-2 small link-primary"
                to="/userlogin"
                >Have an account? Sign In</router-link
              >
              <!-- <a class="d-block text-center mt-2 small" href="#"
                    >Have an account? Sign In</a
                  > -->
              <hr class="my-4" />
              <div class="d-grid mb-2">
                <button
                  class="btn btn-lg btn-google btn-login fw-bold text-uppercase"
                  @click="googleregisteruser"
                >
                  <i class="fab fa-google me-2"></i> Sign up with Google
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getAuth, GoogleAuthProvider, signInWithPopup } from "firebase/auth";
// import axios from "axios";
import { mapActions } from "vuex";
// import firebase from "firebase/package.json";
import firebase from "firebase/compat/app";
import "firebase/compat/auth";
export default {
  name: "MerchantRegistration",
  data() {
    return {
      username: "",
      email: "",
      password: "",
      confirmpassword: "",
    };
  },
  methods: {
    ...mapActions(["SET_USER_DETAILS"]),
    async registeruser() {
      try {
        const res = await firebase
          .auth()
          .createUserWithEmailAndPassword(this.email, this.password);
        console.log(res);
        // firebase.auth().onAuthStateChanged((user) => {
        //   if (user) {
        //     this.id = user.uid;
        //     console.log("user id", this.id);
        //     const requestBody = {
        //       userId: this.id,
        //       userName: this.name,
        //       userEmail: this.email,
        //       userPassword: this.password,
        //       userAddress: this.address,
        //       userPhoneNo: this.phoneNo,
        //     };
        //     axios
        //       .post("http://10.20.5.40:8084/users/AddUserDetails", requestBody)
        //       .then((response) => {
        //         console.log(response);
        //         this.SET_USER_DETAILS(response.data);
        //       })
        //       .catch((error) => {
        //         console.log(error);
        //       });
        //   }
        // });

        //console.log(user);
        alert("Registered New User");
        this.$router.push("/merchantcrud");
      } catch (err) {
        console.log(err);
        alert(err);
      }
    },
    async googleregisteruser() {
      const provider = new GoogleAuthProvider();
      signInWithPopup(getAuth(), provider)
        .then((result) => {
          console.log(result.user);
          this.$router.push("/merchantcrud");
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // registeruser() {
    //   firebase
    //     .auth()
    //     .createUserWithEmailAndPassword(this.email, this.password)
    //     .then(
    //       function () {
    //         alert("Your account has been created");
    //       },
    //       function (err) {
    //         alert("Oops error occured" + err.message);
    //       }
    //     );
    // },
  },
};
</script>

<style scoped>
body {
  background: #007bff;
  background: linear-gradient(to right, #0062e6, #33aeff);
}

.card-img-left {
  width: 45%;
  /* Link to your background image using in the property below! */
  background: scroll center
    url("https://bootstrapious.com/i/snippets/sn-registeration/illustration.svg");
  background-size: cover;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}

.btn-google {
  color: white !important;
  background-color: #ea4335;
}

.btn-facebook {
  color: white !important;
  background-color: #3b5998;
}
</style>
