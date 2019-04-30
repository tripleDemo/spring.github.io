package aop.service;

import aop.domain.Employee;

public interface IEmployeeService {
	
	void save(Employee emp);

	void update(Employee emp);
}
