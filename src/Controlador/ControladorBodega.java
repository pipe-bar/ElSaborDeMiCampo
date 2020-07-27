
package Controlador;

import Modelo.Bodega;
import java.awt.event.ActionEvent;


public class ControladorBodega {
    public void controlarAccion(ActionEvent evento, Bodega unaBodega)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
        unaBodega.insertar();
            break;
        case "Modificar":
           unaBodega.modificar();
           
            break;
        case "Eliminar":
           unaBodega.eliminar();
            break;
    
    }
     
        System.out.println("hola "+accion);
    
    }
}
