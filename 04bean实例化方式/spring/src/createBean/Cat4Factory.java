package createBean;

import org.springframework.beans.factory.FactoryBean;

//createbean_04_factory_bean
public class Cat4Factory implements FactoryBean<Cat4> {
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	
	//实例工厂方法：
	@Override
	public Cat4 getObject() throws Exception {
		System.out.println("username"+username);
		Cat4 c4 = new Cat4();
		return c4;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Cat4.class;
	}
	
	/*@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}*/
	
}
