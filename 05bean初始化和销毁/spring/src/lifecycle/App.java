package lifecycle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {
	@Test
	void testOld() throws Exception {
		//��������
		MyDateSource ds = new MyDateSource();
		//����Զ�������ʼ������
		ds.open();
		
		ds.doWork();
		//������֮ǰִ��ɨβ����
		ds.close();
	}
	
	@Autowired
	private MyDateSource myDateSource;
	
	@Test
	void testIoC() throws Exception {
		myDateSource.doWork();
	}
}
