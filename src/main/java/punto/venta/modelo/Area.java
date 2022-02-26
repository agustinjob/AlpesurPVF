/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto.venta.modelo;

/**
 *
 * @author agus_
 */
public class Area {
     private Integer idArea;
    private Integer idSucursal;
    private String nombre;
    private String estatusArea;
    private String propietario;

    /**
     * @return the idArea
     */
    public Integer getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estatusArea
     */
    public String getEstatusArea() {
        return estatusArea;
    }

    /**
     * @param estatusArea the estatusArea to set
     */
    public void setEstatusArea(String estatusArea) {
        this.estatusArea = estatusArea;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    @Override
    public String toString(){
    return getNombre();
    }
}
