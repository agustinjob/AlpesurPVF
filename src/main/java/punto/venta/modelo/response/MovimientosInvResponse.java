/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;
import punto.venta.modelo.MovimientosInv;

/**
 *
 * @author agus_
 */
public class MovimientosInvResponse {
    private List<MovimientosInv> lista;
    private String mensaje;
    private Boolean realizado;

    /**
     * @return the movimientos
     */
    public List<MovimientosInv> getMovimientos() {
        return lista;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<MovimientosInv> lista) {
        this.lista = lista;
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
    public Boolean getRealizado() {
        return realizado;
    }

    /**
     * @param realizado the realizado to set
     */
    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
}
