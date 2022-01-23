/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import punto.servicio.rest.RestDatos;
import punto.venta.misclases.ConexionModel;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author Rodas
 */
public class Conexion {

    private static Connection con=null;
     private static Connection conHost=null;
    // Librería de MySQL
    public static String driver = "com.mysql.jdbc.Driver";
  
    public static String databaseHost = "punvenalpesur";
    public static String database = "puntoalpesur";
    // Host
      public static String hostnameHost = "193.46.199.155";
      public static String hostname = "localhost";
    // Puerto
    public static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public static String url = "jdbc:mysql://"+hostname+":3306/"+database+"?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    public static String urlHost = "jdbc:mysql://"+hostnameHost+":3306/"+databaseHost+"?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    // Nombre de usuario
    public static String usernameHost = "job";
    public static String username = "root";
    // Clave de usuario
    public static String passwordHost = "agus218825101107Aa*";
   public static String password = "";

   
   public static ConexionModel conexi=new ConexionModel();

  
   
    public static Connection conectarMySQL(){
            if(con == null){
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
              
            }   catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       

        return con;
    }
    
    public static Connection conectarMyHost() {
            if(conHost == null){
            try {
                Class.forName(driver);
                conHost = DriverManager.getConnection(urlHost, usernameHost, passwordHost);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Entro acá al catch de conectar my host");
            }   catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    Statement s=conHost.createStatement();
                    s.executeQuery("Select * from producto");
                } catch (SQLException ex) {
                     
                    System.out.println("AQUI SE VE LA DESCONEXION");
                    conHost=null;
                    conectarMyHost();
                }
            }
       

        return conHost;
    }
    
  
    public static void getConexiones() {
            boolean hayInternet=false;
            Connection conn[]= new Connection[2];
            try {
                String result[] =RestDatos.sendPOST();
          
                hayInternet=true;
                
            } catch (UnsupportedEncodingException ex) {
                System.out.println(ex.getLocalizedMessage());
                 Utilidades.escribirLog(ex.getLocalizedMessage());
            } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());
                 Utilidades.escribirLog(ex.getLocalizedMessage());
           
            }
            
            
    
                if(hayInternet==false){
               
                    conexi.setLocal(conectarMySQL());
                    conexi.setHost(null);
                    conexi.setInternet(hayInternet);
                }else{
                    conexi.setLocal(conectarMySQL());
                    conexi.setHost(conectarMyHost());
                    conexi.setInternet(hayInternet);
                    
                }
                
                
            
             
             
           
            
    
        
    }


}
