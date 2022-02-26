/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.AreaDAO;
import punto.venta.dao.Datos;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Area;
import punto.venta.modelo.response.AreaResponse;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ProductoArea extends javax.swing.JPanel {

    AreaDAO objArea = new AreaDAO();
    ApiSend api = new ApiSend();

    public ProductoArea() {
        initComponents();

    }

    public void llenarCombo() {

        comboAreas.removeAllItems();
        Area vacio = new Area();
        vacio.setIdArea(0);
        comboAreas.addItem(vacio);
        AreaResponse res = api.getAreas(EnviromentLocal.urlG + "areas/" + Datos.idSucursal);
       for(Area a: res.getAreas()){
       comboAreas.addItem(a);
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titu = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        codi = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        titu1 = new javax.swing.JLabel();
        comboAreas = new javax.swing.JComboBox<Area>();
        btnBuscar = new javax.swing.JButton();
        codi1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        titu.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        titu.setForeground(new java.awt.Color(0, 0, 102));
        titu.setText("REGISTRAR ÁREA");

        codi.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        codi.setText("Nombre");

        btnAgregar.setBackground(new java.awt.Color(168, 168, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.setBorder(null);
        btnAgregar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rformed(evt);
            }
        });

        titu1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        titu1.setForeground(new java.awt.Color(0, 0, 102));
        titu1.setText("ELIMINAR ÁREA");

        comboAreas.setEditable(true);
        comboAreas.setModel(new javax.swing.DefaultComboBoxModel<Area>());
        comboAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreasActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(168, 168, 255));
        btnBuscar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBuscar.setText("Eliminar");
        btnBuscar.setBorder(null);
        btnBuscar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        codi1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        codi1.setText("Selecciona el área que deseas eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titu1)
                            .addComponent(titu)
                            .addComponent(codi))
                        .addGap(855, 1046, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codi1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titu)
                .addGap(27, 27, 27)
                .addComponent(codi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(titu1)
                .addGap(19, 19, 19)
                .addComponent(codi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rformed

        String nombre = txtArea.getText();
        if (nombre.trim().equalsIgnoreCase("")) {
            Utilidades.mensajePorTiempo("Por favor ingresa la información solicitada");
        } else {
            Area a=new Area();
                a.setIdArea(0);
                a.setIdSucursal(Datos.idSucursal);
                a.setNombre(nombre);
                a.setEstatusArea("vigente");
                a.setPropietario(Datos.propietario);
            ResponseGeneral res = api.usarAPI(EnviromentLocal.urlG + "areas-nombre",a,"POST");
            if (res.getMensaje().equalsIgnoreCase("Si")) {
                Utilidades.mensajePorTiempo("Ya existe un área con ese nombre, por favor ingresa uno nuevo");
            } else {
              
              ResponseGeneral resul= api.usarAPI(EnviromentLocal.urlG+"areas",a , "POST");
                Utilidades.mensajePorTiempo(resul.getMensaje());
                llenarCombo();
                txtArea.setText("");

            }
        }
    }//GEN-LAST:event_rformed

    private void comboAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreasActionPerformed

    }//GEN-LAST:event_comboAreasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = (String) comboAreas.getSelectedItem();
        if (nombre.trim().equalsIgnoreCase("")) {
            Utilidades.mensajePorTiempo("Por favor ingresa la información solicitada");
        } else {

            String estatus = "En proceso";
            int num = objArea.eliminar(nombre, "Actualizada", "Eliminacion");
            Utilidades.mensajePorTiempo("Área eliminada con exito");
            llenarCombo();

        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel codi;
    private javax.swing.JLabel codi1;
    private javax.swing.JComboBox<Area> comboAreas;
    private javax.swing.JLabel titu;
    private javax.swing.JLabel titu1;
    private javax.swing.JTextField txtArea;
    // End of variables declaration//GEN-END:variables
}
