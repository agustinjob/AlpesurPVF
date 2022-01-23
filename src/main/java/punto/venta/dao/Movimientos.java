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
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class Movimientos {
      Date d = new Date();
      DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
      DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
      Conexion SQL = new Conexion();
      int idUsuario = UsuarioDAO.getIdUsuario();
      BitacoraDAO bita = new BitacoraDAO();
      
      Connection conn;
      
      public Movimientos(){
      bita.setConn(Conexion.conexi.getLocal());
      }
      
     public void setConn(Connection conn){
     this.conn=conn;
     }
    
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
        ResultSet rs = s.executeQuery("SELECT * FROM `movimientos_extras` where tipo= '"+ tipo +"' and fecha= '" + formatoFecha.format(d)+"' and idUsuario = "+idUsuario);
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
          try {
              Conexion SQL = new Conexion();
              Connection conn = SQL.conectarMySQL();
              Statement s = conn.createStatement();
              rs = s.executeQuery("SELECT DAY(fecha) dia,sum(monto) cantidad FROM `movimientos_extras` where tipo= '"+ tipo + "' and descripcion = '"+codigo+"' and MONTH(fecha) = " + mes +
              " AND YEAR(fecha) = "+year +" group by fecha");
              rs.last();
              if (rs.getRow() == 0) {
                  rs=null;
              } else {
                  rs.beforeFirst();
                  System.out.println("Si hay");
              }
              
              return rs;
          } catch (SQLException ex) {
                    Utilidades.escribirLog(ex.getLocalizedMessage());
              Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
          }
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
       
        Statement s = conn.createStatement();
        int rs = s.executeUpdate("INSERT INTO `movimientos_extras`(`tipo`, `descripcion`, `monto`, `fecha`,`idUsuario`,`idSucursal`,`realizadaEn`,`estatus`,`operacion`,`propietario`) VALUES ('"+tipo+"','"+descripcion+"'," +monto+ " ,'"+formatoFecha.format(d)+"',"+idUsuario+","+Datos.idSucursal+", 'Local', '"+estatus+"','"+operacion+"','"+Datos.propietario+"')");
        String mensajeBita ="Se regitro la operación de " + tipo;
        bita.registrarBitacora(mensajeBita);
    }  
}
