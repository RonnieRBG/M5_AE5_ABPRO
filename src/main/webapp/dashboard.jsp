<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.skillnest.web.models.Cliente" %>
	
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .table-container { background-color: white; border-radius: 10px; padding: 20px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
    </style>
</head>
<body>

<div class="container mt-5">
    
    <div class="row mb-4 align-items-center">
        <div class="col">
            <h2 class="text-primary"> Gestión de Clientes</h2>
            <p class="text-muted">Lista actual de clientes</p>
        </div>
        <div class="col-auto">
            <form action="RegistroClienteController" method="get">
                <button type="submit" class="btn btn-success btn-lg shadow">
                    ➕ Nuevo Cliente
                </button>
            </form>
        </div>
    </div>

    <div class="table-container">
        <%
            List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");
        %>

        <table class="table table-hover align-middle">
          <thead class="table-dark">
              <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Telefono</th>
                <th scope="col" class="text-center">Acciones</th>
              </tr>
          </thead>
          <tbody>
            <%
                if (lista != null && !lista.isEmpty()) {
                    for (Cliente u : lista) { 
            %>
              <tr>
                
                <td class="fw-bold"><%= u.getNombre() %></td>
                <td class="fw-bold"><%= u.getDescripcion() %></td>
                <td class="text-success"><%= u.getTelefono() %></td>
                <td>
                    <form action="EditarClienteController" method="get" onsubmit="return confirm('Se reemplazaran los datos y los anteriores no podran ser recuperados');">
                        <input type="hidden" name="id" value="<%= u.getId() %>">
                        <button type="submit" class="btn btn-outline-danger btn-sm">
                            Modificar
                        </button>
                    </form>
                </td>
                <td class="text-center">
                    <form action="EliminarClienteController" method="post" onsubmit="return confirm('¿Estás seguro de querer eliminar este cliente?');">
                        <input type="hidden" name="id" value="<%= u.getId() %>">
                        <button type="submit" class="btn btn-outline-danger btn-sm">
                            🗑️ Eliminar
                        </button>
                    </form>
                </td>
              </tr>
            <%
                    }
                } else {
            %>
              <tr>
                <td colspan="5" class="text-center py-4">
                    <div class="alert alert-warning m-0">
                        ⚠️ No hay frutas registradas en el sistema. ¡Agrega una!
                    </div>
                </td>
              </tr>
            <%
                }
            %>
          </tbody>
        </table>
    </div>

    <div class="text-center mt-4">
        <a href="MenuServlet" class="text-decoration-none text-secondary">
            &larr; Volver al Menú Principal
        </a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>