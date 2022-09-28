/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;

/**
 *
 * @author ovalo
 */
public class ClienteDAO {

    public static List<Cliente> obtenerTodos() {
        List<Cliente> cliente = new ArrayList<>();

        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, direccion, telefono, email FROM cliente");
            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setTelefono(resultSet.getString(4));
                c.setEmail(resultSet.getString(5));
                cliente.add(c);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error " + ex.getMessage());
        }
        return cliente;

    }

    public static boolean guardar(String nombre, String direccion, String telefono, String email) {
        boolean resultado = false;

        try {
            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cliente nombre, direccion, telefono VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            statement.setString(4, email);

            resultado = statement.getUpdateCount() == 1;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error " + ex.getMessage());
        }
        return resultado;
    }

    public static boolean validarCorreo(String email) {

        boolean resultado = false;

        try {
            Connection cone = Conexion.obtener();
            String consulta = "Select email FROM cliente WHERE email = ?";
            PreparedStatement statemnet = cone.prepareCall(consulta);
            statemnet.setString(1, email);
            ResultSet rs = statemnet.executeQuery();
            resultado = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;

    }

}
