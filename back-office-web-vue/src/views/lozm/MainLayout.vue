<template>
  <div>
    <div class="wrapper">
      <notifications></notifications>
      <LeftSideBar>
        <template slot="links">
          <sidebar-item
            :link="{
            name: 'Dashboard',
            path: '/dashboard',
            icon: 'ni ni-tv-2 text-primary',
          }"
          >
          </sidebar-item>

          <sidebar-item
            :link="{
              name: 'Icons',
              path: '/icons',
              icon: 'ni ni-planet text-blue'
              }"
          >
          </sidebar-item>

          <sidebar-item
            :link="{
                name: 'Maps',
                path: '/maps',
                icon: 'ni ni-pin-3 text-orange'
              }">
          </sidebar-item>

          <sidebar-item
            :link="{
                name: 'User Profile',
                path: '/profile',
                icon: 'ni ni-single-02 text-yellow'
                }">
          </sidebar-item>

          <sidebar-item
            :link="{
                  name: 'Tables',
                  path: '/tables',
                  icon: 'ni ni-bullet-list-67 text-red'
                }">
          </sidebar-item>

          <sidebar-item
            :link="{
                    name: 'Login',
                    path: '/login',
                    icon: 'ni ni-key-25 text-info'
                  }">
          </sidebar-item>
          <sidebar-item
            :link="{
                    name: 'Register',
                    path: '/register',
                    icon: 'ni ni-circle-08 text-pink'
                  }">
          </sidebar-item>
        </template>
      </LeftSideBar>
      <div class="main-content">
        <MainHeader></MainHeader>
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
import PerfectScrollbar from 'perfect-scrollbar';
import 'perfect-scrollbar/css/perfect-scrollbar.css';

function hasElement(className) {
  return document.getElementsByClassName(className).length > 0;
}

function initScrollbar(className) {
  if (hasElement(className)) {
    new PerfectScrollbar(`.${className}`);
  } else {
    // try to init it later in case this component is loaded async
    setTimeout(() => {
      initScrollbar(className);
    }, 100);
  }
}

import { FadeTransition } from 'vue2-transitions';
import MainHeader from "@/views/lozm/MainHeader";
import LeftSideBar from "@/views/lozm/LeftSideBar";
import MainFooter from "@/views/lozm/MainFooter";

export default {
  components: {
    MainFooter,
    LeftSideBar,
    MainHeader,
    FadeTransition,
  },
  methods: {
    initScrollbar() {
      let isWindows = navigator.platform.startsWith('Win');
      if (isWindows) {
        initScrollbar('sidenav');
      }
    }
  },
  mounted() {
    this.initScrollbar()
  },
}
</script>

<style scoped>

</style>
