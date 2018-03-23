package humanware_betancourtandres_manotasalejandro;

import AppPackage.AnimationClass;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KISIS VEGA
 */
public class Empresa extends javax.swing.JFrame {
    
    class Nodo {
        
        String titulacion;
        String habilidad;
        int nivel;
        Nodo link;
    }
    
    Nodo ptr, ptr2;
    
    File archivo = new File("./Empresa.txt");
    File file = new File("./Ofertas.txt");
    File solicitante = new File("./Solicitantes.txt");
    
    public Empresa() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        agregarEmpresaFrame.setLocationRelativeTo(null);
        ofertaEmpresaTrabajo.setLocationRelativeTo(null);
        ingresarOferta.setLocationRelativeTo(null);
        IdoneosFrame.setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        agregarEmpresaFrame.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        ofertaEmpresaTrabajo.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        ingresarOferta.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        IdoneosFrame.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        
        DefaultListModel model = new DefaultListModel();
        DefaultListModel modelo = new DefaultListModel();
        titulacionesRequerida.setModel(model);
        listaRequerimientos.setModel(modelo);
        ptr = null;
        ptr2 = null;
        
        noPasteEmpresaNombreField();
        
        noPasteEmpresaTelefonoField();
        
        noPasteNombrePuestoField();
        
        noPasteDescripcionPuestoField();
        
        noPasteSalarioInicialField();
        
        noPasteSalarioFinalField();
        
        noPasteTitulacionRequeridaField();
        
        noPasteHabilidadRequeridaField();
        
