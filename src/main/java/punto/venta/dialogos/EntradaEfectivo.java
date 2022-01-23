/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import punto.venta.dao.Conexion;
import punto.venta.dao.Movimientos;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;

/**
 *
 * @author agus_
 */
public class EntradaEfectivo extends javax.swing.JFrame {

     Movimientos obj = new Movimientos();
     Confirmacion confirma= new Confirmacion();
     int ocultar = 0;
     VentasEstructura ventas;
     
     
    public EntradaEfectivo(VentasEstructura ventas) {
        initComponents();
        setTitle("Registro de Entradas de Efectivo");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("iconos/punto-de-venta.png").getImage());
        ImageIcon a = new ImageIcon("iconos/check.png");
        ImageIcon b = new ImageIcon("iconos/cancelar.png");
        ImageIcon c = new ImageIcon("iconos/entradas_pasadas.png");
        obj.setConn(Conexion.conexi.getLocal());
        btnguardaref.setIcon(a);
        btnc.setIcon(b);
        btnverEntradas.setIcon(c);
        txtcantidade.requestFocus();
        this.ventas= ventas;
        setSize(550, 235);
    }

      public void mensaje(String men){
    confirma.setMensaje(men);
    confirma.setVisible(true);
    
    Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                 txtcantidade.requestFocus();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
    }

    public void limpiaTabla() {
        DefaultTableModel tm = (DefaultTableModel) tablaEntradas.getModel();
        int r = 0;
        while (tm.getRowCount() > r) {
            tm.removeRow(r);
        }
    }

    public void actualizaTabla() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaEntradas.getModel();
            
            
            ResultSet rs = obj.getEntradasDelDia("entrada_efectivo");
            String[] x = new String[3];
            if (rs == null) {

            } else {
                while (rs.next()) {

                    x[0] = rs.getString(3);
                    x[1] = rs.getString(4);
                    x[2] = rs.getString(5);
                    System.out.println("Datos resultados = " + rs.getString(2));
                    System.out.println("Datos resultados = " + x[0]);
                    modelo.addRow(x);

                }
                tablaEntradas.setModel(modelo);
            }
        } catch (ClassNotFoundException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            mensaje ("Hubo un error en el sistema");
        } catch (SQLException ex) {
                  Utilidades.escribirLog(ex.getLocalizedMessage());
            mensaje ("Hubo un error con la conexión a la base de datos");
        }
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnguardaref = new javax.swing.JButton();
        btnc = new javax.swing.JButton();
        btnverEntradas = new javax.swing.JButton();
        txtcantidade = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntradas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 250));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 56, 61, 18);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(12, 153, 300, 35);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Comentarios:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 121, 84, 21);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 250));

        btnguardaref.setBackground(new java.awt.Color(0, 153, 153));
        btnguardaref.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnguardaref.setForeground(new java.awt.Color(255, 255, 255));
        btnguardaref.setText("Guardar");
        btnguardaref.setBorder(null);
        btnguardaref.setPreferredSize(new java.awt.Dimension(150, 35));
        btnguardaref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarefActionPerformed(evt);
            }
        });
        btnguardaref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarefKeyPressed(evt);
            }
        });

        btnc.setBackground(new java.awt.Color(0, 153, 153));
        btnc.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnc.setForeground(new java.awt.Color(255, 255, 255));
        btnc.setText("Salir");
        btnc.setBorder(null);
        btnc.setPreferredSize(new java.awt.Dimension(150, 35));
        btnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncActionPerformed(evt);
            }
        });

        btnverEntradas.setBackground(new java.awt.Color(0, 153, 153));
        btnverEntradas.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnverEntradas.setForeground(new java.awt.Color(255, 255, 255));
        btnverEntradas.setText("Ver entradas ");
        btnverEntradas.setBorder(null);
        btnverEntradas.setPreferredSize(new java.awt.Dimension(150, 35));
        btnverEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverEntradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardaref, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnverEntradas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnguardaref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnverEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(350, 0, 180, 490);

        txtcantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtcantidade);
        txtcantidade.setBounds(12, 80, 300, 35);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENTRADAS DE EFECTIVO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 87, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(2, 2, 340, 24);

        tablaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Monto", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEntradas);
        if (tablaEntradas.getColumnModel().getColumnCount() > 0) {
            tablaEntradas.getColumnModel().getColumn(0).setResizable(false);
            tablaEntradas.getColumnModel().getColumn(0).setPreferredWidth(125);
            tablaEntradas.getColumnModel().getColumn(1).setResizable(false);
            tablaEntradas.getColumnModel().getColumn(1).setPreferredWidth(25);
            tablaEntradas.getColumnModel().getColumn(2).setResizable(false);
            tablaEntradas.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 330, 250);

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Entradas realizadas en el turno");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 200, 290, 18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarefActionPerformed
guardar();
    }//GEN-LAST:event_btnguardarefActionPerformed

    public void guardar(){
    
        String a[] =  new String[2];
        a[0]= jTextField1.getText();
        a[1]= txtcantidade.getText();

        if(Utilidades.hayVacios(a)){
            mensaje("Por favor ingresa todos los datos");

        }else{

            try {
                double tem = Double.parseDouble(a[1]);
                
                obj.registrarEfectivoInicial(txtcantidade.getText(),"entrada_efectivo",jTextField1.getText(), "Actualizada","Registro");
                String men="Se ha realizado el registro de efectivo correctamente";
                confirma.setMensaje(men);
    confirma.setVisible(true);
    
    Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 confirma.dispose();
                
                }
                
            });
            jTextField1.setText("");
            txtcantidade.setText("");
            timer.setRepeats(false);
            timer.start();
              
                
                this.dispose();

            } catch (ClassNotFoundException ex) {
                      Utilidades.escribirLog(ex.getLocalizedMessage());
                mensaje ("Hubo un error en el sistema");
            } catch (SQLException ex) {
                      Utilidades.escribirLog(ex.getLocalizedMessage());
                mensaje ("Hubo un error con la conexión a la base de datos");
            }catch(NumberFormatException e){
                      Utilidades.escribirLog(e.getLocalizedMessage());
                mensaje ("Por favor, revisa los datos ingresados");
            }

        }
    }
    private void btncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncActionPerformed
    
        dispose();
    }//GEN-LAST:event_btncActionPerformed

    private void btnverEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverEntradasActionPerformed
 if (ocultar == 0) {
            btnverEntradas.setText("Ocultar salidas");
            setSize(550, 525);
            actualizaTabla();
            ocultar = 1;
        } else {
            btnverEntradas.setText("Mostrar salidas");
            setSize(550, 235);
            ocultar = 0;
            limpiaTabla();
        }      
    }//GEN-LAST:event_btnverEntradasActionPerformed

    private void txtcantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadeActionPerformed
       guardar();
    }//GEN-LAST:event_txtcantidadeActionPerformed

    private void btnguardarefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarefKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        guardar();
        }
    }//GEN-LAST:event_btnguardarefKeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        guardar();
    }//GEN-LAST:event_jTextField1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnc;
    private javax.swing.JButton btnguardaref;
    private javax.swing.JButton btnverEntradas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaEntradas;
    private javax.swing.JTextField txtcantidade;
    // End of variables declaration//GEN-END:variables
}
