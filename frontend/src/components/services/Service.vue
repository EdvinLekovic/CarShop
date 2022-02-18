<template>
  <div class="mb-2 m-2 ">
    <div class="border rounded p-2 bg-light">
      <div class="heading d-flex align-items-center">
        <h4 class="pe-4">Service type: {{ service.serviceType }}</h4>
        <div>Status : {{ service.serviceStatus }}</div>
      </div>
      <div class="border-bottom">Your description</div>

      <div class="pt-2">{{ service.description }}</div>
    </div>
    <div class="response p-2 pb-1 bg-white border">
      <div class="border-bottom">Response:</div>
      <div class="pt-2">
        {{ service.answer }}
      </div>
      <div>
        <button v-if="$store.getters.getUser.role === 'ADMIN'" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#addServiceAnswerModal">Reply</button>
      </div>
    </div>
    <AddServiceRequestAnswerModal :service-id="service.id"/>
  </div>
</template>

<script>
import AddServiceRequestAnswerModal from "@/components/services/AddServiceRequestAnswerModal";

export default {
  name: "Service",
  components: {AddServiceRequestAnswerModal},
  props: ["service"],
  data() {
    return {
      cars: [],
    };
  },
  mounted() {
    console.log(this.service);
  }
};
</script>

<style scoped>
</style>