        noPasteNivelRequeridoField();
        
    }
    
    public void noPasteEmpresaNombreField() {
        //Para que no copie y pegue caracteres invalidos en el campo del nombre de la empresa
        InputMap map2 = empresaField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteEmpresaTelefonoField() {
        //Para que no copie y pegue caracteres invalidos en el campo del telefono de la empresa
        InputMap map2 = telefonoEmpresaField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteNombrePuestoField() {
        //Para que no copie y pegue caracteres invalidos en el campo del nombre del puesto
        InputMap map2 = nombrePuestoField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteDescripcionPuestoField() {
        //Para que no copie y pegue caracteres invalidos en el campo de descripción del puesto
        InputMap map2 = descripcionPuestoField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteSalarioInicialField() {
        //Para que no copie y pegue caracteres invalidos en el campo de salario inicial
        InputMap map2 = salarioInicialField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteSalarioFinalField() {
        //Para que no copie y pegue caracteres invalidos en el campo de salario final
        InputMap map2 = salarioFinalField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteTitulacionRequeridaField() {
        //Para que no copie y pegue caracteres invalidos en el campo de titulación requerida 
        InputMap map2 = titulacionRequeridaField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteHabilidadRequeridaField() {
        //Para que no copie y pegue caracteres invalidos en el campo de habilidad
        InputMap map2 = habilidadRequeridaField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public void noPasteNivelRequeridoField() {
        //Para que no copie y pegue caracteres invalidos en el campo del nivel requerido
        InputMap map2 = nivelRequeridoField.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    public Nodo AgregarTit(Nodo ptr, String tit) {
        //Agrega titulaciones a la lista
        Nodo a = new Nodo();
        a.titulacion = tit;
        if (ptr == null) {
            ptr = a;
        } else {
            Nodo q = ptr;
            while (q.link != null) {
                q = q.link;
            }
            q.link = a;
        }
        return ptr;
    }
    
    public void mostrarListaTit(Nodo ptr) {
        //Muestra en la lista las titulaciónes a añadir a la tabla
        DefaultListModel model = (DefaultListModel) titulacionesRequerida.getModel();
        model.clear();
        Nodo a = ptr;
        while (a != null) {
            model.addElement(a.titulacion);
            a = a.link;
        }
    }
    
    public void mostrarListaHabilidad(Nodo ptr2) {
//Muestra la habilidad y su respectiva puntuación en la lista        

        DefaultListModel modelo = (DefaultListModel) listaRequerimientos.getModel();
        modelo.clear();
        Nodo ha = ptr2;
        while (ha != null) {
            modelo.addElement(ha.habilidad + "," + ha.nivel);
            ha = ha.link;
        }
    }
    
    public Nodo agregarHabilidad(Nodo ptr2, String habilidad, int nivel) {
        //Añade una habilidad con su respectiva puntuación a la lista
        Nodo ha = new Nodo();
        
        ha.habilidad = habilidad;
        ha.nivel = nivel;
        
        if (ptr2 == null) {
            ptr2 = ha;
        } else {
            Nodo q = ptr2;
            while (q.link != null) {
                System.out.println(q.nivel);
                System.out.println(q.habilidad);
                q = q.link;
            }
            q.link = ha;
        }
        return ptr2;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarEmpresaFrame = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        empresaField = new javax.swing.JTextField();
        telefonoEmpresaField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        agregarEmpresa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cambioUsuario = new javax.swing.JLabel();
        cerrarPrograma = new javax.swing.JLabel();
        retrocederEmpresas = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        FileChooser = new javax.swing.JFileChooser();
        ofertaEmpresaTrabajo = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ofertasTable = new javax.swing.JTable();
        crearOfertaBtn = new javax.swing.JButton();
        eliminarOfertaBtn = new javax.swing.JButton();
        guardarOfertaBtn = new javax.swing.JButton();
        seleccionarOfertaBtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        ubicacionOfertaArchivo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        empresaOfertaField = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        cambiarSolicitantes = new javax.swing.JLabel();
        cerrarSistema = new javax.swing.JLabel();
        devolverEmpresas = new javax.swing.JLabel();
        ingresarOferta = new javax.swing.JFrame();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombrePuestoField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        salarioInicialField = new javax.swing.JTextField();
        salarioFinalField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jornadaComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        titulacionRequeridaField = new javax.swing.JTextField();
        añadirListaTitulacionesBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        titulacionesRequerida = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        habilidadRequeridaField = new javax.swing.JTextField();
        nivelRequeridoField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaRequerimientos = new javax.swing.JList<>();
        añadirOfertaBtn = new javax.swing.JButton();
        añadirHabilidad = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        descripcionPuestoField = new javax.swing.JTextArea();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        retrocederOfertas = new javax.swing.JLabel();
        usuarioCambio = new javax.swing.JLabel();
        CerrarFrames = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        IdoneosFrame = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        retrocederListaOfertas = new javax.swing.JLabel();
        irLogin = new javax.swing.JLabel();
        cerrarSystem = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        candidatoITable = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        agregrarEmpresaBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        empresaTabla = new javax.swing.JTable();
        nombreArchivoField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        seleccionarEmpresaBtn = new javax.swing.JButton();
        guardarEmpresaBtn = new javax.swing.JButton();
        eliminarEmpresaBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        retroceder = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        agregarEmpresaFrame.setMinimumSize(new java.awt.Dimension(627, 394));
        agregarEmpresaFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre de la empresa:");
        agregarEmpresaFrame.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 160, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Telefono de la empresa:");
        agregarEmpresaFrame.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 180, -1));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        agregarEmpresaFrame.getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 230, 30));

        empresaField.setBackground(new java.awt.Color(255, 255, 255));
        empresaField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        empresaField.setForeground(new java.awt.Color(0, 0, 0));
        empresaField.setText("Ingrese el nombre de la empresa");
        empresaField.setBorder(null);
        empresaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empresaFieldMouseClicked(evt);
            }
        });
        empresaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empresaFieldKeyTyped(evt);
            }
        });
        agregarEmpresaFrame.getContentPane().add(empresaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 220, 30));

        telefonoEmpresaField.setBackground(new java.awt.Color(255, 255, 255));
        telefonoEmpresaField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        telefonoEmpresaField.setForeground(new java.awt.Color(0, 0, 0));
        telefonoEmpresaField.setText("Ingrese el telefono de la empresa");
        telefonoEmpresaField.setBorder(null);
        telefonoEmpresaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoEmpresaFieldMouseClicked(evt);
            }
        });
        telefonoEmpresaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoEmpresaFieldKeyTyped(evt);
            }
        });
        agregarEmpresaFrame.getContentPane().add(telefonoEmpresaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 220, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        agregarEmpresa.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        agregarEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        agregarEmpresa.setText("Agregar");
        agregarEmpresa.setBorder(null);
        agregarEmpresa.setContentAreaFilled(false);
        agregarEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEmpresaActionPerformed(evt);
            }
        });
        jPanel2.add(agregarEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 110, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inscripción de la empresa");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, 20));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Idea_96px.png"))); // NOI18N
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cambioUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        cambioUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambioUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambioUsuarioMouseClicked(evt);
            }
        });
        jPanel2.add(cambioUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, -1, -1));

        cerrarPrograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarPrograma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarPrograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarProgramaMouseClicked(evt);
            }
        });
        jPanel2.add(cerrarPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, -1, -1));

        retrocederEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retrocederEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrocederEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederEmpresasMouseClicked(evt);
            }
        });
        jPanel2.add(retrocederEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 40, 30, 30));

        agregarEmpresaFrame.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 400));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        agregarEmpresaFrame.getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 220, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        agregarEmpresaFrame.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 420, 400));

        ofertaEmpresaTrabajo.setMaximumSize(new java.awt.Dimension(680, 402));
        ofertaEmpresaTrabajo.setMinimumSize(new java.awt.Dimension(680, 402));
        ofertaEmpresaTrabajo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ofertas de trabajo de la empresa");
        ofertaEmpresaTrabajo.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 230, 33));

        ofertasTable.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        ofertasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cargo", "Descripcion", "Rango salarial", "Jornada", "Titulaciones", "Requerimientos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ofertasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ofertasTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ofertasTable);

        ofertaEmpresaTrabajo.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 660, 106));

        crearOfertaBtn.setBackground(new java.awt.Color(255, 255, 255));
        crearOfertaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        crearOfertaBtn.setForeground(new java.awt.Color(255, 255, 255));
        crearOfertaBtn.setText("Crear oferta");
        crearOfertaBtn.setBorder(null);
        crearOfertaBtn.setContentAreaFilled(false);
        crearOfertaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearOfertaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearOfertaBtnActionPerformed(evt);
            }
        });
        ofertaEmpresaTrabajo.getContentPane().add(crearOfertaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 153, 30));

        eliminarOfertaBtn.setBackground(new java.awt.Color(255, 255, 255));
        eliminarOfertaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        eliminarOfertaBtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminarOfertaBtn.setText("Eliminar oferta");
        eliminarOfertaBtn.setBorder(null);
        eliminarOfertaBtn.setContentAreaFilled(false);
        eliminarOfertaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarOfertaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarOfertaBtnActionPerformed(evt);
            }
        });
        ofertaEmpresaTrabajo.getContentPane().add(eliminarOfertaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, 30));

        guardarOfertaBtn.setBackground(new java.awt.Color(255, 255, 255));
        guardarOfertaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        guardarOfertaBtn.setForeground(new java.awt.Color(255, 255, 255));
        guardarOfertaBtn.setText("Guardar oferta");
        guardarOfertaBtn.setBorder(null);
        guardarOfertaBtn.setContentAreaFilled(false);
        guardarOfertaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarOfertaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarOfertaBtnActionPerformed(evt);
            }
        });
        ofertaEmpresaTrabajo.getContentPane().add(guardarOfertaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 130, 30));

        seleccionarOfertaBtn.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarOfertaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        seleccionarOfertaBtn.setForeground(new java.awt.Color(255, 255, 255));
        seleccionarOfertaBtn.setText("Seleccionar oferta");
        seleccionarOfertaBtn.setBorder(null);
        seleccionarOfertaBtn.setContentAreaFilled(false);
        seleccionarOfertaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarOfertaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarOfertaBtnActionPerformed(evt);
            }
        });
        ofertaEmpresaTrabajo.getContentPane().add(seleccionarOfertaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 150, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ubicación archivo:");
        ofertaEmpresaTrabajo.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 130, -1));

        ubicacionOfertaArchivo.setBackground(new java.awt.Color(0, 0, 51));
        ubicacionOfertaArchivo.setForeground(new java.awt.Color(255, 255, 255));
        ubicacionOfertaArchivo.setBorder(null);
        ofertaEmpresaTrabajo.getContentPane().add(ubicacionOfertaArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 310, 20));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        ofertaEmpresaTrabajo.getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 110, 20));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        ofertaEmpresaTrabajo.getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 110, 20));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        ofertaEmpresaTrabajo.getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 130, 20));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        ofertaEmpresaTrabajo.getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 110, 20));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        ofertaEmpresaTrabajo.getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 310, 10));

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Empresa:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, 32));

        empresaOfertaField.setBackground(new java.awt.Color(0, 0, 51));
        empresaOfertaField.setForeground(new java.awt.Color(255, 255, 255));
        empresaOfertaField.setBorder(null);
        jPanel4.add(empresaOfertaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 260, -1));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 260, 10));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cambiarSolicitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        cambiarSolicitantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarSolicitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarSolicitantesMouseClicked(evt);
            }
        });
        jPanel4.add(cambiarSolicitantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, -1, -1));

        cerrarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarSistema.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSistemaMouseClicked(evt);
            }
        });
        jPanel4.add(cerrarSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 110, -1, -1));

        devolverEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        devolverEmpresas.setText("jLabel25");
        devolverEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        devolverEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                devolverEmpresasMouseClicked(evt);
            }
        });
        jPanel4.add(devolverEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 30, 30, 30));

        ofertaEmpresaTrabajo.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 430));

        ingresarOferta.setMaximumSize(new java.awt.Dimension(731, 528));
        ingresarOferta.setMinimumSize(new java.awt.Dimension(731, 528));
        ingresarOferta.getContentPane().setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Datos del cargo a ofrecer");
        ingresarOferta.getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 130, 178, 25);

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre del puesto:");
        ingresarOferta.getContentPane().add(jLabel10);
        jLabel10.setBounds(260, 20, 140, 20);

        nombrePuestoField.setBackground(new java.awt.Color(255, 255, 255));
        nombrePuestoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        nombrePuestoField.setForeground(new java.awt.Color(0, 0, 0));
        nombrePuestoField.setText("Ingrese el nombre del puesto");
        nombrePuestoField.setBorder(null);
        nombrePuestoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombrePuestoFieldMouseClicked(evt);
            }
        });
        nombrePuestoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrePuestoFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(nombrePuestoField);
        nombrePuestoField.setBounds(400, 20, 190, 18);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Descripcion:");
        ingresarOferta.getContentPane().add(jLabel11);
        jLabel11.setBounds(310, 70, 90, 19);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Salario ofrecido:");
        ingresarOferta.getContentPane().add(jLabel12);
        jLabel12.setBounds(280, 110, 112, 19);

        salarioInicialField.setBackground(new java.awt.Color(255, 255, 255));
        salarioInicialField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        salarioInicialField.setForeground(new java.awt.Color(0, 0, 0));
        salarioInicialField.setText("Salario inicial");
        salarioInicialField.setBorder(null);
        salarioInicialField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salarioInicialFieldMouseClicked(evt);
            }
        });
        salarioInicialField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarioInicialFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(salarioInicialField);
        salarioInicialField.setBounds(400, 110, 90, 18);

        salarioFinalField.setBackground(new java.awt.Color(255, 255, 255));
        salarioFinalField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        salarioFinalField.setForeground(new java.awt.Color(0, 0, 0));
        salarioFinalField.setText("Salario final");
        salarioFinalField.setBorder(null);
        salarioFinalField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salarioFinalFieldMouseClicked(evt);
            }
        });
        salarioFinalField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarioFinalFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(salarioFinalField);
        salarioFinalField.setBounds(500, 110, 90, 18);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Jornada:");
        ingresarOferta.getContentPane().add(jLabel13);
        jLabel13.setBounds(330, 150, 60, 19);

        jornadaComboBox.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jornadaComboBox.setForeground(new java.awt.Color(0, 0, 0));
        jornadaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completa", "Parcial" }));
        jornadaComboBox.setBorder(null);
        jornadaComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarOferta.getContentPane().add(jornadaComboBox);
        jornadaComboBox.setBounds(400, 150, 190, 27);

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Titulaciones requeridas: ");
        ingresarOferta.getContentPane().add(jLabel14);
        jLabel14.setBounds(228, 210, 170, 19);

        titulacionRequeridaField.setBackground(new java.awt.Color(255, 255, 255));
        titulacionRequeridaField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        titulacionRequeridaField.setForeground(new java.awt.Color(0, 0, 0));
        titulacionRequeridaField.setText("Ingrese las titulaciones");
        titulacionRequeridaField.setBorder(null);
        titulacionRequeridaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titulacionRequeridaFieldMouseClicked(evt);
            }
        });
        titulacionRequeridaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titulacionRequeridaFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(titulacionRequeridaField);
        titulacionRequeridaField.setBounds(400, 210, 190, 18);

        añadirListaTitulacionesBtn.setBackground(new java.awt.Color(0, 0, 51));
        añadirListaTitulacionesBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        añadirListaTitulacionesBtn.setForeground(new java.awt.Color(0, 0, 0));
        añadirListaTitulacionesBtn.setText("Añadir");
        añadirListaTitulacionesBtn.setBorder(null);
        añadirListaTitulacionesBtn.setContentAreaFilled(false);
        añadirListaTitulacionesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        añadirListaTitulacionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirListaTitulacionesBtnActionPerformed(evt);
            }
        });
        ingresarOferta.getContentPane().add(añadirListaTitulacionesBtn);
        añadirListaTitulacionesBtn.setBounds(610, 200, 80, 32);

        titulacionesRequerida.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(titulacionesRequerida);

        ingresarOferta.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(400, 250, 190, 50);

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Habilidad Requerida:");
        ingresarOferta.getContentPane().add(jLabel15);
        jLabel15.setBounds(240, 340, 150, 19);

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nivel requerido:");
        ingresarOferta.getContentPane().add(jLabel16);
        jLabel16.setBounds(270, 380, 110, 15);

        habilidadRequeridaField.setBackground(new java.awt.Color(255, 255, 255));
        habilidadRequeridaField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        habilidadRequeridaField.setForeground(new java.awt.Color(0, 0, 0));
        habilidadRequeridaField.setText("Ingrese la habilidad");
        habilidadRequeridaField.setBorder(null);
        habilidadRequeridaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilidadRequeridaFieldMouseClicked(evt);
            }
        });
        habilidadRequeridaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                habilidadRequeridaFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(habilidadRequeridaField);
        habilidadRequeridaField.setBounds(400, 340, 190, 18);

        nivelRequeridoField.setBackground(new java.awt.Color(255, 255, 255));
        nivelRequeridoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        nivelRequeridoField.setForeground(new java.awt.Color(0, 0, 0));
        nivelRequeridoField.setText("Ingrese el nivel de la habilidad");
        nivelRequeridoField.setBorder(null);
        nivelRequeridoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nivelRequeridoFieldMouseClicked(evt);
            }
        });
        nivelRequeridoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nivelRequeridoFieldKeyTyped(evt);
            }
        });
        ingresarOferta.getContentPane().add(nivelRequeridoField);
        nivelRequeridoField.setBounds(400, 380, 190, 18);

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Lista de requerimientos:");
        ingresarOferta.getContentPane().add(jLabel17);
        jLabel17.setBounds(230, 430, 170, 19);

        jScrollPane4.setViewportView(listaRequerimientos);

        ingresarOferta.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(400, 430, 190, 40);

        añadirOfertaBtn.setBackground(new java.awt.Color(0, 0, 51));
        añadirOfertaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        añadirOfertaBtn.setForeground(new java.awt.Color(255, 255, 255));
        añadirOfertaBtn.setText("Crear oferta");
        añadirOfertaBtn.setBorder(null);
        añadirOfertaBtn.setContentAreaFilled(false);
        añadirOfertaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        añadirOfertaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirOfertaBtnActionPerformed(evt);
            }
        });
        ingresarOferta.getContentPane().add(añadirOfertaBtn);
        añadirOfertaBtn.setBounds(40, 370, 90, 30);

        añadirHabilidad.setBackground(new java.awt.Color(0, 0, 51));
        añadirHabilidad.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        añadirHabilidad.setForeground(new java.awt.Color(0, 0, 0));
        añadirHabilidad.setText("Añadir");
        añadirHabilidad.setBorder(null);
        añadirHabilidad.setContentAreaFilled(false);
        añadirHabilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        añadirHabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirHabilidadActionPerformed(evt);
            }
        });
        ingresarOferta.getContentPane().add(añadirHabilidad);
        añadirHabilidad.setBounds(610, 330, 80, 40);
        ingresarOferta.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(20, 130, 3, 3);

        descripcionPuestoField.setBackground(new java.awt.Color(255, 255, 255));
        descripcionPuestoField.setColumns(20);
        descripcionPuestoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        descripcionPuestoField.setForeground(new java.awt.Color(0, 0, 0));
        descripcionPuestoField.setRows(5);
        descripcionPuestoField.setText("Ingrese la descripción del puesto");
        descripcionPuestoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descripcionPuestoFieldMouseClicked(evt);
            }
        });
        ingresarOferta.getContentPane().add(descripcionPuestoField);
        descripcionPuestoField.setBounds(400, 70, 190, 20);

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator15);
        jSeparator15.setBounds(400, 360, 190, 10);

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator16);
        jSeparator16.setBounds(400, 130, 90, 20);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator17);
        jSeparator17.setBounds(400, 40, 190, 20);

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator18);
        jSeparator18.setBounds(400, 90, 190, 20);

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator19);
        jSeparator19.setBounds(500, 130, 90, 10);

        jSeparator20.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        ingresarOferta.getContentPane().add(jSeparator20);
        jSeparator20.setBounds(40, 400, 90, 10);

        jSeparator21.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator21.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator21);
        jSeparator21.setBounds(400, 230, 190, 10);

        jSeparator22.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator22.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator22);
        jSeparator22.setBounds(400, 400, 190, 10);

        jSeparator23.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator23.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator23);
        jSeparator23.setBounds(400, 400, 190, 10);

        jSeparator24.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator24.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator24);
        jSeparator24.setBounds(620, 230, 60, 10);

        jSeparator25.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator25.setForeground(new java.awt.Color(0, 0, 0));
        ingresarOferta.getContentPane().add(jSeparator25);
        jSeparator25.setBounds(620, 370, 60, 10);

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Handshake_96px.png"))); // NOI18N
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 80));

        retrocederOfertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retrocederOfertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrocederOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederOfertasMouseClicked(evt);
            }
        });
        jPanel5.add(retrocederOfertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 30, 40, 30));

        usuarioCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        usuarioCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarioCambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioCambioMouseClicked(evt);
            }
        });
        jPanel5.add(usuarioCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, -1, -1));

        CerrarFrames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        CerrarFrames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CerrarFrames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarFramesMouseClicked(evt);
            }
        });
        jPanel5.add(CerrarFrames, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 110, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ingresarOferta.getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 210, 530);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ingresarOferta.getContentPane().add(jPanel6);
        jPanel6.setBounds(210, 0, 520, 530);

        IdoneosFrame.setMaximumSize(new java.awt.Dimension(728, 368));
        IdoneosFrame.setMinimumSize(new java.awt.Dimension(728, 368));
        IdoneosFrame.getContentPane().setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retrocederListaOfertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retrocederListaOfertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrocederListaOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederListaOfertasMouseClicked(evt);
            }
        });
        jPanel7.add(retrocederListaOfertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 30, 40, 30));

        irLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        irLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        irLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irLoginMouseClicked(evt);
            }
        });
        jPanel7.add(irLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, -1, 30));

        cerrarSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSystemMouseClicked(evt);
            }
        });
        jPanel7.add(cerrarSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, -1, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        candidatoITable.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        candidatoITable.setForeground(new java.awt.Color(0, 0, 0));
        candidatoITable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "E-mail", "Teléfono", "Retribución", "Foto", "Jornada", "Titulaciones", "Habilidades"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        candidatoITable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                candidatoITableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(candidatoITable);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 603, 165));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Candidatos Idoneos por Oferta");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 210, 30));

        IdoneosFrame.getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 730, 370);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 390));
        setMinimumSize(new java.awt.Dimension(720, 390));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregrarEmpresaBtn.setBackground(new java.awt.Color(255, 255, 255));
        agregrarEmpresaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        agregrarEmpresaBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregrarEmpresaBtn.setText("Agregar empresa");
        agregrarEmpresaBtn.setBorder(null);
        agregrarEmpresaBtn.setContentAreaFilled(false);
        agregrarEmpresaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregrarEmpresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregrarEmpresaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(agregrarEmpresaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 170, 40));

        empresaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Empresa", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empresaTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empresaTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empresaTabla);
        if (empresaTabla.getColumnModel().getColumnCount() > 0) {
            empresaTabla.getColumnModel().getColumn(0).setResizable(false);
            empresaTabla.getColumnModel().getColumn(1).setResizable(false);
            empresaTabla.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, 160));

        nombreArchivoField.setBackground(new java.awt.Color(0, 0, 51));
        nombreArchivoField.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        nombreArchivoField.setForeground(new java.awt.Color(255, 255, 255));
        nombreArchivoField.setBorder(null);
        jPanel1.add(nombreArchivoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 350, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Archivo de las empresas:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        seleccionarEmpresaBtn.setBackground(new java.awt.Color(255, 255, 255));
        seleccionarEmpresaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        seleccionarEmpresaBtn.setForeground(new java.awt.Color(255, 255, 255));
        seleccionarEmpresaBtn.setText("Seleccionar empresa");
        seleccionarEmpresaBtn.setBorder(null);
        seleccionarEmpresaBtn.setContentAreaFilled(false);
        seleccionarEmpresaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarEmpresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarEmpresaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(seleccionarEmpresaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 170, 40));

        guardarEmpresaBtn.setBackground(new java.awt.Color(255, 255, 255));
        guardarEmpresaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        guardarEmpresaBtn.setForeground(new java.awt.Color(255, 255, 255));
        guardarEmpresaBtn.setText("Guardar empresa");
        guardarEmpresaBtn.setBorder(null);
        guardarEmpresaBtn.setContentAreaFilled(false);
        guardarEmpresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEmpresaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(guardarEmpresaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 170, 40));

        eliminarEmpresaBtn.setBackground(new java.awt.Color(255, 255, 255));
        eliminarEmpresaBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        eliminarEmpresaBtn.setForeground(new java.awt.Color(255, 255, 255));
        eliminarEmpresaBtn.setText("Eliminar empresa");
        eliminarEmpresaBtn.setBorder(null);
        eliminarEmpresaBtn.setContentAreaFilled(false);
        eliminarEmpresaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarEmpresaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEmpresaBtnActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarEmpresaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 130, 40));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 150, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 130, 20));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 370, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        retroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederMouseClicked(evt);
            }
        });
        jPanel1.add(retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 50, 30, 30));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 102, 30, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Listado de empresas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregrarEmpresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregrarEmpresaBtnActionPerformed
