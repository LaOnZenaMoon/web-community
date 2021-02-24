import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from "@/views/Login";
import MainLayout from "@/views/MainLayout";
import {checkTokenExpired} from "@/api/token-control";
import {basicLogger} from "@/common/logger";
import {moveSignInPage} from "@/api/api-control";
import Main from "@/views/Main";

Vue.use(VueRouter)

const movePage = () => (to, from, next) => {
  basicLogger(from);
  basicLogger(to);
  basicLogger(next);

  if (checkTokenExpired()) {
    next();
    return;
  }

  moveSignInPage();
};


const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/',
    component: MainLayout,
    redirect: 'main',
    beforeEnter: movePage(),
    children: [
      {
        path: '/main',
        name: 'Main',
        component: Main
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
