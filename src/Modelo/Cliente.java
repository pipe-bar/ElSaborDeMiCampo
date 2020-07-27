
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Cliente {
    
    private int id;
    private String nombreCliente;
    private String documentoCliente;
    private String direccionCliente;
    private String celularCliente;

    //getters y setters de los atributos de cliente
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }
    
    //este es el metodo to string para mostrar datos representativos
    @Override
    public String toString() {
        return getNombreCliente();
    }
    
    //este es le hashcode y equalscode
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    //metodos CRUD de la clase cliente
    
    
    //LISTAR
    
    public Iterator<Cliente> listar()
    {
        ArrayList<Cliente> losClientes = new ArrayList<>();
          try {
              PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM cliente");
               
               ResultSet rs = sql.executeQuery();
              Cliente unCliente;
              while (rs.next()) {                  
                  unCliente = new Cliente();
                  unCliente.setId(rs.getInt("idCliente"));
                  unCliente.setNombreCliente(rs.getString("nombreCliente"));
                  unCliente.setDocumentoCliente(rs.getString("documentocliente"));
                  unCliente.setDireccionCliente(rs.getString("direccionCliente"));
                  unCliente.setCelularCliente(rs.getString("celularCliente"));
                  losClientes.add(unCliente);
                          
              }
        } catch (SQLException ex) {
              System.out.println("No ha sido posible listar "+ex.getMessage());
        }
          if (losClientes.isEmpty()) {
            Cliente miCliente = new Cliente();
            miCliente.setNombreCliente("no hay clientes, ni uno siquiera :V");
            losClientes.add(miCliente);
        }
      return losClientes.iterator();
    }
    
    //INSERTAR
   
    public void insertar()
    {
       
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `cliente`( `nombreCliente`, `documentoCliente`, `direccionCliente`, `celularCliente`) VALUES (?,?,?,?)");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Insertó Cliente',null)");
            auditoria.executeUpdate();
            if(this.getNombreCliente().isEmpty())
            {JOptionPane.showMessageDialog(null,"LLene todos los campos");
            }else{
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getDireccionCliente());
            sql.setString(4, this.getCelularCliente());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente Insertado");
                System.out.println(""+auditoria);
            }
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"NO se registró    ");
        }
    }
    
    //MODIFICAR
    public void modificar ()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `cliente` SET `nombreCliente`=?,`documentoCliente`=?,`direccionCliente`=?,`celularCliente`=? WHERE idCliente=?");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Modificó Cliente',null)");
            auditoria.executeUpdate();
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getDireccionCliente());
            sql.setString(4, this.getCelularCliente());
            sql.setInt(5, this.getId());
            sql.executeUpdate();
             JOptionPane.showMessageDialog(null,"Cliente Modificado");
             System.out.println(sql);
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"NO se modificó");
              
        }
    
    }
    
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
             PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM cliente WHERE idCliente=?");
             PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Eliminó Cliente',null)");
            auditoria.executeUpdate();
             sql.setInt(1, this.getId());
             sql.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente Eliminado");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null ,"No su puede eliminar");
              
        }
    }
    
    
    //BUSCAR
    
    public Iterator<Cliente> buscar(String busqueda)
    {
      ArrayList<Cliente> losClientes = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM cliente WHERE nombreCliente LIKE? OR documentoCliente LIKE? OR direccionCliente LIKE? OR celularCliente LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()) {                
                unCliente = new Cliente();
                unCliente.setId(   rs.getInt("idCliente"));
                unCliente.setNombreCliente(   rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(  rs.getString("documentoCliente"));
                unCliente.setDireccionCliente(  rs.getString("direccionCliente"));
                unCliente.setCelularCliente( rs.getString("celularCliente"));
                losClientes.add(unCliente); 
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar");  
        }
      return losClientes.iterator();
    }
    //
    public Cliente buscarPorId(int elID)
    {
    
    Cliente unCliente = new Cliente();
    unCliente.setNombreCliente("El cliente no existe");
        try {
          PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM cliente WHERE idCliente=?");
          sql.setInt(1, elID);
          int elId = this.getId();
          ResultSet rs = sql.executeQuery();
            while (rs.next()) {                
                unCliente.setId(   rs.getInt("idCliente"));
                unCliente.setNombreCliente(   rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(  rs.getString("documentoCliente"));
                unCliente.setDireccionCliente(  rs.getString("direccionCliente"));
                unCliente.setCelularCliente( rs.getString("celularCliente"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar ID");
        }
        
        return unCliente;
    }
    
    
    
    //esta llave no se borra, es la ultima
}
