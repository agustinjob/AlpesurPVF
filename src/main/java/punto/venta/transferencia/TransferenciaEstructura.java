/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.transferencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author agus_
 */
public class TransferenciaEstructura extends javax.swing.JPanel implements ActionListener {

  
    Paso1 paso1 = new Paso1();
    Paso2 paso2 = new Paso2();
 
    static TransferenciaEstructura transferencia;
    
    public TransferenciaEstructura() {
        initComponents();
    /*    btnPaso1.addActionListener(this);
        btnPaso2.addActionListener(this);
        btnPaso3.addActionListener(this);*/
    
         contenedor.add(paso1);
         transferencia= this;
        //ImageIcon guardar = new ImageIcon("iconos/agregar.png");
        //  btnNuevo.setIcon(guardar);
        
    }

    public void requerirFoco(){
     //  txtCodigo.setFocusable(true);
     //  txtCodigo.requestFocus();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelTicket.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSFERENCIA SUCURSALES");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(825, Short.MAX_VALUE))
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout());

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 492, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(46, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
         Object evt = e.getSource();
       
 /*    if(evt.equals(btnPaso1)){
         paso1.setVisible(true);
         paso2.setVisible(false);
         paso3.setVisible(false);
         contenedor.add(paso1);
         paso1.requerirFoco();
     }else if(evt.equals(btnPaso2)){
         paso1.setVisible(false);
         paso2.setVisible(true);
         paso3.setVisible(false);
         contenedor.add(paso2);
         paso2.requerirFoco();
     }else if(evt.equals(btnPaso3)){
         paso1.setVisible(false);
         paso2.setVisible(false);
         paso3.setVisible(true);
         contenedor.add(paso3);
         paso3.requerirFoco();
     }*/
    }
    public void setPaso1(Paso1 paso1){
    this.paso1=paso1;
    }
    public Paso1 getPaso1(){
    return this.paso1;
    }
      public void setPaso2(Paso2 paso2){
    this.paso2=paso2;
    }
    public Paso2 getPaso2(){
    return this.paso2;
    }
  
    
   public JPanel getContenedor(){
   return contenedor;
   }
   
   
}
