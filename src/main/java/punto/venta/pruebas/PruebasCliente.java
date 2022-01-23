/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.pruebas;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import punto.venta.dao.ClienteDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class PruebasCliente {
    public static void main(String [] Job) throws SQLException, ClassNotFoundException{
        
        ClienteDAO clien= new ClienteDAO();
        clien.getClientes();
  /*
    Calendar c = new GregorianCalendar(2020, 8, 9);
String dia = Integer.toString(c.get(Calendar.DATE));
String mes = Integer.toString(c.get(Calendar.MONTH));
String semanaanno = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
System.out.println("semana del año: ".toUpperCase()+semanaanno);

    Calendar ca = new GregorianCalendar(2021, 8, 9);
 dia = Integer.toString(ca.get(Calendar.DATE));
 mes = Integer.toString(ca.get(Calendar.MONTH));
 semanaanno = Integer.toString(ca.get(Calendar.WEEK_OF_YEAR));
System.out.println("semana del año: ".toUpperCase()+semanaanno);
   */ }
    
}
