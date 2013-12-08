<%@page import="ru.rtec.lighting.data.model.ExtendsBlock"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>

<%@page import="java.util.Date"%>
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
	<%
		Device device = ServerDAO.getInstance().getDeviceById(
				Long.valueOf(request.getParameter("sn")));//new Device(1l, true, "test dev");
	%>
	<%!Logger l = Logger.getLogger("device.jsp");%>
	<%
		List<Parameter> ww = new ArrayList<Parameter>();
		Parameter pw = new BooleanParameter("p1", false);
		pw.setTimestamp(new Date());
		pw.setTu(false);
		pw.setQuality(100);
		l.info("log1");
		Parameter dp = new DoubleParameter("dp", 2d);
		dp.setTimestamp(new Date());
		dp.setTu(true);
		dp.setQuality(200);
		ww.add(pw);
		ww.add(dp);
		device.setDeviceParameters(ww);
		l.info("log2" + device.getDeviceParameters());
	%>
	<h1><%=request.getParameter("sn")%></h1>
	<%
		List<Parameter> params = device.getDeviceParameters();
		l.info("log3" + params);
	%>

	<h2>Блоки расширения</h2>
	<table>

		<tr>
			<th>Номер</th>
			<th>Описание</th>
		</tr>
		<tr>
			<%
				List<ExtendsBlock> blocks = ServerDAO.getInstance()
						.getExtBlockForDevice(device);
			%>
			<%
				for (ExtendsBlock block : blocks) {
			%>
			<td><a href="block.jsp?bn=<%=block.getBlockId()%>">
			<%=block.getNumberBlock()%></a></td>
			<td><%=block.getNumberBlock()%></td>
			<%
				}
			%>
		</tr>
	</table>


	<h2>Параметры устройства</h2>
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