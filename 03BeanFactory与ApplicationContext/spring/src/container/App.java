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
	//ʹ��BeanFactory
	/*����̨�����
	  -----------------------------------
           ����Person.......
      container.Person@1efee8e7*/
	/*���ۣ�BeanFactory���ӳٳ�ʼ�����ص㣬�ڴ���Spring������ʱ�򣬲�������ȥ���������й����Bean����
	              ����Ҫ�ȵ���������ȥ��ȡ�����ʱ�򣬲�ȥ��������*/	
	@Test
	void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource("container/ContainerTest-context.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("-----------------------------------");
		Person p = factory.getBean("person",Person.class);
		System.out.println(p);
	}

	//ʹ��ApplicationContext
	/*����̨�����
	   ����Person.......
      -----------------------------------
      container.Person@13c10b87*/
	//���ۣ�ApplicationContext������Spring������ʱ��ͻᴴ�����е�bean��������ȵ���ȡbean��ʱ���ȥ��ʼ��
	@Test
	void testApplicationContext() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("container/ContainerTest-context.xml");
		System.out.println("-----------------------------------");
		Person p = ctx.getBean("person",Person.class);
		System.out.println(p);
	}
}
