package Frame;

import com.sun.awt.AWTUtilities;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Negocio.UsuarioBL;

public class LoginPrincipal extends javax.swing.JFrame {

    int x, y;

    private UsuarioBL usuarioBL;

    public LoginPrincipal() {
        initComponents();

        AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(null);

    }

    void limpiarTexto() {
        txtUsuario.setText(null);
        txtContraseña.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MoverConElCursor = new javax.swing.JLabel();
        panelIzquierdo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        mobien = new javax.swing.JLabel();
        bibliotecav200 = new javax.swing.JLabel();
        panelDerecho = new javax.swing.JPanel();
        Salir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        Minimizar = new javax.swing.JPanel();
        btnSalir2 = new javax.swing.JLabel();
        iconoLogin = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        contraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelEntrar = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        lblEntrar = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JPanel();
        lblEntrar1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        autor50 = new javax.swing.JLabel();
        autor51 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MoverConElCursor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MoverConElCursor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MoverConElCursorMouseDragged(evt);
            }
        });
        MoverConElCursor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MoverConElCursorMousePressed(evt);
            }
        });
        getContentPane().add(MoverConElCursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 30));

        panelIzquierdo.setBackground(new java.awt.Color(0, 151, 247));
        panelIzquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modulo de biblioteca para la");
        panelIzquierdo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 330, 22));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Intitucion Educativa el Mirador");
        panelIzquierdo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 330, 22));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setToolTipText("");
        panelIzquierdo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 210, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelIzquierdo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 144, 10));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo unimayor.PNG"))); // NOI18N
        panelIzquierdo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 330, 167));

        mobien.setBackground(new java.awt.Color(136, 120, 230));
        mobien.setFont(new java.awt.Font("Decker", 1, 35)); // NOI18N
        mobien.setForeground(new java.awt.Color(255, 255, 255));
        mobien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobien.setText("MoBiem");
        mobien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelIzquierdo.add(mobien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 330, 30));

        bibliotecav200.setBackground(new java.awt.Color(136, 120, 230));
        bibliotecav200.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        bibliotecav200.setForeground(new java.awt.Color(255, 255, 255));
        bibliotecav200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bibliotecav200.setText(" Biblioteca V2.00");
        bibliotecav200.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelIzquierdo.add(bibliotecav200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 330, 20));

        getContentPane().add(panelIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 430));

        panelDerecho.setBackground(new java.awt.Color(37, 47, 67));
        panelDerecho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salir.setBackground(new java.awt.Color(37, 47, 67));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalirMouseExited(evt);
            }
        });
        Salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/xblanco.png"))); // NOI18N
        Salir.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        panelDerecho.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        Minimizar.setBackground(new java.awt.Color(37, 47, 67));
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizarMouseExited(evt);
            }
        });
        Minimizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/-blanco.png"))); // NOI18N
        Minimizar.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        panelDerecho.add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 40, -1));

        iconoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user blanco2.png"))); // NOI18N
        panelDerecho.add(iconoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, 290, 130));

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("LOGIN ");
        panelDerecho.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 134, 290, 22));

        usuario.setBackground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usuario.setText("USUARIO:");
        panelDerecho.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 174, 290, 22));

        contraseña.setBackground(new java.awt.Color(255, 255, 255));
        contraseña.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contraseña.setText("CONTRASEÑA:");
        panelDerecho.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 247, 290, 22));

        txtContraseña.setBackground(new java.awt.Color(37, 47, 67));
        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setText("123");
        txtContraseña.setBorder(null);
        txtContraseña.setHighlighter(null);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        panelDerecho.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 280, 22));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setToolTipText("");
        panelDerecho.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 226, 290, 10));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setToolTipText("");
        panelDerecho.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 295, 290, 10));

        panelEntrar.setBackground(new java.awt.Color(0, 151, 247));
        panelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEntrarMouseExited(evt);
            }
        });
        panelEntrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setFocusable(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        panelEntrar.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 328, 290, 30));

        lblEntrar.setBackground(new java.awt.Color(204, 0, 204));
        lblEntrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblEntrar.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrar.setText("ENTRAR");
        panelEntrar.add(lblEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        panelDerecho.add(panelEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 320, 290, 30));

        panelUsuario.setBackground(new java.awt.Color(77, 54, 218));
        panelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelUsuarioMouseExited(evt);
            }
        });
        panelUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEntrar1.setBackground(new java.awt.Color(204, 0, 204));
        lblEntrar1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblEntrar1.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrar1.setText("INTERFAZ DE USUARIO");
        panelUsuario.add(lblEntrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        panelDerecho.add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 362, 290, 30));

        txtUsuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setText("encargado");
        txtUsuario.setBorder(null);
        txtUsuario.setOpaque(false);
        txtUsuario.setSelectionColor(new java.awt.Color(0, 151, 247));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        panelDerecho.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 280, 22));

        autor50.setBackground(new java.awt.Color(255, 255, 255));
        autor50.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor50.setForeground(new java.awt.Color(255, 255, 255));
        autor50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor50.setText("*");
        panelDerecho.add(autor50, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 20, 20));

        autor51.setBackground(new java.awt.Color(255, 255, 255));
        autor51.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor51.setForeground(new java.awt.Color(255, 255, 255));
        autor51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor51.setText("*");
        panelDerecho.add(autor51, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 20, 20));

        getContentPane().add(panelDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 440, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnEntrar.doClick();
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea cerrar el programa", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalirMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        resetColor2(Minimizar);
        this.setState(LoginPrincipal.ICONIFIED);

    }//GEN-LAST:event_MinimizarMouseClicked

    private void panelEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEntrarMouseEntered
        setColorentrar(panelEntrar);
    }//GEN-LAST:event_panelEntrarMouseEntered

    private void panelEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEntrarMouseExited
        resetColorentrar(panelEntrar);
    }//GEN-LAST:event_panelEntrarMouseExited

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (String.valueOf(txtContraseña.getPassword()).compareTo("") == 0 || String.valueOf(txtUsuario.getText()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(rootPane, "No puede dejar ningun campo vacio");
        } else {
            usuarioBL = new UsuarioBL();
            if (usuarioBL.verificarUsuario(txtUsuario.getText(), new String(txtContraseña.getPassword()))) {
                Modelo.Usuario usuarioLogueado = UsuarioBL.usuario;
                if (usuarioLogueado != null) {
                    if (!usuarioLogueado.getEstado().equals("Activo")) {
                        JOptionPane.showMessageDialog(rootPane, "El usuario se encuentra inactivo.");
                    } else {
                        if (usuarioLogueado.getRol().equals("Administrador")) {
                            Administrador obj = new Administrador();
                            obj.setVisible(true);
                            dispose();
                        } else {
                            Encargado obj = new Encargado();
                            obj.setVisible(true);
                            dispose();
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecta");
            }
        }
        limpiarTexto();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void panelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseClicked
        Usuario obj = new Usuario();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_panelUsuarioMouseClicked

    private void panelUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseEntered
        moradoOscuro(panelUsuario);
    }//GEN-LAST:event_panelUsuarioMouseEntered

    private void panelUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUsuarioMouseExited
        moradoNormal(panelUsuario);
    }//GEN-LAST:event_panelUsuarioMouseExited

    private void panelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEntrarMouseClicked
        if (String.valueOf(txtContraseña.getPassword()).compareTo("") == 0 || String.valueOf(txtUsuario.getText()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(rootPane, "No puede dejar ningun campo vacio");
        } else {
            usuarioBL = new UsuarioBL();
            if (usuarioBL.verificarUsuario(txtUsuario.getText(), new String(txtContraseña.getPassword()))) {
                Modelo.Usuario usuarioLogueado = UsuarioBL.usuario;
                if (usuarioLogueado != null) {
                    if (!usuarioLogueado.getEstado().equals("Activo")) {
                        JOptionPane.showMessageDialog(rootPane, "El usuario se encuentra inactivo.");
                    } else {
                        if (usuarioLogueado.getRol().equals("Administrador")) {
                            Administrador obj = new Administrador();
                            obj.setVisible(true);
                            dispose();
                        } else {
                            Encargado obj = new Encargado();
                            obj.setVisible(true);
                            dispose();
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecta");
            }
        }
        limpiarTexto();
    }//GEN-LAST:event_panelEntrarMouseClicked

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnEntrar.doClick();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited
        resetColor2(Salir);
    }//GEN-LAST:event_SalirMouseExited

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered
        setColor(Salir);
    }//GEN-LAST:event_SalirMouseEntered

    private void MinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseExited
        resetColor2(Minimizar);
    }//GEN-LAST:event_MinimizarMouseExited

    private void MinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseEntered
        setColor(Minimizar);
    }//GEN-LAST:event_MinimizarMouseEntered

    private void MoverConElCursorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoverConElCursorMousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_MoverConElCursorMousePressed

    private void MoverConElCursorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoverConElCursorMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_MoverConElCursorMouseDragged

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed
// cambiar color para el boton entrar

    public void setColorentrar(JPanel boton) {
        boton.setBackground(new java.awt.Color(0, 130, 240));
    }

    public void resetColorentrar(JPanel boton) {
        boton.setBackground(new java.awt.Color(0, 151, 247));
    }

// cambiar de color para el gestion
    public void setColor(JPanel boton) {
        boton.setBackground(new java.awt.Color(58, 71, 97));
    }

    public void resetColor(JPanel boton) {
        boton.setBackground(new java.awt.Color(33, 42, 58));
    }

    public void resetColor2(JPanel boton) {
        boton.setBackground(new java.awt.Color(37, 47, 67));
    }

    public void moradoNormal(JPanel boton) {
        boton.setBackground(new Color(77, 54, 218));
    }

    public void moradoOscuro(JPanel boton) {
        boton.setBackground(new Color(62, 38, 205));
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JPanel Minimizar;
    private javax.swing.JLabel MoverConElCursor;
    private javax.swing.JPanel Salir;
    private javax.swing.JLabel autor50;
    private javax.swing.JLabel autor51;
    private javax.swing.JLabel bibliotecav200;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnSalir2;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel iconoLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblEntrar;
    private javax.swing.JLabel lblEntrar1;
    private javax.swing.JLabel mobien;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelEntrar;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
