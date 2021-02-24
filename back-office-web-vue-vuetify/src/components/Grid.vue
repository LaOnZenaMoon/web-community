<template>
    <v-data-table :headers="headers" :items="items" :items-per-page="10" class="elevation-1">

        <template v-slot:top>
            <v-toolbar flat color="grey lighten-2">
                <v-row no-gutters class="mt-7">
                    <v-col cols="auto" sm="5" class="ml-4 mt-1">
                        <h2>{{ title }}</h2>
                    </v-col>
                    <v-spacer></v-spacer>
                    <v-col cols="auto" sm="2" class="ml-4 mt-1">
                        <v-select
                            outlined
                            dense
                            label="Condition"
                            v-model="searchCondition"
                            :items="searchConditions"
                            v-on:keyup.enter="searchList()"
                        >
                        </v-select>
                    </v-col>
                    <v-col cols="auto" sm="2" class="ml-4 mt-1">
                        <v-text-field
                            dense
                            flat
                            hide-details
                            solo-inverted
                            v-model="searchKeyword" v-on:keyup.enter="searchList()"
                        ></v-text-field>
                    </v-col>
                    <v-col cols="auto" sm="1" class="ml-4 mt-1">
                        <v-btn v-on:click="searchList()">
                            <v-icon color="lightgrey">mdi-magnify</v-icon>
                        </v-btn>
                    </v-col>
                    <v-col cols="auto" sm="1" class="mt-1">
                        <v-btn v-on:click="addButtonClicked()">
                            <v-icon color="lightgrey">mdi-plus-box-outline</v-icon>
                        </v-btn>
                    </v-col>
                    <v-spacer></v-spacer>
                </v-row>
            </v-toolbar>
        </template>
    </v-data-table>

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
            dialog: false,
            dialog2: false,
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
