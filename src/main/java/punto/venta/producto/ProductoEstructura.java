/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import punto.venta.ventanas.Estructura;

/**
 *
 * @author agus_
 */
public class ProductoEstructura extends javax.swing.JPanel implements ActionListener {

 public ProductoAgregar pAgregar = new ProductoAgregar();
    ProductoEliminar pEliminar = new ProductoEliminar();
    ProductoModificar pModificar = new ProductoModificar();
    ProductoVentas pVentas = new ProductoVentas();
    ProductoArea pArea= new ProductoArea();
    
    
    public ProductoEstructura() {
        initComponents();
        btnNuevo.addActionListener(this);
        btnModificar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnVentas.addActionListener(this);
        btnAreas.addActionListener(this);
        contenedor.add(pAgregar);
        ImageIcon guardar = new ImageIcon("iconos/agregar.png");
        ImageIcon modificar = new ImageIcon("iconos/modificar_datos.png");
        ImageIcon eliminar = new ImageIcon("iconos/bote_basura.png");
        ImageIcon ventas = new ImageIcon("iconos/ventas_periodo.png");
        btnNuevo.setIcon(guardar);
        btnModificar.setIcon(modificar);
        btnEliminar.setIcon(eliminar);
        btnVentas.setIcon(ventas);
        btnAreas.setIcon(ventas);
    }

 public void asigna(int tipo, Estructura e, String nombre){
     e.muestraEstructuraProductos();
 if(tipo == 1){
  pModificar.llenarCombo();
      pAgregar.setVisible(false);
      pModificar.setVisible(true);
      pEliminar.setVisible(false);
      pVentas.setVisible(false);
      contenedor.add(pModificar);
      pModificar.buscarProductoDesdeVentas(nombre);
      pModificar.requerirFoco2();
 }else{
  pAgregar.setVisible(false);
      pModificar.setVisible(false);
      pModificar.ocultarFormulario();
      pEliminar.llenarCombo();
      pEliminar.setVisible(true); 
      pVentas.setVisible(false);
      contenedor.add(pEliminar);
      pEliminar.setTextCombo(nombre);
      pEliminar.requerirFoco();
 }
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnAreas = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1109, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setBackground(new java.awt.Color(255, 153, 102));
        btnNuevo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel1.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(255, 153, 102));
        btnModificar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel1.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(255, 153, 102));
        btnEliminar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel1.add(btnEliminar);

        btnVentas.setBackground(new java.awt.Color(255, 153, 102));
        btnVentas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnVentas.setText("Ventas por período");
        btnVentas.setBorder(null);
        btnVentas.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel1.add(btnVentas);

        btnAreas.setBackground(new java.awt.Color(255, 153, 102));
        btnAreas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAreas.setText("Áreas");
        btnAreas.setBorder(null);
        btnAreas.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel1.add(btnAreas);

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        panelTicket.setBackground(new java.awt.Color(204, 102, 0));

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTOS");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 569, Short.MAX_VALUE))
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void requerirFoco(){
    pAgregar.requerirFoco();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAreas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
   Object evt = e.getSource();
       
     if(evt.equals(btnNuevo)){
      pAgregar.setVisible(true);
      pModificar.setVisible(false);
      pModificar.ocultarFormulario();
      pEliminar.setVisible(false);
      pVentas.setVisible(false); 
      pAgregar.llenarCombo();
      contenedor.add(pAgregar);
      pArea.setVisible(false);
      pAgregar.requerirFoco();
     }
     else if(evt.equals(btnModificar)){
      pModificar.llenarCombo();
      pAgregar.setVisible(false);
      pModificar.setVisible(true);
      pEliminar.setVisible(false);
      pVentas.setVisible(false);
      pArea.setVisible(false);
      contenedor.add(pModificar);
      pModificar.requerirFoco();
     }
     else if(evt.equals(btnEliminar)){
      pAgregar.setVisible(false);
      pModificar.setVisible(false);
      pArea.setVisible(false);
      pModificar.ocultarFormulario();
      pEliminar.llenarCombo();
      pEliminar.setVisible(true); 
      pVentas.setVisible(false);
      contenedor.add(pEliminar);
      pEliminar.requerirFoco();
      
     }else if(evt.equals(btnVentas)){
      pAgregar.setVisible(false);
      pModificar.setVisible(false);
      pArea.setVisible(false); 
      pEliminar.setVisible(false);
      pVentas.setVisible(true);
      contenedor.add(pVentas);
      pVentas.requerirFoco();
     
     }else if(evt.equals(btnAreas)){
         pArea.llenarCombo();
      pAgregar.setVisible(false);
      pModificar.setVisible(false);
      pArea.setVisible(true); 
      pEliminar.setVisible(false);
      pVentas.setVisible(false);
      contenedor.add(pArea);
      
     }
    }
}
