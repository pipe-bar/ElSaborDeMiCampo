/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.ControladorBodega;
import Modelo.Bodega;
import Modelo.ConexionDB;
import Modelo.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Duvan
 */
public class FRMBodega extends javax.swing.JInternalFrame {

   ControladorBodega bodegaController = new ControladorBodega();
    public FRMBodega() {
        initComponents();
        limpiarFormulario();
        llenarComboProducto();
        llenarTabla();
        TableColumn columna;
        columna= TBLBodega.getColumnModel().getColumn(3);
        columna.setPreferredWidth(90);
        columna.setMaxWidth(90);
        columna.setPreferredWidth(90);
        columna.setMinWidth(90);
        TBLBodega.setRowHeight(30);
    }

     
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BTNInsertar = new javax.swing.JButton();
        BTNModificar = new javax.swing.JButton();
        BTNEliminar = new javax.swing.JButton();
        BTNLimpiar = new javax.swing.JButton();
        BTNCerrar = new javax.swing.JButton();
        BTNReporteBodega = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CBOProducto = new javax.swing.JComboBox<Producto>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTCantidadBodega = new javax.swing.JFormattedTextField();
        TXTCodigoBodega = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXTBuscarBodega = new javax.swing.JTextField();
        BTNBuscarBodega = new javax.swing.JButton();
        TXTIdBodega = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLBodega = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Formulario Bodega");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones"));

        BTNInsertar.setBackground(new java.awt.Color(51, 255, 102));
        BTNInsertar.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        BTNInsertar.setText("Guardar");
        BTNInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNInsertarActionPerformed(evt);
            }
        });

        BTNModificar.setBackground(new java.awt.Color(0, 255, 255));
        BTNModificar.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNEliminar.setBackground(new java.awt.Color(255, 0, 0));
        BTNEliminar.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        BTNLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        BTNLimpiar.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        BTNLimpiar.setText("Limpiar");
        BTNLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNLimpiarActionPerformed(evt);
            }
        });

        BTNCerrar.setBackground(new java.awt.Color(102, 102, 102));
        BTNCerrar.setFont(new java.awt.Font("Cambria", 3, 12)); // NOI18N
        BTNCerrar.setText("Cerrar");
        BTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCerrarActionPerformed(evt);
            }
        });

        BTNReporteBodega.setBackground(new java.awt.Color(204, 0, 204));
        BTNReporteBodega.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        BTNReporteBodega.setText("Reporte");
        BTNReporteBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNReporteBodegaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BTNEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(BTNReporteBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNInsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(BTNLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNCerrar)
                    .addComponent(BTNReporteBodega))
                .addContainerGap())
        );

        jLabel1.setText("   Producto ");

        CBOProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Cantidad");

        jLabel3.setText("Codigo Bodega ");

        jLabel4.setText("Buscar");

        TXTBuscarBodega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXTBuscarBodegaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXTBuscarBodegaFocusLost(evt);
            }
        });

        BTNBuscarBodega.setText("Buscar");
        BTNBuscarBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarBodegaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(TXTBuscarBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNBuscarBodega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXTCantidadBodega, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CBOProducto, javax.swing.GroupLayout.Alignment.TRAILING, 0, 285, Short.MAX_VALUE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXTIdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TXTCodigoBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(TXTIdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXTCodigoBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBOProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTCantidadBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTBuscarBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBuscarBodega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        TBLBodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "  id", "    Código Bodega", "                                                Producto ", "        Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLBodegaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLBodega);
        if (TBLBodega.getColumnModel().getColumnCount() > 0) {
            TBLBodega.getColumnModel().getColumn(0).setMinWidth(90);
            TBLBodega.getColumnModel().getColumn(0).setPreferredWidth(90);
            TBLBodega.getColumnModel().getColumn(0).setMaxWidth(90);
            TBLBodega.getColumnModel().getColumn(1).setMinWidth(122);
            TBLBodega.getColumnModel().getColumn(1).setPreferredWidth(122);
            TBLBodega.getColumnModel().getColumn(1).setMaxWidth(122);
            TBLBodega.getColumnModel().getColumn(2).setPreferredWidth(99);
            TBLBodega.getColumnModel().getColumn(3).setMinWidth(133);
            TBLBodega.getColumnModel().getColumn(3).setPreferredWidth(133);
            TBLBodega.getColumnModel().getColumn(3).setMaxWidth(133);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNInsertarActionPerformed
       bodegaController.controlarAccion(evt, obtenerCompraBodega());
       limpiarFormulario();
    }//GEN-LAST:event_BTNInsertarActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
       bodegaController.controlarAccion(evt, obtenerCompraBodega());
       limpiarFormulario();
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        bodegaController.controlarAccion(evt, obtenerCompraBodega());
       limpiarFormulario();
    }//GEN-LAST:event_BTNEliminarActionPerformed

    private void BTNLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_BTNLimpiarActionPerformed

    private void BTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCerrarActionPerformed
       doDefaultCloseAction();
    }//GEN-LAST:event_BTNCerrarActionPerformed

    private void TXTBuscarBodegaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarBodegaFocusGained
        if (TXTBuscarBodega.getText().equals("Escriba texto a buscar")) {
           TXTBuscarBodega.setText("");
        
        }
    }//GEN-LAST:event_TXTBuscarBodegaFocusGained

    private void TXTBuscarBodegaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXTBuscarBodegaFocusLost
        if (TXTBuscarBodega.getText().isEmpty()) {
           TXTBuscarBodega.setText("Escriba texto a buscar");
        
        }
    }//GEN-LAST:event_TXTBuscarBodegaFocusLost

    private void TBLBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLBodegaMouseClicked
        if (evt.getClickCount()==1) {
            int fila = TBLBodega.rowAtPoint(evt.getPoint());
            if (fila>-1) {
                TXTIdBodega.setValue((Integer)  TBLBodega.getValueAt(fila, 0));
                TXTCodigoBodega.setText((String )TBLBodega.getValueAt(fila, 1));
                CBOProducto.setSelectedItem((Producto)TBLBodega.getValueAt(fila, 2));
                TXTCantidadBodega.setValue((Integer)TBLBodega.getValueAt(fila, 3));
                BTNEliminar.setEnabled(true);
                BTNModificar.setEnabled(true);
                 
                
            }
        }
    }//GEN-LAST:event_TBLBodegaMouseClicked

    private void BTNBuscarBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarBodegaActionPerformed
        llenarTablaCoBusqueda(TXTBuscarBodega.getText());
    }//GEN-LAST:event_BTNBuscarBodegaActionPerformed

    private void BTNReporteBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNReporteBodegaActionPerformed
        JasperReport jrReporte = null;
        try {
            jrReporte = (JasperReport)JRLoader.loadObject(getClass().getClassLoader().getResource("Reportes/ReportesBodega.jasper"));
            Map params = new HashMap();
            params.put("NombreProducto", "Lenteja");
            JasperPrint jpReporte = JasperFillManager.fillReport(jrReporte, params,ConexionDB.conexion);
            JasperViewer jReporteViewer = new JasperViewer(jpReporte,false);
            jReporteViewer.setVisible(true);
            
        } catch (JRException e) {
            System.out.println("Error en Jasper que no vas a poder solucionar "+e.getMessage());
        }
        
    }//GEN-LAST:event_BTNReporteBodegaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscarBodega;
    private javax.swing.JButton BTNCerrar;
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JButton BTNInsertar;
    private javax.swing.JButton BTNLimpiar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JButton BTNReporteBodega;
    private javax.swing.JComboBox<Producto> CBOProducto;
    private javax.swing.JTable TBLBodega;
    private javax.swing.JTextField TXTBuscarBodega;
    private javax.swing.JFormattedTextField TXTCantidadBodega;
    private javax.swing.JTextField TXTCodigoBodega;
    private javax.swing.JFormattedTextField TXTIdBodega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void llenarComboProducto()
    {
    Producto unProducto = new Producto();
    Iterator<Producto> itProducto = unProducto.listar();
    CBOProducto.removeAllItems();
    Producto seleccionar = new Producto();
    seleccionar.setNombreProducto("Seleccione Producto");
    CBOProducto.addItem(seleccionar);
        while (itProducto.hasNext()) {            
            CBOProducto.addItem(itProducto.next());
        }
    }
    
       //LIMPIAR FORMULARIO
    
     private void limpiarFormulario()
      {
      TXTIdBodega.setValue(0);
       TXTIdBodega.setVisible(false);
      CBOProducto.setSelectedItem(CBOProducto);
      TXTCodigoBodega.setText("");
      TXTCantidadBodega.setValue(0);
      BTNEliminar.setEnabled(false);
      BTNModificar.setEnabled(false);
      llenarTabla();
      }
      
      //LLENAR TABLA
    public void llenarTabla()
    {
     Bodega unaBodega = new Bodega();
     DefaultTableModel tabla = ( DefaultTableModel)TBLBodega.getModel();
     Iterator<Bodega> itBodega = unaBodega.listar();
     Object[] filaBodega = new Object[TBLBodega.getColumnCount()];
     tabla.setRowCount(0);
        while (itBodega.hasNext()) {   
            unaBodega = itBodega.next();
            
             filaBodega[0] = unaBodega.getIdBodega();
            filaBodega[1] = unaBodega.getCodigoBodega();
            filaBodega[2] = new Producto().buscarPorId(unaBodega.getIdProductoBodega());
            filaBodega[3] = unaBodega.getCantidadBodega();
            tabla.addRow(filaBodega);
        }
    }
    
    
    //LLENAR TABLA CON BUSQUEDA
    
    private void llenarTablaCoBusqueda(String busqueda)
    {
     Bodega unaBodega = new Bodega();
     DefaultTableModel tabla = ( DefaultTableModel)TBLBodega.getModel();
     Iterator<Bodega> itBodega = unaBodega.buscar(busqueda);
     Object[] filaBodega = new Object[TBLBodega.getColumnCount()];
     tabla.setRowCount(0);
        while (itBodega.hasNext()) {   
            unaBodega = itBodega.next();
             filaBodega[0] = unaBodega.getIdBodega();
            filaBodega[1] = unaBodega.getCodigoBodega();
            filaBodega[2] = new Producto().buscarPorId(unaBodega.getIdProductoBodega());
            filaBodega[3] = unaBodega.getCantidadBodega();
             ((DefaultTableModel)TBLBodega.getModel()).addRow(filaBodega);
        }
    }
     //OBTENER BODEGA
    private Bodega obtenerCompraBodega()
    {
    Bodega laBodega = new Bodega();
    laBodega.setIdBodega((Integer)TXTIdBodega.getValue());
    laBodega.setCodigoBodega(TXTCodigoBodega.getText());
    laBodega.setIdProductoBodega(((Producto)CBOProducto.getSelectedItem()).getIdProducto());
    laBodega.setCantidadBodega((Integer)TXTCantidadBodega.getValue());   
    return laBodega;
    
    }
  
}
