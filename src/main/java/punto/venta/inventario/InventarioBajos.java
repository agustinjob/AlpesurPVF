/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.inventario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dao.ProductoDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.response.*;
import punto.venta.modelo.Producto;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class InventarioBajos extends javax.swing.JPanel {

    ProductoDAO obj = new ProductoDAO();
    Confirmacion confir;
    ApiSend api = new ApiSend();
    public InventarioBajos() {
        initComponents();
       
    }
    
 public void generaTabla(){
    String cabeza[] = {"Código", "Descripcion de producto", "Cantidad", "Precio de venta"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código de Barras");
        modelo.addColumn("Descripción del producto");
        modelo.addColumn("Precio venta");
        modelo.addColumn("Existencia");
        modelo.addColumn("Inventario minimo");
    
         ProductoResponse data = api.getProductos(EnviromentLocal.urlG + "productos-inv-bajo/" + Datos.idSucursal);
         System.out.println(EnviromentLocal.urlG + "productos-inv-bajo/" + Datos.idSucursal);
         List<Producto> prods= data.getProductos();

        
               String x[] = new String[5];
 
            if (prods.isEmpty()) {
              Utilidades.mensajePorTiempo("No tienes productos con inventario bajo");
            } else {
             
                
                for (Producto p: prods) {
                    x[0]=p.getCodigo();
                    x[1]=p.getDescripcion();
                    x[2]=p.getPrecioVenta()+"";
                    x[3]=p.getCantidad()+"";
                    x[4]=p.getInventarioMinimo()+"";
                    modelo.addRow(x);
          
                }
                
                tablaInventario.setModel(modelo);
            }
            
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 102));
        jLabel2.setText("PRODUCTOS BAJOS EN INVENTARIO");

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel6.setText("A continuación se muestra un listado con los productos con inventario bajo de su mínimo:");

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción del Producto", "Precio de Venta", "Existencia", "Inv.Minimo", "Inv.Maximo"
            }
        ));
        jScrollPane1.setViewportView(tablaInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(0, 562, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}
