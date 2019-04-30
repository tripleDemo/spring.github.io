package dao;

import domain.Employee;

public interface IEmployeeDAO {
	
	void save(Employee emp);
	
	void update(Employee emp);
}
