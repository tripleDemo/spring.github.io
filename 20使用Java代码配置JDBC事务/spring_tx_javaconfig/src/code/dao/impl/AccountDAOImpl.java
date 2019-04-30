package code.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import code.dao.IAccountDAO;

@Repository
public class AccountDAOImpl implements IAccountDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
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
