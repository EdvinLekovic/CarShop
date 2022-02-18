import {createRouter, createWebHistory} from "vue-router";
import BuyCarPage from "@/pages/BuyCarPage";
import HomePage from "@/pages/HomePage";
import ServicePage from "@/pages/ServicePage";
import RatingsPage from "@/pages/RatingsPage";
import AboutUsPage from "@/pages/AboutUsPage";
import AddCarForm from "@/components/buy-car/form/AddCarForm";
import EditCarForm from "@/components/buy-car/form/EditCarForm";
import BuyCarInfo from "@/components/buy-car/BuyCarInfo";
import RegisterForm from "@/components/authentication/RegisterForm";
import LoginPage from "@/pages/LoginPage";
import MyProfilePage from "@/pages/MyProfilePage";
import PersonalInfo from "@/components/personal-profile/PersonalInfo";
import PaymentInfo from "@/components/personal-profile/PaymentInfo";
import MyPurchasedCars from "@/pages/MyPurchasedCars";
import MyServicesPage from "@/pages/MyServicesPage";
import ClientRequestServices from "@/pages/ClientRequestServices";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            redirect: "/home",
        },
        {
            path: "/home",
            component: HomePage,
        },
        {
            path: "/buy-car",
            name: "buy-car",
            component: BuyCarPage,
        },
        {
            name: "buy-car-info",
            path: "/buy-car/:id",
            component: BuyCarInfo,
            props: true,
        },
        {
            path: "/add-car",
            component: AddCarForm,
        },
        {
            path: "/edit-car/:id",
            component: EditCarForm,
            props: true,
        },
        {
            path: "/services",
            name: "services",
            component: ServicePage,
        },
        {
            path: "/ratings",
            name: "ratings",
            component: RatingsPage,
        },
        {
            path: "/about-us",
            component: AboutUsPage,
        },
        {
            path: "/login",
            component: LoginPage,
        },
        {
            path: "/register",
            component: RegisterForm,
        },
        {
            path: "/my-profile",
            component: MyProfilePage,
            children: [
                {
                    path: "/my-profile/personal-info",
                    component: PersonalInfo,
                },
                {
                    path: "/my-profile/payment-info",
                    component: PaymentInfo,
                },
            ],
        },
        {
            path: "/my-purchased-cars",
            component: MyPurchasedCars
        },
        {
            path: "/my-services",
            component: MyServicesPage
        },
        {
            path: "/client-request-services",
            component: ClientRequestServices
        }
    ],
});

export default router;
