package di_setter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {
	@Autowired
	private Employee1 employee;
	@Autowired
	private Person1 person1;
	@Autowired
	private CollectionBean1 collectionBean1;
	
	@Test
	void test() throws Exception {
		System.out.println(employee);
		System.out.println(person1);
		System.out.println(collectionBean1);
	}
}
