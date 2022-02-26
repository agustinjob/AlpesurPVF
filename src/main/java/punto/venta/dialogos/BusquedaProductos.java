/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.ProductoDAO;
import punto.venta.dao.UsuarioDAO;
import punto.venta.transferencia.Paso2;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.Estructura;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.ventanas.VentasEstructura;
import punto.venta.modelo.Producto;
import punto.venta.modelo.response.*;

/**
 *
 * @author agus_
 */
public class BusquedaProductos extends javax.swing.JFrame {

    ProductoDAO producto = new ProductoDAO();
    DefaultTableModel model;
    VentasEstructura ventas;
    Paso2 paso2;
    UsuarioDAO usu = new UsuarioDAO();
    Confirmacion confirma = new Confirmacion();
    boolean sePuede = false;
    String text, textTemp = "";
    int indexTab = 0;
    int longiTemp = 0;
    int opcion = 0;
    ApiSend api = new ApiSend();

    public BusquedaProductos(VentasEstructura ventas, int opcion) {
        initComponents();
        this.ventas = ventas;
        this.opcion = opcion;
        inicializacionGeneral();
    }

    public BusquedaProductos(Paso2 paso2, int opcion) {
        initComponents();
        this.opcion = opcion;
        this.paso2 = paso2;
        inicializacionGeneral();
    }

    public void inicializacionGeneral() {
        setLocationRelativeTo(null);
        setTitle("Busqueda");
        ImageIcon modificar = new ImageIcon("iconos/modificar_datos.png");
        ImageIcon eliminar = new ImageIcon("iconos/bote_basura.png");
        ImageIcon registrar = new ImageIcon("iconos/check.png");
        ImageIcon salir = new ImageIcon("iconos/cancelar.png");

        texto.requestFocus();
        jButton3.setIcon(registrar);
        jButton1.setIcon(modificar);
        jButton2.setIcon(eliminar);
        jButton4.setIcon(salir);
        texto.requestFocus();
        if (UsuarioDAO.getTipo().equalsIgnoreCase("Empleado") || opcion == 2) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);

        }
    }

    public void requerirFoco() {
        texto.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        texto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(12, 53, 62));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BUSQUEDA DE PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );

        texto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoKeyTyped(evt);
            }
        });

        tablaProductos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción del producto", "Precio venta", "Inventario", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setRowHeight(25);
        tablaProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(25);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(25);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 153));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 153));
        jButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ENTER - Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 153));
        jButton4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ESC - Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(texto))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void limpiarTabla() {
        DefaultTableModel tm = (DefaultTableModel) tablaProductos.getModel();
        int r = 0;
        while (tm.getRowCount() > r) {
            tm.removeRow(r);
        }
    }
    private void tablaProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarEnTablaVentas();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }

    }//GEN-LAST:event_tablaProductosKeyPressed
    public void agregarEnTablaVentas() {
        int row = tablaProductos.getSelectedRow();

        if (row < 0) {
            mensaje("Por favor selecciona un producto", 2);
        } else {

            String nombre = (String) model.getValueAt(row, 3);
            if (opcion == 1) {
                ventas.agregarDesdeTablaExterna(nombre);
                mensaje("Producto agregado correctamente", 1);
            } else {
                paso2.agregarDesdeTablaExterna(nombre);
                Utilidades.mensajePorTiempo("Producto agregado correctamente");
            }

            limpiarTabla();
            this.dispose();
        }

    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tablaProductos.getSelectedRow();
        if (row < 0) {
            mensaje("Por favor selecciona un producto", 2);
        } else {
            String idProducto = (String) model.getValueAt(row, 3);
            if (opcion == 1) {
                ventas.agregarDesdeTablaExterna(idProducto);
                mensaje("Producto agregado correctamente", 1);
            } else {
                paso2.agregarDesdeTablaExterna(idProducto);

            }

            limpiarTabla();
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        Utilidades.im("Desde busqueda productos " + evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void textoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarEnTablaVentas();
        }

        modificaSelectTabla(evt.getKeyCode(), texto.getText().length());

    }//GEN-LAST:event_textoKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void textoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN) {
            
                String cad= texto.getText().equalsIgnoreCase("")==true?"a":texto.getText();
                ProductoResponse res=api.getProductos(EnviromentLocal.urlG+"productos-caracter/"+cad);
                System.out.println(EnviromentLocal.urlG+"productos-caracter/"+cad);
                List<Producto> lista=res.getProductos();
                model = (DefaultTableModel) tablaProductos.getModel();
                int r = 0;

                while (model.getRowCount() > r) {
                    model.removeRow(r);
                }

                int i = 0;
                String a[] = new String[4];
                for (Producto p: lista) {
                    a[0] = p.getDescripcion();
                    a[1] = p.getPrecioVenta()+"";
                    a[2] = p.getCantidad()+"";
                    a[3] = p.getIdProducto()+"";
                    model.addRow(a);
                    i++;

                }
                if (model.getRowCount() > 0) {
                    tablaProductos.changeSelection(0, 0, false, false);
                }
        }
          
    }//GEN-LAST:event_textoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tablaProductos.getSelectedRow();

        if (row < 0) {
            mensaje("Por favor selecciona un producto", 2);
        } else {

            String id = (String) model.getValueAt(row, 3);
            Estructura es = ventas.getEstructura();
            es.getEstructuraProducto().asigna(1, es, id);
            limpiarTabla();
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tablaProductos.getSelectedRow();
        if (row < 0) {
            mensaje("Por favor selecciona un producto", 2);
        } else {

            String id = (String) model.getValueAt(row, 0);
            Estructura es = ventas.getEstructura();
            es.getEstructuraProducto().asigna(2, es, id);
            limpiarTabla();
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void mensaje(String men, int tipo) {
        confirma.setMensaje(men);
        confirma.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                if (tipo == 1) {
                    ventas.requerirFoco();
                } else {
                    texto.requestFocus();
                }
            }

        });

        timer.setRepeats(false);
        timer.start();

    }

    public void modificaSelectTabla(int num, int longi) {
        if (longi != longiTemp) {
            indexTab = 0;
            longiTemp = longi;
        }
        if (num == KeyEvent.VK_UP) {
            if (indexTab != 0) {
                indexTab--;
            }
        }

        if (num == KeyEvent.VK_DOWN) {
            if (indexTab != tablaProductos.getModel().getRowCount() - 1) {
                indexTab++;
            }
        }
        tablaProductos.changeSelection(indexTab, 0, false, false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
