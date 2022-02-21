/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.reportes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import punto.venta.dao.Conexion;
import punto.venta.dao.VentasDAO;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class GraficaBarras extends javax.swing.JPanel {
    JFreeChart grafica;
    JFreeChart graficaDeBarras;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
    VentasDAO ventas = new VentasDAO();
    
    public GraficaBarras() {
        initComponents();
        graficaDeBarras = ChartFactory.createBarChart("Resumen de ventas", "Días", "Ventas", datos);
       
        llenarDatosGraficaDeBarras();
    }

   public void llenarDatosGraficaDeBarras() {

        ResultSet res = ventas.getGananciasGraficaDeBarras();
        try {
            res.last();
            if (res.getRow() == 0) {
                datos.addValue(1, "No hay datos", "No hubo ventas en estas fechas");
            } else {
                res.beforeFirst();
                int i = 1;
                while (res.next()) {
                    datos.addValue(res.getDouble("ventas"), "Ventas", res.getString("DIA_SEMANA"));
                    datos.addValue(res.getDouble("ganancia"), "Ganancia", res.getString("DIA_SEMANA"));
                }
                ChartPanel panel2 = new ChartPanel(graficaDeBarras);
                jPanel14.setLayout(new java.awt.BorderLayout());
                jPanel14.add(panel2);
                jPanel14.validate();
            }
        } catch (SQLException ex) {
               
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll1 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2076, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        scroll1.setViewportView(jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1296, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane scroll1;
    // End of variables declaration//GEN-END:variables
}
