<template>
  <div>
    <b-nav class="header-top">
      <b-nav-text>LaOnZenaMoon</b-nav-text>
      <b-nav-item-dropdown right>
        <template #button-content>
          <em>User</em>
        </template>
        <b-dropdown-item href="#">Profile</b-dropdown-item>
        <b-dropdown-item href="#">Sign Out</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-nav>
    <b-nav class="header-nav">
      <b-nav-item to="/">Main</b-nav-item>
      <b-nav-item to="/notice/board">Notice</b-nav-item>
      <b-nav-item to="/column/board">Column</b-nav-item>
      <b-nav-item-dropdown
        text="Community"
        toggle-class="nav-link-custom"
        right
      >
        <b-dropdown-item to="/expert/community/board">Expert community</b-dropdown-item>
        <b-dropdown-divider></b-dropdown-divider>
        <b-dropdown-item to="/free/community/board">Free community</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-nav-item to="/multimedia/board">Multimedia</b-nav-item>
      <b-nav-item to="/comedy/board">Comedy</b-nav-item>
      <b-nav-item to="/market/board">Market</b-nav-item>
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
