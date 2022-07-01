<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Index</title>
</head>
<body>
	<%@ include file="/WEB-INF/vistas/componentes/navbar.jsp" %>
	<h1>Java people inicio</h1>
	<div class="container">
		<div class="row mt-5">
			<div class="col">
				<form class="row g-3" action="/java-people/estudiante" method="POST">
					<input type="hidden" name="id">
				  <div class="col-md-4">
				    <label for="nombre" class="form-label">Nombre: </label>
				    <input type="text" class="form-control" id="nombre" name="nombre">
				  </div>
				  <div class="col-md-4">
				    <label for="apellido" class="form-label">Apellido: </label>
				    <input type="text" class="form-control" id="apellido" name="apellido">
				  </div>
				  <div class="col-md-4">
				    <label for="run" class="form-label">Run: </label>
				    <input type="text" class="form-control" id="run" name="run">
				  </div>
				  <div class="col-md-4">
				    <label for="genero" class="form-label">Genero: </label>
				    <select id="genero" class="form-select" name="genero">
				      <option selected>Selecciona..</option>
				      <option value="Masculino">Masculino</option>
				      <option value="Femenino">Femenino</option>
				    </select>
				  </div>
				  <div class="col-md-4">
				    <label for="fono" class="form-label">Fono: </label>
				    <input type="text" class="form-control" id="fono" name="fono">
				  </div>
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Agregar</button>
				  </div>
				</form>
				<form class="row g-3" action="/java-people/asignatura" method="POST">
					<input type="hidden" name="id">
				  <div class="col-md-4">
				    <label for="nombre" class="form-label">Nombre: </label>
				    <input type="text" class="form-control" id="nombre" name="nombre">
				  </div>
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Agregar</button>
				  </div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>