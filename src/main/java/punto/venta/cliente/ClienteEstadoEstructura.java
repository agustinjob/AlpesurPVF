/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.cliente;

import punto.venta.misclases.Cliente;

/**
 *
 * @author agus_
 */
public class ClienteEstadoEstructura extends javax.swing.JPanel {

    ClienteEstadoBuscar cEB = new ClienteEstadoBuscar(this);
    ClienteEstadoInformacion cEI = new ClienteEstadoInformacion();

    public ClienteEstadoEstructura() {
        initComponents();
        cEB.setVisible(true);
        add(cEB);

    }

    public void mostrarEstado(Cliente c) {
        cEB.setVisible(false);
        cEI.llenarDatos(c);
        cEI.setVisible(true);
        
        add(cEI);
    }
    public void ocultarEstado() {
        cEB.setVisible(true);
        cEB.llenarCombo();
        cEI.setVisible(false);
        
        add(cEB);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
