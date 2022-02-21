/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.transferencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dao.SucursalDAO;
import punto.venta.misclases.TransferenciaProductos;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class Paso1 extends javax.swing.JPanel {

    TransferenciaProductos transP = new TransferenciaProductos();
    SucursalDAO sucursales = new SucursalDAO();
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Nombre", "Dirección", "id"};

    public Paso1() {
        initComponents();
        String men = "Estas en la sucursal:" + Datos.sucursal + ", por favor selecciona a que sucursal vas a enviar los productos";

        md = new DefaultTableModel();
        this.tablaSucursales.setModel(md);
        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        centrarTabla();
        try {
            llenarTabla();
        } catch (Exception e) {
         
            men = "No hay intener, por favor revisa tu conexión y vuelve a intentarlo";
        }

        jLabel1.setText(men);

    }

    public void requerirFoco() {
        // txtCodigo.setFocusable(true);
        // txtCodigo.requestFocus();
    }

    public void llenarTabla() {

        try {
            ResultSet res = sucursales.obtenerSucursales();
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                String datos[] = new String[3];
                while (res.next()) {
                    datos[0] = res.getString("nombre");
                    datos[1] = res.getString("direccion");
                    datos[2] = res.getString("idSucursal");
                    md.addRow(datos);
                }
            }
        } catch (SQLException ex) {
           
            Logger.getLogger(Paso1.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void centrarTabla() {

        JTableHeader tablaCabe = tablaSucursales.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer) tablaSucursales.getTableHeader().getDefaultRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCabe.setDefaultRenderer(render);
        tablaSucursales.setModel(md);
        dt.setHorizontalAlignment(SwingConstants.CENTER);
        tablaSucursales.getColumnModel().getColumn(0).setCellRenderer(dt);
        tablaSucursales.getColumnModel().getColumn(0).setWidth(360);
        tablaSucursales.getColumnModel().getColumn(0).setMinWidth(360);
        tablaSucursales.getColumnModel().getColumn(0).setMaxWidth(360);

        tablaSucursales.getColumnModel().getColumn(1).setCellRenderer(dt);
        tablaSucursales.getColumnModel().getColumn(1).setWidth(360);
        tablaSucursales.getColumnModel().getColumn(1).setMinWidth(360);
        tablaSucursales.getColumnModel().getColumn(1).setMaxWidth(360);

        tablaSucursales.getColumnModel().getColumn(2).setWidth(0);
        tablaSucursales.getColumnModel().getColumn(2).setMinWidth(0);
        tablaSucursales.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaSucursales.setRowHeight(30);

        tablaSucursales.setRowSelectionAllowed(true);
        tablaSucursales.setColumnSelectionAllowed(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSucursales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Estas en la sucursal: Fortin de las flores, por favor selecciona a que sucursal vas a enviar los productos");

        tablaSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dirección", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSucursales.setColumnSelectionAllowed(true);
        tablaSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSucursalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSucursales);
        tablaSucursales.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaSucursales.getColumnModel().getColumnCount() > 0) {
            tablaSucursales.getColumnModel().getColumn(0).setResizable(false);
            tablaSucursales.getColumnModel().getColumn(1).setResizable(false);
            tablaSucursales.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        jLabel2.setText("Selecciona una sucursal por favor");

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //llenar datos en el modelo
        if (transP.getIdSucursalEnvio() != 0) {
            Paso2 paso2 = TransferenciaEstructura.transferencia.getPaso2();
            paso2.setTrans(transP);
            paso2.llenarTabla();
            paso2.setVisible(true);
            this.setVisible(false);
            TransferenciaEstructura.transferencia.getContenedor().add(paso2);
        } else {
            Utilidades.mensajePorTiempo("Selecciona la sucursal a enviar los productos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSucursalesMouseClicked
        int row = tablaSucursales.getSelectedRow();
        String nombre = (String) tablaSucursales.getValueAt(row, 0);
        String direccion = (String) tablaSucursales.getValueAt(row, 1);
        int idSucursal = Integer.parseInt((String) tablaSucursales.getValueAt(row, 2));
        jLabel2.setText("Usted ha seleccionado la sucursal: " + nombre);
        transP.setIdSucursalEnvio(idSucursal);
        transP.setSucursalEnvio(nombre);
// TODO add your handling code here:
    }//GEN-LAST:event_tablaSucursalesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSucursales;
    // End of variables declaration//GEN-END:variables
}
