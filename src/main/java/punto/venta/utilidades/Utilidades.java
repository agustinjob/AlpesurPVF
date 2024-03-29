/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.utilidades;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;
import punto.venta.dialogos.Confirmacion;
import static punto.venta.enviroment.EnviromentLocal.configuracion;
import punto.venta.modelo.Usuario;

/**
 *
 * @author agus_
 */
public class Utilidades {

    static Confirmacion confirma = new Confirmacion();
    static DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    static DateFormat formatoCompleto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static DateFormat formatoCompletoConT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    public static DecimalFormat df = new DecimalFormat("#,###.##");

     public static String formaDos(float val) {
        return df.format(val);
    }
     
    public static void im(String mensaje) {
        System.out.println(mensaje);
    }

    public static String regresarNombre() {
        String nombres[] = UsuarioDAO.getNombre().split(" ");
        return "Atiende:" + nombres[0];
    }

    public static boolean hayVacios(String a[]) {
        boolean bandera = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i].equalsIgnoreCase("")) {
                bandera = true;
            }
        }
        return bandera;
    }

    public static Double[] hayNulosACero(String a[]) {
        Double x[] = new Double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                x[i] = 0.0;
            } else {
                x[i] = Double.parseDouble(a[i]);
            }

        }
        return x;
    }
    
    public static void asignarDatosConfiguracion(){
        try {
            File doc = new File(configuracion);
            doc.createNewFile();
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            
           
            String propietario= (String)obj.readLine().split("=")[1];
            String idSucursal= (String)obj.readLine().split("=")[1];
            String sucursal= (String)obj.readLine().split("=")[1];
            String formatoSistema= (String)obj.readLine().split("=")[1];
            Datos.propietario=propietario;
            Datos.idSucursal= Integer.parseInt(idSucursal);
            Datos.sucursal=sucursal;
            Datos.formatoSistema=formatoSistema;
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        System.out.println("Si entro");
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public static void capturaPantalla(String nombre) throws AWTException, IOException {
        BufferedImage captura = new Robot().createScreenCapture(
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        String Nombre;

        Date d = new Date();
     

        File directorio = new File("C:\\punto_venta\\capturas\\");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {

                System.out.println("Error al crear directorio");
            }
        }
        // Guardar Como JPEG
        String nombreC = "C:\\punto_venta\\capturas\\" + nombre + "-" + formatoFecha.format(d) + " " + formatoHora.format(d) + " hrs";
        File file = new File(nombreC + ".jpg");
        ImageIO.write(captura, "jpg", file);
        JOptionPane.showMessageDialog(null, "Captura realizada");
    }

    public static void confirma(Confirmacion x, String mensaje) {
        x = new Confirmacion();
        x.setMensaje(mensaje);
        x.setFocusable(true);
        x.setVisible(true);
    }

    public static void cierraConfirma(Confirmacion x) {
        x.setVisible(false);
    }

    public static void mensajePorTiempo(String men) {
        confirma.setMensaje(men);
        confirma.setVisible(true);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();

            }

        });

        timer.setRepeats(false);
        timer.start();
    }
    
     public static void mensajePorTiempo(String men, int tiempo) {
        confirma.setMensaje(men);
        confirma.setVisible(true);

        Timer timer = new Timer(tiempo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();

            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    public static void hayConexion() {
        String url = "http://www.mscagustinjob.online/restweb/dateservice.php?tipo=datosfecha";

    }

    /*   public static void jo(String mensaje){
    UIManager UI=new UIManager();
    UI.put("OptionPane.background", Color.white);
   // UI.put("Panel.background", Color.white);
  

    JOptionPane.showMessageDialog(null,mensaje,"SetColor",JOptionPane.INFORMATION_MESSAGE);
    }*/
    public static String getHora(Date date) {
        String hora = formatoHora.format(date);
        return hora;
    }
    
    public static Date getStringToDate(String d){
        try {
            Date da=formatoFecha.parse(d);
              return da;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
    
      public static Date getStringToDateCompleto(String d){
        try {
            Date da=formatoFecha.parse(d);
              return da;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
      
         public static Date getStringToDateCompletoConT(String d){
        try {
            Date da=formatoCompletoConT.parse(d);
              return da;
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }

    public static String getFechaString() {
        Date date = new Date();
        String fecha = formatoFecha.format(date);
        System.out.println(fecha);
        return fecha;
    }

    public static String getFechaString(Date date) {

        String fecha = formatoFecha.format(date);
        System.out.println(fecha);
        return fecha;
    }
    
     public static String getFechaStringCompleto(Date date) {

        String fecha = formatoCompleto.format(date);
        System.out.println(fecha);
        return fecha;
    }
     
         public static String[] getFechaDivididaString(String date) {
             String[] dat=new String[2];
             dat=date.split(" ");
        return dat;
    }
}
