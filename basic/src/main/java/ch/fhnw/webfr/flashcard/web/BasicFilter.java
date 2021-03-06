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
	
	public static final String DEFAULT_BEFORE_MESSAGE_PREFIX = "Before request [";
	public static final String DEFAULT_BEFORE_MESSAGE_SUFFIX = "]";
	
	//Logger hier wegen InterceptorPattern
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
		//Bei jedem Request wird Filter aufgerufen
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		//Hier ist der Filter ein Logger
		StringBuffer buffer = new StringBuffer();
		buffer.append(DEFAULT_BEFORE_MESSAGE_PREFIX);
		buffer.append("uri=").append(httpRequest.getRequestURI());
		buffer.append(DEFAULT_BEFORE_MESSAGE_SUFFIX);
		logger.debug(buffer.toString());
		
		//ruft alle Filter auf
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//Hier könnet man z.B. auch den Logger wieder löschen
		
	}

}
