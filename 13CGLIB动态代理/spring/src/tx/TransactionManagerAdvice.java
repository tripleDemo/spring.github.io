package tx;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

@SuppressWarnings("all")
//事务的增强操作-CGLIB
public class TransactionManagerAdvice implements InvocationHandler {
	private Object target;//真实对象（对谁做增强）
	private TransactionManager txManager;//事务管理器(模拟)
	
	public void setTarget(Object target) {
		this.target = target;
	}
		
	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}

	//创建一个代理对象
	public <T> T getProxyObject(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());//将继承于哪一个类，去做增强
		enhancer.setCallback(this);//设置增强的对象
		return (T) enhancer.create();//创建代理对象
	}

	//如何为真实对象的方法做增强的具体操作
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		txManager.begin();
		Object ret = null;
		try {
		//--------------------------------------------------------------
		ret = method.invoke(target, args);//调用真实对象的方法
		//--------------------------------------------------------------
		txManager.commit();
		} catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
		return ret;
	}
}
