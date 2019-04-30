package aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import aop.dao.IEmployeeDAO;
import aop.domain.Employee;

@Service
public class EmployeeServiceImpl {
	@Autowired
	private IEmployeeDAO dao;

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}

	public void save(Employee emp) {
		dao.save(emp);
		System.out.println("保存成功");
	}

	public void update(Employee emp) {
		dao.update(emp);
		throw new RuntimeException("故意错误的");
	}

}
