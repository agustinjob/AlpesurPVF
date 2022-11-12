/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import java.awt.AWTException;
import punto.venta.producto.ProductoEstructura;
import punto.venta.inventario.InventarioEstructura;
import punto.venta.usuario.UsuarioEstructura;
import punto.venta.cliente.ClienteEstructura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import punto.venta.actualizaciones.EstructuraActualizaciones;
import punto.venta.configuracion.Configuracion;
import punto.venta.dao.UsuarioDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.dialogos.EntradaEfectivo;
import punto.venta.dialogos.SalidaEfectivo;
import punto.venta.transferencia.TransferenciaEstructura;
import punto.venta.utilidades.Utilidades;
import static punto.venta.ventanas.VentasEstructura.tipoPrecio;

/**
 *
 * @author agus_
 */
public class Estructura extends javax.swing.JFrame implements ActionListener, KeyListener {

    VentasEstructura objVentas = new VentasEstructura();
    InventarioEstructura inventarios = new InventarioEstructura();
    ClienteEstructura clientes = new ClienteEstructura();
    UsuarioEstructura usuarios = new UsuarioEstructura();
    ProductoEstructura productos = new ProductoEstructura();
    TransferirEstructura transferir = new TransferirEstructura();
    CorteEstructura corte = new CorteEstructura();
 //   NubeEstructura nube = new NubeEstructura();
    Configuracion confi = new Configuracion();

    EstructuraActualizaciones actualizaciones = new EstructuraActualizaciones();
    TransferenciaEstructura transferencia = new TransferenciaEstructura();
    Confirmacion confir;

    public Estructura() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        btnActualizaciones.addActionListener(this);
        btnVentas.addActionListener(this);
        btnTransferencia.addActionListener(this);
        btnInventario.addActionListener(this);
        btnCliente.addActionListener(this);
        btnUsuario.addActionListener(this);
        btnProductos.addActionListener(this);
        btnTransferir.addActionListener(this);
        btnCorte.addActionListener(this);
    //    btnBitacora.addActionListener(this);
        btnConfiguracion.addActionListener(this);
        btnActualizaciones.setVisible(false);
        btnVentas.setFocusable(false);
        btnInventario.setFocusable(false);
        btnCliente.setFocusable(false);
        btnUsuario.setFocusable(false);
        btnProductos.setFocusable(false);
        btnTransferir.setFocusable(false);
        btnTransferencia.setFocusable(false);
        btnCorte.setFocusable(false);
    //    btnBitacora.setFocusable(false);
        btnConfiguracion.setFocusable(false);   
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        contenedor.add(objVentas);
        objVentas.setEstructura(this);
        inicializarIconos();
        objVentas.requerirFoco();
        ImageIcon logo = new ImageIcon("iconos/logo.jpg");
        this.setIconImage(logo.getImage());
        btnTransferencia.setVisible(false);

    }

    public ProductoEstructura getEstructuraProducto(){
    return productos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        caja = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnCorte = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnActualizaciones = new javax.swing.JButton();
        nombreUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Cambria", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PUNTO DE VENTA");

        caja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnVentas.setBackground(new java.awt.Color(0, 51, 102));
        btnVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setAlignmentX(0.5F);
        btnVentas.setBorder(null);
        btnVentas.setMargin(new java.awt.Insets(3, 14, 2, 14));
        btnVentas.setMinimumSize(new java.awt.Dimension(20, 19));
        btnVentas.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnVentas);

        btnCliente.setBackground(new java.awt.Color(0, 51, 102));
        btnCliente.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Clientes");
        btnCliente.setBorder(null);
        btnCliente.setMinimumSize(new java.awt.Dimension(20, 19));
        btnCliente.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnCliente);

        btnProductos.setBackground(new java.awt.Color(0, 51, 102));
        btnProductos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setMinimumSize(new java.awt.Dimension(20, 19));
        btnProductos.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnProductos);

        btnTransferir.setBackground(new java.awt.Color(0, 51, 102));
        btnTransferir.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferir.setText("Transferir");
        btnTransferir.setBorder(null);
        btnTransferir.setMinimumSize(new java.awt.Dimension(20, 19));
        btnTransferir.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnTransferir);

        btnUsuario.setBackground(new java.awt.Color(0, 51, 102));
        btnUsuario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuario");
        btnUsuario.setBorder(null);
        btnUsuario.setMinimumSize(new java.awt.Dimension(20, 19));
        btnUsuario.setPreferredSize(new java.awt.Dimension(80, 35));
        jPanel2.add(btnUsuario);

        btnConfiguracion.setBackground(new java.awt.Color(0, 51, 102));
        btnConfiguracion.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setBorder(null);
        btnConfiguracion.setMaximumSize(new java.awt.Dimension(115, 19));
        btnConfiguracion.setMinimumSize(new java.awt.Dimension(20, 19));
        btnConfiguracion.setPreferredSize(new java.awt.Dimension(120, 35));
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfiguracion);

        btnInventario.setBackground(new java.awt.Color(0, 51, 102));
        btnInventario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setMinimumSize(new java.awt.Dimension(20, 19));
        btnInventario.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnInventario);

        btnCorte.setBackground(new java.awt.Color(0, 51, 102));
        btnCorte.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCorte.setForeground(new java.awt.Color(255, 255, 255));
        btnCorte.setText("Corte ");
        btnCorte.setBorder(null);
        btnCorte.setMinimumSize(new java.awt.Dimension(20, 19));
        btnCorte.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel2.add(btnCorte);

        btnTransferencia.setBackground(new java.awt.Color(0, 51, 102));
        btnTransferencia.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnTransferencia.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferencia.setText("Sucursales");
        btnTransferencia.setBorder(null);
        btnTransferencia.setMinimumSize(new java.awt.Dimension(20, 19));
        btnTransferencia.setPreferredSize(new java.awt.Dimension(110, 35));
        jPanel2.add(btnTransferencia);

        btnActualizaciones.setBackground(new java.awt.Color(0, 51, 102));
        btnActualizaciones.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnActualizaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizaciones.setText("Actualizar");
        btnActualizaciones.setBorder(null);
        btnActualizaciones.setMaximumSize(new java.awt.Dimension(120, 19));
        btnActualizaciones.setMinimumSize(new java.awt.Dimension(20, 19));
        btnActualizaciones.setPreferredSize(new java.awt.Dimension(120, 35));
        jPanel2.add(btnActualizaciones);

        nombreUsuario.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("jLabel1");

        btnCerrarSesion.setBackground(new java.awt.Color(0, 51, 102));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cambiar");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion)
                        .addGap(18, 18, 18)
                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(caja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreUsuario)
                            .addComponent(btnCerrarSesion))
                        .addGap(14, 14, 14)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenedor.setBackground(new java.awt.Color(102, 102, 255));
        contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        InicioSesion ini = new InicioSesion();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
