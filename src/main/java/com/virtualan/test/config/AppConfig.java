package com.virtualan.test.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.virtualan.test.service.UserService;

/**
 * Spring boot and Apache CXF with virtualan
 * 
 * @author Elan Thangamani
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = UserService.class)
public class AppConfig {
	@Autowired private UserService userService;
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean(destroyMethod = "destroy") @DependsOn("cxf")
	public Server jaxRsServer() {
		final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

		factory.setServiceBean(userService);
		factory.setProvider(new JacksonJsonProvider());
		factory.setBus(cxf());
		factory.setAddress("/");

		return factory.create();
	}

	@Bean
	public ServletRegistrationBean cxfServlet() {
		final ServletRegistrationBean servletRegistrationBean = 
			new ServletRegistrationBean(new CXFServlet(), "/api/*");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
}
