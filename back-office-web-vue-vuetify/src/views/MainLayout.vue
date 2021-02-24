<template>
  <v-app id="inspire">
    <Header></Header>
    <RightSidebar></RightSidebar>
    <LeftSidebar></LeftSidebar>

    <v-theme-provider root>
      <v-main class="main-body">
        <div class="main-header"><h3 v-text="this.$route.name"></h3></div>
        <router-view></router-view>
      </v-main>
    </v-theme-provider>

    <Footer></Footer>
  </v-app>
</template>

<script>
import Header from "@/components/Header";
import LeftSidebar from "@/components/LeftSidebar";
import RightSidebar from "@/components/RightSidebar";
import Footer from "@/components/Footer";


export default {
  components: {
    Footer,
    Header,
    LeftSidebar,
    RightSidebar,
  },
  data() {
    return {}
  },
  methods: {},
}
</script>

<style scoped>
.main-header {
  height: 50px;
  width: 100%;
  padding: 11px 30px;
  color: #DFE4ED;
  background-image: url('../../public/img/header-profile-skin-2.png');
  background-size: 100%;
}

.main-body {

}
</style>
