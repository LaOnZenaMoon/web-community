import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
// import colors from 'vuetify/lib/util/colors';

Vue.use(Vuetify);

// const MY_ICONS = {
//     complete: '...',
//     cancel: '...',
//     close: '...',
//     delete: '...', // delete (e.g. v-chip close)
//     clear: '...',
//     success: '...',
//     info: '...',
//     warning: '...',
//     error: '...',
//     prev: '...',
//     next: '...',
//     checkboxOn: '...',
//     checkboxOff: '...',
//     checkboxIndeterminate: '...',
//     delimiter: '...', // for carousel
//     sort: '...',
//     expand: 'fas fa-angle-down',
//     menu: '...',
//     subgroup: '...',
//     dropdown: '...',
//     radioOn: '...',
//     radioOff: '...',
//     edit: '...',
//     ratingEmpty: '...',
//     ratingFull: '...',
//     ratingHalf: '...',
//     loading: '...',
//     first: '...',
//     last: '...',
//     unfold: '...',
//     file: '...',
// };

export default new Vuetify({
  icons: {
    iconfont: 'faSvg',
    // values: MY_ICONS,
  },
  theme: {
    // dark: true,
    // themes: {
    //   dark: {
    //     primary: '#1976D2',
    //     secondary: '#424242',
    //     accent: '#82B1FF',
    //     error: '#FF5252',
    //     info: '#2196F3',
    //     success: '#4CAF50',
    //     warning: '#FFC107',
    //   },
    // }
  }
});
