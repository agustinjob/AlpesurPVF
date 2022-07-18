/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import bd.PanelTabla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import punto.servicio.rest.ApiSend;
import punto.venta.dao.Conexion;
import punto.venta.dao.Datos;
import punto.venta.dao.ProductoDAO;
import punto.venta.dao.TicketDAO;
import punto.venta.dialogos.BusquedaProductos;
import punto.venta.dialogos.Cobrar;
import punto.venta.dialogos.Confirmacion;
import punto.venta.dialogos.Devoluciones;
import punto.venta.dialogos.EntradaEfectivo;
import punto.venta.dialogos.InsVarios;
import punto.venta.dialogos.SalidaEfectivo;
import punto.venta.enviroment.EnviromentLocal;
import punto.venta.modelo.Producto;
import punto.venta.modelo.Usuario;
import punto.venta.modelo.response.ProductoResponse;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author job
 */
public class VentasEstructura extends javax.swing.JPanel implements ActionListener, KeyListener {

    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Código de barras", "Descripcion de producto", "Precio venta", "Cant", "importe", "Existencia", "Precio Costo"};
    int filas;
    ProductoDAO obj = new ProductoDAO();
    List<Producto> listaPro = new ArrayList();
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    public static int tipoPrecio;
    private Usuario usu;
    // public double total[] = new double[5];
    //public int numeroArticulos[] = new int [5];
    TicketDAO tick = new TicketDAO();
    Confirmacion confirma = new Confirmacion();
    private Dimension dim;
    Estructura e;
    public PanelTabla tablas[] = new PanelTabla[5];
    int ultimaPestanaSeleccionada = 0;
    ApiSend api = new ApiSend();

