import Vue from 'vue';
import store from './store';
import router from './routes/router';
import App from './App.vue';
import DashboardPlugin from './plugins/dashboard-plugin';

// plugin setup
Vue.use(DashboardPlugin);

/* eslint-disable no-new */
new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App),
});
