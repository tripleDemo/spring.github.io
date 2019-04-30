package bean_tag_inheritance;

public class SomeBean2 {
	private String name;
	private int age;
	private int weight;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "SomeBean2 [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

}
