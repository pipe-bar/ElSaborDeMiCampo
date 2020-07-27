
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Proveedor {
   private int idProveedor;
   private String nombreProveedor;
   private String RUTProveedor;
   private String telefonoProveedor;
   private String direccionProveedor;
   
    //METODOS GETTERS Y SETTERS DE LA CLASE PROVEEDOR
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRUTProveedor() {
        return RUTProveedor;
    }

    public void setRUTProveedor(String RUTProveedor) {
        this.RUTProveedor = RUTProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    //METODOS CRUD PARA LA CLASE PROVEEDOR
    
    
    //LISTAR
    
    public Iterator<Proveedor> listar()
    {
        ArrayList<Proveedor> losProveedores = new ArrayList<>();
        
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM proveedor");
            ResultSet rs = sql.executeQuery();
            Proveedor unProveedor;
            
            while (rs.next()) {  
                unProveedor = new Proveedor();
                unProveedor.setIdProveedor(    rs.getInt("idProveedor"));
                unProveedor.setNombreProveedor(   rs.getString("nombreProveedor"));
                unProveedor.setRUTProveedor(     rs.getString("RUTProveedor"));
                unProveedor.setTelefonoProveedor(   rs.getString("telefonoProveedor"));
                unProveedor.setDireccionProveedor(   rs.getString("direccionProveedor"));
                losProveedores.add(unProveedor);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar");
            System.out.println("error  "+e.getMessage());
        }
        
        if (losProveedores.isEmpty()) {
            Proveedor miProveedor = new Proveedor();
            miProveedor.setNombreProveedor("no hay Proveedores Registrados");
            losProveedores.add(miProveedor);
        }
        return losProveedores.iterator();
    }
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `proveedor`( `nombreProveedor`, `RUTProveedor`, `telefonoProveedor`, `direccionProveedor`) VALUES (?,?,?,?)");
            sql.setString(1, this.getNombreProveedor());
            sql.setString(2, this.getRUTProveedor());
            sql.setString(3, this.getTelefonoProveedor() );
            sql.setString(4, this.getDireccionProveedor() );
            sql.executeUpdate();
             JOptionPane.showMessageDialog(null, "Proveedor Registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
            System.out.println("errro  "+e.getMessage());
        }
    
    }
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `proveedor` SET `nombreProveedor`=?,`RUTProveedor`=?,`telefonoProveedor`=?,`direccionProveedor`=? WHERE `idProveedor`=?");
            sql.setString(1, this.getNombreProveedor());
            sql.setString(2, this.getRUTProveedor());
            sql.setString(3, this.getTelefonoProveedor() );
            sql.setString(4, this.getDireccionProveedor() );
            sql.setInt(5, this.getIdProveedor());
            sql.executeUpdate();
             JOptionPane.showMessageDialog(null, "Proveedor Modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar");
            System.out.println("error  "+e.getMessage());
        }
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `proveedor` WHERE `idProveedor`=?");
            sql.setInt(1, this.getIdProveedor());
            sql.executeUpdate();
             JOptionPane.showMessageDialog(null, "Proveedor Eliminado");       
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error al Eliminar");
             System.out.println("error  "+e.getMessage());
        }
    }
    
    //BUSCAR PROVEEDOR
    
    public Iterator<Proveedor> buscar(String busqueda)
    {
    ArrayList<Proveedor> losProveedores = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `proveedor` WHERE idProveedor LIKE? OR nombreProveedor LIKE? OR RUTProveedor LIKE? OR telefonoProveedor LIKE? OR direccionProveedor LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            sql.setString(5, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Proveedor unProveedor;
            
            while (rs.next()) {                
                unProveedor = new Proveedor();
                unProveedor.setIdProveedor(   rs.getInt("idProveedor"));
                unProveedor.setNombreProveedor(   rs.getString("nombreProveedor"));
                unProveedor.setRUTProveedor(     rs.getString("RUTProveedor"));
                unProveedor.setTelefonoProveedor(   rs.getString("telefonoProveedor"));
                unProveedor.setDireccionProveedor(   rs.getString("direccionProveedor"));
                losProveedores.add(unProveedor);        
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "NO se ha podido buscar");  
            
        }
    return losProveedores.iterator();
            
            
    }
    
    //BUSCAR POR EL ID
    
    public Proveedor buscarPorId(int elId)
    {
    Proveedor elProveedor = new Proveedor();
    elProveedor.setNombreProveedor("El Proveedor No Existe");
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `proveedor` WHERE `idProveedor`=?");
            sql.setInt(1, elId);
             ResultSet rs = sql.executeQuery();
             while (rs.next()) {
                
                 elProveedor.setIdProveedor(   rs.getInt("idProveedor"));
                 elProveedor.setNombreProveedor(   rs.getString("nombreProveedor"));
                 elProveedor.setRUTProveedor(     rs.getString("RUTProveedor"));
                 elProveedor.setTelefonoProveedor(     rs.getString("telefonoProveedor"));
                 elProveedor.setDireccionProveedor(    rs.getString("direccionProveedor"));
            }
        } catch (SQLException e) {
            System.out.println("no se ha podido buscar por el id     "+e.getMessage());
        }
    return elProveedor;
    }
   
    //METODO TO STRING PARA LA CLASE PROVEDOR
    @Override
    public String toString() {
        return  getNombreProveedor();
    }
    
    //METODO HASCODE PARA EL ID DE LA CLASE PROVEEDOR
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
        final Proveedor other = (Proveedor) obj;
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        return true;
    }
    
    
   
}
