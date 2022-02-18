<template>
  <div class="">
    <div class="services px-5 py-2 max-w mx-auto">
      <h1 class="display-5 ms-2 text-center">All unanswered service requests</h1>
      <h2 class="text-center mt-4" v-if="services.length === 0">No service request yet</h2>
      <div class="m-auto w-75">
        <Service v-for="s in services" :key="s.id" :service="s"/>
      </div>
    </div>
    <AddServiceRequestAnswerModal/>
  </div>
</template>

<script>
import AddServiceRequestAnswerModal from "@/components/services/AddServiceRequestAnswerModal";
import Service from "@/components/services/Service";
import serviceRequestService from "@/repository/serviceRequest";

export default {
  name: "ClientRequestServices",
  components: {AddServiceRequestAnswerModal, Service},
  data() {
    return {
      services: [],
    }
  },
  methods: {
    fetchAllUnansweredServices() {
      serviceRequestService.listAllUnAnsweredServiceRequests().then(response => {
        console.log(response.data);
        this.services = response.data;
      })
    }
  },
  mounted() {
    console.log("clientRequest");
    this.fetchAllUnansweredServices();
  }
}
</script>

<style scoped>

</style>