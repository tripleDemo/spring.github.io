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
	
	public void close() {
		System.out.println("�ͷ���Դ");
	}
	
	public Object aroundMethod() {
		Object ret = null;
		try {
			System.out.println("��¼��־");
			System.out.println(".........ִ����ʵ�����еķ���...............");
		} catch(Exception e) {
			
		} finally {
			
		}
		return ret;
	}
}
