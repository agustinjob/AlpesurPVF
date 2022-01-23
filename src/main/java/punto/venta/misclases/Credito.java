/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.util.Date;

/**
 *
 * @author agus_
 */
public class Credito {
    private int idCredito;
    private int idCliente;
    private int idTicket;
    private String fecha;
    private double monto;
    private double abonado;
    private String fechaAbono;

    /**
     * @return the idCredito
     */
    public int getIdCredito() {
        return idCredito;
    }

    /**
     * @param idCredito the idCredito to set
     */
    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
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
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the abonado
     */
    public double getAbonado() {
        return abonado;
    }

    /**
     * @param abonado the abonado to set
     */
    public void setAbonado(double abonado) {
        this.abonado = abonado;
    }

    /**
     * @return the finalizado
     */
    public String getFechaAbono() {
        return fechaAbono;
    }

    /**
     * @param finalizado the finalizado to set
     */
    public void setFechaAbono(String fechaAbono) {
        this.fechaAbono = fechaAbono;
    }
    
}
