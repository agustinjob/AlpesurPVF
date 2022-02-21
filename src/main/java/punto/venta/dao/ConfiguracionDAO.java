/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ConfiguracionDAO {

    Conexion SQL = new Conexion();
    BitacoraDAO bita = new BitacoraDAO();
    Confirmacion confir;
    Connection conn= Conexion.conectarMySQL();


    public String almacena(String[] a) throws ClassNotFoundException, SQLException {
   
        Statement s = conn.createStatement();

        int rs = s.executeUpdate("UPDATE `configuracion` SET `impresora`='"+a[0]+"',`nombreLocal`='"+a[1]+"',`rfc`='"+a[2]+"',`direccion`='"+a[3]+"' WHERE idConfiguracion=1");
        String mensajeBita = "Se modificaron los datos del negocio";
        bita.registrarBitacora(mensajeBita);
        return  ("Se han modificado los datos de forma exitosa");
    }
    
    public ResultSet recuperarDatos() throws ClassNotFoundException, SQLException{

     Statement s = conn.createStatement();
     ResultSet res = s.executeQuery("SELECT * FROM configuracion where idConfiguracion = 1");
     return res;
        
    }

}
