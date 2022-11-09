
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConsultasProducto extends Conexion{
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Producto producto){
        Connection conexion = getConnection();
        try {
            ps = conexion.prepareStatement("insert into producto (clave,nombre,precio,fecha_venta,idcategoria) values(?,?,?,?,?)");
            ps.setString(1,producto.getClave());
            ps.setString(2,producto.getNombre());
            ps.setDouble(3,producto.getPrecio());
            ps.setDate(4,producto.getFecha_venta());
            ps.setInt(5,producto.getIdcategoria());
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error ,"+ex);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.print("Error ,"+ex);
               
            }
        }
    }
     public boolean buscar(Producto producto){
        Connection conexion = getConnection();
        try {
           ps= conexion.prepareStatement("select * from producto where clave=?");
           ps.setString(1, producto.getClave());
           rs = ps.executeQuery();
           if(rs.next()){
               producto.setIdProducto(rs.getInt("idProducto"));
               producto.setClave(rs.getString("clave"));
               producto.setNombre(rs.getString("nombre"));
               producto.setPrecio(rs.getDouble("precio"));
               producto.setFecha_venta(rs.getDate("fecha_venta"));
               producto.setIdcategoria(rs.getInt("idcategoria"));
               return  true;
           }
           else{
               return false;
           }
        } catch (Exception ex) {
            System.err.println("Error ,"+ex);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.print("Error ,"+ex);
               
            }
        }
    }
        public boolean modificar(Producto producto){
        Connection conexion = getConnection();
        try {
            ps = conexion.prepareStatement("update producto set clave=?,nombre=?,precio=?,fecha_venta=?,idcategoria=? where idProducto=?");
            ps.setString(1,producto.getClave());
            ps.setString(2,producto.getNombre());
            ps.setDouble(3,producto.getPrecio());
            ps.setDate(4,producto.getFecha_venta());
            ps.setInt(5,producto.getIdcategoria());
            ps.setInt(6,producto.getIdProducto());
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error ,"+ex);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.print("Error ,"+ex);
               
            }
        }
    }
         public boolean eliminar(Producto producto){
        Connection conexion = getConnection();
        try {
            ps = conexion.prepareStatement("delete from producto where idProducto=?");
            ps.setInt(1,producto.getIdProducto());
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error ,"+ex);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception ex) {
                System.err.print("Error ,"+ex);
               
            }
        }
    }
        
}
