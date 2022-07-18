/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package punto.venta.dialogos;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import punto.servicio.rest.ApiSend;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Producto;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;

/**
 *
 * @author agus_
 */
public class CantidadProducto extends javax.swing.JFrame {

    ApiSend api = new ApiSend();
    Producto pro = new Producto();
    VentasEstructura ventas;
    boolean mostrar = false;

    public CantidadProducto(VentasEstructura ventas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ventas = ventas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblInventario = new javax.swing.JLabel();
        panelImporte = new javax.swing.JPanel();
        txfImporte = new javax.swing.JTextField();
        menosImporte = new javax.swing.JButton();
        masImporte = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelCantidad = new javax.swing.JPanel();
        txfCantidad = new javax.swing.JTextField();
        menosCantidad = new javax.swing.JButton();
        masCantidad = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblPrecioUnitario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botones.setBackground(new java.awt.Color(255, 204, 204));
        botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        botones.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 35));

        btnAceptar.setBackground(new java.awt.Color(0, 255, 51));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });
        botones.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, 100, 35));

        fondo.add(botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 130, 210));

        lblInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInventario.setForeground(new java.awt.Color(51, 51, 255));
        lblInventario.setText("Inventario actual = ");
        fondo.add(lblInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        panelImporte.setBackground(new java.awt.Color(255, 255, 255));
        panelImporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txfImporte.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txfImporte.setText("0.0");
        txfImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfImporteFocusGained(evt);
            }
        });
        txfImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfImporteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfImporteKeyReleased(evt);
            }
        });
        panelImporte.add(txfImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        menosImporte.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        menosImporte.setText("-");
        menosImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosImporteActionPerformed(evt);
            }
        });
        panelImporte.add(menosImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 30));

        masImporte.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        masImporte.setText("+");
        masImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masImporteActionPerformed(evt);
            }
        });
        panelImporte.add(masImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 30));

        fondo.add(panelImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 250, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad del producto");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        panelCantidad.setBackground(new java.awt.Color(255, 255, 255));
        panelCantidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txfCantidad.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txfCantidad.setText("0.0");
        txfCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfCantidadFocusGained(evt);
            }
        });
        txfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadActionPerformed(evt);
            }
        });
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
        });
        panelCantidad.add(txfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        menosCantidad.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        menosCantidad.setText("-");
        menosCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosCantidadActionPerformed(evt);
            }
        });
        panelCantidad.add(menosCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 30));

        masCantidad.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        masCantidad.setText("+");
        masCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masCantidadActionPerformed(evt);
            }
        });
        panelCantidad.add(masCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 30));

        fondo.add(panelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Importe actual");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        lblPrecioUnitario.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblPrecioUnitario.setText("$0.0");
        fondo.add(lblPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Precio unitario =");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("¿ Cantidad del producto ?");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void masCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masCantidadActionPerformed
        sumaYresta(txfCantidad, "sumar", 1);

    }//GEN-LAST:event_masCantidadActionPerformed

    private void menosCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosCantidadActionPerformed
        sumaYresta(txfCantidad, "restar", 1);        // TODO add your handling code here:
    }//GEN-LAST:event_menosCantidadActionPerformed

    private void masImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masImporteActionPerformed
        sumaYresta(txfImporte, "sumar", 2);        // TODO add your handling code here:
    }//GEN-LAST:event_masImporteActionPerformed

    private void menosImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosImporteActionPerformed
        sumaYresta(txfImporte, "restar", 2);        // TODO add your handling code here:
    }//GEN-LAST:event_menosImporteActionPerformed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        try {
            float cantidad = Float.parseFloat(txfCantidad.getText());
            txfImporte.setText(Utilidades.formaDos((cantidad * pro.getPrecioVenta())));
        } catch (NumberFormatException e) {
            txfCantidad.setText("1");
            txfImporte.setText(pro.getPrecioVenta() + "");
            Utilidades.mensajePorTiempo("Debes ingresar un valor númerico por favor");
        }

    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfImporteKeyReleased
        try {
            float cantidad = Float.parseFloat(txfImporte.getText());
            txfCantidad.setText(Utilidades.formaDos(cantidad / pro.getPrecioVenta()));
        } catch (NumberFormatException e) {
            txfCantidad.setText("1");
            txfImporte.setText(pro.getPrecioVenta() + "");
            Utilidades.mensajePorTiempo("Debes ingresar un valor númerico por favor");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txfImporteKeyReleased

    private void txfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadActionPerformed


    }//GEN-LAST:event_txfCantidadActionPerformed

    private void txfCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCantidadFocusGained
        String cantidad = txfCantidad.getText();
        txfCantidad.setSelectionStart(0);
        txfCantidad.setSelectionEnd(cantidad.length());        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadFocusGained

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mostrar = true;
        mostrarMensajeAlCerrar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txfImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfImporteFocusGained
        String cantidad = txfImporte.getText();
        txfImporte.setSelectionStart(0);
        txfImporte.setSelectionEnd(cantidad.length());          // TODO add your handling code here:
    }//GEN-LAST:event_txfImporteFocusGained

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        ventas.agregarDesdeTablaExternaConCantidad(pro, txfCantidad.getText(), txfImporte.getText().replace(",", ""));
        mostrarMensajeAlCerrar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ventas.agregarDesdeTablaExternaConCantidad(pro, txfCantidad.getText(), txfImporte.getText());
            mostrarMensajeAlCerrar();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            mostrarMensajeAlCerrar();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadKeyPressed

    private void txfImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfImporteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ventas.agregarDesdeTablaExternaConCantidad(pro, txfCantidad.getText(), txfImporte.getText());
            mostrarMensajeAlCerrar();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            mostrarMensajeAlCerrar();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txfImporteKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ventas.agregarDesdeTablaExternaConCantidad(pro, txfCantidad.getText(), txfImporte.getText());
            this.dispose();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarKeyPressed

    public void mostrarMensajeAlCerrar() {
        if (mostrar) {
            Utilidades.mensajePorTiempo("Artículo cancelado");
        }
        this.dispose();
    }

    public void asignarCantidad(String idProducto) {
        ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos-id/" + idProducto);
        pro = res.getProductos().get(0);
        txfCantidad.setText("1");
        txfImporte.setText(pro.getPrecioVenta() + "");
        lblPrecioUnitario.setText(pro.getPrecioVenta() + "");
        lblInventario.setText("Inventario actual = " + pro.getCantidad());

    }

    public float sumaYresta(JTextField txf, String operacion, int tipo) {
        // tipo 1 = Cantidad , tipo 2 = Importe
        float cantidad = 0.0f;
        try {
            cantidad = Float.parseFloat(txf.getText());

            if (tipo == 1) {
                if (operacion.equalsIgnoreCase("sumar")) {

                    if (cantidad < pro.getCantidad()) {
                        cantidad = cantidad + .5f;
                    } else {
                        Utilidades.mensajePorTiempo("No puedes ingresar más cantidad de lo que se tiene en el inventario");
                    }
                } else {
                    if (cantidad > 0) {
                        cantidad = cantidad - .5f;
                    } else {
                        Utilidades.mensajePorTiempo("La cantidad no puede ser menor a 0");
                    }
                }
                txfImporte.setText(Utilidades.formaDos((cantidad * pro.getPrecioVenta())));
            } else {

                if (operacion.equalsIgnoreCase("sumar")) {
                    float total = pro.getCantidad() * pro.getPrecioVenta();
                    if (cantidad < total) {
                        cantidad = cantidad + .5f;
                    } else {
                        Utilidades.mensajePorTiempo("No puedes ingresar más cantidad de lo que se tiene en el inventario");
                    }
                } else {
                    if (cantidad > 0) {
                        cantidad = cantidad - .5f;
                    } else {
                        Utilidades.mensajePorTiempo("La cantidad no puede ser menor a 0");
                    }
                }
                float importe = Float.parseFloat(txfImporte.getText());
                txfCantidad.setText(Utilidades.formaDos(importe / pro.getPrecioVenta()));
            }
            txf.setText(Utilidades.formaDos(cantidad) + "");
        } catch (NumberFormatException e) {
            Utilidades.mensajePorTiempo("Por favor ingresa un valor númerico");
            txf.setText("0");
        }
        return cantidad;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botones;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JButton masCantidad;
    private javax.swing.JButton masImporte;
    private javax.swing.JButton menosCantidad;
    private javax.swing.JButton menosImporte;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JPanel panelImporte;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfImporte;
    // End of variables declaration//GEN-END:variables
}
