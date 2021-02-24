const namespaced = true

const state = {
    leftDrawer: true,
    rightDrawer: false,
}

const getters = {
    getLeftDrawer(state) {
        return state.leftDrawer
    },
    getRightDrawer(state) {
        return state.rightDrawer
    },
}

const mutations = {
    changeLeftDrawer(state) {
        state.leftDrawer = !state.leftDrawer
    },
    changeRightDrawer(state) {
        state.rightDrawer = !state.rightDrawer
    },
}

export default {
    namespaced,
    state,
    getters,
    mutations,
}
