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
import java.util.logging.Level;
import java.util.logging.Logger;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class AreaDAO {
    
    Connection conn;
    
      public void setConn(Connection conn){
     this.conn=conn;
     }
    public int guardar(String nombre,String estatus, String operacion){
         try {
          
             Statement s = conn.createStatement();
             String sql="INSERT INTO `area`(`nombre`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`) VALUES ('"+nombre+"','Local','"+estatus+"','"+operacion+"','"+Datos.propietario+"','"+Datos.idSucursal+"')";
             int rs = s.executeUpdate(sql);
             return 1;
         } catch (SQLException ex) {
                   Utilidades.escribirLog(ex.getLocalizedMessage());
             return 0;
         }

    }
    
        public int eliminar(String nombre, String estatus, String operacion){
         try {
            
             Statement s = conn.createStatement();
             String sql="Update area set estatusArea='Eliminada', estatus='"+estatus+"', operacion='"+operacion+"' WHERE nombre='"+nombre+"' and idSucursal= " + Datos.idSucursal;
             int rs = s.executeUpdate(sql);
             return 1;
         } catch (SQLException ex) {
                   Utilidades.escribirLog(ex.getLocalizedMessage());
            return 0;
         }

    }
    
    public ResultSet obtenerAreas(){
        
         try {
           
             Statement s = conn.createStatement();
             ResultSet r;
             r=s.executeQuery("select * from area where estatusArea='vigente'");
             
             return r;
         } catch (SQLException ex) {
                   Utilidades.escribirLog(ex.getLocalizedMessage());
             Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return null;
    }
    
      public boolean encontrarAreasPorNombre(String nombre){
        
         try {
            
             Statement s = conn.createStatement();
             ResultSet rs;
             rs=s.executeQuery("select * from area where nombre='"+nombre+"'");
             rs.last();
             if(rs.getRow()==0){
             return false;
             }
             return true;
             
             
         } catch (SQLException ex) {
                   Utilidades.escribirLog(ex.getLocalizedMessage());
             Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
        
    }
      
      public ResultSet obtenerTodoPorArea(String area){
          
           try {
             Statement s = conn.createStatement();
             ResultSet r;
             r=s.executeQuery("select * from producto where area='"+area+"'");
             
             return r;
         } catch (SQLException ex) {
                   Utilidades.escribirLog(ex.getLocalizedMessage());
             Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return null;
      }
}