//Limpias los campos a llenar de la empresa
        empresaField.setText("Ingrese el nombre de la empresa");
        telefonoEmpresaField.setText("Ingrese el telefono de la empresa");
        
        agregarEmpresaFrame.setVisible(true);
        

    }//GEN-LAST:event_agregrarEmpresaBtnActionPerformed

    private void agregarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEmpresaActionPerformed
//Agrega las empresas una vez se hayan llenado los respectivo campos
        DefaultTableModel model = (DefaultTableModel) empresaTabla.getModel();
        boolean vacio = false;
        String nombre = " ";
        long telefono = 0;
        
        int codigo = (int) (Math.random() * 1000);
        
        if (empresaField.getText().isEmpty()) {
            vacio = true;
        } else {
            nombre = empresaField.getText();
        }
        
        if (telefonoEmpresaField.getText().isEmpty()) {
            vacio = true;
        } else {
            telefono = Long.parseLong(telefonoEmpresaField.getText());
        }
        
        if (vacio) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            model.addRow(new Object[]{codigo, nombre, telefono});
            agregarEmpresaFrame.setVisible(false);
        }

    }//GEN-LAST:event_agregarEmpresaActionPerformed

    private void guardarEmpresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEmpresaBtnActionPerformed
//Guarda las empresas en el archivo "Empresa.txt"

        DefaultTableModel model = (DefaultTableModel) empresaTabla.getModel();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            int filas = empresaTabla.getRowCount();
            
            for (int i = 0; i < filas; i++) {
                
                Object codigo = model.getValueAt(i, 0);
                Object nombre = model.getValueAt(i, 1);
                Object telefono = model.getValueAt(i, 2);
                
                bw.write(codigo + "," + nombre + "," + telefono);
                
                bw.newLine();
            }
            
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_guardarEmpresaBtnActionPerformed

    private void telefonoEmpresaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoEmpresaFieldKeyTyped
