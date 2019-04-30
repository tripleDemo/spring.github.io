package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import service.EmployeeServiceImpl;
import tx.TransactionManagerAdvice;

@SpringJUnitConfig
public class App {
	@Autowired
	private TransactionManagerAdvice advice;

	//JDK代理对象：com.sun.proxy.$Proxy19
	//CGLIB代理对象：service.EmployeeServiceImpl$$EnhancerByCGLIB$$9c4bd1e5
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
