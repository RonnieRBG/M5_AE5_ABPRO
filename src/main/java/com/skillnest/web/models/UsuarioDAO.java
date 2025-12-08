package com.skillnest.web.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skillnest.web.util.ConexionDB;

public class UsuarioDAO {
	private Connection conn;

    public UsuarioDAO() {
        ConexionDB.getInstancia();
		conn = ConexionDB.getConexion();
    }

    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (user,password) VALUES ( ?, ?)";

        try {
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
            ps.close();
            System.out.println("Usuario agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try { 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUser(rs.getString("user"));
                usuario.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

	public Usuario validarUsuario(String user, String password) {
		 Usuario usuario = null;
	        String sql = "SELECT * FROM usuarios WHERE user = ? and password = ?";
	        try { 
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, user);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                usuario = new Usuario();
	                usuario.setUser(rs.getString("user"));
	                usuario.setPassword(rs.getString("password"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usuario;
	}
}