<template>
  <div>
    <div class="d-flex flex-column shadow-lg ms-2 mt-2" style="height: 1000px;width: 300px">
      <h3 class="text-center bg-light pb-2 rounded-top">Filter cars</h3>
      <div class="ps-2 w-75">
        <div class="d-flex flex-column">
          <h5>Price:</h5>
          <div class="d-flex">
            <input class="form-control w-75"
                   name="number"
                   type="number"
                   id="priceFrom"
                   placeholder="From"
                   v-model="priceFrom">
            <h2>-</h2>
            <input class="form-control w-75"
                   name="number"
                   type="number"
                   id="priceTo"
                   placeholder="To"
                   v-model="priceTo">
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Brand</h5>
          <div class="form-check" v-for="brand in brands" :key="brand.name">
            <input class="form-check-input"
                   name="selectedBrand"
                   type="checkbox"
                   :value="brand"
                   :id="brand.name"
                   v-model="selectedBrands">
            <label class="form-check-label" :for="brand.name">
              {{ brand.name }}
            </label>
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Model</h5>
          <div class="form-check" v-for="model in models" :key="model.id">
            <input class="form-check-input"
                   name="model"
                   type="checkbox"
                   :value="model.name"
                   :id="model.id"
                   v-model="selectedModels">
            <label class="form-check-label" :for="model.name">
              {{ model.name }}
            </label>
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Car Type</h5>
          <div class="form-check" v-for="type in types" :key="type">
            <input class="form-check-input"
                   name="carType"
                   type="checkbox"
                   :value="type"
                   :id="type"
                   v-model="selectedTypes">
            <label class="form-check-label" :for="type">
              {{ type }}
            </label>
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Transmission</h5>
          <div class="form-check" v-for="transmission in transmissions" :key="transmission">
            <input class="form-check-input"
                   name="transmission"
                   type="checkbox"
                   :value="transmission"
                   :id="transmission"
                   v-model="selectedTransmissions">
            <label class="form-check-label" :for="transmission">
              {{ transmission }}
            </label>
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Fuel Tank Type</h5>
          <div class="form-check" v-for="fuelTankType in fuelTankTypes" :key="fuelTankType">
            <input class="form-check-input"
                   name="fuelTankType"
                   type="checkbox"
                   :value="fuelTankType"
                   :id="fuelTankType"
                   v-model="selectedFuelTankTypes">
            <label class="form-check-label" :for="fuelTankType">
              {{ fuelTankType }}
            </label>
          </div>
        </div>
        <div class="d-flex flex-column">
          <h5>Engine:</h5>
          <input class="form-control"
                 name="engine"
                 type="text"
                 id="engine"
                 placeholder="Enter the engine"
                 v-model="engine">
        </div>
        <div class="d-flex flex-column">
          <h5>Tires:</h5>
          <input class="form-control"
                 name="engine"
                 type="text"
                 id="tires"
                 placeholder="Enter tires"
                 v-model="tires">
        </div>
        <div class="d-flex flex-column">
          <h5>Emissions:</h5>
          <input class="form-control"
                 name="emissions"
                 type="number"
                 id="emissions"
                 placeholder="Enter the emissions"
                 v-model="emissions">
        </div>
        <div class="d-flex flex-column">
          <h5>Year:</h5>
          <input class="form-control"
                 name="emissions"
                 type="number"
                 id="year"
                 placeholder="Enter the year"
                 v-model="year">
        </div>
        <div class="d-flex flex-column mt-3">
          <button class="btn btn-secondary" @click="filterCars">Filter</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FilterBar",
  data() {
    return {
      brands: [],
      selectedBrands: [],
      models: [],
      selectedModels: [],
      types: [],
      selectedTypes: [],
      transmissions: [],
      selectedTransmissions: [],
      fuelTankTypes: [],
      selectedFuelTankTypes: [],
      engine: '',
      tires: '',
      emissions: '',
      priceFrom: '',
      priceTo: '',
      year: '',
    }
  },
  watch: {
    selectedBrands() {
      console.log(this.selectedBrands);
      if (this.selectedBrands.length > 0) {
        this.models = this.selectedBrands.flatMap(brand => brand.models);
      } else {
        this.selectedModels = [];
        this.models = [];
      }
    }
  },
  methods: {
    filterCars() {
      this.$emit('filterCars', {
        priceFrom: this.priceFrom,
        priceTo: this.priceTo,
        brands: this.selectedBrands.map(brand => brand.name),
        models: this.selectedModels,
        types: this.selectedTypes,
        transmissions: this.selectedTransmissions,
        fuelTankTypes: this.selectedFuelTankTypes,
        engine: this.engine,
        tires: this.tires,
        emissions: this.emissions,
        year: this.year
      })
    },
    getBrands() {
      console.log("Brands:")
      this.brands = this.$store.getters.getBrands;
      // this.models = this.brands[0].models;
    },
    getTypes() {
      this.types = this.$store.getters.getTypes;
    },
    getTransmissions() {
      this.transmissions = this.$store.getters.getTransmissions;
    },
    getFuelTankTypes() {
      this.fuelTankTypes = this.$store.getters.getFuelTankTypes;
    }

  },
  mounted() {
    this.getBrands();
    this.getTypes();
    this.getTransmissions();
    this.getFuelTankTypes();
  }
}
</script>

<style scoped>

</style>