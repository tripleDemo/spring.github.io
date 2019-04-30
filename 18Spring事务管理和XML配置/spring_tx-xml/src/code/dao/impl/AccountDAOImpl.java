package code.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import code.dao.IAccountDAO;

public class AccountDAOImpl implements IAccountDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public void transOut(Long outId, int money) {
		jdbcTemplate.update("update account set balance = balance - ? where id = ?",money,outId);
	}

	public void transIn(Long inId, int money) {
		jdbcTemplate.update("update account set balance = balance + ? where id = ?",money,inId);
	}
}
