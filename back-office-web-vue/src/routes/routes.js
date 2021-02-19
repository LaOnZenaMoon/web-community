import SignIn from "@/views/lozm/SignIn";
import MainLayout from "@/views/lozm/MainLayout";
import Main from "@/views/lozm/Main";
import NotFound from "@/views/lozm/NotFound";
import DashboardLayout from "@/views/Layout/DashboardLayout";
import AuthLayout from "@/views/Pages/AuthLayout";

const routes = [
  {
    path: '/signIn',
    component: SignIn,
  },
  {
    path: '/page',
    component: MainLayout,
    children: [
      {
        path: '/main',
        name: 'main',
        component: Main
      },
      {
        path: '*',
        name: 'Not Found',
        component: NotFound
      }
    ],
  },

  {
    path: '/test',
    redirect: 'dashboard',
    component: DashboardLayout,
    children: [
      {
        path: '/dashboard',
        name: 'dashboard',
        component: () => import('../views/Dashboard.vue')
      },
      {
        path: '/icons',
        name: 'icons',
        component: () => import('../views/Icons.vue')
      },
      {
        path: '/profile',
        name: 'profile',
        component: () => import('../views/Pages/UserProfile.vue')
      },
      {
        path: '/maps',
        name: 'maps',
        component: () => import('../views/GoogleMaps.vue')
      },
      {
        path: '/tables',
        name: 'tables',
        component: () => import('../views/RegularTables.vue')
      }
    ]
  },
  {
    path: '/test',
    redirect: 'login',
    component: AuthLayout,
    children: [
      {
        path: '/login',
        name: 'login',
        component: () => import('../views/Pages/Login.vue')
      },
      {
        path: '/register',
        name: 'register',
        component: () => import('../views/Pages/Register.vue')
      },
      { path: '*', component: NotFound }
    ]
  }
];

export default routes;
