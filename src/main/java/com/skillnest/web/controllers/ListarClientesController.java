package com.skillnest.web.controllers;
import java.io.IOException;
import java.util.List;

import com.skillnest.web.models.Cliente;
import com.skillnest.web.models.ClienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard") 
public class ListarClientesController extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenemos la lista 
        List<Cliente> lista = clienteDAO.obtenerTodos();
        // Cargamos los datos
        request.setAttribute("clientes", lista);
        //  Enviamos al JSP
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}