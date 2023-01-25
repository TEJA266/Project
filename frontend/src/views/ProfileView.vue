<template>
  <div>
    <h1>My Profile</h1>
    {{ this.userDetails.emailId }}, {{ this.userDetails.firstName }},
    {{ this.userDetails.lastName }},
    {{ this.userDetails.phoneNumber }}
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["getDetails"]),
  },
  data() {
    return {
      userDetails: [],
    };
  },
  created: function () {
    this.$store.dispatch("getProfileDetails", {
      success: (res) => {
        this.userDetails = res;
        console.log("USER DETAILS", res);
      },
    });
  },
  methods: {
    ...mapActions(["getProfileDetails"]),
  },
};
</script>
