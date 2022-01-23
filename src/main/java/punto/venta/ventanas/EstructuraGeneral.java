/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import punto.venta.producto.ProductoEstructura;
import punto.venta.inventario.InventarioEstructura;
import punto.venta.usuario.UsuarioEstructura;
import punto.venta.cliente.ClienteEstructura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import punto.venta.dao.UsuarioDAO;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class EstructuraGeneral extends javax.swing.JFrame implements ActionListener{
   
    VentasEstructura objVentas = new VentasEstructura();
    InventarioEstructura inventarios = new InventarioEstructura();
    ClienteEstructura clientes = new ClienteEstructura();
    UsuarioEstructura usuarios = new UsuarioEstructura();
    ProductoEstructura productos = new ProductoEstructura();
    TransferirEstructura transferir = new TransferirEstructura();
    CorteEstructura corte = new CorteEstructura();
    
    public EstructuraGeneral() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        btnVentas.addActionListener(this);
        btnInventario.addActionListener(this);
        btnCliente.addActionListener(this);
        btnUsuario.addActionListener(this);
        btnProductos.addActionListener(this);
        btnTransferir.addActionListener(this);
        btnCorte.addActionListener(this);
        contenedor.add(objVentas);
        inicializarIconos();
        
    }
    
    public ProductoEstructura getProductoEstructura(){
        return productos;
    }
 /*private void deshabilitarboton(){
     
        if (objVentas.isVisible()){
            
            btnVentas.setEnabled(false);
            btnInventario.setEnabled(true);
            Utilidades.im("ObjVentas es Visible");
            
        }else if(panel2.isVisible()) {
            
          btnVentas.setEnabled(true);
          btnInventario.setEnabled(false);  
           Utilidades.im("PANEL 2 Visible");
        }
    }*/
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        caja = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnCorte = new javax.swing.JButton();
        btnj1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        contenedor.setBackground(new java.awt.Color(102, 102, 255));
        contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Cambria", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Punto de venta");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnVentas.setBackground(new java.awt.Color(0, 51, 102));
        btnVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setAlignmentX(0.5F);
        btnVentas.setBorder(null);
        btnVentas.setMargin(new java.awt.Insets(3, 14, 2, 14));
        btnVentas.setPreferredSize(new java.awt.Dimension(135, 35));
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel2.add(btnVentas);

        btnCliente.setBackground(new java.awt.Color(0, 51, 102));
        btnCliente.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Clientes");
        btnCliente.setBorder(null);
        btnCliente.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnCliente);

        btnProductos.setBackground(new java.awt.Color(0, 51, 102));
        btnProductos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setPreferredSize(new java.awt.Dimension(135, 35));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel2.add(btnProductos);

        btnInventario.setBackground(new java.awt.Color(0, 51, 102));
        btnInventario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setPreferredSize(new java.awt.Dimension(135, 35));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnInventario);

        btnTransferir.setBackground(new java.awt.Color(0, 51, 102));
        btnTransferir.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferir.setText("Transferir");
        btnTransferir.setBorder(null);
        btnTransferir.setPreferredSize(new java.awt.Dimension(135, 35));
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        jPanel2.add(btnTransferir);

        btnUsuario.setBackground(new java.awt.Color(0, 51, 102));
        btnUsuario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuario");
        btnUsuario.setBorder(null);
        btnUsuario.setPreferredSize(new java.awt.Dimension(135, 35));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnUsuario);

        btnCorte.setBackground(new java.awt.Color(0, 51, 102));
        btnCorte.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorte.setForeground(new java.awt.Color(255, 255, 255));
        btnCorte.setText("Corte");
        btnCorte.setBorder(null);
        btnCorte.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteActionPerformed(evt);
            }
        });
        jPanel2.add(btnCorte);

        btnj1.setBackground(new java.awt.Color(0, 51, 102));
        btnj1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnj1.setForeground(new java.awt.Color(255, 255, 255));
        btnj1.setText("Facturación");
        btnj1.setBorder(null);
        btnj1.setPreferredSize(new java.awt.Dimension(135, 35));
        btnj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnj1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnj1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 283, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
      
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
       
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteActionPerformed
        
    }//GEN-LAST:event_btnCorteActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
       
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnj1ActionPerformed
  
    @Override
    public void actionPerformed(ActionEvent e) {
   Object evt = e.getSource();
    
      if(evt.equals(btnVentas)){
        
        inventarios.setVisible(false);
        objVentas.setVisible(true);
        clientes.setVisible(false);
        usuarios.setVisible(false);
        productos.setVisible(false);
         transferir.setVisible(false);
        corte.setVisible(false);
        contenedor.add(objVentas);
        
        contenedor.validate();
       
       Utilidades.im("Entro a btnVentas");
       
      }else if(evt.equals(btnInventario)){
          
        objVentas.setVisible(false);
        inventarios.setVisible(true);
        clientes.setVisible(false);
        usuarios.setVisible(false);
        productos.setVisible(false);
         transferir.setVisible(false);
        corte.setVisible(false);
        contenedor.add(inventarios);
        contenedor.validate();
      
           
      }else if(evt.equals(btnCliente)){
          
       objVentas.setVisible(false);
        inventarios.setVisible(false);
        clientes.setVisible(true);
           usuarios.setVisible(false);
           productos.setVisible(false);
         transferir.setVisible(false);
        corte.setVisible(false);
        contenedor.add(clientes);
        contenedor.validate();
        
      }else if(evt.equals(btnUsuario)){
        objVentas.setVisible(false);
        inventarios.setVisible(false);
        clientes.setVisible(false);
        usuarios.setVisible(true);
        productos.setVisible(false);
         transferir.setVisible(false);
        corte.setVisible(false);
        contenedor.add(usuarios);
        contenedor.validate();
      
      }else if(evt.equals(btnProductos)){
        objVentas.setVisible(false);
        inventarios.setVisible(false);
        clientes.setVisible(false);
        usuarios.setVisible(false);
        productos.setVisible(true);
         transferir.setVisible(false);
        corte.setVisible(false);
        contenedor.add(productos);
        contenedor.validate();
      
      }else if(evt.equals(btnTransferir)){
        objVentas.setVisible(false);
        inventarios.setVisible(false);
        clientes.setVisible(false);
        usuarios.setVisible(false);
        productos.setVisible(false);
        transferir.setVisible(true);
        corte.setVisible(false);
        contenedor.add(transferir);
        contenedor.validate();
      
      }else if(evt.equals(btnCorte)){
        objVentas.setVisible(false);
        inventarios.setVisible(false);
        clientes.setVisible(false);
        usuarios.setVisible(false);
        productos.setVisible(false);
        transferir.setVisible(false);
        corte.setVisible(true);
        contenedor.add(corte);
        contenedor.validate();
      
      }
    }
    public void inicializarIconos() {
           ImageIcon registradora = new ImageIcon("iconos/comprar.png");
        //iconos/comprar.png
        ImageIcon cc = new ImageIcon("iconos/cancelar.png");
        ImageIcon bc = new ImageIcon("iconos/boton_cerrar.png");
        ImageIcon c = new ImageIcon("iconos/productos.png");
        ImageIcon b = new ImageIcon("iconos/clientes.png");
        ImageIcon d = new ImageIcon("iconos/inventario.png");
        ImageIcon gg = new ImageIcon("iconos/carro_cobrar.png");
        ImageIcon h = new ImageIcon("iconos/corte.png");
        ImageIcon i = new ImageIcon("iconos/reportes.png");
        ImageIcon j = new ImageIcon("iconos/intercambiar.png");
        ImageIcon f = new ImageIcon("iconos/usuario.png");
        ImageIcon e = new ImageIcon("iconos/ticket.png");
        
        btnVentas.setIcon(gg);
        btnCliente.setIcon(b);
        btnProductos.setIcon(c);
        btnInventario.setIcon(d);
      
        btnUsuario.setIcon(f);
        btnCorte.setIcon(h);
       
        btnTransferir.setIcon(j);
        caja.setIcon(registradora);
      //   String tipo = UsuarioDAO.getTipo();
    String tipo = "admin";
        if (tipo.equalsIgnoreCase("Empleado")) {

            btnCliente.setEnabled(false);
            btnProductos.setEnabled(false);
            btnTransferir.setEnabled(false);
            btnUsuario.setEnabled(false);
            btnCorte.setEnabled(false);
            btnCliente.setVisible(false);
            btnProductos.setVisible(false);
            btnTransferir.setVisible(false);
            btnUsuario.setVisible(false);
            btnCorte.setVisible(false);
         
        }
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            java.util.logging.Logger.getLogger(EstructuraGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            java.util.logging.Logger.getLogger(EstructuraGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            java.util.logging.Logger.getLogger(EstructuraGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            java.util.logging.Logger.getLogger(EstructuraGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstructuraGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCorte;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnj1;
    private javax.swing.JLabel caja;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

  
}
