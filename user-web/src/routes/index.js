import Vue from 'vue';
import VueRouter from 'vue-router';
import Main from "@/pages/Main";
import Board from "@/pages/Board";
import Market from "@/pages/Market";
import NotFound from "@/pages/NotFound";

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
        component: Board,
    },
    {
        path: '/column/board',
        name: 'Column',
        component: Board,
    },
    {
        path: '/free/board',
        name: 'Free Community',
        component: Board,
    },
    {
        path: '/expert/board',
        name: 'Expert Community',
        component: Board,
    },
    {
        path: '/multimedia/board',
        name: 'Multimedia',
        component: Board,
    },
    {
        path: '/comedy/board',
        name: 'Comedy',
        component: Board,
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
