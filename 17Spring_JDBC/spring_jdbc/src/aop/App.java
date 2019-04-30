package aop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import aop.dao.IEmployeeDAO;
import aop.domain.Employee;

@SpringJUnitConfig
public class App {
	@Autowired
	private IEmployeeDAO dao;
	
	@Test
	void testSave() throws Exception {
		Employee e = new Employee();
		e.setName("tom");
		e.setAge(18);
		dao.save(e);
	}
	
	@Test
	void testUpdate() throws Exception {
		Employee e = new Employee();
		e.setName("tony");
		e.setAge(28);
		e.setId(3L);
		dao.update(e);
	}
	
	@Test
	void testDelete() throws Exception {
		dao.delete(1L);
	}
	
	@Test
	void testGet() throws Exception {
		Employee e = dao.get(2L);
		System.out.println(e);
	}
	
	@Test
	void testListAll() throws Exception {
		List<Employee> list = dao.listAll();
		for(Employee e : list) {
			System.out.println(list);
		}
	}
}
