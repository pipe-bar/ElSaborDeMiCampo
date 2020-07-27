

package Controlador;

import Modelo.Proveedor;
import java.awt.event.ActionEvent;


public class ControladorProveedor {
    public void controlarAccion(ActionEvent evento , Proveedor unProveedor)
    {
    String accion = evento.getActionCommand();
    switch(accion)
    {
        case "Guardar":
            unProveedor.insertar();
            break;
        case "Modificar":
            unProveedor.modificar();
            break;
        case "Eliminar":
            unProveedor.eliminar();
            break;
    }
     
        System.out.println("accion == "+accion);
    }
}
