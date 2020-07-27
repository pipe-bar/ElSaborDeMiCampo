
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;


public class Compra {
    
    private int idCompra;
    private int idClienteCompra;
    private int idProductoCompra;
    
    //METODOS GETTERS Y SETTERS DE LA CLASE VENTA
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdClienteCompra() {
        return idClienteCompra;
    }

    public void setIdClienteCompra(int idClienteCompra) {
        this.idClienteCompra = idClienteCompra;
    }

    public int getIdProductoCompra() {
        return idProductoCompra;
    }

    public void setIdProductoCompra(int idProductoCompra) {
        this.idProductoCompra = idProductoCompra;
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
        final Compra other = (Compra) obj;
        if (this.idCompra != other.idCompra) {
            return false;
        }
        return true;
    }
    
    
    //METODOS GETTERS Y SETTERS PARA LA CLASE VENTA
    //LISTAR
    public Iterator<Compra> listar()
    {
    ArrayList<Compra> lasVentas =new  ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM compra INNER JOIN cliente ON compra.idClienteCompra = cliente.idCliente INNER JOIN producto ON compra.idProductoCompra=producto.idProducto");
            
            ResultSet rs = sql.executeQuery();
            Compra unaVenta;
            while (rs.next()) {                
                unaVenta = new Compra();
                unaVenta.setIdCompra(     rs.getInt("idCompra"));
                unaVenta.setIdClienteCompra(rs.getInt("idClienteCompra"));
                unaVenta.setIdProductoCompra(   rs.getInt("idProductoCompra"));
                
                lasVentas.add(unaVenta);
            }
        } catch (SQLException e) {
            System.out.println("no se pudo listar porque  "  +e.getMessage());
            
        }
    return lasVentas.iterator();
    }
    
    //REGISTRAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO compra(idClienteCompra,idProductoCompra) VALUES (?,?)");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Insertó Compra',null)");
            auditoria.executeUpdate();
            sql.setInt(1, this.getIdClienteCompra());
            sql.setInt(2, this.getIdProductoCompra());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra insertada");
        } catch (SQLException e) {{
            System.out.println("no se realizo la inserción por  " +e.getMessage());
        }
        }
    }
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `compra` SET `idClienteCompra`=?,`idProductoCompra`=? WHERE `idCompra`=?");
             PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Modificó Compra',null)");
            auditoria.executeUpdate();
            sql.setInt(1, this.getIdClienteCompra());
            sql.setInt(2, this.getIdProductoCompra());
            sql.setInt(3, this.getIdCompra());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra Modificada");
        } catch (SQLException e) {
            System.out.println("no se pudo modificar por  "+e.getMessage());
        }
    }
    
    //Eliminar
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `compra` WHERE `idCompra`=?");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Eliminó Compra',null)");
            auditoria.executeUpdate();
            sql.setInt(1, this.getIdCompra());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra Eliminada");
        } catch (SQLException e) {
            System.out.println("no se pudo eliminar por  "+e.getMessage());
        }
    }
    
    //BUSCAR
    public Iterator<Compra> buscar(String busqueda)
    {
    ArrayList<Compra> lasCompras = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `compra` WHERE `idCompra`=?");
            sql.setString(1, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Compra unaCompra;
            
            while (rs.next()) {                
                unaCompra = new Compra();
                unaCompra.setIdClienteCompra(    rs.getInt("idClienteCompra"));
                lasCompras.add(unaCompra);
            }
        } catch (SQLException e) {
            System.out.println("pailas socito"  +e.getMessage());
        }
    return lasCompras.iterator();
    }
     //BUSCAR POR EL ID
    
   
    
  
            
            //esta es la ultima llave
}
