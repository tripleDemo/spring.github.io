package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.EmployeeServiceImpl;


@SpringJUnitConfig
public class App {
	@Autowired
	private EmployeeServiceImpl service;
	
	@Test
	void testSave() throws Exception {
		System.out.println(service.getClass());
		service.save(new Employee());
	}
	
	@Test
	void testUpdate() throws Exception {
		service.update(new Employee());
	}
}
