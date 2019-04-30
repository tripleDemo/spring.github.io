package value;

import org.springframework.beans.factory.annotation.Value;

public class ValueBean {
	@Value("${server.port}")
	private int port;

	@Override
	public String toString() {
		return "ValueBean [port=" + port + "]";
	}
	
}
