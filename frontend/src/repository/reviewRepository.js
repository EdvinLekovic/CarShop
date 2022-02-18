import axios from "@/custom-axios/axios";
import {reviewResource} from "@/utils/constants";

const reviewService = {
    fetchAllReviews: () => {
        return axios.get(reviewResource);
    },
    addReview: (reviewDto) => {
        return axios.post(reviewResource + "/add-review", reviewDto);
    },
    deleteReview: (reviewId) => {
        return axios.post(reviewResource + `/delete-review`, reviewId);
    },
    getImage: (reviewId) => {
        return axios.get(reviewResource + `/review-image/${reviewId}`, {
            responseType: 'blob'
        });
    }
}

export default reviewService;