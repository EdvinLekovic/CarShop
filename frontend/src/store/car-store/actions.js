export default {
    fetchBrands(context) {
        context.commit('fetchBrands');
    },
    fetchTypes(context) {
        context.commit("fetchTypes");
    },
    fetchTransmissions(context) {
        context.commit("fetchTransmissions");
    },
    fetchModels(context, brandName) {
        context.commit("fetchModels", brandName);
    },
    fetchFuelTankTypes(context) {
        context.commit("fetchFuelTankTypes");
    },
    authenticateUser(context, authRequest) {
        context.commit("authenticateUser", authRequest);
    },
    fetchUser(context, tokenRequest) {
        context.commit("fetchUser", tokenRequest);
    },
    checkTokenExpiration(context, tokenRequest) {
        context.commit("checkTokenExpiration", tokenRequest);
    },
    personalInfoForm(context, personalInfo) {
        context.commit("personalInfoForm", personalInfo);
    },
    paymentInfoForm(context, paymentInfo) {
        context.commit('paymentInfoForm', paymentInfo);
    },
    addSuccessModal(context, successModal) {
        context.commit('addSuccessModal', successModal);
    }
}