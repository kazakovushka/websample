
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!Logger l=Logger.getLogger("block");%>
	<%
		ExtendsBlock block = ServerDAO.getInstance().getExtendsBlockById(
				Long.valueOf(request.getParameter("bn")));
	%>
	<h2>
		Параметры блока расширения №<%=block.getNumberBlock()%></h2>
	<%
		List<Parameter> params = ServerDAO.getInstance()
				.getExtBlockParameters(block);
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
			for (Parameter parameter : params) {
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