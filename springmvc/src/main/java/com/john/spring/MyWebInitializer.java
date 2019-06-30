package com.john.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 使用编程方式初始化WebApplicationContext、动态注册DispatcherServlet
 * 类路径下
 */
@Slf4j
public class MyWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /*XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocations("classpath:/applicationContext.xml", "WEB-INF/DispatcherServlet.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("Dispatcher", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");*/
    }
}
