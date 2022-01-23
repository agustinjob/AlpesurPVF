/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import punto.venta.cliente.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author agus_
 */
public class CorteAmbosEstructura extends javax.swing.JPanel implements ActionListener {

    private CorteEstructura corteDia = new CorteEstructura();
    private CorteSemanal corteSemana = new CorteSemanal();

    
    public CorteAmbosEstructura() {
        initComponents();
        
       btnCorteDia.addActionListener(this);
       btnCorteSemanal.setVisible(false);
       btnCorteSemanal.addActionListener(this);
       contenedor.add(corteDia);
       configurarIconos();
       
    }

    public void configurarIconos(){
     ImageIcon icoNue = new ImageIcon("iconos/cliente_nuevo.png");
     ImageIcon icoMod = new ImageIcon("iconos/modificar_cliente.png");
     ImageIcon icoEli = new ImageIcon("iconos/eliminar_cliente.png");
     ImageIcon icoEsta = new ImageIcon("iconos/documentos.png");
     btnCorteDia.setIcon(icoNue);
     btnCorteSemanal.setIcon(icoMod);
   
    }
    
 
    
 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnCorteDia = new javax.swing.JButton();
        btnCorteSemanal = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnCorteDia.setBackground(new java.awt.Color(153, 153, 255));
        btnCorteDia.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorteDia.setForeground(new java.awt.Color(255, 255, 255));
        btnCorteDia.setText("Corte del día");
        btnCorteDia.setBorder(null);
        btnCorteDia.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnCorteDia);

        btnCorteSemanal.setBackground(new java.awt.Color(153, 153, 255));
        btnCorteSemanal.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorteSemanal.setForeground(new java.awt.Color(255, 255, 255));
        btnCorteSemanal.setText("Corte Semanal");
        btnCorteSemanal.setBorder(null);
        btnCorteSemanal.setPreferredSize(new java.awt.Dimension(180, 35));
        btnCorteSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteSemanalActionPerformed(evt);
            }
        });
        panelBotones.add(btnCorteSemanal);

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        panelTicket.setBackground(new java.awt.Color(204, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CORTE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 749, Short.MAX_VALUE))
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorteSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteSemanalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCorteSemanalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorteDia;
    private javax.swing.JButton btnCorteSemanal;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
      Object evt = e.getSource();
       
     if(evt.equals(btnCorteDia)){
            corteDia.setVisible(true);
            corteSemana.setVisible(false);
          
      contenedor.add(corteDia);
     }
     else if(evt.equals(btnCorteSemanal)){
         corteDia.setVisible(false);
         corteSemana.setVisible(true);
         contenedor.add(corteSemana);
    
     }
     
    }

   
    
}
