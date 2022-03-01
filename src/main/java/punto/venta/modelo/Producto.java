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
public class Producto {
    private Integer idProducto;
    private Integer idSucursal= Datos.idSucursal;
    private String codigo;
    private String descripcion;
    private float precioCosto;
    private float precioVenta;
    private float precioMayoreo;
    private float precioDistribuidor;
    private float cantidad;
    private int inventarioMinimo;
    private boolean eliminado;
    private String area;
    private String propietario=Datos.propietario;
    private Integer idUSuario= UsuarioDAO.getIdUsuario();

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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
     * @return the precioMayoreo
     */
    public float getPrecioMayoreo() {
        return precioMayoreo;
    }

    /**
     * @param precioMayoreo the precioMayoreo to set
     */
    public void setPrecioMayoreo(float precioMayoreo) {
        this.precioMayoreo = precioMayoreo;
    }

    /**
     * @return the precioDistribuidor
     */
    public float getPrecioDistribuidor() {
        return precioDistribuidor;
    }

    /**
     * @param precioDistribuidor the precioDistribuidor to set
     */
    public void setPrecioDistribuidor(float precioDistribuidor) {
        this.precioDistribuidor = precioDistribuidor;
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
     * @return the inventarioMinimo
     */
    public int getInventarioMinimo() {
        return inventarioMinimo;
    }

    /**
     * @param inventarioMinimo the inventarioMinimo to set
     */
    public void setInventarioMinimo(int inventarioMinimo) {
        this.inventarioMinimo = inventarioMinimo;
    }

    /**
     * @return the eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
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
    
    @Override
    public String toString(){
    return getDescripcion();
    }

}
