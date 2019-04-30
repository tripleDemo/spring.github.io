package service;

import dao.IUserDAO;
import domain.User;

public class IUserServiceImpl implements IUserService {

	private IUserDAO dao;
	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}


	public void register(User user) {
		System.out.println("×¢²á²Ù×÷");
		dao.save(user);
	}

}
