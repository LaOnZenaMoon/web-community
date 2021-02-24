<template>
  <v-app id="inspire">
    <v-container class="fill-height">
      <v-row
        align="center"
        justify="center"
      >
        <v-col cols="4">
          <v-img
            src="../../public/img/contract.jpg"
            height="600px"
            rounded
          ></v-img>
        </v-col>
        <v-col cols="4">
          <v-card class="elevation-12"
                  height="600px"
                  rounded
          >
            <v-card-text>
              <v-form>
                <v-text-field
                  name="login"
                  prepend-icon="mdi-account"
                  type="text"
                  v-model="model.identifier"
                />

                <v-text-field
                  name="password"
                  prepend-icon="mdi-lock"
                  type="password"
                  v-model="model.password"
                  v-on:keyup.enter="onSubmit"
                />
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-btn v-on:click="onSubmit" width="100%">
                <v-icon align="center">mdi-login</v-icon>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import {basicLogger} from "@/common/logger";
import {setToken} from "@/api/token-control";
import {noAuthentication} from "@/api";

export default {
  created() {
    this.previousPath = this.$route.query.previousPath || '/';
  },
  data() {
    return {
      model: {
        identifier: '',
        password: '',
        rememberMe: false,
        previousPath: '',
      }
    };
  },
  methods: {
    onSubmit() {
      noAuthentication.signIn({
        identifier: this.model.identifier,
        password: this.model.password
      })
        .then((response) => {
          if (response.status === 200) {
            setToken(response.data.token);
            this.$router.push(this.previousPath);
          }
        })
        .catch(error => {
          basicLogger(error);
          alert('Failed to sign in. Please check your account information.');
        });
    },
  }
}
</script>

<style scoped>

</style>
