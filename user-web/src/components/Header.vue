<template>
  <v-app-bar app color="#009999">
    <v-tabs centered color="white">
      <v-tab to="/">
        Main
      </v-tab>
      <v-tab to="/notice/board">
        Notice
      </v-tab>
      <v-tab to="/column/board">
        Column
      </v-tab>
      <v-tab to="/free/board">
        Free Community
      </v-tab>
      <v-tab to="/expert/board">
        Expert Community
      </v-tab>
      <v-tab to="/multimedia/board">
        Multimedia
      </v-tab>
      <v-tab to="/comedy/board">
        Comedy
      </v-tab>
      <v-tab to="/market">
        Market
      </v-tab>
    </v-tabs>

    <v-col cols="auto">
      <v-icon class="mx-auto">mdi-account-circle</v-icon>
    </v-col>
  </v-app-bar>
</template>

<script>
export default {}
</script>

<style scoped>

</style>
