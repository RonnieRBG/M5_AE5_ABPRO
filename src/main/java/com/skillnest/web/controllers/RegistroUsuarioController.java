package com.skillnest.web.controllers;

import java.io.IOException;

import com.skillnest.web.models.Usuario;
import com.skillnest.web.models.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroUsuarioController")
public class RegistroUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // Crear un objeto de usuario y establecer valores
        Usuario usuario = new Usuario();
        usuario.setUser(user);
        usuario.setPassword(password);

        // Guardar el usuario en la base de datos
           
        
        usuarioDAO.guardar(usuario);

        // Redirigir a el login
        response.sendRedirect("login.jsp");
        
    }
}