/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;

/**
 *
 * @author agus_
 */
public class Devolucion {
    private Integer idTicket;
    private String fecha;
    private String codigo;
    private float cantidadDevuelta;
    private Integer idSucursal=Datos.idSucursal;
    private float montoDevuelto;
    private Integer tipo;
    private Integer idUsuario=UsuarioDAO.getIdUsuario();
    private String propietario=Datos.propietario;

    /**
     * @return the idTicket
     */
    public Integer getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidadDevuelta
     */
    public float getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    /**
     * @param cantidadDevuelta the cantidadDevuelta to set
     */
    public void setCantidadDevuelta(float cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
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

    /**
     * @return the montoDevuelto
     */
    public float getMontoDevuelto() {
        return montoDevuelto;
    }

    /**
     * @param montoDevuelto the montoDevuelto to set
     */
    public void setMontoDevuelto(float montoDevuelto) {
        this.montoDevuelto = montoDevuelto;
    }

    /**
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
