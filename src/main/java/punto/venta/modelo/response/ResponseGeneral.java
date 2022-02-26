/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;

/**
 *
 * @author agus_
 */
public class ResponseGeneral {
    private List<Object> datos;
    private String mensaje;
    private boolean realizado;

    /**
     * @return the datos
     */
    public List<Object> getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(List<Object> datos) {
        this.datos = datos;
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
