<template>
  <div v-if="user">
    <div class="bg-light d-flex mt-5 shadow-lg rounded w-75 m-auto">
      <div class="d-flex w-25 shadow-lg bg-light rounded-start" style="height: 500px;width: 300px">
        <div class="d-flex flex-column w-100 text-center">
          <div class="d-flex bg-secondary rounded-circle justify-content-center align-self-center mt-2"
               style="width: 100px;height: 100px;color: lightgray">
            <h1 class="text-center display-1">{{ firstLetter }}</h1>
          </div>
          <div class="d-flex justify-content-center mt-1">
            <h5 class="fw-bold">{{ user.name }} {{ user.lastName }}</h5>
          </div>
          <div class="d-flex flex-column mt-4">
            <router-link to="/my-profile/personal-info"
                         class="list-group-item list-group-item-action list-group-item-light">
              <font-awesome-icon icon="user" class="me-2" style="width: 15px;height: 15px;"/>
              <span>Personal Info</span>
            </router-link>
            <router-link to="/my-profile/payment-info"
                         class="list-group-item list-group-item-action list-group-item-light">
              <font-awesome-icon icon="credit-card" class="me-2" style="width: 15px;height: 15px;"/>
              <span>Payment Info</span>
            </router-link>
          </div>
        </div>
      </div>
      <div class="d-flex w-75">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyProfilePage",
  data() {
    return {
      user: null,
      firstLetter: ''
    }
  },
  methods: {
    getUser() {
      this.user = this.$store.getters.getUser;
      this.firstLetter = this.user.name.charAt(0);
    }
  },
  mounted() {
    this.getUser();
  }
}
</script>

<style scoped>

</style>