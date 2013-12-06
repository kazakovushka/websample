<%@page import="ru.rtec.lighting.data.model.DoubleParameter"%>
<%@page import="ru.rtec.lighting.data.model.BooleanParameter"%>

<%@page import="java.util.ArrayList"%>
<%@page import="ru.rtec.lighting.data.model.Parameter"%>
<%@page import="java.util.List"%>
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
	<%!Device device = new Device(1l, true, "test dev");%>
	<%
		List<Parameter> ww = new ArrayList<Parameter>();
		Parameter pw = new BooleanParameter("p1", false);
		Parameter dp = new DoubleParameter("dp", 2d);
		ww.add(pw);
		ww.add(dp);
		device.setDeviceParameters(ww);
	%>
	<h1><%=request.getParameter("sn")%></h1>
	<%!List<Parameter> params = device.getDeviceParameters();%>

	<table>

		<tr>
			<th>Имя</th>
			<th>Значение</th>
			<th>Метка времени</th>
			<th>ТУ</th>
		</tr>
		<%
			for (Parameter parameter : params) {
		%>
		<tr>
			<td>
				<%
					parameter.getPrefix();
				%>
			</td>
			<td>
				<%
					parameter.getValue();
				%>
			</td>
			<td>
				<%
					parameter.getTimestamp();
				%>
			</td>
			<td>
				<%
					parameter.isTu();
					}
				%>
			</td>
		</tr>
	</table>
</body>
</html>