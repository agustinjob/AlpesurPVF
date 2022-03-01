/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.ClienteDAO;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Cliente;
import punto.venta.modelo.response.ClienteResponse;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ClienteEliminar extends javax.swing.JPanel {

    ClienteDAO obj = new ClienteDAO();
    ArrayList<Cliente> c;
    Confirmacion confi = new Confirmacion();
    ApiSend api = new ApiSend();

    public ClienteEliminar() {
        initComponents();
        AutoCompleteDecorator.decorate(comboClientes, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void requerirFoco() {
        comboClientes.setFocusable(true);
        comboClientes.requestFocus();
    }

    public void llenarCombo() {

        ClienteResponse res = api.getClientes(EnviromentLocal.urlG + "clientes/" + Datos.idSucursal);
        List<punto.venta.modelo.Cliente> lista = res.getClientes();
        comboClientes.removeAllItems();
        punto.venta.modelo.Cliente vacio = new punto.venta.modelo.Cliente();
        vacio.setIdCliente(0);
        comboClientes.addItem(vacio);
        for (punto.venta.modelo.Cliente c : lista) {
            comboClientes.addItem(c);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnaAceptar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox<Cliente>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 350));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Eliminar cliente");

        btnaAceptar.setBackground(new java.awt.Color(0, 153, 153));
        btnaAceptar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnaAceptar.setText("Aceptar");
        btnaAceptar.setBorder(null);
        btnaAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaAceptarActionPerformed(evt);
            }
        });
        btnaAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaAceptarKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Teclee el nombre del cliente:");

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<Cliente>());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnaAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(186, 186, 186))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnaAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaAceptarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnaAceptarActionPerformed

    public void eliminar() {
        Cliente cli = (Cliente) comboClientes.getSelectedItem();
        cli.setEstatusCliente("eliminado");

        if (cli.getIdCliente() == 0) {
            Utilidades.confirma(confi, "Por favor selecciona un cliente");
        } else {
            ResponseGeneral res = api.usarAPI(EnviromentLocal.urlG + "clientes", cli, "PUT");
            if (res.isRealizado() == true) {
                llenarCombo();
                confi.setMensaje("Datos eliminados satisfactoriamente");
                confi.setVisible(true);
            } else {
                confi.setMensaje("No se pudieron eliminar los datos, vuelve a intentarlo por favor");

            }

        }

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                confi.dispose();
                comboClientes.requestFocus();

            }

        });

        timer.setRepeats(false);
        timer.start();
    }
    private void btnaAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaAceptarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            eliminar();
        }
    }//GEN-LAST:event_btnaAceptarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaAceptar;
    private javax.swing.JComboBox<Cliente> comboClientes;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
