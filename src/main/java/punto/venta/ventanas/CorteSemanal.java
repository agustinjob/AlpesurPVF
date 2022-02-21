/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import punto.venta.dao.CorteDAO;
import punto.venta.dao.Movimientos;
import punto.venta.dao.UsuarioDAO;
import punto.venta.dao.VentasDAO;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class CorteSemanal extends javax.swing.JPanel {

DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
VentasDAO ven = new VentasDAO();
Movimientos mov = new Movimientos();
NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
double finalTotal;

    public CorteSemanal() {
        initComponents();
      centrarTabla();
    }

  public void llenaTabla(){
     
     String vec[] = new String[2];
     ResultSet res = ven.getDatosReporteVentasPorSemana();
     Double tem = 0.0D;
     Double tem2 = 0.0D;
     Double totalCosto = 0.0D;
     Double totalVentas = 0.0D;
     Double totalNumeroVentas = 0.0D;
     DefaultTableModel modelo = (DefaultTableModel) tablaVentas2.getModel();
     limpiarTabla(tablaVentas2);
    try {
        res.last();
        if(res.getRow()==0){
    
        }else{
        res.beforeFirst();
          
        while(res.next()){
        
        tem = Double.parseDouble(res.getString("ventas"));
        tem2 = Double.parseDouble(res.getString("costo"));
         totalNumeroVentas = totalNumeroVentas + Double.parseDouble(res.getString("numeroVentas"));
        totalCosto =totalCosto + tem2;
        totalVentas = totalVentas + tem;
        vec[0]=res.getString("DIA_SEMANA");
        vec[1] =formatoImporte.format(tem);
        modelo.addRow(vec);
        }
        vec[0]="Total";
        vec[1]=formatoImporte.format(totalVentas);
        finalTotal = finalTotal + totalVentas;
        modelo.addRow(vec);
        
   //     txtVentasTotales.setText(formatoImporte.format(totalVentas));
    //    Double ganancia = totalVentas - totalCosto;
     //   txtGanancia.setText(formatoImporte.format(ganancia));
    //    txtNumeroVentas.setText(formatoImporte.format(totalNumeroVentas));
        }
    } catch (SQLException ex) {
             
    }
             
     }
    public void centrarTabla(){
       dt.setHorizontalAlignment(SwingConstants.CENTER);
       // tablaDinero.getColumnModel().getColumn(0).setCellRenderer(dt);
    
        
        
      
    }
    
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        Panelcor = new javax.swing.JPanel();
        panelEnsa = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaVentas2 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaEntradas2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaSalidas2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtDevoluciones = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btnCorte = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1401, 540));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1365, 450));

        Panelcor.setBackground(new java.awt.Color(255, 255, 255));

        panelEnsa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelEnsaLayout = new javax.swing.GroupLayout(panelEnsa);
        panelEnsa.setLayout(panelEnsaLayout);
        panelEnsaLayout.setHorizontalGroup(
            panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );
        panelEnsaLayout.setVerticalGroup(
            panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        tablaVentas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día", "Monto"
            }
        ));
        jScrollPane7.setViewportView(tablaVentas2);

        tablaEntradas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Monto"
            }
        ));
        jScrollPane8.setViewportView(tablaEntradas2);

        tablaSalidas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Monto"
            }
        ));
        jScrollPane9.setViewportView(tablaSalidas2);

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel11.setText("Ventas semanales");

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel12.setText("Entradas extras");

        jLabel13.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel13.setText("Salidas extras");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel15.setText("Descripción:");

        jLabel16.setText("Monto:");

        jButton6.setText("Registrar salidas extras");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Registrar entradas extras");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtDevoluciones.setText("Devoluciones:");

        txtTotal.setText("TOTAL:");

        javax.swing.GroupLayout PanelcorLayout = new javax.swing.GroupLayout(Panelcor);
        Panelcor.setLayout(PanelcorLayout);
        PanelcorLayout.setHorizontalGroup(
            PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelcorLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(46, 46, 46)
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(38, 38, 38)
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)))
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal)
                            .addComponent(txtDevoluciones))))
                .addGap(75, 75, 75)
                .addComponent(panelEnsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(698, Short.MAX_VALUE))
        );
        PanelcorLayout.setVerticalGroup(
            PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelcorLayout.createSequentialGroup()
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEnsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelcorLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(txtDevoluciones)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal))
                            .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(493, Short.MAX_VALUE))
        );

        btnCorte.setBackground(new java.awt.Color(102, 102, 255));
        btnCorte.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorte.setText("Hacer corte semanal");
        btnCorte.setBorder(null);
        btnCorte.setPreferredSize(new java.awt.Dimension(200, 35));
        btnCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteActionPerformed(evt);
            }
        });
        btnCorte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCorteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panelcor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panelcor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteActionPerformed
