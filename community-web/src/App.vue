<template>
  <div id="material-kit">
    <div :class="{ 'nav-open': NavbarStore.showNavbar }">
      <router-view name="header"/>
      <div class="wrapper">
        <parallax class="page-header header-filter" :style="{backgroundColor: '#009999', height: '200px'}">
          <div class="md-layout">
            <div class="md-layout-item">
              <div class="image-wrapper">
                <div class="brand">
                </div>
              </div>
            </div>
          </div>
        </parallax>
        <router-view/>
      </div>
      <router-view name="footer"/>
    </div>
  </div>
</template>
