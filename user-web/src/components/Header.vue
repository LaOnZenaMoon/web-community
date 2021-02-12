<template>
  <v-app-bar app color="primary" flat>
    <v-avatar
      :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'" size="32"
    ></v-avatar>

    <v-tabs centered class="ml-n9" color="white">
      <v-tab>
        Notice
      </v-tab>
      <v-tab>
        Column
      </v-tab>
      <v-tab>
        Community 1
      </v-tab>
      <v-tab>
        Community 2
      </v-tab>
      <v-tab>
        Community 3
      </v-tab>
      <v-tab>
        Community 4
      </v-tab>
      <v-tab>
        Pictures 1
      </v-tab>
      <v-tab>
        Pictures 2
      </v-tab>
    </v-tabs>

    <v-avatar
      class="hidden-sm-and-down" color="white shrink" size="32"
    ></v-avatar>
  </v-app-bar>
</template>

<script>
export default {}
</script>

<style scoped>

</style>
