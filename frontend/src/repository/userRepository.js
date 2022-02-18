import axios from "@/custom-axios/axios";
import {userResource} from "@/utils/constants";

const userService = {
    register:(userDto) => {
        return axios.post(userResource + '/register',userDto);
    },
    authenticate:(authRequest) => {
        return axios.post(userResource+"/authenticate",authRequest);
    },
    getUserByToken: (tokenRequest) => {
        return axios.post(userResource+'/get-user-by-token',tokenRequest);
    },
    checkTokenExpiration:(tokenRequest) => {
        return axios.post(userResource+"/user-expiration",tokenRequest);
    },
    userChanges(userDto){
        return axios.post(userResource+'/edit-user',userDto);
    }
}

export default userService;