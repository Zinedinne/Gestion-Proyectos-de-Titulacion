/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.gui;

import Validaciones.ValidacionDeDatosRegistro;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import uv.fei.sistemaproyectostitulacion.businesslogic.EstudianteDAO;
import uv.fei.sistemaproyectostitulacion.businesslogic.PDFDAO;
import uv.fei.sistemaproyectostitulacion.businesslogic.ProfesorDAO;
import uv.fei.sistemaproyectostitulacion.businesslogic.ProgramaEducativoDAO;
import uv.fei.sistemaproyectostitulacion.businesslogic.ProyectoDeTitulacionDAO;
import uv.fei.sistemaproyectostitulacion.domain.Estudiante;
import uv.fei.sistemaproyectostitulacion.domain.PDF;
import uv.fei.sistemaproyectostitulacion.domain.ProgramaEducativo;
import uv.fei.sistemaproyectostitulacion.domain.ProyectoDeTitulacion;

/**
 *
 * @author oscar
 */
public class GUIRegistrarProyectoTitulacion extends javax.swing.JFrame {

    /**
     * Creates new form GUIRegistrarProyectoTitulacion
     */
    String ruta_archivo = "";
    ProgramaEducativoDAO programaDAO = new ProgramaEducativoDAO();
    ProyectoDeTitulacionDAO proyectoDAO = new ProyectoDeTitulacionDAO();
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();
    String tipoPrograma;
    
