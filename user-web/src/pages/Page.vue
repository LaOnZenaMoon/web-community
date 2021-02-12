<template>
    <v-app id="inspire">
        <v-app-bar
            app color="white" flat
        >
            <v-avatar
                :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'" size="32"
            ></v-avatar>

            <v-tabs
                centered class="ml-n9" color="grey darken-1"
            >
                <v-tab>
                    Notice
                </v-tab>
                <v-tab>
                    Column
                </v-tab>
                <v-tab>
                    Community 1
                </v-tab>
                <v-tab>
                    Community 2
                </v-tab>
                <v-tab>
                    Community 3
                </v-tab>
                <v-tab>
                    Community 4
                </v-tab>
                <v-tab>
                    Pictures 1
                </v-tab>
                <v-tab>
                    Pictures 2
                </v-tab>
            </v-tabs>

            <v-avatar
                class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"
            ></v-avatar>
        </v-app-bar>

        <v-main class="grey lighten-3">
            <v-container>
                <v-row>
                    <v-col
                        cols="12"
                        sm="2"
                    >
                        <v-sheet
                            rounded="lg"
                            min-height="268"
                        >
                            <!--  -->
                        </v-sheet>
                    </v-col>

                    <v-col
                        cols="12"
                        sm="8"
                    >
                        <v-sheet
                            min-height="70vh"
                            rounded="lg"
                        >
                            <!--  -->
                        </v-sheet>
                    </v-col>

                    <v-col
                        cols="12"
                        sm="2"
                    >
                        <v-sheet
                            rounded="lg"
                            min-height="268"
                        >
                            <!--  -->
                        </v-sheet>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
export default {}
</script>

<style scoped>

</style>
