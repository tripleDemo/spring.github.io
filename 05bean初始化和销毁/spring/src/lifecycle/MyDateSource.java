package lifecycle;

//ģ�����ݿ����ӳ�
public class MyDateSource {
	public MyDateSource() {
		System.out.println("��������........");
	}
	
	public void open() {
		System.out.println("������Դ........");
	}
	
	public void close() {
		System.out.println("�ͷ���Դ........");
	}
	
	public void doWork() {
		System.out.println("����........");
	}
}
