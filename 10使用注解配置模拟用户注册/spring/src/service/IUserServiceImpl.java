package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import domain.User;

@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private IUserDAO dao;
	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}


	public void register(User user) {
		System.out.println("×¢²á²Ù×÷");
		dao.save(user);
	}

}
