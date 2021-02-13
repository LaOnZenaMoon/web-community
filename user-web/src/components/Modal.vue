<template>
  <v-dialog
    fullscreen hide-overlay transition="dialog-bottom-transition" scrollable
    v-model="isOpen" @keypress.esc="close()">
    <v-card tile>
      <v-toolbar
        color="grey" dark flat>
        <slot name="header">
          <v-btn
            icon
            dark
            @click="close()"
          >
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title v-text="title">Settings</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-toolbar-items>
            <v-btn
              dark
              text
              @click="close()"
            >
              Save
            </v-btn>
          </v-toolbar-items>
          <v-menu
            bottom
            right
            offset-y
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                dark
                icon
                v-bind="attrs"
                v-on="on"
              >
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <!--                            <v-list-item-->
              <!--                                v-for="(item, i) in items"-->
              <!--                                :key="i"-->
              <!--                                @click="() => {}"-->
              <!--                            >-->
              <!--                                <v-list-item-title>{{ item.title }}</v-list-item-title>-->
              <!--                            </v-list-item>-->
            </v-list>
          </v-menu>
        </slot>
      </v-toolbar>
      <v-card-text>
        <slot name="body">

        </slot>
      </v-card-text>

      <div style="flex: 1 1 auto;"></div>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: [
    'title',
    'isOpen',
  ],
  data() {
    return {}
  },
  methods: {
    close() {
      console.log('close')
      this.$emit('closeModal')
    }
  },
}
</script>

<style scoped>

</style>
