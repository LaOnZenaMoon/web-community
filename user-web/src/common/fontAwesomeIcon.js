import Vue from 'vue';
import {library} from '@fortawesome/fontawesome-svg-core';
import {faHeart as fasHeart} from '@fortawesome/free-solid-svg-icons';
import {faHeart as farHeart} from '@fortawesome/free-regular-svg-icons';
// import {} from '@fortawesome/free-brands-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';

library.add(
  fasHeart,
  farHeart
);

Vue.component('font-awesome-icon', FontAwesomeIcon);
