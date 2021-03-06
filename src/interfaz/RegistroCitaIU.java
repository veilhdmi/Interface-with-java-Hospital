/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author User
 */
import modelo.*;
import control.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroCitaIU extends javax.swing.JFrame {
    private GestorServicio gestorServicio;
    private GestorPaciente gestorPaciente;
    private GestorCita gestorCita;
    private Cita cita;
    private int numeroCitas;

    private DefaultTableModel modeloTablaLineaCita;
        private DefaultComboBoxModel modeloComboBoxServicio;
    private DefaultComboBoxModel modeloComboBoxPaciente;

    /**
     * Creates new form RegistroVentaIU
     */
    public RegistroCitaIU() {
        initComponents();
    }

    public RegistroCitaIU(GestorCita gestorCita, 
            GestorPaciente gestorPaciente, GestorServicio gestorServicio) {
        initComponents();
        this.gestorPaciente = gestorPaciente;
        this.gestorServicio = gestorServicio;
        this.gestorCita = gestorCita;
        this.modeloTablaLineaCita = new DefaultTableModel();        
        this.modeloTablaLineaCita.addColumn("Orden de atención");
        this.modeloTablaLineaCita.addColumn("ID Cita");
        this.modeloTablaLineaCita.addColumn("Doctor");
        this.tablaLineaCita.setModel(modeloTablaLineaCita);
        this.modeloComboBoxServicio = new DefaultComboBoxModel();
        this.cboServicio.setModel(modeloComboBoxServicio);
        this.modeloComboBoxPaciente = new DefaultComboBoxModel();
        this.cboPacientes.setModel(modeloComboBoxPaciente);
        this.txtFecha.setText(String.valueOf(Calendar.getInstance().getTime()));
        this.cita = new Cita(gestorCita.longitud()+1,Calendar.getInstance().getTime(),null);
        this.actualizarComboBoxPaciente();
        this.actualizarComboBoxServicio();
        this.actualizarTablaLineaCita(cita);
        this.numeroCitas = 0;        
    }

    public void limpiarTabla() {
        for (int i = modeloTablaLineaCita.getRowCount() - 1; i >= 0; i--) {
            modeloTablaLineaCita.removeRow(i);
        }
    }

    public void actualizarTablaLineaCita(Cita cita) {
        limpiarTabla();
    
        LineaCita[] lista = cita.getLineasCita();
        for (int i = 0; i < cita.numCitas(); i++) {
            LineaCita linea = lista[i];
            String[] fila = new String[3];     
            int id = linea.getNumeroLinea()+1;
        
            fila[0] = String.valueOf(id);
            fila[1] = String.valueOf(linea.getCita().getNumero());
            fila[2] = linea.getServicio().getNombre();
           
            modeloTablaLineaCita.addRow(fila);
        }
       
    }
    public void actualizarComboBoxServicio() {
        for (int i = 0; i < gestorServicio.longitud(); i++) {
            this.modeloComboBoxServicio.addElement(gestorServicio.iesimo(i));
        }
    }

  
    public void actualizarComboBoxPaciente() {
        for (int i = 0; i < gestorPaciente.longitud(); i++) {
            this.modeloComboBoxPaciente.addElement(gestorPaciente.iesimo(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLineaCita = new javax.swing.JTable();
        txtFecha = new javax.swing.JFormattedTextField();
        btnGenerar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboPacientes = new javax.swing.JComboBox();
        btnCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboServicio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Fecha de creación:");

        jLabel3.setText("Paciente:");

        tablaLineaCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLineaCita);

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btnGenerar.setText("Aprobar Cita");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Generar Cita");

        cboPacientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCrear.setText("Crear Cita");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel4.setText("Docto Asignado:");

        cboServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear)
                        .addGap(97, 97, 97))))
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        cita.setCliente((Paciente)this.cboPacientes.getSelectedItem());
        this.gestorCita.agregar(cita);
        String mensaje = "ID de Cita: "+cita.getNumero()+"\n"+
                "Fecha de creación: "+cita.getFecha() + "\n"+
                "Paciente: "+cita.getCliente()+"\n";
        
        JOptionPane.showMessageDialog(rootPane, mensaje);
        dispose();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        int numeroLinea = this.numeroCitas++;
        Cita cita = this.cita;
        Servicio servicio = (Servicio)this.cboServicio.getSelectedItem();
    
        LineaCita linea = new LineaCita(numeroLinea,cita,servicio);
        cita.agregarLinea(linea);
        this.actualizarTablaLineaCita(cita);
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroCitaIU.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCitaIU.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCitaIU.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCitaIU.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCitaIU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox cboPacientes;
    private javax.swing.JComboBox<String> cboServicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLineaCita;
    private javax.swing.JFormattedTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
