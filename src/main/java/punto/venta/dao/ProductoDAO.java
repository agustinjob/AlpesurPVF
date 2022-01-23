/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dao;

import punto.venta.misclases.Producto;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class ProductoDAO {

    BitacoraDAO bita = new BitacoraDAO();
    Movimientos mov = new Movimientos();
    Confirmacion x;

    Connection conn;

    public ProductoDAO() {
        bita.setConn(Conexion.conexi.getLocal());
        mov.setConn(Conexion.conexi.getLocal());
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String almacena(String[] a, String estatus, String operacion) throws ClassNotFoundException, SQLException {

        Statement s = conn.createStatement();
        Statement s2 = conn.createStatement();
        Confirmacion x;
        boolean bandera = false;

        ResultSet res = s2.executeQuery("Select * from producto where descripcion='" + a[1] + "' || codigo = '" + a[0] + "' && eliminado = false");
        res.last();
        if (res.getRow() == 0) {

            int rs = s.executeUpdate("INSERT INTO producto(`codigo`, `descripcion`, `precioCosto`, `precioVenta`, `precioMayoreo`,`precioDistribuidor`, `cantidad`, `inventarioMinimo`, `eliminado`,`area`,`realizadaEn`,`estatus`,`operacion`,`propietario`,`idSucursal`)"
                    + "VALUES ('" + a[0] + "','" + a[1] + "'," + a[2] + "," + a[3] + "," + a[4] + "," + a[8] + "," + a[5] + "," + a[6] + ", false,'" + a[7] + "', 'Local','" + estatus + "','" + operacion + "','" + Datos.propietario + "'," + Datos.idSucursal + ")");

            String mensajeBita = "Registró el producto " + a[1];
            bita.registrarBitacora(mensajeBita);
            mov.registrarEfectivoInicial(a[5], "registro_producto", a[0], "Actualizada", "Registro");
            bandera = true;
            return "El producto ha sido agregado correctamente";
        } else {

            return "Ya existe un producto con ese código o nombre registrado en la base de datos";

        }

        //       System.out.println("INSERT INTO producto(`codigo`, `descripcion`, `precioCosto`, `precioVenta`, `precioMayoreo`, `cantidad`, `inventarioMinimo` )"
        //             + "VALUES ('" + a[0] + "','" + a[1] + "'," + a[2] + "," + a[3] + "," + a[4] + "," + a[5] + "," + a[6] + ")");
    }

    public ResultSet obtenerProductosPorCoincidencia(String cadena) throws SQLException {
        ResultSet res = null;

        Statement s = conn.createStatement();
        res = s.executeQuery("Select * from producto where eliminado = false and descripcion like'" + cadena + "%'");

        return res;
    }

    public ArrayList<Producto> obtenerProductosSiHuboModificacion(ArrayList<Producto> l, boolean bandera) throws ClassNotFoundException, SQLException {

        ArrayList<Producto> listado = l;
        if (bandera == true) {
            listado = new ArrayList<>();
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("Select * from producto where eliminado = false order by descripcion");

            while (res.next()) {

                Producto pro = new Producto();
                pro.setIdProducto(res.getInt(1));
                pro.setCodigo(res.getString(2));
                pro.setNombre(res.getString(3));
                pro.setpCosto(res.getDouble(4));
                pro.setpVenta(res.getDouble(5));
                pro.setpMayoreo(res.getDouble(6));
                pro.setInvMinimo(res.getInt(9));
                pro.setCantidad(res.getDouble(8));
                pro.setArea(res.getString(11));
                pro.setpDistribuidor(res.getDouble(7));
                pro.setIdSucursal(res.getString("idSucursal"));

                //    System.out.println("Codigo: " + pro.getCodigo() + " Nombre: " +pro.getNombre());
                listado.add(pro);

            }
        }

        return listado;
    }

    public ArrayList<Producto> obtenerProductosBusquedaParametrizada() throws ClassNotFoundException, SQLException {

        ArrayList<Producto> listado = null;
        String sql = "Select * from producto where eliminado = false order by descripcion";

        listado = new ArrayList<>();
        Statement s = conn.createStatement();
        ResultSet res = s.executeQuery(sql);

        while (res.next()) {

            Producto pro = new Producto();
            pro.setIdProducto(res.getInt(1));
            pro.setCodigo(res.getString(2));
            pro.setNombre(res.getString(3));
            pro.setpCosto(res.getDouble(4));
            pro.setpVenta(res.getDouble(5));
            pro.setpMayoreo(res.getDouble(6));
            pro.setInvMinimo(res.getInt(8));
            pro.setCantidad(res.getDouble(7));
            //    System.out.println("Codigo: " + pro.getCodigo() + " Nombre: " +pro.getNombre());

            listado.add(pro);

        }

        return listado;
    }

    public String getProductoPorTipoPrecio(String nombre, ArrayList<Producto> lista, int tipo) {

        Producto p = new Producto();
        String produ = "";
        int i = 0;
        //tipo = 1 por precioVenta
        //tipo = 2 por precioMayoreo

        while (lista.size() > i) {

            if (lista.get(i).getCodigo().equalsIgnoreCase(nombre)) {
                p = lista.get(i);
                if (tipo == 1) {

                    produ = p.getpVenta() + "";
                } else {

                    produ = p.getpMayoreo() + "";
                }
                break;
            }
            i++;
        }

        return produ;
    }

    public Producto getDatosProducto(String nombre, ArrayList<Producto> lista) {
        int i = 0;
        Producto p = new Producto();
        p.setNombre("");

        try {
            Statement s = conn.createStatement();

            ResultSet pro;
            pro = s.executeQuery("Select * from producto where codigo='" + nombre + "' or descripcion='" + nombre + "' and idSucursal= "+Datos.idSucursal);
            pro.next();
            p.setIdProducto(pro.getInt("idProducto"));
            p.setArea(pro.getString("area"));
            p.setCantidad(pro.getInt("cantidad"));
            p.setCodigo(pro.getString("codigo"));
            p.setIdSucursal(pro.getString("idSucursal"));
            p.setInvMinimo(pro.getInt("inventarioMinimo"));
            p.setNombre(pro.getString("descripcion"));
            p.setpCosto(pro.getDouble("precioCosto"));
            p.setpDistribuidor(pro.getDouble("precioDistribuidor"));
            p.setpMayoreo(pro.getDouble("precioMayoreo"));
            p.setpVenta(pro.getDouble("precioVenta"));
            return p;
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String[] getProductoPorNombre(String nombre, ArrayList<Producto> lista, int tipo, int tipoPrecio) {
        Producto p = new Producto();
        String produ[] = new String[7];
        int i = 0;
        //tipo = 1 por nombre
        //tipo = 2 por codigo
        if (tipo == 1) {
            while (lista.size() > i) {
                //System.out.println(lista.get(i).getNombre());
                if (lista.get(i).getNombre().trim().equalsIgnoreCase(nombre) || lista.get(i).getCodigo().trim().equalsIgnoreCase(nombre)) {
                    p = lista.get(i);
                    produ = buscarProductoPorCodigo(p.getCodigo(), tipoPrecio);

                    break;
                }
                i++;
            }

        } else {
            produ = buscarProductoPorCodigo(nombre, tipoPrecio);
        }

        return produ;
    }

    public String[] buscarProductoPorCodigo(String codigo, int tipoPrecio) {
        String[] res = new String[7];
        try {
            Statement s = conn.createStatement();

            ResultSet pro = s.executeQuery("Select * from producto where codigo='" + codigo + "'");
            pro.next();

            res[0] = pro.getString("codigo");
            res[1] = pro.getString("descripcion");
            res[3] = "1";
            res[5] = pro.getString("cantidad");
            res[6] = pro.getString("precioCosto");
            if (tipoPrecio == 1) {
                res[2] = pro.getString("precioVenta");
                res[4] = pro.getString("precioVenta");
            }
            if (tipoPrecio == 2) {
                res[2] = pro.getString("precioMayoreo");
                res[4] = pro.getString("precioMayoreo");
            }
            if (tipoPrecio == 3) {
                res[2] = pro.getString("precioDistribuidor");
                res[4] = pro.getString("precioDistribuidor");
            }

        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public String modificarDatosProducto(Producto p, Producto temporal, String estatus, String operacion) {

        try {

            Statement s = conn.createStatement();
            int modificar = s.executeUpdate("UPDATE producto SET `codigo`='" + p.getCodigo() + "' , `descripcion`='" + p.getNombre() + "', `precioDistribuidor`=" + p.getpDistribuidor()
                    + ",`precioCosto`=" + p.getpCosto() + ",`precioVenta`=" + p.getpVenta() + ",`precioMayoreo`=" + p.getpMayoreo() + ",`cantidad`=" + p.getCantidad() + ",`inventarioMinimo`=" + p.getInvMinimo() + ", `area`='" + p.getArea() + "', `estatus`='" + estatus + "', `operacion`='" + operacion + "'   WHERE codigo ='" + temporal.getCodigo() + "' and idSucursal = " + Datos.idSucursal + " and eliminado = false ");
        //    System.out.println("UPDATE producto SET `codigo`='" + p.getCodigo() + "' , `descripcion`='" + p.getNombre() + "', `precioDistribuidor`=" + p.getpDistribuidor()
          //          + ",`precioCosto`=" + p.getpCosto() + ",`precioVenta`=" + p.getpVenta() + ",`precioMayoreo`=" + p.getpMayoreo() + ",`cantidad`=" + p.getCantidad() + ",`inventarioMinimo`=" + p.getInvMinimo() + ", `area`='" + p.getArea() + "', `estatus`='" + estatus + "', `operacion`='" + operacion + "'   WHERE codigo ='" + temporal.getCodigo() + "' and idSucursal = " + Datos.idSucursal + " and eliminado = false ");
            String mensajeBita = "Modificó los datos del producto " + p.getNombre();
            bita.registrarBitacora(mensajeBita);
            return "Datos del producto modificados";
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            return "Hubo un problema con la conexion a la base de datos";

        } catch (ClassNotFoundException ex) {
      Utilidades.escribirLog(ex.getLocalizedMessage());
            System.out.println(ex.getLocalizedMessage());
            return "Hubo un problema vuelve a intentarlo por favor";
        }

    }

    public String eliminarProducto(Producto p, String estatus, String operacion) {
        try {
            Statement s = conn.createStatement();
            boolean modificar = s.execute("UPDATE producto SET `eliminado`= true, estatus='" + estatus + "', operacion='" + operacion + "' WHERE codigo ='" + p.getCodigo() + "' and idSucursal= " + Datos.idSucursal);
            String mensajeBita = "Eliminó los datos del producto " + p.getNombre();
            bita.registrarBitacora(mensajeBita);
            return "Datos del producto eliminados";
        } catch (SQLException e) {
                  Utilidades.escribirLog(e.getLocalizedMessage());
            return "Ocurrio un error en la conexion a la base de datos";
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            return "Ocurrio un error en el sistema";
        }
    }

    public String transferir(Producto transformar, Producto agregar, double ct, double ca, String estatus, String operacion) throws ClassNotFoundException, SQLException {

        try {

            Statement s = conn.createStatement();
            conn.setAutoCommit(false);
            double totalDisminuir = transformar.getCantidad() - ct;
            double totalAgregar = agregar.getCantidad() + ca;
            String disminuir = "UPDATE producto SET `cantidad`= " + totalDisminuir + ", estatus='" + estatus + "', operacion='" + operacion + "' WHERE codigo ='" + transformar.getCodigo() + "'";
            String sumar = "UPDATE producto SET `cantidad`= " + totalAgregar + ", estatus='" + estatus + "', operacion='" + operacion + "' WHERE codigo ='" + agregar.getCodigo() + "'";

            s.executeUpdate(sumar);
            s.executeUpdate(disminuir);
            conn.commit();

            String mensajeBita = "Se realizó una transferencia del producto " + transformar.getNombre() + "en varios del producto " + agregar.getNombre();
            bita.registrarBitacora(mensajeBita);
            return "Transacción realizada exitosamente";
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            if (conn != null) {

                try {
                    conn.rollback();
                    return "A ocurrido un error vuelve a intentarlo por favor";

                } catch (SQLException exs) {
                          Utilidades.escribirLog(ex.getLocalizedMessage());
                    return "Ocurrio un error con la conexion a la base de datos";
                }
            }
        }

        return "";

    }

    public String agregarInventarioProducto(double cantidad, String codigo, String agregar, String estatus, String operacion) {
        try {

            Statement s = conn.createStatement();
            boolean modificar = s.execute("UPDATE producto SET `cantidad`=" + cantidad + ", estatus='" + estatus + "', operacion='" + operacion + "' WHERE codigo ='" + codigo + "' and idSucursal =" + Datos.idSucursal);

            mov.setConn(conn);
            mov.registrarEfectivoInicial(agregar + "", "registro_producto", codigo, "Actualizada", "Modificacion");
            String mensajeBita = "Agregó inventario al producto con código " + codigo;
            bita.registrarBitacora(mensajeBita);
            return "Inventario agregado exitosamente";
        } catch (SQLException e) {
                  Utilidades.escribirLog(e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
            return ("Hubo un error con la conexion a la base de datos");
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            return ("Hubo un error con el sistema");
        }
    }

    public ResultSet productosBajoInventario() {
        try {

            Statement s = conn.createStatement();

            ResultSet datos = s.executeQuery("SELECT * FROM producto WHERE cantidad <= inventarioMinimo && eliminado = false and idSucursal= " + Datos.idSucursal);

            return datos;
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return null;
    }

    public ResultSet productosUtilidad() {
        try {

            Statement s = conn.createStatement();

            ResultSet datos = s.executeQuery("SELECT codigo,descripcion,cantidad,precioCosto,precioVenta,TRUNCATE ((precioVenta-precioCosto),2) as utilidad,"
                    + " (precioCosto*cantidad) as precioCostoTotal, (precioVenta*cantidad) as precioVentaTotal,TRUNCATE(((precioVenta*cantidad) - (precioCosto*cantidad)),2) as "
                    + "utilidadTotal  FROM producto where eliminado = false;");

            return datos;
        } catch (Exception e) {
      Utilidades.escribirLog(e.getLocalizedMessage());
        }

        return null;
    }
    
  

}
