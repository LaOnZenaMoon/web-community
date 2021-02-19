<template>
  <!-- Header -->
  <div class="header bg-gradient-info py-7 py-lg-8 pt-lg-9">
    <b-container fluid class="mt--6">
      <b-row>
        <b-col xl="12" class="order-xl-2 mb-5">
          <b-card no-body class="card-profile" alt="Image placeholder" img-top>
            <b-row class="justify-content-center">
              <b-col lg="3" class="order-lg-2">
                <div class="card-profile-image">
                </div>
              </b-col>
            </b-row>

            <b-card-header class="text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
              <div class="d-flex justify-content-between">
              </div>
            </b-card-header>

            <b-card-body class="pt-0">
              <div class="text-left">
                <h2>
                  Official Notice
                </h2>
              </div>
              <hr class="my-4">
              <div class="text-center">
                <h5 class="h3" v-text="this.userName">
                  Jessica Jones
                </h5>
                <div class="h5 font-weight-300">
                  <i class="ni location_pin mr-2"></i>Bucharest, Romania
                </div>
              </div>
              <hr class="my-4">
              <div class="text-left">
                <p>What is Lorem Ipsum?
                  Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
                  industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
                  scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap
                  into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the
                  release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing
                  software like Aldus PageMaker including versions of Lorem Ipsum.

                  Why do we use it?
                  It is a long established fact that a reader will be distracted by the readable content of a page when
                  looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal
                  distribution of letters, as opposed to using 'Content here, content here', making it look like
                  readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their
                  default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.
                  Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected
                  humour and the like).

                  Where can I get some?
                  There are many variations of passages of Lorem Ipsum available, but the majority have suffered
                  alteration in some form, by injected humour, or randomised words which don't look even slightly
                  believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything
                  embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to
                  repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a
                  dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate
                  Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from
                  repetition, injected humour, or non-characteristic words etc.
                </p>
                <a href="#">Show more</a>
              </div>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import {getUserName} from "@/api/token-control";

export default {
  components: {
  },
  data() {
    return {
      userName: getUserName(),
    };
  },
  computed: {},
}
</script>

<style scoped>

</style>
