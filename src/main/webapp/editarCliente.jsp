<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.skillnest.web.models.Cliente" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .card { border: none; border-radius: 15px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            
            <%
                // Recuperamos el objeto Cliente que nos envió el Controlador (doGet)
                Cliente c = (Cliente) request.getAttribute("cliente");
                
               //Devolvemos al dashboard si el cliente es nulo
                if (c == null) {
                    response.sendRedirect("dashboard");
                    return;
                }
            %>

            <div class="card p-4">
                <h2 class="text-center text-primary mb-4">✏️ Editar Cliente</h2>

                <form action="EditarClienteController" method="post">
                    
                    <input type="hidden" name="id" value="<%= c.getId() %>">

                    <div class="mb-3">
                        <label class="form-label fw-bold">Nombre:</label>
                        <input type="text" name="nombre" class="form-control" 
                               value="<%= c.getNombre() %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Descripción:</label>
                        <input type="text" name="descripcion" class="form-control" 
                               value="<%= c.getDescripcion() %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Teléfono:</label>
                        <input type="number" name="telefono" class="form-control" 
                               value="<%= c.getTelefono() %>" required>
                    </div>

                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                        <a href="dashboard" class="btn btn-secondary me-md-2">Cancelar</a>
                        <button type="submit" class="btn btn-primary">💾 Guardar Cambios</button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>