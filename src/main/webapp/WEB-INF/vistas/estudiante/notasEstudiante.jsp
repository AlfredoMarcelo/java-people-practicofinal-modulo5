<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/vistas/componentes/navbar.jsp" %>
		<div class="container">
			<div class="row mt-3">
				<div class="col mt-5">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Nombre</th>
					      <th scope="col">Apellido</th>
					      <th scope="col">Asignatura</th>
					      <th scope="col">Nota</th>
					      <th scope="col">N° Evaluacion</th>
					      <th scope="col">Modificar</th>
					    </tr>
					  </thead>
					  <tbody>
						    <tr>
						      <td><c:out value="${calificacion.id}"/></td>
						      <td><c:out value="${calificacion.estudiante.nombre}"/></td>
						      <td><c:out value="${calificacion.estudiante.apellido}"/></td>
						      <td><c:out value="${calificacion.asignatura.nombre}"/></td>
						      <td><c:out value="${calificacion.nota}"/></td>
						      <td><c:out value="${calificacion.evaluacion}"/></td>
						      <td><a class="btn btn-warning" href="${pageContext.request.contextPath}/estudiante?seleccion=ver&amp;id=${calificacion.estudiante.id}">Consultar</a></td>
						    </tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>