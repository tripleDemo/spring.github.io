package spring;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	
	//��ͳ��ʽ�����أ��������ֶ����������󣬺ʹ������������Ķ��󣬲���װ������ϵ
	@org.junit.jupiter.api.Test
	void testName() throws Exception {
		Hello hello = new Hello();
		hello.setUsername("bbbb");
		hello.sayHello();
	}
	
	//ʹ��spring���֮��
	@org.junit.jupiter.api.Test
	void testIoC() throws Exception {
		Hello hello = null;
		//------------------------------
		//1.��classpath·��ȥѰ�������ļ���������Դ����
		Resource resource = new ClassPathResource("applicationContext.xml");
		//2.������Դ���󣬴���Spring IoC��������
		BeanFactory factory = new XmlBeanFactory(resource);
		//3.��Spring IoC�����л�ȡָ�����ƵĶ���
		//ǩ��һ��Object getBean(String beanName)://���ݶ����������е���������ȡ		
		//hello = (Hello) factory.getBean("helloBean");
		//ǩ������<T> T getBean(Class<T> requiredType)//����ָ��������ȥѰ��bean����
		//hello = factory.getBean(Hello.class);
		//ǩ������<T> T getBean(String name, Class<T> requiredType)//����bean������+id����ȥѰ�ң��Ƽ���
		hello = factory.getBean("helloBean",Hello.class);
		//-------------------------------
		hello.sayHello();
	}
	
	//ģ��spring IoC��������
	@org.junit.jupiter.api.Test
	void testIoCMock() throws Exception {
		String className = "spring.Hello";
		Hello hello = null;
		//ʹ�÷��䴴������
		Class clzz = Class.forName(className);
		Constructor con = clzz.getConstructor();
		Object obj = con.newInstance();
		//ʹ����ʡ������������ֵ
		BeanInfo beanInfo = Introspector.getBeanInfo(clzz,Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds) {
			//Hello�������е���������
			String propertyName = pd.getName();
			if("username".equals(propertyName)) {
				//����username��setter����
				pd.getWriteMethod().invoke(obj, "Gogo");
			}else if("age".equals(propertyName)) {
				//����age��setter����
				pd.getWriteMethod().invoke(obj, 18);
			}
		}
		hello = (Hello) obj;
		hello.sayHello();
	}
}
