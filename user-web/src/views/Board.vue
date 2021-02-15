<template>
  <b-row class="m-2">
    <b-col cols="8">
      <Grid v-bind:gridData="{ title: this.pageName, fields: ['title', 'userId'], items: this.items,}"></Grid>
    </b-col>
    <b-col cols="4">
      <b-card title="Card title" sub-title="Card subtitle">
        <b-card-text>
          Some quick example text to build on the <em>card title</em> and make up the bulk of the card's
          content.
        </b-card-text>

        <b-card-text>A second paragraph of text in the card.</b-card-text>

        <a href="#" class="card-link">Card link</a>
        <b-link href="#" class="card-link">Another link</b-link>
      </b-card>
    </b-col>
  </b-row>


</template>

<script>
import axios from 'axios';
import Grid from "@/components/Grid";

export default {
  components: {
    Grid,
  },
  data() {
    return {
      items: [],
      pageName: '',
    }
  },
  methods: {
    getPostData: function () {
      return axios.get('https://jsonplaceholder.typicode.com/posts')
        .then(({ data }) => {
          this.items = data;
        }).catch();
    },
  },
  created() {
    this.getPostData();
    this.pageName = this.$route.name;
  }
}
</script>

<style scoped>

</style>
