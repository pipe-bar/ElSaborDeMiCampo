
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Empleado {
    
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String edadEmpleado;
    private String salarioEmpleado;
    private String correoEmpleado;
    
    //getters y setters de la clase empleado
    
    
    //METODO TO STRING
    @Override
    public String toString() {
        return "Empleado{" + "nombreEmpleado=" + nombreEmpleado + '}';
    }
    
    //METODOS CRUD PARA LA CLASE EMPLEADO
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(String edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }

    public String getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(String salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }
    
    
    //LISTAR
    
    public Iterator<Empleado> listar()
    {
       ArrayList<Empleado> losEmpleados = new ArrayList<>();
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM empleado");
            ResultSet rs = sql.executeQuery();
            Empleado unEmpleado;
            while (rs.next()) {   
                unEmpleado = new Empleado();
                unEmpleado.setIdEmpleado(    rs.getInt("idEmpleado"));
                unEmpleado.setNombreEmpleado(    rs.getString("nombreEmpleado"));
                unEmpleado.setApellidoEmpleado(    rs.getString("apellidoEmpleado"));
                unEmpleado.setEdadEmpleado(     rs.getString("edadEmpleado"));
                unEmpleado.setSalarioEmpleado(   rs.getString("salarioEmpleado"));
                unEmpleado.setCorreoEmpleado(    rs.getString("correoEmpleado"));
                losEmpleados.add(unEmpleado);
            }
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible listar");
        }
        if (losEmpleados.isEmpty()) {
            Empleado miEmpleado = new Empleado();
            miEmpleado.setNombreEmpleado("No hay datos por mostar");
            losEmpleados.add(miEmpleado);
        }
       return losEmpleados.iterator();
    }
    
    //INSERTAR
    
    public void insertar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("INSERT INTO `empleado`( `nombreEmpleado`, `apellidoEmpleado`, `edadEmpleado`, `salarioEmpleado`, `correoEmpleado`) VALUES (?,?,?,?,?)");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Insertó Empleado',null)");
            auditoria.executeUpdate();
            if (!this.getNombreEmpleado().isEmpty() && !this.getApellidoEmpleado().isEmpty()) {
                sql.setString(1, this.getNombreEmpleado());
                sql.setString(2, this.getApellidoEmpleado());
                sql.setString(3, this.getEdadEmpleado());
                sql.setString(4,  this.getSalarioEmpleado());
                sql.setString(5,  this.getCorreoEmpleado());
                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado registrado");  
                
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                
            }
               
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR al registrar");
             System.out.println("no pude registrar porque" +e.getMessage());
            
        }
    }
    
    //MODIFICAR
    public void modificar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("UPDATE `empleado` SET `nombreEmpleado`=?,`apellidoEmpleado`=?,`edadEmpleado`=?,`salarioEmpleado`=?,`correoEmpleado`=? WHERE `idEmpleado`=?");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Modificó Empleado',null)");
            auditoria.executeUpdate();
             sql.setString(1, this.getNombreEmpleado());
                sql.setString(2, this.getApellidoEmpleado());
                sql.setString(3, this.getEdadEmpleado());
                sql.setString(4,  this.getSalarioEmpleado());
                sql.setString(5,  this.getCorreoEmpleado());
                sql.setInt(6, this.getIdEmpleado());
                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado Modificado");   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al modificar");
            System.out.println("      "+e.getMessage());
                    
        }
    }
    
    //ELIMINAR
    
    public void eliminar()
    {
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("DELETE FROM `empleado` WHERE `idEmpleado`=?");
            PreparedStatement auditoria = ConexionDB.conexion.prepareStatement("INSERT INTO `auditoria`( `descripcionAuditoria`, `fechaAuditoria`) VALUES ('Se Eliminó Empleado',null)");
            auditoria.executeUpdate();
            sql.setInt(1, this.getIdEmpleado());
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado Eliminado");  
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al eliminar ");
            
        }
    }
    
    
    //BUSCAR
    
    public Iterator<Empleado> buscar(String busqueda)
    {
    ArrayList<Empleado> losEmpleados = new ArrayList<>();
    
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM `empleado` WHERE `nombreEmpleado` LIKE? or apellidoEmpleado LIKE? OR edadEmpleado LIKE? OR salarioEmpleado LIKE? OR correoEmpleado LIKE?");
            sql.setString(1, "%"+busqueda+"%");
            sql.setString(2, "%"+busqueda+"%");
            sql.setString(3, "%"+busqueda+"%");
            sql.setString(4, "%"+busqueda+"%");
            sql.setString(5, "%"+busqueda+"%");
            
            ResultSet rs = sql.executeQuery();
            Empleado unEmpleado;
            
            while (rs.next()) {   
                unEmpleado = new Empleado();
                unEmpleado.setIdEmpleado(rs.getInt("idEmpleado"));
                unEmpleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                unEmpleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                unEmpleado.setEdadEmpleado(rs.getString("edadEmpleado"));
                unEmpleado.setSalarioEmpleado(rs.getString("salarioEmpleado"));
                unEmpleado.setCorreoEmpleado(rs.getString("correoEmpleado"));
                losEmpleados.add(unEmpleado); 
                
            }
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "ERROR al buscar");
        }
    return  losEmpleados.iterator();
    }
    
    //BUSCAR POR EL ID
    public Empleado buscarPorId(int elId)
    {
    Empleado unEmpleado = new Empleado();
    unEmpleado.setNombreEmpleado("el cliente no existe");
        try {
            PreparedStatement sql = ConexionDB.conexion.prepareStatement("SELECT * FROM empleado WHERE idEmpleado=?");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {                
                unEmpleado.setIdEmpleado(   rs.getInt("idEmpleado"));
                unEmpleado.setNombreEmpleado(   rs.getString("nombreEmpleado"));
                unEmpleado.setApellidoEmpleado( rs.getString("apellidoEmpleado"));
                unEmpleado.setEdadEmpleado( rs.getString("edadEmpleado"));
                unEmpleado.setSalarioEmpleado( rs.getString("salarioEmpleado"));
                unEmpleado.setCorreoEmpleado( rs.getString("correoEmpleado"));
                
            }
        } catch (SQLException e) {
            System.out.println("no se pudo buscar por el id   "+e.getMessage());
        }
    return unEmpleado;
    }
 //esta llave no se borra :V   
}
