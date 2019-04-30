package spring_test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


//SpringTest案例的测试

//Spring的jUnit5方式
@SpringJUnitConfig
public class SpringTestTest {
	
	@Autowired
	private SomeBean bean;
	
	@Test
	void testName() throws Exception {
		bean.doWork();
	}
}
