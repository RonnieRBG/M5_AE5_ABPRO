package com.skillnest.web.controllers;

import java.io.IOException;
import com.skillnest.web.models.Cliente;
import com.skillnest.web.models.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditarClienteController")
public class EditarClienteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    // Instancia del DAO
	private ClienteDAO clienteDAO = new ClienteDAO();

   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //  Recibimos el ID del cliente
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
        // Buscamos al cliente en la base de datos con el ID recibido
		Cliente clienteEncontrado = clienteDAO.obtenerPorId(id);
		
        // Lo guardamos en el request para enviarlo al JSP
		request.setAttribute("cliente", clienteEncontrado);
		
        // Enviamos al formulario de para editarlo
		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
	}

    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- DEBUG INICIO ---");
		
		// Recibir todo como String primero
		String idStr = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String telefonoStr = request.getParameter("telefono"); 

		// Imprimir en consola para comprobar la recepcion de los datos
		System.out.println("ID: " + idStr);
		System.out.println("Nombre: " + nombre);
		System.out.println("Teléfono: " + telefonoStr);

	
		if (telefonoStr == null || nombre == null) {
			System.out.println("❌ ERROR FATAL: El formulario JSP no envió los datos.");
			System.out.println("👉 Causa probable: Error de sintaxis HTML en el input del ID.");
			
			// Si hay algun error nos muestra en consola pero redirigimos al dashboard
			response.sendRedirect("dashboard");
			return; 
		}

		// Ya comprobado la recepcion de los datos, convertimos los numeros string a numeros int
		try {
			int id = Integer.parseInt(idStr);
			int telefono = Integer.parseInt(telefonoStr);

			// y Guardamos en un objeto nuevo
			Cliente clienteEditado = new Cliente();
			clienteEditado.setId(id);
			clienteEditado.setNombre(nombre);
			clienteEditado.setDescripcion(descripcion);
			clienteEditado.setTelefono(telefono);
			
			// usamos el metodo del DAO
			clienteDAO.actualizar(clienteEditado);
			
			//Se imprime en consola para corroborar la actualizacon de los datos y se dirige al dashboard
			System.out.println("✅ Cliente actualizado con éxito.");
			response.sendRedirect("dashboard");

		} catch (NumberFormatException e) {
			System.out.println("❌ Error al convertir los números: " + e.getMessage());
			e.printStackTrace();
			response.sendRedirect("dashboard");
		}
	}
}