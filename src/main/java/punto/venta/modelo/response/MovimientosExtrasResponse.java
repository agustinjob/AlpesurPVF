/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;
import punto.venta.modelo.MovimientosExtras;

/**
 *
 * @author agus_
 */
public class MovimientosExtrasResponse {
    private List<MovimientosExtras> movimientos;
    private String mensaje;
    private boolean realizado;   

    /**
     * @return the movimientos
     */
    public List<MovimientosExtras> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<MovimientosExtras> movimientos) {
        this.movimientos = movimientos;
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
