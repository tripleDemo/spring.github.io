package container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ContainerTest {
	//@Autowired不仅可以注入容器中的对象，还可以注入容器对象
	@Autowired
	private Person person;
	@Autowired
	private BeanFactory beanFactory;
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	void test1() throws Exception {
		System.out.println(person);
		System.out.println(beanFactory);
		System.out.println(ctx);
	}
}
