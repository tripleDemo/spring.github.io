package service;

import dao.IEmployeeDAO;
import domain.Employee;

public class EmployeeServiceImpl {
	
	private IEmployeeDAO dao;

	public void setDao(IEmployeeDAO dao) {
		this.dao = dao;
	}

	public void save(Employee emp) {
		dao.save(emp);
		System.out.println("����ɹ�");
	}

	public void update(Employee emp) {
		dao.update(emp);
		throw new RuntimeException("��������");
	}

}
