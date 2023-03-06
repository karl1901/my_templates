import Vue from 'vue';
import tools from '../js/tools';

Vue.filter('formatDate', function (value, format) {
  return tools.formatDate(value, format);
});

Vue.filter('formatFileSize', function (size) {
  return tools.formatFileSize(size);
});