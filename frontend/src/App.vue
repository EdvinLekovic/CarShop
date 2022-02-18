<template>
  <AppConfig/>
</template>

<script>
import AppConfig from "@/components/config/AppConfig";

export default {
  name: 'App',
  components: {
    AppConfig,
  },
  created() {
    console.log("created");
  }

}
</script>


