package top.karl.games_rent_no_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.karl.api.spring.UtilMessage;
import top.karl.games_rent_no_service.message.WebConfigMessage;
import top.karl.games_rent_no_service.model.WebConfigModel;
import top.karl.games_rent_no_service.service.WebConfigService;

/**
 * 前端网页配置控制器
 *
 * @author karl
 *
 */

@Api(tags = { "文档一级菜单标题" })
@RestController
@RequestMapping("/一级路径")
public class WebConfigController {

	@Autowired
	private WebConfigService webConfigService;

	@ApiOperation(value = "二级菜单标题")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "info", value = "请求的内容", paramType = "query", required = true),
			@ApiImplicitParam(name = "token", value = "用户认证令牌", paramType = "header", required = true) })
	@PostMapping("/二级路径")
	public UtilMessage<?> sysout(templateModel) throws Exception {
		return templateService.sysout(templateModel);
	}

}
