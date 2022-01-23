/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.sql.Connection;

/**
 *
 * @author agus_
 */
public class ConexionModel {

     private Connection local;
     private Connection host;
    private boolean internet;
    private String fecha;
    private String hora;

    /**
     * @return the local
     */
    public Connection getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(Connection local) {
        this.local = local;
    }

    /**
     * @return the host
     */
    public Connection getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(Connection host) {
        this.host = host;
    }

    /**
     * @return the internet
     */
    public boolean isInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
       
   
    
}