//Hace que no se digiten letras en el campo de telefono y solo tenga una longitud máxima de 13
        char car = evt.getKeyChar();
        String largo = telefonoEmpresaField.getText();
        
        if (car < '0' || car > '9') {
            evt.consume();
        }
        
        if (largo.length() > 13) {
            evt.consume();
        }

    }//GEN-LAST:event_telefonoEmpresaFieldKeyTyped

    private void empresaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empresaFieldKeyTyped
//Hace que el usuario no digite números en el nombre de la empresa
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && car != '.' //Ejemplo: Aliansa Sodis S.A
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_empresaFieldKeyTyped

    private void seleccionarEmpresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarEmpresaBtnActionPerformed
//Escoge el archivo donde estén todas las empresas
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.txt", "text", "TEXT", "txt");
        
        FileChooser.setFileFilter(filter);
        int op = FileChooser.showOpenDialog(this);
        
        if (op == JFileChooser.APPROVE_OPTION) {
            archivo = FileChooser.getSelectedFile();
            
            nombreArchivoField.setText(archivo.getAbsolutePath());
            
            DefaultTableModel model = (DefaultTableModel) empresaTabla.getModel();
            
            try (Scanner leer = new Scanner(archivo)) {
                while (leer.hasNextLine()) {
                    String linea = leer.nextLine();
                    
                    String[] datos = linea.split(",");
                    
                    int codigo = Integer.parseInt(datos[0]);
                    String empresa = datos[1];
                    long telefono = Long.parseLong(datos[2]);
                    
                    model.addRow(new Object[]{codigo, empresa, telefono});
                    
                }
                
            } catch (Exception e) {
                
            }
        }
        

    }//GEN-LAST:event_seleccionarEmpresaBtnActionPerformed

    private void eliminarEmpresaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEmpresaBtnActionPerformed
