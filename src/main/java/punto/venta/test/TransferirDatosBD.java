/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import punto.servicio.rest.ApiSend;

import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Producto;
import punto.venta.modelo.response.ResponseGeneral;

/**
 *
 * @author agus_
 */
public class TransferirDatosBD {
    public static void main(String[]Job){
        ApiSend api=new ApiSend();
        try {
            Connection conn=null;
            Statement s = conn.createStatement();
            ResultSet resa = s.executeQuery("Select * from producto");
            Producto p = new Producto();
            while(resa.next()){
            p.setArea(resa.getString("area"));
            p.setCantidad(resa.getFloat("cantidad"));
            p.setCodigo(resa.getString("codigo"));
            p.setDescripcion(resa.getString("descripcion"));
            p.setInventarioMinimo(resa.getFloat("inventarioMinimo"));
            p.setPrecioCosto(resa.getFloat("precioCosto"));
            p.setPrecioDistribuidor(resa.getFloat("precioDistribuidor"));
            p.setPrecioMayoreo(resa.getFloat("precioMayoreo"));
            p.setPrecioVenta(resa.getFloat("precioVenta"));
             ResponseGeneral res=api.usarAPI(EnviromentLocal.urlG+"productos", p, "POST");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferirDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
