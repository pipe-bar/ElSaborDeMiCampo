
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Bodega {
    private int idBodega;
    private String codigoBodega;
    private int idProductoBodega;
    private int cantidadBodega;
    
    //GETTER Y SETTERS DE LA CLASE
    
    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public int getIdProductoBodega() {
        return idProductoBodega;
    }

    public void setIdProductoBodega(int idProductoBodega) {
        this.idProductoBodega = idProductoBodega;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }
    
    //LISTAR
    
    public Iterator<Bodega> listar()
    {
    ArrayList<Bodega> lasBodegas = new ArrayList<>();
    
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM bodega");
            ResultSet rs = sql.executeQuery();
            Bodega unaBodega;
            while (rs.next()) {                
                unaBodega = new Bodega();
                unaBodega.setIdBodega(   rs.getInt("idBodega"));
                unaBodega.setCodigoBodega(     rs.getString("codigoBodega"));
                unaBodega.setIdProductoBodega(   rs.getInt("idProductoBodega"));
                unaBodega.setCantidadBodega(   rs.getInt("cantidadBodega"));
                lasBodegas.add(unaBodega);
            }
        } catch (SQLException e) {
            System.out.println("no se ha podido listar   "+e.getMessage());
        }
    return lasBodegas.iterator();
    }
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `bodega`( `codigoBodega`, `idProductoBodega`, `cantidadBodega`) VALUES (?,?,?)");
            sql.setString(1, this.getCodigoBodega());
            sql.setInt(2, this.getIdProductoBodega());
            sql.setInt(3, this.getCantidadBodega());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Insertado En Bodega");
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error   "+e.getMessage());
            
        }
    }
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
             PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `bodega` SET `codigoBodega`=?,`idProductoBodega`=?,`cantidadBodega`=? WHERE `idBodega`=?");
            sql.setString(1, this.getCodigoBodega());
            sql.setInt(2, this.getIdProductoBodega());
            sql.setInt(3, this.getCantidadBodega());
            sql.setInt(4, this.getIdBodega());
            
           sql.executeUpdate();
           JOptionPane.showMessageDialog(null, "Producto Modificado En Bodega");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()+"no se ha podido modificar por  "+e.getMessage());
        }
        
       
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `bodega` WHERE `idBodega`=?");
            sql.setInt(1, this.getIdBodega());
             sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Eliminado En Bodega");
        } catch (SQLException e) {
            System.out.println("no se ha podido eliminar    "+e.getMessage());
        }
    }
    
    //BUSCAR
    public Iterator<Bodega> buscar(String busqueda)
    {
    ArrayList<Bodega> lasBodegas = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `bodega` WHERE codigoBodega LIKE? OR idProductoBodega LIKE? OR cantidadBodega LIKE?");
             sql.setString(1, "%"+busqueda+"%");
             sql.setString(2, "%"+busqueda+"%");
             sql.setString(3, "%"+busqueda+"%");
             ResultSet rs = sql.executeQuery();
             Bodega unaBodega;
             
             while (rs.next()) {                
                unaBodega = new Bodega();
                unaBodega.setCodigoBodega(   rs.getString("codigoBodega"));
                unaBodega.setIdProductoBodega(   rs.getInt("idProductoBodega"));
                unaBodega.setCantidadBodega(   rs.getInt("cantidadBodega"));
                lasBodegas.add(unaBodega);
            }
        } catch (SQLException e) {
            System.out.println("no se ha podido buscar   "+e.getMessage());
                    
        }
    return lasBodegas.iterator();
    }
    
    
    
  //esta es la llave final   

    //equals y hascode
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Bodega other = (Bodega) obj;
        if (this.idBodega != other.idBodega) {
            return false;
        }
        return true;
    }

    //to string
    @Override
    public String toString() {
        return  getCodigoBodega();
    }
    
    
}
