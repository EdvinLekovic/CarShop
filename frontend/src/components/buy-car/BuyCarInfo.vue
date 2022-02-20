<template>
  <div v-if="car">
    <TheCarInfoHeader :brand="car.brand.name"
                      :model="car.model.name"
                      :price="car.price"
                      :year="car.year"/>
    <PaymentModalForm v-if="$store.getters.getUser" :carId="car.id" :carPrice="car.price"/>
    <SuccessfulPaymentModal/>
    <div>
      <div class="d-flex border-secondary border justify-content-between m-auto"
           style="height: 650px">
        <div class="d-flex flex-column w-25 border-dark border bg-dark just" style="height: 100%">
          <div class="d-flex m-4">
            <div class="d-flex flex-column h-100 me-2 text-white">
              <h1 class="d-flex">Description</h1>
              <p class="d-flex text-break mt-3">
                {{ car.description }}
              </p>
            </div>
          </div>
        </div>
        <div class="d-flex w-75">
          <div id="carouselExampleIndicators" class="carousel slide w-100 h-100" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button type="button"
                      v-for="(image,index) in images"
                      :key="image"
                      data-bs-target="#carouselExampleIndicators"
                      :data-bs-slide-to="index"
                      class="active"
                      aria-current="true"
                      :aria-label="slides(index)"></button>
            </div>
            <div class="carousel-inner w-100 h-100">
              <div class="carousel-item active w-100 h-100">
                <img :src="images[0]" class="d-block w-100 h-100">
              </div>
              <div class="carousel-item w-100 h-100" v-for="image in images.slice(1)" :key="image">
                <img :src="image" class="d-block w-100 h-100">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>

      <div class="d-flex flex-column text-white" style="height: 500px;background-color: darkgray">
        <div class="align-self-center pt-5">
          <h1>Car Features</h1>
        </div>
        <div class="d-flex justify-content-around ms-3 me-3 mt-5 titles">
          <div class="d-flex flex-column">
            <div class="mb-4">
              <h2 class="small">Car Type</h2>
              <h3>{{ car.carType }}</h3>
            </div>
            <div class="mb-4">
              <h2 class="small">Fuel Tank Type</h2>
              <h3>{{ car.fuelTankType }}</h3>
            </div>
          </div>
          <div class="d-flex flex-column">
            <div class="mb-4">
              <h2 class="small">Transmission</h2>
              <h3>{{ car.transmission }}</h3>
            </div>
            <div class="mb-4">
              <h2 class="small">Tires type</h2>
              <h3>{{ car.tires }}</h3>
            </div>
          </div>
          <div class="d-flex flex-column">
            <div class="mb-4">
              <h2 class="small">Engine</h2>
              <h3>{{ car.engine }}</h3>
            </div>
            <div class="mb-4">
              <h2 class="small">Emissions</h2>
              <h3>{{ car.emissions }}</h3>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import carService from "@/repository/carRepository";
import TheCarInfoHeader from "@/components/navigation/TheCarInfoHeader";
import PaymentModalForm from "@/components/buy-car/form/PaymentModalForm";
import SuccessfulPaymentModal from "@/components/buy-car/form/SuccessfulPaymentModal";

export default {
  name: "BuyCarInfo",
  components: {SuccessfulPaymentModal, TheCarInfoHeader, PaymentModalForm},
  props: ['id'],
  data() {
    return {
      car: null,
      images: []
    }
  },
  methods: {
    slides(index) {
      return "Slide " + index;
    },
    getCarById() {
      carService.getCarById(this.id).then(response => {
        this.car = response.data;
        console.log("carInfoPage");
        console.log(this.car);
        this.getAllImages();
      })
    },
    getAllImages() {
      for (let i = 0; i < this.car.images.length; i++) {
        carService.getImage(this.car.id, i).then(response => {
          let reader = new FileReader();
          reader.readAsDataURL(response.data);
          reader.onload = () => {
            this.images.push(reader.result);
          }
        })
      }
    }
  },
  created() {
    console.log("buy-car-info created");
  },
  mounted() {
    console.log("here");
    this.getCarById();
  }
}
</script>

<style scoped>
.font-style {
  font-family: sans-serif;
}

.titles h2 {
  color: darkslategray;
}

</style>