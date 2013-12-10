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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Device device = new Device(1l, true, "test dev");
	%>
	<%--ServerDAO.getInstance().getDeviceById(
				Long.valueOf(request.getParameter("sn"))); --%>
	<%--List<Parameter> params = ServerDAO.getInstance().getDeviceParameters(device); --%>
	<%!Logger l = Logger.getLogger("device.jsp");%>

	<h4><%=request.getParameter("sn")%></h4>
	<%
		List<Parameter> params = new ArrayList<Parameter>();
		Parameter pw = new BooleanParameter("p1", false);
		pw.setTimestamp(new Date());
		pw.setTu(false);
		pw.setQuality(100);
		l.info("log1");
		Parameter dp = new DoubleParameter("dp", 2d);
		dp.setTimestamp(new Date());
		dp.setTu(true);
		dp.setQuality(200);
		params.add(pw);
		params.add(dp);
		device.setDeviceParameters(params);
		l.info("log3" + params);
	%>

	<h2>Блоки расширения</h2>
	<div >
	<table>

		<tr>
			<th>Номер</th>
			<th>Описание</th>
		</tr>
		
		<%-- ServerDAO.getInstance()
						.getExtBlockForDevice(device);--%>
			<%
				List<ExtendsBlock> blocks = new ArrayList<ExtendsBlock>();
				ExtendsBlock b1=new ExtendsBlock(1,new Device());
				ExtendsBlock b2=new ExtendsBlock(2,new Device());
				ExtendsBlock b3=new ExtendsBlock(3,new Device());
				ExtendsBlock b4=new ExtendsBlock(4,new Device());
				ExtendsBlock b5=new ExtendsBlock(5,new Device());
				blocks.add(b1);
				blocks.add(b2);
				blocks.add(b3);
				blocks.add(b4);
				blocks.add(b5);
				device.setExtendsBloks(blocks);
				
			%>
			<%
				for (ExtendsBlock block : device.getExtendsBloks()) {
			%>
			<tr>
			<td><a href="block.jsp?bn=<%=block.getNumberBlock()%>"> <%=block.getNumberBlock()%></a></td>
			<td><%=block.getNumberBlock()%></td>
			<%
				}
			%>
		</tr>
	</table>
	</div>


	<h2>Параметры устройства</h2>
	<div >
	<table>

		<tr>
			<th>Имя</th>
			<th>Значение</th>
			<th>Метка времени</th>
			<th>Качество</th>
			<th>ТУ</th>
		</tr>
		<%
			for (Parameter parameter : device.getDeviceParameters()) {
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
	</div>
</body>
</html>