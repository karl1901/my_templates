package top.karl.games_rent_no_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot启动类 <br>
 * MapperScan注解: 配置Mapper包 <br>
 * EnableScheduling注解: 启用定时任务
 *
 * @author karl
 *
 */

@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	/**
	 * SpringBoot项目启动方法
	 *
	 * @param args 字符串数组
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * SpringBoot项目Build方法
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

}
