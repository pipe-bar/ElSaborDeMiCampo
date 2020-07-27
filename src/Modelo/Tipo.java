
package Modelo;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Tipo {
    private int idTipo;
    private String descripcionTipo;
    
    //METODOS GETTERS Y SETTERS
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
    
    //CRUD DE LA CLASE
    
    public Iterator<Tipo> listar()
    {
    ArrayList<Tipo> losTipos = new ArrayList<>();
    
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM tipo");
            ResultSet rs = sql.executeQuery();
            Tipo unTipo;
            while (rs.next()) {                
                unTipo = new Tipo();
                unTipo.setIdTipo(   rs.getInt("idTipo"));
                unTipo.setDescripcionTipo(   rs.getString("descripcionTipo"));
                losTipos.add(unTipo);
               
            }
        } catch (SQLException e) {
            System.out.println("no se puede listar"+e.getMessage());
        }
        if (losTipos.isEmpty()) {
            Tipo miTipo = new Tipo();
            miTipo.setDescripcionTipo("el tipo no existe");
            losTipos.add(miTipo);
        }
        
    return losTipos.iterator();
    }
    
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `tipo`( `descripcionTipo`) VALUES (?)");
            sql.setString(1, this.getDescripcionTipo());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "se ha ingresado un tipo");
        } catch (SQLException e) {
            System.out.println("no se ha podido registrar"+e.getMessage());
        }      
    }
    
    
   //MODIFICAR
    
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `tipo` SET `descripcionTipo`=? WHERE `idTipo`=?");
            sql.setString(1, this.getDescripcionTipo());
            sql.setInt(2, this.getIdTipo());
             JOptionPane.showMessageDialog(null, "Tipo Modificado");
            sql.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al modificar"+e.getMessage());
        }
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `tipo` WHERE `idTipo`=?");
            sql.setInt(1, this.getIdTipo());
            sql.executeUpdate();
              JOptionPane.showMessageDialog(null, "Tipo Eliminado");      
        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
    //BUSCAR
    public Iterator<Tipo> buscar(String busqueda)
    {
    ArrayList<Tipo> losTipos = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `tipo` WHERE `idTipo` LIKE? OR `descripcionTipo` LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Tipo unTipo;
            while (rs.next()) {                
               unTipo  = new Tipo();
               unTipo.setIdTipo(   rs.getInt("idTipo"));
               unTipo.setDescripcionTipo(   rs.getString("descripcionTipo"));
               losTipos.add(unTipo);
            }
            
        } catch (SQLException e) {
            System.out.println("no se ha podido buscar");
        }
        
        if (losTipos.isEmpty()) {
            Tipo miTipo = new Tipo();
            miTipo.setDescripcionTipo("el tipo no existe");
            losTipos.add(miTipo);
        }
    return losTipos.iterator();
    }
    
    
    //BUSCAR POR EL ID
    
   public Tipo buscarPorId(int elId)
   {
   Tipo unTipo = new Tipo();
   unTipo.setDescripcionTipo("el tipo no existe");
       try {
           PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `tipo` WHERE `idTipo`=?");
           sql.setInt(1, elId);
           ResultSet rs = sql.executeQuery();
           while (rs.next()) {  
               unTipo.setIdTipo(     rs.getInt("idTipo"));
               unTipo.setDescripcionTipo(       rs.getString("descripcionTipo")); 
               
           }
       } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "no se ha podido buscar por el id");
             System.out.println("no se ha podido buscar por el id  "+e.getMessage());
       }
   return unTipo;
   
   }   
   
   

    //METODO HASCODE
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
        final Tipo other = (Tipo) obj;
        if (this.idTipo != other.idTipo) {
            return false;
        }
        return true;
    }
   
    //to string
    @Override
    public String toString() {
        return getDescripcionTipo();
    }
    
    
}
