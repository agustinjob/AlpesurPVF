/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

import java.util.Date;

/**
 *
 * @author agus_
 */

public class Ticket {
    private Integer idTicket;
    private Integer idSucursal;
    private Integer serial;
    private Date actualizada;

    /**
     * @return the idTicket
     */
    public Integer getIdTicket() {
        return idTicket;
    }

    /**
     * @param idTicket the idTicket to set
     */
    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
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
     * @return the serial
     */
    public Integer getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    /**
     * @return the actualizada
     */
    public Date getActualizada() {
        return actualizada;
    }

    /**
     * @param actualizada the actualizada to set
     */
    public void setActualizada(Date actualizada) {
        this.actualizada = actualizada;
    }
}
