/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import punto.venta.misclases.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class ClienteDAO {

    BitacoraDAO bita = new BitacoraDAO();
    Confirmacion confirma;
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
     Connection conn= null; 

    public String almacena(String[] a, String estatus, String operacion){
    
        try {
            Statement s = conn.createStatement();
               ResultSet datos = s.executeQuery("Select * from cliente where email ='"+a[5]+"' and idSucursal="+Datos.idSucursal);
               System.out.println("Select * from cliente where email ='"+a[6]+"' and idSucursal="+Datos.idSucursal);
               datos.last();
               if(datos.getRow()==0){
            int rs = s.executeUpdate("INSERT INTO cliente(`nombre`, `direccion`, `telefono`, `limiteCredito`, `eliminado`,`rfc`,`email`,`mayorista`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`, `estatusCliente`) "
                    + "VALUES ('" + a[0] + "','" + a[1] + "','" + a[2] + "','" + a[3] + "', false,'"+a[4]+"','"+a[5]+"','"+a[6]+"','Local','"+estatus+"','"+operacion+"','"+Datos.propietario+"','"+Datos.idSucursal+"','vigente')");
            
            String mensajeBita = "Registro al cliente " + a[0];
            bita.registrarBitacora(mensajeBita);
            return "Datos del cliente agregados correctamente";
               }
               else{
                   return "Ya existe otro cliente con ese email";
               }
            
        } catch (SQLException ex) {
                 
          return "Error en la base de datos";
        } catch (ClassNotFoundException ex) {
                 
           return "Error en la base de datos";
        }
    }

    public ArrayList<Cliente> getClientes() throws ClassNotFoundException, SQLException {

        ArrayList<Cliente> listado = new ArrayList<Cliente>();

     
        Statement s = conn.createStatement();
        ResultSet res = s.executeQuery("Select * from cliente where eliminado = false");

        while (res.next()) {
      

            Cliente cli = new Cliente();
              
            cli.setId(res.getString(1));
            cli.setNombres(res.getString(2));
            cli.setDireccion(res.getString(3));
            cli.setTelefono(res.getString(4));
            cli.setLimiteCredito(res.getString(8));
            cli.setEmail(res.getString(5));
            cli.setRfc(res.getString(6));
            cli.setMayorista(res.getString(7));
            cli.setIdSucursal(res.getString("idSucursal"));
            

            listado.add(cli);

        }

        return listado;
    }

    public int modificarDatosCliente(Cliente c,Cliente temporal,String estatus,String operacion) {
        try {

            Statement s = conn.createStatement();
            String update = "UPDATE cliente SET `email`='"+c.getEmail()+"' , `rfc`='"+c.getRfc()+"',`operacion`='"+operacion+"', `estatus`='"+estatus+"', `mayorista`='"+c.getMayorista()+"', `nombre`='" + c.getNombres() + "',`direccion`='" + c.getDireccion() + "',`telefono`='" + c.getTelefono() + "',`limiteCredito`=" + c.getLimiteCredito() + " WHERE idSucursal = " + temporal.getIdSucursal()+ " and email='"+temporal.getEmail()+"' and rfc='"+temporal.getRfc()+"'";
            System.out.println(update);
            int modificar = s.executeUpdate(update);
           // Utilidades.confirma(confirma, "Datos del cliente modificados correctamente");

            String mensajeBita = "Modificó los datos del cliente " + c.getNombres();
            bita.registrarBitacora(mensajeBita);
            return modificar;
        } catch (SQLException e) {
               
            Utilidades.mensajePorTiempo( "Hubo un error con la conexion a la base de datos");
        } catch (ClassNotFoundException ex) {
                 
            Utilidades.mensajePorTiempo( "Hubo un error en el sistema");
        }
        
        return 0;
    }

    public int eliminarDatosCliente(Cliente c, String estatus, String operacion) {
        try {
            Statement s = conn.createStatement();
            String update = "UPDATE cliente SET `eliminado`= true ,`operacion`='"+operacion+"', `estatus`='"+estatus+"' WHERE idSucursal = " + c.getIdSucursal()+ " and email='"+c.getEmail()+"' and rfc='"+c.getRfc()+"'";
            int modificar = s.executeUpdate(update);
           
            String mensajeBita = "Elimino los datos del cliente " + c.getNombres();
            bita.registrarBitacora(mensajeBita);
            return modificar;
        } catch (SQLException e) {
               
            Utilidades.mensajePorTiempo( "Hubo un error en la conexion a la base de datos");
            System.out.println(e.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
                 
            Utilidades.mensajePorTiempo("Error en el sistema");
        }
        return 0;
    }
    // Compras a credito, para eso es este metodo para ver las tickets a credito
     public ResultSet obtenerTicketsCliente(String idCliente, boolean finalizado){
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `ventas` WHERE idCliente = "+idCliente+" and tipoCompra = 'credito' and devocompleta = false and finalizada = "+finalizado + " GROUP BY idTicket");
            
            rs.last();
            if (rs.getRow() == 0) {
                rs=null;
              
                
            } else {
                rs.beforeFirst();
          
                
            }
            
            return rs;
        
        } catch (SQLException ex) {
                 
             Utilidades.mensajePorTiempo( "Hubo un error con la conexión a la base de datos");
        }
     return null;
    }
     
       public ResultSet getVentasPorTicketCliente(String idTicket, String idCliente, String fecha) {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql = "";

            sql = "SELECT idVenta,nombre,precioVenta,cantidad,importe FROM `ventas` WHERE idTicket = " + idTicket + " and idCliente = "+idCliente + " and fecha = '"+fecha+"'";
            datos = s.executeQuery(sql);
         
            
        } catch (SQLException ex) { 
                 
          Utilidades.mensajePorTiempo( "Hubo un error con la conexión a la base de datos");
        } 

        return datos;

    }
       
      public double obtenerDeudaCliente(String idCliente){
      ResultSet datos = null;
      double suma=0;
          try {
            Statement s = conn.createStatement();
            String sql = "";

            sql = "SELECT sum(importe) as importe FROM `ventas` WHERE idCliente = "+idCliente+" and tipoCompra = \"credito\" and finalizada = false";
            datos = s.executeQuery(sql);
            datos.next();
            suma=datos.getDouble("importe");
            
        } catch (SQLException ex) { 
                 
          Utilidades.mensajePorTiempo("Hubo un error con la conexión a la base de datos");
        } 
          return suma;
      } 
      
      public ResultSet getAbonos(String idTicket, String idCliente, String fecha) {
        ResultSet datos = null;

        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM `credito` WHERE idTicket = " + idTicket + " and idCliente = "+idCliente + " and fecha = '"+fecha+"'";

            datos = s.executeQuery(sql);
          
            
        } catch (SQLException ex) { 
                 
          Utilidades.mensajePorTiempo( "Hubo un error con la conexión a la base de datos");
        }

        return datos;

    }
      
      public double getSaldoCliente(String idCliente){
          double creditos=0;
          double abonos=0;
          double total=0;
          
            try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT sum(importe) as importe FROM `ventas` WHERE idCliente = "+idCliente+" and tipoCompra = 'credito' and devocompleta = false and finalizada = false");
          
            rs.last();
            if (rs.getRow() == 0) {
               total=0;
                
            } else {
                rs.beforeFirst();
                rs.next();
                creditos= rs.getDouble("importe");
                ResultSet rs2 = s.executeQuery("SELECT sum(abonado) as abonado FROM `credito` WHERE idCliente = "+idCliente+" and finalizado = false");
                rs2.next();
                abonos=rs2.getDouble("abonado");
                total = creditos - abonos;
             
            }
          
        } catch (SQLException ex) {
             
             Utilidades.mensajePorTiempo("Hubo un error en la base de datos");
        }
          
          return total;
      }
      
      
      public void liquidarAdeudo(String idCliente,String nombre,String monto){
      int idUsuario=UsuarioDAO.getIdUsuario();
           

        try {
        // esto en credito la conjunción de todo
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            int rs = s.executeUpdate("INSERT INTO `credito`(`idCliente`, `idTicket`, `fecha`, `monto`, `abonado`, `fechaAbono`,`idUsuario`,`realizadaEn`,`estatus`,`operacion`,`propietario`) VALUES "
                    + " (" + idCliente + "," + "0" + ",'"+formatoFecha.format(d)+"', 0 , " + monto + ", '" + formatoFecha.format(d) + "',"+idUsuario+",'Local','En proceso','Registro','"+Datos.propietario+"')");
            int rs2 = s.executeUpdate("UPDATE `ventas` SET `finalizada`= true where idCliente =" + idCliente);
            int rs3 = s.executeUpdate("UPDATE `credito` SET `finalizado`= true where idCliente =" +idCliente );
            String mensajeBita = "Se liquidaron todos los adeudos del cliente " + nombre;
            bita.registrarBitacora(mensajeBita);
            conn.commit();
            Utilidades.mensajePorTiempo("Se liquido el adeudo total del cliente");
        } catch (ClassNotFoundException ex) {
                 
            Utilidades.mensajePorTiempo( "Hubo un error en el sistema");
        } catch (SQLException ex) {
                 
            System.out.println(ex.getLocalizedMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException exe) {
                    System.out.println(exe.toString());
                }
            }
            Utilidades.mensajePorTiempo( "Hubo un error con la conexion a la base de datos");
        }

    }
      
      
      
}
