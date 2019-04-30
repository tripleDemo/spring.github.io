package spring_test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


//SpringTest�����Ĳ���

//Spring��jUnit5��ʽ
@SpringJUnitConfig
public class SpringTestTest {
	
	@Autowired
	private SomeBean bean;
	
	@Test
	void testName() throws Exception {
		bean.doWork();
	}
}
