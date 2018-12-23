package info.inetsolv.DBUtil;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import info.inetsolv.entity.Employee;

@Configuration
@PropertySource("classpath:db.properties")
public class DBUtil {

	@Autowired
	private Environment env;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Bean
	public DataSource dataSource(){
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("db.driverClass"));
		ds.setDriverClassName(env.getProperty("db.url"));
		ds.setDriverClassName(env.getProperty("db.userName"));
		ds.setDriverClassName(env.getProperty("db.passWord"));
		return ds;
	}
	@Bean
	public HibernateTemplate hibernateTemplate(){
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sessionFactory);
		return ht;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBean lsb=new LocalSessionFactoryBean();
		lsb.setDataSource(dataSource);
		lsb.setAnnotatedClasses(Employee.class);
		lsb.setHibernateProperties(properties);
		
		return lsb;
		
	}
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager ts=new HibernateTransactionManager();
		ts.setSessionFactory(sessionFactory);
		return ts;
	}
	
	
	
}
