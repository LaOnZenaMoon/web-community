import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from "@/pages/Main";
import Market from "@/pages/Market";
import NotFound from "@/pages/NotFound";
import createCommonBoard from "@/pages/CommonBoard";

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  },
  {
    path: '/notice/board',
    name: 'Notice',
    component: createCommonBoard('Notice'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/column/board',
    name: 'Column',
    component: createCommonBoard('Column'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/free/board',
    name: 'Free Community',
    component: createCommonBoard('Free Community'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/expert/board',
    name: 'Expert Community',
    component: createCommonBoard('Expert Community'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/multimedia/board',
    name: 'Multimedia',
    component: createCommonBoard('Multimedia'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/comedy/board',
    name: 'Comedy',
    component: createCommonBoard('Comedy'),
    beforeEnter: (to, from, next) => {
      next();
    },
  },
  {
    path: '/market',
    name: 'Market',
    component: Market,
  },
  {
    path: '*',
    name: 'NotFound',
    component: NotFound,
    children: [
      {
        path: '*',
        name: 'NotFound',
        component: NotFound
      },
    ]
  },
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
