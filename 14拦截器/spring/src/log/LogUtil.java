package log;

import java.util.Date;

//��service��������֮ǰ������־��¼
public class LogUtil {
	public void writeLog(String className,String methodName) {
		System.out.println(new Date().toLocaleString()+"������"+className+"���е�"+methodName+"����");
	}
}