    private boolean sonCamposValidos(){
        boolean estatusCampus = false;
        int numeroDeCamposInvalidos = 0;
        ValidacionDeDatosRegistro validar = new ValidacionDeDatosRegistro();
        if (jTextField1.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty() || jTextField7.getText().isEmpty() || jDateChooser1.getDate().toString().isEmpty()|| jComboBox2.getSelectedItem().toString().isEmpty() || jTextArea1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se puede dejar campos en blanco. Campos obligatorios");
        }
        else {
            if(validar.validarLongitudDeCadena(jTextField1.getText()) == false || validar.validarMayusculasMinusculasAcentos(jTextField1.getText()) == false){
                jTextField1.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            }    
            if(validar.validarLongitudMatricula(jTextField3.getText()) == false){        
                jTextField3.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            }
            if(validar.validarLongitudDeCadena(jTextField4.getText()) == false || validar.validarMayusculasMinusculasAcentos(jTextField4.getText()) == false){
                jTextField4.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            }    
            if(validar.validarLongitudDeCadena(jTextField5.getText()) == false || validar.validarMayusculasMinusculasAcentos(jTextField5.getText()) == false){
                jTextField5.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            } 
            if(validar.validarLongitudDeCadena(jTextField6.getText()) == false || validar.validarMayusculasMinusculasAcentos(jTextField6.getText()) == false){
                jTextField6.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            } 
            if(validar.validarLongitudDeCadena(jTextField7.getText()) == false || validar.validarMayusculasMinusculasAcentos(jTextField7.getText()) == false){
                jTextField7.setBackground(new Color(255, 69, 43));
                numeroDeCamposInvalidos++;
            } 
            if (numeroDeCamposInvalidos == 0){
                estatusCampus = true;
            }
        }
        return estatusCampus;
    }
    public void limpiarCampos(){
        jTextField1.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextArea1.setText(null);
        jDateChooser1.setCalendar(null);
    }

    
    public void registrarProyecto(){
        ProyectoDeTitulacion proyectoRegistrar = new ProyectoDeTitulacion();
        boolean registro;  
        String titulo = jTextField1.getText();
        String tipoProyecto = jComboBox1.getSelectedItem().toString();
        String dia = null;
        String mes = null;
        int auxiliarMes =jDateChooser1.getCalendar().get(Calendar.MONTH )+1;
        if (auxiliarMes <= 9){
            mes = String.valueOf(auxiliarMes);
            mes = "0" + mes + "-";
        }
        else{
            mes = String.valueOf(auxiliarMes) + "-";
        }
        int auxiliarDia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        if (auxiliarDia <= 9){
            dia = String.valueOf(auxiliarDia);
            dia = "0" + dia;
        }
        else{
            dia = String.valueOf(auxiliarDia);
        }
        String anio = String.valueOf(jDateChooser1.getCalendar().get(Calendar.YEAR)) + "-";
        String fechaTitulacion = anio.concat(mes.concat(dia));
        String resultado = "Aprobado";
        String clave = programaDAO.obtenerClaveCarrera(jComboBox2.getSelectedItem().toString());
        String descripción = jTextArea1.getText();
        proyectoRegistrar.setTitulo(titulo);
        proyectoRegistrar.setModalidad(tipoProyecto);
        proyectoRegistrar.setFechaTitulacion(fechaTitulacion);
        proyectoRegistrar.setResultado(resultado);
        proyectoRegistrar.setClaveCarrera(clave);
        proyectoRegistrar.setDescripcion(descripción);
        registro = proyectoDAO.registrarProyectoTitulacion(proyectoRegistrar);
        if (registro == true){
            JOptionPane.showMessageDialog(null, "Proyecto registrado correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void registrarProyectoYEstudiante(){
        boolean registro;  
        Estudiante estudianteRegistrado = new Estudiante();
        estudianteRegistrado.setMatricula(jTextField3.getText());
        estudianteRegistrado.setClave(programaDAO.obtenerClaveCarrera(jComboBox2.getSelectedItem().toString()));
        estudianteRegistrado.setNombre(jTextField4.getText());
        estudianteRegistrado.setIdProyecto(proyectoDAO.obtenerIdProyecto(jTextField1.getText()));
        registro = estudianteDAO.registrarEstudianteNuevoConProyecto(estudianteRegistrado);
        if (registro == true){
           JOptionPane.showMessageDialog(null, "Alumno agregado al proyecto correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void añadirDirectorAlProyecto(){
        boolean registro;
        String rol = "Director";
        int numeroPersonal = profesorDAO.obtenerNumeroPersonalPorNombre(jTextField5.getText());
        int idProyecto = proyectoDAO.obtenerIdProyecto(jTextField1.getText());
        registro = proyectoDAO.registrarProfesoresParticipantes(rol, numeroPersonal, idProyecto);
        if (registro == true){
            JOptionPane.showMessageDialog(null, "Director agregado al proyecto correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void añadirPrimerSinodalAlProyecto(){
        boolean registro;
        String rol = "Sinodal";
        int numeroPersonal = profesorDAO.obtenerNumeroPersonalPorNombre(jTextField6.getText());
        int idProyecto = proyectoDAO.obtenerIdProyecto(jTextField1.getText());
        registro = proyectoDAO.registrarProfesoresParticipantes(rol, numeroPersonal, idProyecto);
        if (registro == true){
            JOptionPane.showMessageDialog(null, "Primer sinodal agregado al proyecto correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void añadirSegundoSinodalAlProyecto(){
        boolean registro;
        String rol = "Sinodal";
        int numeroPersonal = profesorDAO.obtenerNumeroPersonalPorNombre(jTextField6.getText());
        int idProyecto = proyectoDAO.obtenerIdProyecto(jTextField1.getText());
        registro = proyectoDAO.registrarProfesoresParticipantes(rol, numeroPersonal, idProyecto);
        if (registro == true){
            JOptionPane.showMessageDialog(null, "Segundo sinodal agregado al proyecto correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardar_pdf(int idProyecto, String nombre, File ruta) {
        PDFDAO pdfDAO = new PDFDAO();
        PDF pdfRegistrado = new PDF();
        pdfRegistrado.setIdProyecto(idProyecto);
        pdfRegistrado.setNombreMatricula(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            pdfRegistrado.setArchivo(pdf);
        } catch (IOException ex) {
            pdfRegistrado.setArchivo(null);
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        pdfDAO.agregarPDF(pdfRegistrado);
    }

    public GUIRegistrarProyectoTitulacion() {
        initComponents();
        jTextField5.setEnabled(false); 
        jTextField6.setEnabled(false); 
        jTextField7.setEnabled(false); 
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre del proyecto");

        jLabel2.setText("Tipo de proyecto");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tesis", "Tesina", "Monografía", "Trabajo de investigación", " " }));

        jLabel3.setText("Matrícula");

        jLabel4.setText("Autor del trabajo");

        jLabel5.setText("Director");

        jLabel6.setText("¿Es externo a la facultad?");

        jRadioButton1.setText("Si");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("No");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Primer Sinodal");

        jLabel8.setText("¿Es externo a la facultad?");

        jRadioButton3.setText("Si");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("No");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha de titulación");

        jLabel10.setText("Grado");

        jLabel11.setText("Programa educativo");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licenciatura", "Especialidad", "Maestría", "Doctorado" }));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Registrar proyecto de titulación");

        jLabel13.setText("Descripción");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel14.setText("Adjuntar archivo");

        jButton1.setText("Archivo PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Segundo Sinodal");

        jLabel16.setText("¿Es externo a la facultad?");

        jRadioButton5.setText("Si");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("No");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton4.setText("Obtener Programas Educativos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 505, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(35, 35, 35)
                                .addComponent(jButton1))
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton4))
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                            .addComponent(jTextField6)
                                            .addComponent(jTextField7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(64, 64, 64)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTextField5.setEnabled(true); 
        jRadioButton2.setSelected(false);  
        jTextField5.setText(null);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jTextField6.setEnabled(true); 
        jRadioButton4.setSelected(false); 
        jTextField6.setText(null);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jTextField7.setEnabled(true);  
        jRadioButton6.setSelected(false);
        jTextField7.setText(null);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jTextField5.setEnabled(false); 
        jRadioButton1.setSelected(false);
        SeleccionarDirector ventanaDirector = new SeleccionarDirector();
        ventanaDirector.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jTextField6.setEnabled(false); 
        jRadioButton3.setSelected(false);
        SeleccionarPrimerSinodal ventanaPrimerSinodal = new SeleccionarPrimerSinodal();
        ventanaPrimerSinodal.setVisible(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jTextField7.setEnabled(false); 
        jRadioButton5.setSelected(false);
        SeleccionarSegundoSinodal ventanaSegundoSinodal = new SeleccionarSegundoSinodal();
        ventanaSegundoSinodal.setVisible(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser buscarPdf = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        buscarPdf.setFileFilter(fi);
        int se = buscarPdf.showOpenDialog(this);
        if (se == 0) {
            this.jButton1.setText("" + buscarPdf.getSelectedFile().getName());
            ruta_archivo = buscarPdf.getSelectedFile().getAbsolutePath();

        } else {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jComboBox2.removeAllItems();
       tipoPrograma = jComboBox3.getSelectedItem().toString();
       ArrayList<ProgramaEducativo> programasObtenidos = (ArrayList<ProgramaEducativo>) programaDAO.obtenerProgramasEducativosPorTipo(tipoPrograma);
       for(ProgramaEducativo programaObtenido : programasObtenidos){
            jComboBox2.addItem(programaObtenido.getNombre());
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
        if (sonCamposValidos() == true){  
            String nombreProyecto = jTextField1.getText();
            boolean idSesionRegistroPrevio;
            idSesionRegistroPrevio = proyectoDAO.buscarProyectoPorNombre(nombreProyecto);
            if(idSesionRegistroPrevio == true){
                registrarProyecto();
                añadirDirectorAlProyecto();
                añadirPrimerSinodalAlProyecto();
                añadirSegundoSinodalAlProyecto();
                String nombre = jTextField3.getText();
                registrarProyectoYEstudiante();
                int idProyecto = proyectoDAO.obtenerIdProyecto(jTextField1.getText());
                File ruta = new File(ruta_archivo);
                guardar_pdf(idProyecto, nombre, ruta);
                limpiarCampos(); 
            
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe este registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                limpiarCampos(); 
            } 
        }  
        else {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos. Favor de verificarlos");
            limpiarCampos(); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GUIMenu menu = new GUIMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIRegistrarProyectoTitulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarProyectoTitulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarProyectoTitulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarProyectoTitulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIRegistrarProyectoTitulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    static javax.swing.JTextField jTextField5;
    static javax.swing.JTextField jTextField6;
    static javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
