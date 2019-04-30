package createBean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {
	@Autowired
	private Cat1 c1;
	@Autowired
	private Cat2 c2;
	@Autowired
	private Cat3 c3;
	@Autowired
	private Cat4 c4;
	@Autowired
	private Cat4 c44;
	
	@Test
	void testOld() throws Exception {
		//��ʽ1��������
		Cat1 c1 = new Cat1();
		//��ʽ2����̬��������
		Cat2 c2 = Cat2Factory.createInstance();
		//��ʽ3��ʵ����������
		Cat3 c3 = new Cat3Factory().createInstance();
	}
	
	@Test
	void test() throws Exception {
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c44);
	}
}
