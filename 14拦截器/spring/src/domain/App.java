package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import log.LogAdvice;
import service.EmployeeServiceImpl;

@SpringJUnitConfig
public class App {
	@Autowired
	private LogAdvice advice;
	
	@Test
	void testSave() throws Exception {
		EmployeeServiceImpl proxy = advice.getProxyObject();
		proxy.save(new Employee());
	}
	
	@Test
	void testUpdate() throws Exception {
		EmployeeServiceImpl proxy = advice.getProxyObject();
		proxy.update(new Employee());
	}
}
