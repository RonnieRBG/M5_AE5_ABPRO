package com.skillnest.web.controllers;

import java.io.IOException;
import com.skillnest.web.models.ClienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarClienteController")
public class EliminarClienteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    // Instanciamos el DAO 
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Obtener ID desde el formulario 
        String idTexto = request.getParameter("id");
        
        // Convertimos a INT
        try {
            int id = Integer.parseInt(idTexto);

            // Ejecutar en el DAO
            clienteDAO.eliminar(id);
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Error: El ID no es un número válido");
        }

        // Enviamos al dashboard
        
        response.sendRedirect("dashboard");
    }
}