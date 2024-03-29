package punto.venta.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Datos;
import static punto.venta.dao.Datos.formatoSistema;
import punto.venta.dao.Movimientos;
import punto.venta.dao.UsuarioDAO;
import static punto.venta.dialogos.Cobrar.txtn1;
import punto.venta.dialogos.Confirmacion;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Sucursal;
import punto.venta.modelo.Usuario;
import punto.venta.modelo.response.MovimientosExtrasResponse;
import punto.venta.modelo.response.SucursalResponse;
import punto.venta.modelo.response.UsuarioResponse;
import punto.venta.utilidades.Imagen;
import punto.venta.utilidades.Utilidades;

public class InicioSesion extends javax.swing.JFrame {

    Movimientos obj = new Movimientos();
    Confirmacion confir;
    Usuario usu = new Usuario();
    UsuarioDAO usuDAO = new UsuarioDAO();
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    ArrayList<Usuario> p;
    Confirmacion confirma = new Confirmacion();
    ApiSend api = new ApiSend();

    public InicioSesion() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("Inicio de sesión");
          Utilidades.asignarDatosConfiguracion();
        ImageIcon e = new ImageIcon("iconos/cajaSeguro.png");
        ImageIcon iniciar = new ImageIcon("iconos/check.png");
        ImageIcon salir = new ImageIcon("iconos/cancelar.png");
        cajaSeguro.setIcon(e);
        btnSalir.setIcon(salir);
        btnIniciar.setIcon(iniciar);
        comboUsuario.setRequestFocusEnabled(true);
       
        AutoCompleteDecorator.decorate(comboUsuario, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        llenarCombo();
        llenarComboSucursal();
        ImageIcon logo = new ImageIcon("iconos/lavicentina.jpg");
        this.setIconImage(logo.getImage());
      
        if(!formatoSistema.equalsIgnoreCase("Administrador")){
        comboSucursales.setVisible(false);
        }

    }

    public final void llenarCombo() {
        UsuarioResponse res = api.getUsuarios(EnviromentLocal.urlG + "/usuarios/" + Datos.idSucursal);
        Usuario vacio = new Usuario();
        vacio.setIdUsuario(0);
        vacio.setNombre("");
        vacio.setTipo(1);
        vacio.setUsername("");

        comboUsuario.removeAllItems();
        comboUsuario.addItem(vacio);

        for (Usuario u : res.getUsuarios()) {
            u.setTipo(1);
            comboUsuario.addItem(u);
        }
        
        
    }
    
    public final void llenarComboSucursal(){
        SucursalResponse sucu = api.getSucursales(EnviromentLocal.urlG + "sucursales/" + Datos.propietario + "/" + 0);
        List<Sucursal> lista = sucu.getSucursal();
        
        for(Sucursal s: lista){
        comboSucursales.addItem(s);
        }
    }

    /*public void asignarFolioTicket() {
        try {
            TicketDAO tick = new TicketDAO();
            tick.consultarNumeroTicket();
        } catch (ClassNotFoundException ex) {

            Utilidades.confirma(confir, "Hubo un error con el sistema");
        } catch (SQLException ex) {

            System.out.println("Error " + ex.getLocalizedMessage() + "Asinar folio");
        }
    }*/

    public void efectivoInicial() throws ClassNotFoundException, SQLException {
        boolean ban = false;
        ResultSet rs;

        MovimientosExtrasResponse mov = api.getMovimientosExtrasGET(EnviromentLocal.urlG + "movimientos-efectivo-inicial/" + UsuarioDAO.idUsuario + "/" + Datos.idSucursal);

        if (mov.getMovimientos().isEmpty()) {
            EfectivoInicial objeto = new EfectivoInicial();
            objeto.setVisible(true);
            dispose();
        } else {
            Estructura objeto = new Estructura();
            objeto.setVisible(true);
            dispose();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        cajaSeguro = new javax.swing.JLabel();
        labelc = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        comboUsuario = new javax.swing.JComboBox<Usuario>();
        comboSucursales = new javax.swing.JComboBox<Sucursal>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Comenzar nuevo turno");

        jLabel2.setText("Por favor ingresa tu nombre de usuario y contraseña");

        label1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        label1.setText("USUARIO:");
        label1.setPreferredSize(new java.awt.Dimension(130, 35));

        labelc.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        labelc.setText("CONTRASEÑA:");
        labelc.setPreferredSize(new java.awt.Dimension(130, 35));

        password.setPreferredSize(new java.awt.Dimension(170, 35));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(153, 153, 255));
        btnIniciar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setBorder(null);
        btnIniciar.setPreferredSize(new java.awt.Dimension(250, 35));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(153, 153, 255));
        btnSalir.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setPreferredSize(new java.awt.Dimension(250, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        comboUsuario.setEditable(true);
        comboUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboUsuario.setModel(new javax.swing.DefaultComboBoxModel<Usuario>());
        comboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUsuarioActionPerformed(evt);
            }
        });

        comboSucursales.setEditable(true);
        comboSucursales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSucursales.setModel(new javax.swing.DefaultComboBoxModel<Sucursal>());
        comboSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSucursalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cajaSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboUsuario, 0, 276, Short.MAX_VALUE)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addComponent(labelc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(comboSucursales, javax.swing.GroupLayout.Alignment.TRAILING, 0, 276, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajaSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(labelc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        buscarUsuario();
    }//GEN-LAST:event_passwordActionPerformed

    public void buscarUsuario() {
        UsuarioDAO obj = new UsuarioDAO();
        Usuario usuario = (Usuario) comboUsuario.getSelectedItem();
        String pass = new String(password.getPassword());

        try {
            if (usuario.getPassword().equals(pass)) {
                //   obj.modificarFechaYhoraSesionUsuario();
                UsuarioDAO.idUsuario = usuario.getIdUsuario();
                UsuarioDAO.nombre = usuario.getNombre();
                UsuarioDAO.tipo = usuario.getTipoUsuario();
                UsuarioDAO.username = usuario.getUsername();
              //  Sucursal sucu= (Sucursal)comboSucursales.getSelectedItem();
            
                efectivoInicial();
            } else {
                mensaje("Usuario o contraseña incorrectos");
            }
        } catch (ClassNotFoundException ex) {
            Utilidades.confirma(confir, "Hubo un error en el sistema");
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            Utilidades.confirma(confir, ex.getLocalizedMessage());
        }
    }
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        buscarUsuario();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarUsuario();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void comboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUsuarioActionPerformed

    private void comboSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSucursalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSucursalesActionPerformed

    public void mensaje(String men) {
        confirma.setMensaje(men);
        confirma.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();

                comboUsuario.requestFocus();

            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel cajaSeguro;
    private javax.swing.JComboBox<Sucursal> comboSucursales;
    private javax.swing.JComboBox<Usuario> comboUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelc;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
