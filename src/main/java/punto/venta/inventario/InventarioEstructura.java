/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.inventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class InventarioEstructura extends javax.swing.JPanel implements ActionListener {

    

   private InventarioAgregar iagregar = new InventarioAgregar();
   private InventarioBajos ibajos = new InventarioBajos();
   private InventarioDatos idatos = new InventarioDatos();
   private InventarioMovimientos imovimientos = new InventarioMovimientos();
   
   
   
    public InventarioEstructura() {
        initComponents();
        
        btnAgregar.addActionListener(this);
        btnBajos.addActionListener(this);
        btnDatos.addActionListener(this);
        btnMovimientos.addActionListener(this);
        ImageIcon agregar = new ImageIcon("iconos/agregar.png");
        ImageIcon inventario = new ImageIcon("iconos/inventario.png");
        ImageIcon reporte = new ImageIcon("iconos/reporte_inventario.png");
        btnAgregar.setIcon(agregar);
        btnDatos.setIcon(inventario);
        btnBajos.setIcon(reporte);
        btnMovimientos.setIcon(reporte);
       
        contenedor.add(iagregar);
    }

    public void requerirFoco(){
    getIagregar().requerirFoco();
    }
    public void asignaPrimerContenedor(){
        getIagregar().setVisible(true);
        getIbajos().setVisible(false);
        getIdatos().setVisible(false);
        getImovimientos().setVisible(false);
        contenedor.add(getIagregar());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnDatos = new javax.swing.JButton();
        btnBajos = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        panelTicket1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1369, 512));

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregar.setBackground(new java.awt.Color(153, 153, 255));
        btnAgregar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setPreferredSize(new java.awt.Dimension(1365, 40));
        panelBotones.add(btnAgregar);

        btnDatos.setBackground(new java.awt.Color(153, 153, 255));
        btnDatos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnDatos.setText("Datos inventario");
        btnDatos.setPreferredSize(new java.awt.Dimension(250, 35));
        panelBotones.add(btnDatos);

        btnBajos.setBackground(new java.awt.Color(153, 153, 255));
        btnBajos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBajos.setText("Productos bajos en inventario");
        btnBajos.setBorder(null);
        btnBajos.setPreferredSize(new java.awt.Dimension(250, 35));
        panelBotones.add(btnBajos);

        btnMovimientos.setBackground(new java.awt.Color(153, 153, 255));
        btnMovimientos.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnMovimientos.setText("Movimientos");
        btnMovimientos.setBorder(null);
        btnMovimientos.setPreferredSize(new java.awt.Dimension(250, 35));
        panelBotones.add(btnMovimientos);

        contenedor.setBackground(new java.awt.Color(204, 255, 255));
        contenedor.setLayout(new java.awt.BorderLayout());

        panelTicket1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel2.setBackground(new java.awt.Color(204, 204, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTARIO");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicket1Layout = new javax.swing.GroupLayout(panelTicket1);
        panelTicket1.setLayout(panelTicket1Layout);
        panelTicket1Layout.setHorizontalGroup(
            panelTicket1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicket1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(1209, Short.MAX_VALUE))
        );
        panelTicket1Layout.setVerticalGroup(
            panelTicket1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicket1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTicket1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelTicket1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBajos;
    private javax.swing.JButton btnDatos;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTicket1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       Object evt = e.getSource();
       
     if(evt.equals(btnAgregar)){
            getIagregar().setVisible(true);
            getIbajos().setVisible(false);
            getIdatos().setVisible(false); 
               getImovimientos().setVisible(false);
      contenedor.add(getIagregar());
      iagregar.llenarComboArea();
      requerirFoco();
     }
     else if(evt.equals(btnBajos)){
            getIagregar().setVisible(false);
            getIbajos().setVisible(true);
            getIbajos().generaTabla();
            getIdatos().setVisible(false); 
               getImovimientos().setVisible(false);
      contenedor.add(getIbajos());
     }
     else if(evt.equals(btnDatos)){
            getIagregar().setVisible(false);
            getIbajos().setVisible(false);
            getIdatos().setVisible(true); 
              getImovimientos().setVisible(false);
            getIdatos().llenarTabla();
      contenedor.add(getIdatos());
      getIdatos().requerirFoco();
     }else if(evt.equals(btnMovimientos)){
            getImovimientos().setVisible(true);
              getIagregar().setVisible(false);
            getIbajos().setVisible(false);
            getIdatos().setVisible(false); 
           getImovimientos().limpiarTabla();
            contenedor.add(getImovimientos());
     }
    
     
    }
    
    /**
     * @return the iagregar
     */
    public InventarioAgregar getIagregar() {
        return iagregar;
    }

    /**
     * @param iagregar the iagregar to set
     */
    public void setIagregar(InventarioAgregar iagregar) {
        this.iagregar = iagregar;
    }

    /**
     * @return the ibajos
     */
    public InventarioBajos getIbajos() {
        return ibajos;
    }

    /**
     * @param ibajos the ibajos to set
     */
    public void setIbajos(InventarioBajos ibajos) {
        this.ibajos = ibajos;
    }

    /**
     * @return the idatos
     */
    public InventarioDatos getIdatos() {
        return idatos;
    }

    /**
     * @param idatos the idatos to set
     */
    public void setIdatos(InventarioDatos idatos) {
        this.idatos = idatos;
    }

    /**
     * @return the imovimientos
     */
    public InventarioMovimientos getImovimientos() {
        return imovimientos;
    }

    /**
     * @param imovimientos the imovimientos to set
     */
    public void setImovimientos(InventarioMovimientos imovimientos) {
        this.imovimientos = imovimientos;
    }
}
