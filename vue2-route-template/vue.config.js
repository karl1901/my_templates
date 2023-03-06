module.exports = {
  // 生成环境不需要map文件
  productionSourceMap: !process.env.NODE_ENV === 'production',
  // 项目输出路径(build后项目保存的路径)
  // outputDir: 'D:\\karlword\\aliyun.code\\test-server\\' +'导出后的文件夹名称',
  // 服务器虚拟路径(判断是否是本地启动还是服务器启动)
  // publicPath: process.env.NODE_ENV === 'production' ? '/back/' : '/'
};
