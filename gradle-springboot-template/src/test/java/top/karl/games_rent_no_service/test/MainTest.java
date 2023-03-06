package top.karl.games_rent_no_service.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.karl.api.templates.MyEntity;

/**
 * SpringBoot测试类
 *
 * @author karl
 *
 */

@SpringBootTest
public class MainTest {

  @Test
  public void Test() throws Exception {
    System.out.println("karl的springboot模板项目");
    // 调用生成实体类的方法
    //		sendEntity();
  }

  // 实体类生成方法封装
  public static final void sendEntity() {
    // 创建生成工具对象
    MyEntity myEntity = new MyEntity();
    // 设置生成的属性
    MyEntity.setCustomization_OutPut_Path(MyEntity.getDefaultOutputPath());
    MyEntity.setOpen_File(false);
    MyEntity.setOverride(true);
    MyEntity.setAuthor("作者");
    MyEntity.setSQL_Ip("数据库地址");
    MyEntity.setSQL_Port("3306");
    MyEntity.setSQL_Database_Name("数据库名称");
    MyEntity.setSQL_User_Name("数据库用户名");
    MyEntity.setSQL_User_Password("数据库用户密码");
    MyEntity.setEntity_Templates_Name("模板文件名称");
    MyEntity.setGenerate_Package_Name("包名(不包括实体类的包名))");
    MyEntity.setCustomization_Entity_Package_Name(
      MyEntity.getDefaultEntityPackageName()
    );
    MyEntity.setCreate_Table(MyEntity.getCreateTableNamePrefix());
    MyEntity.setTables_Prefix("");
    // 执行生成的方法
    myEntity.GeneratedEntity(
      myEntity.getSQL_URL(),
      MyEntity.getSqlDrivername()
    );
  }
}
