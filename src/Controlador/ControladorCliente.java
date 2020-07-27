
package Controlador;

import Modelo.Cliente;
import java.awt.event.ActionEvent;

public class ControladorCliente {
    public void controlarAccion(ActionEvent evento, Cliente unCliente)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
            unCliente.insertar();
            break;
        case "Modificar":
            unCliente.modificar();
            break;
        case "Eliminar":
            unCliente.eliminar();
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
    
   
}
