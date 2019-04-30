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
	
	//传统方式，正控；调用者手动来创建对象，和创建队形依赖的对象，并组装依赖关系
	@org.junit.jupiter.api.Test
	void testName() throws Exception {
		Hello hello = new Hello();
		hello.setUsername("bbbb");
		hello.sayHello();
	}
	
	//使用spring框架之后
	@org.junit.jupiter.api.Test
	void testIoC() throws Exception {
		Hello hello = null;
		//------------------------------
		//1.从classpath路径去寻找配置文件，创建资源对象
		Resource resource = new ClassPathResource("applicationContext.xml");
		//2.根据资源对象，创建Spring IoC容器对象
		BeanFactory factory = new XmlBeanFactory(resource);
		//3.从Spring IoC容器中获取指定名称的对象
		//签名一：Object getBean(String beanName)://根据对象在容器中的名称来获取		
		//hello = (Hello) factory.getBean("helloBean");
		//签名二：<T> T getBean(Class<T> requiredType)//按照指定的类型去寻找bean对象
		//hello = factory.getBean(Hello.class);
		//签名三：<T> T getBean(String name, Class<T> requiredType)//根据bean的类型+id名称去寻找，推荐的
		hello = factory.getBean("helloBean",Hello.class);
		//-------------------------------
		hello.sayHello();
	}
	
	//模拟spring IoC容器操作
	@org.junit.jupiter.api.Test
	void testIoCMock() throws Exception {
		String className = "spring.Hello";
		Hello hello = null;
		//使用反射创建对象
		Class clzz = Class.forName(className);
		Constructor con = clzz.getConstructor();
		Object obj = con.newInstance();
		//使用内省机制设置属性值
		BeanInfo beanInfo = Introspector.getBeanInfo(clzz,Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds) {
			//Hello类中所有的属性名称
			String propertyName = pd.getName();
			if("username".equals(propertyName)) {
				//调用username的setter方法
				pd.getWriteMethod().invoke(obj, "Gogo");
			}else if("age".equals(propertyName)) {
				//调用age的setter方法
				pd.getWriteMethod().invoke(obj, 18);
			}
		}
		hello = (Hello) obj;
		hello.sayHello();
	}
}
