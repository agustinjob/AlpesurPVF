/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;
import punto.venta.modelo.Producto;


/**
 *
 * @author agus_
 */
public class ProductoResponse {
   private List<Producto> productos;
    private String mensaje;
    private boolean realizado;   

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the realizado
     */
    public boolean isRealizado() {
        return realizado;
    }

    /**
     * @param realizado the realizado to set
     */
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}
