

package Controlador;

import Modelo.Producto;
import java.awt.event.ActionEvent;


public class ControladorProducto {
     public void controlarAccion(ActionEvent evento , Producto unProducto)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
            unProducto.insertar();
            break;
        case "Modificar":
            unProducto.modificar();
            break;
        case "Eliminar":
           unProducto.eliminar();
            break;
    }
     
        System.out.println("accion == "+accion);
    }
}
