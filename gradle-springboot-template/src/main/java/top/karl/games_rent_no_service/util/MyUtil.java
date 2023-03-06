package top.karl.games_rent_no_service.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import top.karl.api.external.IpUtil;
import top.karl.api.external.JsonUtil;

/**
 * 自定义工具类
 *
 * @author karl
 *
 */

public class MyUtil {

	private static final Logger log = LoggerFactory.getLogger(MyUtil.class);

	/**
	 * 封装JSON格式化对象的方法
	 *
	 * @param object java对象
	 * @return JSON字符串
	 */
	public static String jsonStringify(Object object) {
		String jsonStr = null;
		try {
			jsonStr = JsonUtil.JsonStringify(object);
		} catch (Exception ex) {
			log.error("自定义工具类JSON格式化对象发生错误: " + ex);
		}
		return jsonStr;
	}

	/**
	 * 获取客户端ip地址
	 *
	 * @return 客户端ip地址
	 *
	 * @throws Exception 处理发生异常
	 */
	public static String getIpAddress() throws Exception {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		return IpUtil.getIpAddr(request);
	}

}
