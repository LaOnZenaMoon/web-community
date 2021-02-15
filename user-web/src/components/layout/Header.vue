<template>
  <div>
    <b-nav class="header-top">
      <b-nav-item-dropdown right>
        <template #button-content>
          <em>User</em>
        </template>
        <b-dropdown-item href="#">Profile</b-dropdown-item>
        <b-dropdown-item href="#">Sign Out</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-nav>
    <b-nav class="header-nav">
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
    </b-nav>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.header-top {
  background-color: lightgrey;
  height: 50px;
}
.header-nav {
  background-color: #CC9999;
  height: 50px;
}
</style>
