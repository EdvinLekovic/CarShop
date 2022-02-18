<template>
  <div>
    <div class="d-flex bg-secondary justify-content-between align-items-center text-white "
         style="height: 100px;width: 100%">
      <div class="d-flex ms-3">
        <h3 class="me-2">{{ year }}</h3>
        <h3 class="me-2">{{ brand }}</h3>
        <h3 class="me-2">{{ model }}</h3>
      </div>
      <div class="d-flex justify-content-center">
        <div class="d-flex justify-content-center me-2">
          <h3 class="align-content-center">Price: ${{ price }}</h3>
        </div>
        <div class="d-flex me-5" style="width: 150px;">
          <!--          data-bs-toggle="modal" data-bs-target="#exampleModal"-->
          <button class="btn btn-danger w-100" data-bs-toggle="modal" data-bs-target="#exampleModal">Buy Now</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  components: {},
  props: ['year', "brand", "model", "price"],
  name: "TheCarInfoHeader",
  methods: {
    buyCar() {
      console.log("here");
      // document.getElementById("openModal").click();
    },
  },
}
</script>

<style scoped>
.sticky {
  position: -webkit-sticky;
  position: sticky;
  /* z-index: 1000; */
}
</style>