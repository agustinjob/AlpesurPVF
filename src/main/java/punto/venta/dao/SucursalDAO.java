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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import punto.venta.misclases.TransferenciaProductos;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class SucursalDAO {
     Connection conn=null;
     DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
     
   
     public  ResultSet obtenerSucursales(){
         try {
             ResultSet res=null;
             
             Statement s = conn.createStatement();
             res = s.executeQuery("select * from sucursal where idSucursal !="+Datos.idSucursal);
             
             return res;
             
           
         } catch (SQLException ex) {
                  
             Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           return null;
     }
     
     public  ResultSet obtenerProductosPorSucursal(){
         try {
             ResultSet res=null;
             Statement s = conn.createStatement();
             res = s.executeQuery("select * from producto where cantidad>0 and idSucursal="+Datos.idSucursal);
             
             return res;
             
           
         } catch (SQLException ex) {
                  
             Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           return null;
     }
     
        public  ResultSet obtenerProductoPorNombre(String nombre){
         try {
             ResultSet res=null;
             Statement s = conn.createStatement();
             res = s.executeQuery("select * from producto where descripcion='"+nombre+"'");
             
             return res;
             
           
         } catch (SQLException ex) {
                  
             Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           return null;
     }
        
        public String realizarTraspaso(TransferenciaProductos tran){
       
     //    try {
     /*        Statement s = conn.createStatement();
             conn.setAutoCommit(false);
             int total= tran.getMd().getRowCount();
             DefaultTableModel modelo=tran.getMd();
             ResultSet productoInventario;
             for(int i=0;i<total;i++){
                 double cantidad= Double.parseDouble((String)modelo.getValueAt(i, 3));
                 double precioCosto=Double.parseDouble((String) modelo.getValueAt(i, 4));
                 double inventario =Double.parseDouble((String) modelo.getValueAt(i, 2));
                 String codigo = (String) modelo.getValueAt(i,0);
                 
                 
            
            // Se realiza la actualización del inventario de la sucursal que esta enviando productos 
             s.executeUpdate("UPDATE `producto` SET `cantidad`= "+(inventario-cantidad)+" ,`estatus`='En proceso', `operacion`='Modificacion' WHERE codigo = '"+codigo+"'  and idSucursal="+Datos.idSucursal);
             //Seleccionamos el producto al cual se le va agregar inventario de la que recibe 
             productoInventario= s.executeQuery("Select * from producto where codigo = '"+codigo+"' and idSucursal = "+tran.getIdSucursalEnvio()+" and eliminado=false;");
             // Se realiza condición para saber si el código existe en la sucursal que recibew
             productoInventario.last();
             
             if(productoInventario.getRow()==0){
                 //Si no existe un código se regresa todo a como estaba
             conn.rollback();
             return "El producto: " + modelo.getValueAt(i, 1) + " con código: " + codigo + " no se encuentra en la otra sucursal, no se realizarán los cambios";
             }
             productoInventario.first();
             //Se actualiza inventario de la sucursal que recibe productos
             s.executeUpdate("UPDATE `producto` SET `cantidad`="+(productoInventario.getDouble("cantidad")+cantidad)+", `estatus`='En proceso', `operacion`='Modificacion' WHERE codigo = '"+codigo+"' and idSucursal="+tran.getIdSucursalEnvio());
             
             // Se registra la información de los traspasos
             s.executeUpdate("INSERT INTO `traspaso`(`idSucursalE`, `idSucursalR`, `idProducto`, `precioCompra`, `cantidad`, `monto`, `fecha`,propietario,operacion,estatus,codigo)" +
                                                    "VALUES ("+Datos.idSucursal+","+tran.getIdSucursalEnvio()+",0,"+precioCosto+","+cantidad+","+(cantidad*precioCosto)+",'"+formatoFecha.format(d)+"','Jely','Registro','En proceso','"+codigo+"');");
             
             }
              conn.commit();
         } catch (SQLException ex) {
                  
             try {
                  System.out.println("Entro acá");
                 System.out.println(ex.getLocalizedMessage());
                 conn.rollback();
             } catch (SQLException ex1) {
                    
                 return "Hubo un error con la conexion a la base de datos, no se pudo regresar la información a como estaba anteriormente. Por favor revisa tus datos";
               
             }
            
                return "No se hizo la transferencia, por favor revisa tu conexion a internet y vulve a intentarlo, no se realizo ningún cambio";
              */
         //}
         
         return "La transferencia se realizado correctamente";
        }
}
