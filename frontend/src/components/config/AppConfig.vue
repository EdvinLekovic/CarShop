<template>
  <div v-if="fetchFinished" >
    <div>
      <TheHeader/>
      <router-view></router-view>
      <Footer/>
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/navigation/TheHeader";
import Footer from "@/components/navigation/Footer";

export default {
  components: {TheHeader,Footer},
  name: "AppConfig",
  computed: {
    fetchFinished() {
      // console.log(this.getBrands);
      // console.log(this.getTypes);
      // console.log(this.getTransmissions);
      // console.log(this.getFuelTankType);
      let predicate;
      if (this.$store.getters.getUserToken) {
        console.log(this.$store.getters.getUserToken);
        console.log(this.$store.getters.getUser);
        predicate = this.getBrands?.length > 0 && this.getTypes?.length > 0 &&
            this.getTransmissions?.length > 0 && this.getFuelTankType?.length > 0 && this.$store.getters.getUser;
      } else {
        predicate = this.getBrands?.length > 0 && this.getTypes?.length > 0 &&
            this.getTransmissions?.length > 0 && this.getFuelTankType?.length > 0;
      }
      // console.log("Predicate: ",predicate);
      return predicate;
    },
    getBrands() {
      return this.$store.getters.getBrands;
    },
    getTypes() {
      return this.$store.getters.getTypes;
    },
    getTransmissions() {
      return this.$store.getters.getTransmissions;
    },
    getFuelTankType() {
      return this.$store.getters.getFuelTankTypes;
    }
  },
  watch: {
    fetchFinished() {
      return this.fetchFinished;
    }
  },
  methods: {
    fetchBrands() {
      this.$store.dispatch("fetchBrands");
    },
    fetchTypes() {
      this.$store.dispatch("fetchTypes");
    },
    fetchTransmissions() {
      this.$store.dispatch("fetchTransmissions");
    },
    fetchFuelTankTypes() {
      this.$store.dispatch("fetchFuelTankTypes");
    },
    fetchUser() {
      console.log(this.$store.getters.getUserToken);
      if (this.$store.getters.getUserToken) {
        this.$store.dispatch("checkTokenExpiration", {thisObj: this, token: this.$store.getters.getUserToken})
      }
    }
  },
  created() {
    this.fetchBrands();
    this.fetchTypes();
    this.fetchTransmissions();
    this.fetchFuelTankTypes();
    this.fetchUser();
  }
}
</script>

<style scoped>

</style>