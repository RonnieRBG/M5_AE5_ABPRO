<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form action="RegistroClienteController" method="post">
		<div class="mb-3">
        	<label for="nombre" class="form-label">Nombre:</label>
        	<input type="text" class="form-control" name="nombre" id="nombre" required>
        </div>
        <div class="mb-3">
        	<label for="correo" class="form-label">Descripcion:</label>
        	<input type="text" class="form-control" name="descripcion" id="descripcion" required >
        </div>
        <div class="mb-3">
        	<label for="pass" class="form-label">Telefono:</label>
        	<input type="text" class="form-control" name="telefono" id="telefono" required>
        </div>
        <div class="mb-3">
        <button type="submit" class="btn btn-primary">Registrar</button>
        </div>
    </form>
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>