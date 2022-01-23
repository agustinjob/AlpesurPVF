/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import punto.servicio.rest.RestDatos;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class TicketDAO {

    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    static int numero = 0;
    BitacoraDAO bi = new BitacoraDAO();
    String idUsuario = "";
    Confirmacion confir;
    Boolean hayInternet;
    Connection conn;
    
    public TicketDAO(){
    bi.setConn(Conexion.conexi.getLocal());
    }
    
     public void setConn(Connection conn){
     this.conn=conn;
     }

    public void insertarTicket() throws ClassNotFoundException {

       
        try {
           
            Statement s = conn.createStatement();
            s.executeUpdate("UPDATE `ticketc` SET `numero`=" + numero + " where idTicket=1;");
            System.out.println("UPDATE `ticketc` SET `numero`=" + numero + " where idTicket=1;");
            conn.commit();
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.toString());
        }
    }

    public void sumarTicket() throws ClassNotFoundException {
        numero++;
        insertarTicket();

    }

    public void setNumero(int num) {
        numero = num;
    }

    public int getNumero() {
        return numero;
    }

    public void consultarNumeroTicket() throws ClassNotFoundException, SQLException {
                try {

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT  numero FROM `ticketc`");
            rs.next();
            numero = rs.getInt("numero");
            System.out.println("Ticket: " + numero);
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.toString() + " " + ex.getLocalizedMessage());
        }
    }

    public void modificarEstatus() throws ClassNotFoundException, SQLException {
        // aqui hacer logica para modificar todos los anteriro a no activos activos = false
       
        try {

            Statement s = conn.createStatement();
            int rs = s.executeUpdate("UPDATE `ticketc` SET `numero`= 1");
            Utilidades.mensajePorTiempo("Se ha reiniciado la numeración del ticket");
            numero = 1;
            insertarTicket();

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.toString());
        }

    }

    public ResultSet getTickets(Date fecha) {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            datos = s.executeQuery("SELECT idTicket,fecha,hora FROM `Ventas` where fecha = '" + formatoFecha.format(fecha) + "' and devolucion = false  and devocompleta=false GROUP by fecha,hora");

            return datos;
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.toString() + " " + ex.getLocalizedMessage());
        }
        return datos;
    }

    public void eliminarVentasDeTicket(String idTicket,String fecha, String hora) {
        try {
            
            Statement s = conn.createStatement();
            Statement s2 = conn.createStatement();
            String sqlPorTicket = "Select codigo, cantidad from ventas where idTicket = " + idTicket + " and fecha = '"+fecha+"' and hora='"+hora+"'";
            System.out.println(sqlPorTicket);
                ResultSet porTick = s.executeQuery(sqlPorTicket);
                while (porTick.next()) {
                    String codi = porTick.getString("codigo");
                    String canti = porTick.getString("cantidad");
                    System.out.println("Codigo = " + codi + "Cantidad = "+ canti);
                    ResultSet numeroPro = s2.executeQuery("Select (cantidad+" + canti + ") as cantiTotal from Producto where codigo = '" + codi + "'");
                    numeroPro.next();
                    String cantiTotal = numeroPro.getString("cantiTotal");
                     System.out.println("CantiTotal = " + cantiTotal);
                    int x = s2.executeUpdate("Update Producto Set cantidad = " + cantiTotal + " where codigo = '" + codi + "'");
                    bi.registrarBitacora("Se registró la devolución de "+ canti + " articulo(s) con el código "+codi);
                }
            String sql = "UPDATE `Ventas` SET devolucion = true, devocompleta = true, fecha = '" + formatoFecha.format(d) + "' where idTicket = " + idTicket + " and hora= '"+hora+"'";
            s.executeUpdate(sql);
            Utilidades.mensajePorTiempo("Se ha realizado la devolución");
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public void eliminarVentasDeTicketPorProducto(String idTicket, String codigo, String monto, double cantidad, int opcion, String canAgregar,String fecha, String hora) {
        idUsuario = UsuarioDAO.getIdUsuario() + "";
        try {
          
            Statement s = conn.createStatement();
            //Elimino todo el producto SELECT (cantidad+2) as cantidadSumada FROM `producto` where codigo = '3'
            conn.setAutoCommit(false);
            if (opcion == 1) {
                ResultSet cantidadTotal = s.executeQuery("select (cantidad+ "+canAgregar+ ") as cantiTotal from producto where codigo = '"+codigo+"'");
               cantidadTotal.next();
                String canTo= cantidadTotal.getString("cantiTotal");
               System.out.println("Cantitadad total "+ canTo );
                int x = s.executeUpdate("Update Producto Set cantidad = " + canTo + " where codigo = '" + codigo + "'");
                String sql = "UPDATE `Ventas` SET devolucion = true, devocompleta = true where idTicket = " + idTicket + " and codigo = '" + codigo + "' and fecha='"+fecha+"' and hora='"+hora+"'";
                s.executeUpdate(sql);
                bi.registrarBitacora("Se registró la devolución de "+ canAgregar + " articulo(s) con el código "+codigo);
            } else {
                ResultSet cantidadTotal = s.executeQuery("select (cantidad+ "+canAgregar+ ") as cantiTotal from producto where codigo = '"+codigo+"'");
                cantidadTotal.next();
                String canTo= cantidadTotal.getString("cantiTotal");
                int x = s.executeUpdate("Update Producto Set cantidad = " + canTo + " where codigo = '" + codigo + "'");
                String sql = "UPDATE `Ventas` SET devolucion = true, cantidad = " + cantidad + " where idTicket = " + idTicket + " and fecha='"+fecha+"' and hora='"+hora+"' and codigo = '" + codigo + "';";
                String sql2 = "INSERT INTO `Movimientos_extras`(`tipo`, `descripcion`, `monto`, `fecha`,`idUsuario`) VALUES ('devolución','Se registro la devolución del producto con cœdigo " + codigo + "'," + monto + " ,'" + formatoFecha.format(d) + "'," + idUsuario + ");";
                System.out.println(sql);
                System.out.println(sql2);
                s.executeUpdate(sql);
                s.executeUpdate(sql2);
                 bi.registrarBitacora("Se registró la devolución de "+ canAgregar + " articulo(s) con el código "+codigo);
            }
            conn.commit();
            
            Utilidades.mensajePorTiempo("Se ha realizado la devolución");
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Utilidades.mensajePorTiempo("Hubo un error en el sistema");
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
           Utilidades.mensajePorTiempo("Hubo un error con la base de datos");
        }
    }

}
