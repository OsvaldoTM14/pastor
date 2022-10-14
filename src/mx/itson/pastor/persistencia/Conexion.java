package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ovalo
 */
public class Conexion {

    public static Connection obtener() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pastordb1?user=root&password=Cr7711xd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;

    }
}
