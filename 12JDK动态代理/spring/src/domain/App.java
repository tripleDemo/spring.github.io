package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import service.IEmployeeService;
import tx.TransactionManagerAdvice;

@SpringJUnitConfig
public class App {
	@Autowired
	private TransactionManagerAdvice advice;

	//代理对象com.sun.proxy.$Proxy19
	@Test
	void testSave() throws Exception {
		//获取代理对象
		IEmployeeService proxy = advice.getProxyObject();
		proxy.save(new Employee());
	}

	@Test
	void testUpdate() throws Exception {
		//获取代理对象
		IEmployeeService proxy = advice.getProxyObject();
		proxy.update(new Employee());
	}
}
