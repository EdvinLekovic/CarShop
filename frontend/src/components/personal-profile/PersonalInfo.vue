<template>
  <div class="container m-auto rounded-end" v-if="user">
    <div class="d-flex flex-column">
      <div class="m-auto">
        <h1>PersonalInfo</h1>
      </div>
      <div class="mb-2">
        <div class="m-auto w-75">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name"/>
        </div>
      </div>
      <div class="mb-2">
        <div class="m-auto w-75">
          <label>Lastname</label>
          <input type="text" class="form-control" v-model="lastName"/>
        </div>
      </div>
      <div class="mb-2">
        <div class="m-auto w-75">
          <label>Password</label>
          <input type="text" class="form-control" v-model="password"/>
        </div>
      </div>
      <div class="mb-2">
        <div class="m-auto w-75">
          <label>Repeat Password</label>
          <input type="text" class="form-control" v-model="repeatPassword"/>
        </div>
      </div>
      <div class="m-auto w-75">
        <button class="btn btn-primary" @click="userChanges">Save changes</button>
      </div>
    </div>
  </div>
</template>

<script>
import userService from "@/repository/userRepository";

export default {
  name: "PersonalInfo",
  data() {
    return {
      user: null,
      name: '',
      lastName: '',
      password: '',
      repeatPassword: ''
    }
  },
  methods: {
    getUser() {
      this.user = this.$store.getters.getUser;
      this.name = this.user.name;
      this.lastName = this.user.lastName;
    },
    userChanges() {
      userService.userChanges({
        username: this.$store.getters.getUser.username,
        name: this.name,
        lastName: this.lastName,
        password: this.password,
        repeatPassword: this.repeatPassword
      }).then(() => {
        this.$router.go(0);
      })
    }
  },
  mounted() {
    this.getUser();
  }
}
</script>

<style scoped>

</style>