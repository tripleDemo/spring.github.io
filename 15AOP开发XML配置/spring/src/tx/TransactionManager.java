package tx;

//模拟事务管理器
public class TransactionManager {
	public void begin() {
		System.out.println("开启事务");
	}
	
	public void commit() {
		System.out.println("提交事务");
	}
	
	public void rollback() {
		System.out.println("回滚事务");
	}
	
	public void close() {
		System.out.println("释放资源");
	}
	
	public Object aroundMethod() {
		Object ret = null;
		try {
			System.out.println("记录日志");
			System.out.println(".........执行真实对象中的方法...............");
		} catch(Exception e) {
			
		} finally {
			
		}
		return ret;
	}
}
