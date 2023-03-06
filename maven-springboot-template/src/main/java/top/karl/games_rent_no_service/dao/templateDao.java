package top.karl.games_rent_no_service.dao;

import java.util.Date;
import org.apache.ibatis.annotations.Mapper;
import top.karl.games_rent_no_service.entity.Grn_token_info;

/**
 * 实体类方法接口
 *
 * @author karl
 *
 */

@Mapper
public interface templateDao {
  /**
   * 方法名称
   *
   * @return 返回的结构
   * @throws Exception 处理发生异常
   */
  Object template() throws Exception;
}
