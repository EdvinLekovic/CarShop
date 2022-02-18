import axios from "@/custom-axios/axios";
import {serviceResource} from "@/utils/constants";

const serviceRequestService = {
    listAllUnAnsweredServiceRequests: () => {
        return axios.get(serviceResource);
    },
    listAllServiceRequestsByUsername: (usernameDto) => {
        console.log(usernameDto);
        return axios.post(serviceResource + "/list-by-user", usernameDto);
    },
    addServiceRequest: (serviceRequestDto) => {
        return axios.post(serviceResource + "/add-service-request", serviceRequestDto);
    },
    editServiceRequest: (serviceRequestDto, serviceId) => {
        return axios.post(serviceResource + `/edit-service-request/${serviceId}`)
    },
    deleteServiceRequest: (serviceId) => {
        return axios.delete(serviceResource + `/delete-service-request/${serviceId}`);
    },
    addAnswerOnQuestion: (answerDto, serviceId) => {
        return axios.post(serviceResource + `/answer-service-request/${serviceId}`, answerDto);
    }
}

export default serviceRequestService;