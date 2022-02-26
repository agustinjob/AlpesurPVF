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
import punto.servicio.rest.ApiSend;
import punto.servicio.rest.RestDatos;
import punto.venta.dao.Conexion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.response.VentasResponse;
import punto.venta.utilidades.Utilidades;
import punto.venta.modelo.ModeloFechas;


/**
 *
 * @author agus_
 */
public class PruebaRestService {
    
    public static void main(String[]Job){
       ModeloFechas fechs= new ModeloFechas();
       ApiSend api = new ApiSend();
       
         fechs.setFechaI("2022-02-01");
         fechs.setFechaF("2022-02-22");
              
              VentasResponse ven=api.getVentas(EnviromentLocal.urlG+"ventas-fiff", fechs);
    
     
       
        
    }
    
    
}
