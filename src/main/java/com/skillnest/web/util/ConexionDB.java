package com.skillnest.web.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    private static ConexionDB instancia;
    private static Connection conexion;
    //private final String diverDB = "MySQL";
    private final String URL = "jdbc:mysql://localhost:3306/gestionclientes";
    private final String USUARIO = "root";
    private final String CONTRASENA = "Admin1234.";

    private ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            //conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public static Connection getConexion() {
        return conexion;
    }
}