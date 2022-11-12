/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;

import punto.venta.dao.CorteDAO;
import punto.venta.dao.Datos;
import punto.venta.dao.Movimientos;
import punto.venta.dao.UsuarioDAO;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.CorteModelo;
import punto.venta.modelo.MovimientosExtras;
import punto.venta.modelo.response.MovimientosExtrasResponse;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class CorteEstructura extends javax.swing.JPanel {

    CorteDAO corted = new CorteDAO();
    NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    Movimientos mv = new Movimientos();

    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    ApiSend api = new ApiSend();

    public CorteEstructura() {
        initComponents();
        corteDe.setVisible(false);
        ImageIcon ima = new ImageIcon("iconos/corte_dia.png");
        ImageIcon dinero = new ImageIcon("iconos/dinero_caja.png");
        ImageIcon entrada = new ImageIcon("iconos/entradas_dinero.png");
        ImageIcon salida = new ImageIcon("iconos/salida.png");
        ImageIcon ventaTotal = new ImageIcon("iconos/ventas_totales.png");
        ImageIcon gananciaTotal = new ImageIcon("iconos/ganacias.png");
        fecha.setDate(new Date());
        txtEntrada.setIcon(entrada);
        txtSalida.setIcon(salida);
        txtDinero.setIcon(dinero);
        btnCorte.setIcon(ima);
        txtVentasTotales.setIcon(ventaTotal);
        txtGananciaTotal.setIcon(gananciaTotal);
        panelEnsa.setVisible(false);
        if (UsuarioDAO.getTipo().equalsIgnoreCase("Empleado")) {
            txtGananciaTotal.setVisible(false);
            txtGanancia.setVisible(false);
        }
    }

    public void limpiarTodo() {

    }

    public void requerirFoco() {
        btnCorte.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        corteDe = new javax.swing.JLabel();
        Panelcor = new javax.swing.JPanel();
        txtDinero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDinero = new javax.swing.JTable();
        txtVentasTotales = new javax.swing.JLabel();
        txtGananciaTotal = new javax.swing.JLabel();
        txtVentas = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JLabel();
        panelEnsa = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        txtEntrada = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        txtSalida = new javax.swing.JLabel();
        txtVentasTotales1 = new javax.swing.JLabel();
        txtVentasCredito = new javax.swing.JLabel();
        btnCorte = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        corteDe1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1401, 540));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1365, 450));

        corteDe.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        corteDe.setForeground(new java.awt.Color(0, 0, 204));
        corteDe.setText("Corte de");

        Panelcor.setBackground(new java.awt.Color(255, 255, 255));

        txtDinero.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtDinero.setForeground(new java.awt.Color(102, 0, 51));
        txtDinero.setText("Dinero en Caja");

        tablaDinero.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tablaDinero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Fondo de caja", "0.0"},
                {"Ventas", "0.0"},
                {"Entradas", "0.0"},
                {"Abonos", "0.0"},
                {"Salidas", "0.0"},
                {"Devoluciones", "0.0"},
                {"", "0.0"}
            },
            new String [] {
                "Descripción", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tablaDinero);

        txtVentasTotales.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtVentasTotales.setForeground(new java.awt.Color(0, 0, 153));
        txtVentasTotales.setText("Ventas totales en efectivo");

        txtGananciaTotal.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtGananciaTotal.setForeground(new java.awt.Color(0, 0, 153));
        txtGananciaTotal.setText("Ganancia");

        txtVentas.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtVentas.setForeground(new java.awt.Color(0, 0, 153));
        txtVentas.setText("$ 0.0");

        txtGanancia.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtGanancia.setForeground(new java.awt.Color(0, 0, 153));
        txtGanancia.setText("$ 0.0");

        panelEnsa.setBackground(new java.awt.Color(255, 255, 255));

        tablaEntradas.setFont(new java.awt.Font("Lucida Console", 2, 10)); // NOI18N
        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Monto"
            }
        ));
        tablaEntradas.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tablaEntradas);

        txtEntrada.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtEntrada.setForeground(new java.awt.Color(0, 0, 255));
        txtEntrada.setText("Entradas de efectivo");

        tablaSalidas.setFont(new java.awt.Font("Lucida Console", 2, 10)); // NOI18N
        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Descripcion", "Monto"
            }
        ));
        jScrollPane2.setViewportView(tablaSalidas);

        txtSalida.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtSalida.setForeground(new java.awt.Color(255, 0, 0));
        txtSalida.setText("Salidas de Efectivo");

        javax.swing.GroupLayout panelEnsaLayout = new javax.swing.GroupLayout(panelEnsa);
        panelEnsa.setLayout(panelEnsaLayout);
        panelEnsaLayout.setHorizontalGroup(
            panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnsaLayout.createSequentialGroup()
                .addGroup(panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalida)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelEnsaLayout.setVerticalGroup(
            panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnsaLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(panelEnsaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnsaLayout.createSequentialGroup()
                        .addComponent(txtEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnsaLayout.createSequentialGroup()
                        .addComponent(txtSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        txtVentasTotales1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtVentasTotales1.setForeground(new java.awt.Color(0, 0, 153));
        txtVentasTotales1.setText("Ventas totales a credito");

        txtVentasCredito.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtVentasCredito.setForeground(new java.awt.Color(0, 0, 153));
        txtVentasCredito.setText("$ 0.0");

        javax.swing.GroupLayout PanelcorLayout = new javax.swing.GroupLayout(Panelcor);
        Panelcor.setLayout(PanelcorLayout);
        PanelcorLayout.setHorizontalGroup(
            PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelcorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtVentasTotales)
                            .addComponent(txtGananciaTotal))
                        .addGap(29, 29, 29)
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGanancia, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(txtVentasTotales1)
                        .addGap(18, 18, 18)
                        .addComponent(txtVentasCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDinero))
                        .addGap(37, 37, 37)
                        .addComponent(panelEnsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(698, Short.MAX_VALUE))
        );
        PanelcorLayout.setVerticalGroup(
            PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelcorLayout.createSequentialGroup()
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelcorLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtDinero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelEnsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVentasTotales)
                    .addComponent(txtVentas)
                    .addComponent(txtVentasTotales1)
                    .addComponent(txtVentasCredito))
                .addGap(18, 18, 18)
                .addGroup(PanelcorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGanancia)
                    .addComponent(txtGananciaTotal))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        btnCorte.setBackground(new java.awt.Color(102, 102, 255));
        btnCorte.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorte.setText("Hacer corte del día");
        btnCorte.setBorder(null);
        btnCorte.setPreferredSize(new java.awt.Dimension(200, 35));
        btnCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteActionPerformed(evt);
            }
        });
        btnCorte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCorteKeyPressed(evt);
            }
        });

        panelTicket.setBackground(new java.awt.Color(204, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CORTE");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        corteDe1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        corteDe1.setForeground(new java.awt.Color(0, 0, 204));
        corteDe1.setText("Seleccionar fecha:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Panelcor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(corteDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(corteDe, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(corteDe))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(corteDe1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panelcor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteActionPerformed
        if (fecha.getDate() != null) {
            String fech = Utilidades.getFechaString(fecha.getDate());
            hacerCorte();
        } else {
            Utilidades.mensajePorTiempo("Selecciona una fecha por favor");
        }

    }//GEN-LAST:event_btnCorteActionPerformed

    private void btnCorteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCorteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hacerCorte();
        }
    }//GEN-LAST:event_btnCorteKeyPressed
    public void hacerCorte() {

        String x[] = new String[6];
        //  x = corted.getDatosPorDia();
        String fechaS = Utilidades.getFechaString(fecha.getDate());
        CorteModelo corte = api.getCorteModeloGET(EnviromentLocal.urlG + "corte-dia/" + UsuarioDAO.idUsuario + "/" + fechaS + "/" + Datos.idSucursal);
        tablaDinero.setValueAt("+ " + formatoImporte.format(Float.parseFloat(corte.getDineroCaja())), 0, 1);
        tablaDinero.setValueAt("+ " + formatoImporte.format(Float.parseFloat(corte.getVentas())), 1, 1);
        tablaDinero.setValueAt("+ " + formatoImporte.format(Float.parseFloat(corte.getEntradas())), 2, 1);
        tablaDinero.setValueAt("+ " + formatoImporte.format(Float.parseFloat(corte.getAbonos())), 3, 1);
        tablaDinero.setValueAt("- " + formatoImporte.format(Float.parseFloat(corte.getSalidas())), 4, 1);
        tablaDinero.setValueAt("- " + formatoImporte.format(Float.parseFloat(corte.getDevoluciones())), 5, 1);
        float total = Float.parseFloat(corte.getDineroCaja()) + Float.parseFloat(corte.getVentas()) + Float.parseFloat(corte.getEntradas())
                + Float.parseFloat(corte.getAbonos()) - Float.parseFloat(corte.getSalidas()) - Float.parseFloat(corte.getDevoluciones());
        tablaDinero.setValueAt(formatoImporte.format(total), 6, 1);

        double gananciaNeta = Float.parseFloat(corte.getVentas()) - Float.parseFloat(corte.getCosto());
        txtVentas.setText(formatoImporte.format(Float.parseFloat(corte.getVentas())));

        //new DecimalFormat("#.##").format(gananciaNeta)
        txtGanancia.setText(formatoImporte.format(gananciaNeta));
        txtVentasCredito.setText(corte.getVentasACredito());
        corteDe.setText("Corte de " + UsuarioDAO.username + " finalizado a las " + formatoHora.format(new Date()));
        corteDe.setVisible(true);

        //DefaultTableModel entrada = new DefaultTableModel();
        llenarTabla(1);
        llenarTabla(2);
        panelEnsa.setVisible(true);
    }

    public void ocultarPanel() {
        panelEnsa.setVisible(false);
    }

    public void llenarTabla(int tipo) {
   
            DefaultTableModel modelo = null;
            String tipoLLamada = "";
            if (tipo == 1) {
                modelo = (DefaultTableModel) tablaEntradas.getModel();
                limpiarTabla(tablaEntradas);
                tipoLLamada = "entrada_efectivo";
            } else {
                modelo = (DefaultTableModel) tablaSalidas.getModel();
                limpiarTabla(tablaSalidas);
                tipoLLamada = "salida_efectivo";
            }

            MovimientosExtras obj = new MovimientosExtras();
            obj.setTipo(tipoLLamada);
            MovimientosExtrasResponse res = api.getMovimientosExtras(EnviromentLocal.urlG + "movimientos-fecha", obj);
            List<MovimientosExtras> lista = res.getMovimientos();
            String[] x = new String[2];

            if (lista.isEmpty()) {
                System.out.println("Esta vacio");
            } else {
                    for (MovimientosExtras m : lista) {
                        x[0] = m.getDescripcion();
                        x[1] = m.getMonto() + "";
                        modelo.addRow(x);
                    }

                    if (tipo == 1) {
                        tablaEntradas.setModel(modelo);

                    } else {
                        tablaSalidas.setModel(modelo);
                    }
                

            }
        

    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelcor;
    private javax.swing.JButton btnCorte;
    private javax.swing.JLabel corteDe;
    private javax.swing.JLabel corteDe1;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelEnsa;
    private javax.swing.JPanel panelTicket;
    private javax.swing.JTable tablaDinero;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTable tablaSalidas;
    private javax.swing.JLabel txtDinero;
    private javax.swing.JLabel txtEntrada;
    private javax.swing.JLabel txtGanancia;
    private javax.swing.JLabel txtGananciaTotal;
    private javax.swing.JLabel txtSalida;
    private javax.swing.JLabel txtVentas;
    private javax.swing.JLabel txtVentasCredito;
    private javax.swing.JLabel txtVentasTotales;
    private javax.swing.JLabel txtVentasTotales1;
    // End of variables declaration//GEN-END:variables
}
