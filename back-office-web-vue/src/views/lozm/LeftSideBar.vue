<template>
  <side-bar>
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

    <template slot="links-after">
      <hr class="my-3">
      <h6 class="navbar-heading p-0 text-muted">Documentation</h6>

      <b-nav class="navbar-nav mb-md-3">
        <b-nav-item
          href="https://www.creative-tim.com/learning-lab/bootstrap-vue/quick-start/argon-dashboard"
        >
          <i class="ni ni-spaceship"></i>
          <b-nav-text class="p-0">Getting started</b-nav-text>
        </b-nav-item>
        <b-nav-item href="https://www.creative-tim.com/learning-lab/bootstrap-vue/colors/argon-dashboard">
          <i class="ni ni-palette"></i>
          <b-nav-text class="p-0">Foundation</b-nav-text>
        </b-nav-item>
        <b-nav-item href="https://www.creative-tim.com/learning-lab/bootstrap-vue/avatar/argon-dashboard">
          <i class="ni ni-ui-04"></i>
          <b-nav-text class="p-0">Components</b-nav-text>
        </b-nav-item>
      </b-nav>
    </template>
  </side-bar>
</template>

<script>
export default {
  name: "LeftSideBar"
}
</script>

<style scoped>

</style>
