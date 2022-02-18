import axios from "@/custom-axios/axios";
import {carsPage} from "@/utils/constants";

const carService = {
    fetchAllCars: () => {
        return axios.get(carsPage);
    },
    fetchAllCarTypes: () => {
        return axios.get(carsPage + '/car-types');
    },
    fetchAllFuelTankTypes: () => {
        return axios.get(carsPage + '/fuel-tank-types')
    },
    fetchAllTransmissions: () => {
        return axios.get(carsPage + '/transmissions');
    },
    fetchAllBrands: () => {
        return axios.get(carsPage + "/brands");
    },
    fetchAllModelsByBrand: (brandName) => {
        return axios.get(carsPage + `/brands/${brandName}`);
    },
    getCarById: (id) => {
        return axios.get(carsPage + `/${id}`)
    },
    addCar: (car) => {
        //car should be an object with params
        console.log("Before sending axios.post");
        console.log(car);
        return axios.post(carsPage + '/add-car', car);
    },
    getImage(carId, index) {
        return axios.get(carsPage + `/get-images-by-car-id/${carId}/${index}`, {
            responseType: 'blob'
        })
    },
    editCar: (editCar) => {
        return axios.post(carsPage + "/edit-car", editCar);
    },
    deleteCar: (id) => {
        return axios.delete(carsPage + `/delete-car/${id}`);
    },

    fetchUsersPurchasedCars: (usernameDto) => {
        return axios.post(carsPage + "/users-cars", usernameDto);
    },
    quantityOfOwningSameCarModel: (usernameDto, carId) => {
        return axios.post(carsPage + `/number-of-owning-same-model/${carId}`,usernameDto);
    }

}


export default carService;