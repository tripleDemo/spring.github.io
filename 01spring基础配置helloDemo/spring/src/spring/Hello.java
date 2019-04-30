package spring;

public class Hello {
	private String username;
	private int age;
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void sayHello() {
		System.out.println("this is my first spring! username="+username+",age="+age);
	}
}
