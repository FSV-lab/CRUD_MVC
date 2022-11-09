
package crud_mvc;

import controlador.ControladorProducto;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.VistaProducto;


public class CRUD_MVC {

    
    public static void main(String[] args) {
      VistaProducto vista = new VistaProducto();
      Producto producto = new Producto();
      ConsultasProducto modelo = new ConsultasProducto();
      ControladorProducto controlador = new ControladorProducto(vista,producto,modelo);
    
      controlador.iniciar();
      vista.setVisible(true);
    }
    
}
