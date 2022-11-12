/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.venta.test;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import punto.venta.utilidades.Utilidades;

/**
 *
 * @author agus_
 */
public class PruebasLog {
    
    public static BufferedImage generateCode128BarCodeImage(final String barcodeText) throws Exception {
        final Barcode barcode = BarcodeFactory.createCode128(barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }
    
    public static void main(String [] Job) throws Exception{
BufferedImage bufferedImage = generateCode128BarCodeImage("ricardogeek.com");
File codigoBarras= new File("C:\\punto_venta\\codbarr\\codigo-barras.jpg");
ImageIO.write(bufferedImage, "jpg", codigoBarras);
    }
}
