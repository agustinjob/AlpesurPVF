/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo.response;

import java.util.List;
import punto.venta.modelo.Area;

/**
 *
 * @author agus_
 */
public class AreaResponse {
       private List<Area> areas;
    private String mensaje;
    private boolean realizado;  

    /**
     * @return the areas
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * @param areas the areas to set
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
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
