<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="dark" class="menu">
      <b-navbar-brand href="/">LaOnZenaMoon</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <template #button-content>
              <em>User</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse is-nav>
        <b-navbar-nav>
          <b-nav-item>Notice</b-nav-item>
          <b-nav-item>Column</b-nav-item>
          <b-nav-item-dropdown
            text="Community"
            toggle-class="nav-link-custom"
            right
          >
            <b-dropdown-item>Expert community</b-dropdown-item>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-item>Free community</b-dropdown-item>
          </b-nav-item-dropdown>
          <b-nav-item>Multimedia</b-nav-item>
          <b-nav-item>Comedy</b-nav-item>
          <b-nav-item>Market</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.menu {
  background-color: #CC9999;
}
</style>
