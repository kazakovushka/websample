
<%@page import="ru.rtec.lighting.data.model.DoubleParameter"%>
<%@page import="java.util.Date"%>
<%@page import="ru.rtec.lighting.data.model.BooleanParameter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ru.rtec.lighting.data.model.Device"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="ru.rtec.lighting.data.model.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="ru.rtec.lighting.data.model.ServerDAO"%>
<%@page import="ru.rtec.lighting.data.model.ExtendsBlock"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!Logger l=Logger.getLogger("block");%>
	<%--ExtendsBlock block = ServerDAO.getInstance().getExtendsBlockById(
				Long.valueOf(request.getParameter("bn"))); --%>
	<%
		ExtendsBlock block=new ExtendsBlock(44, new Device());
	%>
		<h4><%=request.getParameter("sn")%></h4>
	<h2>
		Параметры блока расширения №<%=request.getParameter("bn")%></h2>
		<%--ServerDAO.getInstance()
				.getExtBlockParameters(block); --%>
	<%
		List<Parameter> params = new ArrayList<Parameter>();
		Parameter pw = new BooleanParameter("some boolean parameter", false);
		pw.setTimestamp(new Date());
		pw.setTu(false);
		pw.setQuality(300);
		
		Parameter dp = new DoubleParameter("Double parameter", 2d);
		dp.setTimestamp(new Date());
		dp.setTu(false);
		dp.setQuality(400);
		params.add(pw);
		params.add(dp);
		block.setParameters(params);
	
	%>
	
	<table>

		<tr>
			<th>Имя</th>
			<th>Значение</th>
			<th>Метка времени</th>
			<th>Качество</th>
			<th>ТУ</th>
		</tr>
		<%
			for (Parameter parameter :  block.getParameters()) {
				l.info("param=" + parameter);
		%>
		<tr>
			<td><%=parameter.getPrefix()%></td>
			<td><%=parameter.getValue()%></td>
			<td><%=parameter.getTimestamp()%></td>
			<td><%=parameter.getQuality()%></td>
			<td><%=parameter.isTu()%> <%
 	}
 %></td>
		</tr>
	</table>


</body>
</html>