    public VentasEstructura() {

        initComponents();
        btnNSVarios.setVisible(false);
        btnNSVarios.setEnabled(false);
        tipoPrecio = 1;
        md = new DefaultTableModel();
        //   this.txtTabla.setModel(md);
        txtCodigo.requestFocus();
        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4 || column == 2 ? true : false;
            }
        };
        inicializarIconos();

        txtTicket.setText("Folio del ticket: " + tick.getNumero());
        addKeyListener(this);
        Utilidades.im("Entro a ventas");
        Utilidades.im("" + this.hasFocus());
        inicializaTabbed();

    }

    public void mensaje(String men, int tipo) {
        confirma.setMensaje(men);
        confirma.setVisible(true);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirma.dispose();
                if (tipo == 1) {
                    txtCodigo.requestFocus();
                }

                if (tipo == 2) {
                    comboProductos.requestFocus();
                }
            }

        });

        timer.setRepeats(false);
        timer.start();
    }

    public void inicializaTabbed() {
        tablas[0] = new PanelTabla(txtTotal, this);
        tablas[1] = new PanelTabla(txtTotal, this);
        tablas[2] = new PanelTabla(txtTotal, this);
        tablas[3] = new PanelTabla(txtTotal, this);
        tablas[4] = new PanelTabla(txtTotal, this);
        tablas[0].setObjVentas(this);
        tablas[1].setObjVentas(this);
        tablas[2].setObjVentas(this);
        tablas[3].setObjVentas(this);
        tablas[4].setObjVentas(this);
        // total[0]=0.0d;
        // total[1]=0.0d;
        // total[2]=0.0d;
        // total[3]=0.0d;
        /* total[4]=0.0d;
    numeroArticulos[0]=0;
    numeroArticulos[1]=0;
    numeroArticulos[2]=0;
    numeroArticulos[3]=0;
    numeroArticulos[4]=0;*/
        jTabbedPane1.addTab("Ticket A", tablas[0]);
        jTabbedPane1.addTab("Ticket B", tablas[1]);
        jTabbedPane1.addTab("Ticket C", tablas[2]);
        jTabbedPane1.addTab("Ticket D", tablas[3]);
        jTabbedPane1.addTab("Ticket E", tablas[4]);
    }

    public void setEstructura(Estructura e) {
        this.e = e;
    }

    public Estructura getEstructura() {
        return e;
    }

    public void actualizaTicket(String tik) {
        txtTicket.setText("Folio del ticket: " + tik);
        txtTotal.setText("");
    }

    public void requerirFoco() {
        txtCodigo.setFocusable(true);
        txtCodigo.requestFocus();
    }

    public void llenarCombo() {

        comboProductos.removeAllItems();
        Producto vacio = new Producto();
        vacio.setIdProducto(0);
        comboProductos.addItem(vacio);

        ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos/" + Datos.idSucursal);

        for (Producto p : res.getProductos()) {
            comboProductos.addItem(p);
        }

    }

    /* public void centrarValoresTabla() {
        JTableHeader tablaCabe = txtTabla.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer) txtTabla.getTableHeader().getDefaultRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCabe.setDefaultRenderer(render);
        txtTabla.setModel(md);
        dt.setHorizontalAlignment(SwingConstants.CENTER);
        txtTabla.getColumnModel().getColumn(0).setCellRenderer(dt);

        txtTabla.getColumnModel().getColumn(1).setCellRenderer(dt);
        txtTabla.getColumnModel().getColumn(2).setCellRenderer(dt);
        txtTabla.getColumnModel().getColumn(3).setCellRenderer(dt);
        txtTabla.getColumnModel().getColumn(4).setCellRenderer(dt);
        txtTabla.getColumnModel().getColumn(5).setCellRenderer(dt);

        txtTabla.getColumnModel().getColumn(6).setWidth(0);
        txtTabla.getColumnModel().getColumn(6).setMinWidth(0);
        txtTabla.getColumnModel().getColumn(6).setMaxWidth(0);
        txtTabla.setRowHeight(30);
    }*/
    public boolean revisarRepetidos(String codigo) {

        DefaultTableModel modelo = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
        int i = 0;

        while (i < modelo.getRowCount()) {
            if (modelo.getValueAt(i, 0).equals(codigo) || modelo.getValueAt(i, 1).equals(codigo)) {
                String cantidad = (String) modelo.getValueAt(i, 3);
                double numero = Double.parseDouble(cantidad);
                String pre = (String) modelo.getValueAt(i, 2);
                double precio = Double.parseDouble(pre);
                numero = numero + 1;
                double to = precio * numero;
                modelo.setValueAt(numero + "", i, 3);
                modelo.setValueAt(to + "", i, 4);
                tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + precio);
                txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");
                tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() + 1);
                return true;
            }
            i++;
        }
        return false;
    }

    public void eliminaCelda(int tipoEliminacion) {

        DefaultTableModel tm = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
        int tamano = tm.getRowCount();
        if (tipoEliminacion == 1) {
            if (tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow() >= 0) {
                if (tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow(), 0) == null) {
                    Utilidades.mensajePorTiempo("La fila que selecciono ,no cuenta con ningún producto");
                } else {

                    double resta = Double.parseDouble((String) tm.getValueAt(tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow(), 4));
                    tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() - resta);
                    tm.removeRow(tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow());
                    txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");

                    if (tamano > 0) {
                        tamano = tamano - 2;
                        tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano, 0, false, false);
                    }
                }
            } else {
                mensaje("No haz seleccionado ninguna fila", 1);

            }

        } else {

            int r = 0;
            while (tm.getRowCount() > r) {
                tm.removeRow(r);
            }

        }
    }

    /*
    public void actualizarImporteTabla() {
        DefaultTableModel tm = (DefaultTableModel) txtTabla.getModel();
        numeroArticulos = 0;
        total = 0;
        for (int i = 0; i < tm.getRowCount(); i++) {
            double precio = Double.parseDouble((String) tm.getValueAt(i, 2));
            double cantidad = Double.parseDouble((String) tm.getValueAt(i, 3));
            double inventario = Double.parseDouble((String) tm.getValueAt(i, 5));
            numeroArticulos = (int) (numeroArticulos + cantidad);
            if (cantidad > inventario) {
                mensaje("La cantidad de productos a vender es mayor que el número de productos en inventario");
                tm.removeRow(i);
            } else {
                double suma = precio * cantidad;
                tm.setValueAt(suma + "", i, 4);
                total = total + suma;
            }

        }

        txtTotal.setText(total + "");
    }
     */
    public boolean masCantidadQueInventario() {

        DefaultTableModel model = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
        int i = 0;
        while (i < model.getRowCount()) {
            String cantidad = (String) model.getValueAt(i, 3);
            String inventario = (String) model.getValueAt(i, 5);
            String pVenta = (String) model.getValueAt(i, 2);
            System.out.println("Cantidad " + cantidad + " Inventario " + inventario);
            double can = Double.parseDouble(cantidad);
            double inv = Double.parseDouble(inventario);
            Double.parseDouble(pVenta);
            if (can > inv) {
                JOptionPane.showMessageDialog(null, "Revisa los datos, ingresaste más cantidad de un producto de lo que tienes en inventario");
                return true;
            }
            i++;
        }

        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<Producto>();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtagregar = new javax.swing.JButton();
        txtTicket = new javax.swing.JLabel();
        panelSuperiorBotones = new javax.swing.JPanel();
        btn10 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnBusqueda = new javax.swing.JButton();
        btnNSVarios = new javax.swing.JButton();
        panelDevo = new javax.swing.JPanel();
        btndevoluciones = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btnReiniciarFolio = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btn8 = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelTicket.setBackground(new java.awt.Color(102, 0, 102));
        panelTicket.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelTicketFocusGained(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTAS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1500, 40));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Nombre  producto:");

        comboProductos.setEditable(true);
        comboProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<Producto>());
        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Código:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtagregar.setBackground(new java.awt.Color(0, 51, 153));
        txtagregar.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtagregar.setForeground(new java.awt.Color(255, 255, 255));
        txtagregar.setBorder(null);
        txtagregar.setLabel("Agregar Producto");
        txtagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtagregarActionPerformed(evt);
            }
        });
        txtagregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtagregarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 16, Short.MAX_VALUE))
        );

        txtTicket.setText("Folio ticket:");

        panelSuperiorBotones.setBackground(new java.awt.Color(255, 255, 255));
        panelSuperiorBotones.setLayout(new java.awt.GridLayout(1, 8));

        btn10.setBackground(new java.awt.Color(0, 51, 153));
        btn10.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn10.setForeground(new java.awt.Color(255, 255, 255));
        btn10.setText("F6 Venta");
        btn10.setBorder(null);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn10);

        btn3.setBackground(new java.awt.Color(0, 51, 153));
        btn3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("F11 Mayoreo");
        btn3.setBorder(null);
        btn3.setMaximumSize(new java.awt.Dimension(100, 19));
        btn3.setPreferredSize(new java.awt.Dimension(100, 19));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn3);

        btn9.setBackground(new java.awt.Color(0, 51, 153));
        btn9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("F9 Distribuidor");
        btn9.setBorder(null);
        btn9.setMaximumSize(new java.awt.Dimension(120, 19));
        btn9.setPreferredSize(new java.awt.Dimension(140, 19));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn9);

        btn4.setBackground(new java.awt.Color(0, 51, 153));
        btn4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("F7 Entradas");
        btn4.setBorder(null);
        btn4.setPreferredSize(new java.awt.Dimension(85, 19));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn4);

        btn5.setBackground(new java.awt.Color(0, 51, 153));
        btn5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("F8 Salidas");
        btn5.setBorder(null);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn5);

        btn6.setBackground(new java.awt.Color(0, 51, 153));
        btn6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("DEL Borrar Art");
        btn6.setBorder(null);
        btn6.setMaximumSize(new java.awt.Dimension(125, 19));
        btn6.setPreferredSize(new java.awt.Dimension(125, 19));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btn6);

        btnBusqueda.setBackground(new java.awt.Color(0, 51, 153));
        btnBusqueda.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        btnBusqueda.setText("F10 Busqueda");
        btnBusqueda.setBorder(null);
        btnBusqueda.setMaximumSize(new java.awt.Dimension(140, 19));
        btnBusqueda.setPreferredSize(new java.awt.Dimension(140, 19));
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btnBusqueda);

        btnNSVarios.setBackground(new java.awt.Color(0, 51, 153));
        btnNSVarios.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnNSVarios.setForeground(new java.awt.Color(255, 255, 255));
        btnNSVarios.setText("F2 Busqueda");
        btnNSVarios.setBorder(null);
        btnNSVarios.setMaximumSize(new java.awt.Dimension(140, 19));
        btnNSVarios.setPreferredSize(new java.awt.Dimension(140, 19));
        btnNSVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSVariosActionPerformed(evt);
            }
        });
        panelSuperiorBotones.add(btnNSVarios);

        panelDevo.setBackground(new java.awt.Color(255, 255, 255));
        panelDevo.setLayout(new java.awt.GridLayout(1, 0));

        btndevoluciones.setBackground(new java.awt.Color(0, 51, 153));
        btndevoluciones.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btndevoluciones.setForeground(new java.awt.Color(255, 255, 255));
        btndevoluciones.setText("Devoluciones");
        btndevoluciones.setBorder(null);
        btndevoluciones.setPreferredSize(new java.awt.Dimension(150, 35));
        btndevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndevolucionesActionPerformed(evt);
            }
        });
        panelDevo.add(btndevoluciones);

        btn7.setBackground(new java.awt.Color(0, 51, 153));
        btn7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("Eliminar Todo");
        btn7.setBorder(null);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        panelDevo.add(btn7);

        btnReiniciarFolio.setBackground(new java.awt.Color(0, 51, 153));
        btnReiniciarFolio.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnReiniciarFolio.setForeground(new java.awt.Color(255, 255, 255));
        btnReiniciarFolio.setText("Reiniciar folio");
        btnReiniciarFolio.setBorder(null);
        btnReiniciarFolio.setPreferredSize(new java.awt.Dimension(150, 35));
        btnReiniciarFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarFolioActionPerformed(evt);
            }
        });
        panelDevo.add(btnReiniciarFolio);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn8.setBackground(new java.awt.Color(0, 51, 153));
        btn8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("F12 Cobrar");
        btn8.setBorder(null);
        btn8.setPreferredSize(new java.awt.Dimension(130, 38));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 204));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(null);
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("$");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(txtTotal))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelDevo, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                                .addGap(512, 512, 512))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE)
                    .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSuperiorBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSuperiorBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTicket))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtagregarActionPerformed

        buscarDesdeCombo();

    }//GEN-LAST:event_txtagregarActionPerformed
    public String[] asignarPrecio(Producto pro) {
        if (pro == null) {
            return null;
        }
        String res[] = new String[10];
        res[0] = pro.getCodigo();
        res[1] = pro.getDescripcion();
        res[2] = pro.getPrecioVenta() + "";
        res[3] = "1";
        res[4] = pro.getPrecioVenta() + "";
        res[5] = pro.getCantidad() + "";
        res[6] = pro.getPrecioCosto() + "";
        res[7] = pro.getPrecioMayoreo() + "";
        res[8] = pro.getPrecioDistribuidor() + "";
        res[9] = pro.getPrecioVenta() + "";
        return res;
    }

    public void buscarDesdeCombo() {
        Producto pro = (Producto) comboProductos.getSelectedItem();
        if (pro.getIdProducto() == 0) {
            mensaje("Por favor ingresa el nombre del producto", 2);
        } else {
            md = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
            boolean bandera = revisarRepetidos(pro.getDescripcion());
            if (bandera == false) {
                String[] info = new String[9];
                info = asignarPrecio(pro);// obj.getProductoPorNombre(nombre, p, 1, tipoPrecio);

                if (info == null) {
                    mensaje("Producto no encontrado", 1);
                } else {
                    double can = Double.parseDouble(info[5]);
                    if (can > 0) {
                        md.addRow(info);
                        int tamano = md.getRowCount();
                        tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + (Double.parseDouble(info[2]) * Double.parseDouble(info[3])));

                        //  tablas[jTabbedPane1.getSelectedIndex()].setTotal(total[jTabbedPane1.getSelectedIndex()]);
                        txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");
                        tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() + 1);
                        tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano - 1, 0, false, false);
                    } else {
                        mensaje("El producto esta registrado pero su invenario esta en 0, por favor agregar más producto en la sección correspondiente", 1);
                    }

                }
            }
            comboProductos.setSelectedIndex(0);
            txtCodigo.requestFocus();
        }
    }

    // Forma anterior de agregar a la tabla desde la opción de buscar por nombre
    public void agregarDesdeTablaExterna(String idProducto) {
        ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos-id/" + idProducto);
        List<Producto> lis = res.getProductos();

        if (lis.isEmpty()) {
            mensaje("Producto no encontrado", 1);
        } else {
            Producto pro1 = lis.get(0);
            md = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
            boolean bandera = revisarRepetidos(pro1.getDescripcion());
            if (bandera == false) {
                String[] info = new String[7];
                info = asignarPrecio(pro1);// obj.getProductoPorNombre(nombre, p, 1, tipoPrecio);
                if (info == null) {
                    mensaje("Producto no encontrado", 1);
                } else {
                    double can = Double.parseDouble(info[5]);
                    if (can > 0) {
                        md.addRow(info);
                        int tamano = md.getRowCount();
                        tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + (Double.parseDouble(info[2]) * Double.parseDouble(info[3])));
                        txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");
                        tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() + 1);
                        tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano - 1, 0, false, false);
                    } else {
                        mensaje("El producto esta registrado pero su invenario esta en 0, por favor agregar más producto en la sección correspondiente", 1);
                    }

                }
            } else {

            }
            comboProductos.setSelectedIndex(0);
        }

    }

    public void agregarDesdeTablaExternaConCantidad(Producto pro, String cantidadIngresada, String importe) {

        md = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
        boolean bandera = revisarRepetidos(pro.getDescripcion());
        if (bandera == false) {
            String[] res = new String[10];
            res[0] = pro.getCodigo();
            res[1] = pro.getDescripcion();
            res[2] = pro.getPrecioVenta() + "";
            res[3] = cantidadIngresada; // cantidad ingresada
            res[4] = importe + "";
            res[5] = pro.getCantidad() + "";
            res[6] = pro.getPrecioCosto() + "";
            res[7] = pro.getPrecioMayoreo() + "";
            res[8] = pro.getPrecioDistribuidor() + "";
            res[9] = pro.getPrecioVenta() + "";
            md.addRow(res);
            int tamano = md.getRowCount();
            tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + Double.parseDouble(importe));
            txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");
            tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() + 1);
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano - 1, 0, false, false);

        } else {

        }
        comboProductos.setSelectedIndex(0);

    }

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
//requerirFoco();
        String nombre = txtCodigo.getText();
        ProductoResponse res = api.getProductos(EnviromentLocal.urlG + "productos/" + Datos.idSucursal + "/" + nombre);
        List<Producto> lis = res.getProductos();
        Producto pro1 = lis.get(0);
        if (nombre.equalsIgnoreCase("")) {

            mensaje("Por favor ingresa un código", 1);
        } else {
            md = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();
            boolean bandera = revisarRepetidos(nombre);
            if (bandera == false) {
                String[] info = asignarPrecio(pro1);//obj.getProductoPorNombre(nombre, p, 1, tipoPrecio);
                if (info == null) {
                    mensaje("Producto no encontrado", 1);
                } else {
                    double can = Double.parseDouble(info[5]);
                    if (can > 0) {
                        md.addRow(info);
                        tablas[jTabbedPane1.getSelectedIndex()].setTotal(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + (Double.parseDouble(info[2]) * Double.parseDouble(info[3])));
                        //  tablas[jTabbedPane1.getSelectedIndex()].setTotal(total[jTabbedPane1.getSelectedIndex()]);
                        txtTotal.setText(tablas[jTabbedPane1.getSelectedIndex()].getTotal() + "");
                        tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() + 1);
                    } else {
                        mensaje("El producto esta registrado pero su inventario esta en 0, por favor agregar más producto en la sección correspondiente", 1);

                    }
                }

            }
            txtCodigo.setText("");
        }

    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        BusquedaProductos bus = new BusquedaProductos(this, 1);
        bus.setVisible(true);
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        asignarPrecioMayoreo();
    }//GEN-LAST:event_btn3ActionPerformed
    public void asignarPrecioMayoreo() {
        int row = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow();
        if (row < 0) {
            Utilidades.mensajePorTiempo("Por favor selecciona un elemento");
        } else {
            float cantidad = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 3));
            float precioMayoreo = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 7));
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioMayoreo) + "", row, 4);
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioMayoreo) + "", row, 2);
            String importe = tablas[jTabbedPane1.getSelectedIndex()].obtenerDatosDelModelo();
            tablas[jTabbedPane1.getSelectedIndex()].setTotal(Float.parseFloat(importe));
            txtTotal.setText(importe);
            int tamano = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getRowCount();
            if (tamano > 0) {
                tamano = tamano - 2;
                tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano, 0, false, false);
            }
            Utilidades.mensajePorTiempo("Modificado a precio de mayoreo", 1500);
        }
    }
    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        EntradaEfectivo objeto = new EntradaEfectivo(this);
        objeto.setVisible(true);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        SalidaEfectivo objeto = new SalidaEfectivo(this);
        objeto.setVisible(true);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        eliminaCelda(1);

        if (tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() > 0) {
            tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos() - 1);
        }


    }//GEN-LAST:event_btn6ActionPerformed


    private void btnReiniciarFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarFolioActionPerformed
        try {
            tick.modificarEstatus();
            txtTicket.setText("Folio ticket: " + tick.getNumero());// TODO add your handling code here:
        } catch (ClassNotFoundException ex) {

            mensaje("Ocurrio un error con el sistema", 1);
        } catch (SQLException ex) {

            Logger.getLogger(VentasEstructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReiniciarFolioActionPerformed

    private void btndevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndevolucionesActionPerformed
        Devoluciones obj = new Devoluciones(this);
        obj.setVisible(true);
    }//GEN-LAST:event_btndevolucionesActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        eliminaCelda(2);
        tablas[jTabbedPane1.getSelectedIndex()].setNumArticulos(0);
        tablas[jTabbedPane1.getSelectedIndex()].setTotal(0);
        txtTotal.setText("");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        realizaCobro();

    }//GEN-LAST:event_btn8ActionPerformed

    public void realizaCobro() {
        DefaultTableModel tm = (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel();

        if (tm.getRowCount() <= 0) {
            mensaje("Por favor ingresa productos para realizar el cobro", 1);
        } else {
            try {
                if (!masCantidadQueInventario()) {
                    Cobrar obj = new Cobrar(this, (DefaultTableModel) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getModel(), jTabbedPane1.getSelectedIndex());
                    obj.setVisible(true);
                    String info = txtTotal.getText();
                    Cobrar.txtn2.setText(info);
                    int numArticulos=tablas[jTabbedPane1.getSelectedIndex()].getNumArticulos();
                    if(numArticulos<0){
                    numArticulos=numArticulos*-1;
                    }
                    obj.numArticulos.setText(numArticulos+"");
                    obj.requerirFoco();
                }
            } catch (NumberFormatException e) {

                mensaje("Ingresaste una letra u otro caracter en lugar de un número. Por favor revisa la información ingresada", 1);
            }
        }

    }
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void panelTicketFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelTicketFocusGained
        System.out.println("Quien lo gano " + evt.getComponent().getName());
        System.out.println("Quien lo perde " + evt.getOppositeComponent().getName());
    }//GEN-LAST:event_panelTicketFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.out.println("Dio Click");
        //   txtTabla.clearSelection();

    }//GEN-LAST:event_formMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        Utilidades.im(jTabbedPane1.getSelectedIndex() + "");
        if (ultimaPestanaSeleccionada != jTabbedPane1.getSelectedIndex()) {
            txtTotal.setText("" + tablas[jTabbedPane1.getSelectedIndex()].getTotal());
            ultimaPestanaSeleccionada = jTabbedPane1.getSelectedIndex();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnNSVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSVariosActionPerformed

    }//GEN-LAST:event_btnNSVariosActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        Utilidades.im("Ests es el numero " + evt.getKeyCode());
        ejecutaOnKey(evt.getKeyCode());
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtagregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtagregarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarDesdeCombo();
        }
    }//GEN-LAST:event_txtagregarKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car) || Character.isDigit(car)) {

        } else {
            evt.consume();
            getToolkit().beep();
        }

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        asignarPrecioDistribuidor();
    }//GEN-LAST:event_btn9ActionPerformed
    public void asignarPrecioDistribuidor() {
        int row = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow();
        if (row < 0) {
            Utilidades.mensajePorTiempo("Por favor selecciona un elemento");
        } else {
            float cantidad = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 3));
            float precioDistribuidor = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 8));
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioDistribuidor) + "", row, 4);
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioDistribuidor) + "", row, 2);
            String importe = tablas[jTabbedPane1.getSelectedIndex()].obtenerDatosDelModelo();
            tablas[jTabbedPane1.getSelectedIndex()].setTotal(Float.parseFloat(importe));
            txtTotal.setText(importe);
            int tamano = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getRowCount();
            if (tamano > 0) {
                tamano = tamano - 2;
                tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano, 0, false, false);
            }
            Utilidades.mensajePorTiempo("Modificado a precio de distribuidor", 1500);
        }
    }
    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        asignarPrecioVenta();
    }//GEN-LAST:event_btn10ActionPerformed
    public void asignarPrecioVenta() {
        int row = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getSelectedRow();
        if (row < 0) {
            Utilidades.mensajePorTiempo("Por favor selecciona un elemento");
        } else {
            float cantidad = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 3));
            float precioVenta = Float.parseFloat((String) tablas[jTabbedPane1.getSelectedIndex()].getTabla().getValueAt(row, 9));
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioVenta) + "", row, 4);
            tablas[jTabbedPane1.getSelectedIndex()].getTabla().setValueAt((cantidad * precioVenta) + "", row, 2);
            String importe = tablas[jTabbedPane1.getSelectedIndex()].obtenerDatosDelModelo();
            tablas[jTabbedPane1.getSelectedIndex()].setTotal(Float.parseFloat(importe));
            txtTotal.setText(importe);
            int tamano = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getRowCount();
            if (tamano > 0) {
                tamano = tamano - 2;
                tablas[jTabbedPane1.getSelectedIndex()].getTabla().changeSelection(tamano, 0, false, false);
            }
            Utilidades.mensajePorTiempo("Modificado a precio de venta", 1500);
        }
    }
    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProductosActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    ejecutaOnKey(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed
    public void inicializarIconos() {
        System.out.println("Si entro aca");

        ImageIcon e = new ImageIcon("iconos/ticket.png");
        ImageIcon f = new ImageIcon("iconos/usuario.png");
        ImageIcon enter = new ImageIcon("iconos/check.png");
        ImageIcon aa = new ImageIcon("iconos/documentos.png");
        ImageIcon bb = new ImageIcon("iconos/lupa.png");
        ImageIcon ccc = new ImageIcon("iconos/estrella.png");
        ImageIcon dd = new ImageIcon("iconos/ganancias_dinero.png");
        ImageIcon ee = new ImageIcon("iconos/salida_dinero.png");
        ImageIcon ff = new ImageIcon("iconos/bote_basura.png");
        ImageIcon gg = new ImageIcon("iconos/carro_cobrar.png");
        ImageIcon iconoCap = new ImageIcon("iconos/ico_cap.png");
        ImageIcon lupa = new ImageIcon("iconos/lupa.png");

        btnBusqueda.setIcon(aa);
        btnReiniciarFolio.setIcon(e);
        btndevoluciones.setIcon(aa);
        btnNSVarios.setIcon(lupa);
        btn3.setIcon(ccc);
        btn4.setIcon(dd);
        btn5.setIcon(ee);
        btn6.setIcon(ff);
        btn7.setIcon(ff);
        btn8.setIcon(gg);
        btn9.setIcon(ccc);
        btn10.setIcon(ccc);
        txtagregar.setIcon(enter);

        try {
            llenarCombo();
        } catch (Exception ClassNotFoundException) {

        }
        AutoCompleteDecorator.decorate(comboProductos, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
    }

    public void ejecutaOnKey(int num) {

        if (num == 118) {
            EntradaEfectivo objeto = new EntradaEfectivo(this);
            objeto.setVisible(true);
        }
        if (num == 119) {
            SalidaEfectivo objeto = new SalidaEfectivo(this);
            objeto.setVisible(true);
        }
        if (num == 113) {

            BusquedaProductos bus = new BusquedaProductos(this, 1);

            bus.setVisible(true);

        }
        int totalRows = tablas[jTabbedPane1.getSelectedIndex()].getTabla().getRowCount();
        if (num == 107) {
            if (totalRows > 0) {
                tablas[jTabbedPane1.getSelectedIndex()].sumarDeUno();
            }
        }

        if (num == 109) {
            if (totalRows > 0) {
                tablas[jTabbedPane1.getSelectedIndex()].restarDeUno();
            }
        }

        if (num == 120) {
            asignarPrecioDistribuidor();
        }

        if (num == 121) {
            BusquedaProductos bus = new BusquedaProductos(this, 1);
            bus.setVisible(true);
        }

        if (num == 122) {
            asignarPrecioMayoreo();
        }

        if (num == 117) {
            asignarPrecioVenta();
        }

        if (num == 123) {
            realizaCobro();
        }
        if (num == 127) {
            Utilidades.im("Entro a eliminar");
            eliminaCelda(1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnNSVarios;
    private javax.swing.JButton btnReiniciarFolio;
    private javax.swing.JButton btndevoluciones;
    private javax.swing.JComboBox<Producto> comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelDevo;
    private javax.swing.JPanel panelSuperiorBotones;
    private javax.swing.JPanel panelTicket;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JLabel txtTicket;
    public static javax.swing.JTextField txtTotal;
    private javax.swing.JButton txtagregar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Utilidades.im("1");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Utilidades.im("2");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Utilidades.im("Tecla presionada " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Utilidades.im("1");
    }

}
