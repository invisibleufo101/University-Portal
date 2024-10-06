package com.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * REST Controller 같이 각 Http 요청마다 (GET, POST, PUT/PATCH, DELETE)마다 Controller 객체가 알맞는 메소드를 
 * 쓸 수 있게끔 만든 추상 Controller 클래스입니다.
 * 
 * 그러나 현재 프로젝트는 사실상 GET과 POST밖에 핸들링를 하지 못하기 때문에 진정한 REST라고 보기 어렵습니다.
 * 이유는 HTML5가 지원하는 요청 타입들은 GET과 POST밖에 없기 때문입니다.
 */
public abstract class Controller {
	
	/**
	 * GET 요청의 모든 결과를 보여줄 때 쓰는 메소드입니다.
	 * @param request
	 * @param response
	 * @return
	 */
	public String browse(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	/**
	 * GET 요청의 특정한 하나의 결과를 보여줄 때 쓰는 메소드입니다.
	 * @param request
	 * @param response
	 * @return
	 */
	public String read(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	/**
	 * POST 요청의 기존에 존재하는 데이터를 수정하기 위한 메소드입니다.
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	/**
	 * POST 요청의 새로운 데이터를 추가하기 위한 메소드입니다.
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	
	/**
	 * POST 
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}



