
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.VistaProducto;



public class ControladorProducto implements ActionListener{
        private VistaProducto vista;
        private Producto producto;
        private ConsultasProducto modelo;

    public ControladorProducto(VistaProducto vista, Producto producto, ConsultasProducto modelo) {
        this.vista = vista;
        this.producto = producto;
        this.modelo = modelo;
        vista.botonInsertar.addActionListener(this); 
        vista.botonLimpiar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonModificar.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
    }
    
    public void iniciar(){
       vista.setTitle("CRUD MVC");
       vista.setLocationRelativeTo(null);
       vista.cajaId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== vista.botonInsertar) {
            producto.setClave(vista.cajaClave.getText());
            producto.setNombre(vista.cajaNombre.getText());
            producto.setPrecio(Double.parseDouble(vista.cajaPrecio.getText()));
            producto.setFecha_venta(Date.valueOf(vista.cajafecha.getText()));
            producto.setIdcategoria(Integer.parseInt(vista.cajaIdCategoria.getText()));
            if (modelo.insertar(producto)) {
                JOptionPane.showMessageDialog(null,"Registro Insertado Correctamente!");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al insertar registro!");
                limpiarCajas();
            }
        }
        if(ae.getSource()==vista.botonLimpiar){
            limpiarCajas();
        }
        if(ae.getSource()==vista.botonBuscar){
           producto.setClave(vista.cajaBuscar.getText());
           
           if(modelo.buscar(producto)){
               vista.cajaId.setText(String.valueOf(producto.getIdProducto()));
               vista.cajaClave.setText(producto.getClave());
               vista.cajaNombre.setText(producto.getNombre());
               vista.cajaPrecio.setText(String.valueOf(producto.getPrecio()));
               vista.cajafecha.setText(String.valueOf(producto.getFecha_venta()));
               vista.cajaIdCategoria.setText(String.valueOf(producto.getIdcategoria()));
              
           }
           else{
               JOptionPane.showMessageDialog(null,"No existe un producto con esa clave");
               limpiarCajas();
           }
        }
        if(ae.getSource()== vista.botonModificar){
            producto.setClave(vista.cajaClave.getText());
            producto.setNombre(vista.cajaNombre.getText());
            producto.setPrecio(Double.parseDouble(vista.cajaPrecio.getText()));
            producto.setFecha_venta(Date.valueOf(vista.cajafecha.getText()));
            producto.setIdcategoria(Integer.parseInt(vista.cajaIdCategoria.getText())); 
            producto.setIdProducto(Integer.parseInt(vista.cajaId.getText()));
            
            if(modelo.modificar(producto)){
                JOptionPane.showMessageDialog(null,"Registro modificado Correctamente!");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pudo modificar el registro!");
                limpiarCajas();
            }
        }
        if (ae.getSource()== vista.botonEliminar) {
            producto.setIdProducto(Integer.parseInt(vista.cajaId.getText()));
            
            if (modelo.eliminar(producto)) {
                JOptionPane.showMessageDialog(null,"Registro Eliminado Correctamente!");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pudo Eliminar el Registro");
                limpiarCajas();
            }
        }
    }
    
    public void limpiarCajas(){
        vista.cajaBuscar.setText(null);
        vista.cajaClave.setText(null);
        vista.cajaNombre.setText(null);
        vista.cajaPrecio.setText(null);
        vista.cajafecha.setText(null);
        vista.cajaIdCategoria.setText(null);
        vista.cajaId.setText(null);
    }
    
    
    
}
