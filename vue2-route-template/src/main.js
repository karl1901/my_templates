import Vue from 'vue';
import App from './App.vue';
import router from './router';

import './filter/myfilter';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import myplugins from './plugins/myplugins';
Vue.use(myplugins);

Vue.config.productionTip = false;

import myTools from './util/myTools';
myTools.errorHandler(Vue);

new Vue({
  router,
  render: (h) => h(App)
}).$mount('#app');
