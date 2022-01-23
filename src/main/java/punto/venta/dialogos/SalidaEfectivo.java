/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import punto.venta.dao.Conexion;
import punto.venta.dao.Movimientos;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;

public class SalidaEfectivo extends javax.swing.JFrame {

    Confirmacion confirma= new Confirmacion();
    VentasEstructura ventas;
    Movimientos obj = new Movimientos();
    int ocultar = 0;

    public SalidaEfectivo(VentasEstructura ventas) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registro de salidas de efectivo");
        setIconImage(new ImageIcon("iconos/punto-de-venta.png").getImage());
        ImageIcon a = new ImageIcon("iconos/check.png");
        ImageIcon b = new ImageIcon("iconos/cancelar.png");
        ImageIcon c = new ImageIcon("iconos/entradas_pasadas.png");
        obj.setConn(Conexion.conexi.getLocal());
        this.ventas = ventas;
        btnguardar.setIcon(a);
        btncancelar.setIcon(b);
        btnversalidas.setIcon(c);
        jTextField1.requestFocus();
        setSize(550, 250);
    }

    public void limpiaTabla() {
        DefaultTableModel tm = (DefaultTableModel) tablaSalidas.getModel();
        int r = 0;
        while (tm.getRowCount() > r) {
            tm.removeRow(r);
        }
    }

    public void actualizaTabla() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
            
            
            ResultSet rs = obj.getEntradasDelDia("salida_efectivo");
            String[] x = new String[3];
            if (rs == null) {

            } else {
                while (rs.next()) {

                    x[0] = rs.getString(3);
                    x[1] = rs.getString(4);
                    x[2] = rs.getString(5);
                    System.out.println("Datos resultados = " + rs.getString(2));
                    System.out.println("Datos resultados = " + x[0]);
                    modelo.addRow(x);

                }
                tablaSalidas.setModel(modelo);
            }
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            mensaje( "Hubo un error en el sistema",1);
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            mensaje( "Hubo un error con la conexión a la base de datos",1);
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnversalidas = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad:");

        jTextField1.setPreferredSize(new java.awt.Dimension(200, 35));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Razón o Proveedor");

        jTextField2.setPreferredSize(new java.awt.Dimension(200, 35));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 250));

        btnguardar.setBackground(new java.awt.Color(153, 0, 0));
        btnguardar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.setBorder(null);
        btnguardar.setPreferredSize(new java.awt.Dimension(150, 35));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(153, 0, 0));
        btncancelar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(null);
        btncancelar.setPreferredSize(new java.awt.Dimension(150, 35));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnversalidas.setBackground(new java.awt.Color(153, 0, 0));
        btnversalidas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnversalidas.setForeground(new java.awt.Color(255, 255, 255));
        btnversalidas.setText("Ver salidas");
        btnversalidas.setBorder(null);
        btnversalidas.setPreferredSize(new java.awt.Dimension(150, 35));
        btnversalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnversalidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnversalidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnversalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 40));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SALIDAS DE EFECTIVO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 113, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Monto", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaSalidas);
        if (tablaSalidas.getColumnModel().getColumnCount() > 0) {
            tablaSalidas.getColumnModel().getColumn(0).setResizable(false);
            tablaSalidas.getColumnModel().getColumn(0).setPreferredWidth(125);
            tablaSalidas.getColumnModel().getColumn(1).setResizable(false);
            tablaSalidas.getColumnModel().getColumn(1).setPreferredWidth(25);
            tablaSalidas.getColumnModel().getColumn(2).setResizable(false);
            tablaSalidas.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Salidas realizadas en el turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed
public void guardar(){
        String a[] = new String[2];
        a[0] = jTextField1.getText();
        a[1] = jTextField2.getText();

        if (Utilidades.hayVacios(a)) {
            mensaje( "Por favor ingresa todos los datos",1);
        } else {

            try {
                double tem = Double.parseDouble(a[0]);
                obj.registrarEfectivoInicial(jTextField1.getText(), "salida_efectivo", jTextField2.getText(), "Actualizada","Registro");
                mensaje( "Se ha registrado la salida correctamente",2);
                jTextField1.setText("");//Cantidad
                jTextField2.setText("");//Proveedor
                this.dispose();
            } catch (ClassNotFoundException ex) {
                      Utilidades.escribirLog(ex.getLocalizedMessage());
                mensaje( "Hubo un error en el sistema",1);
            } catch (SQLException ex) {
                      Utilidades.escribirLog(ex.getLocalizedMessage());
                mensaje( "Hubo un error con la base de datos",1);
            } catch (NumberFormatException e) {
                      Utilidades.escribirLog(e.getLocalizedMessage());
                mensaje( "Por favor revisa los datos ingresados",1);
            }

        }        // TODO add your handling code here:
}
    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

      public void mensaje(String men, int tipo){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    
    Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 if(tipo == 1){
                 jTextField1.requestFocus();
                 }else{
                 ventas.requerirFoco();
                 }
                }
                
            });

    timer.setRepeats(false);
            timer.start();
    }

    
    private void btnversalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnversalidasActionPerformed
        if (ocultar == 0) {
            btnversalidas.setText("Ocultar salidas");
            setSize(550, 500);
            actualizaTabla();
            ocultar = 1;
        } else {
            btnversalidas.setText("Mostrar salidas");
            setSize(550, 250);
            ocultar = 0;
            limpiaTabla();
        }
        // total 500
    }//GEN-LAST:event_btnversalidasActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       guardar();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    guardar();
    }//GEN-LAST:event_jTextField2ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnversalidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tablaSalidas;
    // End of variables declaration//GEN-END:variables
}