//Elimina una empresa indeseada
        DefaultTableModel model = (DefaultTableModel) empresaTabla.getModel();
        
        int fila = empresaTabla.getSelectedRow();
        
        model.removeRow(fila);

    }//GEN-LAST:event_eliminarEmpresaBtnActionPerformed

    private void añadirOfertaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirOfertaBtnActionPerformed
//Añade la respectiva ofertas con el código de la empresa a la cual se selecciono
        DefaultTableModel model = (DefaultTableModel) ofertasTable.getModel();
        boolean vacio = false, logica = false;
        String puesto = " ", descripcion = "", salario = "";
        String jornada = (String) jornadaComboBox.getSelectedItem();
        int codigo = (int) empresaTabla.getValueAt(empresaTabla.getSelectedRow(), 0);
        
        if (nombrePuestoField.getText().isEmpty()) {
            vacio = true;
        } else {
            puesto = nombrePuestoField.getText();
        }
        if (descripcionPuestoField.getText().isEmpty()) {
            vacio = true;
        } else {
            descripcion = descripcionPuestoField.getText();
        }
        if (salarioInicialField.getText().isEmpty() && salarioFinalField.getText().isEmpty()) {
            vacio = true;
        } else {
            salario = salarioInicialField.getText() + "-" + salarioFinalField.getText();
        }
        
        if (Integer.parseInt(salarioInicialField.getText()) > Integer.parseInt(salarioFinalField.getText())) {
            logica = true;
            JOptionPane.showMessageDialog(null, "Salario final no puede ser mayor que el inicial", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        List<String> titulaciones = titulacionesRequerida.getSelectedValuesList();
        if (titulaciones.isEmpty() || titulaciones.size() < 2) {
            vacio = true;
        }
        List<String> habilidades = listaRequerimientos.getSelectedValuesList();
        if (habilidades.isEmpty() || habilidades.size() < 3) {
            vacio = true;
        }
        
        if (vacio && logica) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            model.addRow(new Object[]{codigo, puesto, descripcion, salario, jornada, titulaciones, habilidades});
            ingresarOferta.setVisible(false);
        }

    }//GEN-LAST:event_añadirOfertaBtnActionPerformed

    private void crearOfertaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearOfertaBtnActionPerformed
//Limpia los campos a llenar
        DefaultListModel model = (DefaultListModel) listaRequerimientos.getModel();
        DefaultListModel modelo = (DefaultListModel) titulacionesRequerida.getModel();
        
        nombrePuestoField.setText("Ingrese el nombre del puesto");
        descripcionPuestoField.setText("Ingrese la descripción del puesto");
        salarioInicialField.setText("Salario inicial");
        salarioFinalField.setText("Salario Final");
        titulacionRequeridaField.setText("Ingrese la titulación");
        habilidadRequeridaField.setText("Ingrese la habilidad");
        nivelRequeridoField.setText("Ingrese el nivel de la habilidad");
        model.clear();
        modelo.clear();
        listaRequerimientos.removeAll();
        titulacionesRequerida.removeAll();
        
        ingresarOferta.setVisible(true);

    }//GEN-LAST:event_crearOfertaBtnActionPerformed

    private void añadirListaTitulacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirListaTitulacionesBtnActionPerformed
