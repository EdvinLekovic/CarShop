<template>
  <div>
    <div class="p-5 mb-4 bg-light hero d-flex align-items-start">
      <div class="py-5 bg-light rounded w-50 p-4">
        <h1 class="display-3 fw-bold pt-5">
          We are a European online marketplace
        </h1>

        <p>
          We bring you new markets, new customers and new opportunities for the
          purchase and sale of used cars. Now you can buy and sell a used car
          safely and comfortablly online, with only a few easy clicks.
        </p>
      </div>
      <div class="py-5 bg-light rounded w-50 p-4">
        <img
          class="w-100 h-100"
          src="https://media.istockphoto.com/photos/low-angle-of-tall-building-in-manhattan-picture-id1291177121?b=1&k=20&m=1291177121&s=170667a&w=0&h=aI1PkWS_GkXJ4Qz0gz2cTOud95SS4hUa4iZc1kqWYL4="
          alt="building"
        />
      </div>
    </div>
    <div class="aboutus-section">
      <div class="container">
        <div class="row">
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="aboutus">
              <h2 class="aboutus-title display-3">The Team</h2>
              <p class="aboutus-text">
                We are a group of talented professionals, that seek to deliver
                the best quality for price
              </p>
              <p class="aboutus-text">
                Each one of us is educated and trained mechanic and foremost car
                enthusiast. Combining our skills together leads us to having
                competitive advantage on the market
              </p>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="aboutus-banner">
              <img
                src="http://themeinnovation.com/demo2/html/build-up/img/home1/about1.jpg"
                alt=""
              />
            </div>
          </div>
          <div class="col-md-5 col-sm-6 col-xs-12">
            <div class="feature">
              <div class="feature-box">
                <div class="clearfix">
                  <div class="iconset">
                    <span class="glyphicon glyphicon-cog icon"></span>
                  </div>
                  <div class="feature-content">
                    <h4>Work with heart</h4>
                    <p>
                      We love what we do and we have the best success rating
                    </p>
                  </div>
                </div>
              </div>
              <div class="feature-box">
                <div class="clearfix">
                  <div class="iconset">
                    <span class="glyphicon glyphicon-cog icon"></span>
                  </div>
                  <div class="feature-content">
                    <h4>Reliable services</h4>
                    <p>
                      Our services are done on time in the most efficient time
                      window. Our repairs will keep you going for a long time
                    </p>
                  </div>
                </div>
              </div>
              <div class="feature-box">
                <div class="clearfix">
                  <div class="iconset">
                    <span class="glyphicon glyphicon-cog icon"></span>
                  </div>
                  <div class="feature-content">
                    <h4>Great support</h4>
                    <p>
                      If any issue arises we can assist you on the phone, and
                      send help whereever is needed on the field
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div
      id="map-container-google-1"
      class="z-depth-1-half map-container"
      style="height: 500px"
    >
      <iframe
        class="w-100 h-100"
        src="https://maps.google.com/maps?q=manhatan&t=&z=13&ie=UTF8&iwloc=&output=embed"
        frameborder="0"
        style="border: 0"
        allowfullscreen
      ></iframe>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUsPage",
};
</script>

<style scoped>
.paddingTB60 {
  padding: 60px 0px 60px 0px;
}
.gray-bg {
  background: #f1f1f1 !important;
}
.about-title {
}
.about-title h1 {
  color: #535353;
  font-size: 45px;
  font-weight: 600;
}
.about-title span {
  color: #af0808;
  font-size: 45px;
  font-weight: 700;
}
.about-title h3 {
  color: #535353;
  font-size: 23px;
  margin-bottom: 24px;
}
.about-title p {
  color: #7a7a7a;
  line-height: 1.8;
  margin: 0 0 15px;
}
.about-paddingB {
  padding-bottom: 12px;
}
.about-img {
  padding-left: 57px;
}

/* Social Icons */
.about-icons {
  margin: 48px 0px 48px 0px;
}
.about-icons i {
  margin-right: 10px;
  padding: 0px;
  font-size: 35px;
  color: #323232;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);
}
.about-icons li {
  margin: 0px;
  padding: 0;
  display: inline-block;
}
#social-fb:hover {
  color: #3b5998;
  transition: all 0.001s;
}
#social-tw:hover {
  color: #4099ff;
  transition: all 0.001s;
}
#social-gp:hover {
  color: #d34836;
  transition: all 0.001s;
}
#social-em:hover {
  color: #f39c12;
  transition: all 0.001s;
}
</style>
