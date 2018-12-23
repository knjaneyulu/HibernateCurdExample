package info.inetsolv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;

	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String getForm(Employee employee){
		return "display";
	}
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String processForm(Employee employee){
		empservice.save(employee);
		return "success";
	}
}
