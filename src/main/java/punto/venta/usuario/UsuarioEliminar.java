/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dao.UsuarioDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Usuario;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.modelo.response.UsuarioResponse;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class UsuarioEliminar extends javax.swing.JPanel {

    ArrayList<Usuario> lista = new ArrayList<Usuario>();
    UsuarioDAO obj = new UsuarioDAO();
    Usuario usu = new Usuario();
    ApiSend api = new ApiSend();
    Confirmacion confirma = new Confirmacion();

    public UsuarioEliminar() {
        initComponents();
  
        AutoCompleteDecorator.decorate(comboUsuario, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void requerirFoco() {
        comboUsuario.setFocusable(true);
        comboUsuario.requestFocus();
    }

    public void llenarCombo() {

      comboUsuario.removeAllItems();
        Usuario vacio= new Usuario();
        vacio.setIdUsuario(0);
        comboUsuario.addItem(vacio);

        UsuarioResponse res = api.getUsuarios(EnviromentLocal.urlG + "usuarios/" + Datos.idSucursal);
        for (Usuario usua : res.getUsuarios()) {
            comboUsuario.addItem(usua);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboUsuario = new javax.swing.JComboBox<Usuario>();
        btn4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Eliminar usuario");

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setText("Teclee el  nombre del usuario");

        comboUsuario.setModel(new javax.swing.DefaultComboBoxModel<Usuario>());

        btn4.setBackground(new java.awt.Color(153, 153, 0));
        btn4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn4.setText("Aceptar");
        btn4.setBorder(null);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        btn4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        eliminar();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            eliminar();
        }
    }//GEN-LAST:event_btn4KeyPressed
    public void mensaje(String men) {
        confirma.setMensaje(men);
        confirma.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                comboUsuario.requestFocus();
            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    public void eliminar() {
        Usuario user = (Usuario) comboUsuario.getSelectedItem();
        if (user.getIdUsuario() == 0) {
            Utilidades.mensajePorTiempo("Por favor selecciona o ingresa un usuario");
       
            mensaje("Por favor ingresa los datos");
        } else {
            user.setEliminado(true);
            ResponseGeneral res=api.usarAPI(EnviromentLocal.urlG + "usuarios", user, "PUT");
            mensaje(res.getMensaje());
            if (res.isRealizado()==true) {

                llenarCombo();
            } 

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn4;
    private javax.swing.JComboBox<Usuario> comboUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
