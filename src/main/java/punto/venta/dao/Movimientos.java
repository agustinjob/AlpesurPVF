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

/**
 *
 * @author job
 */
public class Movimientos {
      Date d = new Date();
      DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
      DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
      
      int idUsuario = UsuarioDAO.getIdUsuario();
      BitacoraDAO bita = new BitacoraDAO();
      
      Connection conn=null;

      
    
      public ResultSet obteneEfectivoInicial(int id) throws ClassNotFoundException, SQLException {
        
      
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `movimientos_extras`  where tipo= 'efectivo_inicial' and fecha= '" + formatoFecha.format(d) + "' and idUsuario = "+id + " and idSucursal= "+Datos.idSucursal);
        //Utilidades.im("SELECT * FROM `movimientos_extras`  where tipo= 'efectivo_inicial' and fecha= '" + formatoFecha.format(d) + "' and idUsuario = "+id);
        
        rs.last();
        if (rs.getRow() == 0) {
            rs=null;
            System.out.println("No hay");
    
        } else {
            rs.beforeFirst();
            System.out.println("Si hay");
          
        }

        return rs;
    }
      //ResultSet rs = s.executeQuery("SELECT sum(monto) devoluciones FROM `movimientos_extras` where tipo= 'devolución' and fecha= '" + formatoFecha.format(d)+"'");
        
      
      public ResultSet getEntradasDelDia(String tipo) throws ClassNotFoundException, SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `movimientos_extras` where tipo= '"+ tipo +"' and fecha= '" + formatoFecha.format(d)+"' and idUsuario = "+idUsuario +" and idSucursal= "+ Datos.idSucursal);
        System.out.println("SELECT * FROM `movimientos_extras` where tipo= '"+ tipo +"' and fecha= '" + formatoFecha.format(d)+"' and idUsuario = "+idUsuario);
        rs.last();
        if (rs.getRow() == 0) {
            rs=null;
        } else {
            rs.beforeFirst();
            System.out.println("Si hay");  
        }
        return rs;
      }
      
      public ResultSet getEntradasProducto(String tipo, String codigo, String mes, String year){
          ResultSet rs = null;
        
          return rs;
      }
      
          public ResultSet getEntradasDelDiaPorSemana(String tipo) throws ClassNotFoundException, SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM `movimientos_extras` where tipo= '"+ tipo +"' and WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW())");
        rs.last();
        if (rs.getRow() == 0) {
            rs=null;
        } else {
            rs.beforeFirst();
         
        }
        
        return rs;
      
      }
      
       public ResultSet getDevoluciones() throws ClassNotFoundException, SQLException{      
       
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT sum(monto) as devoluciones FROM `movimientos_extras` where tipo= 'devolución' and fecha= '" + formatoFecha.format(d)+"'and idUsuario = "+idUsuario);
        rs.last();
        if (rs.getRow() == 0) {
            rs=null;
        } else {
            rs.beforeFirst();
            System.out.println("Si hay");  
        }
        
        return rs;
      
      }
      
    public void registrarEfectivoInicial(String monto, String tipo, String descripcion, String estatus, String operacion) throws ClassNotFoundException, SQLException{
       
    }  
}
