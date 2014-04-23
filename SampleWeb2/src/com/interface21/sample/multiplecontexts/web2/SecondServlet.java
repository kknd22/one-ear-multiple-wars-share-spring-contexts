package com.interface21.sample.multiplecontexts.web2;

import java.io.IOException;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.interface21.sample.multiplecontexts.service.SampleService;
import com.interface21.sample.multiplecontexts.service.SampleServiceImpl;

/**
 * Servlet implementation class for Servlet: SecondServlet
 *
 */
 public class SecondServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// For this sample, we simply perform depency lookup from the current WebApplicationContext. 
		// This will query the shared parent context and find the sampleService bean.
		// In a real web app, Spring provide a better way to do dependency injection
		// of your web controllers/actions/whatever your web framework calls them.
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

		Object s = com.interface21.sample.multiplecontexts.service.SampleService.class.getClassLoader();
		System.out.println("222-----------> com.interface21.sample.multiplecontexts.service.SampleService.class.getClassLoader(): " + s);
		Object o =	ctx.getBean("sampleService");
		System.out.println("222-----------> o.getClass.getClassLoader():" + o.getClass().getClassLoader());
		//SampleService service = (SampleService) o;
		SampleServiceImpl service = (SampleServiceImpl) o;
		
		response.getWriter().println(service.sayHello("SampleWeb2") + " using service instance " + service);
	}
	
}