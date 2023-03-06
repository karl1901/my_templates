package top.karl.games_rent_no_service.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.karl.games_rent_no_service.dao.UtilDao;
import top.karl.games_rent_no_service.service.AdminMessageService;
import top.karl.games_rent_no_service.service.OrdersService;
import top.karl.games_rent_no_service.service.UtilService;

/**
 * 定时任务
 *
 * @author karl
 *
 */

@Component
public class ScheduleTask {

  private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

  /**
   * 定时任务名称 <br>
   * 开始：3秒后 <br>
   * 循环: 1分钟
   */
  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 1 * 60 * 1000)
  public void systemOut() {
    try {
      log.debug("定时任务", System.currentTimeMillis());
    } catch (Exception e) {
      log.error("定时任务发生错误", e);
    }
  }
}
