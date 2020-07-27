

package Controlador;

import Modelo.Tipo;
import java.awt.event.ActionEvent;

public class ControladorTipo {
     public void controlarAccion(ActionEvent evento , Tipo unTipo)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
            unTipo.insertar();
            break;
        case "Modificar":
            unTipo.modificar();
            break;
        case "Eliminar":
            unTipo.eliminar();
            break;
    }
     
        System.out.println("accion == "+accion);
    }
}
