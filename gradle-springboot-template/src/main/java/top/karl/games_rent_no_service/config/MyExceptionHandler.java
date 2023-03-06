package top.karl.games_rent_no_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.karl.api.external.MailUtil;
import top.karl.api.spring.UtilMessage;

/**
 * 控制器全局错误处理器 <br>
 * ControllerAdvice注解表示是控制器层拦截处理（AOP-面向切面编程）<br>
 * ExceptionHandler注解表示方法为错误处理器，参数是错误的类型
 *
 * @author karl
 *
 */

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(
    MyExceptionHandler.class
  );

  @ExceptionHandler(Exception.class)
  public UtilMessage<?> handleException(Exception ex) throws Exception {
    // 控制台打印错误
    log.error("服务器处理发生错误: " + ex);
    // 打印具体错误
    ex.printStackTrace();
    // 声明中心应答对象
    UtilMessage<?> message = new UtilMessage<>();
    // 如果资源不存在
    if (ex instanceof NoHandlerFoundException) {
      // 返回资源不存在的应答信息
      message.setFalseMessage("404,资源不存在!", null);
      return message;
    }
    // 返回服务器繁忙的应答信息
    message.setFalseMessage("服务器繁忙，请稍后重试!", null);
    return message;
  }
}
