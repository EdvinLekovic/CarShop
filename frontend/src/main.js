import { createApp } from "vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";
import router from "@/router";
import store from "@/store/store";
import App from "@/App";
import { FontAwesomeIcon } from "@/font-awesome/font-awesome";
import VueStarRating from "vue-star-rating";


const app = createApp(App);

app.use(router);
app.use(store);

app.component("star-rating", VueStarRating.default);
app.component("font-awesome-icon", FontAwesomeIcon);

app.mount("#app");
