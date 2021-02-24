<template>
  <div>
    <v-app-bar app clipped-right flat height="50" color="#DFE4ED">
      <v-col cols="auto">
        <v-icon class="mx-auto" @click.stop="changeLeftDrawer">mdi-menu</v-icon>
      </v-col>
      <v-col cols="auto">
        <v-icon class="mx-auto" @click="home">mdi-home</v-icon>
      </v-col>
      <v-spacer></v-spacer>
      <v-col cols="auto">
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-icon class="mx-auto" v-bind="attrs" v-on="on">mdi-account-circle</v-icon>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-title @click="signOut"><v-icon>mdi-logout</v-icon></v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-col>
<!--      <v-col cols="auto">-->
<!--        <v-icon class="mx-auto" @click.stop="changeRightDrawer">mdi-arrow-collapse-right</v-icon>-->
<!--      </v-col>-->
    </v-app-bar>
  </div>
</template>

<script>
import {mapMutations} from "vuex";
import {noAuthentication} from "@/api";

export default {
  methods: {
    ...mapMutations({
      changeLeftDrawer: 'sidebar/changeLeftDrawer',
      changeRightDrawer: 'sidebar/changeRightDrawer',
    }),
    signOut() {
      noAuthentication.signOut();
    },
    home() {
      this.$router.push('/main');
    }
  }
}
</script>

<style scoped>

</style>
