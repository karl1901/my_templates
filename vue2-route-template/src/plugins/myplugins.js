import server from '../js/server';
import tools from '../js/tools';
import myTools from '../util/myTools';

let myplugin = {};

myplugin.install = function (Vue) {
  Vue.prototype.$ajax = function (url, param, method, cb) {
    server.ajax(url, param, method, cb);
  };

  Vue.prototype.$upFile = function (url, file, param, cb) {
    server.sendFile(url, file, param, cb);
  };

  Vue.prototype.$openFile = function (cb) {
    tools.openFile(cb);
  };

  Vue.prototype.$getCssText = function (className) {
    return myTools.getCssText(className);
  };

  Vue.prototype.$copyText = function (text) {
    return tools.copyText(text);
  };
};

export default myplugin;
