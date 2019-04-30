package action;

import domain.User;
import service.IUserService;

//ģ��Struts2��Action/SpringMVC��Controller
public class UserAction {
	private IUserService service;
	
	public void setService(IUserService service) {
		this.service = service;
	}

	public String execute() {
		System.out.println("ע������");
		service.register(new User());
		return "success";
	}
}
