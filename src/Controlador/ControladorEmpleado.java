

package Controlador;

import Modelo.Empleado;
import java.awt.event.ActionEvent;


public class ControladorEmpleado {
     public void controlarAccion(ActionEvent evento, Empleado unEmpleado)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
           unEmpleado.insertar();
            break;
        case "Modificar":
           unEmpleado.modificar();
            break;
        case "Eliminar":
            unEmpleado.eliminar();
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
}
