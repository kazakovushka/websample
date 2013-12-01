<%@page import="ru.rtec.lighting.data.model.ServerDAO"%>
<%@page import="ru.rtec.lighting.data.model.Device"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!Device device; %>
<h1><%=request.getParameter("sn")%></h1>
</body>
</html>