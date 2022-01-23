/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import punto.servicio.rest.RestDatos;
import punto.venta.dao.Conexion;
import punto.venta.utilidades.Utilidades;


/**
 *
 * @author agus_
 */
public class PruebaRestService {
    
    public static void main(String[]Job){
        
        while(true){
        
            try {
                Thread.sleep(5000);
                
                    Conexion.getConexiones();
                
                if(Conexion.conexi.isInternet()){
                System.out.println("Es true");
                }else{
                 System.out.println("Es false");
                }
            } catch (InterruptedException ex) {
                       Utilidades.escribirLog(ex.getLocalizedMessage());
            }
            
        }
    
     
       
        
    }
    
    
}
