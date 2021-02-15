<template>
  <b-card v-bind:title="this.gridData.title">
    <b-table
      :head-variant="'dark'"
      :fields="this.gridData.fields"
      :items="this.gridData.items"
      :per-page="perPage"
      small
    ></b-table>
    <b-pagination v-model="currentPage" :total-rows="rows"></b-pagination>
  </b-card>
</template>

<script>
export default {
  props: ['gridData'],
  data() {
    return {
      fields: [],
      items: [],
      rows: 101,
      perPage: 20,
      currentPage: 1,
    }
  },
}
</script>

<style scoped>

</style>
