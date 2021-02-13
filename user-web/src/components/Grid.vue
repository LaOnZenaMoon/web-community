<template>
  <v-app id="inspire">
    <v-data-table
      class="elevation-1" hide-default-footer
      :page.sync="page" @page-count="pageCount = $event" :items-per-page="itemsPerPage"
      :headers="headers" :items="items">
      <template v-slot:top>
        <v-toolbar flat color="grey lighten-2" height="30">
          <v-row>
            <v-col class="">
              <h2>{{ title }}</h2>
            </v-col>
          </v-row>
        </v-toolbar>
      </template>
    </v-data-table>
    <v-row class="ma-2">
      <v-col sm="6">
        <v-pagination
          total-visible="10"
          v-model="page"
          :length="pageCount"
        ></v-pagination>
      </v-col>
      <v-col cols="auto" sm="3" class="ml-4 mt-1">
        <v-text-field
          dense
          flat
          hide-details
          solo-inverted
          v-model="searchKeyword" v-on:keyup.enter="searchList()"
        ></v-text-field>
      </v-col>
      <v-col cols="auto" sm="1" class="mt-1">
        <v-btn v-on:click="searchList()">
          <v-icon color="lightgrey">mdi-magnify</v-icon>
        </v-btn>
      </v-col>
      <v-col cols="auto" sm="1" class="mt-1">
        <v-btn v-on:click="addButtonClicked()">
          <v-icon color="lightgrey">mdi-plus-box-outline</v-icon>
        </v-btn>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>

export default {
  props: [
    'title',
    'searchConditions',
    'headers',
    'items',
  ],
  data() {
    return {
      page: 1,
      pageCount: 10,
      itemsPerPage: 20,
      dialog: false,
      notifications: false,
      sound: true,
      widgets: false,
      searchKeyword: '',
      searchCondition: '',
    }
  },
  methods: {
    searchList() {

    },
    addButtonClicked() {
      this.$emit('addItem')
    },
  },
}
</script>


<style scoped>

</style>
