let tools = {};

/**
 * 复制文本
 *
 * @param {string} text  要复制的文本
 */
tools.copyText = function (text) {
  let input = document.createElement('input');
  input.readOnly = 'readonly';
  input.value = text;
  document.body.appendChild(input);
  input.select();
  input.setSelectionRange(0, input.value.length);
  document.execCommand('Copy');
  document.body.removeChild(input);
};

/**
 * 格式化日期
 *
 * @param {string} value  日期时间戳
 * @param {string} format  格式化字符串(默认：yyyy-MM-dd hh:mm:ss)
 * @returns 格式化后的日期
 */
tools.formatDate = function (value, format) {
  try {
    format = format ? format : 'yyyy-MM-dd hh:mm:ss';
    if (!isNaN(value) && !(value instanceof Date)) {
      let time = new Date();
      time.setTime(parseInt(value));
      value = time;
    }
    let year = value.getFullYear() + '';
    let month = value.getMonth() + 1;
    let day = value.getDate();
    let hour = value.getHours();
    let minute = value.getMinutes();
    let second = value.getSeconds();
    month = month < 10 ? '0' + month : '' + month;
    day = day < 10 ? '0' + day : '' + day;
    hour = hour < 10 ? '0' + hour : '' + hour;
    minute = minute < 10 ? '0' + minute : '' + minute;
    second = second < 10 ? '0' + second : '' + second;
    format = format.replace(/yyyy/g, year);
    format = format.replace(/MM/g, month);
    format = format.replace(/dd/g, day);
    format = format.replace(/hh/g, hour);
    format = format.replace(/mm/g, minute);
    format = format.replace(/ss/g, second);
    return format;
  } catch (ex) {
    console.error(ex);
    return '';
  }
};

/**
 * 格式化文件大小
 *
 * @param {number} size 文件大小(单位：字节)
 *
 * @returns 格式化后的文件大小(带单位)
 */
tools.formatFileSize = function (size) {
  if (size == null || size == '') {
    return '0B';
  }
  let unitArr = new Array('B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB');
  let index = 0;
  let srcsize = parseFloat(size);
  index = Math.floor(Math.log(srcsize) / Math.log(1024));
  let sizes = srcsize / Math.pow(1024, index);
  // toFixed(保留的小数位数)
  sizes = sizes.toFixed(2);
  // 返回格式化后的文件大小(带单位)
  return sizes + unitArr[index];
};

/**
 * 打开文件
 *
 * @param {Function} cb 回调函数
 */
tools.openFile = function (cb) {
  let eleFile = document.createElement('input');
  eleFile.setAttribute('type', 'file');
  eleFile.addEventListener('change', function () {
    if (eleFile.files || eleFile.files.length == 1) {
      cb(eleFile.files[0]);
    } else {
      cb(null);
    }
  });

  eleFile.addEventListener('cancel', function () {
    cb(null);
  });

  eleFile.click();
};

export default tools;
