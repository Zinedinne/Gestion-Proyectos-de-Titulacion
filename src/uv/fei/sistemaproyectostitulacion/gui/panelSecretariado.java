/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.sistemaproyectostitulacion.gui;

import javax.swing.JOptionPane;
import uv.fei.sistemaproyectostitulacion.businesslogic.UsuarioDAO;
import uv.fei.sistemaproyectostitulacion.domain.Usuario;

/**
 *
 * @author Zinedinne
 */
public class panelSecretariado extends javax.swing.JPanel {

    /**
     * Creates new form panelSecretariado
     */
    public panelSecretariado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNumeroPersonal = new javax.swing.JLabel();
        labelCorreoInstitucional = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        tfNombre = new javax.swing.JTextField();
        tfNumeroPersonal = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        tfCorreoInstitucional = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(labelNumeroPersonal, "Número de Personal");

        org.openide.awt.Mnemonics.setLocalizedText(labelCorreoInstitucional, "Correo Institucional");

        org.openide.awt.Mnemonics.setLocalizedText(btnGuardar, "Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(labelNombre, "Nombre");

        org.openide.awt.Mnemonics.setLocalizedText(labelTelefono, "Teléfono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCorreoInstitucional)
                            .addComponent(labelTelefono)
                            .addComponent(labelNumeroPersonal)
                            .addComponent(labelNombre))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumeroPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnGuardar)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeroPersonal)
                    .addComponent(tfNumeroPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreoInstitucional)
                    .addComponent(tfCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnGuardar)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
     
        usuario.setRol("Secretariado");
        usuario.setNombre(tfNombre.getText());
        usuario.setTelefono(tfTelefono.getText());
        usuario.setCorreoinstitucional(tfCorreoInstitucional.getText());
     
        
        dao.insertarUsuario(usuario);
        JOptionPane.showMessageDialog(null, "Se guarda usuario");
    }//GEN-LAST:event_btnGuardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel labelCorreoInstitucional;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumeroPersonal;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField tfCorreoInstitucional;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNumeroPersonal;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