if (evt.equals(btnActualizaciones)) {
            actualizaciones.setVisible(true);
            inventarios.setVisible(false);
            objVentas.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
      //      nube.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
            transferencia.setVisible(false);
            contenedor.add(actualizaciones);
            //objVentas.requerirFoco();
            contenedor.validate();

           // Utilidades.im("Entro a btnVentas");

        } else if (evt.equals(btnVentas)) {
 actualizaciones.setVisible(false);
            inventarios.setVisible(false);
            objVentas.setVisible(true);
            objVentas.llenarCombo();
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
          //  nube.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
            transferencia.setVisible(false);
            contenedor.add(objVentas);
            objVentas.requerirFoco();
            contenedor.validate();

           // Utilidades.im("Entro a btnVentas");

        } else if(evt.equals(btnTransferencia)){
            actualizaciones.setVisible(false);
        inventarios.setVisible(false);
            objVentas.setVisible(false);
            transferencia.setVisible(true);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
         //   nube.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
           
        transferencia.getPaso1().llenarTabla();
            contenedor.add(transferencia);
            transferencia.requerirFoco();
            contenedor.validate();

    
        }
         else       if (evt.equals(btnInventario)) {
actualizaciones.setVisible(false);
            objVentas.setVisible(false);
         //   nube.setVisible(false);
            inventarios.setVisible(true);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
            
             transferencia.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            inventarios.asignaPrimerContenedor();    
            contenedor.add(inventarios);
             inventarios.requerirFoco();
           inventarios.getIagregar().llenarCombo();
             inventarios.getIagregar().llenarComboArea();
            
            contenedor.validate();

        } else if (evt.equals(btnCliente)) {
actualizaciones.setVisible(false);
            objVentas.setVisible(false);
        //    nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(true);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
             transferencia.setVisible(false);
            clientes.ocultarEstadoInformacion();
            contenedor.add(clientes);
            clientes.requerirFoco();
            contenedor.validate();

        } else if (evt.equals(btnUsuario)) {
            actualizaciones.setVisible(false);
            objVentas.setVisible(false);
       //     nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(true);
            productos.setVisible(false);
            transferir.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
             transferencia.setVisible(false);
            contenedor.add(usuarios);
            usuarios.requerirFoco();
            contenedor.validate();

        } else if (evt.equals(btnProductos)) {
            actualizaciones.setVisible(false);
            objVentas.setVisible(false);
         //   nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(true);
            productos.pAgregar.llenarCombo();
            transferir.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
             transferencia.setVisible(false);
            contenedor.add(productos);
            productos.requerirFoco();
            contenedor.validate();

        } else if (evt.equals(btnTransferir)) {
            actualizaciones.setVisible(false);
            objVentas.setVisible(false);
      //      nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(true);
            confi.setVisible(false);
            
             transferencia.setVisible(false);
            transferir.limpiarDatos();
            transferir.llenarCombo();
            corte.setVisible(false);
           
            contenedor.add(transferir);
            transferir.requerirFoco();
            contenedor.validate();

        } else if (evt.equals(btnCorte)) {
            actualizaciones.setVisible(false);
            objVentas.setVisible(false);
      //      nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
            confi.setVisible(false);
            corte.setVisible(true);
           
            contenedor.add(corte);
            transferencia.setVisible(false);
            contenedor.validate();

        }else  /*if (evt.equals(btnBitacora)) {
            actualizaciones.setVisible(false);
            objVentas.setVisible(false);
            nube.setVisible(true);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            
             transferencia.setVisible(false);
            contenedor.add(nube);
            contenedor.validate();
        }else */if (evt.equals(btnConfiguracion)){
            actualizaciones.setVisible(false);
        confi.setVisible(true);
        confi.llenarCombo();
        confi.llenarDatos();
        objVentas.setVisible(false);
         //   nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(false);
            transferir.setVisible(false);
            corte.setVisible(false);
            transferencia.setVisible(false);
           
            contenedor.add(confi);
            confi.requerirFoco();
            contenedor.validate();
        
        }
    }
    
    public void muestraEstructuraProductos(){
     objVentas.setVisible(false);
     //       nube.setVisible(false);
            inventarios.setVisible(false);
            clientes.setVisible(false);
            usuarios.setVisible(false);
            productos.setVisible(true);
            transferir.setVisible(false);
            corte.setVisible(false);
            confi.setVisible(false);
            contenedor.add(productos);
            productos.requerirFoco();
            contenedor.validate();
    }

    public void inicializarIconos() {
        ImageIcon registradora = new ImageIcon("iconos/logo.jpeg");
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
        ImageIcon documentos = new ImageIcon("iconos/documentos.png");
         ImageIcon actualizarVarios = new ImageIcon("iconos/actualizar_varios.png");
        ImageIcon nubeIcon = new ImageIcon("iconos/servidorChico.png");
        ImageIcon configuracion = new ImageIcon("iconos/engranajes.png");

        btnVentas.setIcon(gg);
        btnCliente.setIcon(b);
        btnProductos.setIcon(c);
        btnInventario.setIcon(d);
       // btnBitacora.setIcon(nubeIcon);
        btnUsuario.setIcon(f);
        btnCorte.setIcon(h);
        btnConfiguracion.setIcon(configuracion);
        btnTransferir.setIcon(j);
        btnTransferencia.setIcon(j);
        btnActualizaciones.setIcon(actualizarVarios);
        caja.setIcon(registradora);
        String tipo = UsuarioDAO.getTipo();
        nombreUsuario.setText(Utilidades.regresarNombre());
        if (tipo.equalsIgnoreCase("Empleado")) {
            btnCliente.setEnabled(false);
            btnProductos.setEnabled(false);
            btnTransferir.setEnabled(false);
            btnUsuario.setEnabled(false);
            btnCliente.setVisible(false);
            btnProductos.setVisible(false);
            btnTransferir.setVisible(false);
            btnUsuario.setVisible(false);
            btnConfiguracion.setEnabled(false);
            btnConfiguracion.setVisible(false);
       //     btnBitacora.setEnabled(false);
         //   btnBitacora.setVisible(false)
            btnTransferencia.setVisible(false);
            btnTransferencia.setEnabled(false);
            btnActualizaciones.setVisible(false);
            btnActualizaciones.setEnabled(false);

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
                 
            java.util.logging.Logger.getLogger(Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
                 
            java.util.logging.Logger.getLogger(Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
                 
            java.util.logging.Logger.getLogger(Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                 
            java.util.logging.Logger.getLogger(Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estructura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizaciones;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnCorte;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel caja;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nombreUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed " + e.getKeyCode());
        if (e.getKeyCode() == 122) {

            if (VentasEstructura.tipoPrecio == 1) {
                Utilidades.confirma(confir, "Se ha activado el precio de mayoreo");
                VentasEstructura.tipoPrecio = 2;
            } else {
                Utilidades.confirma(confir, "Se ha desactivado el precio de mayoreo");
                VentasEstructura.tipoPrecio = 1;
            }
        }

        if (e.getKeyCode() == 118) {
            EntradaEfectivo objeto = new EntradaEfectivo(objVentas);
            objeto.setVisible(true);
        }
        if (e.getKeyCode() == 119) {
            SalidaEfectivo objeto = new SalidaEfectivo(objVentas);
            objeto.setVisible(true);
        }
        if (e.getKeyCode() == 123) {
            objVentas.realizaCobro();
        }
        if(e.getKeyCode() == 127){
            Utilidades.im("Entro a eliminar");
            objVentas.eliminaCelda(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key resleased");
    }

}
