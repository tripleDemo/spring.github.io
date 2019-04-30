package proxy;

import domain.Employee;
import service.IEmployeeService;
import tx.TransactionManager;

//��̬������
public class EmployeeServiceProxy implements IEmployeeService {
	private IEmployeeService target;//��ʵ����/ί�ж���
	private TransactionManager txManager;//���������

	public void setTarget(IEmployeeService target) {
		this.target = target;
	}

	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

	public void save(Employee emp) {
		txManager.begin();
		try {
			target.save(emp);
			txManager.commit();
		} catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}

	public void update(Employee emp) {
		txManager.begin();
		try {
			target.update(emp);
			txManager.commit();
		} catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}

}
