package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    public static Connection obtenerConexion() {
        Connection conectar = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca2", "root", "");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
        

    }
}
