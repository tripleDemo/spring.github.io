package lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
	@Test
	void test1() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/App-context.xml");
		MyDateSource ds = ctx.getBean("ds", MyDateSource.class);
		ds.doWork();
		ctx.close();//手动关闭Spring容器
	}
	
	@Test
	void test2() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/App-context.xml");
		MyDateSource ds = ctx.getBean("ds", MyDateSource.class);
		ds.doWork();
		ctx.registerShutdownHook();//把Spring线程作为JVM的子线程，JVM在结束程序前把Spring子线程结束掉（了解）
	}
}
