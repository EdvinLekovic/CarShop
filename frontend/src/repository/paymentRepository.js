import axios from "@/custom-axios/axios";
import {paymentResource} from "@/utils/constants";

const paymentService = {
    findAllCreditCardsByUser: (usernameDto) => {
        return axios.post(paymentResource, usernameDto);
    },
    findCreditCardByCardNumber: (creditCardNumberDto) => {
        return axios.post(paymentResource+'/get-credit-card-by-number', creditCardNumberDto);
    },
    buyCarWithCreditCard: (paymentForm) => {
        return axios.post(paymentResource+'/buy-car', paymentForm);
    },
    addCreditCard: (creditCardDto) => {
        return axios.post(paymentResource+'/add-credit-card',creditCardDto);
    },
    deleteCreditCard: (creditCardNumberDto) => {
        return axios.post(paymentResource+"/delete-credit-card",creditCardNumberDto);
    }

}

export default paymentService;


