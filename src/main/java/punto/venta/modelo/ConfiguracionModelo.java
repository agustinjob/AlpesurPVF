/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.modelo;

/**
 *
 * @author agus_
 */
public class ConfiguracionModelo {

    /**
     * @return the idConfiguracion
     */
    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    /**
     * @param idConfiguracion the idConfiguracion to set
     */
    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    /**
     * @return the impresora
     */
    public String getImpresora() {
        return impresora;
    }

    /**
     * @param impresora the impresora to set
     */
    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    /**
     * @return the nombreLocal
     */
    public String getNombreLocal() {
        return nombreLocal;
    }

    /**
     * @param nombreLocal the nombreLocal to set
     */
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the idSucursal
     */
    public Integer getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal the idSucursal to set
     */
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    private Integer idConfiguracion;
    private String impresora;
    private String nombreLocal;
    private String rfc;
    private String direccion;
    private Integer idSucursal;
}
