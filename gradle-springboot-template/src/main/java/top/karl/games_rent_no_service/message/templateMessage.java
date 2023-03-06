package top.karl.games_rent_no_service.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import top.karl.api.spring.PageBean;
import top.karl.games_rent_no_service.entity.Grn_admin_collection;

/**
 * 应答类
 *
 * @author karl
 *
 */

@ApiModel(value = "类名", description = "应答信息说明")
public class templateMessage {

  // 应答的集合
  @ApiModelProperty(value = "应答的集合")
  private List<Object> list;

  // 分页信息
  @ApiModelProperty(value = "分页信息")
  private PageBean page;
}
