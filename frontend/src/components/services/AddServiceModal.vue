<template>
  <div>
    <!-- Button trigger modal -->
    <!--    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">-->
    <!--      Launch static backdrop modal-->
    <!--    </button>-->
    <!-- Modal -->
    <div class="modal fade" id="addServiceModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="d-flex flex-column">
              <label>Type of Service:</label>
              <select
                  class="form-select col-4"
                  v-model="serviceType"
                  aria-label="Default select example">
                <option v-for="opt in options" :key="opt" :value="opt">
                  {{ opt }}
                </option>
              </select>
            </div>
            <div class="d-flex flex-column">
              <label>Description:</label>
              <textarea class="form-control" v-model="description"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button id="close" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" @click="addService">Request Service</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import serviceRequestService from "@/repository/serviceRequest";

export default {
  name: "AddServiceModal",
  data() {
    return {
      serviceType: "21 Point Inspection",
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
      description: '',
    }
  },
  methods: {
    addService() {
      serviceRequestService.addServiceRequest({
        usernameDto: {
          username: this.$store.getters.getUser.username,
        },
        serviceType: this.serviceType,
        description: this.description
      }).then(() => {
        document.getElementById("close").click();
        this.$router.go(0);
      })
    }
  }

}
</script>

<style scoped>

</style>