<template>
  <v-sheet color="grey lighten-1">
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2" color="grey">
          <Grid v-bind="gridData" v-on="{addItem: changeModalStatus}"></Grid>
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" color="grey" height="100%">
        </v-sheet>
      </v-col>
    </v-row>

    <Modal v-bind="modalData" v-on="{closeModal: changeModalStatus}"></Modal>
  </v-sheet>
</template>

<script>
import Test from "@/data/test";
import Grid from "@/components/Grid";
import Modal from "@/components/Modal";

export default {
  components: {
    Grid,
    Modal,
  },
  data() {
    return {
      gridData: {
        title: this.$route.name,
        headers: Test.header1,
        items: Test.items1
      },
      modalData: {
        title: this.$route.name,
        isOpen: false,
      },
    };
  },
  methods: {
    changeModalStatus() {
      console.log('changeModalStatus')
      this.modalData.isOpen = !this.modalData.isOpen
    },
  },
}
</script>

<style scoped>

</style>
