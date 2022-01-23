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
public class BitacoraDAO {
   
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    int idUsuario = UsuarioDAO.getIdUsuario();
      Connection conn;
      
     public void setConn(Connection conn){
     this.conn=conn;
     }
     
     public void registrarBitacora(String descripcion) throws ClassNotFoundException, SQLException{
   
        Statement s = conn.createStatement();
        int rs = s.executeUpdate("INSERT INTO bitacora(`descripcion`, `fecha`, `hora`, `idUsuario`,`realizadaEn`,`estatus`,`operacion`,`propietario`, `idSucursal`) VALUES ('"+descripcion+"','"+formatoFecha.format(d)+"','"+formatoHora.format(d)+"',"+idUsuario+",'Local','En proceso', 'Bitacoreo','"+Datos.propietario+"',"+Datos.idSucursal+")");
    }  
     
     public ResultSet getDatosBitacoraHoy(){
     
          try {
            Statement s = conn.createStatement();
            ResultSet datos = s.executeQuery("SELECT nombre,descripcion,bi.fecha,bi.hora FROM bitacora as bi, usuario as usu where bi.fecha ='"+formatoFecha.format(d)+"' and usu.idUsuario = bi.idUsuario");
            return datos;
        } catch ( SQLException e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }
       
        return null;
     }
     
     public ResultSet getDatosBitacoraPorRangoDeFecha(){
     return null;
     }
     
      public ResultSet getDatosBitacoraPorRango(Date inicio, Date fin){
     
          try {
            Statement s = conn.createStatement();
            ResultSet datos = s.executeQuery("SELECT u.nombre,bi.descripcion,bi.fecha,bi.hora FROM bitacora as bi,  usuario as u where bi.fecha >='"+formatoFecha.format(inicio)+"' and bi.fecha<='"+formatoFecha.format(fin)+"' and bi.idUsuario = u.idUsuario");
             return datos;
        } catch (SQLException e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }
       
        return null;
     }
     
   
    
}
