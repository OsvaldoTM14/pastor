/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.negocio;

import mx.itson.pastor.persistencia.ClienteDAO;

/**
 *
 * @author ovalo
 */
public class ClienteNegocio {

    public static boolean guardar(String nombre, String direccion, String telefono, String email) {
        boolean resultado = false;

        try {
            if (!ClienteDAO.validarCorreo(email));
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return resultado;

    }

}
