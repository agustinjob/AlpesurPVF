/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.tabla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import punto.venta.dialogos.BusquedaProductos;
import punto.venta.dialogos.Confirmacion;
import punto.venta.dialogos.EntradaEfectivo;
import punto.venta.dialogos.SalidaEfectivo;
import punto.venta.utilidades.Utilidades;
import punto.venta.ventanas.Estructura;
import punto.venta.ventanas.VentasEstructura;
import static punto.venta.ventanas.VentasEstructura.tipoPrecio;
import static punto.venta.ventanas.VentasEstructura.txtTotal;

/**
 *
 * @author agus_
 */
public class TablaVentas extends javax.swing.JPanel implements KeyListener {

   public int numeroArticulos = 0;
   DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Código de barras", "Descripcion de producto", "Precio venta", "Cant", "importe", "Existencia", "Precio Costo"};
    int filas;
     
    public double total = 0.0d;
    Estructura e;
    Confirmacion confirma = new Confirmacion();
    DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
    VentasEstructura ventas; 
    public TablaVentas(VentasEstructura ventas) {
        initComponents();
      
        md = new DefaultTableModel();
        this.txtTabla.setModel(md);
        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4 || column == 2 ? true : false;
            }
        };
        centrarValoresTabla();
        this.ventas=ventas;
    }
    public JTable getTabla(){
    return txtTabla;
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
        txtTabla.setRowHeight(30);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTabla = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

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
        txtTabla.setColumnSelectionAllowed(true);
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

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTablaKeyPressed
Utilidades.im("SI fue tabla ventas");
        try{
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int row = txtTabla.getSelectedRow();
                int column = txtTabla.getSelectedColumn();
                double preci = Double.parseDouble(txtTabla.getValueAt(row, 2) + "");
                if (column == 3) {// por cantidad
                    String can = (String) txtTabla.getValueAt(row, column);
                    double canti = Double.parseDouble(can);
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
            if (evt.getKeyCode()== 122) {

            if (ventas.tipoPrecio == 1) {
                mensaje("Se ha activado el precio de mayoreo");
                tipoPrecio = 2;
            } else {
                mensaje("Se ha desactivado el precio de mayoreo");
                ventas.tipoPrecio = 1;
            }
        }

        if (evt.getKeyCode()== 118) {
            EntradaEfectivo objeto = new EntradaEfectivo(ventas);
            objeto.setVisible(true);
        }
        if (evt.getKeyCode()== 119) {
            SalidaEfectivo objeto = new SalidaEfectivo(ventas);
            objeto.setVisible(true);
        }
        if(evt.getKeyCode()== 113){
          
          BusquedaProductos bus = new BusquedaProductos(ventas,1);
          
        bus.setVisible(true);
      
      
        }
        if (evt.getKeyCode()== 123) {
            ventas.realizaCobro();
        }
        if(evt.getKeyCode()== 127){
            Utilidades.im("Entro a eliminar");
            eliminaCelda(1);
        }
            if(evt.getKeyCode() == 127){
                eliminaCelda(1);
            }
        }catch(NumberFormatException exc){
            Utilidades.escribirLog(exc.getLocalizedMessage());
           mensaje("Haz ingresado una letra u otro caracter en lugar de un número. Por favor revisa los datos ingresados");
        }

        if (txtTabla.getSelectedRow() >= 0) {
        }else{
            e.requestFocus();
        }
    }//GEN-LAST:event_txtTablaKeyPressed

    public void eliminaCelda(int tipoEliminacion) {
        System.out.println("antes del model");
        DefaultTableModel tm = (DefaultTableModel) txtTabla.getModel();
        System.out.println("despues del modelo en tipo eliminacion");
        if (tipoEliminacion == 1) {
            if (txtTabla.getSelectedRow() >= 0) {
                if (txtTabla.getValueAt(txtTabla.getSelectedRow(), 0) == null) {
                    JOptionPane.showMessageDialog(this, "La fila que selecciono ,no cuenta con ningún producto", "Alexito", JOptionPane.WARNING_MESSAGE);
                } else {

                    double resta = Double.parseDouble((String) tm.getValueAt(txtTabla.getSelectedRow(), 4));
                    total = total - resta;
                    tm.removeRow(txtTabla.getSelectedRow());
                    txtTotal.setText(total + "");
                }
            } else {
               mensaje("No haz seleccionado ninguna fila");
                
            }

        } else {

            int r = 0;
            while (tm.getRowCount() > r) {
                tm.removeRow(r);
            }

        }
    }
    
     public void sumarDeUno(){
      
      String temp = (String) md.getValueAt(txtTabla.getSelectedRow(), 3);
      double cantidad = Double.parseDouble(temp) + 1;
      md.setValueAt(cantidad+"",txtTabla.getSelectedRow() , 3);
      actualizarImporteTabla();
    }
     
      public void restarDeUno(){
      
      String temp = (String) md.getValueAt(txtTabla.getSelectedRow(), 3);
      double cantidad = Double.parseDouble(temp) - 1;
      md.setValueAt(cantidad+"",txtTabla.getSelectedRow() , 3);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable txtTabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
     public void mensaje(String men){
         
    confirma.setMensaje(men);
    confirma.setVisible(true);
    Utilidades.im("Entro al mensaje");
    Timer timer = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    Utilidades.im("No lo hizo");
                 confirma.dispose();
                }
                
            });

    timer.setRepeats(false);
            timer.start();
    }

}
