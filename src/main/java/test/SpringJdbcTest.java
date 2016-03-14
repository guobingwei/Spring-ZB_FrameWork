package test;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;



/**
 * Created by john on 2016/3/14.
 */
public class SpringJdbcTest {
    private static final Logger log = LoggerFactory.getLogger(SpringJdbcTest.class);
    private static ApplicationContext ctx = null;

    //表示在所以测试方法之前执行，且只执行一次。
    public static void onlyOnce() {
        ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }


    public void testSave(){
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.saveUser();
    }

    public void testSaveThrowException() throws Exception{
        IUserService service=ctx.getBean("userService",IUserService.class);
        service.saveUserThrowException();
    }

    public void testJDBCDaoQuery(){
        IUserService service=ctx.getBean("userService", IUserService.class);
        service.findUsers();
    }

    public static void  main(String [] args) {
        User user = new User();
        user.getAge();
    }
}