//Añade titulaciones a la lista 
        DefaultListModel model = (DefaultListModel) titulacionesRequerida.getModel();
        
        if (model.getSize() < 2) {
            if (!titulacionRequeridaField.getText().isEmpty()) {
                String titulacion = titulacionRequeridaField.getText();
                ptr = AgregarTit(ptr, titulacion);
                mostrarListaTit(ptr);
            } else {
                JOptionPane.showMessageDialog(null, "No ha incluido ninguna titulacion", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo puede agregar 2 titulaciones", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_añadirListaTitulacionesBtnActionPerformed

    private void añadirHabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirHabilidadActionPerformed
//Añade habilidades a la lista de habilidades junto con la puntuación
        DefaultListModel model = (DefaultListModel) listaRequerimientos.getModel();
        
        if (model.getSize() < 3) {
            if (!habilidadRequeridaField.getText().isEmpty() && !nivelRequeridoField.getText().isEmpty()) {
                String habilidad = habilidadRequeridaField.getText();
                int nivel = Integer.parseInt(nivelRequeridoField.getText());
                ptr2 = agregarHabilidad(ptr2, habilidad, nivel);
                mostrarListaHabilidad(ptr2);
            } else {
                JOptionPane.showMessageDialog(null, "Complete los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo puede agregar 3 habilidades", "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_añadirHabilidadActionPerformed

    private void nombrePuestoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrePuestoFieldKeyTyped
//Hace que el usuario no digite números en el campo del nombre del puesto
        char car = evt.getKeyChar();
        
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && car != '.' //Ejemplo: Aliansa Sodis S.A
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Error", JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_nombrePuestoFieldKeyTyped

    private void titulacionRequeridaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titulacionRequeridaFieldKeyTyped
//Hace que el usuario no digite números en el campo de titulación
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && car != '.' //Ejemplo: Aliansa Sodis S.A
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_titulacionRequeridaFieldKeyTyped

    private void habilidadRequeridaFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_habilidadRequeridaFieldKeyTyped
//Hace que el usuario no digite números en el campo de habilidad
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas           
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas           
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'ñ'
                && car != 'Ñ'
                && car != '.' //Ejemplo: Aliansa Sodis S.A
                && (car != (char) KeyEvent.VK_SPACE)
                && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puede digitar letras", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_habilidadRequeridaFieldKeyTyped

    private void nivelRequeridoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelRequeridoFieldKeyTyped
//Hace que el usuario no puede digitar más de un número en el nivel y solo pueda digitar números
        char car = evt.getKeyChar();
        String largo = nivelRequeridoField.getText();
        
        if (car < '1' || car > '5') {
            evt.consume();
        }
        
        if (largo.length() > 0) {
            evt.consume();
        }

    }//GEN-LAST:event_nivelRequeridoFieldKeyTyped

    private void salarioInicialFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioInicialFieldKeyTyped
//Hace que el usuario no permita digitar letras en el campo de salario inicial
        char car = evt.getKeyChar();
        
        if (car < '0' || car > '9') {
            evt.consume();
        }

    }//GEN-LAST:event_salarioInicialFieldKeyTyped

    private void salarioFinalFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioFinalFieldKeyTyped
//Hace que el usuario no pueda digitar letras en el campo de salario final
        char car = evt.getKeyChar();
        
        if (car < '0' || car > '9') {
            evt.consume();
        }

    }//GEN-LAST:event_salarioFinalFieldKeyTyped

    private void eliminarOfertaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarOfertaBtnActionPerformed
//Permite eliminar una oferta no deseada o mal formulada
        DefaultTableModel model = (DefaultTableModel) ofertasTable.getModel();
        
        int fila = ofertasTable.getSelectedRow();
        
        model.removeRow(fila);

    }//GEN-LAST:event_eliminarOfertaBtnActionPerformed

    private void ofertasTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ofertasTableMouseClicked
//Muestre los ideoneos para el trabajo        
        DefaultTableModel modelo = (DefaultTableModel) candidatoITable.getModel();
        
        if (evt.getClickCount() == 2) {
            
            try (FileReader fr = new FileReader(solicitante)) {
                BufferedReader br = new BufferedReader(fr);
                
                String linea = br.readLine();
                while (linea != null) {
                    
                    String [] datos = linea.split(",");
                    String [] datos1 = ofertasTable.getValueAt(ofertasTable.getSelectedRow(), 5).toString().split(" ");
                    
                    if (datos[6].equalsIgnoreCase(datos1[0]) || datos[6].equalsIgnoreCase(datos1[2])
                            || datos[7].equalsIgnoreCase(datos1[0]) || datos[7].equalsIgnoreCase(datos1[1])) {
                        String nombre = datos[0];
                        String email = datos[1];
                        long telefono = Long.parseLong(datos[2]);
                        long retribucion = Long.parseLong(datos[3]);
                        Object foto = datos[4];
                        String jornada = datos[5];
                        String titulaciones = datos[6] + datos[7];
                        String habilidadPun = datos[8] + datos[9] + datos[10] + datos[11] + datos[12] + datos[13];
                        
                        modelo.addRow(new Object[]{nombre, email, telefono, retribucion, foto, jornada,
                            titulaciones, habilidadPun});
                    }
                    linea = br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ofertaEmpresaTrabajo.dispose();
            
            
            //ordernarIdoneos(modelo);
            
            IdoneosFrame.setVisible(true);
        }

    }//GEN-LAST:event_ofertasTableMouseClicked
    
    /*public void ordernarIdoneos(DefaultTableModel model) {
        //Ordena los solicitantes de manera descendente, del más calificado al menos calificado
        for (int i = 0; i < model.getRowCount(); i++) {
            if (Integer.parseInt(model.getValueAt(i, 7).toString())
                    < Integer.parseInt(model.getValueAt(i + 1, 7).toString())) {
                
                String nombre = model.getValueAt(i, 0).toString();
                String email = model.getValueAt(i, 1).toString();
                long telefono = Long.parseLong(model.getValueAt(i, 2).toString());
                long retribucion = Long.parseLong(model.getValueAt(i, 3).toString());
                Object foto = model.getValueAt(i, 4);
                String jornada = model.getValueAt(i, 5).toString();
                String titulacion = model.getValueAt(i, 6).toString();
                String habilidadPun = model.getValueAt(i, 7).toString();
                
                model.setValueAt(model.getValueAt(i + 1, 0), i, 0);
                model.setValueAt(model.getValueAt(i + 1, 1), i, 1);
                model.setValueAt(model.getValueAt(i + 1, 2), i, 2);
                model.setValueAt(model.getValueAt(i + 1, 3), i, 3);
                model.setValueAt(model.getValueAt(i + 1, 4), i, 4);
                model.setValueAt(model.getValueAt(i + 1, 5), i, 5);
                model.setValueAt(model.getValueAt(i + 1, 6), i, 6);
                model.setValueAt(model.getValueAt(i + 1, 7), i, 7);
                
                model.setValueAt((Object) nombre, i + 1, 0);
                model.setValueAt((Object) email, i + 1, 1);
                model.setValueAt((Object) telefono, i + 1, 2);
                model.setValueAt((Object) retribucion, i + 1, 3);
                model.setValueAt((Object) foto, i + 1, 4);
                model.setValueAt((Object) jornada, i + 1, 5);
                model.setValueAt((Object) titulacion, i + 1, 6);
                model.setValueAt((Object) habilidadPun, i + 1, 7);
                
            }
        }
    }*/
    

    private void empresaTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empresaTablaMouseClicked
//Carga las ofertas disponibles de esa empresa(Si las hay) y permite crear más para la respectiva empresa
        if (evt.getClickCount() == 2) {
            DefaultTableModel model = (DefaultTableModel) ofertasTable.getModel();
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                
                String linea = br.readLine();
                while (linea != null) {
                    
                    String[] datos = linea.split(",");
                    if (datos[0].equals(empresaTabla.getValueAt(empresaTabla.getSelectedRow(), 0).toString())) {
                        
                        int codigo = Integer.parseInt(datos[0]);
                        String cargo = datos[1];
                        String descripcion = datos[2];
                        String retribucion = (datos[3]);
                        String jornada = datos[4];
                        String titulacion = (datos[5] + datos[6]);
                        String habilidad = (datos[7] + datos[8] + datos[9] + datos[10] + datos[11] + datos[12]);
                        
                        model.addRow(new Object[]{codigo, cargo, descripcion, retribucion, jornada, titulacion,
                            habilidad});
                    }
                    linea = br.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            ofertaEmpresaTrabajo.setVisible(true);
            empresaOfertaField.setText((String) empresaTabla.getValueAt(empresaTabla.getSelectedRow(), 1));
            
        }
        

    }//GEN-LAST:event_empresaTablaMouseClicked

    private void guardarOfertaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarOfertaBtnActionPerformed
//Guarda las ofertas en el archivo "Ofertas.txt"
        DefaultTableModel model = (DefaultTableModel) ofertasTable.getModel();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            
            int filas = ofertasTable.getRowCount();
            
            for (int i = 0; i < filas; i++) {
                
                Object codigo = model.getValueAt(i, 0);
                Object cargo = model.getValueAt(i, 1);
                Object descripcion = model.getValueAt(i, 2);
                Object rangoSalario = model.getValueAt(i, 3);
                Object jornada = model.getValueAt(i, 4);
                Object titulaciones = model.getValueAt(i, 5);
                Object requerimientos = model.getValueAt(i, 6);
                
                bw.write(codigo + "," + cargo + "," + descripcion + "," + rangoSalario + ","
                        + jornada + "," + titulaciones + "," + requerimientos);
                
                bw.newLine();
            }
            
        } catch (Exception e) {
            
        }
        

    }//GEN-LAST:event_guardarOfertaBtnActionPerformed

    private void seleccionarOfertaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarOfertaBtnActionPerformed
        /*Selecciona el archivo de las ofertas de manera que las muestre todas, de esta manera así permite tener todas las ofertas
 de todas las empresas*/
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.txt", "text", "TEXT", "txt");
        
        fileChooser.setFileFilter(filter);
        int op = fileChooser.showOpenDialog(this);
        
        if (op == fileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            
            ubicacionOfertaArchivo.setText(file.getAbsolutePath());
            
            DefaultTableModel model = (DefaultTableModel) ofertasTable.getModel();
            
            try (Scanner leer = new Scanner(file)) {
                while (leer.hasNextLine()) {
                    String linea = leer.nextLine();
                    
                    String[] datos = linea.split(",");
                    
                    int codigo = Integer.parseInt(datos[0]);
                    String cargo = datos[1];
                    String descripcion = datos[2];
                    String retribucion = (datos[3]);
                    String jornada = datos[4];
                    String titulacion = (datos[5] + datos[6]);
                    String habilidad = (datos[7] + datos[8] + datos[9] + datos[10] + datos[11] + datos[12]);
                    
                    model.addRow(new Object[]{codigo, cargo, descripcion, retribucion, jornada, titulacion,
                        habilidad});
                    
                }
                
            } catch (Exception e) {
                
            }
        }

    }//GEN-LAST:event_seleccionarOfertaBtnActionPerformed

    private void candidatoITableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidatoITableMouseClicked
