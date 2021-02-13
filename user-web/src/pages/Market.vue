<template>
  <v-sheet color="grey lighten-1">
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2 pt-3" color="grey">
          <v-row>
            <template v-for="n in 4">
              <v-col
                :key="n"
                cols="12"
              >
                <strong>Category {{ n }}</strong>
              </v-col>

              <v-col
                v-for="j in 6"
                :key="`${n}${j}`"
                cols="6"
                md="2"
              >
                <v-sheet height="150"></v-sheet>
              </v-col>
            </template>
          </v-row>
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" color="grey" height="100%">
        </v-sheet>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script>

export default {
  data() {
    return {
      drawer: null
    };
  }
}
</script>

<style scoped>

</style>
