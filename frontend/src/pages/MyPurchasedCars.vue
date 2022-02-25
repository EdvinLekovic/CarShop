<template>
  <div class="container" style="height: 500px">
    <h1 class="text-center mt-2">My Purchased Cars</h1>
    <h2 v-if="cars.length === 0" class="text-center mt-2">No cars available</h2>
    <table v-else class="mt-4 table table-striped table-hover">
      <thead class="table-dark">
      <tr>
        <td>#</td>
        <td>Brand</td>
        <td>Model</td>
        <td>Year</td>
        <td>Type</td>
        <td>transmission</td>
        <td>Fuel Tank Type</td>
        <td>Engine</td>
        <td>Tires</td>
        <td>Emissions</td>
        <td>Quantity</td>
        <td class="fw-bold">Price</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(car,index) in cars" :key="car.id">
        <td>{{ index + 1 }}.</td>
        <td>{{ car.brand.name }}</td>
        <td>{{ car.model.name }}</td>
        <td>{{ car.year }}</td>
        <td>{{ car.carType }}</td>
        <td>{{ car.transmission }}</td>
        <td>{{ car.fuelTankType }}</td>
        <td>{{ car.engine }}</td>
        <td>{{ car.tires }}</td>
        <td>{{ car.emissions }}</td>
        <td>{{ car.quantity }}</td>
        <td class="fw-bold">${{car.price}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import carService from "@/repository/carRepository";

export default {
  name: "MyPurchasedCars",
  data() {
    return {
      cars: []
    }
  },
  methods: {
    fetchMyPurchasedCars() {
      carService.fetchUsersPurchasedCars(
          {
            username: this.$store.getters.getUser.username
          }
      ).then(response => {
            this.cars = response.data;
            this.fetchQuantityOfSameModel(this.cars);
          }
      );
    },
    fetchQuantityOfSameModel(cars) {
      for (let i = 0; i < cars.length; i++) {
        carService.quantityOfOwningSameCarModel(
            {username: this.$store.getters.getUser.username}, cars[i].id)
            .then(response => {
              console.log(response.data);
              cars[i].quantity = response.data;
            });
      }
    }
  },
  mounted() {
    this.fetchMyPurchasedCars();
  }
}
</script>

<style scoped>

</style>