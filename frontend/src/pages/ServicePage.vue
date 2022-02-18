<template>
  <div>
    <div
        class="container-fluid mx-auto mt-5 mb-5 col-12"
        style="text-align: center"
    >
      <div class="hd">Why People Believe in Us</div>
      <p>
        <small
        >Always render more and better service than <br/>is expected of you,
          no matter what your ask may be.</small
        >
      </p>
      <div class="row" style="justify-content: center">
        <div class="card col-md-3 col-12">
          <div class="card-content">
            <div class="card-body">
              <img class="img" src="https://i.imgur.com/S7FJza5.png"/>
              <div class="shadow"></div>
              <div class="card-title">We're Hardowkring</div>
              <div class="card-subtitle">
                <p>
                  <small
                  >We spent thousands of hours over the year to please our
                    customers. And the word of mouth speaks for itself</small
                  >
                </p>
              </div>
            </div>
          </div>
        </div>
        <div class="card col-md-3 col-12 ml-2">
          <div class="card-content">
            <div class="card-body">
              <img class="img" src="https://i.imgur.com/xUWJuHB.png"/>
              <div class="card-title">We're Unbiased</div>
              <div class="card-subtitle">
                <p>
                  <small>
                    We take any work needed, and we dont ask many questions
                    besides what we need to know about the car. Many payment
                    options available
                  </small>
                </p>
              </div>
            </div>
          </div>
        </div>
        <div class="card col-md-3 col-12 ml-2">
          <div class="card-content">
            <div class="card-body">
              <img class="img rck" src="https://i.imgur.com/rG3CGn3.png"/>
              <div class="card-title">We Guide you</div>
              <div class="card-subtitle">
                <p>
                  <small
                  >Future help with small issues is on us and its free. If you also seek advice or want to discuss about
                    a new car we got you.</small
                  >
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="ft">
        <p class="chk"><small>Still not sure?</small></p>
        <button v-if="$store.getters.getUser" class="btn-primary btn" data-bs-toggle="modal" data-bs-target="#addServiceModal">Request a service</button>
      </div>
    </div>
    <div class="container">
      <h1 style="text-align: center">Our services</h1>
      <div
          class="list-group"
          style="max-width: 800px; margin-left: auto; margin-right: auto"
      >
        <a
            class="list-group-item list-group-item-action flex-column align-items-start bg-light"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">21 Point Inspection</h5>
            <small>$344</small>
          </div>
          <p class="mb-1">
            Complete inspection of your car to makes sure everything is in place and good to go
          </p>
          <small>We also help you pass the laws required</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Oil & Filter Change</h5>
            <small>$1599</small>
          </div>
          <p class="mb-1">
            Oil changes should be done often
          </p>
          <small>We cover a wide range of oil for all types of vehicles</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start bg-light"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">PA State Inspection</h5>
            <small>$700</small>
          </div>
          <p class="mb-1">
            We can help you with PA state inspections
          </p>
          <small>Our close relations to the gonverment come in handy</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">PA Emissions Inspection</h5>
            <small>$311</small>
          </div>
          <p class="mb-1">
            We have the latest gear and in 20 min we can measure your car emissions and see if the are up to par
          </p>
          <small>We are conducting this test at least 2 times daily in our shop</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start bg-light"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Rotate Tires</h5>
            <small>$3400</small>
          </div>
          <p class="mb-1">
            Get a handle of your tires to make sure your roads are safe
          </p>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Rotate & Balance Tires</h5>
            <small>$223</small>
          </div>
          <p class="mb-1">
            Donec id elit non mi porta gravida at eget metus. Maecenas sed diam
            eget risus varius blandit.
          </p>
          <small>Donec id elit non mi porta.</small>
        </a>
        <a class="list-group-item list-group-item-action flex-column align-items-start bg-light">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Four Wheel Alingment</h5>
            <small>$3000</small>
          </div>
          <p class="mb-1">
            Donec id elit non mi porta gravida at eget metus. Maecenas sed diam
            eget risus varius blandit.
          </p>
          <small>Donec id elit non mi porta.</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Tire Repair</h5>
            <small>$39</small>
          </div>
          <p class="mb-1">
            Donec id elit non mi porta gravida at eget metus. Maecenas sed diam
            eget risus varius blandit.
          </p>
          <small>Donec id elit non mi porta.</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start bg-light"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Cooling System Service</h5>
            <small>$350</small>
          </div>
          <p class="mb-1">
            Donec id elit non mi porta gravida at eget metus. Maecenas sed diam
            eget risus varius blandit.
          </p>
          <small>Donec id elit non mi porta.</small>
        </a>
        <a
            class="list-group-item list-group-item-action flex-column align-items-start"
        >
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Brake Fluid Service</h5>
            <small>$200</small>
          </div>
          <p class="mb-1">
            Donec id elit non mi porta gravida at eget metus. Maecenas sed diam
            eget risus varius blandit.
          </p>
          <small>Donec id elit non mi porta.</small>
        </a>
      </div>
    </div>
    <AddServiceModal/>
  </div>
</template>

<script>

import serviceRequestService from "@/repository/serviceRequest";
import AddServiceModal from "@/components/services/AddServiceModal";

export default {
  name: "ServicePage",
  components: {AddServiceModal},
  data() {
    return {
      user: null,
      textareaInput: "",
      options: [
        "21 Point Inspection",
        "Oil & Filter Change",
        "PA State Inspection",
        "PA Emissions Inspection",
        "Rotate Tires",
        "Rotate & Balance Tires",
        "Tire Repair",
        "Four Wheel Alingment",
        "Brake Fluid Service",
        "Cooling System Service",
      ],
      selectedOption: "Select Service",
      services: [],
    };
  },
  computed: {
    disableButton() {
      return !(
          this.textareaInput && this.options.includes(this.selectedOption)
      );
    },
  },
  methods: {
    getUser() {
      this.user = this.$store.getters.getUser;
    },
    addService() {
      serviceRequestService.addServiceRequest({
        usernameDto: {
          username: this.user.username,
        },
        serviceType: this.selectedOption,
        description: this.textareaInput
      }).then(() => {
        this.$router.go(0);
      })
    },
    fetchServicesByUser() {
      serviceRequestService.listAllServiceRequestsByUsername({
        username: this.$store.getters.getUser
      }).then(response => {
        this.services = response.data;
      })
    }
  },
  mounted() {
    // {
    //   usernameDto:{username:''},
    //   description:''
    // }
    //
    this.fetchServicesByUser();
  },
};
</script>

<style scoped>
.w-70 {
  width: 70%;
}

.btn-container {
  height: 280px;
}

.max-w {
  max-width: 960px;
}
</style>

