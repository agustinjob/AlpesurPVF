/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.reportes;

import punto.venta.cliente.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author agus_
 */
public class ReporteEstructura extends javax.swing.JPanel implements ActionListener {

    private ReporteVentas cVentas = new ReporteVentas();
    private ReporteProducto cProducto = new ReporteProducto();
    private ReporteGraficas cGraficas = new ReporteGraficas();
     
    public ReporteEstructura() {
        initComponents();
        
       btnVentas.addActionListener(this);
       btnProductos.addActionListener(this);
       btnGraficas.addActionListener(this);
       contenedor.add(cGraficas);
       configurarIconos();
       
    }

    public void configurarIconos(){
     ImageIcon icoNue = new ImageIcon("iconos/cliente_nuevo.png");
     ImageIcon icoMod = new ImageIcon("iconos/modificar_cliente.png");
     ImageIcon icoEli = new ImageIcon("iconos/eliminar_cliente.png");
     ImageIcon icoEsta = new ImageIcon("iconos/documentos.png");
     btnVentas.setIcon(icoNue);
     btnProductos.setIcon(icoMod);
     btnGraficas.setIcon(icoEli);
    }
    

 
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnVentas = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnGraficas = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnVentas.setBackground(new java.awt.Color(0, 153, 153));
        btnVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnVentas.setText("Reporte de ventas");
        btnVentas.setBorder(null);
        btnVentas.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnVentas);

        btnProductos.setBackground(new java.awt.Color(0, 153, 153));
        btnProductos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnProductos.setText("Reporte por producto");
        btnProductos.setBorder(null);
        btnProductos.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnProductos);

        btnGraficas.setBackground(new java.awt.Color(0, 153, 153));
        btnGraficas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGraficas.setText("Gráficas");
        btnGraficas.setBorder(null);
        btnGraficas.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnGraficas);

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        panelTicket.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTES");
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
                .addGap(0, 569, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
      Object evt = e.getSource();
       
     if(evt.equals(btnVentas)){
            cVentas.setVisible(true);
            cProducto.setVisible(false);
            cGraficas.setVisible(false);
            contenedor.add(cVentas);
     }
     else if(evt.equals(btnProductos)){
            cVentas.setVisible(false);
            cProducto.setVisible(true);
            cGraficas.setVisible(false);
            contenedor.add(cProducto);
     }
     else if(evt.equals(btnGraficas)){
             cVentas.setVisible(false);
            cProducto.setVisible(false);
            cGraficas.setVisible(true);
            contenedor.add(cGraficas);
      
     }
    }

    /**
     * @return the cAgregar
     */
  


  
    
    
}
