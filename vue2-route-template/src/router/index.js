import Vue from 'vue';
import VueRouter from 'vue-router';
import myTools from '../util/myTools';

Vue.use(VueRouter);

const routes = myTools.sendRoutes();

const router = new VueRouter({
  // url去#
  mode: 'history',
  routes
});

export default router;
