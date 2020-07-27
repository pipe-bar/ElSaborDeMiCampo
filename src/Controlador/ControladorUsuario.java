
package Controlador;

import Modelo.Usuario;
import java.awt.event.ActionEvent;


public class ControladorUsuario {
    
      public void controlarAccion(ActionEvent evento, Usuario unUsuario)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
           unUsuario.insertar();
            break;
        case "Modificar":
           unUsuario.modificar();
            break;
        case "Eliminar":
          unUsuario.eliminar();
          
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
}
