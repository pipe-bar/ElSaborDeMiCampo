/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.ControladorEmpleado;
import Modelo.Empleado;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duvan
 */
public class FRMEmpleado extends javax.swing.JInternalFrame {

    ControladorEmpleado empleadoController = new ControladorEmpleado();
    public FRMEmpleado() {
        initComponents();
        TXTIdEmpleado.setValue(0);
        TXTIdEmpleado.setVisible(false);
        limpiarFormulario();
        llenarTabla();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TXTNombreEmpleado = new javax.swing.JTextField();
        TXTApellidoEmpleado = new javax.swing.JTextField();
        TXTBuscarEmpleado = new javax.swing.JTextField();
        TXTIdEmpleado = new javax.swing.JFormattedTextField();
        TXTCorreoEmpleado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BTNGuardar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNLimpiar = new javax.swing.JButton();
        BTNCerrar = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();
        TXTEdadEmpleado = new javax.swing.JTextField();
        TXTSalarioEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLEmpleado = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Empleado");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Edad");

        jLabel4.setText("Salario");

        jLabel5.setText("Correo");

        TXTBuscarEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTBuscarEmpleadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTBuscarEmpleadoFocusLost(evt);
            }
        });

        jLabel6.setText("Buscar");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Acciones"));

        BTNGuardar.setBackground(new java.awt.Color(51, 255, 51));
        BTNGuardar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNGuardar.setText("Guardar");
        BTNGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGuardarActionPerformed(evt);
            }
        });

        BTNModificar.setBackground(new java.awt.Color(51, 255, 255));
        BTNModificar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNEliminar.setBackground(new java.awt.Color(255, 51, 51));
        BTNEliminar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        BTNLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        BTNLimpiar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNLimpiar.setText("Limpiar");
        BTNLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNLimpiarActionPerformed(evt);
            }
        });

        BTNCerrar.setBackground(new java.awt.Color(102, 102, 102));
        BTNCerrar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNCerrar.setText("Cerrar");
        BTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTNEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNLimpiar)
                .addGap(18, 18, 18))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(BTNCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        BTNBuscar.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("    Llene  los campos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)))
                        .addGap(4, 4, 4)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(TXTBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TXTEdadEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(TXTApellidoEmpleado, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(26, 26, 26)
                        .addComponent(TXTIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TXTSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTCorreoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXTIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TXTEdadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTCorreoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TBLEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "  ID", "            Nombre", "           Apellido", "     Edad", "         Salario", "        Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLEmpleado);
        if (TBLEmpleado.getColumnModel().getColumnCount() > 0) {
            TBLEmpleado.getColumnModel().getColumn(0).setPreferredWidth(20);
            TBLEmpleado.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
    doDefaultCloseAction();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void BTNGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGuardarActionPerformed
       empleadoController.controlarAccion(evt, obtenerEmpleado());
       limpiarFormulario();
      
    }//GEN-LAST:event_BTNGuardarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
      empleadoController.controlarAccion(evt, obtenerEmpleado());
       limpiarFormulario();
       
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
       empleadoController.controlarAccion(evt, obtenerEmpleado());
       limpiarFormulario();
       
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNLimpiarActionPerformed
       limpiarFormulario();
    }//GEN-LAST:event_BTNLimpiarActionPerformed

    private void TBLEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLEmpleadoMouseClicked
        if (evt.getClickCount()==1) {
            int fila = TBLEmpleado.rowAtPoint(evt.getPoint());
            if (fila>-1) {
                 
                TXTIdEmpleado.setValue((Integer)  TBLEmpleado.getValueAt(fila, 0));
                TXTNombreEmpleado.setText((String)  TBLEmpleado.getValueAt(fila, 1));
                TXTApellidoEmpleado.setText((String) TBLEmpleado.getValueAt(fila, 2));
                TXTEdadEmpleado.setText((String)TBLEmpleado.getValueAt(fila, 3));
                TXTSalarioEmpleado.setText((String)  TBLEmpleado.getValueAt(fila, 4));
                TXTCorreoEmpleado.setText((String)  TBLEmpleado.getValueAt(fila, 5));
                BTNEliminar.setEnabled(true);
                BTNModificar.setEnabled(true);

            }

        }
    }//GEN-LAST:event_TBLEmpleadoMouseClicked

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        llenarTablaConBusqueda(TXTBuscarEmpleado.getText());
    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void TXTBuscarEmpleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarEmpleadoFocusGained
        if (TXTBuscarEmpleado.getText().equals("Escriba texto a buscar")) {
            TXTBuscarEmpleado.setText("");
            
        }
    }//GEN-LAST:event_TXTBuscarEmpleadoFocusGained

    private void TXTBuscarEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarEmpleadoFocusLost
        if (TXTBuscarEmpleado.getText().isEmpty()) {
            TXTBuscarEmpleado.setText("Escriba texto a buscar");
        }
    }//GEN-LAST:event_TXTBuscarEmpleadoFocusLost
      //LIMPIAR EL FORMULARIO
     private void limpiarFormulario()
    {
    TXTIdEmpleado.setValue(0);
    TXTNombreEmpleado.setText("");
    TXTApellidoEmpleado.setText("");
    TXTEdadEmpleado.setText("");
    TXTSalarioEmpleado.setText("");
    TXTCorreoEmpleado.setText("");
    TXTBuscarEmpleado.setText("Escriba texto a buscar");
    
    BTNModificar.setEnabled(false);
    BTNEliminar.setEnabled(false);
    llenarTabla();
    }
    
       //LLENAR TABLA
      public void llenarTabla()
    {
    Empleado unEmpleado = new Empleado();
     DefaultTableModel tabla = (DefaultTableModel)TBLEmpleado.getModel();
     Iterator<Empleado> itEmpleado = unEmpleado.listar();
     Object[] filaEmpleado = new Object[TBLEmpleado.getColumnCount()];
     tabla.setRowCount(0);//limpiar la tabla
     while (itEmpleado.hasNext()) {   
             unEmpleado = itEmpleado.next();
            filaEmpleado[0] = unEmpleado.getIdEmpleado();
            filaEmpleado[1] = unEmpleado.getNombreEmpleado();
            filaEmpleado[2] = unEmpleado.getApellidoEmpleado();
            filaEmpleado[3] = unEmpleado.getEdadEmpleado();
            filaEmpleado[4] = unEmpleado.getSalarioEmpleado();
            filaEmpleado[5] = unEmpleado.getCorreoEmpleado();
            tabla.addRow(filaEmpleado);
     }
    }
     //LLENAR TABLA CON BUSQUEDA
        private void llenarTablaConBusqueda(String busqueda)
    {
     Empleado unEmpleado = new Empleado();
     DefaultTableModel tabla = (DefaultTableModel)TBLEmpleado.getModel();
     Iterator<Empleado> itEmpleado = unEmpleado.buscar(busqueda);
     Object[] filaEmpleado = new Object[TBLEmpleado.getColumnCount()];
     tabla.setRowCount(0);//limpiar la tabla
        while (itEmpleado.hasNext()) {   
             unEmpleado = itEmpleado.next();
            filaEmpleado[0] = unEmpleado.getIdEmpleado();
            filaEmpleado[1] = unEmpleado.getNombreEmpleado();
            filaEmpleado[2] = unEmpleado.getApellidoEmpleado();
            filaEmpleado[3] = unEmpleado.getEdadEmpleado();
            filaEmpleado[4] = unEmpleado.getSalarioEmpleado();
            filaEmpleado[5] = unEmpleado.getCorreoEmpleado();
            ((DefaultTableModel)TBLEmpleado.getModel()).addRow(filaEmpleado);
     }
    }
        
        //OBTENER EL EMPLEADO 
         private Empleado obtenerEmpleado()
    {
    String nom = TXTNombreEmpleado.getText();
    String id= TXTEdadEmpleado.getText();
    
    Empleado elEmpleado= new Empleado();
    elEmpleado.setIdEmpleado((Integer)TXTIdEmpleado.getValue());
    elEmpleado.setNombreEmpleado(TXTNombreEmpleado.getText());
    elEmpleado.setApellidoEmpleado(TXTApellidoEmpleado.getText());
    elEmpleado.setEdadEmpleado(TXTEdadEmpleado.getText());
   elEmpleado.setSalarioEmpleado(TXTSalarioEmpleado.getText());
    elEmpleado.setCorreoEmpleado(TXTCorreoEmpleado.getText());
    
    System.out.println("nombre   "+nom);
    
    return elEmpleado;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNGuardar;
    private javax.swing.JButton BTNLimpiar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JTable TBLEmpleado;
    private javax.swing.JTextField TXTApellidoEmpleado;
    private javax.swing.JTextField TXTBuscarEmpleado;
    private javax.swing.JTextField TXTCorreoEmpleado;
    private javax.swing.JTextField TXTEdadEmpleado;
    private javax.swing.JFormattedTextField TXTIdEmpleado;
    private javax.swing.JTextField TXTNombreEmpleado;
    private javax.swing.JTextField TXTSalarioEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
