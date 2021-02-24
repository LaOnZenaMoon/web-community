<template>
  <v-navigation-drawer
      v-model="getLeftDrawer"
      app
      width="250"
      color="#2f4050"
  >
    <v-sheet
        height="100"
        width="100%"
        align="center"
        class="logo-style"
    >
      <h3>KT is OAM</h3>
      <h4 v-text="getUserName()"></h4>
    </v-sheet>

    <v-list>
      <v-list-group
          :value="false"
          prepend-icon="mdi-cloud"
      >
        <template v-slot:activator>
          <v-list-item-title>114On</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

      <v-list-group
          :value="false"
          prepend-icon="mdi-account-multiple"
      >
        <template v-slot:activator>
          <v-list-item-title>INJOS</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

      <v-list-group
          :value="false"
          prepend-icon="mdi-phone"
      >
        <template v-slot:activator>
          <v-list-item-title>IPCC</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

      <v-list-group
          :value="false"
          prepend-icon="mdi-database"
      >
        <template v-slot:activator>
          <v-list-item-title>NDAS</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

      <v-list-group
          :value="false"
          prepend-icon="mdi-database"
      >
        <template v-slot:activator>
          <v-list-item-title>NDMS</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

      <v-list-group
          :value="false"
          prepend-icon="mdi-cash-usd"
      >
        <template v-slot:activator>
          <v-list-item-title>WOOSUN</v-list-item-title>
        </template>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server1</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-group
            :value="false"
            no-action
            sub-group
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>Server2</v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>OS</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>DB</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list-group>

    </v-list>

  </v-navigation-drawer>
</template>

<script>
import {mapGetters} from 'vuex'
import {getUserName} from "@/api/token-control";

export default {
  computed: {
    ...mapGetters({
      getLeftDrawer: 'sidebar/getLeftDrawer',
    }),
  },
  methods: {
    getUserName() {
      return getUserName();
    },
  },
}
</script>

<style>
.logo-style {
  padding: 25px;
  background-image: url('../../public/img/header-profile-skin-2.png');
  background-size: 100%;
}

h3 {
  color: #DFE4ED;
}

h4 {
  color: #8095A8;
}

.v-list-item .v-list-item__title {
  font-size: 15px;
  color: #DFE4ED;
}

.v-list-item--active .v-list-item__title {
  font-size: 15px;
  color: #1976d2 !important;
}

.v-list-item__icon i, svg {
  font-size: 15px !important;
  color: #8095A8 !important;
}

.v-list-item i, svg {
  color: #8095A8 !important;
}

</style>
