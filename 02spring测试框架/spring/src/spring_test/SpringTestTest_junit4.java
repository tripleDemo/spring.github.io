package spring_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//SpringTest�����Ĳ���

//����Spring��jUnit4
@RunWith(SpringJUnit4ClassRunner.class)
//���������ö���(Ѱ�������ļ���)
@ContextConfiguration("classpath:spring_test/springtest.xml")
//@ContextConfiguration()������Ϊ��Ĭ��Ѱ���ļ�"������-context.xml"
public class SpringTestTest_junit4 {
	//��ʾ�Զ���������ȥSpring�������ҵ�bean���󣬲����ø����ֶ�
	@Autowired
	private SomeBean bean;
	
	@Test
	public void testIoC() throws Exception {
		bean.doWork();
		//����Spring���������ٴ����������л�ȡbean������ʹ��
	}
	
}
