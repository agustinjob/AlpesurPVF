/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

import java.util.Date;
import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;

/**
 *
 * @author agus_
 */
public class MovimientosExtras {
    private Integer idMovimiento;
    private String tipo;
    private String descripcion;
    private float monto;
    private Date fecha;
    private boolean revisado;
    private Integer idUsuario=UsuarioDAO.getIdUsuario();
    private Integer idSucursal= Datos.idSucursal;
    private String propietario= Datos.propietario;    

    /**
     * @return the idMovimiento
     */
    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    /**
     * @param idMovimiento the idMovimiento to set
     */
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the revisado
     */
    public boolean isRevisado() {
        return revisado;
    }

    /**
     * @param revisado the revisado to set
     */
    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
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
