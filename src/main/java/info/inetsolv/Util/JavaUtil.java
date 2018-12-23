package info.inetsolv.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("{info.inetsolv.controller}")
public class JavaUtil {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/jsps/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}
}
