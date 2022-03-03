/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

import java.util.List;

/**
 *
 * @author agus_
 */
public class CorteModelo {

 private String dineroCaja;
   private String ventas;
   private String ventasACredito;
   private String costo;
   private String entradas;
   private String salidas;
   private String abonos;
   private String devoluciones;
    private List<MovimientosExtras> entradasLista;
    private List<MovimientosExtras> salidasLista;

  

    /**
     * @return the ventas
     */
    public String getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the entradas
     */
    public String getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    /**
     * @return the salidas
     */
    public String getSalidas() {
        return salidas;
    }

    /**
     * @param salidas the salidas to set
     */
    public void setSalidas(String salidas) {
        this.salidas = salidas;
    }

    /**
     * @return the abonos
     */
    public String getAbonos() {
        return abonos;
    }

    /**
     * @param abonos the abonos to set
     */
    public void setAbonos(String abonos) {
        this.abonos = abonos;
    }

    /**
     * @return the devoluciones
     */
    public String getDevoluciones() {
        return devoluciones;
    }

    /**
     * @param devoluciones the devoluciones to set
     */
    public void setDevoluciones(String devoluciones) {
        this.devoluciones = devoluciones;
    }

    /**
     * @return the entradasLista
     */
    public List<MovimientosExtras> getEntradasLista() {
        return entradasLista;
    }

    /**
     * @param entradasLista the entradasLista to set
     */
    public void setEntradasLista(List<MovimientosExtras> entradasLista) {
        this.entradasLista = entradasLista;
    }

    /**
     * @return the salidasLista
     */
    public List<MovimientosExtras> getSalidasLista() {
        return salidasLista;
    }

    /**
     * @param salidasLista the salidasLista to set
     */
    public void setSalidasLista(List<MovimientosExtras> salidasLista) {
        this.salidasLista = salidasLista;
    }

    /**
     * @return the dineroCaja
     */
    public String getDineroCaja() {
        return dineroCaja;
    }

    /**
     * @param dineroCaja the dineroCaja to set
     */
    public void setDineroCaja(String dineroCaja) {
        this.dineroCaja = dineroCaja;
    }

    /**
     * @return the ventasACredito
     */
    public String getVentasACredito() {
        return ventasACredito;
    }

    /**
     * @param ventasACredito the ventasACredito to set
     */
    public void setVentasACredito(String ventasACredito) {
        this.ventasACredito = ventasACredito;
    }

    /**
     * @return the costo
     */
    public String getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

}
