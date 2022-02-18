<template>
  <div class="rounded-end w-100" v-if="user">
    <div class="d-flex flex-column">
      <div class="text-center">
        <h1>Payment cards</h1>
      </div>
      <div class="mb-1 d-flex w-50 justify-content-between m-auto bg-light"
           v-for="(creditCard) in creditCards"
           :key="creditCard.transactionalNumber">
        <div class="d-flex">
          <div class="d-flex">
            <img :src="require('../../assets/credit-card.png')" style="width: 50px;height: 50px"/>
          </div>
          <div class="ms-2 d-flex flex-column">
            <small class="text-muted">Transaction number: {{ creditCard.transactionalNumber }}</small>
            <small class="text-muted">Expiration date:
              {{ creditCard.expirationMonth }}/{{ creditCard.expirationYear }}</small>
          </div>
        </div>
        <div>
          <button class="btn btn-outline-danger" @click="deleteCreditCard(creditCard.transactionalNumber)">Delete
          </button>
        </div>
      </div>
      <div class="d-flex mt-4 m-auto">
        <button class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Add Credit Card</button>
      </div>
    </div>
    <AddCreditCardForm v-if="modalVisibility"/>
  </div>
</template>

<script>
import AddCreditCardForm from "@/components/personal-profile/form/AddCreditCardForm";
import paymentService from "@/repository/paymentRepository";

export default {
  name: "PaymentInfo",
  components: {AddCreditCardForm},
  data() {
    return {
      user: null,
      modalVisibility: true,
      creditCards: null
    }
  },
  methods: {
    getUser() {
      this.user = this.$store.getters.getUser;
    },
    closeModal() {
      this.modalVisibility = false;
    },
    loadCreditCards() {
      paymentService.findAllCreditCardsByUser({
            username: this.user.username
          }
      ).then(response => {
        this.creditCards = response.data;
      })
    },
    deleteCreditCard(transactionalNumber) {
      paymentService.deleteCreditCard({
        cardNumber: transactionalNumber
      }).then(() => {
        this.loadCreditCards();
      })
    }
  }
  ,
  provide() {
    return {
      closeModal: this.closeModal,
      loadCreditCards: this.loadCreditCards
    }
  },
  mounted() {
    this.getUser();
    this.loadCreditCards();
  }
}
</script>

<style scoped>

</style>