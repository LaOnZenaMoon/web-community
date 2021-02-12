<template>
  <v-sheet color="grey lighten-2">
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2" color="grey" height="1200">
          <h2>{{ this.$route.name }}</h2>
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" color="grey" height="1200">
        </v-sheet>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script>

export default {
  data() {
    return {};
  }
}
</script>

<style scoped>

</style>
