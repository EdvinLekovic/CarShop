<template>
  <div>
    <!-- Button trigger modal -->
    <!--    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">-->
    <!--      Launch static backdrop modal-->
    <!--    </button>-->
    <!-- Modal -->
    <div class="modal fade" id="addServiceAnswerModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Answer the service</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="d-flex flex-column">
              <label>Description:</label>
              <textarea class="form-control" v-model="description"></textarea>
            </div>
          </div>
          <div class="modal-footer">
            <button id="close" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" @click="addAnswer">Reply</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import serviceRequestService from "@/repository/serviceRequest";

export default {
  name: "AddServiceRequestAnswerModal",
  props: ['serviceId'],
  data() {
    return {
      description: '',
    }
  },
  methods: {
    addAnswer() {
      serviceRequestService
          .addAnswerOnQuestion({answer: this.description}, this.serviceId)
          .then(() => {
            document.getElementById("close").click();
            this.$router.go(0);
          })
    }
  }
}
</script>

<style scoped>

</style>