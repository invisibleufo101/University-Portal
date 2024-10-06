package com.university.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(urlPatterns = "*.do", initParams = @WebInitParam(name = "characterEncoding", value="UTF-8"))
public class CharacterEncodingFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	private String encoding;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("characterEncoding");
	}

}
