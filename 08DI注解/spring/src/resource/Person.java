package resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	@Resource(name="cat1")
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
