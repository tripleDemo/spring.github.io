package aop.dao;

import org.springframework.stereotype.Repository;

import aop.domain.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	public void save(Employee emp) {
		System.out.println("����Ա��");
	}

	public void update(Employee emp) {
		System.out.println("�޸�Ա��");
	}

}
