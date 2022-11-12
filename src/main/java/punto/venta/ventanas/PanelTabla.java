/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import punto.venta.dialogos.Confirmacion;
import punto.venta.dialogos.EntradaEfectivo;
import punto.venta.dialogos.SalidaEfectivo;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.VentasEstructura;
import static punto.venta.ventanas.VentasEstructura.txtTotal;

/**
 *
 * @author agus_
 */
public class PanelTabla extends javax.swing.JPanel implements ActionListener, KeyListener {

    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Código de barras", "Descripcion de producto", "Precio venta", "Cant", "importe", "Existencia", "Precio Costo", "Precio Mayoreo",
        "Precio Distribuidor", "Precio Venta Extra", "Cantidad Mayoreo"};
    int filas;
    DecimalFormat df = new DecimalFormat("#.00");
    private VentasEstructura objVentas;

    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    public double total = 0.0d;
    public int numeroArticulos = 0;
    Confirmacion confir;
    JTextField txtTotalOb;
    Confirmacion confirma = new Confirmacion();

    public PanelTabla(JTextField txtTotalOb, VentasEstructura ventas) {
        initComponents();
        md = new DefaultTableModel();
        this.txtTabla.setModel(md);
        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 ? true : false;
            }
        };
        this.txtTotalOb = txtTotalOb;
        objVentas = ventas;
        centrarValoresTabla();
        addKeyListener(this);
    }

    public void centrarValoresTabla() {
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
        txtTabla.getColumnModel().getColumn(7).setWidth(0);
        txtTabla.getColumnModel().getColumn(7).setMinWidth(0);
        txtTabla.getColumnModel().getColumn(7).setMaxWidth(0);
        txtTabla.getColumnModel().getColumn(8).setWidth(0);
        txtTabla.getColumnModel().getColumn(8).setMinWidth(0);
        txtTabla.getColumnModel().getColumn(8).setMaxWidth(0);
        txtTabla.getColumnModel().getColumn(9).setWidth(0);
        txtTabla.getColumnModel().getColumn(9).setMinWidth(0);
        txtTabla.getColumnModel().getColumn(9).setMaxWidth(0);
        txtTabla.getColumnModel().getColumn(10).setWidth(0);// COLUMNA CANTIDAD MAYOREO
        txtTabla.getColumnModel().getColumn(10).setMinWidth(0);
        txtTabla.getColumnModel().getColumn(10).setMaxWidth(0);
        txtTabla.setRowHeight(30);
    }

    public JTable getTabla() {
        return txtTabla;
    }

    public void sumarDeUno() {

        String temp = (String) md.getValueAt(txtTabla.getSelectedRow(), 3);
        double cantidad = Double.parseDouble(temp) + 1;
        md.setValueAt(cantidad + "", txtTabla.getSelectedRow(), 3);
        String cantidadMayoreo = (String) md.getValueAt(txtTabla.getSelectedRow(), 10);

        if (Float.parseFloat(cantidadMayoreo) <= cantidad) {
            String pMayoreo = (String) md.getValueAt(txtTabla.getSelectedRow(), 7);
            md.setValueAt(pMayoreo, txtTabla.getSelectedRow(), 2);
        }

        actualizarImporteTabla();
    }

    public void restarDeUno() {

        String temp = (String) md.getValueAt(txtTabla.getSelectedRow(), 3);
        double cantidad = Double.parseDouble(temp) - 1;
        String cantidadMayoreo = (String) md.getValueAt(txtTabla.getSelectedRow(), 10);
        md.setValueAt(cantidad + "", txtTabla.getSelectedRow(), 3);
        if (Float.parseFloat(cantidadMayoreo) > cantidad) {
            String pVenta = (String) md.getValueAt(txtTabla.getSelectedRow(), 9);
            md.setValueAt(pVenta, txtTabla.getSelectedRow(), 2);
        }
        actualizarImporteTabla();
    }

    public void actualizarImporteTabla() {
        DefaultTableModel tm = (DefaultTableModel) txtTabla.getModel();
        numeroArticulos = 0;
        total = 0;
        for (int i = 0; i < tm.getRowCount(); i++) {
            double precio = Double.parseDouble((String) tm.getValueAt(i, 2));
            double cantidad = Double.parseDouble((String) tm.getValueAt(i, 3));
            double inventario = Double.parseDouble((String) tm.getValueAt(i, 5));
            numeroArticulos = (int) (numeroArticulos + cantidad);

            double suma = precio * cantidad;
            tm.setValueAt(suma + "", i, 4);
            total = total + suma;

        }
        txtTotalOb.setText(df.format(total) + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTabla = new javax.swing.JTable();

        jScrollPane1.setBorder(null);

        txtTabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTabla.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Pruieba Producto", "10", "10", "10", "10"}
            },
            new String [] {
                "Código de barras ", "Descripción del Producto", "Precio Venta", "Cant", "Importe", "Existencia"
            }
        ));
        txtTabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        txtTabla.setAutoscrolls(false);
        txtTabla.setDropMode(javax.swing.DropMode.ON);
        txtTabla.setGridColor(new java.awt.Color(255, 255, 255));
        txtTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        txtTabla.setShowHorizontalLines(false);
        txtTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTablaKeyPressed

        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int row = txtTabla.getSelectedRow();
                int column = txtTabla.getSelectedColumn();

                String can = (String) txtTabla.getValueAt(row, column);
                double canti = Double.parseDouble(can);
                String cantidadMayoreo = (String) md.getValueAt(txtTabla.getSelectedRow(), 10);
                 double preci = 0f;
           
                if (Float.parseFloat(cantidadMayoreo) > canti) {preci=Double.parseDouble(txtTabla.getValueAt(row, 9) + "");} 
                else {preci=Double.parseDouble(txtTabla.getValueAt(row, 7) + "");}
                
                txtTabla.setValueAt(preci+"", row, 2);
                if (column == 3) {// por cantidad
                    double totalImporte = canti * preci;
                    txtTabla.setValueAt(totalImporte + "", row, 4);
                }

                if (column == 4) {// por importe
                    String imp = (String) txtTabla.getValueAt(row, column);
                    double impor = Double.parseDouble(imp);
                    double totalCanti = impor / preci;
                    txtTabla.setValueAt(totalCanti + "", row, 3);

                }
                actualizarImporteTabla();

            }

            if (evt.getKeyCode() == 107) {
                sumarDeUno();
            }

            if (evt.getKeyCode() == 109) {
                restarDeUno();
            }
            if (evt.getKeyCode() == 127) {
                eliminaCelda(1);
            }
            if (evt.getKeyCode() == 123) {
                getObjVentas().realizaCobro();
            }

            if (evt.getKeyCode() == 122) {
                mensaje("Se ha activado el precio de mayoreo", 1);
            }

            if (evt.getKeyCode() == 120) {
                mensaje("Se ha activado el precio de Distribuidor", 1);
            }

            if (evt.getKeyCode() == 117) {
                mensaje("Se ha activado el precio de de venta regular", 1);
            }

            if (evt.getKeyCode() == 118) {
                EntradaEfectivo objeto = new EntradaEfectivo(objVentas);
                objeto.setVisible(true);
            }
            if (evt.getKeyCode() == 119) {
                SalidaEfectivo objeto = new SalidaEfectivo(objVentas);
                objeto.setVisible(true);
            }
        } catch (NumberFormatException exc) {
            mensaje("Haz ingresado una letra u otro caracter en lugar de un número. Por favor revisa los datos ingresados", 1);
        }


    }//GEN-LAST:event_txtTablaKeyPressed

    public void setTotal(double total) {
        this.total = Double.parseDouble(df.format(total));
    }

    public double getTotal() {
        return Double.parseDouble(df.format(total));
    }

    public void setNumArticulos(int numArticulos) {
        this.numeroArticulos = numArticulos;
    }

    public int getNumArticulos() {
        return numeroArticulos;
    }

    public void eliminaCelda(int tipoEliminacion) {
        System.out.println("antes del model");
        DefaultTableModel tm = (DefaultTableModel) txtTabla.getModel();
        System.out.println("despues del modelo en tipo eliminacion");
        if (tipoEliminacion == 1) {
            if (txtTabla.getSelectedRow() >= 0) {
                if (txtTabla.getValueAt(txtTabla.getSelectedRow(), 0) == null) {
                    JOptionPane.showMessageDialog(this, "La fila que selecciono ,no cuenta con ningún producto", "Punto de venta", JOptionPane.WARNING_MESSAGE);
                } else {

                    double resta = Double.parseDouble((String) tm.getValueAt(txtTabla.getSelectedRow(), 4));
                    Utilidades.im("Total " + total);
                    total = total - resta;
                    double cantidad = Double.parseDouble((String) tm.getValueAt(txtTabla.getSelectedRow(), 3));

                    tm.removeRow(txtTabla.getSelectedRow());
                    txtTotal.setText(total + "");
                    numeroArticulos = (int) (numeroArticulos - cantidad);

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

    public String obtenerDatosDelModelo() {
        DefaultTableModel md = (DefaultTableModel) txtTabla.getModel();
        int i = 0;
        float importe = 0.0f;
        while (md.getRowCount() > i) {
            String imp = (String) md.getValueAt(i, 4);
            importe = importe + Float.parseFloat(imp);

            i++;
        }
        return importe + "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable txtTabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the objVentas
     */
    public VentasEstructura getObjVentas() {
        return objVentas;
    }

    /**
     * @param objVentas the objVentas to set
     */
    public void setObjVentas(VentasEstructura objVentas) {
        this.objVentas = objVentas;
    }

    public void mensaje(String men, int tipo) {

        confirma.setMensaje(men);
        confirma.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                confirma.dispose();
                if (tipo == 1) {
                    objVentas.requerirFoco();
                }
            }

        });

        timer.setRepeats(false);
        timer.start();
    }
}
