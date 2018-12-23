package info.inetsolv.Util;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import info.inetsolv.DAO.EmployeeDao;
import info.inetsolv.service.EmployeeService;

public class WebApplication implements WebApplicationInitializer{

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext parentContainer=new AnnotationConfigWebApplicationContext();
		parentContainer.register(EmployeeDao.class,EmployeeService.class);
		context.addListener(new ContextLoaderListener(parentContainer));
		AnnotationConfigWebApplicationContext childContainer=new AnnotationConfigWebApplicationContext();
		childContainer.register(JavaUtil.class);
		ServletRegistration.Dynamic dynamic=context.addServlet("ds", new DispatcherServlet(childContainer));
		dynamic.setLoadOnStartup(3);
		dynamic.addMapping("/");
		
		
	}

	
}
