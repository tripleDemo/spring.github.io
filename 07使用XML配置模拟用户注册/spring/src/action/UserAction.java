package action;

import domain.User;
import service.IUserService;

//模拟Struts2的Action/SpringMVC的Controller
public class UserAction {
	private IUserService service;
	
	public void setService(IUserService service) {
		this.service = service;
	}

	public String execute() {
		System.out.println("注册请求");
		service.register(new User());
		return "success";
	}
}
