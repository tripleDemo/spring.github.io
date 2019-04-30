package log;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//日志增强
public class LogAdvice implements MethodInterceptor {
	private Object target;//真实对象
	private LogUtil logUtil;

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setLogUtil(LogUtil logUtil) {
		this.logUtil = logUtil;
	}

	//创建代理对象
	public <T> T getProxyObject() {
		/*Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();*/
		return (T) Enhancer.create(target.getClass(),this);
	}
	
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		logUtil.writeLog(method.getDeclaringClass().getName(),method.getName());
		Object ret = method.invoke(target, args);
		return ret;
	}

}
