package zwl.learning.note.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zwl.learning.note.aop.demo.HelloWorld;
import zwl.learning.note.aop.primitive.Dao;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-23 下午2:29
 */
@ContextConfiguration("classpath:/spring/applicationContext-main.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AOPTest.class);

    @Autowired
    private Dao daoImpl;

    @Test
    public void testAop() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/aop.xml");

        Dao dao = daoImpl;
        dao.insert();
        LOGGER.info("----------分割线----------");
        dao.delete();
        LOGGER.info("----------分割线----------");
        dao.update();
    }

    @Test
    public void demoTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-main.xml");

        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");

        hw1.printHelloWorld();

        hw1.doPrint();

        hw2.printHelloWorld();
        hw2.doPrint();
    }
}
