/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.inventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;

import punto.venta.dao.Datos;
import punto.venta.dao.ProductoDAO;
import punto.venta.dao.UsuarioDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.misclases.CrearExcel;
import punto.venta.modelo.Producto;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.modelo.response.ProductoUtilidadResponse;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class InventarioDatos extends javax.swing.JPanel {

    ProductoDAO p = new ProductoDAO();
    Confirmacion confirma = new Confirmacion();
    NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
    ApiSend api = new ApiSend();

    public InventarioDatos() {
        initComponents();
        ImageIcon billetes = new ImageIcon("iconos/billetes.png");
        ImageIcon excel = new ImageIcon("iconos/excel.png");
        txtBilletes.setIcon(billetes);
        btnInventarioExcel.setIcon(excel);
   
    }

    public void limpiarTabla() {
        DefaultTableModel tm = (DefaultTableModel) tablaPro.getModel();
        int r = 0;
        while (tm.getRowCount() > r) {
            tm.removeRow(r);
        }
    }

    public void requerirFoco() {
        btnInventarioExcel.requestFocus();
    }

    public void llenarTabla() {
        limpiarTabla();
        float preCos, preVen, utilidad;
        preCos = preVen = utilidad = 0.0F;

    
            DefaultTableModel model = (DefaultTableModel) tablaPro.getModel();
            ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos/" + Datos.idSucursal);
            List<Producto> prou = res.getProductos();
            if (prou.isEmpty()) {
            } else {
                String x[] = new String[10];

                int i = 1;
                for (Producto pu : prou) {
                    x[0] = i + "";
                    x[1] = pu.getCodigo();
                    x[2] = pu.getDescripcion();
                    x[3] = pu.getCantidad()+"";
                    x[4] = pu.getPrecioCosto()+"";
                    x[5] = pu.getPrecioVenta()+"";
                    x[6] = (pu.getPrecioVenta()- pu.getPrecioCosto())+"";

                    x[7] = (pu.getPrecioCosto()* pu.getCantidad())+"";
                    preCos = preCos + (pu.getPrecioCosto()* pu.getCantidad());
                    x[8] = (pu.getPrecioVenta()*pu.getCantidad())+"";
                    preVen = preVen + (pu.getPrecioVenta()*pu.getCantidad());
                    x[9] = ((pu.getPrecioVenta()*pu.getCantidad())-(pu.getPrecioCosto()* pu.getCantidad()))+"";
                    utilidad = utilidad + ((pu.getPrecioVenta()*pu.getCantidad())-(pu.getPrecioCosto()* pu.getCantidad()));
                    model.addRow(x);
                    i++;

                }
                if (UsuarioDAO.getTipo().equalsIgnoreCase("empleado")) {
                    txtPreVen.setText("");
                    txtPreCos.setText("");
                    txtUtilidad.setText("");
                } else {
                    txtPreVen.setText(formatoImporte.format(preVen));
                    txtPreCos.setText(formatoImporte.format(preCos));
                    txtUtilidad.setText(formatoImporte.format(utilidad));
                }
            }
    

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPro = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPreCos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPreVen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JLabel();
        txtBilletes = new javax.swing.JLabel();
        btnInventarioExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tablaPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Código", "Nombre", "Cantidad", "P. Compra", "P. Venta", "Utilidad", "P. Com. Total", "P. Vent. Total", "Utilidad Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPro);

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Total precio compra:");

        txtPreCos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtPreCos.setText("jLabel5");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Total precio venta:");

        txtPreVen.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtPreVen.setText("jLabel5");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Utilidad total:");

        txtUtilidad.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtUtilidad.setText("jLabel5");

        txtBilletes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBilletes.setForeground(new java.awt.Color(51, 0, 204));
        txtBilletes.setText("Ganancias");

        btnInventarioExcel.setText("Generar Excel");
        btnInventarioExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioExcelActionPerformed(evt);
            }
        });
        btnInventarioExcel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnInventarioExcelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBilletes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPreCos)
                            .addComponent(txtPreVen)
                            .addComponent(jLabel2)
                            .addComponent(txtUtilidad)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(btnInventarioExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnInventarioExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtBilletes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreCos)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreVen)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUtilidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioExcelActionPerformed
        generaExcel();
    }//GEN-LAST:event_btnInventarioExcelActionPerformed

    private void btnInventarioExcelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInventarioExcelKeyPressed
        generaExcel();
    }//GEN-LAST:event_btnInventarioExcelKeyPressed

    public void generaExcel() {
        try {
            CrearExcel objE = new CrearExcel();
            objE.writeExcel();
            mensaje("Se genero el documento, buscalo en C:/inventario_punto_venta/inventario.xls");
        } catch (Exception ex) {
            Logger.getLogger(InventarioDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mensaje(String men) {
        confirma.setMensaje(men);
        confirma.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                btnInventarioExcel.requestFocus();
            }

        });

        timer.setRepeats(false);
        timer.start();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInventarioExcel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPro;
    private javax.swing.JLabel txtBilletes;
    private javax.swing.JLabel txtPreCos;
    private javax.swing.JLabel txtPreVen;
    private javax.swing.JLabel txtUtilidad;
    // End of variables declaration//GEN-END:variables
}
