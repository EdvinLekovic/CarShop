<template>
  <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
       aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="d-flex flex-column">
            <div class="d-flex mt-2">
              <img :src="require('@/assets/credit-cards.png')" class="img-fluid" style="height: 50px;width: 50px">
            </div>
            <div class="d-flex flex-column mt-2">
              <label>Transactional card number:</label>
              <input type="text"
                     class="form-control"
                     required
                     placeholder="Enter transactional number"
                     v-model="transactionalNumber"/>
            </div>
            <div class="d-flex mt-2 justify-content-between">
              <div class="d-flex flex-column">
                <label>Expiration Date:</label>
                <div class="d-flex">
                  <input type="number"
                         class="form-control w-25 me-2"
                         required
                         placeholder="MM"
                         v-model="expirationMonth"/>
                  <input type="number"
                         class="form-control w-25"
                         required
                         placeholder="YYYY"
                         v-model="expirationYear"/>
                </div>
              </div>
              <div class="d-flex flex-column w-25">
                <label>CVV:</label>
                <input type="text"
                       class="form-control"
                       required
                       placeholder="ex. 414"
                       v-model="cvvCode"/>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button id="close" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" @click="addCreditCard">Add credit card</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import paymentService from "@/repository/paymentRepository";

export default {
  name: "AddCreditCardForm",
  inject: ['loadCreditCards'],
  data() {
    return {
      transactionalNumber: '',
      expirationYear: '',
      expirationMonth: '',
      cvvCode: ''
    }
  },
  methods: {
    addCreditCard() {
      const username = this.$store.getters.getUser.username
      paymentService.addCreditCard({
        transactionalNumber: this.transactionalNumber,
        usernameDto: {username: username},
        cvvCode: this.cvvCode,
        expirationMonth: this.expirationMonth,
        expirationYear: this.expirationYear
      }).then(() => {
        this.loadCreditCards();
        document.getElementById("close").click();
        this.transactionalNumber = '';
        this.cvvCode = '';
        this.expirationYear = '';
        this.expirationMonth = '';
      })
    }
  }

}
</script>

<style scoped>

</style>