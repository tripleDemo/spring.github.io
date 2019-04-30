package bean_tag_inheritance;

public class SomeBean1 {
	private String name;
	private int age;
	private String color;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "SomeBean1 [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
}
