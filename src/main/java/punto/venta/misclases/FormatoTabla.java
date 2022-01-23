/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author job
 */
public class FormatoTabla extends DefaultTableCellRenderer
{  
    
    @Override                                    
    public Component getTableCellRendererComponent(JTable jTable1,Object value,boolean selected, boolean focused, int row, int column){
    { 
         Component c = super.getTableCellRendererComponent(jTable1,value,selected,focused,row,column);
       // setEnabled(jTable1 == null || jTable1.isEnabled()); 
        
        
         //   System.out.println("Columna "+ column);
         //   System.out.println("Renglon "+ row);
         //  System.out.println("Numero columnas = " + jTable1.getColumnCount());
           
           // System.out.println("Numero filas = " + jTable1.getRowCount());
            
            c.setForeground(row==0 || row==1 || row==2 ? Color.BLUE : Color.RED);
        
      //  super.getTableCellRendererComponent(jTable1, value, selected, focused, row, column); 
      
        return c;
    }
    }
}
