import qs from 'qs';
import axios from 'axios';

let server = {};

const baseUrl = {
  local: '127.0.0.1:20000',
  server: 'https://xxx.com'
};

server.baseUrl = baseUrl.local;

server.localTokenKey = 'karlLocalToken';

server.getToken = function () {
  return localStorage.getItem(server.localTokenKey);
};

server.saveToken = function (info) {
  if (info) {
    localStorage.setItem(server.localTokenKey, info);
    return;
  }
  console.error('save tokeninfo is null');
};

/**
 * ajax请求的方法
 *
 * @param {string} url 请求地址
 * @param {object} param 请求参数
 * @param {Function} cb 回调函数
 * @param {string} method 请求方法
 */
server.ajax = function (url, param, cb, method) {
  param = qs.stringify(param, { allowDots: true });
  if (method == 'get' || method == 'GET') {
    url = url + '?' + param;
    param = '';
  }
  method = method ? method : 'post';
  url = server.baseUrl + url;
  let promise = axios({
    url: url,
    data: param,
    method: method,
    headers: {
      token: server.getToken()
    }
  });

  promise
    .then((resp) => {
      server.saveToken(resp.data.token);
      cb(resp.data);
    })
    .catch((error) => {
      cb({ code: 500, success: false, message: '请求发生错误!', error: error });
    });
};

// 上传文件大小限制(2MB)
const MAX_FILE_SIZE = 2 * 1024 * 1024;

/**
 * 文件上传的方法
 *
 * @param {string} url 请求地址
 * @param {File} file 文件
 * @param {object} params 请求信息
 * @param {Function} cb 回调函数
 */
server.sendFile = function (url, file, params, cb) {
  if (file == null || !file) {
    cb({
      code: 500,
      success: false,
      message: '必须选择文件!'
    });
  }
  if (file.size > MAX_FILE_SIZE) {
    cb({ code: 500, success: false, message: '文件大小超过限制!' });
    return;
  }
  url = server.baseUrl + url;
  let formdata = new FormData();
  formdata.append('file', file);
  for (let key in params) {
    formdata.append(key, params[key]);
  }
  let promise = axios({
    url: url,
    data: formdata,
    method: 'post',
    headers: {
      token: server.getToken(),
      'Content-Type': 'multipart/form-data'
    }
  });
  promise
    .then(function (resp) {
      server.saveToken(resp.data.token);
      cb(resp.data);
    })
    .catch(function (error) {
      console.error('上传文件发生错误', error);
      cb({
        code: 500,
        message: '上传文件发生错误!',
        success: false,
        error: error
      });
    });
};

export default server;
