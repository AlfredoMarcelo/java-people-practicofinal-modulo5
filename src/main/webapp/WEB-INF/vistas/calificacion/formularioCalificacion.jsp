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
			<div class="row mt-4">
				<div class="col mt-5">
					<p class="h3 text-center">Agregar nota de evaluación</p>
					<form class="row g-3" action="/java-people/calificacion" method="POST" >
					<input type="hidden" name="id">
					<input type="hidden" name="estudianteId" value="${estudiante.id}">
				  <div class="col-md-6">
				    <label for="nombre" class="form-label">Nombre: </label>
				    <input type="text" class="form-control" id="nombre" name="nombre" value="${estudiante.nombre}">
				  </div>
				  <div class="col-md-6">
				    <label for="apellido" class="form-label">Apellido: </label>
				    <input type="text" class="form-control" id="apellido" name="apellido" value="${estudiante.apellido}">
				  </div>
				  <div class="col-md-4">
				    <label for="nota" class="form-label">Nota: </label>
				    <input type="text" class="form-control" id="nota" name="nota" >
				  </div>
				  
				  <div class="col-md-4">
				    <label for="evaluacion" class="form-label">N° Evaluacion: </label>
				    <input type="number" class="form-control" id="evaluacion" name="evaluacion">
				  </div>
				  
				  <div class="col-md-4">
				    <label for="asignatura" class="form-label">Asignatura: </label>
				    <select id="asignatura" class="form-select" name="asignaturaId">
				      
				      <c:forEach var="asignatura" items="${asignaturas}">
		  				<c:choose>
		  					<c:when test="${asignatura.id == calificacion.asignatura.id}">
		  						<option selected="selected" value="${asignatura.id}">${asignatura.nombre}</option>
		  					</c:when>
		  					<c:otherwise>
		  						<option value="${asignatura.id}">${asignatura.nombre}</option>
		  					</c:otherwise>
		  				</c:choose>		  				
		  			</c:forEach>
				      
				    </select>
				  </div>
				  
				  <div class="col-12">
				    <button type="submit" class="btn btn-success">Agregar Nota</button>
				  </div>
				</form>
				</div>
			</div>
		</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>