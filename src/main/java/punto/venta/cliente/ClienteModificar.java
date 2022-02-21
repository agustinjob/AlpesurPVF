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
import javax.swing.ImageIcon;
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
public class ClienteModificar extends javax.swing.JPanel {

    int filas;
    ClienteDAO obj = new ClienteDAO();
    ArrayList<Cliente> c;
    Cliente cliente = new Cliente();
     Cliente clienteTemporal;
    Confirmacion confirma = new Confirmacion();

    public ClienteModificar() {
        initComponents();
        formulario.setVisible(false);
        llenarCombo();
        ImageIcon check = new ImageIcon("iconos/check.png");
        btnModificar.setIcon(check);
        AutoCompleteDecorator.decorate(jComboBox1, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        
    }
    
    public void ocultarFormulario(){
   formulario.setVisible(false);
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
                 
           mensaje("Hubo un error en el sistema");
        } catch (SQLException ex) {
                 
            mensaje("Hubo un error con la conexion a la base de datos");
        }

    }
    
      public void mensaje(String men){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnaa = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        formulario = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtnombrec = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcredito = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboMayorista = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setPreferredSize(new java.awt.Dimension(500, 380));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setText("Buscar cliente");

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Teclee el nombre del cliente:");

        btnaa.setBackground(new java.awt.Color(0, 153, 153));
        btnaa.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnaa.setText("Buscar");
        btnaa.setBorder(null);
        btnaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaaActionPerformed(evt);
            }
        });
        btnaa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaaKeyPressed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout buscarLayout = new javax.swing.GroupLayout(buscar);
        buscar.setLayout(buscarLayout);
        buscarLayout.setHorizontalGroup(
            buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarLayout.createSequentialGroup()
                .addGroup(buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnaa, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buscarLayout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(jLabel4))
                        .addGroup(buscarLayout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel11))
                        .addGroup(buscarLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        buscarLayout.setVerticalGroup(
            buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnaa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formulario.setBackground(new java.awt.Color(255, 255, 255));
        formulario.setPreferredSize(new java.awt.Dimension(500, 380));

        jLabel31.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel31.setText("Nombre Completo");

        jLabel32.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel32.setText("Dirección");

        jLabel33.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel33.setText("Telefono(s)");

        jLabel34.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel34.setText("Limite de Credito");

        txtnombrec.setPreferredSize(new java.awt.Dimension(250, 30));

        txtdireccion.setPreferredSize(new java.awt.Dimension(250, 30));

        txttelefono.setPreferredSize(new java.awt.Dimension(250, 30));

        txtcredito.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel35.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel35.setText("Ingresa los datos del cliente que quieras modificar");

        jLabel36.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel36.setText("Modificar cliente");

        txtRFC.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel10.setText("RFC:");

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setText("Email:");

        txtEmail.setEnabled(false);
        txtEmail.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Mayorista?");

        comboMayorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Sí" }));

        btnModificar.setBackground(new java.awt.Color(0, 153, 153));
        btnModificar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnModificar.setText("Modificar datos");
        btnModificar.setBorder(null);
        btnModificar.setPreferredSize(new java.awt.Dimension(180, 35));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout formularioLayout = new javax.swing.GroupLayout(formulario);
        formulario.setLayout(formularioLayout);
        formularioLayout.setHorizontalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(92, 92, 92)))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formularioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(formularioLayout.createSequentialGroup()
                            .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formularioLayout.createSequentialGroup()
                            .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32))
                                .addComponent(jLabel33)
                                .addComponent(jLabel34))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnombrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
        );
        formularioLayout.setVerticalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addGap(37, 37, 37)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addComponent(formulario, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaaActionPerformed
    buscar();
    }//GEN-LAST:event_btnaaActionPerformed

    public void buscar(){
    String nombre = (String) jComboBox1.getSelectedItem();
        int i = 0;
        clienteTemporal=new Cliente();
        Cliente cli = new Cliente();
                while(i<c.size()){
            if(c.get(i).getNombres().equalsIgnoreCase(nombre)){
                cli = c.get(i);
                cliente = cli;
                clienteTemporal = c.get(i);
                break;
            }
            i++;
        }

        if(cli.getNombres() == null){
           
            mensaje("Datos del cliente no encontrados");
           Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 jComboBox1.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
            
        }else{
            formulario.setVisible(true);
            txtnombrec.setText(cli.getNombres());
            txtdireccion.setText(cli.getDireccion());
            txttelefono.setText(cli.getTelefono());
            txtcredito.setText(cli.getLimiteCredito());
            txtEmail.setText(cli.getEmail());
            txtRFC.setText(cli.getRfc());
            llenarComboMayorista(cli.getMayorista());
            txtnombrec.requestFocus();
        }
    }
    
    public void llenarComboMayorista(String opcion){
     comboMayorista.removeAllItems();
        comboMayorista.addItem(opcion);
       if(opcion.equalsIgnoreCase("Sí")){
        comboMayorista.addItem("No");
       }else{
           comboMayorista.addItem("Sí");
       }
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    public void modificar(){
        
    String [] a = new String[7];
        a[0]= txtnombrec.getText();
        a[1]=txtdireccion.getText();
        a[2]=txttelefono.getText();
        a[3]=txtcredito.getText();
         a[4]=txtRFC.getText();
        a[5]= txtEmail.getText();
        a[6]= comboMayorista.getSelectedItem().toString();
        boolean bandera = Utilidades.hayVacios(a);

        if(bandera == true){
       
            mensaje("Por favor ingresa todos los datos");
            Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    confirma.dispose();
                   txtnombrec.requestFocus();
                }
                
            });
            
            timer.setRepeats(false);
            timer.start();
           
            
        }else{
           
            cliente.setNombres(a[0]);
            cliente.setTelefono(a[2]);
            cliente.setDireccion(a[1]);
            cliente.setLimiteCredito(a[3]);
            cliente.setRfc(a[4]);
            cliente.setEmail(a[5]);
            cliente.setMayorista(a[6]);
           int ban=0;
            try{
            Double.parseDouble(a[3]);
            
             
                 
              ban=obj.modificarDatosCliente(cliente,clienteTemporal,"Actualizada","Modificacion");
              String estatus=ban>=1?"Realizada":"En proceso";
                         
          
           if(ban>0){
            formulario.setVisible(false);
            txtnombrec.setText("");
            txtdireccion.setText("");
            txttelefono.setText("");
            txtcredito.setText("");
            txtRFC.setText("");
            txtEmail.setText("");
            llenarCombo();
              mensaje("Datos del cliente modificados correctamente");
              
            Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    confirma.dispose();
                    jComboBox1.requestFocus();
                }
                
            });
            
            timer.setRepeats(false);
            timer.start();
            
            
           }else{
            mensaje("Ocurrio un error vuelve a intentarlo por favor");
            
            Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                       confirma.dispose();
                  txtnombrec.requestFocus();
                }
                
            });
                timer.setRepeats(false);
            timer.start();
           
           }
         
           }catch(NumberFormatException e){
                  
           mensaje("Por favor revisa los datos ingresados");
            Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                         confirma.dispose();
                  txtnombrec.requestFocus();
                }
                
            });
                timer.setRepeats(false);
            timer.start();
           }
        }
    }
    private void btnaaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaaKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      buscar();
        }
    }//GEN-LAST:event_btnaaKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER){
     modificar();
        }
    }//GEN-LAST:event_btnModificarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnaa;
    private javax.swing.JPanel buscar;
    private javax.swing.JComboBox<String> comboMayorista;
    private javax.swing.JPanel formulario;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtcredito;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombrec;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
