/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.reportes;

import punto.venta.cliente.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import punto.venta.dao.ClienteDAO;
import punto.venta.dao.VentasDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;
import static punto.venta.utilidades.Utilidades.confirma;

/**
 *
 * @author agus_
 */
public class ReporteGraficas extends javax.swing.JPanel implements ActionListener {

    GraficaBarras gBarras = new GraficaBarras();
    GraficaPastel gPastel = new GraficaPastel();
    
    public ReporteGraficas() {
        initComponents();
        ImageIcon guardar = new ImageIcon("iconos/check.png");
        graficaB.addActionListener(this);
        graficaP.addActionListener(this);
           contenedor.add(gBarras);
 
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        graficaB = new javax.swing.JButton();
        graficaP = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setText("Resumen de ventas de la semana actual");

        graficaB.setBackground(new java.awt.Color(102, 102, 255));
        graficaB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        graficaB.setForeground(new java.awt.Color(255, 255, 255));
        graficaB.setText("G. Barras");
        graficaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficaBActionPerformed(evt);
            }
        });

        graficaP.setBackground(new java.awt.Color(102, 102, 255));
        graficaP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        graficaP.setForeground(new java.awt.Color(255, 255, 255));
        graficaP.setText("G. Pastel");
        graficaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficaPActionPerformed(evt);
            }
        });

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(graficaB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(graficaP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(graficaB)
                        .addComponent(graficaP))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void graficaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficaBActionPerformed

    }//GEN-LAST:event_graficaBActionPerformed

    private void graficaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficaPActionPerformed
     

    }//GEN-LAST:event_graficaPActionPerformed
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton graficaB;
    private javax.swing.JButton graficaP;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
             Object evt = e.getSource();
       
     if(evt.equals(graficaB)){
            gBarras.setVisible(true);
            gPastel.setVisible(false);
            contenedor.add(gBarras);
     }
     else if(evt.equals(graficaP)){
            gBarras.setVisible(false);
            gPastel.setVisible(true);
            contenedor.add(gPastel);
     }

    }
}
