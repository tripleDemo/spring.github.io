package code;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//��ǰ��Ŀ�������࣬�ñ���applicationContext.xml
@Configuration//��־��ǰ��Ϊһ��������
@Import(DataSourceConfig.class)//����������������
@ComponentScan //IoCע�������  //��д����Ĭ�ϴӵ�ǰ�������Ӱ���Ҫɨ��
@EnableTransactionManagement//����ע�������
public class AppConfig {

	//������������Bean
	@Bean
	public DataSourceTransactionManager txManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

}
