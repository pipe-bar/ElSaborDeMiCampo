
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Pedido {
   private int idPedido;
   private int idProveedorPedido;
   private int idProductoPedido;
   private String fechaPedido;
   private String observacionPedido;
   
    //GETTERS Y SETTERS DE LA CLASE PEDIDO
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProveedorPedido() {
        return idProveedorPedido;
    }

    public void setIdProveedorPedido(int idProveedorPedido) {
        this.idProveedorPedido = idProveedorPedido;
    }

    public int getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(int idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getObservacionPedido() {
        return observacionPedido;
    }

    public void setObservacionPedido(String observacionPedido) {
        this.observacionPedido = observacionPedido;
    }
    
    //METODOS CRUD PARA LA CLASE PERSONA
    
    //LISTAR
    
    public Iterator<Pedido> listar()
    {
        ArrayList<Pedido> losPedidos = new ArrayList<>();
        
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `pedido`");
            ResultSet rs = sql.executeQuery();
            Pedido unPedido;
            while (rs.next()) {                
                unPedido = new Pedido();
                unPedido.setIdPedido(    rs.getInt("idPedido"));
                unPedido.setIdProveedorPedido(   rs.getInt("idProveedorPedido"));
                unPedido.setIdProductoPedido(   rs.getInt("idProductoPedido"));
                unPedido.setObservacionPedido(rs.getString("observacionPedido"));
                unPedido.setFechaPedido(rs.getString("fechaPedido"));
                losPedidos.add(unPedido);
               
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace()+"   no ha sido posible listar por   "+e.getMessage());
        }
            
        return losPedidos.iterator();
    
    }
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `pedido`( `idProveedorPedido`, `idProductoPedido`,`observacionPedido`) VALUES (?,?,?)");
            sql.setInt(1, this.getIdProveedorPedido());
            sql.setInt(2, this.getIdProductoPedido());
            sql.setString(3, this.getObservacionPedido());
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido Insertado");
            
            
        } catch (SQLException e) {
            System.out.println("no se ha podido insertar  "+e.getLocalizedMessage());
        }
    }
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `pedido` SET `idProveedorPedido`=?,`idProductoPedido`=?,`observacionPedido`=? WHERE `idPedido`=?");
            sql.setInt(1, this.getIdProveedorPedido());
            sql.setInt(2, this.getIdProductoPedido());
            sql.setString(3, this.getObservacionPedido());
            sql.setInt(4, this.getIdPedido());
            sql.executeUpdate();
             JOptionPane.showMessageDialog(null, "Pedido Modificado");
            
        } catch (SQLException e) {
            System.out.println("no se ha podido modificar"+e.getMessage());
        }
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `pedido` WHERE `idPedido`=?");
            sql.setInt(1, this.getIdPedido());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido Eliminado");
        } catch (SQLException e) {
            System.out.println("no se pudo eliminar   "+e.getMessage());
        }
    }
    
    //BUSCAR 
    
    public Iterator<Pedido> buscar(String busqueda)
    {
    ArrayList<Pedido> losPedidos = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `pedido` WHERE idPedido LIKE? or idProductoPedido LIKE? OR idProductoPedido LIKE? OR observacionPedido LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Pedido unPedido;
            
            while (rs.next()) {                
                unPedido = new Pedido();
                unPedido.setIdPedido(rs.getInt("idPedido"));
                unPedido.setIdProveedorPedido(   rs.getInt("idProductoPedido"));
                unPedido.setIdProductoPedido( rs.getInt("idProductoPedido"));
                unPedido.setObservacionPedido(  rs.getString("observacionPedido"));
                unPedido.setFechaPedido(   rs.getString("fechaPedido"));
                losPedidos.add(unPedido);
            }
        } catch (SQLException e) {
            System.out.println("pailas socito"  +e.getMessage());
        }
    return losPedidos.iterator();
    }
    
    //METODO HASH
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return getObservacionPedido();
    }
   
    
   
   
    
}