//Genera una simulación de que se envia un correo

        if (evt.getClickCount() == 2) {
            IdoneosFrame.dispose();
            new EnviarCorreo().setVisible(true);
        }

    }//GEN-LAST:event_candidatoITableMouseClicked
    
    public Frame dameIdoneosFrame(){
        return IdoneosFrame;
    }
    
    public Frame dameOfertasFrame(){
        return ofertaEmpresaTrabajo;
    }
    
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        //Desde el frame de empresas
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, retroceder);
        cerrarr.jLabelXRight(-40, 10, 10, 5, cerrar);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, retroceder);
        cerrarf.jLabelXLeft(10, -40, 10, 5, cerrar);
        

    }//GEN-LAST:event_jLabel4MouseClicked

    private void retrocederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederMouseClicked
//Retrocede al login desde el frame de empresa
        HumanWare Field = new HumanWare();
        if (evt.getClickCount() == 2) {
            this.dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }

    }//GEN-LAST:event_retrocederMouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
//Cierra el programa
        if(evt.getClickCount() == 2){
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked

        //Desde el frame de inscripción de empresas
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        AnimationClass cambiarr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, retrocederEmpresas);
        cambiarr.jLabelXRight(-40, 10, 10, 5, cambioUsuario);
        cerrarr.jLabelXRight(-40, 10, 10, 5, cerrarPrograma);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambiarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, retroceder);
        cambiarf.jLabelXLeft(10, -40, 10, 5, cambioUsuario);
        cerrarf.jLabelXLeft(10, -40, 10, 5, cerrar);
        
    }//GEN-LAST:event_jLabel24MouseClicked

    private void cambioUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambioUsuarioMouseClicked
//Te lleva al login cerrando todo lo abierto con respecto a empresas
        HumanWare Field = new HumanWare();
        if(evt.getClickCount() == 2){
            agregarEmpresaFrame.dispose();
            this.dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }
        
    }//GEN-LAST:event_cambioUsuarioMouseClicked

    private void cerrarProgramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarProgramaMouseClicked

        if(evt.getClickCount() == 2){
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarProgramaMouseClicked

    private void retrocederEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederEmpresasMouseClicked
//Retrocede al frame del listado de empresas
        if(evt.getClickCount() == 2){
            agregarEmpresaFrame.dispose();
        }
        
    }//GEN-LAST:event_retrocederEmpresasMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

        //Desde el frame de ofertas
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        AnimationClass cambiarr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, devolverEmpresas);
        cambiarr.jLabelXRight(-40, 10, 10, 5, cambiarSolicitantes);
        cerrarr.jLabelXRight(-40, 10, 10, 5, cerrarSistema);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambiarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, devolverEmpresas);
        cambiarf.jLabelXLeft(10, -40, 10, 5, cambiarSolicitantes);
        cerrarf.jLabelXLeft(10, -40, 10, 5, cerrarSistema);

    }//GEN-LAST:event_jLabel19MouseClicked

    private void cambiarSolicitantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarSolicitantesMouseClicked
//Te lleva al login desde el frame de las ofertas de cada empresa
        HumanWare Field = new HumanWare();
        if(evt.getClickCount() == 2){
            ofertaEmpresaTrabajo.dispose();
            this.dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }
        
    }//GEN-LAST:event_cambiarSolicitantesMouseClicked

    private void cerrarSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSistemaMouseClicked
