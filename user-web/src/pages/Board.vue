<template>
  <v-sheet color="grey lighten-2">
    <v-row>
      <v-col sm="9">
        <v-sheet class="ma-2" color="grey">
          <Grid v-bind="gridProps1" v-on="{addItem: changeGrid1Modal}"></Grid>
          <v-data-footer disable-items-per-page="true"></v-data-footer>
        </v-sheet>
      </v-col>
      <v-col sm="3">
        <v-sheet class="ma-2" color="grey" height="100%">
        </v-sheet>
      </v-col>
    </v-row>

    <Modal v-bind="grid1ModalProps" v-on="{closeModal: changeGrid1Modal}"></Modal>
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
      gridProps1: {
        title: this.$route.name,
        headers: Test.header1,
        items: Test.items1
      },
      grid1ModalProps: {
        isOpen: false,
        title: 'test1 modal',
      },
    };
  },
  methods: {
    changeGrid1Modal() {
      this.grid1ModalProps.isOpen = !this.grid1ModalProps.isOpen
    },
    changeGrid2Modal() {
      this.grid2ModalProps.isOpen = !this.grid2ModalProps.isOpen
    },
  },
}
</script>

<style scoped>

</style>
