/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;
import punto.venta.modelo.Usuario;
import punto.venta.modelo.Ventas;

/**
 *
 * @author agus_
 */
public class VentasResponse {
      private List<Ventas> ventas;
    private String mensaje;
    private boolean realizado;

    /**
     * @return the ventas
     */
    public List<Ventas> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
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
