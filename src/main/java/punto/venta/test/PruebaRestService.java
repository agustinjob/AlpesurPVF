/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import punto.servicio.rest.ApiSend;
import punto.servicio.rest.RestDatos;
import punto.venta.dao.Conexion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Credito;
import punto.venta.modelo.response.VentasResponse;
import punto.venta.utilidades.Utilidades;
import punto.venta.modelo.ModeloFechas;
import punto.venta.modelo.response.ResponseGeneral;


/**
 *
 * @author agus_
 */
public class PruebaRestService {
    
    public static void main(String[]Job){
        try {
            ModeloFechas fechs= new ModeloFechas();
            ApiSend api = new ApiSend();
            
            fechs.setFechaI("2022-02-01");
            fechs.setFechaF("2022-02-22");
            
            String fechaC="2022-03-01 09:49:02";
            DateFormat formatoCompletoConT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d=formatoCompletoConT.parse(fechaC);
            Credito obcre= new Credito();
       obcre.setAbonado(100);
       obcre.setFinalizado(true);
       obcre.setIdCliente(1);
       obcre.setIdCredito(0);
       obcre.setMonto(400);
       obcre.setIdTicket(99);
   
       
       String f[]=Utilidades.getFechaDivididaString(fechaC);
       ResponseGeneral res=api.usarAPI(EnviromentLocal.urlG+"creditos/"+f[0]+"%20"+f[1], obcre, "POST");
            
            VentasResponse ven=api.getVentas(EnviromentLocal.urlG+"ventas-fiff", fechs);
        } catch (ParseException ex) {
            Logger.getLogger(PruebaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
       
        
    }
    
    
}
