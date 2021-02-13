<template>
  <v-sheet color="grey lighten-2">
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2" height="400">
          <v-carousel
            height="400"
            hide-delimiter-background
            show-arrows-on-hover
          >
            <v-carousel-item
              v-for="(slide, i) in slides"
              :key="i"
            >
              <v-sheet
                :color="colors[i]"
                height="100%"
              >
                <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
                >
                  <div class="display-3">
                    {{ slide }} Slide
                  </div>
                </v-row>
              </v-sheet>
            </v-carousel-item>
          </v-carousel>
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" color="grey" height="400">
          <v-form>
            <v-text-field
              label="ID"
            ></v-text-field>
            <v-text-field
              label="Password"
              type="password"
            ></v-text-field>
          </v-form>
        </v-sheet>
      </v-col>
    </v-row>
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2" height="800" color="grey">
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" height="800" color="grey">
        </v-sheet>
      </v-col>
    </v-row>
  </v-sheet>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      colors: [
        'indigo',
        'warning',
        'pink darken-2',
        'red lighten-1',
        'deep-purple accent-4',
      ],
      slides: [
        'First',
        'Second',
        'Third',
        'Fourth',
        'Fifth',
      ],
    };
  }
}
</script>

<style scoped>

</style>
