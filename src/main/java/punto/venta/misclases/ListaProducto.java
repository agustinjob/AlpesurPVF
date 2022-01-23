
package punto.venta.misclases;

import java.util.Vector;


public class ListaProducto {

    private static Vector datos = new Vector();

    public static void agregar(Object obj) {
        datos.addElement(obj);
    }

  

    public static Vector mostrar() {
        return datos;
    }
}
