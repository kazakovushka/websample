<%@page import="ru.rtec.lighting.data.model.exceptions.DaoExceptions"%>
<%@page import="ru.rtec.lighting.data.model.ServerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ru.rtec.lighting.data.model.Device"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!List<Device> devices=new ArrayList<Device>(); 
		String descr; 
		boolean alive;
		%>
	<% try{ 
		devices=ServerDAO.getInstance().getDevice();
			}
			catch(DaoExceptions exc){
				exc.printStackTrace();
				
			}
	%>
	<table border="1">
		<tr>
			<th>Название прибора</th>
			<th>На связи</th>
		</tr>
		<% for(Device dev : devices) {		 
		%>
		<tr>
			<td><a href="device.jsp?sn=<%=dev.getSerialNumber()%>"><%=dev.getDescription()%></a></td>
			<td><%= dev.isOnline() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>