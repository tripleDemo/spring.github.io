package tx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@SuppressWarnings("all")
//�������ǿ����
public class TransactionManagerAdvice implements InvocationHandler {
	private Object target;//��ʵ���󣨶�˭����ǿ��
	private TransactionManager txManager;//���������(ģ��)
	
	public void setTarget(Object target) {
		this.target = target;
	}
		
	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

	public <T> T getProxyObject(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),//���������һ�������ʵ������������
				target.getClass().getInterfaces(),//��ʵ������ʵ�ֵĽӿڣ�JDK��̬�������Ҫ����ʵ�����нӿڣ�
				this);//�����������ǿ�Ķ���
	}

	//���Ϊ��ʵ����ķ�������ǿ�ľ������
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		txManager.begin();
		Object ret = null;
		try {
		//--------------------------------------------------------------
		ret = method.invoke(target, args);//������ʵ����ķ���
		//--------------------------------------------------------------
		txManager.commit();
		} catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
		return ret;
	}
}
