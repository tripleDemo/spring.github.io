package tx;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

@SuppressWarnings("all")
//�������ǿ����-CGLIB
public class TransactionManagerAdvice implements InvocationHandler {
	private Object target;//��ʵ���󣨶�˭����ǿ��
	private TransactionManager txManager;//���������(ģ��)
	
	public void setTarget(Object target) {
		this.target = target;
	}
		
	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

	//����һ���������
	public <T> T getProxyObject(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());//���̳�����һ���࣬ȥ����ǿ
		enhancer.setCallback(this);//������ǿ�Ķ���
		return (T) enhancer.create();//�����������
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
