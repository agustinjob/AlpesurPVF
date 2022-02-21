/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.venta.dao.Conexion;
import punto.venta.dao.ProductoDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.misclases.Producto;
import punto.venta.utilidades.Utilidades;
import static punto.venta.utilidades.Utilidades.confirma;

/**
 *
 * @author agus_
 */
public class TransferirEstructura extends javax.swing.JPanel {

    ProductoDAO obj = new ProductoDAO();
    Producto pro1 = new Producto();
    Producto pro2 = new Producto();
    ArrayList<Producto> p = new ArrayList();
    Confirmacion confirma = new Confirmacion();

    public TransferirEstructura() {
        initComponents();
        ImageIcon a3 = new ImageIcon("iconos/proximo.png");
        ImageIcon lupa = new ImageIcon("iconos/buscador.png");
        ImageIcon transformar = new ImageIcon("iconos/inter.png");
        ImageIcon exportarI = new ImageIcon("iconos/exportar.png");
        ImageIcon agregarI = new ImageIcon("iconos/agregar.png");
        ImageIcon datos = new ImageIcon("iconos/datos.png");
        btnBuscarT.setIcon(lupa);
        btnBuscarA.setIcon(lupa);
        btnTransformar.setIcon(transformar);
        exportar.setIcon(exportarI);
        agregar.setIcon(agregarI);
        imagen.setIcon(datos);
        l1.setIcon(a3);
        llenarCombo();
        AutoCompleteDecorator.decorate(producT, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        AutoCompleteDecorator.decorate(producA, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void limpiarDatos() {
        cantidadT.setText("");
        agregarT.setText("");
        cantidadA.setText("");
        agregarA.setText("");
    }

    public void mensaje(String men) {
        confirma.setMensaje(men);
        confirma.setVisible(true);
        Timer timer = new Timer(1100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                producT.requestFocus();
            }

        });
        timer.setRepeats(false);
        timer.start();
    }

    public void requerirFoco() {
        producT.requestFocus();
    }

    public void llenarCombo() {

        try {
            p = obj.obtenerProductosSiHuboModificacion(p, true);
            int i = 0;
            producA.removeAllItems();
            producT.removeAllItems();
            producA.addItem("");
            producT.addItem("");
            while (i < p.size()) {
                producA.addItem(p.get(i).getNombre());
                producT.addItem(p.get(i).getNombre());
                i++;
            }
        } catch (ClassNotFoundException ex) {
           
            mensaje("Hubo un error en el sistema");

        } catch (SQLException ex) {
           
            mensaje("Hubo un error con la base de datos");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        agregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cantidadA = new javax.swing.JTextField();
        agregarA = new javax.swing.JTextField();
        btnBuscarA = new javax.swing.JButton();
        producA = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        exportar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cantidadT = new javax.swing.JTextField();
        agregarT = new javax.swing.JTextField();
        btnBuscarT = new javax.swing.JButton();
        producT = new javax.swing.JComboBox<>();
        btnTransformar = new javax.swing.JButton();
        panelTicket3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1365, 507));

        l1.setPreferredSize(new java.awt.Dimension(70, 35));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 300));

        agregar.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        agregar.setText("Producto a agregar");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Nombre producto");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Agregar");

        cantidadA.setEditable(false);
        cantidadA.setPreferredSize(new java.awt.Dimension(200, 30));

        agregarA.setPreferredSize(new java.awt.Dimension(200, 30));

        btnBuscarA.setBackground(new java.awt.Color(93, 155, 120));
        btnBuscarA.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscarA.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarA.setText("Buscar");
        btnBuscarA.setBorder(null);
        btnBuscarA.setPreferredSize(new java.awt.Dimension(120, 35));
        btnBuscarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAActionPerformed(evt);
            }
        });
        btnBuscarA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarAKeyPressed(evt);
            }
        });

        producA.setEditable(true);
        producA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(agregar)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(producA, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(agregar)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(producA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidadA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(agregarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(500, 300));

        exportar.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        exportar.setText("Producto a transferir");

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Nombre producto");

        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setText("Cantidad");

        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setText("Transferir");

        cantidadT.setEditable(false);
        cantidadT.setPreferredSize(new java.awt.Dimension(200, 30));

        agregarT.setPreferredSize(new java.awt.Dimension(200, 30));

        btnBuscarT.setBackground(new java.awt.Color(93, 155, 120));
        btnBuscarT.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscarT.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarT.setText("Buscar");
        btnBuscarT.setBorder(null);
        btnBuscarT.setPreferredSize(new java.awt.Dimension(120, 35));
        btnBuscarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTActionPerformed(evt);
            }
        });
        btnBuscarT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarTKeyPressed(evt);
            }
        });

        producT.setEditable(true);
        producT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidadT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(producT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(exportar)
                    .addComponent(agregarT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(exportar)
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnBuscarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        btnTransformar.setBackground(new java.awt.Color(91, 153, 118));
        btnTransformar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnTransformar.setForeground(new java.awt.Color(255, 255, 255));
        btnTransformar.setText("TRANSFORMAR");
        btnTransformar.setBorder(null);
        btnTransformar.setPreferredSize(new java.awt.Dimension(250, 35));
        btnTransformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransformarActionPerformed(evt);
            }
        });
        btnTransformar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTransformarKeyPressed(evt);
            }
        });

        panelTicket3.setBackground(new java.awt.Color(204, 51, 0));

        jLabel8.setBackground(new java.awt.Color(204, 204, 0));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TRANSFERIR");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicket3Layout = new javax.swing.GroupLayout(panelTicket3);
        panelTicket3.setLayout(panelTicket3Layout);
        panelTicket3Layout.setHorizontalGroup(
            panelTicket3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicket3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTicket3Layout.setVerticalGroup(
            panelTicket3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicket3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(btnTransformar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
            .addComponent(panelTicket3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panelTicket3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTransformar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAActionPerformed
        buscarAgregar();
    }//GEN-LAST:event_btnBuscarAActionPerformed
    public void buscarAgregar() {
        String p2 = (String) producA.getSelectedItem();
        if (p2.equalsIgnoreCase("")) {
            mensaje("Por favor selecciona un producto y presiona el botón 'Buscar'");

        } else {
            pro2 = obj.getDatosProducto(p2, p);
            cantidadA.setText(pro2.getCantidad() + "");
        }
    }
    private void btnBuscarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTActionPerformed
        buscarTransferir();
    }//GEN-LAST:event_btnBuscarTActionPerformed

    public void buscarTransferir() {
        String p1 = (String) producT.getSelectedItem();
        if (p1.equalsIgnoreCase("")) {

            mensaje("Por favor selecciona un producto y presiona el botón 'Buscar'");

        } else {
            pro1 = obj.getDatosProducto(p1, p);
            cantidadT.setText(pro1.getCantidad() + "");
        }
    }
    private void btnTransformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransformarActionPerformed
        transferir();
    }//GEN-LAST:event_btnTransformarActionPerformed

    public void transferir() {
        String a[] = new String[4];
        a[0] = cantidadT.getText();
        a[1] = cantidadA.getText();
        a[2] = agregarT.getText();
        a[3] = agregarA.getText();
        String p1 = (String) producT.getSelectedItem();
        String p2 = (String) producA.getSelectedItem();
        if (p1.equalsIgnoreCase("") || p2.equalsIgnoreCase("")) {

            mensaje("Por favor selecciona un producto y presiona el botón 'Buscar'");
        } else {
            if (p1.equalsIgnoreCase(p2)) {

                mensaje("No puedes transferir al mismo producto");
            } else {

                boolean datosC = true;
                boolean hay = Utilidades.hayVacios(a);
                if (hay == true) {
                    mensaje("Por favor ingresa todos los datos solicitados");
                } else {
                    double ct, ca, at, aa;
                    ct = ca = aa = at = 0.0D;
                    try {
                        ct = Double.parseDouble(a[0]);
                        ca = Double.parseDouble(a[1]);
                        aa = Double.parseDouble(a[2]);
                        at = Double.parseDouble(a[3]);
                    } catch (NumberFormatException e) {
                        mensaje("Por favor revisa los datos ingresados");
                        datosC = false;
                    }
                    if (datosC == true) {
                        if (ct > aa) {
                            try {
                                String mensa = "";
                                String estatus = "En proceso";
                                mensa = obj.transferir(pro1, pro2, aa, at, "Actualizada", "Modificacion");
                                mensaje(mensa);
                                llenarCombo();
                                limpiarDatos();
                            } catch (ClassNotFoundException ex) {
                                mensaje("Hubo un error en el sistema");
                            } catch (SQLException ex) {

                            }
                        } else {
                            mensaje("El número de productos a agregar debe ser igual o menor a la cantidad de productos que hay en inventario");
                        }
                    }
                }
            }
        }
    }
    private void btnBuscarTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarTKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarTransferir();
        }

    }//GEN-LAST:event_btnBuscarTKeyPressed

    private void btnBuscarAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarAKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarAgregar();
        }
    }//GEN-LAST:event_btnBuscarAKeyPressed

    private void btnTransformarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTransformarKeyPressed
        transferir();
    }//GEN-LAST:event_btnTransformarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agregar;
    private javax.swing.JTextField agregarA;
    private javax.swing.JTextField agregarT;
    private javax.swing.JButton btnBuscarA;
    private javax.swing.JButton btnBuscarT;
    private javax.swing.JButton btnTransformar;
    private javax.swing.JTextField cantidadA;
    private javax.swing.JTextField cantidadT;
    private javax.swing.JLabel exportar;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel l1;
    private javax.swing.JPanel panelTicket3;
    private javax.swing.JComboBox<String> producA;
    private javax.swing.JComboBox<String> producT;
    // End of variables declaration//GEN-END:variables
}
