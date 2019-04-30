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

//ģ�����������
@Component
@Aspect //����һ������
public class TransactionManager {
	
	//XML:<aop:pointcut id="txPoint" expression="execution(* aop.service.*Service*.*(..))"/>
	@Pointcut("execution(* aop.service.*Service*.*(..))")
	public void txPoint() {}
	
	//@Before("txPoint()")
	public void begin(JoinPoint jp) {
		/*
		 * System.out.println("�������:"+jp.getThis().getClass());
		 * System.out.println("Ŀ�����:"+jp.getTarget().getClass());
		 * System.out.println("����ǿ�����Ĳ���:"+Arrays.toString(jp.getArgs()));
		 * System.out.println("���ӵ㷽��ǩ��:"+jp.getSignature());
		 * System.out.println("��ǰ���ӵ������:"+jp.getKind());
		 */
		System.out.println("��������");
	}
	
	//@AfterReturning("txPoint()")
	public void commit() {
		System.out.println("�ύ����");
	}
	
	//@AfterThrowing(value="txPoint()",throwing="ex")
	public void rollback(Throwable ex) {
		System.out.println("�ع�����,�쳣��Ϣ��"+ex.getMessage());
	}
	
	//@After("txPoint()")
	public void close() {
		System.out.println("�ͷ���Դ");
	}
	
	@Around("txPoint()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object ret = null;
		System.out.println("��������");
		try {
			pjp.proceed();//������ʵ����ķ���
			System.out.println("��¼��־");
			System.out.println(".........ִ����ʵ�����еķ���...............");
			System.out.println("�ύ����");
		} catch(Throwable e) {
			System.out.println("�ع�����,�쳣��Ϣ��"+e.getMessage());
		} finally {
			System.out.println("�ͷ���Դ");
		}
		return ret;
	}
}
