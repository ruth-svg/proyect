<%@page import="entidades.Titulos"%>
<%@page import="dao.TitulosDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preincripción alumno</title>
</head>
<body>
	<form action="ServletController" method="post">
		<table align="center">

			<tr>
				<td colspan=2><h2>SISTEMA PREINSCRIPCION GF</h2></td>
			</tr>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="dni" required="required" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" required="required" /></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="apellidos" required="required" /></td>
			</tr>
			<tr>
				<td>Título:</td>
				<td><select name="titulo" required="required">
						<option>(ELIGE TITULO)</option>
						<%
						for (Titulos tit : TitulosDAO.getAll()) {
						%>
						<option value="<%=tit.getCodtitulo()%>"><%=tit.getCiclo()%>
							<%=tit.getDescripcion()%>
							<%
							}
							%>
						
				</select></td>

			</tr>
			<tr>
				<td>Fecha inscripcion:</td>
				<td><input type="text" name="fecha" value="dd/mm/aaaa"
					required="required" /></td>
			</tr>
			<%
			if (request.getAttribute("mensaje") != null) {
			%>
			<tr>
				<td><p style="color:red"><%=request.getAttribute("mensaje")%></p></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Grabar"
					name="grabar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>