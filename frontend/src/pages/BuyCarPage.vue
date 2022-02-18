<template>
  <div>
    <!--    <h1>Buy Car Page</h1>-->
    <div v-if="filteredCars">
      <div class="d-flex justify-content-center mt-5">
        <router-link class="btn btn-secondary w-25" to="/add-car" v-if="$store.getters?.getUser?.role === 'ADMIN'">Add Car</router-link>
      </div>
      <div class="d-flex">
        <FilterBar @filterCars="filterCars"/>
        <BuyCarList :cars="filteredCars"></BuyCarList>
      </div>
    </div>
  </div>
</template>

<script>
import carService from "@/repository/carRepository";
import BuyCarList from "@/components/buy-car/BuyCarList";
import FilterBar from "@/components/UI/FilterBar";

export default {
  name: "BuyCarPage",
  components: {FilterBar, BuyCarList},
  data() {
    return {
      cars: [],
      filteredCars: []
    }
  },
  methods: {
    listCars() {
      carService.fetchAllCars().then(response => {
        // console.log("listCars");
        this.cars = response.data;
        this.filteredCars = this.cars;
        console.log(this.cars);
      })
    },
    deleteCar(id) {
      carService.deleteCar(id).then(() => {
        this.listCars();
      })
    },
    filterCars(filterObj) {
      this.filteredCars = this.cars
      console.log(this.filteredCars);
      console.log("Filter obj");
      console.log(filterObj);
      if (filterObj) {

        if (filterObj.priceFrom !== '' && filterObj.priceTo !== '') {
          this.filteredCars = this.filteredCars.filter(car => car.price >= filterObj.priceFrom && car.price <= filterObj.priceTo);
        } else if (filterObj.priceFrom === '' && filterObj.priceTo !== '') {
          this.filteredCars = this.filteredCars.filter(car => car.price <= filterObj.priceTo);
        } else if (filterObj.priceFrom !== '' && filterObj.priceTo === '') {
          this.filteredCars = this.filteredCars.filter(car => car.price >= filterObj.priceFrom);
        }

        if (filterObj.brands.length > 0) {
          this.filteredCars = this.filteredCars.filter(car => filterObj.brands.includes(car.brand.name));
        }

        if (filterObj.models.length > 0) {
          this.filteredCars = this.filteredCars.filter(car => filterObj.models.includes(car.model.name))
        }

        if (filterObj.types.length > 0) {
          this.filteredCars = this.filteredCars.filter(car => filterObj.types.includes(car.carType));
        }

        if (filterObj.transmissions.length > 0) {
          this.filteredCars = this.filteredCars.filter(car => filterObj.transmissions.includes(car.transmission))
        }

        if (filterObj.fuelTankTypes.length > 0) {
          this.filteredCars = this.filteredCars.filter(car => filterObj.fuelTankTypes.includes(car.fuelTankType));
        }

        if (filterObj.engine !== '') {
          this.filteredCars = this.filteredCars.filter(car => car.engine.toLowerCase().includes(filterObj.engine.toLowerCase()));
        }

        if (filterObj.tires !== '') {
          this.filteredCars = this.filteredCars.filter(car => car.tires.toLowerCase().includes(filterObj.tires.toLowerCase()));
        }

        if (filterObj.emissions !== '') {
          this.filteredCars = this.filteredCars.filter(car => filterObj.emissions === car.emissions);
        }

        if (filterObj.year !== '') {
          this.filteredCars = this.filteredCars.filter(car => filterObj.year === car.year);
        }
      }
    }
  },
  provide() {
    return {
      deleteCar: this.deleteCar
    }
  },
  mounted() {
    // console.log("CarPage mounted");
    this.listCars();
  }

}
</script>

<style scoped>

</style>