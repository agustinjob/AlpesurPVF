/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author agus_
 */
public class PruebaArchivo {

    public static void main(String args[]) throws IOException {
        File doc = new File("C:\\configuracion\\conf.txt");
        doc.createNewFile();
        BufferedReader obj = new BufferedReader(new FileReader(doc));

        String strng;
        String propietario= (String)obj.readLine().split("=")[1];
        String idSucursal= (String)obj.readLine().split("=")[1];
        String sucursal= (String)obj.readLine().split("=")[1];
        
        System.out.println(propietario);
         System.out.println(idSucursal);
          System.out.println(sucursal);
      //  while ((strng = obj.readLine()) != null) {
      //      System.out.println(strng);
      //  }

    }
}
