package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import domain.User;
import service.IUserService;

@Controller
@Scope("prototype")
//ģ��Struts2��Action/SpringMVC��Controller
public class UserAction {
	@Autowired
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
