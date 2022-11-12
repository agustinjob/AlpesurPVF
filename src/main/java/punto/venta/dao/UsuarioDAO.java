/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import punto.venta.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import punto.venta.dialogos.Confirmacion;
import punto.venta.misclases.ConexionModel;
import punto.venta.utilidades.Utilidades;


/**
 *
 * @author job
 */
public class UsuarioDAO {
    int i = 0;
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
     public static int idUsuario;
     public static String nombre;
     public static String tipo;
     public static String hora;
     public static String fecha;
     public static String username;

     Connection conn= null;
  
     BitacoraDAO bita = new BitacoraDAO();
    Confirmacion confir;

     
    

    /**
     * @return the idUsuario
     */
    public static int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param aIdUsuario the idUsuario to set
     */
    public static void setIdUsuario(int aIdUsuario) {
        idUsuario = aIdUsuario;
    }

    /**
     * @return the nombre
     */
    public static String getNombre() {
        return nombre;
    }

    /**
     * @param aNombre the nombre to set
     */
    public static void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * @return the tipo
     */
    public static String getTipo() {
        return tipo;
    }

    /**
     * @param aTipo the tipo to set
     */
    public static void setTipo(String aTipo) {
        tipo = aTipo;
    }

    /**
     * @return the hora
     */
    public static String getHora() {
        return hora;
    }

    /**
     * @param aHora the hora to set
     */
    public static void setHora(String aHora) {
        hora = aHora;
         System.out.println("Desde el SET " + aHora);
    }

    /**
     * @return the fecha
     */
    public static String getFecha() {
        return fecha;
    }

    /**
     * @param aFecha the fecha to set
     */
    public static void setFecha(String aFecha) {
        fecha = aFecha;
    }

   
    
  
}
