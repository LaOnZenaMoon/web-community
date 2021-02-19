<template>
  <div>
    <div class="wrapper">
      <MainHeader></MainHeader>
      <notifications></notifications>
      <LeftSideBar></LeftSideBar>
      <div class="main-content">
        <dashboard-navbar :type="$route.meta.navbarType"></dashboard-navbar>

        <div @click="$sidebar.displaySidebar(false)">
          <fade-transition :duration="200" origin="center top" mode="out-in">
            <!-- your content here -->
            <router-view></router-view>
          </fade-transition>
        </div>
        <MainFooter></MainFooter>
      </div>
    </div>
  </div>
</template>

<script>
import MainHeader from "@/views/lozm/MainHeader";
import LeftSideBar from "@/views/lozm/LeftSideBar";
import MainFooter from "@/views/lozm/MainFooter";

export default {
  components: {MainFooter, LeftSideBar, MainHeader}
}
</script>

<style scoped>

</style>
