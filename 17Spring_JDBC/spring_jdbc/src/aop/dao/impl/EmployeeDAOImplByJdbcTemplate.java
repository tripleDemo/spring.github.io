package aop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import aop.dao.IEmployeeDAO;
import aop.domain.Employee;

@Repository
public class EmployeeDAOImplByJdbcTemplate implements IEmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	//属性：dataSource
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@SuppressWarnings("unchecked")
	public void save(Employee emp) {
		//jdbcTemplate.update("insert into employee (name,age) values (?,?)",emp.getName(),emp.getAge());
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
		namedParameterJdbcTemplate.update("insert into employee (name,age) values (:ename,:eage)", new HashMap() {{
			this.put("ename",emp.getName());
			this.put("eage",emp.getAge());
		}});
	}

	public void update(Employee emp) {
		jdbcTemplate.update("update employee set name=?,age=? where id=?",emp.getName(),emp.getAge(),emp.getId());
	}

	public void delete(Long id) {
		jdbcTemplate.update("delete from employee where id=?",id);
	}

	public Employee get(Long id) {
		List<Employee> list = jdbcTemplate.query("select * from employee where id=?", new Object[] {id},
				(rs,rowNum)->{
					Employee emp = new Employee();
					emp.setId(rs.getLong("id"));
					emp.setName(rs.getString("name"));
					emp.setAge(rs.getInt("age"));
					return emp;
				});
		return list.size() == 1 ? list.get(0) : null;
 	}

	public List<Employee> listAll() {
		return jdbcTemplate.query("select * from employee", new Object[] {},new RowMapper<Employee>() {
			//把每一行结果及映射成一个Employee对象
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				return emp;
			}});
	}

}
