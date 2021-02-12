<template>
    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col sm="10" offset="1">
            <v-sheet min-height="1200">
              <v-row>
                <v-col sm="9">
                  <v-sheet class="ma-3" color="grey" height="1200">
                    <h2>{{ this.$route.name }}</h2>
                  </v-sheet>
                </v-col>
                <v-col sm="3">
                  <v-sheet class="ma-3" color="grey" height="1200">
                  </v-sheet>
                </v-col>
              </v-row>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
</template>

<script>

export default {
  data() {
    return {
    };
  }
}
</script>

<style scoped>

</style>
