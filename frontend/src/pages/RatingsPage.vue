<template>
  <div class="ratings-page">
    <div class="container-fuid">
      <div
          class="row p-4 pt-lg-5 align-items-center rounded-3 border shadow-lg"
      >
        <div class="col-lg-5 p-3">
          <h4 class="my-5">CarShop Reviews</h4>
          <h1 class="">What do your customers say about us?</h1>
          <button
              data-bs-toggle="modal"
              data-bs-target="#myModal1"
              v-if="userExists()"
              class="mt-2 btn btn-primary"
              type="button"
          >
            Add your rating
          </button>
        </div>
        <div class="col-lg-6 offset-lg-1 p-0 overflow-hidden shadow-lg">
          <img
              class="rounded-lg-3"
              src="https://media.istockphoto.com/photos/young-couple-buying-a-car-picture-id988321834?k=20&m=988321834&s=612x612&w=0&h=FLeWmtawea0xmNkDkbKol_MugZRacWyoPe8V5kgLbfc="
              alt=""
              width="720"
          />
        </div>
      </div>
    </div>
    <div class="d-flex">
      <div class="d-flex flex-wrap  p-2 mt-5 mx-auto h-100" data-masonry>
        <RatingReview
            v-for="review in reviews"
            :review="review"
            :key="review.id"
        />
      </div>
    </div>

    <div>
      <div
          class="modal fade"
          id="myModal1"
          tabindex="-1"
          aria-labelledby="myModal1Label"
          aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="myModal1Label">Your Review</h5>
              <button
                  type="button"
                  class="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <div class="selects">
                <div class="row pt-4">
                  <div class="col-6">
                    <label>Brand:</label>
                    <select
                        class="form-select col-6"
                        aria-label="Default select example"
                        v-model="selectedBrand">
                      <option v-for="brand in brands"
                              :key="brand.name"
                              :value="brand">{{ brand.name }}
                      </option>
                    </select>
                  </div>
                  <div class="col-6">
                    <label>Model:</label>
                    <select
                        class="form-select col-6"
                        aria-label="Default select example"
                        v-model="selectedModel">
                      <option v-for="model in models" :key="model.name" :value="model">{{ model.name }}</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="form-group mt-2">
                <label for="exampleFormControlTextarea1">Add Text Below</label>
                <textarea
                    v-model="description"
                    class="form-control"
                    placeholder="I really enjoyed my car ..."
                    id="exampleFormControlTextarea1"
                    rows="7"
                ></textarea>
              </div>
              <div class="rating mt-2">
                <label for="ratingScore">What is your rating score?</label>
                <input
                    class="ms-4"
                    type="number"
                    name="ratingScore"
                    id="ratingScore"
                    v-model="rating"
                    min="1"
                    max="5"
                />
              </div>
              <div class="rating mt-3">
                <label for="ratingScore">Car image:</label>
                <input
                    class="ms-4"
                    type="file"
                    name="image"
                    id="image"
                    ref="image"
                    min="1"
                    max="5"
                />
              </div>
            </div>
            <div class="modal-footer">
              <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal">
                Close
              </button>
              <button type="button" class="btn btn-primary" @click="addReview">
                Create Review
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RatingReview from "../components/ratings/RatingReview.vue";
import Masonry from "masonry-layout";
import reviewService from "@/repository/reviewRepository";

export default {
  components: {RatingReview},
  name: "RatingsPage",
  mounted() {
    var row = document.querySelector("[data-masonry]");
    new Masonry(row, {
      // options
      percentPosition: true,
    });
    this.getBrands();
    this.fetchReviews();
  },
  data() {
    return {
      showModal: false,
      reviews: [],
      brands: [],
      selectedBrand: '',
      models: [],
      selectedModel: '',
      rating: '',
      description: ''
    };
  },
  watch: {
    selectedBrand() {
      console.log(this.selectedBrand);
      this.models = this.selectedBrand.models;
      this.selectedModel = this.models[0];
    }
  },
  methods: {
    userExists() {
      return this.$store.getters.getUser;
    },
    getBrands() {
      console.log("Brands:")
      this.brands = this.$store.getters.getBrands;
      this.selectedBrand = this.brands[0];
      this.models = this.brands[0].models;
      this.selectedModel = this.models[0];
    },
    fetchReviews() {
      reviewService.fetchAllReviews().then(response => {
        this.reviews = response.data;
      })
    },
    addReview() {
      let formData = new FormData();
      formData.append("brand", JSON.stringify(this.selectedBrand));
      formData.append("model", JSON.stringify(this.selectedModel));
      formData.append('rating', this.rating);
      formData.append('description', this.description);
      formData.append('username', this.$store.getters.getUser.username);
      formData.append('image', this.$refs.image.files[0]);

      reviewService.addReview(formData).then(() => {
        this.fetchReviews();
        this.$router.go(0);
      })
    }
  },
};
</script>

<style scoped>
.reivews {
  max-width: 1300px;
}
</style>
