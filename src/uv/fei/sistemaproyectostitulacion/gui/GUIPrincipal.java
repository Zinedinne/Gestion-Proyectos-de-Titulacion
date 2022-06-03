package uv.fei.sistemaproyectostitulacion.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uv.fei.sistemaproyectostitulacion.businesslogic.ProgramaEducativoDAOSara;
import uv.fei.sistemaproyectostitulacion.businesslogic.ProyectoDeTitulacionDAOSara;
import uv.fei.sistemaproyectostitulacion.domain.ProgramaEducativoSara;
import uv.fei.sistemaproyectostitulacion.domain.ProyectoDeTitulacionSara;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author cashd
 */
public class GUIPrincipal extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel = new DefaultTableModel(){
        @Override
        public boolean isCellEditable (int row, int column){
            return false;
        }
    };
    
    public GUIPrincipal() {
        initComponents();
        ProgramaEducativoSara pE = new ProgramaEducativoSara();
        pE.setNombre("Seleccionar");
        jComboBPE.addItem(pE);
        agregarProgramasEducativosAComboBox();
        jLabel7.setVisible(false);
        jTextFieldDirector.setVisible(false);
        String[] titulo =  new String[]{"Título", "Autor", "Modalidad", "Director", "Fecha"};
        defaultTableModel.setColumnIdentifiers(titulo);
        jTable1.setModel(defaultTableModel);
        jButton1.setEnabled(false);
    }

    private void agregarProgramasEducativosAComboBox(){
        ProgramaEducativoDAOSara pedao = new ProgramaEducativoDAOSara();
        ArrayList<ProgramaEducativoSara> pe = (ArrayList<ProgramaEducativoSara>)pedao.consultarProgramasEducativos();
        for (ProgramaEducativoSara pEE : pe){
            jComboBPE.addItem(pEE);
        }
    }
    private void eliminarProgramasEducativosDeComboBox(){
        int items = jComboBPE.getItemCount();
        jComboBPE.removeAllItems();
        ProgramaEducativoSara pE = new ProgramaEducativoSara();
        pE.setNombre("Todos");
        jComboBPE.addItem(pE);
    }
    private void eliminarGradosDeComboBox(){
        int items = jComboBoxGrado.getItemCount();
        jComboBoxGrado.removeAllItems();
        jComboBoxGrado.addItem("Todos");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxGrado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxModalidad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBPE = new javax.swing.JComboBox<>();
        jCheckBoxBuscar = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDirector = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consulta de proyectos de titulación");

        jLabel2.setText("Seleccione el grado, modalidad y programa educativo del proyecto de titulación que desee consultar");

        jLabel3.setText("Grado:");

        jComboBoxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Licenciatura", "Doctorado", "Maestría" }));
        jComboBoxGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGradoActionPerformed(evt);
            }
        });

        jLabel4.setText("Modalidad:");

        jComboBoxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tesis", "Tesina", "Monografía", "Trabajo Práctico-Técnico", "Trabajo Práctico-Educativo" }));

        jLabel5.setText("Programa Educativo:");

        jComboBPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBPEActionPerformed(evt);
            }
        });

        jCheckBoxBuscar.setText("Buscar por director de proyecto");
        jCheckBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBuscarActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre del Director:");

        jTextFieldDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDirectorActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("O");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Título", "Autor", "Modalidad", "Director", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(131, 131, 131)))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jCheckBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jButtonBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(261, 261, 261))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(jCheckBoxBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBuscarActionPerformed
        if (jCheckBoxBuscar.isSelected()){
            jLabel7.setVisible(true);
            jTextFieldDirector.setVisible(true);
        }
        else{
            jLabel7.setVisible(false);
            jTextFieldDirector.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxBuscarActionPerformed

    private void jTextFieldDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDirectorActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        jButton1.setEnabled(false);
        limpiarTabla();
        ProyectoDeTitulacionDAOSara pTDao = new ProyectoDeTitulacionDAOSara();
        ArrayList<ProyectoDeTitulacionSara> pTEncontrados = new ArrayList<>();
        pTEncontrados = pTDao.consultarProyectosDeTitulacion();
        if (pTEncontrados.size() >= 1) {
            if (jCheckBoxBuscar.isSelected()){
                     String director = jTextFieldDirector.getText();
                     buscarPorDirector(director);
             }
            else {
            String grado = "";
            String pE = "";
            String modalidad = "";
            if (jComboBPE.getSelectedIndex() < 1 && jComboBoxGrado.getSelectedIndex() < 1 && jComboBoxModalidad.getSelectedIndex() < 1){
                 limpiarTabla();
                 for (int i = 0; i < pTEncontrados.size(); i++){
                        defaultTableModel.addRow(new Object[]{
                            pTEncontrados.get(i).getTitulo(), 
                            pTEncontrados.get(i).getNombreAutor(),
                            pTEncontrados.get(i).getModalidad(),
                            pTEncontrados.get(i).getNombreDirector(),
                            pTEncontrados.get(i).getFechaDeTitulacion()
                        });
                    }  
             }
            else{ 
            if (jComboBPE.getSelectedIndex() > 0){
                pE = (jComboBPE.getItemAt(jComboBPE.getSelectedIndex())).getClave();
                if (jComboBoxModalidad.getSelectedIndex() > 0){
                    modalidad = jComboBoxModalidad.getItemAt(jComboBoxModalidad.getSelectedIndex());
                    buscarPorPEyModalidad(pE, modalidad, pTEncontrados);
                }
                else{
                    buscarPorPE(pE, pTEncontrados);
                }
            }
             else if (jComboBoxGrado.getSelectedIndex() > 0){
                grado = jComboBoxGrado.getItemAt(jComboBoxGrado.getSelectedIndex()); 
                if (jComboBoxModalidad.getSelectedIndex() > 0){
                    modalidad = jComboBoxModalidad.getItemAt(jComboBoxModalidad.getSelectedIndex());
                    buscarPorGradoyModalidad(grado, modalidad, pTEncontrados);
                }
                else{
                    buscarPorGrado(grado, pTEncontrados);
                }
             }
             else if (jComboBoxModalidad.getSelectedIndex() > 0){
                 modalidad = jComboBoxModalidad.getItemAt(jComboBoxModalidad.getSelectedIndex());
                 bucarPorModalidad(modalidad, pTEncontrados);
             }
        }
        }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void buscarPorPEyModalidad(String pE, String modalidad, ArrayList<ProyectoDeTitulacionSara>pTEncontrados){
        limpiarTabla();
        boolean bandera = false;
        for (int i = 0; i < pTEncontrados.size(); i++){
            if (pTEncontrados.get(i).getClaveCarrera().equals(pE) && pTEncontrados.get(i).getModalidad().equals(modalidad)){
                bandera = true;
                defaultTableModel.addRow(new Object[]{
                    pTEncontrados.get(i).getTitulo(), 
                    pTEncontrados.get(i).getNombreAutor(),
                    pTEncontrados.get(i).getModalidad(),
                    pTEncontrados.get(i).getNombreDirector(),
                    pTEncontrados.get(i).getFechaDeTitulacion()
                });
            }
        }
        if (bandera == false)
            JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan");
    }
    private void buscarPorPE(String pE, ArrayList<ProyectoDeTitulacionSara>pTEncontrados){
        limpiarTabla();
        boolean bandera = false;
        for (int i = 0; i < pTEncontrados.size(); i++){
            if (pTEncontrados.get(i).getClaveCarrera().equals(pE)){
                bandera = true;
                defaultTableModel.addRow(new Object[]{
                    pTEncontrados.get(i).getTitulo(), 
                    pTEncontrados.get(i).getNombreAutor(),
                    pTEncontrados.get(i).getModalidad(),
                    pTEncontrados.get(i).getNombreDirector(),
                    pTEncontrados.get(i).getFechaDeTitulacion()
                });
            }
        }
        if (bandera == false)
            JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan");
    }
    private void buscarPorGradoyModalidad(String grado, String modalidad, ArrayList<ProyectoDeTitulacionSara>pTEncontrados){
        limpiarTabla();
        boolean bandera = false;
        for (int i = 0; i < pTEncontrados.size(); i++){
            if (pTEncontrados.get(i).getModalidad().equals(modalidad) && pTEncontrados.get(i).getGrado().equals(grado)){
                bandera = true;
                defaultTableModel.addRow(new Object[]{
                    pTEncontrados.get(i).getTitulo(), 
                    pTEncontrados.get(i).getNombreAutor(),
                    pTEncontrados.get(i).getModalidad(),
                    pTEncontrados.get(i).getNombreDirector(),
                    pTEncontrados.get(i).getFechaDeTitulacion()
                });
            }
        }
        if (bandera == false)
            JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan");
    }
    private void buscarPorGrado(String grado, ArrayList<ProyectoDeTitulacionSara>pTEncontrados){
        limpiarTabla();
        boolean bandera = false;
            for (int i = 0; i < pTEncontrados.size(); i++){
            if (pTEncontrados.get(i).getGrado().equals(grado)){
                bandera = true;
                defaultTableModel.addRow(new Object[]{
                    pTEncontrados.get(i).getTitulo(), 
                    pTEncontrados.get(i).getNombreAutor(),
                    pTEncontrados.get(i).getModalidad(),
                    pTEncontrados.get(i).getNombreDirector(),
                    pTEncontrados.get(i).getFechaDeTitulacion()
                });
            }
            }
            if (bandera == false)
            JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan");
    }
    private void bucarPorModalidad(String modalidad, ArrayList<ProyectoDeTitulacionSara>pTEncontrados){
        limpiarTabla();
        boolean bandera = false;
            for (int i = 0; i < pTEncontrados.size(); i++){
            if (modalidad.equals((String)pTEncontrados.get(i).getModalidad())){
                bandera = true;
                defaultTableModel.addRow(new Object[]{
                    pTEncontrados.get(i).getTitulo(), 
                    pTEncontrados.get(i).getNombreAutor(),
                    pTEncontrados.get(i).getModalidad(),
                    pTEncontrados.get(i).getNombreDirector(),
                    pTEncontrados.get(i).getFechaDeTitulacion()
                });
            }
        }
        if (bandera == false)
            JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan");
    }
    private void buscarPorDirector(String director){
        limpiarTabla();
        ProyectoDeTitulacionDAOSara pTDao = new ProyectoDeTitulacionDAOSara();
        ArrayList<ProyectoDeTitulacionSara> pTEncontrados2 = new ArrayList<>();
        pTEncontrados2 = pTDao.consultarProyectosDeTitulacionPorDirector(director);
        if (pTEncontrados2.size() < 1)
                JOptionPane.showMessageDialog(null, "No se encontraron Proyectos de titulación que coincidan joaldkjsd");
        else {
            for (int i = 0; i < pTEncontrados2.size(); i++){   
                    defaultTableModel.addRow(new Object[]{
                        pTEncontrados2.get(i).getTitulo(), 
                        pTEncontrados2.get(i).getNombreAutor(),
                        pTEncontrados2.get(i).getModalidad(),
                        pTEncontrados2.get(i).getNombreDirector(),
                        pTEncontrados2.get(i).getFechaDeTitulacion()
                    });
            }    
        }
    }
    private void limpiarTabla(){
        int filas = defaultTableModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            defaultTableModel.removeRow(0);
        }
    }
    
    private void jComboBoxGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGradoActionPerformed
        if (jComboBoxGrado.getSelectedIndex() != 0){
            eliminarProgramasEducativosDeComboBox();
            ProgramaEducativoDAOSara pedao = new ProgramaEducativoDAOSara();
            ArrayList<ProgramaEducativoSara> pe = (ArrayList<ProgramaEducativoSara>)pedao.consultarProgramasEducativosPorGrado((String)jComboBoxGrado.getSelectedItem());
            for (ProgramaEducativoSara pEE : pe){
                jComboBPE.addItem(pEE);
            }
        }
        else{
            eliminarProgramasEducativosDeComboBox();
            agregarProgramasEducativosAComboBox();
        }
    }//GEN-LAST:event_jComboBoxGradoActionPerformed

    private void jComboBPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBPEActionPerformed

    }//GEN-LAST:event_jComboBPEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = (String)jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        GUIInformacionDetallada ventana = new GUIInformacionDetallada(nombre);
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.getSelectedRowCount()>0){
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GUIMenu menu = new GUIMenu();
            menu.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JCheckBox jCheckBoxBuscar;
    private javax.swing.JComboBox<ProgramaEducativoSara> jComboBPE;
    private javax.swing.JComboBox<String> jComboBoxGrado;
    private javax.swing.JComboBox<String> jComboBoxModalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldDirector;
    // End of variables declaration//GEN-END:variables
}