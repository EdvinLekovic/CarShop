<template>
  <Form width="800px" height="600px">
    <form @submit.prevent="editCar">
      <div class="d-flex justify-content-center">
        <h3 class="mt-5">Form for editing car</h3>
      </div>
      <div class="d-flex flex-column ms-2 mt-3 me-2">
        <label>Fuel tank type:</label>
        <select class="form-control" v-model="selectedFuelTankType">
          <option v-for="fuelTankType in fuelTankTypes" :key="fuelTankType">{{ fuelTankType }}</option>
        </select>
      </div>
      <div class="d-flex flex-column ms-2 mt-3 me-2">
        <label>Engine:</label>
        <input type="text" required class="form-control" placeholder="Enter the car engine" v-model="engine">
      </div>
      <div class="d-flex flex-column ms-2 mt-3 me-2">
        <label>Tires type:</label>
        <input type="text" required class="form-control" placeholder="Enter the car tires type" v-model="tiresType">
      </div>
      <div class="d-flex flex-column ms-2 mt-3 me-2">
        <label>Emissions:</label>
        <input type="number" required class="form-control" placeholder="Enter the car emissions" v-model="emissions">
      </div>
      <div class="d-flex flex-column ms-2 mt-3 me-2">
        <label>Price:</label>
        <input type="number" required class="form-control" placeholder="Enter the car emissions" v-model="price">
      </div>
      <div class="d-flex ms-2 mt-3">
        <button type="submit" class="btn btn-secondary">Add New Car</button>
      </div>
    </form>
  </Form>
</template>

<script>
import carService from "@/repository/carRepository";
import Form from "@/components/UI/Form";

export default {
  name: "EditCarForm",
  props: ['id'],
  components: {Form},
  data() {
    return {
      fuelTankTypes: [],
      selectedFuelTankType: '',
      engine: '',
      tiresType: '',
      emissions: '',
      price: ''
    }
  },
  methods: {
    editCar() {
      carService.editCar({
        id: this.id,
        fuelTankType: this.selectedFuelTankType,
        engine: this.engine,
        tires: this.tiresType,
        emissions: this.emissions,
        price: this.price
      }).then(() => {
        this.$router.push('/buy-car')
      })
    },
    fetchFuelTankTypes() {
      this.fuelTankTypes = this.$store.getters.getFuelTankTypes;
      this.selectedFuelTankType = this.fuelTankTypes[0];
    }
  },
  mounted() {
    this.fetchFuelTankTypes();
  }
}
</script>

<style scoped>

</style>