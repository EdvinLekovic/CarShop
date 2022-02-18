<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="z-index: 100">
    <div class="container">
      <div class="d-flex justify-content-between align-items-center">
        <button
            class="navbar-toggler me-4"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="">
          <router-link class="navbar-brand" to="/home">CarShop</router-link>
        </div>
      </div>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" aria-current="page" to="/home"
            >Home
            </router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/buy-car">Buy Car</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/services">Services</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/ratings">Ratings</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/about-us">About Us</router-link>
          </li>
          <li class="nav-item ps-5">
            <router-link
                class="btn btn-outline-light"
                to="/login"
                v-if="!$store.getters.getUser">Login
            </router-link>
            <div
                class="collapse navbar-collapse"
                id="navbarNavDarkDropdown"
                v-else
            >
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                  <a
                      class="d-flex nav-link"
                      href="#"
                      id="navbarDarkDropdownMenuLink"
                      role="button"
                      data-bs-toggle="dropdown"
                      aria-expanded="false"
                  >
                    <!--                    <img :src="require('@/assets/nissan-gtr-2021.jpg')" alt="lala" class="rounded-circle" style="width: 50px;height: 50px"/>-->
                    <div
                        class="d-flex bg-secondary rounded-circle justify-content-center me-1"
                        style="width: 25px; height: 25px; color: lightgray"
                    >
                      <h5 class="text-center">{{ firstLetter }}</h5>
                    </div>
                    <div class="d-flex">
                      {{ user?.username }}
                    </div>
                  </a>

                  <ul
                      class="dropdown-menu dropdown-menu-dark"
                      aria-labelledby="navbarDarkDropdownMenuLink">
                    <li>
                      <router-link
                          class="dropdown-item"
                          to="/my-profile/personal-info">My Profile
                      </router-link>
                    </li>
                    <li>
                      <router-link class="dropdown-item" to="/my-purchased-cars">My purchased cars</router-link>
                    </li>
                    <li v-if="user?.role === 'ADMIN'">
                      <router-link class="dropdown-item" to="/client-request-services">Client request services
                      </router-link>
                    </li>
                    <li v-else>
                      <router-link class="dropdown-item" to="/my-services">My services</router-link>
                    </li>
                    <li class="dropdown-divider"></li>
                    <li>
                      <a class="dropdown-item" href="#" @click="logoutUser"
                      >Logout</a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
            <!--            <button class="btn btn-outline-light" v-else @click="logoutUser">Logout</button>-->
          </li>
        </ul>
      </div>
      <div class="d-flex"></div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "TheHeader",
  data() {
    return {
      user: null,
      firstLetter: "",
    };
  },
  methods: {
    logoutUser() {
      this.$store.state.user = null;
      this.$store.state.userToken = null;
      this.$store.state.userAvailability = false;
      sessionStorage.clear();
    },
    getUser() {
      this.user = this.$store.getters.getUser;
      if (this.user) {
        this.firstLetter = this.user?.name?.charAt(0);
      }
    },
    isLoggedIn() {
      return this.$store.getters.getUser;
    },
  },
  mounted() {
    this.getUser();
  },
};
</script>

<style>
.header-sticky {
  z-index: 100;
}
</style>
