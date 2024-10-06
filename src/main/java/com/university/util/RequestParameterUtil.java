package com.university.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestParameterUtil {

	/**
	 * 사용자 요청의 인자 값들을 Map<String, String>으로 매핑하여 사용자 요청을 쉽게 처리할 수 있도록 도와주는 메소드입니다.
	 * 
	 * @param request 사용자 요청의 인자 값들 (Map<String, String[]>)
	 * @return		  사용자의 요청을 Map<String,String>으로 변환한 맵 
	 */
	public static Map<String, String> mapRequestParameters(HttpServletRequest request){
		Map<String, String[]> requestParams = request.getParameterMap();
		Map<String, String> paramMap = new LinkedHashMap<>();
		for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			
			String value = String.join(", ", paramValues);
			paramMap.put(paramName, value);
		}
		
		return paramMap;
	}
}
