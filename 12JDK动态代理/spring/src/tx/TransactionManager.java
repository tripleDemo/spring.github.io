package tx;

//ģ�����������
public class TransactionManager {
	public void begin() {
		System.out.println("��������");
	}
	
	public void commit() {
		System.out.println("�ύ����");
	}
	
	public void rollback() {
		System.out.println("�ع�����");
	}
}
