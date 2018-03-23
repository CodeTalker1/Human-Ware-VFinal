package humanware_betancourtandres_manotasalejandro;

import AppPackage.AnimationClass;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejo
 */
public class EnviarCorreo extends javax.swing.JFrame {

Empresa frames = new Empresa();

    public EnviarCorreo() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/mundoGlobal.jpg")).getImage());
        
        idoneoEmail.setText("Digite el correo del empleado a contratar");
        asuntoField.setText("Escriba el asunto");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enviarCorreoBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        correoField = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idoneoEmail = new javax.swing.JTextField();
        asuntoField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cerrarFrames = new javax.swing.JLabel();
        irLogin = new javax.swing.JLabel();
        retrocederIdoneos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(699, 414));
        setMinimumSize(new java.awt.Dimension(699, 414));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enviarCorreoBtn.setBackground(new java.awt.Color(0, 0, 51));
        enviarCorreoBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        enviarCorreoBtn.setForeground(new java.awt.Color(255, 255, 255));
        enviarCorreoBtn.setText("Enviar Correo");
        enviarCorreoBtn.setBorder(null);
        enviarCorreoBtn.setContentAreaFilled(false);
        enviarCorreoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviarCorreoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCorreoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(enviarCorreoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 110, -1));

        correoField.setBackground(new java.awt.Color(255, 255, 255));
        correoField.setColumns(20);
        correoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        correoField.setForeground(new java.awt.Color(0, 0, 0));
        correoField.setRows(5);
        jScrollPane1.setViewportView(correoField);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 126, 393, 220));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Correo electronico");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 80, 130, -1));

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Destino:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 41, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Asunto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 78, -1, -1));

        idoneoEmail.setBackground(new java.awt.Color(255, 255, 255));
        idoneoEmail.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        idoneoEmail.setForeground(new java.awt.Color(0, 0, 0));
        idoneoEmail.setBorder(null);
        idoneoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idoneoEmailMouseClicked(evt);
            }
        });
        getContentPane().add(idoneoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 42, 306, -1));

        asuntoField.setBackground(new java.awt.Color(255, 255, 255));
        asuntoField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        asuntoField.setForeground(new java.awt.Color(0, 0, 0));
        asuntoField.setBorder(null);
        asuntoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asuntoFieldMouseClicked(evt);
            }
        });
        getContentPane().add(asuntoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 79, 303, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 90, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 310, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 310, 10));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Today_96px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        cerrarFrames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Multiply_32px.png"))); // NOI18N
        cerrarFrames.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarFrames.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarFramesMouseClicked(evt);
            }
        });
        jPanel1.add(cerrarFrames, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 110, -1, -1));

        irLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_customer_32px_1.png"))); // NOI18N
        irLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        irLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                irLoginMouseClicked(evt);
            }
        });
        jPanel1.add(irLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 70, -1, -1));

        retrocederIdoneos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Back_64px.png"))); // NOI18N
        retrocederIdoneos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retrocederIdoneos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederIdoneosMouseClicked(evt);
            }
        });
        jPanel1.add(retrocederIdoneos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 30, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos_Frame/icons8_Menu_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 420));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        //Desde el frame para enviar un correo
        AnimationClass cerrarr = new AnimationClass();
        AnimationClass retrocederr = new AnimationClass();
        AnimationClass cambiarr = new AnimationClass();
        //Se desplaza hacia la derecha
        retrocederr.jLabelXRight(-40, 10, 10, 5, retrocederIdoneos);
        cambiarr.jLabelXRight(-40, 10, 10, 5, irLogin);
        cerrarr.jLabelXRight(-40, 10, 10, 5, cerrarFrames);

        //Se desplaza hacia la izquierda
        AnimationClass cerrarf = new AnimationClass();
        AnimationClass cambiarf = new AnimationClass();
        AnimationClass retrocederf = new AnimationClass();
        
        retrocederf.jLabelXLeft(10, -40, 10, 5, retrocederIdoneos);
        cambiarf.jLabelXLeft(10, -40, 10, 5, irLogin);
        cerrarf.jLabelXLeft(10, -40, 10, 5, cerrarFrames);
        

    }//GEN-LAST:event_jLabel8MouseClicked

    private void retrocederIdoneosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederIdoneosMouseClicked
//Retrocede a la lista de los solicitantes idoneos
        if(evt.getClickCount() == 2){
            this.dispose();
            frames.dameIdoneosFrame().setVisible(true);
        }

    }//GEN-LAST:event_retrocederIdoneosMouseClicked

    private void irLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_irLoginMouseClicked
//Retrocede al login desde el frame para enviar correos
        HumanWare Field = new HumanWare();
        if (evt.getClickCount() == 2) {
            this.dispose();
            frames.dameIdoneosFrame().dispose();
            frames.dameOfertasFrame().dispose();
            new HumanWare().setVisible(true);
            Field.dameUsuarioTextField().setText("Ingrese usuario");
            Field.dameContraseñaField().setText("Ingrese contraseña");
        }


    }//GEN-LAST:event_irLoginMouseClicked

    private void cerrarFramesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarFramesMouseClicked
//Cierra el programa
        if(evt.getClickCount() == 2){
            System.exit(0);
        }

    }//GEN-LAST:event_cerrarFramesMouseClicked

    private void enviarCorreoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarCorreoBtnActionPerformed
//Envia el correo electronico
        if(!idoneoEmail.getText().isEmpty() && !asuntoField.getText().isEmpty() && 
                !correoField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "Exito", JOptionPane.OK_OPTION);
            this.dispose();
            frames.dameIdoneosFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_enviarCorreoBtnActionPerformed

    private void idoneoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idoneoEmailMouseClicked
//Vacia el campo de texto del email
        if(evt.getClickCount() == 1){
            idoneoEmail.setText("");
        }
        
    }//GEN-LAST:event_idoneoEmailMouseClicked

    private void asuntoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asuntoFieldMouseClicked
//Vacia el campo de texto del asunto
        if(evt.getClickCount() == 1){
            asuntoField.setText("");
        }

    }//GEN-LAST:event_asuntoFieldMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarCorreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asuntoField;
    private javax.swing.JLabel cerrarFrames;
    private javax.swing.JTextArea correoField;
    private javax.swing.JButton enviarCorreoBtn;
    private javax.swing.JTextField idoneoEmail;
    private javax.swing.JLabel irLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel retrocederIdoneos;
    // End of variables declaration//GEN-END:variables
}
