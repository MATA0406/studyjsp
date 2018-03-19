<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Enumeration <String>attr = session.getAttributeNames();
	while(attr.hasMoreElements()){
		String attrName = attr.nextElement();
		String attrvalue = (String)session.getAttribute(attrName);
		out.println("세션의 속성명은" + attrName + " 이고");
		out.println("세션의 속성값은" + attrvalue + " 이다<br>");
	}
%>