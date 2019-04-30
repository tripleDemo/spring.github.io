package di_constructor;

import java.math.BigDecimal;

public class Employee2 {
	private String name;
	private Integer age;
	private BigDecimal salary;
	
	public Employee2(String name, Integer age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
