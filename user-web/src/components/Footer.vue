<template>
  <v-footer
    color="primary lighten-1" padless
  >
    <v-row
      justify="center" no-gutters
    >
      <v-btn
        v-for="link in links"
        :key="link"
        color="white"
        text
        rounded
        class="my-2"
      >
        {{ link }}
      </v-btn>
    </v-row>
  </v-footer>
</template>

<script>
export default {
  data() {
    return {
      links: [
        'Home',
        'About Us',
        'Team',
        'Services',
        'Blog',
        'Contact Us',
      ],
    };
  }
}
</script>

<style scoped>

</style>
