package aop.dao;

import org.springframework.stereotype.Repository;

import aop.domain.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	public void save(Employee emp) {
		System.out.println("保存员工");
	}

	public void update(Employee emp) {
		System.out.println("修改员工");
	}

}
