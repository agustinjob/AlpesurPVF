/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;
import punto.venta.modelo.Producto;
import punto.venta.modelo.Sucursal;

/**
 *
 * @author agus_
 */
public class TransferenciaProductos {
    
   private int idSucursalLocal= Datos.idSucursal;
   private String sucursalLocal=Datos.sucursal;
   private int idSucursalRecibe;
   private String sucursalRecibe;
   private List<Producto> lista;
   private String propietarioLocal=Datos.propietario;
   private String propietarioRecibe=Datos.propietario;
   private Integer idUsuario=UsuarioDAO.idUsuario;

    /**
     * @return the idSucursalLocal
     */
    public int getIdSucursalLocal() {
        return idSucursalLocal;
    }

    /**
     * @param idSucursalLocal the idSucursalLocal to set
     */
    public void setIdSucursalLocal(int idSucursalLocal) {
        this.idSucursalLocal = idSucursalLocal;
    }

    /**
     * @return the sucursalLocal
     */
    public String getSucursalLocal() {
        return sucursalLocal;
    }

    /**
     * @param sucursalLocal the sucursalLocal to set
     */
    public void setSucursalLocal(String sucursalLocal) {
        this.sucursalLocal = sucursalLocal;
    }

    /**
     * @return the idSucursalRecibe
     */
    public int getIdSucursalRecibe() {
        return idSucursalRecibe;
    }

    /**
     * @param idSucursalRecibe the idSucursalRecibe to set
     */
    public void setIdSucursalRecibe(int idSucursalRecibe) {
        this.idSucursalRecibe = idSucursalRecibe;
    }

    /**
     * @return the sucursalRecibe
     */
    public String getSucursalRecibe() {
        return sucursalRecibe;
    }

    /**
     * @param sucursalRecibe the sucursalRecibe to set
     */
    public void setSucursalRecibe(String sucursalRecibe) {
        this.sucursalRecibe = sucursalRecibe;
    }

    /**
     * @return the lista
     */
    public List<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    /**
     * @return the propietarioLocal
     */
    public String getPropietarioLocal() {
        return propietarioLocal;
    }

    /**
     * @param propietarioLocal the propietarioLocal to set
     */
    public void setPropietarioLocal(String propietarioLocal) {
        this.propietarioLocal = propietarioLocal;
    }

    /**
     * @return the propietarioRecibe
     */
    public String getPropietarioRecibe() {
        return propietarioRecibe;
    }

    /**
     * @param propietarioRecibe the propietarioRecibe to set
     */
    public void setPropietarioRecibe(String propietarioRecibe) {
        this.propietarioRecibe = propietarioRecibe;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

   
}
