package xml_autowired;
//������Spring���Ҵ���Person���󣬶�Person������Ҫ����Dog����
public class Person {
	private Dog dog;
	
	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Person(Dog dog) {
		this.dog = dog;
	}
	
	@Override
	public String toString() {
		return "Person [dog=" + dog + "]";
	}
	
}
