package top.karl.games_rent_no_service.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.karl.api.spring.PageBean;
import top.karl.api.spring.UtilMessage;
import top.karl.games_rent_no_service.dao.AdminCollectionDao;
import top.karl.games_rent_no_service.entity.Grn_admin_collection;
import top.karl.games_rent_no_service.message.AdminCollectionMessage;
import top.karl.games_rent_no_service.model.AdminCollectionModel;
import top.karl.games_rent_no_service.service.AdminCollectionService;

/**
 * 业务接口实现类
 *
 * @author karl
 *
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminCollectionServiceImpl implements AdminCollectionService {

  @Override
  public 返回的内容 queryAll(类 类名) throws Exception {
    // 业务逻辑处理
  }
}
