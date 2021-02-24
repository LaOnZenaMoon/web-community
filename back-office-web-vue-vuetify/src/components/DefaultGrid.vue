<template>
  <div>
    <template slot="item"></template>
    <v-data-table
        dense multi-sort
        :headers="headers" :items="items" :items-per-page="itemsPerPage"
        :header-props="{
          class: ['head-class'],
        }"
        :footer-props="{
          prevIcon: 'mdi-arrow-left-bold',
          nextIcon: 'mdi-arrow-right-bold',
        }"
    >
      <template v-slot:top v-if="searchUse">
        <v-toolbar flat>
          <v-row no-gutters class="mt-7">
            <v-spacer></v-spacer>
            <v-col cols="auto" sm="3" class="ml-4 mt-1">
              <v-select
                  outlined
                  dense
                  label="Condition"
                  v-model="searchCondition"
                  :items="searchConditions"
                  v-on:keyup.enter="searchItems()"
              >
              </v-select>
            </v-col>
            <v-col cols="auto" sm="3" class="ml-4 mt-1">
              <v-text-field
                  dense
                  flat
                  hide-details
                  solo-inverted
                  v-model="searchKeyword" v-on:keyup.enter="searchItems()"
              ></v-text-field>
            </v-col>
            <v-col cols="auto" sm="1" class="ml-4 mt-2">
              <v-icon color="lightgrey" @click="searchItems">mdi-magnify</v-icon>
            </v-col>

            <v-col cols="auto" sm="1" class="mt-2">
              <v-icon color="lightgrey" @click="addItem">mdi-plus-box-outline</v-icon>
            </v-col>
          </v-row>
        </v-toolbar>
      </template>

      <template v-slot:item.actions="{ item }" v-if="actionsUse">
        <v-icon
            small
            class="mr-2"
            @click="editItem(item)"
        >
          mdi-pencil
        </v-icon>
        <v-icon
            small
            @click="deleteItem(item)"
        >
          mdi-delete
        </v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn
            color="primary"
            @click="initialize"
        >
          Reset
        </v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
  props: [
    'title',
    'searchConditions',
    'searchUse',
    'actionsUse',
    'headers',
    'items',
    'itemsPerPage',
  ],
  data() {
    return {
      page: 1,
      pageCount: 0,
      searchKeyword: '',
      searchCondition: '',
    }
  },
  methods: {
    searchItems() {
      this.$emit('searchItems');
    },
    addItem() {
      this.$emit('addItem');
    },
    editItem() {
      this.$emit('editItem');
    },
    deleteItem() {
      this.$emit('deleteItem');
    },
  },
}
</script>


<style>
.v-data-table thead {
  background-image: url('../../public/img/header-profile-skin-2.png');
  background-size: 100%;
}

.v-data-table tbody {
}

.v-data-table th {
  color: #DFE4ED !important;
  font-size: 15px !important;
}

.v-data-table th:first-child {
  border-radius: 4px 0px 0px 0px !important;
}

.v-data-table th:last-child {
  border-radius: 0px 4px 0px 0px !important;
}
</style>
