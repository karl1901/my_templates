import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue')
  },
];

const router = new VueRouter({
  // url去#
  mode: 'history',
  routes
});

export default router;