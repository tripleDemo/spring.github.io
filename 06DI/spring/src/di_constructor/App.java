package di_constructor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {
	@Autowired
	private Employee2 employee;
	@Autowired
	private Person2 person;
	@Autowired
	private CollectionBean2 collectionBean;
	//@Autowired
	private Cat2 c2;
	
	@Test
	void test() throws Exception {
		System.out.println(employee);
		System.out.println(person);
		System.out.println(collectionBean);
		System.out.println(c2);
	}
}
