package com.coforge.springWebApp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfigurerAdapter.class);
		context.setServletContext(arg0);
		
		ServletRegistration.Dynamic sd=arg0.addServlet("dispatcher", new DispatcherServlet(context));
		sd.setLoadOnStartup(1);
		sd.addMapping("/");
		
		
		
		
	}

}
