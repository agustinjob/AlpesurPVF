/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.venta.dao.AreaDAO;
import punto.venta.dao.Conexion;
import punto.venta.dao.ProductoDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.misclases.Producto;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class ProductoModificar extends javax.swing.JPanel {

    ProductoDAO obj = new ProductoDAO();
    Producto pTemporal = new Producto();
    ArrayList<Producto> lista = new ArrayList();
    Confirmacion confirma= new Confirmacion();
    AreaDAO objArea = new AreaDAO();
    
    public ProductoModificar() {
        initComponents();
        formulario.setVisible(false);
        obj.setConn(Conexion.conexi.getLocal());
        objArea.setConn(Conexion.conexi.getLocal());
        llenarCombo();  
        AutoCompleteDecorator.decorate(comboProductos, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }
    
    public void requerirFoco(){
    comboProductos.setFocusable(true);
    comboProductos.requestFocus();
    }
    
     public void requerirFoco2(){
    txtCodigo.requestFocus();
    }
    public void ocultarFormulario(){
   formulario.setVisible(false);
    }

     public void llenarCombo()  {
        lista = new ArrayList<Producto>();
        try {
            lista = obj.obtenerProductosSiHuboModificacion(lista, true);
             comboProductos.removeAllItems();
               comboProductos.addItem("");
        int i = 0;
      
        while (i < lista.size()) {
            comboProductos.addItem(lista.get(i).getNombre());
            i++;
        }
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(ProductoModificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            mensaje("Hubo un problema con la base de datos");
           
           
            
        }
       

    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<>();
        btn5 = new javax.swing.JButton();
        formulario = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecioCosto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cantidad = new javax.swing.JTextField();
        inventarioMinimo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtPrecioMayoreo = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox<>();
        txtPrecioDistribuidor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1365, 430));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel6.setText("Modificar producto");

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel11.setText("Teclee el número o nombre del producto:");

        comboProductos.setEditable(true);
        comboProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboProductos.setMaximumSize(new java.awt.Dimension(25, 25));
        comboProductos.setMinimumSize(new java.awt.Dimension(10, 10));
        comboProductos.setPreferredSize(new java.awt.Dimension(15, 25));
        comboProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboProductosKeyTyped(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 102, 0));
        btn5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btn5.setText("Aceptar");
        btn5.setBorder(null);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        btn5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn5KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formulario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(255, 204, 153));
        jLabel13.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel13.setText("Código de Barras");

        jLabel14.setBackground(new java.awt.Color(255, 204, 153));
        jLabel14.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel14.setText("Descripcion");

        jLabel15.setBackground(new java.awt.Color(255, 204, 153));
        jLabel15.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel15.setText("Precio costo");

        txtCodigo.setEnabled(false);
        txtCodigo.setPreferredSize(new java.awt.Dimension(300, 30));

        txtNombre.setPreferredSize(new java.awt.Dimension(300, 30));

        txtPrecioCosto.setPreferredSize(new java.awt.Dimension(300, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 153, 102));
        btnGuardar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnGuardar.setText("Modificar");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setPreferredSize(new java.awt.Dimension(180, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        cantidad.setPreferredSize(new java.awt.Dimension(250, 30));

        inventarioMinimo.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setText("Hay");

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setText("Mínimo");

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel10.setText("en este momento");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventarioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel12.setText("Precio venta");

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel16.setText("Precio mayoreo");

        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(300, 30));

        txtPrecioMayoreo.setPreferredSize(new java.awt.Dimension(300, 30));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 204, 153));
        jLabel18.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel18.setText("Área");

        txtPrecioDistribuidor.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel17.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel17.setText("Precio distribuidor");

        javax.swing.GroupLayout formularioLayout = new javax.swing.GroupLayout(formulario);
        formulario.setLayout(formularioLayout);
        formularioLayout.setHorizontalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(formularioLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecioDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formularioLayout.createSequentialGroup()
                                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(24, 24, 24)
                                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18)
                    .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        formularioLayout.setVerticalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(7, 7, 7)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(formulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed
  public void guardar(){
          Producto prod = new Producto();
        String a[] = new String[9];
        // `codigo`, `descripcion`, `precioCosto`, `precioVenta`, `precioMayoreo`, `cantidad`, `inventarioMinimo "
        a[0] = txtCodigo.getText();
        a[1] = txtNombre.getText();
        a[4] = txtPrecioMayoreo.getText();
        a[3] = txtPrecioVenta.getText();
        a[2] = txtPrecioCosto.getText();
        a[5] = cantidad.getText();
        a[6] = inventarioMinimo.getText();
        a[7] = (String)comboArea.getSelectedItem()!=null?(String)comboArea.getSelectedItem():"S/A";
        a[8] = txtPrecioDistribuidor.getText();

        boolean bandera = Utilidades.hayVacios(a);
        boolean banLimpiar = false;

        if (bandera == true) {
           mensaje("Por favor ingresa todos los datos solicitados");
           
        Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                 confirma.dispose();
                 txtCodigo.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
           

        } else {
           
            try{
                prod.setCodigo(a[0]);
                prod.setCantidad(Double.parseDouble(a[5]));
                prod.setInvMinimo(Integer.parseInt(a[6]));
                prod.setNombre(a[1]);
                prod.setpCosto(Double.parseDouble(a[2]));
                prod.setpMayoreo(Double.parseDouble(a[4]));
                prod.setpVenta(Double.parseDouble(a[3]));
                prod.setArea(a[7]);
                prod.setpDistribuidor(Double.parseDouble(a[8]));
                banLimpiar=true;
            }catch(NumberFormatException e){
                      Utilidades.escribirLog(e.getLocalizedMessage());
                  mensaje("Por favor ingresa el tipo de dato que se te solicita para dar de alta el producto");
                  Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                 confirma.dispose();
                 txtCodigo.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
                  
               
            }
            if(banLimpiar==true){
           
                    String x="";
                    Conexion.getConexiones();
                    String estatus="Actualizada";
                    if(Conexion.conexi.isInternet()){
                        obj.setConn(Conexion.conexi.getHost());
                        x=obj.modificarDatosProducto(prod, prod,"Actualizada","Modificacion");
                        if(!x.equalsIgnoreCase("Datos del producto modificados")){
                            estatus="En proceso";
                        }
                        obj.setConn(Conexion.conexi.getLocal());
                        x=obj.modificarDatosProducto(prod, prod,"Actualizada","Modificacion");
                    }else{
                        obj.setConn(Conexion.conexi.getLocal());
                        x=obj.modificarDatosProducto(prod, prod,"En proceso","Modificacion");
                    }
                    
                    
                    if(x.equalsIgnoreCase("Datos del producto modificados")){
                        formulario.setVisible(false);
                        mensaje(x);
                        Timer timer = new Timer(1000, new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                confirma.dispose();
                                comboProductos.requestFocus();
                            }
                            
                        });
                        
                        timer.setRepeats(false);
                        timer.start();
                    }  
                
           
              }
              

        }
                llenarCombo();
        
  }
    public void mensaje(String men){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    }

    public void buscarProducto(){
     String nombre = (String) comboProductos.getSelectedItem();

        Producto info = new Producto();
        info = obj.getDatosProducto(nombre, lista);
        pTemporal=info;

        if(info.getNombre().equalsIgnoreCase("")){
           mensaje("El producto no fue encontrado en la base de datos");
           Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 comboProductos.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
           

        }else{
            formulario.setVisible(true);

         
            txtCodigo.setText(info.getCodigo());
            txtNombre.setText(info.getNombre());
            txtPrecioVenta.setText(info.getpVenta() + "");
            txtPrecioCosto.setText(info.getpCosto()+"");
            txtPrecioMayoreo.setText(info.getpMayoreo()+"");
            cantidad.setText(info.getCantidad()+"");
            inventarioMinimo.setText(info.getInvMinimo()+"");
            txtCodigo.requestFocus();
            txtPrecioDistribuidor.setText(info.getpDistribuidor()+"");
            llenarComboArea(info.getArea());

        }

        comboProductos.setSelectedIndex(0);
    }
    
       public void llenarComboArea(String tipo) {
        comboArea.removeAllItems();
        comboArea.addItem(tipo);
        int i = 0;

       try {
                  
                   ResultSet areas= objArea.obtenerAreas();
                      
                if(areas!=null){
              
                   while (areas.next()) {
                     System.out.println(areas.getString(2));
                     System.out.println(tipo);
                       if(!areas.getString(2).trim().equalsIgnoreCase(tipo))
                       comboArea.addItem(areas.getString(2));
                       i++;
                   }  
                }
                
       } catch (SQLException ex) {
                 Utilidades.escribirLog(ex.getLocalizedMessage());
            Logger.getLogger(ProductoModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarProductoDesdeVentas(String nombre){
    Producto info = new Producto();
        info = obj.getDatosProducto(nombre, lista);

        if(info.getNombre().equalsIgnoreCase("")){
           mensaje("El producto no fue encontrado en la base de datos");
           Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 comboProductos.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
           

        }else{
            formulario.setVisible(true);

            
            txtCodigo.setText(info.getCodigo());
            txtNombre.setText(info.getNombre());
            txtPrecioVenta.setText(info.getpVenta() + "");
            txtPrecioCosto.setText(info.getpCosto()+"");
            txtPrecioMayoreo.setText(info.getpMayoreo()+"");
            txtPrecioDistribuidor.setText(info.getpDistribuidor()+"");
            cantidad.setText(info.getCantidad()+"");
            inventarioMinimo.setText(info.getInvMinimo()+"");
            txtCodigo.requestFocus();
            llenarComboArea(info.getArea());
            
        }
    }
    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed

        if(!comboProductos.getSelectedItem().toString().equalsIgnoreCase("")){
            buscarProducto();
        }else{
             mensaje("Por favor selecciona un producto");
           Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 comboProductos.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
        }
      
    }//GEN-LAST:event_btn5ActionPerformed

    private void comboProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboProductosKeyTyped
     

    }//GEN-LAST:event_comboProductosKeyTyped

    private void btn5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn5KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
       if(!comboProductos.getSelectedItem().toString().equalsIgnoreCase("")){
            buscarProducto();
        }else{
         mensaje("Por favor selecciona un producto");
           Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 comboProductos.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
        }
        }

    }//GEN-LAST:event_btn5KeyPressed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      guardar();
        }

    }//GEN-LAST:event_btnGuardarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn5;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> comboArea;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JPanel formulario;
    private javax.swing.JTextField inventarioMinimo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCosto;
    private javax.swing.JTextField txtPrecioDistribuidor;
    private javax.swing.JTextField txtPrecioMayoreo;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
