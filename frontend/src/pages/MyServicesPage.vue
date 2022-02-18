<template>
  <div class="">
    <div class="services px-5 py-2 max-w mx-auto">
      <h1 class="display-5 ms-2 text-center">Your services</h1>
      <h2 class="text-center mt-4" v-if="services.length === 0">No Services yet</h2>
      <Service v-else v-for="s in services" :key="s.id" :service="s"/>
      <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#addServiceModal">Add service
      </button>
    </div>
    <AddServiceModal/>
  </div>
</template>

<script>
import Service from "../components/services/Service";
import serviceRequestService from "@/repository/serviceRequest";
import AddServiceModal from "@/components/services/AddServiceModal";

export default {
  name: "ServicePage",
  components: {
    AddServiceModal,
    Service,
  },
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
        username: this.$store.getters.getUser.username
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
