
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Producto {
   private int idProducto;
   private String nombreProducto;
   private int pesoProducto;
   private int idProveedor_Producto;
   private int idTipo_Producto;
   private int precioProducto;
   
    //METODOS GETTERS Y SETTERS DE LA CLASE PRODUCTO
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPesoProducto() {
        return pesoProducto;
    }

    public void setPesoProducto(int pesoProducto) {
        this.pesoProducto = pesoProducto;
    }

    public int getIdProveedor_Producto() {
        return idProveedor_Producto;
    }

    public void setIdProveedor_Producto(int idProveedor_Producto) {
        this.idProveedor_Producto = idProveedor_Producto;
    }

    public int getIdTipo_Producto() {
        return idTipo_Producto;
    }

    public void setIdTipo_Producto(int idTipo_Producto) {
        this.idTipo_Producto = idTipo_Producto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    //METODOS CRUD PARA LA CLASE PRODUCTO
    
    //LISTAR
    
    public Iterator<Producto> listar()
    {
    ArrayList<Producto> losProductos = new ArrayList<>();
    
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `producto`");
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            while (rs.next()) {                
                unProducto = new Producto();
                unProducto.setIdProducto(   rs.getInt("idProducto"));
                unProducto.setNombreProducto(   rs.getString("nombreProducto"));
                unProducto.setPesoProducto(   rs.getInt("pesoProducto"));
                unProducto.setIdProveedor_Producto(    rs.getInt("idProveedor_Producto"));
                unProducto.setIdTipo_Producto(    rs.getInt("idTipo_Producto"));
                unProducto.setPrecioProducto(   rs.getInt("precioProducto"));
                losProductos.add(unProducto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar");
        }
        
        if (losProductos.isEmpty()) {
            Producto miProducto = new Producto();
            miProducto.setNombreProducto("no hay productos disponibles");
            losProductos.add(miProducto);
        }
    return losProductos.iterator();
    }
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `producto`( `nombreProducto`, `pesoProducto`, `idProveedor_Producto`, `idTipo_Producto`, `precioProducto`) VALUES (?,?,?,?,?)");
            sql.setString(1, this.getNombreProducto());
            sql.setInt(2, this.getPesoProducto());
            sql.setInt(3, this.getIdProveedor_Producto());
            sql.setInt(4, this.getIdTipo_Producto());
            sql.setInt(5, this.getPrecioProducto());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println("Error  en Produco "+e.getMessage());
        }
    }
    
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `producto` SET`nombreProducto`=?,`pesoProducto`=?,`idProveedor_Producto`=?,`idTipo_Producto`=?,`precioProducto`=? WHERE `idProducto`=?");
            sql.setString(1, this.getNombreProducto());
            sql.setInt(2, this.getPesoProducto());
            sql.setInt(3, this.getIdProveedor_Producto());
            sql.setInt(4, this.getIdTipo_Producto());
            sql.setInt(5, this.getPrecioProducto());
            sql.setInt(6, this.getIdProducto());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println("Error al modificar  "+e.getMessage());
        }
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `producto` WHERE `idProducto`=?");
            sql.setInt(1, this.getIdProducto());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println("Error   "+e.getMessage());
        }
    }
    
    //BUSCAR
    
    public Iterator<Producto> buscar(String busqueda)
    {
    ArrayList<Producto> losProductos = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `producto` WHERE idProducto LIKE ? OR nombreProducto LIKE? OR pesoProducto LIKE? OR idProveedor_Producto LIKE? OR idTipo_Producto LIKE? OR precioProducto LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            sql.setString(5, "%"+busqueda+"%");
            sql.setString(6, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            while (rs.next()) {                
                unProducto = new Producto();
                unProducto.setIdProducto(   rs.getInt("idProducto"));
                unProducto.setNombreProducto(  rs.getString("nombreProducto"));
                unProducto.setPesoProducto(   rs.getInt("pesoProducto"));
                unProducto.setIdProveedor_Producto(   rs.getInt("idProveedor_Producto"));
                unProducto.setIdTipo_Producto(    rs.getInt("idTipo_Producto"));
                unProducto.setPrecioProducto(   rs.getInt("precioProducto"));
                losProductos.add(unProducto);
                       
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error");
            System.out.println("Error   "+e.getMessage());
        }
    return losProductos.iterator();
    
    }
    
    //BUSCAR POR EL ID
    
    public Producto buscarPorId(int elId)
    {
    Producto unProducto = new Producto();
    unProducto.setNombreProducto("el Producto no existe");
    
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `producto` WHERE `idProducto`=?");
            sql.setInt(1, elId);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {                
                unProducto.setIdProducto(   rs.getInt("idProducto"));
                unProducto.setNombreProducto(   rs.getString("nombreProducto"));
                unProducto.setPesoProducto(   rs.getInt("pesoProducto"));
                unProducto.setIdProveedor_Producto(   rs.getInt("idProveedor_Producto"));
                unProducto.setIdTipo_Producto(   rs.getInt("idTipo_Producto"));
                unProducto.setPrecioProducto(   rs.getInt("precioProducto"));
                
            }
        } catch (SQLException e) {
           
            System.out.println("Error   "+e.getMessage());
        }
    return unProducto;
    }
    //METODO HASHCODE
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    //METODO TO STRING
    @Override
    public String toString() {
        return getNombreProducto();
    }
    
}
