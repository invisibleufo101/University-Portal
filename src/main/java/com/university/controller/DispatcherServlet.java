package com.university.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RouteHandler routeHandler;
	private ViewResolver viewResolver;
	
	/**
	 * 모든 view 파일에 대한 경로를 세팅해줍니다.
	 * 사용자 계정 역할 (user_role)에 따라 view 경로가 달라져서 일단 제일 기본적인 WEB-INF로만 지정했습니다.
	 */
	@Override
	public void init() throws ServletException {
		routeHandler = new RouteHandler();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./WEB-INF/");
		viewResolver.setSuffix(".jsp");
	}

	/**
	 * 클라이언트로부터 오는 GET과 POST 요청을 처리합니다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		String viewName = routeHandler.handleRequest(path, request, response);
		
		System.out.println("URI: " + uri);
		System.out.println("path: " + path);
		System.out.println("ViewName: " + viewName);
		
		String view = null;
		if (viewName.contains(".do")) {
			view = viewName;
		} else if (viewName.equals("login") || viewName.equals("error")) {
			view = viewName + ".jsp";
		} else {
			view = viewResolver.getViewPath(viewName);
		}

		System.out.println("View: " + view);
		System.out.println("----------------------------------------------");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}

//String view = null;
//if (!viewName.contains(".do")) { 
//	if (viewName.equals("login")) {
//		view = viewName + ".jsp";
//	} else {
//		view = viewResolver.getViewPath(viewName);
//	}
//} else {
//	view = viewName;
//}


//if (viewName.equals("login")) {
//	view = viewName + ".jsp";
//} else if (!viewName.contains(".do")) {
//	view = viewResolver.getViewPath(viewName);
//} else {
//	view = viewName;
//}
