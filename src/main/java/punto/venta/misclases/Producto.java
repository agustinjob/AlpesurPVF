
package punto.venta.misclases;

import java.util.Vector;

/**
 *
 * @author Moises
 */
public class Producto {
    //Atributos Privados
    private int idProducto;
    private String codigo;
    private String nombre;
    private double pCosto;
    private double pVenta;
    private double pDistribuidor;
    private double pMayoreo;
    private int invMinimo;
    private double cantidad;
    private String area;
    private String idSucursal;

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
     * @return the pCosto
     */
    public double getpCosto() {
        return pCosto;
    }

    /**
     * @param pCosto the pCosto to set
     */
    public void setpCosto(double pCosto) {
        this.pCosto = pCosto;
    }

    /**
     * @return the pVenta
     */
    public double getpVenta() {
        return pVenta;
    }

    /**
     * @param pVenta the pVenta to set
     */
    public void setpVenta(double pVenta) {
        this.pVenta = pVenta;
    }

    /**
     * @return the pMayoreo
     */
    public double getpMayoreo() {
        return pMayoreo;
    }

    /**
     * @param pMayoreo the pMayoreo to set
     */
    public void setpMayoreo(double pMayoreo) {
        this.pMayoreo = pMayoreo;
    }

    /**
     * @return the invMinimo
     */
    public int getInvMinimo() {
        return invMinimo;
    }

    /**
     * @param invMinimo the invMinimo to set
     */
    public void setInvMinimo(int invMinimo) {
        this.invMinimo = invMinimo;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
 
    public boolean empiezaPor(String inicio) {
          inicio = inicio.toLowerCase();
          nombre = nombre.toLowerCase();
        if(inicio.isEmpty() || inicio.length()>nombre.length())
            return false;
        for(int i=0; i<inicio.length(); ++i)
            if( inicio.charAt(i) != nombre.charAt(i) )
                return false;
        return true;
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
     * @return the pDistribuidor
     */
    public double getpDistribuidor() {
        return pDistribuidor;
    }

    /**
     * @param pDistribuidor the pDistribuidor to set
     */
    public void setpDistribuidor(double pDistribuidor) {
        this.pDistribuidor = pDistribuidor;
    }

    /**
     * @return the idSucursal
     */
    public String getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal the idSucursal to set
     */
    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
   
    
}
