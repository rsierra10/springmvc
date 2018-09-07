package org.javasavvy.demo.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.javasavvy.demo.app.config.DatabaseConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomerWebAppIntializer  implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		
		
		/*XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/config/dispatcherServlet-config.xml");*/
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(DatabaseConfig.class);
		webContext.register(CustomerWebMVCConfig.class);
		webContext.setServletContext(container);
		
        ServletRegistration.Dynamic registration = container.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("*.action");
        
        
        
	}


	


}
