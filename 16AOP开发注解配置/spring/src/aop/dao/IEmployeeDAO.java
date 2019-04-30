package aop.dao;

import aop.domain.Employee;

public interface IEmployeeDAO {
	
	void save(Employee emp);
	
	void update(Employee emp);
}
