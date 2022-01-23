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
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.RestDatos;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

public class VentasDAO {

    DefaultTableModel tm;
   
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    Confirmacion confir;
    int idUsuario;
    String fecha;
    String hora;
    BitacoraDAO bita = new BitacoraDAO();
 
     Connection conn;
     
     public void setConn(Connection conn){
     this.conn=conn;
     }
     
     public VentasDAO(){
     bita.setConn(Conexion.conexi.getLocal());
     }
     
     
     public void asignarFechaYHora(String fecha, String hora) throws IOException{
         if(fecha.equalsIgnoreCase("")){
        this.fecha= formatoFecha.format(d);
        this.hora =formatoHora.format(d);
         }else{
         
         this.fecha=fecha;
         this.hora=hora;
                 
         }
     }
     
 
    public String registrarVenta(DefaultTableModel md, int tipoCompra,String idCliente, String realizadaEn,String estatus, String operacion, int numTic) throws ClassNotFoundException, SQLException {
   
   
        tm = md;
        int i = 0;
        idUsuario = UsuarioDAO.getIdUsuario();
       
        try {

            Statement s = conn.createStatement();
            conn.setAutoCommit(false);
            String insert="";
            if(tipoCompra==1){
             insert = "INSERT INTO ventas(`idTicket`, `nombre`, `precioCosto`, `precioVenta`, `cantidad`, `importe`, `fecha`, `hora`, `idUsuario`, `mayoreo`, `codigo`, `realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`)";
            }else{
             insert = "INSERT INTO ventas(`idTicket`, `nombre`, `precioCosto`, `precioVenta`, `cantidad`, `importe`, `fecha`, `hora`, `idUsuario`, `mayoreo`, `codigo`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`,`tipoCompra`,`idCliente`,`finalizada`)";
            }

            while (i < md.getRowCount()) {
                double cantidad = Double.parseDouble(md.getValueAt(i, 3) + "");
                double precioVenta = Double.parseDouble(md.getValueAt(i, 2) + "");
                double total = cantidad * precioVenta;
                double existencia = Double.parseDouble(md.getValueAt(i, 5) + "");
                String codigo = (String) md.getValueAt(i, 0);
                double totalExistencia = existencia - cantidad;
                String value = " VALUES (" + numTic + ",'" + md.getValueAt(i, 1) + "'," + md.getValueAt(i, 6) + "," + precioVenta + "," + cantidad + "," + total + ",'" + fecha
                        + "','" + hora + "'," + idUsuario + ",'NO','" + codigo + "',"+"'"+realizadaEn+"','"+estatus+"','"+operacion+"','"+Datos.propietario+"',"+Datos.idSucursal;
             
                if(tipoCompra==2){
                value = value+", 'credito'," + idCliente + ", false" ;
                }
                System.out.println(insert + value + ")");
                s.executeUpdate(insert + value + ")");
                s.executeUpdate("UPDATE `producto` SET `cantidad`=" + totalExistencia + ", estatus= '"+estatus+"', operacion= 'Modificacion' WHERE codigo = '" + codigo + "'");
                i++;
            }
            conn.commit();
           
            String mensajeBita = "Venta registrada";
            bita.registrarBitacora(mensajeBita);
          
             return "Venta registrada con exito";
           
        } catch (SQLException e) {
                  Utilidades.escribirLog(e.getLocalizedMessage());
      
            System.out.println(e.getLocalizedMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                          Utilidades.escribirLog(ex.getLocalizedMessage());
                    System.out.println(ex.toString());
                }
            }
            
            return "Hubo un error en la base de datos";
        }

    }
    
    public double getVentasPorProducto(String codigo,String mes, String ano){
    double cantidad = 0;
         try {

        Statement s = conn.createStatement();
        String sql = "select sum(cantidad) cantidad from ventas where codigo = '"+codigo+"' and MONTH(fecha) ="+ mes +" and YEAR(fecha) = "+ano+" and devocompleta = false";
       ResultSet datos = s.executeQuery(sql);
       datos.next();
       if(datos.getString("cantidad").equalsIgnoreCase("null")){
       
       }else{
       cantidad = Double.parseDouble(datos.getString("cantidad"));
       }
         }catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }
         
         return cantidad;
         }

    public ResultSet consultarVentasPorFecha(int tipoBusqueda) {
        ResultSet datos = null;

        try {

            Statement s = conn.createStatement();
            String sql = "";

            if (tipoBusqueda == 1) {
                sql = "select codigo,nombre,cantidad,precioVenta,fecha,hora from ventas where fecha = '" + formatoFecha.format(d) + "'";
            }
            if (tipoBusqueda == 2) {
                sql = "select codigo,nombre,cantidad,precioVenta,fecha,hora from ventas where fecha = Date_format(DATE_SUB(NOW(),INTERVAL 1 DAY),'%Y-%m-%d')";
            }
            if (tipoBusqueda == 3) {
                sql = "select codigo,nombre,cantidad,precioVenta,fecha,hora from ventas where fecha >= Date_format(DATE_SUB(NOW(),INTERVAL 7 DAY),'%Y-%m-%d') && fecha <= '" + formatoFecha.format(d) + "'";
            }
            if (tipoBusqueda == 4) {
                sql = "select codigo,nombre,cantidad,precioVenta,fecha,hora from ventas where fecha >= Date_format(DATE_SUB(NOW(),INTERVAL 1 MONTH),'%Y-%m-%d') && fecha <= '" + formatoFecha.format(d) + "'";
            }
            datos = s.executeQuery(sql);
       
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return datos;
    }

    public ResultSet consultarVentasPorFechaPorLapsosDeTiempo(Date inicio, Date fin) {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql = "";

            sql = "select codigo,nombre,cantidad,precioVenta,fecha,hora from ventas where fecha >= '" + formatoFecha.format(inicio) + "' && fecha <= '" + formatoFecha.format(fin) + "'";
            datos = s.executeQuery(sql);
        
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
        }

        return datos;
    }

    public ResultSet getGananciasGraficaDeBarras() {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql = "";

            sql = "SELECT sum(importe) as ventas,sum(precioCosto*cantidad) as costo, (sum(importe)-sum((precioCosto*cantidad))) as ganancia , "
                    + "fecha, (ELT(WEEKDAY(fecha) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) AS DIA_SEMANA\n"
                    + "FROM ventas where WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) group by fecha";
            datos = s.executeQuery(sql);

        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return datos;

    }

    public ResultSet getNumeroVentasGragicaDePastel() {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql = "";

            sql = "SELECT SUM(cantidad) as cantidad,nombre FROM ventas WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) group by nombre";
            datos = s.executeQuery(sql);
     
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return datos;
    }

    public ResultSet getDatosReporteVentas() {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql, sql2 = "";

            sql = "SELECT SUM(importe) as ventas,sum(precioCosto*cantidad) as costo,sum(cantidad) as numeroVentas, (ELT(WEEKDAY(fecha) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes',"
                    + " 'Sabado', 'Domingo')) AS DIA_SEMANA FROM ventas WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) and devocompleta = false group by fecha order by fecha ";
            datos = s.executeQuery(sql);
       
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return datos;

    }

    public double getDevolucionPorSemana() {
        ResultSet datos = null;
        ResultSet datos2 = null;
        try {

            double total = 0;
            Statement s = conn.createStatement();
            String sql, sql2 = "";
            sql = "SELECT SUM(monto) as devoluciones FROM Movimientos_extras WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) and tipo = 'devolución'";
            sql2 = "SELECT SUM(importe) as devoluciones FROM ventas WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) and devocompleta = true";
            datos = s.executeQuery(sql);

            datos.next();
            String d1 = datos.getString("devoluciones");
            if(d1 == null){
                d1 = "0.0";}
            datos2 = s.executeQuery(sql2);
            datos2.next();
            String d2 = datos2.getString("devoluciones");
            if(d2 == null){
                d2 = "0.0";}
            
            return Double.parseDouble(d1) + Double.parseDouble(d2);

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
        } 
        return 0;
    }

    public ResultSet getVentasPorTicket(String idTicket,String fecha, String hora) {
        ResultSet datos = null;

        try {

            Statement s = conn.createStatement();
            String sql = "";
         
            sql = "SELECT idVenta,codigo,nombre,cantidad,importe FROM ventas WHERE idTicket = " + idTicket + " and fecha = '"+fecha+"' and hora='"+hora+"' and devocompleta = false ";
             
            datos = s.executeQuery(sql);
        
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return datos;

    }

    public ResultSet getDatosReporteVentasPorSemana() {
        ResultSet datos = null;

        try {

            Statement s = conn.createStatement();
            String sql, sql2 = "";

            sql = "SELECT SUM(importe) as ventas,sum(precioCosto*cantidad) as costo,sum(cantidad) as numeroVentas, (ELT(WEEKDAY(fecha) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes',"
                    + " 'Sabado', 'Domingo')) AS DIA_SEMANA FROM ventas WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and YEAR(fecha)=YEAR(NOW()) group by fecha order by fecha ";
            datos = s.executeQuery(sql);
            //   sql2="SELECT SUM(monto) as devoluciones, (ELT(WEEKDAY(fecha) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes','Sabado', 'Domingo')) AS DIA_SEMANA FROM Movimientos_extras WHERE WEEKOFYEAR(fecha)=WEEKOFYEAR(NOW()) and tipo = 'devolución' group by fecha order by fecha";

        } catch (SQLException ex) {
            Utilidades.escribirLog(ex.getLocalizedMessage());
            Utilidades.confirma(confir, "Hubo un error la conexión a la base de datos");
        }

        return datos;

    }

}
