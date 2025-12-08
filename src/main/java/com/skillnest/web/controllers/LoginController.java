package com.skillnest.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.skillnest.web.models.Usuario;
import com.skillnest.web.models.UsuarioDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();   
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //obtenemos el ususario y la contra desde le jsp y se guarda en el request
		String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        //Errores por si el usuario esta mal o vacio devuelve al login
		if (user == null || user.isEmpty()) {
		    request.setAttribute("error", "El nombre de usuario es obligatorio");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    return;
		}

		
		//Instanciamos el usario y lo comparamos con el metodo con el usuario guarsado en la base de datos
        Usuario usuario = usuarioDAO.validarUsuario(user,password);
        
        // error por si hay alguna diferencia
        if(usuario== null) {
		    request.setAttribute("error", "Error de inicio de session");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    return;
        }
        //guardamos en sesion y  enviamos al dashboard
		HttpSession session = request.getSession();
		session.setAttribute("user", usuario.getUser());
		session.setAttribute("password", usuario.getPassword
				());
		response.sendRedirect("dashboard");
		//Aqui habia probado varias cosas pero se usa send direct ya que queremos que una vez validado el login pase a la siguiente pagina
        //request.setAttribute("user", usuario.getUser());
        //request.getRequestDispatcher("/dashboard").forward(request, response);
        
	}

}