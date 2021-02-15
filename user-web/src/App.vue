<template>
  <div id="app">
    <Header></Header>
    <b-container>
      <router-view></router-view>
    </b-container>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/layout/Header";
import Footer from "@/components/layout/Footer";

export default {
  components: {
    Header,
    Footer,
  }
}
</script>

<style scoped>

</style>
