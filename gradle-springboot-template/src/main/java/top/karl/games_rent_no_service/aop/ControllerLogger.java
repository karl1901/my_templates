package top.karl.games_rent_no_service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制器日志切面
 *
 * @author karl
 *
 */

@Aspect
@Component
public class ControllerLogger extends BaseControllerAop {

	private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

	@Before("controller()")
	public void before(JoinPoint jp) throws Exception {
		log.debug("进入日志记录===>", jp.getSignature());
		Object[] args = jp.getArgs();
		if (args == null || args.length == 0) {
			log.debug("方法没有传入参数!");
		} else {
			log.debug("参数列表:");
			for (Object arg : args) {
				log.debug("{" + arg + "}");
			}
		}
	}

	@After("controller()")
	public void after(JoinPoint jp) throws Exception {
		log.debug("日志记录完毕===>", jp.getSignature());
	}

	@AfterReturning(pointcut = "controller()", returning = "result")
	public void returning(JoinPoint jp, Object result) throws Exception {
		log.debug("日志记录返回值===>", jp.getSignature(), result);
	}

}
