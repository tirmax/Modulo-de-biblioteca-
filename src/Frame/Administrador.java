package Frame;

import Modelo.Recursos;
import com.sun.awt.AWTUtilities;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Negocio.UsuarioBL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Administrador extends javax.swing.JFrame {

    int x, y;
    DefaultTableModel model;
    private UsuarioBL usuarioBL;
    private int idUsuarioSeleccionado = -1;
    private String fechaRegistro;

    public void Cargar() {
        String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] registros = new String[8];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = usuarioBL.listarUsuarios();
        if (resultado != null && resultado.size() > 0) {
            ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Usuario usuario : usuarios) {
                registros[0] = String.valueOf(usuario.getIdUsuario());
                registros[1] = usuario.getNombres();
                registros[2] = usuario.getApellidos();
                registros[3] = dateFormat.format(usuario.getFechaRegistro());
                registros[4] = usuario.getCodigo();
                registros[5] = usuario.getConatrseña();
                registros[6] = usuario.getRol();
                registros[7] = usuario.getEstado();

                model.addRow(registros);
            }
        }
        tbAdministrador.setModel(model);
        tbAdministrador.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new Date()));
        txtCodigo.setText("");
        txtContraseña.setText("");
        cbRol.setSelectedIndex(0);
        cbEstado.setSelectedIndex(0);
    }

    public Administrador() {
        usuarioBL = new UsuarioBL();
        initComponents();
        Cargar();
        if (UsuarioBL.usuario != null) {
            lblUsuarioNombre.setText(UsuarioBL.usuario.getNombres() + " " + UsuarioBL.usuario.getApellidos());
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new Date()));
        limpiar();
        tbAdministrador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
                if (tbAdministrador.getRowCount() > 0 && tbAdministrador.getSelectedRow() != -1) {
                    idUsuarioSeleccionado = Integer.parseInt(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 0).toString());
                    txtNombre.setText(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 1).toString());
                    txtApellido.setText(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 2).toString());
                    txtFechaDeRegistro.setText(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 3).toString());
                    txtCodigo.setText(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 4).toString());
                    txtContraseña.setText(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 5).toString());
                    cbRol.setSelectedItem(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 6).toString());
                    cbEstado.setSelectedItem(tbAdministrador.getValueAt(tbAdministrador.getSelectedRow(), 7).toString());
                }
            }
        });
        AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        Minimizar = new javax.swing.JPanel();
        btnSalir2 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        MoverConElCursor = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        lblUsuarioNombre = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtApellido = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        codigo1 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        año1 = new javax.swing.JLabel();
        estado1 = new javax.swing.JLabel();
        txtFechaDeRegistro = new javax.swing.JTextField();
        autor2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        cbRol = new javax.swing.JComboBox<>();
        estado2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        autor3 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btnModificar = new javax.swing.JButton();
        autor52 = new javax.swing.JLabel();
        autor53 = new javax.swing.JLabel();
        autor56 = new javax.swing.JLabel();
        autor57 = new javax.swing.JLabel();
        autor58 = new javax.swing.JLabel();
        autor59 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        buscar = new javax.swing.JLabel();
        spAdministrador = new javax.swing.JScrollPane();
        tbAdministrador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1079, 0, -1, -1));

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

        getContentPane().add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1036, 0, -1, -1));

        btnCerrarSesion.setBackground(new java.awt.Color(33, 42, 58));
        btnCerrarSesion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(33, 42, 58));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -1, 140, 30));

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
        getContentPane().add(MoverConElCursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        panelPrincipal.setBackground(new java.awt.Color(37, 47, 67));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuarioNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuarioNombre.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lblUsuarioNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioNombre.setText("Usuario");
        panelPrincipal.add(lblUsuarioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 1120, -1));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Administrador");
        panelPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        jPanel2.setBackground(new java.awt.Color(33, 42, 58));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtApellido.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 240, 20));

        txtCodigo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 240, 20));

        txtNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 240, 20));

        codigo1.setBackground(new java.awt.Color(255, 255, 255));
        codigo1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        codigo1.setForeground(new java.awt.Color(255, 255, 255));
        codigo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigo1.setText("Rol");
        jPanel2.add(codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 110, 20));

        titulo1.setBackground(new java.awt.Color(255, 255, 255));
        titulo1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Nombres");
        jPanel2.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 110, 20));

        año1.setBackground(new java.awt.Color(255, 255, 255));
        año1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        año1.setForeground(new java.awt.Color(255, 255, 255));
        año1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        año1.setText("Apellidos");
        jPanel2.add(año1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 110, 20));

        estado1.setBackground(new java.awt.Color(255, 255, 255));
        estado1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado1.setForeground(new java.awt.Color(255, 255, 255));
        estado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado1.setText("Estado");
        jPanel2.add(estado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 110, 20));

        txtFechaDeRegistro.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaDeRegistro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jPanel2.add(txtFechaDeRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 240, 20));

        autor2.setBackground(new java.awt.Color(255, 255, 255));
        autor2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor2.setForeground(new java.awt.Color(255, 255, 255));
        autor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor2.setText("Fecha de registro");
        jPanel2.add(autor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 20));

        cbEstado.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel2.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 240, 20));

        cbRol.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encargado", "Administrador" }));
        jPanel2.add(cbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 240, 20));

        estado2.setBackground(new java.awt.Color(255, 255, 255));
        estado2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado2.setForeground(new java.awt.Color(255, 255, 255));
        estado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado2.setText("Contraseña");
        jPanel2.add(estado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 110, 20));

        btnRegistrar.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistrar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 240, 20));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setToolTipText("");
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 240, 10));

        btnEliminar.setBackground(new java.awt.Color(33, 42, 58));
        btnEliminar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(33, 42, 58));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 120, 20));

        autor3.setBackground(new java.awt.Color(255, 255, 255));
        autor3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor3.setForeground(new java.awt.Color(255, 255, 255));
        autor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor3.setText("Codigo");
        jPanel2.add(autor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 20));
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 240, -1));

        btnModificar.setBackground(new java.awt.Color(33, 42, 58));
        btnModificar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(33, 42, 58));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setBorderPainted(false);
        btnModificar.setFocusable(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 110, -1));

        autor52.setBackground(new java.awt.Color(255, 255, 255));
        autor52.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor52.setForeground(new java.awt.Color(255, 255, 255));
        autor52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor52.setText("*");
        jPanel2.add(autor52, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 20, 20));

        autor53.setBackground(new java.awt.Color(255, 255, 255));
        autor53.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor53.setForeground(new java.awt.Color(255, 255, 255));
        autor53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor53.setText("*");
        jPanel2.add(autor53, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 20, 20));

        autor56.setBackground(new java.awt.Color(255, 255, 255));
        autor56.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor56.setForeground(new java.awt.Color(255, 255, 255));
        autor56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor56.setText("*");
        jPanel2.add(autor56, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 20, 20));

        autor57.setBackground(new java.awt.Color(255, 255, 255));
        autor57.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor57.setForeground(new java.awt.Color(255, 255, 255));
        autor57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor57.setText("*");
        jPanel2.add(autor57, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 20, 20));

        autor58.setBackground(new java.awt.Color(255, 255, 255));
        autor58.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor58.setForeground(new java.awt.Color(255, 255, 255));
        autor58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor58.setText("*");
        jPanel2.add(autor58, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 20, 20));

        autor59.setBackground(new java.awt.Color(255, 255, 255));
        autor59.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor59.setForeground(new java.awt.Color(255, 255, 255));
        autor59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor59.setText("*");
        jPanel2.add(autor59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 20, 20));

        panelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1120, 200));

        txtBuscar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        panelPrincipal.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 240, 20));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar.setText("Buscar");
        panelPrincipal.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 110, 20));

        spAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        spAdministrador.setBorder(null);
        spAdministrador.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbAdministrador.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbAdministrador.setForeground(new java.awt.Color(33, 42, 58));
        tbAdministrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Fecha de registro", "Codigo", "Contraseña", "Rol", "Estado"
            }
        ));
        tbAdministrador.setFocusable(false);
        tbAdministrador.setGridColor(new java.awt.Color(0, 151, 247));
        tbAdministrador.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbAdministrador.getTableHeader().setReorderingAllowed(false);
        spAdministrador.setViewportView(tbAdministrador);

        panelPrincipal.add(spAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1120, 240));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea cerrar el programa", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalirMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        resetColor2(Minimizar);
        this.setState(Administrador.ICONIFIED);

    }//GEN-LAST:event_MinimizarMouseClicked

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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Esta seguro que desea cerrar sesión", "Cerrar sesión", dialog);
        if (result == 0) {
            UsuarioBL.usuario = null;
            LoginPrincipal obj = new LoginPrincipal();
            obj.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (usuarioBL.validarCodigoUsuario(txtCodigo.getText(), null)) {
            Modelo.Usuario usuario = new Modelo.Usuario();
            usuario.setNombres(txtNombre.getText());
            usuario.setApellidos(txtApellido.getText());
            usuario.setCodigo(txtCodigo.getText());
            usuario.setFechaRegistro(new java.sql.Timestamp(new Date().getTime()));
            usuario.setConatrseña(new String(txtContraseña.getPassword()));
            if (cbEstado.getSelectedItem() != null) {
                usuario.setEstado(cbEstado.getSelectedItem().toString());
            } else {
                usuario.setEstado("Activo");
            }
            if (cbRol.getSelectedItem() != null) {
                usuario.setRol(cbRol.getSelectedItem().toString());
            } else {
                usuario.setRol("Encargado");
            }
            Boolean resultado = usuarioBL.guardarUsuario(usuario);
            if (resultado) {
                Cargar();
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigo.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (tbAdministrador.getSelectedRow() != -1) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro usted seguro de eliminar el usuario: " + txtCodigo.getText() + " ?.", "Salir", dialog);
            if (result == 0) {
                Modelo.Usuario usuario = new Modelo.Usuario();
                usuario.setIdUsuario(idUsuarioSeleccionado);
                Boolean resultado = usuarioBL.eliminarUsuario(usuario);
                if (resultado) {
                    Cargar();
                    limpiar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (usuarioBL.validarCodigoUsuario(txtCodigo.getText(), idUsuarioSeleccionado)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Usuario usuario = new Modelo.Usuario();
                usuario.setIdUsuario(idUsuarioSeleccionado);
                usuario.setNombres(txtNombre.getText());
                usuario.setApellidos(txtApellido.getText());
                usuario.setCodigo(txtCodigo.getText());
                usuario.setFechaRegistro(new java.sql.Timestamp(dateFormat.parse(txtFechaDeRegistro.getText()).getTime()));
                usuario.setConatrseña(new String(txtContraseña.getPassword()));
                if (cbEstado.getSelectedItem() != null) {
                    usuario.setEstado(cbEstado.getSelectedItem().toString());
                } else {
                    usuario.setEstado("Activo");
                }
                if (cbRol.getSelectedItem() != null) {
                    usuario.setRol(cbRol.getSelectedItem().toString());
                } else {
                    usuario.setRol("Encargado");
                }
                Boolean resultado = usuarioBL.modificarUsuario(usuario);
                if (resultado) {
                    Cargar();
                    limpiar();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigo.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (txtBuscar.getText().isEmpty()) {
            Cargar();
        } else {
            String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
            String[] registros = new String[8];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Usuario usuarioBusqueda = new Modelo.Usuario();
            usuarioBusqueda.setNombres(txtBuscar.getText());
            usuarioBusqueda.setApellidos(txtBuscar.getText());
            usuarioBusqueda.setCodigo(txtBuscar.getText());
            List resultado = usuarioBL.buscarUsuarios(usuarioBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Usuario usuario : usuarios) {
                    registros[0] = String.valueOf(usuario.getIdUsuario());
                    registros[1] = usuario.getNombres();
                    registros[2] = usuario.getApellidos();
                    registros[3] = dateFormat.format(usuario.getFechaRegistro());
                    registros[4] = usuario.getCodigo();
                    registros[5] = usuario.getConatrseña();
                    registros[6] = usuario.getRol();
                    registros[7] = usuario.getEstado();

                    model.addRow(registros);
                }
            }
            tbAdministrador.setModel(model);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Minimizar;
    private javax.swing.JLabel MoverConElCursor;
    private javax.swing.JPanel Salir;
    private javax.swing.JLabel autor2;
    private javax.swing.JLabel autor3;
    private javax.swing.JLabel autor52;
    private javax.swing.JLabel autor53;
    private javax.swing.JLabel autor56;
    private javax.swing.JLabel autor57;
    private javax.swing.JLabel autor58;
    private javax.swing.JLabel autor59;
    private javax.swing.JLabel año1;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnSalir2;
    private javax.swing.JLabel buscar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel estado1;
    private javax.swing.JLabel estado2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane spAdministrador;
    private javax.swing.JTable tbAdministrador;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtFechaDeRegistro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
