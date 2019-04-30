package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	@Autowired(required=false)
	@Qualifier("cat3")
	//使用@Qulifier(“other”)标签来规定依赖对象按照bean的id和类型的组合方式去找
	private Cat c1;
	
	/*@Autowired
	public void setC1(Cat c1) {
		this.c1 = c1;
	}*/

	@Override
	public String toString() {
		return "Person [c1=" + c1 + "]";
	}
	
}
