<template>
    <v-dialog
        v-model="isOpen"
        fullscreen
        hide-overlay
        transition="dialog-bottom-transition"
        scrollable
    >
        <v-card tile>
            <v-toolbar
                flat
                dark
                color="grey"
            >
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
                    <v-list
                        three-line
                        subheader
                    >
                        <v-subheader>User Controls</v-subheader>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>Content filtering</v-list-item-title>
                                <v-list-item-subtitle>Set the content filtering level to restrict apps that can be
                                    downloaded
                                </v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-list-item>
                            <v-list-item-content>
                                <v-list-item-title>Password</v-list-item-title>
                                <v-list-item-subtitle>Require password for purchase or use password to restrict purchase
                                </v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list>
                    <v-divider></v-divider>
                    <v-list
                        three-line
                        subheader
                    >
                        <v-subheader>General</v-subheader>
                        <v-list-item>
                            <v-list-item-action>
                                <v-checkbox v-model="notifications"></v-checkbox>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>Notifications</v-list-item-title>
                                <v-list-item-subtitle>Notify me about updates to apps or games that I downloaded
                                </v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-list-item>
                            <v-list-item-action>
                                <v-checkbox v-model="sound"></v-checkbox>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>Sound</v-list-item-title>
                                <v-list-item-subtitle>Auto-update apps at any time. Data charges may apply
                                </v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        <v-list-item>
                            <v-list-item-action>
                                <v-checkbox v-model="widgets"></v-checkbox>
                            </v-list-item-action>
                            <v-list-item-content>
                                <v-list-item-title>Auto-add widgets</v-list-item-title>
                                <v-list-item-subtitle>Automatically add home screen widgets</v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list>
                </slot>
            </v-card-text>

            <div style="flex: 1 1 auto;"></div>
        </v-card>
    </v-dialog>
</template>

<script>
export default {
    props: [
        'isOpen',
        'title'
    ],
    data() {
        return {
            dialog: false,
            dialog2: false,
            notifications: false,
            sound: true,
            widgets: false,
        }
    },
    methods: {
        close() {
            this.$emit('closeModal')
        }
    },
}
</script>

<style scoped>

</style>
