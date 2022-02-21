/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.reportes;

import java.awt.Dimension;
import punto.venta.cliente.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import punto.venta.dao.ClienteDAO;
import punto.venta.dao.Conexion;
import punto.venta.dao.VentasDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.utilidades.Utilidades;
import static punto.venta.utilidades.Utilidades.confirma;

/**
 *
 * @author agus_
 */
public class ReporteVentas extends javax.swing.JPanel {

    Confirmacion confirma= new Confirmacion();
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    VentasDAO ven = new VentasDAO();
    NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();

    public ReporteVentas() {
        initComponents();
          tablaVentas.getTableHeader().setPreferredSize(new Dimension(0,0));
        llenaTabla();
        centrarTabla();
      
 
    }

       public void centrarTabla(){
       dt.setHorizontalAlignment(SwingConstants.CENTER);
       // tablaDinero.getColumnModel().getColumn(0).setCellRenderer(dt);
        tablaVentas.getColumnModel().getColumn(1).setCellRenderer(dt);
        tablaVentas.setRowHeight(30);
       // tablaEntradas.getColumnModel().getColumn(1).setMaxWidth(60);
       // tablaEntradas.setRowHeight(30);
        //  tablaSalidas.getColumnModel().getColumn(1).setMaxWidth(60);
       // tablaSalidas.setRowHeight(30);
         ImageIcon iconoCap = new ImageIcon("iconos/ico_cap.png");
     
        
      
    }
public void llenaTabla(){
     
     String vec[] = new String[2];
     ResultSet res = ven.getDatosReporteVentas();
     Double tem = 0.0D;
     Double tem2 = 0.0D;
     Double totalCosto = 0.0D;
     Double totalVentas = 0.0D;
     Double totalNumeroVentas = 0.0D;
     DefaultTableModel modelo = (DefaultTableModel) tablaVentas.getModel();
    try {
        res.last();
        if(res.getRow()==0){
    
        }else{
        res.beforeFirst();
            System.out.println("Entro al false que llena");
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
        
        txtVentasTotales.setText(formatoImporte.format(totalVentas));
        Double ganancia = totalVentas - totalCosto;
        txtGanancia.setText(formatoImporte.format(ganancia));
        txtNumeroVentas.setText(totalNumeroVentas+"");
        }
    } catch (SQLException ex) {
      mensaje("Error en la base de datos");
     
    }
             
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVentasTotales = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroVentas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        jLabel2.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Ventas por día");

        jLabel1.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel1.setText("Reporte de ventas");

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Ventas totales");

        txtVentasTotales.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        txtVentasTotales.setText("$0");

        jLabel3.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Ganancia");

        txtGanancia.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        txtGanancia.setText("$0");

        jLabel5.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Número de ventas");

        txtNumeroVentas.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        txtNumeroVentas.setText("$0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroVentas)
                            .addComponent(txtGanancia)
                            .addComponent(txtVentasTotales))))
                .addGap(0, 354, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtVentasTotales))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNumeroVentas))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGanancia))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mensaje(String men){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    }
    
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel txtGanancia;
    private javax.swing.JLabel txtNumeroVentas;
    private javax.swing.JLabel txtVentasTotales;
    // End of variables declaration//GEN-END:variables
}
