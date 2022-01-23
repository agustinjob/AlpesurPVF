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
import punto.venta.misclases.ActualizacionesNecesarias;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ActualizacionDAO {

    private Connection connHost;
    private Connection connLocal;

    /**
     * @return the connHost
     */
    public Connection getConnHost() {
        return connHost;
    }

    /**
     * @param connHost the connHost to set
     */
    public void setConnHost(Connection connHost) {
        this.connHost = connHost;
    }

    /**
     * @return the connLocal
     */
    public Connection getConnLocal() {
        return connLocal;
    }

    /**
     * @param connLocal the connLocal to set
     */
    public void setConnLocal(Connection connLocal) {
        this.connLocal = connLocal;
    }

    public String subirActualizaciones() {
        return "";
    }

    public String descargarActualizaciones() {
        return "";
    }

    public ActualizacionesNecesarias buscarActualizaciones() {
        ActualizacionesNecesarias obj = new ActualizacionesNecesarias();
        try {
            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            boolean productoDes = false;
            boolean areasDes = false;
            boolean clientesDes = false;
            boolean usuariosDes = false;
            boolean productoSub = false;
            boolean areasSub = false;
            boolean clientesSub = false;
            boolean usuariosSub = false;
            boolean ventasSub = false;
            obj.setVentasSub("No necesario actualizar");
            obj.setClientesSub("No necesario actualizar");
            obj.setUsuariosSub("No necesario actualizar");
            obj.setProductosSub("No necesario actualizar");
            obj.setAreasSub("No necesario actualizar");
            obj.setClientesDes("No necesario actualizar");
            obj.setUsuariosDes("No necesario actualizar");
            obj.setProductosDes("No necesario actualizar");
            obj.setAreasDes("No necesario actualizar");

            res = sLocal.executeQuery("select * from ventas where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
          
                obj.setVentasSub("Es necesario actualizar");
            }

            res = sLocal.executeQuery("select * from cliente where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
           
                obj.setClientesSub("Es necesario actualizar");
            }

            res = sLocal.executeQuery("select * from usuario where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
           
                obj.setUsuariosSub("Es necesario actualizar");
            }

            res = sLocal.executeQuery("select * from producto where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
      
                obj.setProductosSub("Es necesario actualizar");
            }

            res = sLocal.executeQuery("select * from area where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
       
                obj.setAreasSub("Es necesario actualizar");
            }
            
            res = sHost.executeQuery("select * from area where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' ");
            res.last();
            if (res.getRow() != 0) {
     
                obj.setAreasDes("Es necesario actualizar");
            }
            
             res = sHost.executeQuery("select * from cliente where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' ");
            res.last();
            if (res.getRow() != 0) {
        
                obj.setClientesDes("Es necesario actualizar");
            }
            
            res = sHost.executeQuery("select * from producto where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
      
                obj.setProductosDes("Es necesario actualizar");
            }
            
            res = sHost.executeQuery("select * from usuario where idSucursal = " + Datos.idSucursal + " and estatus='En proceso'");
            res.last();
            if (res.getRow() != 0) {
      
                obj.setUsuariosDes("Es necesario actualizar");
            }

            return obj;
        } catch (SQLException ex) {
                Utilidades.escribirLog(ex.getLocalizedMessage());
          System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    public String buscarNubeVentasRegistro() {
        try {

            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
             Statement busqueda = connLocal.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from ventas where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion='Registro'");
     
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "INSERT INTO ventas(`idTicket`, `nombre`, `precioCosto`, `precioVenta`, `cantidad`, `importe`, `fecha`, `hora`, `idUsuario`, `mayoreo`, `codigo`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`,`tipoCompra`,`idCliente`,`finalizada`)"
                            + " VALUES (" + res.getString("idTicket") + ",'" + res.getString("nombre") + "'," + res.getString("precioCosto") + "," + res.getString("precioVenta") + "," + res.getString("cantidad") + "," + res.getString("importe") + ",'" + res.getString("fecha")
                            + "','" + res.getString("hora") + "'," + res.getString("idUsuario") + ",'" + res.getString("mayoreo") + "','" + res.getString("codigo") + "'," + "'" + res.getString("realizadaEn") + "','" + res.getString("estatus") + "','" + res.getString("operacion") + "','" + Datos.propietario + "'," + Datos.idSucursal+",'"+res.getString("tipoCompra")+"',"+res.getString("idCliente")+", "+res.getString("finalizada")+");";
                    System.out.println("UPDATE ventas set estatus='Actualizada' where idTicket=" + res.getString("idTicket") + "and codigo='" + res.getString("codigo") + "' and fecha='" + res.getString("fecha") + "' and hora='" + res.getString("hora") + "' and idSucursal=" + Datos.idSucursal);
                            sHost.executeUpdate(sql);
                    sLocal.executeUpdate("UPDATE ventas set estatus='Actualizada' where idTicket=" + res.getString("idTicket") + " and codigo='" + res.getString("codigo") + "' and fecha='" + res.getString("fecha") + "' and hora='" + res.getString("hora") + "' and idSucursal=" + Datos.idSucursal);
                    
                }
                connLocal.commit();
                    connHost.commit();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            Utilidades.escribirLog(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
            return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
        }
        return "Actualizaciones completadas";
    }

    public String buscarVentasModificacionesEliminacionesNoImplementada() {
        try {
            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
             Statement busqueda = connHost.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from cliente where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion != 'Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "UPDATE area set nombre='" + res.getString("nombre") + "', direccion='" + res.getString("direccion") + "', telefono='" + res.getString("telefono") + "', limiteCredito='" + res.getString("limiteCredito") + "', eliminado=" + res.getString("eliminado") + ","
                            + " rfc='" + res.getString("rfc") + "',email='" + res.getString("email") + "', mayorista='" + res.getString("mayorista") + "', estatusCliente='" + res.getString("estatusCliente") + "' realizadaEn='" + res.getString("realizadaEn") + "', estatus='Actualizada'  where email=" + res.getString("email") + " and idSucursal=" + Datos.idSucursal;
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE usuario set estatus='Actualizada' where email='" + res.getString("email") + "' and idSucursal=" + Datos.idSucursal);
                    
                }
                connLocal.commit();
                    connHost.commit();
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeClienteRegistro() {
        try {

            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
             Statement busqueda = connHost.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from cliente where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion='Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "INSERT INTO cliente(`nombre`, `direccion`, `telefono`, `limiteCredito`, `eliminado`,`rfc`,`email`,`mayorista`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`, `estatusCliente`) "
                            + "VALUES ('" + res.getString("nombre") + "','" + res.getString("direccion") + "','" + res.getString("telefono") + "','" + res.getString("limiteCredito") + "', false,'" + res.getString("rfc") + "','" + res.getString("email") + "','" + res.getString("mayorista") + "','" + res.getString("realizadaEn") + "','Actualizada','Registro','" + Datos.propietario + "','" + Datos.idSucursal + "','vigente')";
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE cliente set estatus='Actualizada' where nombre='" + res.getString("nombre") + "' and email='" + res.getString("email") + "' and idSucursal=" + Datos.idSucursal);
                    
                }
                connLocal.commit();
                    connHost.commit();
            }
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
              return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
        }
        return "Actualizaciones completadas";
    }

    public String buscarClienteModificacionesEliminaciones() {
        try {
            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
             Statement busqueda = connHost.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from cliente where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion != 'Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "UPDATE area set nombre='" + res.getString("nombre") + "', direccion='" + res.getString("direccion") + "', telefono='" + res.getString("telefono") + "', limiteCredito='" + res.getString("limiteCredito") + "', eliminado=" + res.getString("eliminado") + ","
                            + " rfc='" + res.getString("rfc") + "',email='" + res.getString("email") + "', mayorista='" + res.getString("mayorista") + "', estatusCliente='" + res.getString("estatusCliente") + "' realizadaEn='" + res.getString("realizadaEn") + "', estatus='Actualizada'  where email=" + res.getString("email") + " and idSucursal=" + Datos.idSucursal;
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE usuario set estatus='Actualizada' where email='" + res.getString("email") + "' and idSucursal=" + Datos.idSucursal);
                  
                }
                  connLocal.commit();
                    connHost.commit();
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeUsuarioRegistro() {
        try {

            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
             Statement busqueda = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from usuario where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion='Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "INSERT INTO `usuario`(`nombre`, `direccion`, `username`, `password`, `tipoUsuario`, `telefono`, `eliminado`, `fecha`, `enSesion`, `hora`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`)"
                            + "VALUES ('" + res.getString("nombre") + "','" + res.getString("direccion") + "','" + res.getString("username") + "','" + res.getString("password") + "','" + res.getString("tipoUsuario") + "','" + res.getString("telefono") + "', false ,'" + res.getString("fecha") + "', false ,'" + res.getString("hora") + "','" + res.getString("RealizadaEn") + "','Actualizada','Registro','" + Datos.propietario + "'," + Datos.idSucursal + ")";
                    System.out.println("UPDATE area set estatus='Actualizada' where nombre='" + res.getString("nombre") + "' and username='" + res.getString("username") + "' and idSucursal=" + Datos.idSucursal);
                    sLocal.executeUpdate(sql);
                    
                    sHost.executeUpdate("UPDATE usuario set estatus='Actualizada' where nombre='" + res.getString("nombre") + "' and username='" + res.getString("username") + "' and idSucursal=" + Datos.idSucursal);
                   
                }
                 connLocal.commit();
                    connHost.commit();
            }
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
             return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
        }
        return "Actualizaciones completadas";
    }

    public String buscarUsuarioModificacionesEliminaciones() {
        try {
            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
             Statement busqueda = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);
            res = busqueda.executeQuery("select * from usuario where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion != 'Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "UPDATE area set nombre='" + res.getString("nombre") + "', direccion='" + res.getString("direccion") + "', username='" + res.getString("username") + "', password='" + res.getString("password") + "',tipoUsuario='" + res.getString("tipoUsuario") + "',"
                            + "telefono=" + res.getString("telefono") + ", eliminado=" + res.getString("eliminado") + ", fecha='" + res.getString("fecha") + "',hora='" + res.getString("hora") + "', realizadaEn='" + res.getString("realizadaEn") + "', estatus='Actualizada'  where username=" + res.getString("username") + " and idSucursal=" + Datos.idSucursal;
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE usuario set estatus='Actualizada' where username='" + res.getString("username") + "' and idSucursal=" + Datos.idSucursal);
                   
                }
                 connLocal.commit();
                    connHost.commit();
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeAreaRegistro() {
        try {

            ResultSet res = null;
            String sql = "";
            String sql2="";
            Statement sHost = connHost.createStatement();
             Statement busqueda = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);

            res = busqueda.executeQuery("select * from area where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion='Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "INSERT INTO `area`(`nombre`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`) VALUES ('" + res.getString("nombre") + "','"+res.getString("realizadaEn")+"','Actualizada','"+res.getString("operacion")+"','" + Datos.propietario + "','" + Datos.idSucursal + "');";
                   System.out.println(sql);
                   sql2="UPDATE area set estatus='Actualizada' where nombre='" + res.getString("nombre") + "' and idSucursal=" + Datos.idSucursal;
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate(sql2);
                      
                }
                 connLocal.commit();
                    connHost.commit();
             
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
              return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeAreaModificacionesEliminaciones() {
        try {

            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
            Statement busqueda = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);

            res = busqueda.executeQuery("select * from area where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion != 'Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "UPDATE area set estatusArea='" + res.getString("estatusArea") + "',estatus='Actualizada'  where nombre='" + res.getString("nombre") + "' and idSucursal=" + Datos.idSucursal;
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE area set estatus='Actualizada' where nombre='" + res.getString("nombre") + "' and idSucursal=" + Datos.idSucursal);
                   
                }
                 connLocal.commit();
                    connHost.commit();
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
                  return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeProductosRegistro() {
        try {

            ResultSet res = null;
            String sql = "";
            Statement sHost = connHost.createStatement();
             Statement busqueda = connHost.createStatement();
            Statement sLocal = connLocal.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);

            res = busqueda.executeQuery("select * from producto where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion='Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                while (res.next()) {
                    sql = "INSERT INTO producto(`codigo`, `descripcion`, `precioCosto`, `precioVenta`, `precioMayoreo`,`precioDistribuidor`, `cantidad`, `inventarioMinimo`, `eliminado`,`area`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`)"
                            + "VALUES ('" + res.getString("codigo") + "','" + res.getString("descripcion") + "'," + res.getDouble("precioCosto") + "," + res.getDouble("precioVenta") + "," + res.getDouble("precioMayoreo") + "," + res.getDouble("precioDistribuidor") + "," + res.getDouble("cantidad") + "," + res.getDouble("inventarioMinimo") + ", false,'" + res.getString("area") + "', 'Web','Actualizada','Registro','" + Datos.propietario + "'," + Datos.idSucursal + ")";
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate("UPDATE producto set estatus='Actualizada' where codigo=" + res.getString("codigo") + " and idSucursal=" + Datos.idSucursal);
                  
                }
                  connLocal.commit();
                    connHost.commit();
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }

    public String buscarNubeProductosModificacionesEliminaciones() {
        try {

            ResultSet res = null;
            String sql = "";
            String sql2="";
            Statement sLocal = connLocal.createStatement();
            Statement sHost = connHost.createStatement();
            Statement busqueda = connHost.createStatement();
            connLocal.setAutoCommit(false);
            connHost.setAutoCommit(false);

            res = busqueda.executeQuery("select * from producto where idSucursal = " + Datos.idSucursal + " and estatus='En proceso' and operacion != 'Registro'");
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                
                while (res.next()) {
                    sql = "UPDATE producto set codigo='" + res.getString("codigo") + "', descripcion='" + res.getString("descripcion") + "', precioCosto=" + res.getDouble("precioCosto") + ", precioVenta='" + res.getDouble("precioVenta") + "', precioMayoreo=" + res.getDouble("precioMayoreo") + ","
                       + " precioDistribuidor=" + res.getDouble("precioDistribuidor") + ", cantidad=" + res.getDouble("cantidad") + ", inventarioMinimo=" + res.getDouble("inventarioMinimo") + ", eliminado=" + res.getString("eliminado") + ", area='" + res.getString("area") + "', operacion ='" + res.getString("operacion") + "', estatus='Actualizada'  where codigo='" + res.getString("codigo") + "' and idSucursal=" + Datos.idSucursal;
                    sql2="UPDATE producto set estatus='Actualizada' where codigo='" + res.getString("codigo") + "' and idSucursal=" + Datos.idSucursal;
                    System.out.println(sql);
                    sLocal.executeUpdate(sql);
                    sHost.executeUpdate(sql2);
                    
                }
                connLocal.commit();
                connHost.commit();
                
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            try {
                connLocal.rollback();
                connHost.rollback();
            } catch (SQLException ex1) {
                return "No se pudieron hacer las actualizaciones, revisa si tienes Internet y vuelve a intentarlo";
            }
        }
        return "Actualizaciones completadas";
    }
}
