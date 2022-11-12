/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.dialogos;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.servicio.rest.FechaYHora;
import punto.servicio.rest.RestDatos;
import punto.venta.dao.ClienteDAO;

import punto.venta.dao.Datos;
import punto.venta.dao.VentasDAO;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.misclases.ImprimirTicket;
import punto.venta.modelo.Cliente;
import punto.venta.modelo.Ventas;
import punto.venta.modelo.VentasModel;
import punto.venta.modelo.response.ClienteResponse;
import punto.venta.modelo.response.ResponseGeneral;
import punto.venta.modelo.response.TicketResponse;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;
import static punto.venta.ventanas.VentasEstructura.ti;

/**
 *
 * @author agus_
 */
public class Cobrar extends javax.swing.JFrame {

    DefaultTableModel md;
    VentasDAO ventas = new VentasDAO();
    VentasEstructura ven3;
    Confirmacion confirma = new Confirmacion();
    ClienteDAO obj = new ClienteDAO();
    ArrayList<Cliente> c;
    Cliente cliente = new Cliente();
    int tipoVenta = 1; // Efectivo
    int indexTabbed = 0;
    ApiSend api = new ApiSend();

    public Cobrar(VentasEstructura ven3, DefaultTableModel md, int indexTabbed) {
        initComponents();
        setTitle("Cobro");
        setLocationRelativeTo(null);
        ImageIcon a = new ImageIcon("iconos/dinero33.png");
        ImageIcon d = new ImageIcon("iconos/impresora.png");
        ImageIcon e = new ImageIcon("iconos/facturar_ticket.png");
        ImageIcon f = new ImageIcon("iconos/cancelar.png");
        ImageIcon g = new ImageIcon("iconos/hoja.png");
        ImageIcon cli = new ImageIcon("iconos/clientesGrande.png");
        setIconImage(new ImageIcon("iconos/punto-de-venta.png").getImage());
        btnefectivo.setIcon(a);
        btnCredito.setIcon(cli);
        btn1.setIcon(d);
        btn2.setIcon(e);
        btn3.setIcon(f);
        this.ven3 = ven3;
        this.md = md;
        this.indexTabbed = indexTabbed;
        panelClientes.setVisible(false);
        txtn1.requestFocus();
        llenarCombo();
        comboClientes.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == 112) {
                    imprimeTicket();
                }
                if (evt.getKeyCode() == 113) {
                    soloRegistraVenta();
                }
                if (evt.getKeyCode() == 27) {
                    cerrar();
                }
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (((JTextComponent) ((JComboBox) ((Component) evt
                            .getSource()).getParent()).getEditor()
                            .getEditorComponent()).getText().isEmpty()) {
                        mensaje("Por favor selecciona un cliente", 2);
                    } else {
                        btnCredito.requestFocus();
                    }

                }
            }
        });

        AutoCompleteDecorator.decorate(comboClientes, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        ImageIcon logo = new ImageIcon("iconos/lavicentina.jpg");
        this.setIconImage(logo.getImage());
    }

    public void cerrar() {
        this.dispose();
    }

    public void requerirFoco() {
        txtn1.requestFocus();
    }

    public void llenarCombo() {
        comboClientes.removeAllItems();
        Cliente vacio = new Cliente();
        vacio.setIdCliente(0);
        ClienteResponse res = api.getClientes(EnviromentLocal.urlG + "clientes/" + Datos.idSucursal);
        comboClientes.addItem(vacio);

        for (Cliente c : res.getClientes()) {
            comboClientes.addItem(c);

        }

    }

    public boolean buscarCliente() {
        Cliente cli = (Cliente) comboClientes.getSelectedItem();
        if (cli.getIdCliente() == 0) {
            mensaje("Datos del cliente no encontrados", tipoVenta);
            return false;
        } else {
            System.out.println("Si lo Encontro al cliente");
            return true;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtn2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnCredito = new javax.swing.JButton();
        btnefectivo = new javax.swing.JButton();
        panelEfectivo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtresultado = new javax.swing.JTextField();
        txtn1 = new javax.swing.JTextField();
        panelClientes = new javax.swing.JPanel();
        comboClientes = new javax.swing.JComboBox<Cliente>();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        numArticulos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(420, 470));

        txtn2.setEditable(false);
        txtn2.setFont(new java.awt.Font("Cambria", 0, 48)); // NOI18N
        txtn2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtn2.setBorder(null);
        txtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtn2ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        btnCredito.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnCredito.setText("Credito");
        btnCredito.setBorderPainted(false);
        btnCredito.setContentAreaFilled(false);
        btnCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCredito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCredito.setIconTextGap(-3);
        btnCredito.setPreferredSize(new java.awt.Dimension(120, 100));
        btnCredito.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCredito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });
        btnCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCreditoKeyPressed(evt);
            }
        });

        btnefectivo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnefectivo.setBorderPainted(false);
        btnefectivo.setContentAreaFilled(false);
        btnefectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnefectivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnefectivo.setIconTextGap(-3);
        btnefectivo.setLabel("Efectivo");
        btnefectivo.setPreferredSize(new java.awt.Dimension(120, 100));
        btnefectivo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnefectivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnefectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnefectivoActionPerformed(evt);
            }
        });
        btnefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnefectivoKeyPressed(evt);
            }
        });

        panelEfectivo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel7.setText("Su cambio");

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel8.setText("Pagó con");

        txtresultado.setEditable(false);
        txtresultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtresultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtresultadoActionPerformed(evt);
            }
        });
        txtresultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtresultadoKeyPressed(evt);
            }
        });

        txtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtn1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtn1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelEfectivoLayout = new javax.swing.GroupLayout(panelEfectivo);
        panelEfectivo.setLayout(panelEfectivoLayout);
        panelEfectivoLayout.setHorizontalGroup(
            panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEfectivoLayout.createSequentialGroup()
                        .addComponent(txtresultado)
                        .addGap(6, 6, 6))
                    .addGroup(panelEfectivoLayout.createSequentialGroup()
                        .addComponent(txtn1)
                        .addGap(4, 4, 4))))
        );
        panelEfectivoLayout.setVerticalGroup(
            panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectivoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEfectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtresultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addComponent(panelEfectivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnefectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelClientes.setBackground(new java.awt.Color(255, 255, 255));

        comboClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<Cliente>());
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });
        comboClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboClientesKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(txtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );

        jPanel13.setBackground(new java.awt.Color(0, 0, 153));
        jPanel13.setPreferredSize(new java.awt.Dimension(420, 40));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("COBRAR");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel9)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel15.setBackground(new java.awt.Color(153, 204, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(280, 520));

        btn1.setBackground(new java.awt.Color(204, 204, 255));
        btn1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btn1.setText("F1-Cobrar e imprimir ticket");
        btn1.setBorder(null);
        btn1.setPreferredSize(new java.awt.Dimension(255, 40));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(204, 204, 255));
        btn2.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        btn2.setText("F2-Cobrar solo registrando la venta ");
        btn2.setBorder(null);
        btn2.setPreferredSize(new java.awt.Dimension(255, 40));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(204, 204, 255));
        btn3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btn3.setText("ESC-Cancelar");
        btn3.setBorder(null);
        btn3.setPreferredSize(new java.awt.Dimension(255, 40));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel11.setText("Total de Artículos");

        numArticulos.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        numArticulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numArticulos.setText("1");
        numArticulos.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addComponent(numArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtn2ActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        tipoVenta = 2; // Credito
        panelClientes.setVisible(true);
        panelEfectivo.setVisible(false);
        comboClientes.requestFocus();

    }//GEN-LAST:event_btnCreditoActionPerformed

    public void mensaje(String men, int tipo) {
        confirma.setMensaje(men);
        confirma.setVisible(true);

        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                if (tipo == 1) {
                    //efectivo
                    txtn1.requestFocus();
                } else {
                    comboClientes.requestFocus();
                }
            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    public VentasModel modeloAVentasModel(DefaultTableModel md, int idTicket, int idCliente) {
        VentasModel res = new VentasModel();
        List<Ventas> ven = new ArrayList<>();
        int i = 0;
        while (i < md.getRowCount()) {
            Ventas v = new Ventas();
            v.setCodigo((String) md.getValueAt(i, 0));
            v.setNombre((String) md.getValueAt(i, 1));
            v.setPrecioVenta(Float.parseFloat((String) md.getValueAt(i, 2)));
            v.setCantidad(Float.parseFloat((String) md.getValueAt(i, 3)));
            v.setImporte(Float.parseFloat((String) md.getValueAt(i, 4)));
            v.setPrecioCosto(Float.parseFloat((String) md.getValueAt(i, 6)));
            v.setIdTicket(idTicket);
            v.setIdCliente(idCliente);
            v.setIdVenta(0);
            v.setTipoCompra(tipoVenta == 2 ? "Credito" : "Efectivo");
            v.setFinalizada(tipoVenta == 2 ? false : true);

            i++;
            ven.add(v);
        }
        res.setVentas(ven);

        return res;
    }

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        imprimeTicket();

    }//GEN-LAST:event_btn1ActionPerformed
    public void imprimeTicket() {
        ImprimirTicket obj = new ImprimirTicket();
        String x = "";
        VentasEstructura.ti.getSerial();

        boolean ban = true;

        Integer idCliente = 0;
        if (tipoVenta == 2) {
            Cliente c = (Cliente) comboClientes.getSelectedItem();
            idCliente = c.getIdCliente();
        }
        if (ban == true) {

            //    x= ventas.registrarVenta(md, tipoVenta, idCliente, "Local", "Actualizada", "Registro", numTic);
            ResponseGeneral resul = api.usarAPI(EnviromentLocal.urlG + "ventas", modeloAVentasModel(md, ti.getSerial(), idCliente), "POST");
            ti.setSerial(ti.getSerial() + 1);
                  ti.setActualizada(null);
            TicketResponse resTicket = api.usarAPITicket(EnviromentLocal.urlG + "ticket/guardar", ti);
            x = resul.getMensaje();

            String res = obj.convertirModeloAString(md, txtn2.getText());
            obj.imprimirTicket(res);
            ven3.eliminaCelda(2);
            ven3.tablas[indexTabbed].setNumArticulos(0);
            ven3.tablas[indexTabbed].setTotal(0);
            ven3.llenarCombo();
            ti=resTicket.getTickets().get(0);
            ven3.actualizaTicket(ti.getSerial() + "");
            ven3.requerirFoco();

            this.dispose();
            mensaje(x, tipoVenta);

        }

    }
    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        soloRegistraVenta();
    }//GEN-LAST:event_btn2ActionPerformed
    public void soloRegistraVenta() {
    

            boolean ban = true;
            Integer idCliente = 0;
            if (tipoVenta == 2) {
                Cliente c = (Cliente) comboClientes.getSelectedItem();
                if (ban == true) {
                    idCliente = c.getIdCliente();
                    double totalPro = Double.parseDouble(txtn2.getText());
                    String saldoC = api.getDato(EnviromentLocal.urlG + "saldo-cliente/" + idCliente + "/" + Datos.idSucursal);
                    double saldo = Double.parseDouble(saldoC);
                    double totalTotal = totalPro + saldo;
                    if (totalTotal > c.getLimiteCredito()) {
                        ban = false;
                        mensaje("Esta compra sobre pasa el limite de credito asignado al cliente", tipoVenta);
                    }
                }
            }
            if (ban == true) {
                String x = "";


                //  x = ventas.registrarVenta(md, tipoVenta, idCliente, "Local", "Actualizada", "Registro", numTic);
                ResponseGeneral resul = api.usarAPI(EnviromentLocal.urlG + "ventas", modeloAVentasModel(md, ti.getSerial(), idCliente), "POST");
                x = resul.getMensaje();
                ti.setSerial(ti.getSerial() + 1);
                ti.setActualizada(null);
            TicketResponse resTicket = api.usarAPITicket(EnviromentLocal.urlG + "ticket/guardar", ti);
                if (resul.isRealizado()) {
                    ven3.eliminaCelda(2);
                    ven3.tablas[indexTabbed].setNumArticulos(0);
                    ven3.tablas[indexTabbed].setTotal(0); // mod aqui
 ti=resTicket.getTickets().get(0);
                    ven3.llenarCombo();
                    ven3.actualizaTicket(ti.getSerial() + "");
                    ven3.requerirFoco();
                    this.dispose();
                }

                mensaje(x, tipoVenta);

            }


    }
    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        this.dispose();

    }//GEN-LAST:event_btn3ActionPerformed

    private void btnefectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnefectivoActionPerformed
        tipoVenta = 1; // Efectivo
        panelClientes.setVisible(false);
        panelEfectivo.setVisible(true);
        txtn1.requestFocus();
    }//GEN-LAST:event_btnefectivoActionPerformed

    private void txtn1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtn1KeyReleased
        int nu = evt.getKeyCode();
        if (nu == 96 || nu == 97 || nu == 98 || nu == 99 || nu == 100 || nu == 101 || nu == 102 || nu == 103 || nu == 104 || nu == 105 || nu == 48 || nu == 49 || nu == 50 || nu == 51 || nu == 52
                || nu == 53 || nu == 54 || nu == 55 || nu == 56 || nu == 57) {
            double n1, n2, result = 0;
            n1 = Double.parseDouble(txtn1.getText());
            n2 = Double.parseDouble(txtn2.getText());
            System.out.println("N1 = " + n1);
            if (n2 <= n1) {
                result = n1 - n2;
                txtresultado.setText("" + result);
            }
        } else {

        }
    }//GEN-LAST:event_txtn1KeyReleased

    private void txtresultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtresultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtresultadoActionPerformed

    private void txtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtn1KeyPressed
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtn1KeyPressed

    private void btnefectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnefectivoKeyPressed
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnefectivoKeyPressed

    private void btnCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCreditoKeyPressed
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_btnCreditoKeyPressed

    private void txtresultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtresultadoKeyPressed
        teclaPresionada(evt.getKeyCode());
    }//GEN-LAST:event_txtresultadoKeyPressed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        // btnCredito.requestFocus();
        // Utilidades.im("Info  " + KeyEvent.);
    }//GEN-LAST:event_comboClientesActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        btnCredito.requestFocus();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void comboClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyPressed

    }//GEN-LAST:event_comboClientesKeyPressed

    public void teclaPresionada(int num) {
        Utilidades.im("Entro al metodo");
        if (num == 112) {
            imprimeTicket();
        }

        if (num == 113) {
            soloRegistraVenta();
        }

        if (num == 27) {
            this.dispose();
            ven3.requerirFoco();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnefectivo;
    private javax.swing.JComboBox<Cliente> comboClientes;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    public javax.swing.JLabel numArticulos;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelEfectivo;
    public static javax.swing.JTextField txtn1;
    public static javax.swing.JTextField txtn2;
    private javax.swing.JTextField txtresultado;
    // End of variables declaration//GEN-END:variables
}
