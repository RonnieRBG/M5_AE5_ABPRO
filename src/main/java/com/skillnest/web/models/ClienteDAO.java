package com.skillnest.web.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillnest.web.util.ConexionDB;

public class ClienteDAO {

	private Connection conn;

    public ClienteDAO() {
        ConexionDB.getInstancia();
		conn = ConexionDB.getConexion();
    }
    
    
    public void guardar (Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, descripcion, telefono) VALUES (?, ?, ?)";
        // se agrega este print para comprobar la insercion
        System.out.println("Preparando inserción en BD...");
        try {
            //Connection conn = ConexionDB.getInstancia().getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDescripcion());
            ps.setInt(3, cliente.getTelefono());
        
           // ps.executeUpdate();
            
            //si la insercion se realiza bien deberia imprimir el numero de filas inser
            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas = " + filas);
            ps.close();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
   
	public List<Cliente> obtenerTodos() {
    	 List<Cliente> lista = new ArrayList<>();
    	 
    	 try { 
		   String sql = "SELECT * FROM clientes";
		   
		        Connection conn = ConexionDB.getInstancia().getConexion();
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
    	 
		        while (rs.next()) {
		        	Cliente cliente = new Cliente (
		            rs.getInt("id"),
		            rs.getString("nombre"),
		            rs.getString("descripcion"),
		            rs.getInt("telefono")  );
		        	 
		        	lista.add(cliente);
		        	
		        }
		        rs.close();
		        ps.close(); 
		        
    	 } catch (SQLException e) {
		              e.printStackTrace();
		    }
			return lista;
		
	}
	
    public Cliente obtenerPorId(int id) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";
        
        try {
      
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Creamos el objeto con los datos encontrados
                c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("telefono")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c; 
    }


	public void actualizar(Cliente c) {
	    String sql = "UPDATE clientes SET nombre=?, descripcion=?, telefono=? WHERE id=?";
	    
	    try {
	        Connection conn = ConexionDB.getInstancia().getConexion();
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, c.getNombre());
	        ps.setString(2, c.getDescripcion());
	        ps.setInt(3, c.getTelefono());
	        ps.setInt(4, c.getId()); 	        
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

	
	public void eliminar(int id) {
		String sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		} catch (SQLException e) {
            e.printStackTrace();
            
	}

	}

}

