<template>
  <div class="d-flex flex-column m-2 rounded-1 shadow-lg mb-5 bg-body" style="height: 400px;width: 350px;">
    <div class="d-flex">
      <img :src="image" style="width: 350px;height: 190px;max-width: 350px;max-height: 190px" class="rounded-top">
    </div>
    <div class="d-flex flex-column ps-2">
      <h5 class="text-center">{{ car.brand.name }} {{ car.brand?.models[0]?.name }}</h5>
      <h6>Year: {{ car.year }}</h6>
      <h4>Price: ${{ car.price }}</h4>
      <div class="flex m-auto">
        <div class="flex justify-content-end">
          <router-link class="flex btn btn-dark m-1" :to="linkToMore">More info</router-link>
          <button class="btn btn-danger m-1" @click="deleteCar(car.id)">
            <font-awesome-icon :icon="['trash']" style="width: 20px;height: 20px"/>
          </button>
          <router-link class="btn btn-primary m-1" :to="editLink">Edit</router-link>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column justify-content-center">
    </div>
  </div>
</template>

<script>

import carService from "@/repository/carRepository";

export default {
  props: ['car'],
  inject: ['deleteCar'],
  data() {
    return {
      image: null
    }
  },
  name: "BuyCarItem",
  computed: {
    linkToMore() {
      // return "/buy-car/" + this.car.id;
      console.log('here');
      console.log(this.car.id);
      return {
        name: 'buy-car-info',
        params: {
          id: this.car.id
        }
      }
    },
    editLink() {
      return '/edit-car/' + this.car.id;
    }
  },
  methods: {
    getAllImages() {
      carService.getImage(this.car.id, 0).then(response => {
        let reader = new FileReader();
        reader.readAsDataURL(response.data);
        reader.onload = () => {
          this.image = reader.result;
        }
      })
    }
  },
  mounted() {
    console.log("mounted CartItem")
    this.getAllImages();
  }
}
</script>

<style scoped>

</style>