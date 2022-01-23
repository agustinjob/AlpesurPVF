/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agus_
 */
public class TransferenciaProductos {
    
   private int idSucursalEnvio;
   private String sucursalEnvio;
   private DefaultTableModel md;

    /**
     * @return the idSucursalEnvio
     */
    public int getIdSucursalEnvio() {
        return idSucursalEnvio;
    }

    /**
     * @param idSucursalEnvio the idSucursalEnvio to set
     */
    public void setIdSucursalEnvio(int idSucursalEnvio) {
        this.idSucursalEnvio = idSucursalEnvio;
    }

    /**
     * @return the sucursalEnvio
     */
    public String getSucursalEnvio() {
        return sucursalEnvio;
    }

    /**
     * @param sucursalEnvio the sucursalEnvio to set
     */
    public void setSucursalEnvio(String sucursalEnvio) {
        this.sucursalEnvio = sucursalEnvio;
    }

    /**
     * @return the md
     */
    public DefaultTableModel getMd() {
        return md;
    }

    /**
     * @param md the md to set
     */
    public void setMd(DefaultTableModel md) {
        this.md = md;
    }
}
