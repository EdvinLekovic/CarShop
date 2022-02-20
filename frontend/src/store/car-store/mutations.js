import carService from "@/repository/carRepository";
import userService from "@/repository/userRepository";

export default {
    fetchBrands(state) {
        carService.fetchAllBrands().then(data => {
            console.log(data.data);
            state.brands = data.data
        });
    },
    fetchTypes(state) {
        carService.fetchAllCarTypes().then(response => {
            state.types = response.data;
        })
    },
    fetchTransmissions(state) {
        carService.fetchAllTransmissions().then(response => {
            state.transmissions = response.data;
        })
    },
    fetchModels(state, brandName) {
        carService.fetchAllModelsByBrand(brandName).then(response => {
            state.models = response.data;
        })
    },
    fetchFuelTankTypes(state) {
        carService.fetchAllFuelTankTypes().then(response => {
            state.fuelTankTypes = response.data;
        });
    },
    authenticateUser(state, authRequest) {
        console.log("authenticateUser");
        userService.authenticate({username: authRequest.username, password: authRequest.password})
            .then(response => {
                state.userToken = response.data;
                this.commit('checkTokenExpiration', {token: state.userToken, thisObj: authRequest.thisObj});
            })
    },
    checkTokenExpiration(state, tokenRequest) {
        console.log("checkTokenExpiration");
        userService.checkTokenExpiration({token: tokenRequest.token}).then(response => {
                state.userAvailability = response.data;
                console.log(state.userAvailability);
                if (state.userAvailability) {
                    this.commit("fetchUser", {token: tokenRequest.token, thisObj: tokenRequest.thisObj})
                } else {
                    state.userToken = null;
                }
            }
        )
    },
    fetchUser(state, tokenRequest) {
        console.log("fetchUser enter");
        userService.getUserByToken({token: tokenRequest.token}).then(response => {
            if (response.status === 200) {
                console.log("user returned");
                state.user = response.data;
                console.log(state.user);
                if (tokenRequest.thisObj.$router.currentRoute.value.path === '/login' &&
                    tokenRequest.thisObj.$router.options.history.state.back !== '/register') {
                    tokenRequest.thisObj.$router.back();
                }
            }
        })
    },
    personalInfoForm(state, personalInfo) {
        state.paymentForm.personalInfo = personalInfo;
    },
    paymentInfoForm(state, paymentInfo) {
        state.paymentForm.paymentInfo = paymentInfo;
    },
    addSuccessModal(state, successModal) {
        state.successModals.push(successModal);
    }
}