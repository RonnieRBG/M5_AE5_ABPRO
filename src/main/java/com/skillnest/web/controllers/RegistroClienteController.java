package com.skillnest.web.controllers;

import java.io.IOException;

import com.skillnest.web.models.Cliente;
import com.skillnest.web.models.ClienteDAO;
import com.skillnest.web.models.Usuario;
import com.skillnest.web.models.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroClienteController")
public class RegistroClienteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //  redirige la visualización al archivo JSP del formulario
	  
	    request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Obtenemos los valores y guardamos en el rquest
		String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String telefono = request.getParameter("telefono");

        // Crear un objeto de usuario y establecer valores
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setDescripcion(descripcion);
        cliente.setTelefono(Integer.parseInt(telefono));

        // Guardar el usuario en la base de datos mediante el metodo del dao.
   
        
        clienteDAO.guardar(cliente);

        // Redirigir a una página de confirmación
        response.sendRedirect("dashboard");
        
    }
}