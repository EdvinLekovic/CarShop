import {createStore} from "vuex";
import mutations from "@/store/car-store/mutations";
import actions from "@/store/car-store/actions";
import getters from "@/store/car-store/getters";
import createPersistedState from 'vuex-persistedstate'

const store = createStore({
    plugins: [
        createPersistedState({
            storage: window.sessionStorage,
        })
    ],
    state() {
        return {
            brands: [],
            models: [],
            types: [],
            transmissions: [],
            fuelTankTypes: [],
            userAvailability: false,
            userToken: null,
            user: null,
            successModals: [],
            paymentForm: {
                personalInfo: {
                    name: '',
                    lastName: '',
                    city: '',
                    address: ''
                },
                paymentInfo: {
                    cardNumber: '',
                    expirationMonth: '',
                    expirationYear: '',
                    CVV: ''
                }
            }
        }
    },
    mutations: mutations,
    actions: actions,
    getters: getters
})

export default store;