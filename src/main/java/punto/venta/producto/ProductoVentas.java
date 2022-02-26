/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dao.VentasDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.misclases.CrearExcel;
import punto.venta.modelo.Ventas;
import punto.venta.modelo.ModeloFechas;
import punto.venta.modelo.response.VentasResponse;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ProductoVentas extends javax.swing.JPanel {

   VentasDAO objVen = new VentasDAO();
   Confirmacion confirma = new Confirmacion();
   ApiSend api = new ApiSend();
    DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatoHora=new SimpleDateFormat("HH:mm:ss");
   
    public ProductoVentas() {
        initComponents();
        ImageIcon lupa = new ImageIcon("iconos/lupa.png");
        ImageIcon excel = new ImageIcon("iconos/excel.png");
        btnGenerarExcel.setIcon(excel);
        btnBuscar.setIcon(lupa);
        btnBuscarLapso.setIcon(lupa);
    }
    
     public void requerirFoco(){
    combo.setFocusable(true);
    combo.requestFocus();
    }
    
public void llenaTabla() throws SQLException {

        String tipo = (String) combo.getSelectedItem();
        int tipoBusqueda = 0;
        switch (tipo) {
            case "Hoy":
                tipoBusqueda = 1;
                break;
            case "Ayer":
                tipoBusqueda = 2;
                break;
            case "Hace una semana":
                tipoBusqueda = 3;
                break;
            case "Hace un mes":
                tipoBusqueda = 4;
                break;
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código de Barras");
        modelo.addColumn("Descripción del producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio venta");
        modelo.addColumn("fecha");
        modelo.addColumn("hora");
        
        VentasResponse resp=api.getVentas(EnviromentLocal.urlG+"ventas-lapso/"+tipoBusqueda+"/"+Datos.idSucursal);
        List<Ventas> listaV=resp.getVentas();
        
        double total = 0.0d;
        String x[] = new String[6];
        if (listaV.isEmpty()) {
           mensaje("No hay ventas en la fecha seleccionada");
        } else {
           for(Ventas v: listaV){
                x[0] = v.getCodigo();
                x[1] = v.getNombre();
                x[2] = v.getCantidad()+"";
                x[3] = v.getPrecioVenta()+"";
                x[4] = formatoFecha.format(v.getFecha());
                x[5] = formatoHora.format(v.getFecha());
                modelo.addRow(x);
                total = total + v.getImporte();
           }

            tabla_ventas.setModel(modelo);
            txttotalvendido.setText(total + "");

        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        txttotalvendido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        btnBuscarLapso = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        btnGenerarExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1365, 344));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("REPORTE DE PRODUCTOS VENDIDOS");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Mostrar ventas de:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoy", "Ayer", "Hace una semana", "Hace un mes", " " }));
        combo.setMaximumSize(new java.awt.Dimension(173, 20));

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Total vendido:");

        btnBuscar.setBackground(new java.awt.Color(255, 153, 51));
        btnBuscar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(120, 27));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        fechaInicio.setMaximumSize(new java.awt.Dimension(160, 35));
        fechaInicio.setDateFormatString("yyyy-MM-dd");

        fechaFin.setMaximumSize(new java.awt.Dimension(160, 35));
        fechaFin.setMinimumSize(new java.awt.Dimension(100, 35));
        fechaFin.setDateFormatString("yyyy-MM-dd");

        btnBuscarLapso.setBackground(new java.awt.Color(255, 102, 0));
        btnBuscarLapso.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBuscarLapso.setText("Buscar por lapso");
        btnBuscarLapso.setMaximumSize(new java.awt.Dimension(120, 27));
        btnBuscarLapso.setMinimumSize(new java.awt.Dimension(120, 27));
        btnBuscarLapso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLapsoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Fecha inicio");

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setText("Fecha fin");

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción del Producto", "Cantidad", "Precio de Venta"
            }
        ));
        jScrollPane1.setViewportView(tabla_ventas);

        btnGenerarExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerarExcel.setText("Genera Excel");
        btnGenerarExcel.setMaximumSize(new java.awt.Dimension(160, 35));
        btnGenerarExcel.setMinimumSize(new java.awt.Dimension(140, 25));
        btnGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel6)
                                .addGap(245, 245, 245)
                                .addComponent(jLabel5)
                                .addGap(155, 155, 155)
                                .addComponent(jLabel9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(btnBuscarLapso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnGenerarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarLapso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttotalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try { 
            llenaTabla();
        } catch (SQLException ex) {
          mensaje("Hubo error con la conexion a la base de datos");
          
         

        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarLapsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLapsoActionPerformed

   
            Date inicio = fechaInicio.getDate();
            Date fin = fechaFin.getDate();
            
           if(inicio == null || fin == null){
               Utilidades.mensajePorTiempo("Por favor ingresa la fecha de inicio y la fecha final");
           }else{
              ModeloFechas fechs= new ModeloFechas();
              fechs.setFechaI(formatoFecha.format(inicio));
              fechs.setFechaF(formatoFecha.format(fin));
              
              VentasResponse ven=api.getVentas(EnviromentLocal.urlG+"ventas-fiff", fechs);
              Utilidades.im(EnviromentLocal.urlG+"ventas-fiff");
              List<Ventas>listaV= ven.getVentas();
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código de Barras");
            modelo.addColumn("Descripción del producto");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio venta");
            modelo.addColumn("fecha");
            modelo.addColumn("hora");
            
            double total = 0.0d;
            String x[] = new String[6];
            if (listaV.isEmpty()) {
                Utilidades.mensajePorTiempo("No hay datos de ventas en esa fecha especifica");
            } else {
               

                for (Ventas v: listaV) {
                    x[0] = v.getCodigo();
                x[1] = v.getNombre();
                x[2] = v.getCantidad()+"";
                x[3] = v.getPrecioVenta()+"";
                x[4] = formatoFecha.format(v.getFecha());
                x[5] = formatoHora.format(v.getFecha());
                    modelo.addRow(x);
                    total = total + v.getImporte();
                    
                }

                tabla_ventas.setModel(modelo);
                txttotalvendido.setText(total + "");

            }
           }
 
       
        
    }//GEN-LAST:event_btnBuscarLapsoActionPerformed

      public void mensaje(String men){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
    }

    private void btnGenerarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarExcelActionPerformed
            Date inicio = fechaInicio.getDate();
            Date fin = fechaFin.getDate();
        
           if(inicio == null || fin == null){
               mensaje( "Por favor ingresa la fecha de inicio y la fecha final");
           }else{
            try {
                 ModeloFechas fechs= new ModeloFechas();
              fechs.setFechaI(formatoFecha.format(inicio));
              fechs.setFechaF(formatoFecha.format(fin));
              
              VentasResponse ven=api.getVentas(EnviromentLocal.urlG+"ventas-fiff", fechs);
              Utilidades.im(EnviromentLocal.urlG+"ventas-fiff");
              List<Ventas>listaV= ven.getVentas();;
                CrearExcel objE = new CrearExcel();
                
                
                if (listaV.isEmpty()) {
                    mensaje( "No hay datos de ventas en esa fecha especifica");
                }else{
                   
                    objE.writeExcelVentas(listaV, inicio,  fin);
                }
                
              
            } catch (SQLException ex) {
                     
                 Utilidades.im(ex.getLocalizedMessage());
            } catch (Exception ex) {
                     
                 mensaje( "Ocurrio un error en el sistema");
                Utilidades.im(ex.getMessage());
            }
           
                 
           }
    }//GEN-LAST:event_btnGenerarExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarLapso;
    private javax.swing.JButton btnGenerarExcel;
    private javax.swing.JComboBox<String> combo;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_ventas;
    private javax.swing.JTextField txttotalvendido;
    // End of variables declaration//GEN-END:variables
}
