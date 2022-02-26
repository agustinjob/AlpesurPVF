/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

import java.sql.Time;
import java.util.Date;
import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;

/**
 *
 * @author agus_
 */
public class Ventas {
private Integer idVenta;
private Integer idSucursal=Datos.idSucursal;
private int     idTicket;
private String  nombre;
private String  codigo;
private float   precioVenta;
private float   precioCosto;
private float   cantidad;
private float   importe;
private Date    fecha;
private int     idUsuario=UsuarioDAO.getIdUsuario();
private int     idCliente;
private String  mayoreo="NO";
private boolean revisada=false;
private boolean devolucion=false;
private boolean devocompleta=false;
private String  tipoCompra="Efectivo";
private boolean finalizada=true;
private String  propietario=Datos.propietario;

    /**
     * @return the idVenta
     */
    public Integer getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
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
     * @return the idTicket
     */
    public int getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the precioCosto
     */
    public float getPrecioCosto() {
        return precioCosto;
    }

    /**
     * @param precioCosto the precioCosto to set
     */
    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    /**
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
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
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the mayoreo
     */
    public String getMayoreo() {
        return mayoreo;
    }

    /**
     * @param mayoreo the mayoreo to set
     */
    public void setMayoreo(String mayoreo) {
        this.mayoreo = mayoreo;
    }

    /**
     * @return the revisada
     */
    public boolean isRevisada() {
        return revisada;
    }

    /**
     * @param revisada the revisada to set
     */
    public void setRevisada(boolean revisada) {
        this.revisada = revisada;
    }

    /**
     * @return the devolucion
     */
    public boolean isDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    /**
     * @return the devocompleta
     */
    public boolean isDevocompleta() {
        return devocompleta;
    }

    /**
     * @param devocompleta the devocompleta to set
     */
    public void setDevocompleta(boolean devocompleta) {
        this.devocompleta = devocompleta;
    }

    /**
     * @return the tipoCompra
     */
    public String getTipoCompra() {
        return tipoCompra;
    }

    /**
     * @param tipoCompra the tipoCompra to set
     */
    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    /**
     * @return the finalizada
     */
    public boolean isFinalizada() {
        return finalizada;
    }

    /**
     * @param finalizada the finalizada to set
     */
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
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