finalTotal = 0;  
    llenaTabla();   
    llenarTabla(1);
    llenarTabla(2);
    
    double devo = ven.getDevolucionPorSemana();
    txtDevoluciones.setText("Devoluciones: "+ formatoImporte.format(devo));
    finalTotal = finalTotal - devo;
    txtTotal.setText("Total: "+ formatoImporte.format(finalTotal));
    }//GEN-LAST:event_btnCorteActionPerformed

    private void btnCorteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCorteKeyPressed
   
    }//GEN-LAST:event_btnCorteKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            //Salidas
            String des =  txtDescripcion.getText();
            String monto = txtMonto.getText();
            double tem= Double.parseDouble(monto);
            mov.registrarEfectivoInicial(monto, "entrada_extra", des, "Actualizada","Registro");
            JOptionPane.showMessageDialog(null, "entrada extra registrada con exito");
            txtDescripcion.setText("");
            txtMonto.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CorteSemanal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CorteSemanal.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Por favor, revisa la información que agregaste");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            //Salidas
            String des =  txtDescripcion.getText();
            String monto = txtMonto.getText();
            mov.registrarEfectivoInicial(monto, "salida_extra", des, "Actualizada","Registro");
            JOptionPane.showMessageDialog(null, "Salida extra registrada con exito");
            txtDescripcion.setText("");
            txtMonto.setText("");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CorteSemanal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CorteSemanal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // txtEntrada.getText();
        // mov.registrarEfectivoInicial(monto, tipo, descripcion);
    }//GEN-LAST:event_txtDescripcionActionPerformed
   
   public void llenarTabla(int tipo){
    DefaultTableModel modelo = null;
    String tipoLLamada = "";
    double total = 0.0;
   if(tipo==1){
   modelo = (DefaultTableModel) tablaEntradas2.getModel();
   limpiarTabla(tablaEntradas2);
   tipoLLamada = "entrada_extra";
   }else{
    modelo = (DefaultTableModel) tablaSalidas2.getModel();
    limpiarTabla(tablaSalidas2);
    tipoLLamada = "salida_extra";
    }
try{
   
    ResultSet rs = mov.getEntradasDelDiaPorSemana(tipoLLamada);
    String [] x = new String[2];
 
    if(rs == null){
    System.out.println("Esta vacio");
    }else{
        
    while(rs.next()){
        
    x[0] = rs.getString(3);
    x[1] = formatoImporte.format(Double.parseDouble(rs.getString(4)));
    total = total + Double.parseDouble(rs.getString(4));
    modelo.addRow(x);
        
    }
    x[0]="Total";
    x[1]=formatoImporte.format(total);
    modelo.addRow(x);
    if(tipo==1){
        finalTotal = finalTotal + total;
    tablaEntradas2.setModel(modelo);
    }else{
        finalTotal = finalTotal - total;
    tablaSalidas2.setModel(modelo);
    }
    
    }
}catch(Exception e){

}
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelcor;
    private javax.swing.JButton btnCorte;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel panelEnsa;
    private javax.swing.JTable tablaEntradas2;
    private javax.swing.JTable tablaSalidas2;
    private javax.swing.JTable tablaVentas2;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JLabel txtDevoluciones;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
