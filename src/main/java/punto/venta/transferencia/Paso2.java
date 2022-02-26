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
import punto.venta.dao.ActualizacionDAO;
import punto.venta.dao.Conexion;
import punto.venta.dao.SucursalDAO;
import punto.venta.dialogos.BusquedaProductos;
import punto.venta.misclases.TransferenciaProductos;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class Paso2 extends javax.swing.JPanel {

    TransferenciaProductos trans;
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    DefaultTableModel md;
    DefaultTableModel mdSeleccionados;
    String data[][] = {};
    String cabeza[] = {"Código", "Descripción", "Inventario", "precioCompra"};
    String cabezaSeleccionados[] = {"Código", "Descripción", "Inventario", "Cantidad", "precioCompra"};
    SucursalDAO sucursales = new SucursalDAO();

    public Paso2() {
        initComponents();
        md = new DefaultTableModel();
        mdSeleccionados = new DefaultTableModel();
        this.tablaInventario.setModel(md);
        this.tablaSeleccionados.setModel(mdSeleccionados);

        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdSeleccionados = new DefaultTableModel(data, cabezaSeleccionados) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        configurarTablas();
        llenarTabla();

    }

    public void requerirFoco() {
        // txtCodigo.setFocusable(true);
        // txtCodigo.requestFocus();
    }

    public void configurarTablas() {
        JTableHeader tablaCabe = tablaInventario.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer) tablaInventario.getTableHeader().getDefaultRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCabe.setDefaultRenderer(render);
        tablaInventario.setModel(md);
        dt.setHorizontalAlignment(SwingConstants.CENTER);
        tablaInventario.getColumnModel().getColumn(0).setCellRenderer(dt);
        tablaInventario.getColumnModel().getColumn(0).setWidth(100);
        tablaInventario.getColumnModel().getColumn(0).setMinWidth(100);
        tablaInventario.getColumnModel().getColumn(0).setMaxWidth(100);

        tablaInventario.getColumnModel().getColumn(1).setCellRenderer(dt);
        tablaInventario.getColumnModel().getColumn(1).setWidth(360);
        tablaInventario.getColumnModel().getColumn(1).setMinWidth(360);
        tablaInventario.getColumnModel().getColumn(1).setMaxWidth(360);

        tablaInventario.getColumnModel().getColumn(2).setCellRenderer(dt);
        tablaInventario.getColumnModel().getColumn(2).setWidth(100);
        tablaInventario.getColumnModel().getColumn(2).setMinWidth(100);
        tablaInventario.getColumnModel().getColumn(2).setMaxWidth(100);

        tablaInventario.getColumnModel().getColumn(3).setCellRenderer(dt);
        tablaInventario.getColumnModel().getColumn(3).setWidth(0);
        tablaInventario.getColumnModel().getColumn(3).setMinWidth(0);
        tablaInventario.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaInventario.setRowHeight(30);

        tablaInventario.setRowSelectionAllowed(true);
        tablaInventario.setColumnSelectionAllowed(false);

        JTableHeader tablaCabe2 = tablaSeleccionados.getTableHeader();
        DefaultTableCellRenderer render2 = (DefaultTableCellRenderer) tablaSeleccionados.getTableHeader().getDefaultRenderer();
        render2.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCabe2.setDefaultRenderer(render);
        tablaSeleccionados.setModel(mdSeleccionados);
        tablaSeleccionados.getColumnModel().getColumn(0).setCellRenderer(dt);
        tablaSeleccionados.getColumnModel().getColumn(0).setWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(0).setMinWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(0).setMaxWidth(120);

        tablaSeleccionados.getColumnModel().getColumn(1).setCellRenderer(dt);
        tablaSeleccionados.getColumnModel().getColumn(1).setWidth(390);
        tablaSeleccionados.getColumnModel().getColumn(1).setMinWidth(390);
        tablaSeleccionados.getColumnModel().getColumn(1).setMaxWidth(390);

        tablaSeleccionados.getColumnModel().getColumn(2).setCellRenderer(dt);
        tablaSeleccionados.getColumnModel().getColumn(2).setWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(2).setMinWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(2).setMaxWidth(120);

        tablaSeleccionados.getColumnModel().getColumn(3).setCellRenderer(dt);
        tablaSeleccionados.getColumnModel().getColumn(3).setWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(3).setMinWidth(120);
        tablaSeleccionados.getColumnModel().getColumn(3).setMaxWidth(120);

        tablaSeleccionados.getColumnModel().getColumn(4).setCellRenderer(dt);
        tablaSeleccionados.getColumnModel().getColumn(4).setWidth(0);
        tablaSeleccionados.getColumnModel().getColumn(4).setMinWidth(0);
        tablaSeleccionados.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaSeleccionados.setRowHeight(30);

        tablaSeleccionados.setRowSelectionAllowed(true);
        tablaSeleccionados.setColumnSelectionAllowed(false);
    }

    public void limpiarTabla() {
        int filas = md.getRowCount();
        for (int i = 0; filas > i; i++) {
            md.removeRow(0);
        }
    }

    public void llenarTabla() {
        limpiarTabla();
        try {
            ResultSet res = sucursales.obtenerProductosPorSucursal();
            res.last();
            if (res.getRow() != 0) {
                res.beforeFirst();
                String datos[] = new String[4];
                while (res.next()) {
                    datos[0] = res.getString("codigo");
                    datos[1] = res.getString("descripcion");
                    datos[2] = res.getString("cantidad");
                    datos[3] = res.getString("precioCosto");
                    md.addRow(datos);
                }
            }
        } catch (SQLException ex) {
           
            Logger.getLogger(Paso1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setTrans(TransferenciaProductos trans) {
        this.trans = trans;
    }

    public TransferenciaProductos getTrans() {
        return this.trans;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeleccionados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Productos seleccionados:");

        tablaSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSeleccionados.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablaSeleccionados);
        tablaSeleccionados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaSeleccionados.getColumnModel().getColumnCount() > 0) {
            tablaSeleccionados.getColumnModel().getColumn(0).setResizable(false);
        }

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Inventario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInventario.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaInventario);
        tablaInventario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaInventario.getColumnModel().getColumnCount() > 0) {
            tablaInventario.getColumnModel().getColumn(0).setResizable(false);
            tablaInventario.getColumnModel().getColumn(1).setResizable(false);
            tablaInventario.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Selecciona los productos de la tabla o realiza una busqueda avanzada para seleccionar un artículo.");

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Terminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Eliminar producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Seleccionar producto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Si el inventario esta en 0, no aparecerá el producto");

        jButton5.setBackground(new java.awt.Color(0, 51, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar producto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(382, 382, 382))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 105, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGap(685, 685, 685)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel2)
                    .addContainerGap(465, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //llenar datos en el modelo
        trans.setMd((DefaultTableModel) tablaSeleccionados.getModel());

        int total = tablaSeleccionados.getRowCount();
        boolean permitirTermino = true;
        if (total > 0) {
            int i = 0;
            while (i < total) {
                double inv = 0.0d;
                double can = 0.0d;
                try {
                    inv = Double.parseDouble((String) tablaSeleccionados.getValueAt(i, 2));
                    can = Double.parseDouble((String) tablaSeleccionados.getValueAt(i, 3));
                } catch (Exception e) {
                 
                    System.out.println(e.getLocalizedMessage());
                    permitirTermino = false;
                }

                if (can > inv) {
                    permitirTermino = false;
                    break;
                }

                i++;
            }
            if (permitirTermino == true) {
                String mensaje = sucursales.realizarTraspaso(trans);
                Utilidades.mensajePorTiempo(mensaje);
                limpiarSeleccionados();
                if (mensaje.equalsIgnoreCase("La transferencia se realizado correctamente")) {
                    ActualizacionDAO act = new ActualizacionDAO();
                    act.buscarNubeProductosModificacionesEliminaciones();
                    regresar();
                }
            } else {
                Utilidades.mensajePorTiempo("Por favor revisa tu información ingresada, recuerde que la cantidad no debe superar lo que se tiene en inventario");
            }
        } else {
            Utilidades.mensajePorTiempo("Tienes que seleccionar por lo menos un producto");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public void limpiarSeleccionados() {

        for (int i = 0; i < mdSeleccionados.getRowCount(); i++) {
            mdSeleccionados.removeRow(i);
        }
    }

    public void regresar() {
        this.setVisible(false);
        TransferenciaEstructura.transferencia.getContenedor().add(TransferenciaEstructura.transferencia.getPaso1());
        TransferenciaEstructura.transferencia.getPaso1().setVisible(true);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        regresar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int rowSeleccionados = tablaSeleccionados.getSelectedRow();

        if (rowSeleccionados != -1) {
            mdSeleccionados.removeRow(rowSeleccionados);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int rowInventario = tablaInventario.getSelectedRow();
        String datos[] = new String[5];
        if (rowInventario != -1) {
            datos[0] = (String) tablaInventario.getValueAt(rowInventario, 0);
            String res = buscarCodigoEnTabla(datos[0]);

            datos[1] = (String) tablaInventario.getValueAt(rowInventario, 1);
            datos[2] = (String) tablaInventario.getValueAt(rowInventario, 2);
            datos[3] = "";
            datos[4] = (String) tablaInventario.getValueAt(rowInventario, 3);
            if (res.equalsIgnoreCase("Correcto")) {
                mdSeleccionados.addRow(datos);
            } else {
                Utilidades.mensajePorTiempo(res);
            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        BusquedaProductos bus = new BusquedaProductos(this, 2);
        bus.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    public String buscarCodigoEnTabla(String codigo) {

        int total = mdSeleccionados.getRowCount();
        int i = 0;
        while (i < total) {
            String cod = (String) tablaSeleccionados.getValueAt(i, 0);
            if (cod.equalsIgnoreCase(codigo)) {
                return "El producto ya se encuentra en la tabla de productos seleccionados";
            }
            i++;
        }
        return "Correcto";
    }

    public void agregarDesdeTablaExterna(String nombre) {
        nombre = nombre.trim();
        if (nombre.equalsIgnoreCase("")) {
            Utilidades.mensajePorTiempo("Por favor ingresa el nombre del producto");
        } else {
            try {
                ResultSet producto = sucursales.obtenerProductoPorNombre(nombre);
                producto.last();
                if (producto.getRow() != 0) {
                    producto.beforeFirst();
                    producto.next();
                    double can = Double.parseDouble(producto.getString("cantidad"));
                    if (can > 0) {
                        String pro[] = new String[5];
                        pro[0] = producto.getString("codigo");
                        pro[1] = producto.getString("descripcion");
                        pro[2] = "" + can;
                        pro[3] = "";
                        pro[4] = producto.getString("precioCosto");
                        String res = buscarCodigoEnTabla(pro[0]);

                        if (res.equalsIgnoreCase("correcto")) {
                            mdSeleccionados.addRow(pro);
                            Utilidades.mensajePorTiempo("El producto ha sido agregado correctamente");
                        } else {
                            Utilidades.mensajePorTiempo(res);
                        }
                    } else {
                        Utilidades.mensajePorTiempo("No tienes inventario en ese producto");
                    }
                } else {
                    Utilidades.mensajePorTiempo("Producto no encontrado");
                }

            } catch (SQLException ex) {
               
                Logger.getLogger(Paso2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JTable tablaSeleccionados;
    // End of variables declaration//GEN-END:variables
}
