package com.sgm.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {
	// @Override
	// public void onStartup(ServletContext servletContext) throws
	// ServletException {
	// AnnotationConfigWebApplicationContext ctx = new
	// AnnotationConfigWebApplicationContext();
	// ctx.register(WebAppContextConfig.class);
	// servletContext.addListener(new ContextLoaderListener(ctx));
	// ctx.setServletContext(servletContext);
	// Dynamic servlet = servletContext.addServlet("dispatcher", new
	// DispatcherServlet(ctx));
	// servlet.addMapping("/");
	// servlet.setLoadOnStartup(1);
	// }
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
