import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from "@/views/Main";
import createBoard from "@/views/createBoard";

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
    component: createBoard('Notice'),
  },
  {
    path: '/column/board',
    name: 'Column',
    component: createBoard('Column'),
  },
  {
    path: '/free/community/board',
    name: 'Free Community',
    component: createBoard('Free Community'),
  },
  {
    path: '/expert/community/board',
    name: 'Expert Community',
    component: createBoard('Expert Community'),
  },
  {
    path: '/multimedia/board',
    name: 'Multimedia',
    component: createBoard('Multimedia'),
  },
  {
    path: '/comedy/board',
    name: 'Comedy',
    component: createBoard('Comedy'),
  },
  {
    path: '/market/board',
    name: 'Market',
    component: createBoard('Market'),
  },
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
