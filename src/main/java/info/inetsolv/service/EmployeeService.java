package info.inetsolv.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import info.inetsolv.DAO.EmployeeDao;
import info.inetsolv.entity.Employee;

@Service
@Transactional
@EnableTransactionManagement
public class EmployeeService {

	@Autowired
	private EmployeeDao empdao;
	public void save(Employee employee){
		empdao.save(employee);
		//return null;
	}
}
