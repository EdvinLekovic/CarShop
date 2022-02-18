<template>
  <div>
    <button id="openSuccessfulModal" type="button" class="btn btn-primary d-none" data-bs-toggle="modal" data-bs-target="#successfulModal">
      Launch static backdrop modal
    </button>

    <!-- Modal -->
    <div class="modal fade" id="successfulModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body text-center">
            <div>
              <font-awesome-icon icon="check-circle" class="text-success" style="width: 200px;height: 200px"/>
            </div>
            <div>
              <h1>Successful Payment!</h1>
              <h5>Thank you for your trust!</h5>
              <h5>Your car will be delivered from 2 to 4 weeks.</h5>
              <p class="fst-italic">Drive Safe</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessfulPaymentModal"
}
</script>

<style scoped>

</style>