/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author agus_
 */
public class ClienteEstructura extends javax.swing.JPanel implements ActionListener {

    private ClienteAgregar cAgregar = new ClienteAgregar();
    private ClienteModificar cModificar = new ClienteModificar();
    private ClienteEliminar cEliminar = new ClienteEliminar();
     private ClienteEstadoEstructura cEstado = new ClienteEstadoEstructura();
    
    public ClienteEstructura() {
        initComponents();
        
       btnNuevo.addActionListener(this);
       btnModificar.addActionListener(this);
       btnEliminar.addActionListener(this);
       btnEstado.addActionListener(this);
       contenedor.add(cAgregar);
       configurarIconos();
       
    }

    public void configurarIconos(){
     ImageIcon icoNue = new ImageIcon("iconos/cliente_nuevo.png");
     ImageIcon icoMod = new ImageIcon("iconos/modificar_cliente.png");
     ImageIcon icoEli = new ImageIcon("iconos/eliminar_cliente.png");
     ImageIcon icoEsta = new ImageIcon("iconos/documentos.png");
     btnNuevo.setIcon(icoNue);
     btnModificar.setIcon(icoMod);
     btnEliminar.setIcon(icoEli);
     btnEstado.setIcon(icoEsta);
    }
    
    public void ocultarEstadoInformacion(){
        getcEstado().ocultarEstado();
    }
    
    public void requerirFoco(){
    cAgregar.requerirFoco();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setBackground(new java.awt.Color(0, 153, 153));
        btnNuevo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo Cliente");
        btnNuevo.setBorder(null);
        btnNuevo.setPreferredSize(new java.awt.Dimension(180, 35));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBotones.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 153, 153));
        btnModificar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificar.setText("Modificar Cliente");
        btnModificar.setBorder(null);
        btnModificar.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar Cliente");
        btnEliminar.setBorder(null);
        btnEliminar.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnEliminar);

        btnEstado.setBackground(new java.awt.Color(0, 153, 153));
        btnEstado.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnEstado.setText("Estado de Cuenta");
        btnEstado.setBorder(null);
        btnEstado.setPreferredSize(new java.awt.Dimension(180, 35));
        panelBotones.add(btnEstado);

        contenedor.setBackground(new java.awt.Color(204, 255, 204));
        contenedor.setLayout(new java.awt.BorderLayout());

        panelTicket.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTES");
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
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 389, Short.MAX_VALUE))
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
      Object evt = e.getSource();
       
     if(evt.equals(btnNuevo)){
            getcAgregar().setVisible(true);
            getcModificar().setVisible(false);
            getcModificar().ocultarFormulario();
            getcEliminar().setVisible(false); 
            getcEstado().setVisible(false);
      
      contenedor.add(getcAgregar());
      getcAgregar().requerirFoco();
     }
     else if(evt.equals(btnModificar)){
            getcAgregar().setVisible(false);
            getcModificar().setVisible(true);
            getcModificar().llenarCombo();
            getcEliminar().setVisible(false); 
            getcEstado().setVisible(false);
      contenedor.add(getcModificar());
      getcModificar().requerirFoco();
     }
     else if(evt.equals(btnEliminar)){
            getcAgregar().setVisible(false);
            getcModificar().setVisible(false);
            getcModificar().ocultarFormulario();
            getcEliminar().setVisible(true); 
            getcEliminar().llenarCombo();
            getcEstado().setVisible(false);
      
      contenedor.add(getcEliminar());
      getcEliminar().requerirFoco();
      
     }if(evt.equals(btnEstado)){
            getcAgregar().setVisible(false);
            getcModificar().setVisible(false);
            getcModificar().ocultarFormulario();
            getcEliminar().setVisible(false);
            getcEstado().setVisible(true);
            getcEstado().ocultarEstado();
      
      contenedor.add(getcEstado());
      getcEstado().cEB.requerirFoco();
      getcEstado().cEB.llenarCombo();
      
     }
    }

    /**
     * @return the cAgregar
     */
    public ClienteAgregar getcAgregar() {
        return cAgregar;
    }

    /**
     * @param cAgregar the cAgregar to set
     */
    public void setcAgregar(ClienteAgregar cAgregar) {
        this.cAgregar = cAgregar;
    }

    /**
     * @return the cModificar
     */
    public ClienteModificar getcModificar() {
        return cModificar;
    }

    /**
     * @param cModificar the cModificar to set
     */
    public void setcModificar(ClienteModificar cModificar) {
        this.cModificar = cModificar;
    }

    /**
     * @return the cEliminar
     */
    public ClienteEliminar getcEliminar() {
        return cEliminar;
    }

    /**
     * @param cEliminar the cEliminar to set
     */
    public void setcEliminar(ClienteEliminar cEliminar) {
        this.cEliminar = cEliminar;
    }

    /**
     * @return the cEstado
     */
    public ClienteEstadoEstructura getcEstado() {
        return cEstado;
    }

    /**
     * @param cEstado the cEstado to set
     */
    public void setcEstado(ClienteEstadoEstructura cEstado) {
        this.cEstado = cEstado;
    }
    
    
}
