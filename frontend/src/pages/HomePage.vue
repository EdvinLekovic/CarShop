<template>
  <div>
    <div class="p-5 mb-4 bg-light hero d-flex align-items-start">
      <div class="py-5 bg-light rounded w-md-100 smaller-on-big p-4"
           style="max-width: 300px">
        <h4 class="display-6 fw-bold">
          You choose your car online. We inspect it and deliver it.
        </h4>
      </div>
    </div>

    <div class="container px-4 py-5" id="hanging-icons">
      <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em">
              <use xlink:href="#toggles2"></use>
            </svg>
          </div>
          <div>
            <h2>We own all the cars before you buy</h2>
            <p>
              We own all the cars before your purchase and we are liable for
              them. You only talk to Carvago, in your language.
            </p>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em">
              <use xlink:href="#cpu-fill"></use>
            </svg>
          </div>
          <div>
            <h2>Our car-screening system</h2>
            <p>
              A unique way of checking cars all over Europe through qualified
              technicians, and with our smart Application
            </p>
          </div>
        </div>
        <div class="col d-flex align-items-start">
          <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
            <svg class="bi" width="1em" height="1em">
              <use xlink:href="#tools"></use>
            </svg>
          </div>
          <div>
            <h2>Smart application for dealers</h2>
            <p>
              Artificial intelligence will help you make better purchase and
              sale decisions, makes recommendations on the most profitable and
              sellable cars and much more
            </p>
          </div>
        </div>
      </div>
    </div>

    <div class="container px-4 pb-5" id="custom-cards">
      <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 pb-5">
        <div class="col">
          <div
              class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg"
              style="
              background-image: url('https://media.istockphoto.com/photos/dealer-new-cars-stock-picture-id480652712?b=1&k=20&m=480652712&s=170667a&w=0&h=dcmAjMGPXz8YFjCfhjJi8icIe-LGmOX6LuCaTXpyFJA=');
            "
          >
            <div
                class="d-flex flex-column h-100 p-2 pb-3 text-white text-shadow-1"
            >
              <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">
                More than 2milion cars
              </h2>
              <ul class="d-flex list-unstyled mt-auto">
                <li class="me-auto">
                  <img
                      src="https://img.lovepik.com/free-png/20210926/lovepik-car-icon-png-image_401452256_wh1200.png"
                      alt="Bootstrap"
                      width="32"
                      height="32"
                      class="rounded-circle border border-white"
                  />
                </li>
              </ul>
            </div>
          </div>
        </div>

        <div class="col">
          <div
              class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg"
              style="
              background-image: url('https://images.pexels.com/photos/302769/pexels-photo-302769.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500');
            "
          >
            <div
                class="d-flex flex-column h-100 p-2 pb-3 text-white text-shadow-1"
            >
              <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">
                4 subsidiaries
              </h2>
              <ul class="d-flex list-unstyled mt-auto">
                <li class="me-auto">
                  <img
                      src="https://media.istockphoto.com/vectors/subsidiary-concept-small-business-unit-branches-vector-line-icon-vector-id1311227735?k=20&m=1311227735&s=612x612&w=0&h=8B7LB8Gj52ro432SMIWq_QPa0-iJ5SjlPIopRuJsKF8="
                      alt="Subsidiaries"
                      width="32"
                      height="32"
                      class="rounded-circle border border-white"
                  />
                </li>
              </ul>
            </div>
          </div>
        </div>

        <div class="col">
          <div
              class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg"
              style="
              background-image: url('https://media.istockphoto.com/photos/planet-earth-at-night-city-lights-of-europe-glowing-in-the-dark-picture-id1299972938?b=1&k=20&m=1299972938&s=170667a&w=0&h=zMbfARWNqkm0CQLZcQpsUzJ0ES8e0bXc5imrIN4hQxI=');
            "
          >
            <div class="d-flex flex-column h-100 p-2 pb-3 text-shadow-1">
              <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">
                We operate in 6 European countries
              </h2>
              <ul class="d-flex list-unstyled mt-auto">
                <li class="me-auto">
                  <img
                      src="https://spng.subpng.com/20201006/czf/transparent-european-union-icon-flags-icon-europe-icon-5f7c846d617107.3779743316019958853991.jpg"
                      alt="Europe"
                      width="32"
                      height="32"
                      class="rounded-circle border border-white"
                  />
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>

export default {
  name: "HomePage",
  mounted() {
    console.log(this.$router.currentRoute.value.path);
    console.log(this.$router.options.history.state.back);
  }
};
</script>

<style scoped>
.hero {
  background-size: cover;
  background-image: url("https://st.focusedcollection.com/14026668/i/1800/focused_180235988-stock-photo-two-men-car-dealer-digital.jpg");
}
</style>
