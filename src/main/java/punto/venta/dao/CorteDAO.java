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
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class CorteDAO {
    
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    int idUsuario = UsuarioDAO.getIdUsuario();
    Connection conn= Conexion.conectarMySQL();



    public String[] getDatosPorDia() {
        String info[] = new String[8];
        try {
      
            Statement s = conn.createStatement();

            ResultSet datos = s.executeQuery("SELECT sum(monto) as dineroCaja FROM `Movimientos_extras`"
                    + " WHERE tipo = 'efectivo_inicial' and revisado = false and idUsuario=" + idUsuario + " and fecha = '" + formatoFecha.format(d) + "'");
            //ventas select sum(importe) as Ventas from ventas where idUsuario = 1 and revisada = false and fecha = "2020-07-28"
            datos.next();
            info[0] = datos.getString("dineroCaja");

            ResultSet ventasYcosto = s.executeQuery("select sum(importe) as ventas, sum(precioCosto*cantidad) as costo from ventas where idUsuario = " + idUsuario
                    + "  and devocompleta = false and fecha = '" + formatoFecha.format(d) + "' and tipoCompra='efectivo'");
           
         
             ventasYcosto.last();

            info[1] = ventasYcosto.getString("ventas");
            info[2] = ventasYcosto.getString("costo");

            ResultSet entradas = s.executeQuery("SELECT sum(monto) as entradas FROM `Movimientos_extras` WHERE tipo = 'entrada_efectivo' and revisado = false and idUsuario= " + idUsuario
                    + " and fecha = '" + formatoFecha.format(d) + "'");

            entradas.next();
            info[3] = entradas.getString("entradas");

            ResultSet salidas = s.executeQuery("SELECT sum(monto) as salidas FROM `Movimientos_extras` WHERE tipo = 'salida_efectivo' and revisado = false and idUsuario= " + idUsuario
                    + " and fecha = '" + formatoFecha.format(d) + "'");

         
            salidas.next();
            info[4] = salidas.getString("salidas");
            
            // DEVOLUCIONES
            
            ResultSet devolucion = s.executeQuery("SELECT sum(importe) as devolucion FROM `Ventas` where  devolucion = true and devocompleta = true and fecha = '"
                    + formatoFecha.format(d) + "' and idUsuario= " + idUsuario);
            System.out.println("SELECT sum(importe) as devolucion FROM `Ventas` where  devolucion = true and devocompleta = true and fecha = '"
                    + formatoFecha.format(d) + "' and idUsuario= " + idUsuario);
            devolucion.next();
            String dt1 = devolucion.getString("devolucion");
            if (dt1 == null) {
                dt1 = "0";
            }
            double d1 = Double.parseDouble(dt1);

            ResultSet devolucion2 = s.executeQuery("SELECT sum(monto) as devolucion FROM `Movimientos_extras` WHERE tipo = 'devolución' and revisado = false and  fecha = '" + formatoFecha.format(d) + "' and idUsuario= " + idUsuario);
            devolucion2.next();
            String dt2 = devolucion2.getString("devolucion");
            if (dt2 == null) {
                dt2 = "0.0";
            }
            d1 = d1 + Double.parseDouble(dt2);
            info[5] = d1 + "";

            //ABONOS
             ResultSet abonos = s.executeQuery("SELECT sum(abonado) as abonos FROM `credito` WHERE fechaAbono='"+formatoFecha.format(d)+"' and idUsuario= " +idUsuario);
             abonos.next();
             String abonoVerificado = abonos.getString("abonos");
             if(abonoVerificado==null){
             abonoVerificado="0.0";
             }
             info[6]=abonoVerificado;
             
             // ventas a credito
             ResultSet creditos = s.executeQuery("select sum(importe) as creditos, sum(precioCosto*cantidad) as costo from ventas where idUsuario = " + idUsuario
                    + "  and devocompleta = false and fecha = '" + formatoFecha.format(d) + "' and tipoCompra='credito'");
             creditos.next();
             String creditosVerificada = creditos.getString("creditos");
             if(creditosVerificada == null){
             creditosVerificada ="0.0";
             }
             info[7]=creditosVerificada;
             
            for (int i = 0; i < info.length; i++) {
                System.out.println(info[i]);
            }

        } catch (SQLException e) {
               
            System.out.println(e.getLocalizedMessage());
        }

        return info;

    }

}
