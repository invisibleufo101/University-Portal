package com.university.controller;

public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	public ViewResolver() {}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getViewPath(String viewName) {
		return prefix + viewName + suffix;
	}
}
