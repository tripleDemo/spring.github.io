package code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import code.service.IAcountService;

@SpringJUnitConfig(classes=AppConfig.class)
public class App {
	@Autowired
	private IAcountService service;
	
	@Test
	void testTrans() throws Exception {
		service.trans(10086L, 10010L, 1000);
	}
}
