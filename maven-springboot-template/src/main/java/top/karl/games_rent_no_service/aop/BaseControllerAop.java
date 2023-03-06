package 项目包名.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 控制器切点定义
 *
 * @author karl
 *
 */

public class BaseControllerAop {

	// ..：任意级别，*：任意名称
	// 项目包名.controller..*.*(..)：控制包下任意级别子包任意类的任意方法里面任意参数
	// 定义切点为控制器包下的所有公开的方法
	@Pointcut("execution(public * 项目包名.controller..*.*(..))")
	public void controller() {
	}

}
