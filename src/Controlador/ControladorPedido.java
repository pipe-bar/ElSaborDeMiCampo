

package Controlador;

import Modelo.Pedido;
import java.awt.event.ActionEvent;


public class ControladorPedido {
     public void controlarAccion(ActionEvent evento, Pedido unPedido)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
          unPedido.insertar();
            break;
        case "Modificar":
           unPedido.modificar();
           
            break;
        case "Eliminar":
          unPedido.eliminar();
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
    
}
