export default {
    getBrands(state) {
        return state.brands;
    },
    getTypes(state) {
        return state.types;
    },
    getTransmissions(state) {
        return state.transmissions;
    },
    getModels(state){
        return state.models;
    },
    getFuelTankTypes(state){
        return state.fuelTankTypes;
    },
    getUser(state){
        return state.user;
    },
    getUserToken(state){
        return state.userToken;
    },
    getSuccessModals(state){
        return state.successModals;
    }
}