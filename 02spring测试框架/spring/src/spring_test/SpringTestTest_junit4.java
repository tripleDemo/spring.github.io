package spring_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//SpringTest案例的测试

//运行Spring的jUnit4
@RunWith(SpringJUnit4ClassRunner.class)
//上下文配置对象(寻找配置文件的)
@ContextConfiguration("classpath:spring_test/springtest.xml")
//@ContextConfiguration()若参数为空默认寻找文件"本类名-context.xml"
public class SpringTestTest_junit4 {
	//表示自动按照类型去Spring容器中找到bean对象，并设置给该字段
	@Autowired
	private SomeBean bean;
	
	@Test
	public void testIoC() throws Exception {
		bean.doWork();
		//创建Spring容器对象，再从容器对象中获取bean对象，再使用
	}
	
}
