/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Duvan
 */
public class ConexionDB {
    public static Connection conexion;
    private ConexionDB() {
     
          try {
        String driverDB = "com.mysql.jdbc.Driver";
         String urlDB= "jdbc:mysql://localhost:3306/test";
        String userDB="root";
        String claveDB="";
            Class.forName(driverDB);
            conexion=(Connection) DriverManager.getConnection(urlDB, userDB,claveDB);
            JOptionPane.showMessageDialog(null, "Bienvenido");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "no encuentro el mk driver");
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "NO puedo conectarme");
            
        
        }
    }
    
    public static void desconectar()
    {
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "Finalizado");
        } catch (SQLException ex) {
            System.err.println("ha ocurrido un error y no se ha desconectado"+ex.getMessage());
        }
    }
    
    public static ConexionDB getInstance() {
        return ConexionDBHolder.INSTANCE;
    }
    
    private static class ConexionDBHolder {

        private static final ConexionDB INSTANCE = new ConexionDB();
    }
}
