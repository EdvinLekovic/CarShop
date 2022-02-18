<template>
  <div>
    <Modal width="800px" height="1350px">
      <form @submit.prevent="addNewCar">
        <div class="d-flex justify-content-center">
          <h3 class="mt-5">Form for adding new car</h3>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Brand:</label>
          <select class="form-control" id="selectedBrand" name="selectedBrand" v-model="selectedBrand">
            <option v-for="brand in brands" :key="brand.name" :value="brand">{{ brand.name }}</option>
          </select>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Model:</label>
          <select class="form-control" v-model="selectedModel">
            <option v-for="model in models" :key="model.id" :value="model">{{ model.name }}</option>
          </select>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Type:</label>
          <select class="form-control" name="selectedType" v-model="selectedType">
            <option v-for="type in types" :key="type" :value="type">{{ type }}</option>
          </select>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Transmission:</label>
          <select class="form-control" v-model="selectedTransmission">
            <option v-for="transmission in transmissions" :key="transmission" :value="transmission">{{
                transmission
              }}
            </option>
          </select>
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
          <input type="number" required class="form-control" placeholder="Enter the car price" v-model="price">
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Year:</label>
          <input type="number" required class="form-control" placeholder="Enter the car year" v-model="year">
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Description:</label>
          <textarea type="number" required class="form-control" style="height: 200px"
                    placeholder="Enter the car description" v-model="description"/>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Car quantity:</label>
          <input type="number" required class="form-control" placeholder="Enter the car quantity" v-model="quantity">
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Image:</label>
          <input type="file" ref="images" multiple>
        </div>
        <div class="d-flex ms-2 mt-3">
          <button type="submit" class="btn btn-secondary">Add New Car</button>
        </div>
      </form>
    </Modal>
  </div>
</template>

<script>
import Modal from "@/components/UI/Form";
import carService from "@/repository/carRepository";

export default {
  name: "AddCarForm",
  components: {Modal},
  data() {
    return {
      brands: [],
      selectedBrand: "",
      models: [],
      selectedModel: "",
      types: [],
      selectedType: "",
      transmission: "",
      selectedTransmission: "",
      fuelTankTypes: "",
      selectedFuelTankType: "",
      engine: '',
      tiresType: '',
      emissions: '',
      price: '',
      year: '',
      description: '',
      quantity: '',
    }
  },
  watch: {
    selectedBrand() {
      console.log(this.selectedBrand);
      this.models = this.selectedBrand.models;
      this.selectedModel = this.models[0];
    }
  },
  methods: {
    addNewCar() {
      let formData = new FormData();
      for (let i = 0; i < this.$refs?.images?.files?.length; i++) {
        formData.append("images", this.$refs.images.files[i]);
      }
      formData.append("brand", JSON.stringify(this.selectedBrand));
      formData.append("model", JSON.stringify(this.selectedModel));
      formData.append("carType", this.selectedType);
      formData.append("transmission", this.selectedTransmission);
      formData.append("fuelTankType", this.selectedFuelTankType);
      formData.append("engine", this.engine);
      formData.append("tires", this.tiresType);
      formData.append("emissions", this.emissions);
      formData.append("price", this.price);
      formData.append("year", this.year);
      formData.append("description", this.description);
      formData.append("quantity", this.quantity);
      carService.addCar(formData).then(() => {
        this.$router.push("/buy-car");
      });
    },
    getBrands() {
      console.log("Brands:")
      this.brands = this.$store.getters.getBrands;
      this.selectedBrand = this.brands[0];
      this.models = this.brands[0].models;
      this.selectedModel = this.models[0];
    },
    getTypes() {
      this.types = this.$store.getters.getTypes;
      this.selectedType = this.types[0];
    },
    getTransmissions() {
      this.transmissions = this.$store.getters.getTransmissions;
      this.selectedTransmission = this.transmissions[0];
    },
    getFuelTankTypes() {
      this.fuelTankTypes = this.$store.getters.getFuelTankTypes;
      this.selectedFuelTankType = this.fuelTankTypes[0];
    }
  },
  mounted() {
    this.getBrands();
    this.getTypes();
    this.getTransmissions();
    this.getFuelTankTypes();
    console.log("AddCarForm mounted")
    console.log(this.$store.getters.getBrands);
  }
}
</script>

<style scoped>

</style>