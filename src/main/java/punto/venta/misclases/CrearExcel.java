/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.misclases;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import punto.venta.dao.Conexion;
import punto.venta.dao.ProductoDAO;
import punto.venta.dialogos.Confirmacion;
import punto.venta.modelo.*;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class CrearExcel {
    
   
    private  ProductoDAO objP = new ProductoDAO();
    private  List<Producto> producto;
    Confirmacion confir;
    Date d = new Date();
    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatoHora = new SimpleDateFormat("HH mm");
    
     
    public  void consultarInventario(){
       //     producto=objP.obtenerProductosBusquedaParametrizada();
            
    
    }



   

    public  void writeExcel() throws Exception {
        consultarInventario();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Inventario");

        String[] headers = new String[]{
                "Código",
                "Descripción",
                "Precio costo",
                "Precio venta",
                "Precio mayoreo",
                "Cantidad"
        };

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }

        for (int i = 0; i < producto.size(); ++i) {
            HSSFRow dataRow = sheet.createRow(i + 1);

            Producto p = producto.get(i);
          //  String product = (String) d[0];
          //  BigDecimal price = (BigDecimal) d[1];
          //  String link = (String) d[2];

            dataRow.createCell(0).setCellValue(p.getCodigo());
         /*   dataRow.createCell(1).setCellValue(p.getNombre());
            dataRow.createCell(2).setCellValue(p.getpCosto());
            dataRow.createCell(3).setCellValue(p.getpVenta());
            dataRow.createCell(4).setCellValue(p.getpMayoreo());
            dataRow.createCell(5).setCellValue(p.getCantidad());*/
        }

        // Esto es para crear una nueva fila con la suma de toda una columna
       // HSSFRow dataRow = sheet.createRow(1 + DATA.size());
       // HSSFCell total = dataRow.createCell(1);
       // total.setCellStyle(style);
       // total.setCellFormula(String.format("SUM(B2:B%d)", 1 + DATA.size()));
     File directorio = new File("C:\\punto_venta\\inventario\\");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
               
                System.out.println("Error al crear directorio");
            }
        }
        FileOutputStream file = new FileOutputStream("C:\\punto_venta\\inventario\\"+formatoFecha.format(d)+" "+formatoHora.format(d)+" hrs.xls");
        
        workbook.write(file);
        file.close();
    }
    
    public  void writeExcelVentas(List<Ventas> listaVentas, Date fechaI, Date fechaF) throws Exception {
        consultarInventario();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "Ventas");

        String[] headers = new String[]{
                "Código",
                "Descripción",
                "Cantidad",
                "Precio venta",
                "Fecha",
                "Hora"
        };

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);

        CellStyle style = workbook.createCellStyle();
     //   
       
        style.setAlignment(HorizontalAlignment.CENTER);

        HSSFRow headerRow = sheet.createRow(0);
      
        
        for (int i = 0; i < headers.length; ++i) {
            String header = headers[i];
            
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }
         
       

        int i=0;
         HSSFRow dataRow = null;
         
        for(Ventas v: listaVentas){
            if(i==0){
            i=i+1;
            }
            dataRow = sheet.createRow(i + 1);
            Cell c1= dataRow.createCell(0);
            c1.setCellStyle(style);
            c1.setCellValue(v.getCodigo());
            Cell c2= dataRow.createCell(1);
            c2.setCellStyle(style);
            c2.setCellValue(v.getNombre());
             Cell c3= dataRow.createCell(2);
           c3.setCellStyle(style);
            c3.setCellValue(v.getCantidad());
             Cell c4= dataRow.createCell(3);
          c4.setCellStyle(style);
            c4.setCellValue(v.getPrecioVenta());
             Cell c5= dataRow.createCell(4);
            c5.setCellStyle(style);
            c5.setCellValue(formatoFecha.format(v.getFecha()));
             Cell c6= dataRow.createCell(5);
            c6.setCellStyle(style);
            c6.setCellValue(formatoHora.format(v.getFecha()));
            
           /* dataRow.createCell(0).setCellValue();
       
            dataRow.createCell(1).setCellValue(ventas.getString("nombre"));
            dataRow.createCell(2).setCellValue(ventas.getDouble("cantidad"));
            dataRow.createCell(3).setCellValue(ventas.getDouble("precioVenta"));
            dataRow.createCell(4).setCellValue(ventas.getString("fecha"));
            dataRow.createCell(5).setCellValue(ventas.getString("hora"));
           */
            i++;
            
        }
        
         dataRow.getSheet().setColumnWidth(1, 10000);
         dataRow.getSheet().setColumnWidth(3, 5000);
         dataRow.getSheet().setColumnWidth(4, 5000);
         dataRow.getSheet().setColumnWidth(5, 5000);
         
      
         
         HSSFRow dataRowNu = sheet.createRow(1 + i);
          CellStyle style2 = workbook.createCellStyle();
         HSSFCell total = dataRowNu.createCell(2);
         HSSFCell total2 = dataRowNu.createCell(3);
         style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
         style2.setAlignment(HorizontalAlignment.CENTER);
         total.setCellStyle(style2);
         total2.setCellStyle(style2);
        
         total.setCellFormula(String.format("SUM(C3:C%d)", 1 + i));
          total2.setCellFormula(String.format("SUM(D3:D%d)", 1 + i));
         
          i=i+5;
         dataRow = sheet.createRow(i);
         dataRow.createCell(2).setCellValue("Fecha inicio: "+formatoFecha.format(fechaI) +", Fecha Fin: " + formatoFecha.format(fechaF));

      
     File directorio = new File("C:\\punto_venta\\ventas");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
               
                System.out.println("Error al crear directorio");
            }
        }
        FileOutputStream file = new FileOutputStream("C:\\punto_venta\\ventas\\ventas"+formatoFecha.format(d)+" "+formatoHora.format(d)+" hrs.xls");
        
        workbook.write(file);
        file.close();
        Utilidades.mensajePorTiempo("Se ha generado el documento de manera correcta, puedes encontrar el archivo en C:/punto_venta/ventas/ ");
       
    }
    
    
    
}
