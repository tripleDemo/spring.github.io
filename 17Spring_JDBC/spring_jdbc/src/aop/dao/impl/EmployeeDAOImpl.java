package aop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import aop.dao.IEmployeeDAO;
import aop.domain.Employee;

@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO {

	public void save(Employee emp) {
		super.getJdbcTemplate().update("insert into employee (name,age) values (?,?)",emp.getName(),emp.getAge());
	}

	public void update(Employee emp) {
		super.getJdbcTemplate().update("update employee set name=?,age=? where id=?",emp.getName(),emp.getAge(),emp.getId());
	}

	public void delete(Long id) {
		super.getJdbcTemplate().update("delete from employee where id=?",id);
	}

	public Employee get(Long id) {
		List<Employee> list = super.getJdbcTemplate().query("select * from employee where id=?", new Object[] {id},
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
		return super.getJdbcTemplate().query("select * from employee", new Object[] {},new RowMapper<Employee>() {
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
