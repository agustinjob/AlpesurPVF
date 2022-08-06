/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;

import punto.venta.dao.VentasDAO;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.misclases.ImprimirTicket;
import punto.venta.modelo.Ventas;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.modelo.response.VentasResponse;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;

/**
 *
 * @author agus_
 */
public class Devoluciones extends javax.swing.JFrame {

    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    VentasDAO v = new VentasDAO();
    Confirmacion confir;
    String idTicket = "";
    String fecha, hora = "";
    VentasEstructura ventas;
    ApiSend api = new ApiSend();

    public Devoluciones(VentasEstructura ventas) {
        initComponents();
        setTitle("Devoluciones");
        setLocationRelativeTo(null);
        this.ventas = ventas;

        seleccionaFecha.setDate(d);
        //ancho,largo
        setSize(350, 500);
            ImageIcon logo = new ImageIcon("iconos/lavicentina.jpg");
        this.setIconImage(logo.getImage());

    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {

            Utilidades.confirma(confir, "Error al limpiar la tabla");
        }
    }

    public void actualizarTabla() {

        DefaultTableModel m = (DefaultTableModel) tablaTickets.getModel();
        limpiarTabla(tablaTickets);
        String x[] = new String[3];

        Date fechas = seleccionaFecha.getDate();
        VentasResponse res = api.getVentas(EnviromentLocal.urlG + "ventas/" + formatoFecha.format(fechas)+"/"+Datos.idSucursal);
        List<Ventas> lista = res.getVentas();

        if (lista.isEmpty()) {
            Utilidades.mensajePorTiempo("No hay datos en esa fecha");
        } else {
            for (Ventas v : lista) {

                x[0] = v.getIdTicket() + "";
                x[1] = formatoFecha.format(v.getFecha());
                x[2] = formatoHora.format(v.getFecha());
                m.addRow(x);
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        seleccionaFecha = new com.toedter.calendar.JDateChooser();
        btnbuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new javax.swing.JTable();
        txtOcultar1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Devoluciones");

        seleccionaFecha.setBackground(new java.awt.Color(0, 0, 102));
        seleccionaFecha.setForeground(new java.awt.Color(255, 255, 255));
        seleccionaFecha.setDateFormatString("yyyy-MM-dd");
        seleccionaFecha.setFont(new java.awt.Font("Cambria", 1, 11)); // NOI18N
        seleccionaFecha.setPreferredSize(new java.awt.Dimension(170, 35));

        btnbuscar1.setBackground(new java.awt.Color(0, 0, 102));
        btnbuscar1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnbuscar1.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar1.setText("Buscar");
        btnbuscar1.setBorder(null);
        btnbuscar1.setPreferredSize(new java.awt.Dimension(150, 35));
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        tablaTickets.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaTickets.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTicketseventoClickTablaTickets(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTickets);
        if (tablaTickets.getColumnModel().getColumnCount() > 0) {
            tablaTickets.getColumnModel().getColumn(0).setResizable(false);
            tablaTickets.getColumnModel().getColumn(1).setResizable(false);
            tablaTickets.getColumnModel().getColumn(2).setResizable(false);
        }

        txtOcultar1.setText("Selecciona el articulo que quieres devolver");

        tablaVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Cantidad", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasdevolverCantidadDeArticulos(evt);
            }
        });
        jScrollPane2.setViewportView(tablaVentas);
        if (tablaVentas.getColumnModel().getColumnCount() > 0) {
            tablaVentas.getColumnModel().getColumn(0).setResizable(false);
            tablaVentas.getColumnModel().getColumn(1).setResizable(false);
            tablaVentas.getColumnModel().getColumn(2).setResizable(false);
            tablaVentas.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Devolver todo");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(0, 0, 102));
        btnImprimir.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Imprimir ticket");
        btnImprimir.setPreferredSize(new java.awt.Dimension(150, 35));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(seleccionaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOcultar1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seleccionaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOcultar1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int row = tablaTickets.getSelectedRow();
        if (row < 0) {
            Utilidades.confirma(confir, "Selecciona un ticket");
        } else {
            String id = (String) tablaTickets.getValueAt(row, 0);

            TicketDevolverTodo obj = new TicketDevolverTodo(id, this, fecha, hora,ventas);
            obj.setVisible(true);
          

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaVentasdevolverCantidadDeArticulos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasdevolverCantidadDeArticulos
        int row = tablaVentas.getSelectedRow();

        String codigo = (String) tablaVentas.getValueAt(row, 0);
        String nombre = (String) tablaVentas.getValueAt(row, 1);
        String cantidad = (String) tablaVentas.getValueAt(row, 2);
        String monto = (String) tablaVentas.getValueAt(row, 3);
        
     // Aquí registrar
        Ticket obj = new Ticket(idTicket, codigo, nombre, cantidad, monto, this, fecha, hora,ventas);
        obj.setVisible(true);
    }//GEN-LAST:event_tablaVentasdevolverCantidadDeArticulos

    private void tablaTicketseventoClickTablaTickets(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTicketseventoClickTablaTickets
        setSize(840, 500);
        int row = tablaTickets.getSelectedRow();
        DefaultTableModel m = (DefaultTableModel) tablaTickets.getModel();

        idTicket = (String) m.getValueAt(row, 0);
        fecha = (String) m.getValueAt(row, 1);
        hora = (String) m.getValueAt(row, 2);

        DefaultTableModel m2 = (DefaultTableModel) tablaVentas.getModel();
        limpiarTabla(tablaVentas);
        String x[] = new String[5];

        VentasResponse res = api.getVentas(EnviromentLocal.urlG + "ventas-ticket/" + idTicket + "/" + fecha + "%20" + hora+"/"+Datos.idSucursal);
        System.out.println(EnviromentLocal.urlG + "ventas-ticket/" + idTicket + "/" + fecha + "%20" + hora+"/"+Datos.idSucursal);
        List<Ventas> lista = res.getVentas();

        if (lista==null) {
            
        } else {

            for (Ventas v : lista) {
                x[0] = v.getCodigo();
                x[1] = v.getNombre();
                x[2] = v.getCantidad() + "";
                x[3] = v.getImporte() + "";
                m2.addRow(x);
            }

        }

    }//GEN-LAST:event_tablaTicketseventoClickTablaTickets

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int row = tablaTickets.getSelectedRow();
        if (row < 0) {
            Utilidades.mensajePorTiempo("Tienes que seleccionar un ticket");
        } else {
            String idTick = (String) tablaTickets.getModel().getValueAt(row, 0);
            String fecha = (String) tablaTickets.getModel().getValueAt(row, 1);
            String hora = (String) tablaTickets.getModel().getValueAt(row, 2);
            DefaultTableModel model = (DefaultTableModel) tablaVentas.getModel();
            int i = 0;
            double total = 0.0;
            while (i < model.getRowCount()) {

                total = total + Double.parseDouble((String) model.getValueAt(i, 3));
                i++;
            }
            ImprimirTicket imp = new ImprimirTicket();
            String ticketRes = imp.convertirModeloAStringReimprimirTicket(model, total + "", fecha, hora, idTick);
            imp.imprimirTicket(ticketRes);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser seleccionaFecha;
    private javax.swing.JTable tablaTickets;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel txtOcultar1;
    // End of variables declaration//GEN-END:variables
}