//Cierra el programa
        if(evt.getClickCount() == 2){
         System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarSistemaMouseClicked

    private void devolverEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolverEmpresasMouseClicked
//Devuelve al frame del listado de las empresas
        if(evt.getClickCount() == 2){
            ofertaEmpresaTrabajo.dispose();
            this.setVisible(true);
        }
        
    }//GEN-LAST:event_devolverEmpresasMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

        //Desde el frame de ingresar ofertas
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        AnimationClass cambiarr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, retrocederOfertas);
        cambiarr.jLabelXRight(-40, 10, 10, 5, usuarioCambio);
        cerrarr.jLabelXRight(-40, 10, 10, 5, CerrarFrames);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambiarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, retrocederOfertas);
        cambiarf.jLabelXLeft(10, -40, 10, 5, usuarioCambio);
        cerrarf.jLabelXLeft(10, -40, 10, 5, CerrarFrames);
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void retrocederOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederOfertasMouseClicked
//Se devuelve a las ofertas ya creadas de cada empresa
        if(evt.getClickCount() == 2){
            ingresarOferta.dispose();
        }

    }//GEN-LAST:event_retrocederOfertasMouseClicked

    private void usuarioCambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioCambioMouseClicked
//Te lleva al login desde el frame de la creación de ofertas
        HumanWare Field = new HumanWare();
        if(evt.getClickCount() == 2){
            ofertaEmpresaTrabajo.dispose();
            ingresarOferta.dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }

    }//GEN-LAST:event_usuarioCambioMouseClicked

    private void CerrarFramesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarFramesMouseClicked
//Cierra el programa
        if(evt.getClickCount() == 2){
            System.exit(0);
        }
        
    }//GEN-LAST:event_CerrarFramesMouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked

        //Desde el frame de los candidatos idoneos
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        AnimationClass cambiarr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, retrocederListaOfertas);
        cambiarr.jLabelXRight(-40, 10, 10, 5, irLogin);
        cerrarr.jLabelXRight(-40, 10, 10, 5, cerrarSystem);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambiarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, retrocederListaOfertas);
        cambiarf.jLabelXLeft(10, -40, 10, 5, irLogin);
        cerrarf.jLabelXLeft(10, -40, 10, 5, cerrarSystem);
        
        
    }//GEN-LAST:event_jLabel27MouseClicked

    private void retrocederListaOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederListaOfertasMouseClicked

        if(evt.getClickCount() == 2){
            IdoneosFrame.dispose();
            ofertaEmpresaTrabajo.setVisible(true);
        }

    }//GEN-LAST:event_retrocederListaOfertasMouseClicked

    private void irLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irLoginMouseClicked
//Te lleva al login desde el frame de los idoneos
        HumanWare Field = new HumanWare();
        if(evt.getClickCount() == 2){
            ofertaEmpresaTrabajo.dispose();
            IdoneosFrame.dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }
        
        
    }//GEN-LAST:event_irLoginMouseClicked

    private void cerrarSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSystemMouseClicked
//Cierra el programa
        if(evt.getClickCount() == 2){
            System.exit(0);
        }
        
    }//GEN-LAST:event_cerrarSystemMouseClicked

    private void nombrePuestoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombrePuestoFieldMouseClicked
//Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            nombrePuestoField.setText("");
        }
        
    }//GEN-LAST:event_nombrePuestoFieldMouseClicked

    private void descripcionPuestoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descripcionPuestoFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            descripcionPuestoField.setText("");
        }
        
    }//GEN-LAST:event_descripcionPuestoFieldMouseClicked

    private void salarioInicialFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salarioInicialFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            salarioInicialField.setText("");
        }

    }//GEN-LAST:event_salarioInicialFieldMouseClicked

    private void salarioFinalFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salarioFinalFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            salarioFinalField.setText("");
        }

    }//GEN-LAST:event_salarioFinalFieldMouseClicked

    private void titulacionRequeridaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titulacionRequeridaFieldMouseClicked

       //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            titulacionRequeridaField.setText("");
        }
        
    }//GEN-LAST:event_titulacionRequeridaFieldMouseClicked

    private void habilidadRequeridaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilidadRequeridaFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
           habilidadRequeridaField.setText("");
        }

    }//GEN-LAST:event_habilidadRequeridaFieldMouseClicked

    private void nivelRequeridoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nivelRequeridoFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            nivelRequeridoField.setText("");
        }

    }//GEN-LAST:event_nivelRequeridoFieldMouseClicked

    private void empresaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empresaFieldMouseClicked

        //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            empresaField.setText("");
        }

    }//GEN-LAST:event_empresaFieldMouseClicked

    private void telefonoEmpresaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoEmpresaFieldMouseClicked

        
         //Pone vacio el campo una vez se le da click
        if(evt.getClickCount() == 1){
            telefonoEmpresaField.setText("");
        }
    }//GEN-LAST:event_telefonoEmpresaFieldMouseClicked
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CerrarFrames;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JFrame IdoneosFrame;
    private javax.swing.JButton agregarEmpresa;
    private javax.swing.JFrame agregarEmpresaFrame;
    private javax.swing.JButton agregrarEmpresaBtn;
    private javax.swing.JButton añadirHabilidad;
    private javax.swing.JButton añadirListaTitulacionesBtn;
    private javax.swing.JButton añadirOfertaBtn;
    private javax.swing.JLabel cambiarSolicitantes;
    private javax.swing.JLabel cambioUsuario;
    private javax.swing.JTable candidatoITable;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel cerrarPrograma;
    private javax.swing.JLabel cerrarSistema;
    private javax.swing.JLabel cerrarSystem;
    private javax.swing.JButton crearOfertaBtn;
    private javax.swing.JTextArea descripcionPuestoField;
    private javax.swing.JLabel devolverEmpresas;
    private javax.swing.JButton eliminarEmpresaBtn;
    private javax.swing.JButton eliminarOfertaBtn;
    private javax.swing.JTextField empresaField;
    private javax.swing.JTextField empresaOfertaField;
    private javax.swing.JTable empresaTabla;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton guardarEmpresaBtn;
    private javax.swing.JButton guardarOfertaBtn;
    private javax.swing.JTextField habilidadRequeridaField;
    private javax.swing.JFrame ingresarOferta;
    private javax.swing.JLabel irLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JComboBox<String> jornadaComboBox;
    private javax.swing.JList<String> listaRequerimientos;
    private javax.swing.JTextField nivelRequeridoField;
    private javax.swing.JTextField nombreArchivoField;
    private javax.swing.JTextField nombrePuestoField;
    private javax.swing.JFrame ofertaEmpresaTrabajo;
    private javax.swing.JTable ofertasTable;
    private javax.swing.JLabel retroceder;
    private javax.swing.JLabel retrocederEmpresas;
    private javax.swing.JLabel retrocederListaOfertas;
    private javax.swing.JLabel retrocederOfertas;
    private javax.swing.JTextField salarioFinalField;
    private javax.swing.JTextField salarioInicialField;
    private javax.swing.JButton seleccionarEmpresaBtn;
    private javax.swing.JButton seleccionarOfertaBtn;
    private javax.swing.JTextField telefonoEmpresaField;
    private javax.swing.JTextField titulacionRequeridaField;
    private javax.swing.JList<String> titulacionesRequerida;
    private javax.swing.JTextField ubicacionOfertaArchivo;
    private javax.swing.JLabel usuarioCambio;
    // End of variables declaration//GEN-END:variables
}
