package info.inetsolv.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import info.inetsolv.entity.Employee;

@Repository
@ComponentScan("info.inetsolv.DBUtil")
public class EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void save(Employee employee){
		System.out.println("dao.........");
		hibernateTemplate.save(employee);
	}
	
}
