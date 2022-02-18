<template>
  <div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <form @submit.prevent="buyNewCar">
            <div class="modal-header">
              <h3 class="modal-title" id="exampleModalLabel">Payment Form</h3>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="d-flex flex-column">
                <div class="d-flex align-self-center">
                  <h5>Personal info</h5>
                </div>
                <div class="d-flex flex-column mt-2">
                  <label>Name:</label>
                  <input type="text" class="form-control" required placeholder="Enter your name" v-model="name">
                </div>
                <div class="d-flex flex-column mt-2">
                  <label>Lastname:</label>
                  <input type="text" class="form-control" required placeholder="Enter your lastname" v-model="lastName">
                </div>
                <div class="d-flex flex-column mt-2">
                  <label>City:</label>
                  <input type="text" class="form-control" required placeholder="Enter your city" v-model="city">
                </div>
                <div class="d-flex flex-column mt-2">
                  <label>Address:</label>
                  <input type="text" class="form-control" required placeholder="Enter your address" v-model="address">
                </div>
                <div class="d-flex align-self-center mt-4">
                  <h5>Payment info</h5>
                </div>

                <button
                    @focus="handleFocus(creditCard)"
                    @focusout="handleFocusOut(creditCard)"
                    class="btn btn-outline-dark mb-1 d-flex justify-content-between m-auto"
                    style="width: 68%"
                    v-for="(creditCard) in creditCards"
                    :key="creditCard.transactionalNumber"
                    @click="selectTransactionToBuyWith(creditCard.transactionalNumber)"
                    :class="selectedCardNumber === creditCard.transactionalNumber ? 'active' :''">
                  <div class="d-flex m-auto">
                    <div class="d-flex">
                      <img :src="require('../../../assets/credit-card.png')" style="width: 50px;height: 50px"/>
                    </div>
                    <div class="ms-2 d-flex flex-column">
                      <small class="text-muted">Card number: {{ creditCard.transactionalNumber }}</small>
                      <small class="text-muted">Expiration date:
                        {{ creditCard.expirationMonth }}/{{ creditCard.expirationYear }}</small>
                    </div>
                  </div>
                </button>
                <div class="d-flex flex-column w-25 m-auto">
                  <label>CVV:</label>
                  <input type="text"
                         class="form-control"
                         required
                         placeholder="ex. 414"
                         v-model="cvvCode"/>
                </div>
                <div class="d-flex mt-4 m-auto">
                  <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse"
                          data-bs-target="#multiCollapseExample1" aria-expanded="false"
                          aria-controls="multiCollapseExample1">Add Credit Card
                  </button>
                </div>
                <div class="col mt-2">
                  <div class="collapse multi-collapse" id="multiCollapseExample1">
                    <div class="card card-body">
                      <form @submit.prevent="addCreditCard">
                        <div class="d-flex flex-column">
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
                                     v-model="cvvCodeForNew"/>
                            </div>
                          </div>
                        </div>
                        <div class="modal-footer mt-1">
                          <button type="submit" class="btn btn-outline-primary">Add New Credit Card</button>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button id="close" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-primary">Buy Car</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <AddCreditCardForm/>
  </div>
</template>

<script>
import paymentService from "@/repository/paymentRepository";
import AddCreditCardForm from "@/components/personal-profile/form/AddCreditCardForm";

export default {
  name: "PaymentModalForm",
  components: {AddCreditCardForm},
  props: ['carId', 'carPrice'],
  data() {
    return {
      creditCards: null,
      selectedCardNumber: "",
      transactionalNumber: '',
      expirationMonth: '',
      expirationYear: '',
      cvvCodeForNew: '',
      name: '',
      lastName: '',
      city: '',
      address: '',
      cvvCode: ''
    }
  },
  methods: {
    loadCreditCards() {
      paymentService.findAllCreditCardsByUser({
            username: this.$store.getters.getUser.username
          }
      ).then(response => {
        this.creditCards = response.data;
      })
    },
    selectTransactionToBuyWith(cardNumber) {
      console.log("hereTransss");
      this.selectedCardNumber = cardNumber;
    },
    handleFocus(cardNumber) {
      console.log("here");
      this.selectedCardNumber = cardNumber;
    },
    handleFocusOut() {
      console.log("outOfHere");
      // this.selectedCardNumber = ''
    },
    addCreditCard() {
      const username = this.$store.getters.getUser.username
      paymentService.addCreditCard({
        transactionalNumber: this.transactionalNumber,
        usernameDto: {username: username},
        cvvCode: this.cvvCodeForNew,
        expirationMonth: this.expirationMonth,
        expirationYear: this.expirationYear
      }).then(() => {
        this.loadCreditCards();
      })
      this.transactionalNumber = '';
      this.expirationMonth = '';
      this.expirationYear = '';
      this.cvvCode = '';
    },
    buyNewCar() {
      console.log("buyNewCar");
      paymentService.buyCarWithCreditCard({
        name: this.name,
        lastName: this.lastName,
        city: this.city,
        address: this.address,
        cardNumber: this.selectedCardNumber,
        cvvCode: this.cvvCode,
        usernameDto: {
          username: this.$store.getters.getUser.username
        },
        carPrice: this.carPrice,
        carId: this.carId
      }).then(() => {
        document.getElementById("close").click();
        document.getElementById("openSuccessfulModal").click();
      })
      this.selectedCardNumber = '';
      this.name = '';
      this.lastName = '';
      this.city = '';
      this.address = '';
      this.cvvCode = '';
    }
  },
  mounted() {
    this.loadCreditCards();
  }
}
</script>

<style scoped>

</style>