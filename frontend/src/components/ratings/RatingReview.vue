<template>
  <div class="d-flex flex-column border review col rounded" style="width: 414px;height: 500px;max-height: 500px;max-width: 414px">
    <img
        :src="image"
        class="card-img-top"
        style="height: 240px;width: 412px;max-height: 240px;max-width: 412px"
        :alt="review.model.name"
    />
    <div class="card-body px-4">
      <div class="info-rating d-flex">
        <div class="info d-flex align-items-start me-4 flex-column">
          <div class="name fw-bold">{{ review.user.username }}</div>
        </div>
        <div class="rating d-flex align-items-center">
          <font-awesome-icon
              v-for="i in review.rating"
              :key="i"
              icon="star"
              style="width: 20px; height: 20px"
              class="text-warning"
          />
        </div>
      </div>
      <p class="card-text py-4 lh-lg fw-light mb-0 text-break">
        {{ review.description }}
      </p>
      <div class="d-flex  align-items-center">
        <div class="model">
          <span>{{ review.brand.name }}</span> <span class="dot mx-1">
                -
          </span>
          <span>{{ review.model.name }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import reviewService from "@/repository/reviewRepository";

export default {
  name: "RatingReview",
  props: ["review"],
  data() {
    return {
      image: null
    }
  },
  components: {},
  methods: {
    getImage() {
      reviewService.getImage(this.review.id).then(response => {
        let reader = new FileReader();
        reader.readAsDataURL(response.data);
        reader.onload = () => {
          this.image = reader.result;
        }
      })

    }
  },
  mounted() {
    this.getImage();
  }
};
</script>

<style scoped>
.review {
  max-width: 440px;
  margin-right: 6px !important;
  margin-bottom: 7px !important;
}

.card-text {
  color: #1F2B59;
}
</style>
