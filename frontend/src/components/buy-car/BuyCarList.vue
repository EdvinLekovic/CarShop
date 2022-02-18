<template>
  <div class="d-flex flex-wrap">
    <buy-car-item v-for="car in cars" :key="car.id" :car="car"></buy-car-item>
  </div>
</template>

<script>
import BuyCarItem from "@/components/buy-car/BuyCarItem";

export default {
  props: ['cars'],
  name: "BuyCarList",
  components: {BuyCarItem}
}
</script>

<style scoped>

</style>