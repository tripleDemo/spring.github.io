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
		ctx.close();//�ֶ��ر�Spring����
	}
	
	@Test
	void test2() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/App-context.xml");
		MyDateSource ds = ctx.getBean("ds", MyDateSource.class);
		ds.doWork();
		ctx.registerShutdownHook();//��Spring�߳���ΪJVM�����̣߳�JVM�ڽ�������ǰ��Spring���߳̽��������˽⣩
	}
}
