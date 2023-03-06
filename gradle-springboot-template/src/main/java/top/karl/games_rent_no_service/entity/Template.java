package top.karl.games_rent_no_service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import top.karl.games_rent_no_service.util.MyUtil;

/**
 *
 * 实体类
 *
 * @author karl
 */
@ApiModel(value = "类名", description = "对应表名")
public class Grn_account_info {

  // 内容
  @ApiModelProperty(value = "内容")
  @ApiParam(hidden = true)
  private String info;
}
