/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import punto.venta.dao.TicketDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import punto.venta.configuracion.Configuracion;
import punto.venta.dao.Conexion;
import punto.venta.dao.ConfiguracionDAO;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class ImprimirTicket {
    
 Date da = new Date();
 DateFormat formatoFecha = new SimpleDateFormat("dd, MMM yyyy");
 DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
 TicketDAO ticket = new TicketDAO();
 ConfiguracionDAO configuracion = new ConfiguracionDAO();
 String fecha;
 String hora;
 
   public void asignarFechaYHora(String fecha, String hora) throws IOException{
         if(fecha.equalsIgnoreCase("")){
        this.fecha= formatoFecha.format(da);
        this.hora =formatoHora.format(da);
         }else{
         
         this.fecha=fecha;
         this.hora=hora;
                 
         }
     }
 public ImprimirTicket(){
 ticket.setConn(Conexion.conectarMySQL());
 configuracion.setConn(Conexion.conectarMySQL());
 }
    public void imprimirTicket(String prueba)  {
        try {
            String[] d= recuperarDatos();
            byte[] bytes = prueba.getBytes();
            //Formato de Documento
//DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            DocFlavor docFormat = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Lectura de Documento
            Doc document = new SimpleDoc(bytes, docFormat, null);
//Nombre de la impresora
            String printerName = d[0];
//Inclusion del nombre de impresora y sus atributos
            AttributeSet attributeSet = new HashAttributeSet();
            attributeSet.add(new PrinterName(printerName, null));
            attributeSet = new HashAttributeSet();
//Soporte de color o no
            attributeSet.add(ColorSupported.NOT_SUPPORTED);
//Busqueda de la impresora por el nombre asignado en attributeSet
            PrintService[] services = PrintServiceLookup.lookupPrintServices(docFormat, attributeSet);
            int r=0;
            while(r<services.length){
            if(services[r].getName().equalsIgnoreCase(d[0])){
            break;
            }
            r++;
            }
        //    Utilidades.im("Desde el services " + services[r].getName());
            DocPrintJob printJob = services[r].createPrintJob();
//Envio a la impresora
            printJob.print(document, new HashPrintRequestAttributeSet());
        } catch (PrintException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
           JOptionPane.showMessageDialog(null, "Hubo un problema con tu impresora, el ticket no se imprimirá, pero la venta si será registrada");
        } catch(ArrayIndexOutOfBoundsException ex){
                  Utilidades.escribirLog(ex.getLocalizedMessage());
          JOptionPane.showMessageDialog(null, "Hubo un problema con tu impresora, el ticket no se imprimirá, pero la venta si será registrada");
        }
        
    }
    
       public String[] recuperarDatos(){
            String a[] = new String[4];
        try {
            ResultSet datos=  configuracion.recuperarDatos();
            // Impresora , Nombre, RFC , Direccion
            String info="";
           
            while(datos.next()){
                a[1]=datos.getString("nombreLocal");
                a[2]=datos.getString("direccion");
                a[3]=datos.getString("rfc");
                a[0]=datos.getString("impresora");
            }
            System.out.println("ESTE ES EL RECUPERAR DATOOS " + a[0] + " " + a[2]);
         
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
        public String convertirModeloAString(DefaultTableModel model, String total){
    int numTic = ticket.getNumero();
    String d[] = recuperarDatos();
    
        String titulo = " ===="+d[1]+"==== \n"
         +       " Direccion:"+d[2]+". \n"
        + "     Fecha: "+this.fecha+"\n"
               + "        Hora: "+this.hora+" \n"
         +       "     Num. de Ticket: "+numTic+" \n"
                  +       "============================== \n"
         +       "Cant.   Descripcion      Importe  \n";
        
        int i=0;
        int indice=0;
        while(model.getRowCount()>i){
        String productos ="";
        String can =(String) model.getValueAt(i, 3);
        String pro =(String) model.getValueAt(i, 1);
        String impor =(String) model.getValueAt(i, 4);
        if(pro.length()>=15){
        indice = 15;
        }else{
        indice = pro.length();
        }
        productos = padRight(can,8)  + padRight(pro.substring(0, indice),17) +  "$" +impor +"\n";
        titulo = titulo + productos;
        i++;
        }
        String ultima =      "============================== \n"
         +        "       Total : $"+total+"           \n"
         +        "   Gracias por su preferencia  \n\n\n";
        titulo = titulo + ultima;
        System.out.println(titulo);
        return titulo;
    }
       
    public String convertirModeloAStringReimprimirTicket(DefaultTableModel model, String total, String fecha, String hora,String id){
   
    String d[] = recuperarDatos();
    
        String titulo = " ===="+d[1]+"==== \n"
         +       " Dirección:"+d[2]+". \n"
        + "     Fecha: "+fecha+"\n"
               + "        Hora: "+hora+" \n"
         +       "     Num. de Ticket: "+id+" \n"
                  +       "============================== \n"
         +       "Cant.   Descripcion      Importe  \n";
        
        int i=0;
        int indice=0;
        while(model.getRowCount()>i){
        String productos ="";
        String can =(String) model.getValueAt(i, 2);
        String pro =(String) model.getValueAt(i, 1);
        String impor =(String) model.getValueAt(i, 3);
        if(pro.length()>=15){
        indice = 15;
        }else{
        indice = pro.length();
        }
        productos = padRight(can,8)  + padRight(pro.substring(0, indice),17) +  "$" +impor +"\n";
        titulo = titulo + productos;
        i++;
        }
        String ultima =      "============================== \n"
         +        "       Total : $"+total+"           \n"
         +        "   Gracias por su preferencia  \n\n\n";
        titulo = titulo + ultima;
        System.out.println(titulo);
        return titulo;
    }
    
    public String convertirModeloParaInventario(ResultSet res, String area){
   
     try {
         String d[] = recuperarDatos();
         
         String titulo = " ===="+d[1]+"==== \n"
                 +       " Dirección:"+d[2]+". \n"
                 + "     Fecha: "+formatoFecha.format(da)+"\n"
                 + "        Hora: "+formatoHora.format(da)+" \n"
                 +       "     Área: "+area+" \n"
                 +       "============================== \n"
                 +       "Cant.   Descripcion \n";
         
         int i=0;
         int indice=0;
         while(res.next()){
             String productos ="";
             String can =res.getString(7);
             String pro =res.getString(3);
             if(pro.length()>=20){
                 indice = 20;
             }else{
                 indice = pro.length();
             }
             productos = padRight(can,8)  + padRight(pro.substring(0, indice),17) +"\n";
             titulo = titulo + productos;
             i++;
         }
         String ultima =      "============================== \n"
                 
                 +        "   Inventario \n\n\n";
         titulo = titulo + ultima;
         System.out.println(titulo);
         return titulo;
     } catch (SQLException ex) {
               Utilidades.escribirLog(ex.getLocalizedMessage());
         Logger.getLogger(ImprimirTicket.class.getName()).log(Level.SEVERE, null, ex);
     }
     return "";
    }
    // 6 cantidad
    // 2
    public static String padRight(String s, int n) {
     return String.format("%-" + n + "s", s);  
}
    public static String padLeft(String s, int n) {
    return String.format("%" + n + "s", s);  
}
   

}
