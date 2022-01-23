/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.venta.dao.ClienteDAO;
import punto.venta.dao.Conexion;
import punto.venta.dialogos.Confirmacion;
import punto.venta.misclases.Cliente;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ClienteEliminar extends javax.swing.JPanel {

    ClienteDAO obj = new ClienteDAO();
    ArrayList<Cliente> c;
    Confirmacion confi = new Confirmacion();

    public ClienteEliminar() {
        initComponents();
        obj.setConn(Conexion.conexi.getLocal());
        llenarCombo();
        AutoCompleteDecorator.decorate(jComboBox1, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }
    
    
    public void requerirFoco(){
    jComboBox1.setFocusable(true);
    jComboBox1.requestFocus();
    }
    

    public void llenarCombo() {

        try {
            c = new ArrayList<Cliente>();
            c = obj.getClientes();
            jComboBox1.removeAllItems();
            jComboBox1.addItem("");
            int i = 0;
            while (i < c.size()) {
                jComboBox1.addItem(c.get(i).getNombres());
                i++;
            }
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Utilidades.confirma(confi, "Hubo un error en el sistema");
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Utilidades.confirma(confi, "Hubo un error con la conexion a la base de datos");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnaAceptar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 350));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setText("Eliminar cliente");

        btnaAceptar.setBackground(new java.awt.Color(0, 153, 153));
        btnaAceptar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnaAceptar.setText("Aceptar");
        btnaAceptar.setBorder(null);
        btnaAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaAceptarActionPerformed(evt);
            }
        });
        btnaAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaAceptarKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Teclee el nombre del cliente:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnaAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(186, 186, 186))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnaAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaAceptarActionPerformed
eliminar();
    }//GEN-LAST:event_btnaAceptarActionPerformed

    public void eliminar(){
            String nombre = (String) jComboBox1.getSelectedItem();
            
             int x=0;
        if(nombre.equalsIgnoreCase("")){
        Utilidades.confirma(confi,"Datos del cliente no encontrados");
        }else{
        int i = 0;
        Cliente cliente = new Cliente();
           while(i<c.size()){
            if(c.get(i).getNombres().equalsIgnoreCase(nombre)){
               
              
                    cliente = c.get(i);
                    Conexion.getConexiones();
                    if(Conexion.conexi.isInternet()){
                        obj.setConn(Conexion.conexi.getHost());
                        x= obj.eliminarDatosCliente(cliente,"Actualizada","Eliminacion");
                        String estatus=x==0?"En proceso":"Actualizada";
                        obj.setConn(Conexion.conexi.getLocal());
                        x= obj.eliminarDatosCliente(cliente,estatus,"Eliminacion");
                        
                    }else{
                        obj.setConn(Conexion.conexi.getLocal());
                        x= obj.eliminarDatosCliente(cliente,"En proceso","Eliminacion");
                    }
                    llenarCombo();
                    break;
               
                
            }
            i++;
        }
           if(x>0){
           confi.setMensaje("Datos del cliente eliminados");
           confi.setVisible(true);
           }
        }
        
        Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                 confi.dispose();
                 jComboBox1.requestFocus();
                
                }
                
            });

    timer.setRepeats(false);
            timer.start();
    }
    private void btnaAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaAceptarKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      eliminar();
        }
    }//GEN-LAST:event_btnaAceptarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaAceptar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
