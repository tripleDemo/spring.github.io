package container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
	//使用BeanFactory
	/*控制台输出：
	  -----------------------------------
           构建Person.......
      container.Person@1efee8e7*/
	/*结论：BeanFactory有延迟初始化的特点，在创建Spring容器的时候，不会立马去创建容器中管理的Bean对象，
	              而是要等到从容器中去获取对象的时候，才去创建对象。*/	
	@Test
	void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource("container/ContainerTest-context.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("-----------------------------------");
		Person p = factory.getBean("person",Person.class);
		System.out.println(p);
	}

	//使用ApplicationContext
	/*控制台输出：
	   构建Person.......
      -----------------------------------
      container.Person@13c10b87*/
	//结论：ApplicationContext在启动Spring容器的时候就会创建所有的bean，而不会等到获取bean的时候才去初始化
	@Test
	void testApplicationContext() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("container/ContainerTest-context.xml");
		System.out.println("-----------------------------------");
		Person p = ctx.getBean("person",Person.class);
		System.out.println(p);
	}
}
