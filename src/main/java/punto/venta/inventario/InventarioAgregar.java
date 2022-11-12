/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.inventario;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.AreaDAO;

import punto.venta.dao.Datos;
import punto.venta.dao.ProductoDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.misclases.ImprimirTicket;
import punto.venta.modelo.Area;
import punto.venta.modelo.Producto;
import punto.venta.modelo.response.AreaResponse;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.producto.ProductoArea;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class InventarioAgregar extends javax.swing.JPanel {

    List<Producto> plist = new ArrayList();
    Confirmacion confir = new Confirmacion();
    ImprimirTicket objImprimir = new ImprimirTicket();
    ApiSend api = new ApiSend();

    public InventarioAgregar() {
        initComponents();
        ImageIcon lupa = new ImageIcon("iconos/lupa.png");
        ImageIcon agregar = new ImageIcon("iconos/check.png");
        btnBuscar.setIcon(lupa);
        btnAgregar.setIcon(agregar);
        AutoCompleteDecorator.decorate(comboProductos, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        AutoCompleteDecorator.decorate(comboAreas, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void llenarCombo() {
        comboProductos.removeAllItems();
        Producto vacio = new Producto();
        vacio.setIdProducto(0);
        comboProductos.addItem(vacio);
        ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos/" + Datos.idSucursal);
        plist = res.getProductos();
        for (Producto p : res.getProductos()) {
            comboProductos.addItem(p);

        }
    }

    public void llenarComboArea() {

        comboAreas.removeAllItems();
        Area vacio = new Area();
        vacio.setIdArea(0);
        comboAreas.addItem(vacio);
        AreaResponse res = api.getAreas(EnviromentLocal.urlG + "areas/" + Datos.idSucursal);
        for (Area a : res.getAreas()) {
            comboAreas.addItem(a);
        }
    }

    public void requerirFoco() {
        comboProductos.setFocusable(true);
        comboProductos.requestFocus();
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecioCosto.setText("");
        txtPrecioVenta.setText("");
        txtPrecioMayoreo.setText("");
        txtExistencia.setText("");
        txtAgregar.setText("");
        txtPrecioDistribuidor.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titu = new javax.swing.JLabel();
        codi = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<Producto>();
        btnBuscar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        codiso = new javax.swing.JLabel();
        des = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecioCosto = new javax.swing.JTextField();
        preco = new javax.swing.JLabel();
        preve = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtPrecioMayoreo = new javax.swing.JTextField();
        prema = new javax.swing.JLabel();
        exis = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        txtAgregar = new javax.swing.JTextField();
        agrega = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        comboAreas = new javax.swing.JComboBox<Area>();
        btnAgregar1 = new javax.swing.JButton();
        codi1 = new javax.swing.JLabel();
        txtPrecioDistribuidor = new javax.swing.JTextField();
        prema1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        titu.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        titu.setForeground(new java.awt.Color(0, 0, 102));
        titu.setText("AGREGAR INVENTARIO");

        codi.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        codi.setText("Nombre:");

        comboProductos.setEditable(true);
        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<Producto>());

        btnBuscar.setBackground(new java.awt.Color(168, 168, 255));
        btnBuscar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        txtCodigo.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        codiso.setBackground(new java.awt.Color(255, 204, 153));
        codiso.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        codiso.setText("Código de barras:");

        des.setBackground(new java.awt.Color(255, 204, 153));
        des.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        des.setText("Descripción:");

        txtNombre.setEditable(false);
        txtNombre.setPreferredSize(new java.awt.Dimension(300, 30));

        txtPrecioCosto.setEditable(false);
        txtPrecioCosto.setPreferredSize(new java.awt.Dimension(300, 30));

        preco.setBackground(new java.awt.Color(255, 204, 153));
        preco.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        preco.setText("Precio costo:");

        preve.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        preve.setText("Precio venta:");

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(300, 30));

        txtPrecioMayoreo.setEditable(false);
        txtPrecioMayoreo.setPreferredSize(new java.awt.Dimension(300, 30));

        prema.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        prema.setText("Precio distribuidor:");

        exis.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        exis.setText("Existencia:");

        txtExistencia.setEditable(false);
        txtExistencia.setPreferredSize(new java.awt.Dimension(300, 30));

        txtAgregar.setPreferredSize(new java.awt.Dimension(300, 30));

        agrega.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        agrega.setText("Agregar:");

        btnAgregar.setBackground(new java.awt.Color(168, 168, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAgregar.setText("Imprimir inventario ");
        btnAgregar.setBorder(null);
        btnAgregar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });

        comboAreas.setEditable(true);
        comboAreas.setModel(new javax.swing.DefaultComboBoxModel<Area>());
        comboAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreasActionPerformed(evt);
            }
        });

        btnAgregar1.setBackground(new java.awt.Color(168, 168, 255));
        btnAgregar1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAgregar1.setText("Agregar inventario");
        btnAgregar1.setBorder(null);
        btnAgregar1.setPreferredSize(new java.awt.Dimension(130, 35));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        btnAgregar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregar1KeyPressed(evt);
            }
        });

        codi1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        codi1.setText("Selecciona un área para imprimir su inventario");

        txtPrecioDistribuidor.setEditable(false);
        txtPrecioDistribuidor.setPreferredSize(new java.awt.Dimension(300, 30));

        prema1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        prema1.setText("Precio mayoreo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titu)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(des)
                            .addComponent(preco)
                            .addComponent(preve))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPrecioCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codiso)
                            .addComponent(codi))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(agrega)
                    .addComponent(prema1)
                    .addComponent(prema)
                    .addComponent(exis))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(codi1)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titu)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codiso))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(des)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preve))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prema1)
                    .addComponent(txtPrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exis)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agrega))
                .addGap(11, 11, 11)
                .addComponent(codi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar(1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void buscar(int opcion) {
        String nombre = "";
        Producto objP = new Producto();

        if (opcion == 1) {
            objP = (Producto) comboProductos.getSelectedItem();
            nombre = objP.getDescripcion();
        } else {
            nombre = txtCodigo.getText();

            for (Producto p : plist) {
                if (p.getCodigo().equals(nombre)) {
                    objP = p;
                    break;
                }
            }
        }

        if (nombre.equalsIgnoreCase("")) {
            mensaje("Por favor ingresa los datos solicitados");
        } else {

           

            if (objP == null) {
                mensaje("Código no encontrado, por favor vuelve a intentarlo");
            } else {
                txtCodigo.setText(objP.getCodigo());
                txtNombre.setText(objP.getDescripcion());
                txtPrecioCosto.setText(objP.getPrecioCosto()+"");
                txtPrecioVenta.setText(objP.getPrecioVenta()+"");
                txtPrecioMayoreo.setText(objP.getPrecioMayoreo()+"");
                txtExistencia.setText(objP.getCantidad()+"");
                txtPrecioDistribuidor.setText(objP.getPrecioDistribuidor()+"");
            }
        }
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Area area = (Area) comboAreas.getSelectedItem();
        if (area.getIdArea()==0) {
            Utilidades.mensajePorTiempo("Selecciona un área por favor o revisa si el área ingresado se encuentra registrada");
        } else {
       
                
             ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos/" + Datos.idSucursal);
                if (res.getProductos().isEmpty()) {
                    Utilidades.mensajePorTiempo("No se encontrarón productos en esa área");
                } else {
                  
                    String modelo = objImprimir.convertirModeloParaInventario(res.getProductos(), area.getNombre());
                    objImprimir.imprimirTicket(modelo);
                }

         
        }
        llenarComboArea();
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void mensaje(String men) {
        confir.setMensaje(men);
        confir.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confir.dispose();
                comboProductos.requestFocus();
            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    public void agregar() {
        String a[] = new String[3];
        a[0] = txtExistencia.getText();
        a[1] = txtAgregar.getText();
        a[2] = txtCodigo.getText();
        boolean ban = Utilidades.hayVacios(a);
        if (ban == false) {
            try {
                float total = Float.parseFloat(a[0]) + Float.parseFloat(a[1]);
                String x = "";
                Producto pinv=(Producto)comboProductos.getSelectedItem();
                pinv.setCantidad(total);
                ResponseGeneral res = api.usarAPI(EnviromentLocal.urlG + "productos", pinv, "PUT");
                mensaje(res.getMensaje());
               
                if (res.isRealizado()==true) {
                    llenarCombo();
                    limpiar();

                }
            
            } catch (NumberFormatException e) {

                mensaje("Por favor revisa los datos agregados");

            }

        } else {
            mensaje("Por favor ingresa la cantidad a agregar");
        }
    }
    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        buscar(2);
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        agregar();
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar(1);
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void comboAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreasActionPerformed

    }//GEN-LAST:event_comboAreasActionPerformed

    private void btnAgregar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1KeyPressed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agrega;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel codi;
    private javax.swing.JLabel codi1;
    private javax.swing.JLabel codiso;
    private javax.swing.JComboBox<Area> comboAreas;
    private javax.swing.JComboBox<Producto> comboProductos;
    private javax.swing.JLabel des;
    private javax.swing.JLabel exis;
    private javax.swing.JLabel preco;
    private javax.swing.JLabel prema;
    private javax.swing.JLabel prema1;
    private javax.swing.JLabel preve;
    private javax.swing.JLabel titu;
    private javax.swing.JTextField txtAgregar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCosto;
    private javax.swing.JTextField txtPrecioDistribuidor;
    private javax.swing.JTextField txtPrecioMayoreo;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
