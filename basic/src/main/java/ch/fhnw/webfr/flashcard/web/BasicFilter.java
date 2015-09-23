package ch.fhnw.webfr.flashcard.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class BasicFilter implements javax.servlet.Filter{
	
	private static Logger logger = Logger.getLogger(BasicFilter.class);
	
	public BasicFilter(){
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("Test");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info(((HttpServletRequest) request).getRequestURL());
		//ruft alle Filter auf
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
