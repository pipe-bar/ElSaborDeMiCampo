
package Controlador;

import Modelo.Compra;
import java.awt.event.ActionEvent;


public class ControladorCompra {
      public void controlarAccion(ActionEvent evento, Compra unaCompra)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
          unaCompra.insertar();
            break;
        case "Modificar":
           unaCompra.modificar();
           
            break;
        case "Eliminar":
           unaCompra.eliminar();
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
    
}
