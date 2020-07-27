

package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Usuario {
    
    private int idUsuario;
    private String nombreUsuario;
    private String cedulaUsuario;
    private String correoUsuario;
    private String telefonoUsuario;
    private String contrasenaUsuario;
    private String rolUsuario;
    
    //METODOS GETTERS Y SETTERS DE LA CLASE USUARIO
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
       //METODOS CRUD DE LA CLASE USUARIO
    
    //INSERTAR
    
    public Iterator<Usuario> listar()
    {
        ArrayList<Usuario> losUsuarios = new ArrayList<>();
        
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = sql.executeQuery();
            Usuario unUsuario;
            while (rs.next()) {                
                unUsuario = new Usuario();
                unUsuario.setIdUsuario(   rs.getInt("idUsuario"));
                unUsuario.setNombreUsuario(   rs.getString("nombreUsuario"));
                unUsuario.setCedulaUsuario(     rs.getString("cedulaUsuario"));
                unUsuario.setCorreoUsuario(     rs.getString("correoUsuario"));
                unUsuario.setTelefonoUsuario(     rs.getString("telefonoUsuario"));
                unUsuario.setContrasenaUsuario(     rs.getString("contrasenaUsuario"));
                unUsuario.setRolUsuario(     rs.getString("rolUsuario"));
                losUsuarios.add(unUsuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no se ha podido listar");
            System.out.println("error  "+e.getMessage());
        }
        
        if (losUsuarios.isEmpty()) {
            Usuario miUsuario = new Usuario();
            miUsuario.setNombreUsuario("No hay usuarios");
        }
        return losUsuarios.iterator();
    
    }
    
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            if (this.getNombreUsuario().isEmpty()  || this.getCedulaUsuario().isEmpty() || this.getCorreoUsuario().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
            } else {
             PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `usuario` ( `nombreUsuario`, `cedulaUsuario`, `correoUsuario`, `telefonoUsuario`, `contrasenaUsuario`, `rolUsuario`) VALUES (?,?,?,?,SHA(?),?)");
             PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Insertó Usuario',null)");
            sql.setString(1, this.getNombreUsuario());
            sql.setString(2, this.getCedulaUsuario());
            sql.setString(3, this.getCorreoUsuario());
            sql.setString(4, this.getTelefonoUsuario());
            sql.setString(5, this.getContrasenaUsuario());
            sql.setString(6, this.getRolUsuario());
            sql.executeUpdate();
            auditoria.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Usuario Insertado");
                 System.out.println(""+auditoria);
            }
                 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar");
            System.out.println("no se ha ingresado por   "+e.getMessage());
        }
    
    }
    
    //MODIFICAR
    
    public void modificar()
    {
        try {
            if (this.getNombreUsuario().isEmpty()  || this.getCedulaUsuario().isEmpty() || this.getCorreoUsuario().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
            } else {
             PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `usuario` SET `nombreUsuario`=?,`cedulaUsuario`=?,`correoUsuario`=?,`telefonoUsuario`=?,`contrasenaUsuario`=?,`rolUsuario`=? WHERE `idUsuario`=?");
            sql.setString(1, this.getNombreUsuario());
            sql.setString(2, this.getCedulaUsuario());
            sql.setString(3, this.getCorreoUsuario());
            sql.setString(4, this.getTelefonoUsuario());
            sql.setString(5, this.getContrasenaUsuario());
            sql.setString(6, this.getRolUsuario());
            sql.setInt(7, this.getIdUsuario());
             sql.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Usuario Modificado");
            }
                 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erroe al modificar");
            System.out.println("no se ha modificado por   "+e.getMessage());
        }
    }
    
    //ELIMINAR
    
   public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `usuario` WHERE `idUsuario`=?");
            sql.setInt(1, this.getIdUsuario());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");  
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al eliminar "); 
        }
    }
      //BUSCAR
    public Iterator <Usuario>buscar(String busqueda)
    {
        ArrayList<Usuario> losUsuarios = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `usuario` WHERE nombreUsuario LIKE? or cedulaUsuario LIKE? OR correoUsuario LIKE? OR telefonoUsuario LIKE? OR rolUsuario LIKE ?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            sql.setString(5, "%"+busqueda+"%");
            
            ResultSet rs = sql.executeQuery();
            Usuario unUsuario;
            while (rs.next()) {    
                unUsuario = new Usuario();
                unUsuario.setNombreUsuario(    rs.getString("nombreUsuario"));
                unUsuario.setCedulaUsuario(     rs.getString("cedulausuario"));
                unUsuario.setCorreoUsuario(    rs.getString("correoUsuario"));
                unUsuario.setTelefonoUsuario(      rs.getString("telefonoUsuario"));
                unUsuario.setRolUsuario(           rs.getString("rolUsuario"));
                losUsuarios.add(unUsuario);
            }
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al buscar");
            System.out.println("error  "+e.getMessage());
        }
        return losUsuarios.iterator();
    }
    
    //BUSCAR POR EL ID
    
      public Usuario buscarPorId(int elId)
    {
    Usuario unUsuario = new Usuario();
    unUsuario.setNombreUsuario("el cliente no existe");
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM usuario WHERE idUsuario=?");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {                
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unUsuario.setNombreUsuario(rs.getString("nombreUsuario"));
                unUsuario.setCedulaUsuario(rs.getString("cedulaUsuario"));
                unUsuario.setCorreoUsuario(rs.getString("correoEmpleado"));
                unUsuario.setTelefonoUsuario(rs.getString("telefonoEmpleado"));
                unUsuario.setRolUsuario(rs.getString("rolEmpleado"));
            }
        } catch (SQLException e) {
            System.out.println("no se pudo buscar por el id   "+e.getMessage());
        }
    return unUsuario;
    }
    
    
    //HASH CODE 
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return getNombreUsuario();
    }
     
    
}
