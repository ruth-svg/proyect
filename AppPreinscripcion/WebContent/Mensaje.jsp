<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mensaje</title>
</head>
<body>
	<form action="ServletController" method="post">
		<div style="text-align: center;">
			<table border="1" style="margin: 0 auto;">
				<tr>
					<td><%=request.getAttribute("mensaje")%></td>
				</tr>
				<tr>
					<td><input type="submit" value="Volver" name="volver"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>