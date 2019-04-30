package aop.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//模拟事务管理器
@Component
@Aspect //配置一个切面
public class TransactionManager {
	
	//XML:<aop:pointcut id="txPoint" expression="execution(* aop.service.*Service*.*(..))"/>
	@Pointcut("execution(* aop.service.*Service*.*(..))")
	public void txPoint() {}
	
	//@Before("txPoint()")
	public void begin(JoinPoint jp) {
		/*
		 * System.out.println("代理对象:"+jp.getThis().getClass());
		 * System.out.println("目标对象:"+jp.getTarget().getClass());
		 * System.out.println("被增强方法的参数:"+Arrays.toString(jp.getArgs()));
		 * System.out.println("连接点方法签名:"+jp.getSignature());
		 * System.out.println("当前连接点的类型:"+jp.getKind());
		 */
		System.out.println("开启事务");
	}
	
	//@AfterReturning("txPoint()")
	public void commit() {
		System.out.println("提交事务");
	}
	
	//@AfterThrowing(value="txPoint()",throwing="ex")
	public void rollback(Throwable ex) {
		System.out.println("回滚事务,异常信息："+ex.getMessage());
	}
	
	//@After("txPoint()")
	public void close() {
		System.out.println("释放资源");
	}
	
	@Around("txPoint()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object ret = null;
		System.out.println("开启事务");
		try {
			pjp.proceed();//调用真实对象的方法
			System.out.println("记录日志");
			System.out.println(".........执行真实对象中的方法...............");
			System.out.println("提交事务");
		} catch(Throwable e) {
			System.out.println("回滚事务,异常信息："+e.getMessage());
		} finally {
			System.out.println("释放资源");
		}
		return ret;
	}
}
