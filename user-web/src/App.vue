<template>
  <v-app id="inspire">
    <v-system-bar
      color="deep-purple darken-4"
      dark
    >
      <v-spacer></v-spacer>
      <v-icon small>
        mdi-square
      </v-icon>
      <v-icon
        class="ml-1"
        small
      >
        mdi-circle
      </v-icon>
      <v-icon
        class="ml-1"
        small
      >
        mdi-triangle
      </v-icon>
    </v-system-bar>
    <Header></Header>
    <router-view></router-view>
    <Footer></Footer>
  </v-app>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";

export default {
  components: {
    Header,
    Footer,
  },
}
</script>
