package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	@Autowired(required=false)
	@Qualifier("cat3")
	//ʹ��@Qulifier(��other��)��ǩ���涨����������bean��id�����͵���Ϸ�ʽȥ��
	private Cat c1;
	
	/*@Autowired
	public void setC1(Cat c1) {
		this.c1 = c1;
	}*/

	@Override
	public String toString() {
		return "Person [c1=" + c1 + "]";
	}
	
}
