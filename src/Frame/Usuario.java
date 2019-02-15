package Frame;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import DAO.conexion;
import Negocio.RecursoBL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class Usuario extends javax.swing.JFrame {

    DefaultTableModel model;
    private RecursoBL recursoBL;

    public Usuario() {
        initComponents();
        recursoBL = new RecursoBL();

        this.setLocationRelativeTo(null);

        CargarTablaLibros();

        aniHome.setVisible(true);
        aniLibros.setVisible(false);
        aniCds.setVisible(false);

        aniRetroceder.setVisible(false);

        Retroceder.setVisible(false);
        Recursos.setVisible(false);
        NoDisponible.setVisible(false);
        Inicio.setVisible(true);
        panelMenu.setVisible(true);
    }
    //CARGAR AUTOMATICAMENTE LA TABLA LIBROS

    public void CargarTablaLibros() {
        // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] titulos = {"TIPO RECURSO", "CODIGO", "NOMBRE", "AUTOR", "ESTADO", "EDITORIAL", "DESCRIPCION"};
        String[] registros = new String[8];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = recursoBL.listarRecursos();
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Recursos recurso : recursos) {
                //registros[0] = String.valueOf(recurso.getIdRecurso());
                registros[0] = recurso.getTipoRecurso();
                registros[1] = recurso.getCodigo();
                registros[2] = recurso.getNombre();
                registros[3] = recurso.getAutor();
                //registros[4] = dateFormat.format(recurso.getFecha());
                registros[4] = recurso.getEstado();
                //registros[6] = recurso.getUbicacion();
                registros[5] = recurso.getEditorial();
                registros[6] = recurso.getDescripcion();

                model.addRow(registros);
            }
        }
        tbRecursos.setModel(model);
        tbRecursos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    //LIMPIAD TEXTOS
    void limpiarTexto() {
        txtBuscarRECURSO.setText(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        mobien = new javax.swing.JLabel();
        bibliotecav200 = new javax.swing.JLabel();
        aniHome = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        recursos = new javax.swing.JLabel();
        aniLibros = new javax.swing.JPanel();
        libros = new javax.swing.JLabel();
        aniCds = new javax.swing.JPanel();
        cds = new javax.swing.JLabel();
        aniRetroceder = new javax.swing.JPanel();
        retroceder = new javax.swing.JLabel();
        Inicio = new javax.swing.JPanel();
        titulo6 = new javax.swing.JLabel();
        buscarU3 = new javax.swing.JLabel();
        buscarU4 = new javax.swing.JLabel();
        buscarU5 = new javax.swing.JLabel();
        buscarU6 = new javax.swing.JLabel();
        buscarU7 = new javax.swing.JLabel();
        buscarU8 = new javax.swing.JLabel();
        buscarU9 = new javax.swing.JLabel();
        buscarU10 = new javax.swing.JLabel();
        buscarU12 = new javax.swing.JLabel();
        buscarU13 = new javax.swing.JLabel();
        buscarU14 = new javax.swing.JLabel();
        buscarU11 = new javax.swing.JLabel();
        buscarU15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Recursos = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRecursos = new javax.swing.JTable();
        txtBuscarRECURSO = new javax.swing.JTextField();
        buscarU1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        buscarU2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        NoDisponible = new javax.swing.JPanel();
        titulo2 = new javax.swing.JLabel();
        Retroceder = new javax.swing.JPanel();
        AvisoEmergente = new javax.swing.JPanel();
        tituloAE = new javax.swing.JLabel();
        tituloAE1 = new javax.swing.JLabel();
        ContraseñaAV = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelarAV = new javax.swing.JLabel();
        btnAceptarAV1 = new javax.swing.JLabel();
        btnAceptarAV2 = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(77, 54, 218));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobien.setBackground(new java.awt.Color(136, 120, 230));
        mobien.setFont(new java.awt.Font("Decker", 1, 35)); // NOI18N
        mobien.setForeground(new java.awt.Color(255, 255, 255));
        mobien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobien.setText("MOBIEM");
        mobien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelMenu.add(mobien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, 30));

        bibliotecav200.setBackground(new java.awt.Color(136, 120, 230));
        bibliotecav200.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        bibliotecav200.setForeground(new java.awt.Color(255, 255, 255));
        bibliotecav200.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bibliotecav200.setText("                  Biblioteca V2.0");
        bibliotecav200.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelMenu.add(bibliotecav200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 20));

        aniHome.setBackground(new java.awt.Color(214, 217, 224));

        javax.swing.GroupLayout aniHomeLayout = new javax.swing.GroupLayout(aniHome);
        aniHome.setLayout(aniHomeLayout);
        aniHomeLayout.setHorizontalGroup(
            aniHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        aniHomeLayout.setVerticalGroup(
            aniHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelMenu.add(aniHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 5, 40));

        home.setBackground(new java.awt.Color(136, 120, 230));
        home.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home90x20.png"))); // NOI18N
        home.setText("Inicio");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setOpaque(true);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        panelMenu.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 280, 40));

        recursos.setBackground(new java.awt.Color(136, 120, 230));
        recursos.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        recursos.setForeground(new java.awt.Color(255, 255, 51));
        recursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        recursos.setText("                  Categorias");
        recursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelMenu.add(recursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 280, 40));

        javax.swing.GroupLayout aniLibrosLayout = new javax.swing.GroupLayout(aniLibros);
        aniLibros.setLayout(aniLibrosLayout);
        aniLibrosLayout.setHorizontalGroup(
            aniLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        aniLibrosLayout.setVerticalGroup(
            aniLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelMenu.add(aniLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 5, 40));

        libros.setBackground(new java.awt.Color(77, 54, 218));
        libros.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        libros.setForeground(new java.awt.Color(255, 255, 255));
        libros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        libros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/libro115x20.png"))); // NOI18N
        libros.setText("Recursos");
        libros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libros.setOpaque(true);
        libros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                librosMouseClicked(evt);
            }
        });
        panelMenu.add(libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 40));

        javax.swing.GroupLayout aniCdsLayout = new javax.swing.GroupLayout(aniCds);
        aniCds.setLayout(aniCdsLayout);
        aniCdsLayout.setHorizontalGroup(
            aniCdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        aniCdsLayout.setVerticalGroup(
            aniCdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelMenu.add(aniCds, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 5, 40));

        cds.setBackground(new java.awt.Color(77, 54, 218));
        cds.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cds.setForeground(new java.awt.Color(255, 255, 255));
        cds.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cds115x20.png"))); // NOI18N
        cds.setText("No disponible");
        cds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cds.setOpaque(true);
        cds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cdsMouseClicked(evt);
            }
        });
        panelMenu.add(cds, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 280, 40));

        javax.swing.GroupLayout aniRetrocederLayout = new javax.swing.GroupLayout(aniRetroceder);
        aniRetroceder.setLayout(aniRetrocederLayout);
        aniRetrocederLayout.setHorizontalGroup(
            aniRetrocederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        aniRetrocederLayout.setVerticalGroup(
            aniRetrocederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelMenu.add(aniRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 5, 40));

        retroceder.setBackground(new java.awt.Color(62, 38, 205));
        retroceder.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        retroceder.setForeground(new java.awt.Color(255, 255, 255));
        retroceder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        retroceder.setText("                  Retroceder");
        retroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retroceder.setOpaque(true);
        retroceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retrocederMouseClicked(evt);
            }
        });
        panelMenu.add(retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 280, 40));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 700));

        Inicio.setBackground(new java.awt.Color(214, 217, 224));
        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo6.setBackground(new java.awt.Color(255, 255, 255));
        titulo6.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        titulo6.setForeground(new java.awt.Color(103, 104, 112));
        titulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo6.setText("INICIO");
        Inicio.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        buscarU3.setBackground(new java.awt.Color(255, 255, 255));
        buscarU3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscarU3.setForeground(new java.awt.Color(103, 104, 112));
        buscarU3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarU3.setText("Cristian Alexis Losada Quibano");
        Inicio.add(buscarU3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1000, 20));

        buscarU4.setBackground(new java.awt.Color(255, 255, 255));
        buscarU4.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        buscarU4.setForeground(new java.awt.Color(103, 104, 112));
        buscarU4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU4.setText("Bienvenidos al sistema MOBIEM ");
        Inicio.add(buscarU4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1020, 30));

        buscarU5.setBackground(new java.awt.Color(255, 255, 255));
        buscarU5.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU5.setForeground(new java.awt.Color(103, 104, 112));
        buscarU5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU5.setText("Si deseas hacer uso de los recursos bibliotecarios");
        Inicio.add(buscarU5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1020, 30));

        buscarU6.setBackground(new java.awt.Color(255, 255, 255));
        buscarU6.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU6.setForeground(new java.awt.Color(103, 104, 112));
        buscarU6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU6.setText("solo tienes que dar clic en la siguiente opción (recursos)");
        Inicio.add(buscarU6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1020, 30));

        buscarU7.setBackground(new java.awt.Color(255, 255, 255));
        buscarU7.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU7.setForeground(new java.awt.Color(103, 104, 112));
        buscarU7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU7.setText("y previamente buscar el recurso de tu interés");
        Inicio.add(buscarU7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1020, 30));

        buscarU8.setBackground(new java.awt.Color(255, 255, 255));
        buscarU8.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU8.setForeground(new java.awt.Color(103, 104, 112));
        buscarU8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU8.setText("como te indica la pantalla (recursos).");
        Inicio.add(buscarU8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1020, 30));

        buscarU9.setBackground(new java.awt.Color(255, 255, 255));
        buscarU9.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU9.setForeground(new java.awt.Color(103, 104, 112));
        buscarU9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU9.setText("Una ves sepas el recurso de tu interés");
        Inicio.add(buscarU9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1020, 30));

        buscarU10.setBackground(new java.awt.Color(255, 255, 255));
        buscarU10.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU10.setForeground(new java.awt.Color(103, 104, 112));
        buscarU10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU10.setText("solo tienes que memorizarte el código del recurso");
        Inicio.add(buscarU10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 1020, 30));

        buscarU12.setBackground(new java.awt.Color(255, 255, 255));
        buscarU12.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscarU12.setForeground(new java.awt.Color(103, 104, 112));
        buscarU12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarU12.setText("Copyright: Institucion Universitaria Colegio Mayor Del Cauca");
        Inicio.add(buscarU12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1000, 20));

        buscarU13.setBackground(new java.awt.Color(255, 255, 255));
        buscarU13.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU13.setForeground(new java.awt.Color(103, 104, 112));
        buscarU13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UsuariosEstudiantes.png"))); // NOI18N
        Inicio.add(buscarU13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 110, 100));

        buscarU14.setBackground(new java.awt.Color(255, 255, 255));
        buscarU14.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU14.setForeground(new java.awt.Color(103, 104, 112));
        buscarU14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU14.setText("y mencionar al bibliotecario, el se encargara de hacer el respectivo prestamo.");
        Inicio.add(buscarU14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1020, 30));

        buscarU11.setBackground(new java.awt.Color(255, 255, 255));
        buscarU11.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscarU11.setForeground(new java.awt.Color(103, 104, 112));
        buscarU11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarU11.setText("Software Developer: Javier Estiven Meneses Erazo");
        Inicio.add(buscarU11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1000, -1));

        buscarU15.setBackground(new java.awt.Color(255, 255, 255));
        buscarU15.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU15.setForeground(new java.awt.Color(103, 104, 112));
        buscarU15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/flecha morada.png"))); // NOI18N
        Inicio.add(buscarU15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 50, 570, 290));

        jPanel1.setBackground(new java.awt.Color(203, 205, 209));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo unimayor.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(838, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(75, 75, 75))
        );

        Inicio.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1020, 620));

        getContentPane().add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1020, 700));

        Recursos.setBackground(new java.awt.Color(214, 217, 224));
        Recursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo1.setBackground(new java.awt.Color(255, 255, 255));
        titulo1.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        titulo1.setForeground(new java.awt.Color(103, 104, 112));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("RECURSOS BIBLIOTECARIOS");
        Recursos.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jScrollPane1.setOpaque(false);

        tbRecursos.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbRecursos.setForeground(new java.awt.Color(33, 42, 58));
        tbRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Titulo", "Autor", "Año", "Estado"
            }
        ));
        tbRecursos.setGridColor(new java.awt.Color(136, 120, 230));
        tbRecursos.setSelectionBackground(new java.awt.Color(136, 120, 230));
        tbRecursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbRecursos);

        Recursos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 247, 1020, 460));

        txtBuscarRECURSO.setBackground(new java.awt.Color(153, 51, 0));
        txtBuscarRECURSO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscarRECURSO.setForeground(new java.awt.Color(103, 104, 112));
        txtBuscarRECURSO.setText("Clic aqui para buscar   *");
        txtBuscarRECURSO.setBorder(null);
        txtBuscarRECURSO.setOpaque(false);
        txtBuscarRECURSO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarRECURSOMouseClicked(evt);
            }
        });
        txtBuscarRECURSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarRECURSOKeyReleased(evt);
            }
        });
        Recursos.add(txtBuscarRECURSO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 590, 30));

        buscarU1.setBackground(new java.awt.Color(255, 255, 255));
        buscarU1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscarU1.setForeground(new java.awt.Color(103, 104, 112));
        buscarU1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU1.setText("RECUERDA memorizar el codigo del libro de tu interes");
        Recursos.add(buscarU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1020, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar.png"))); // NOI18N
        Recursos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 330, 30));

        jSeparator3.setBackground(new java.awt.Color(214, 217, 224));
        jSeparator3.setForeground(new java.awt.Color(103, 104, 112));
        Recursos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 630, 20));

        buscarU2.setBackground(new java.awt.Color(255, 255, 255));
        buscarU2.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        buscarU2.setForeground(new java.awt.Color(103, 104, 112));
        buscarU2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarU2.setText("Buscar por: codigo, nombre, autor, estado, editorial o descripcion");
        Recursos.add(buscarU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1020, 30));

        jPanel2.setBackground(new java.awt.Color(203, 205, 209));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        Recursos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1020, 620));

        getContentPane().add(Recursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1020, 700));

        NoDisponible.setBackground(new java.awt.Color(214, 217, 224));
        NoDisponible.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo2.setBackground(new java.awt.Color(255, 255, 255));
        titulo2.setFont(new java.awt.Font("Decker", 1, 36)); // NOI18N
        titulo2.setForeground(new java.awt.Color(103, 104, 112));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("No disponible");
        NoDisponible.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 80));

        getContentPane().add(NoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1020, 700));

        Retroceder.setBackground(new java.awt.Color(214, 217, 224));
        Retroceder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AvisoEmergente.setBackground(new java.awt.Color(255, 255, 255));
        AvisoEmergente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloAE.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tituloAE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloAE.setText("Solo los administradores pueden retroceder ");
        AvisoEmergente.add(tituloAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 430, -1));

        tituloAE1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tituloAE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloAE1.setText("por favor ingresa la contraseña");
        AvisoEmergente.add(tituloAE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 430, -1));

        ContraseñaAV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ContraseñaAV.setBorder(null);
        ContraseñaAV.setSelectionColor(new java.awt.Color(77, 54, 218));
        ContraseñaAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContraseñaAVKeyTyped(evt);
            }
        });
        AvisoEmergente.add(ContraseñaAV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(77, 54, 218));
        jSeparator1.setForeground(new java.awt.Color(77, 54, 218));
        AvisoEmergente.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 310, 10));

        btnCancelarAV.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarAV.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnCancelarAV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelarAV.setText("CANCELAR");
        btnCancelarAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelarAV.setOpaque(true);
        btnCancelarAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarAVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarAVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarAVMouseExited(evt);
            }
        });
        AvisoEmergente.add(btnCancelarAV, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 30));

        btnAceptarAV1.setBackground(new java.awt.Color(77, 54, 218));
        btnAceptarAV1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnAceptarAV1.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarAV1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptarAV1.setText("ACEPTAR");
        btnAceptarAV1.setOpaque(true);
        btnAceptarAV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarAV1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarAV1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarAV1MouseExited(evt);
            }
        });
        AvisoEmergente.add(btnAceptarAV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, 30));

        btnAceptarAV2.setBorderPainted(false);
        btnAceptarAV2.setContentAreaFilled(false);
        btnAceptarAV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAV2ActionPerformed(evt);
            }
        });
        AvisoEmergente.add(btnAceptarAV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, 30));

        Retroceder.add(AvisoEmergente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 430, 150));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Escritorio borroso.png"))); // NOI18N
        Retroceder.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 700));

        getContentPane().add(Retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        //cambio de color entre los botones estiquetas
        setLblColor(home);
        resetLblColor(libros);
        resetLblColor(cds);

        colorRetroceder(retroceder);
        //mostrar o hacer invisible el ani
        aniHome.setVisible(true);
        aniLibros.setVisible(false);
        aniCds.setVisible(false);

        aniRetroceder.setVisible(false);
        //al hacer clic me lleve a otra ventana
        Inicio.setVisible(true);
        Recursos.setVisible(false);
        NoDisponible.setVisible(false);
        Retroceder.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void retrocederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retrocederMouseClicked
        //cambio de color entre los botones estiquetas
        setLblColor(retroceder);
        resetLblColor(libros);
        resetLblColor(cds);
        resetLblColor(home);
        //mostrar o hacer invisible el ani
        aniHome.setVisible(false);
        aniLibros.setVisible(false);
        aniCds.setVisible(false);

        aniRetroceder.setVisible(true);
        //al hacer clic me lleve a otra ventana
        Inicio.setVisible(false);
        Recursos.setVisible(false);
        NoDisponible.setVisible(false);
        panelMenu.setVisible(false);
        Retroceder.setVisible(true);

    }//GEN-LAST:event_retrocederMouseClicked

    private void btnCancelarAVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarAVMouseClicked
        //al hacer clic me lleve a otra ventana
        /*panelMenu.setVisible(true);
        RetrocederNada.setVisible(true);
        Retroceder.setVisible(false);**/

        Usuario obj = new Usuario();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarAVMouseClicked

    private void btnAceptarAV1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarAV1MouseEntered
        //al pasar el mouse que ponga un color
        setLblColor(btnAceptarAV1);
    }//GEN-LAST:event_btnAceptarAV1MouseEntered

    private void btnAceptarAV1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarAV1MouseExited
        //al salie el mouse que ponga un color
        colorRetroceder(btnAceptarAV1);
    }//GEN-LAST:event_btnAceptarAV1MouseExited

    private void btnCancelarAVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarAVMouseEntered
        //al pasar el mouse que ponga un color
        colorGris(btnCancelarAV);
    }//GEN-LAST:event_btnCancelarAVMouseEntered

    private void btnCancelarAVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarAVMouseExited
        //al salie el mouse que ponga un color
        colorBlanco(btnCancelarAV);
    }//GEN-LAST:event_btnCancelarAVMouseExited

    private void btnAceptarAV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarAV1MouseClicked
        // que me lleve atras
        if (String.valueOf(ContraseñaAV.getPassword()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(rootPane, "No puede dejar ningun campo vacio");
        } else {
            if (String.valueOf(ContraseñaAV.getPassword()).compareTo("admin") == 0) {
                LoginPrincipal obj = new LoginPrincipal();
                obj.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta");
            }

        }
    }//GEN-LAST:event_btnAceptarAV1MouseClicked

    private void txtBuscarRECURSOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarRECURSOMouseClicked
        limpiarTexto();
    }//GEN-LAST:event_txtBuscarRECURSOMouseClicked

    private void ContraseñaAVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaAVKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAceptarAV2.doClick();
        }
    }//GEN-LAST:event_ContraseñaAVKeyTyped

    private void btnAceptarAV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAV2ActionPerformed
        // que me lleve atras
        if (String.valueOf(ContraseñaAV.getPassword()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(rootPane, "No puede dejar ningun campo vacio");
        } else {
            if (String.valueOf(ContraseñaAV.getPassword()).compareTo("admin") == 0) {
                LoginPrincipal obj = new LoginPrincipal();
                obj.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta");
            }

        }
    }//GEN-LAST:event_btnAceptarAV2ActionPerformed

    private void txtBuscarRECURSOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRECURSOKeyReleased
        if (txtBuscarRECURSO.getText().isEmpty()) {
            CargarTablaLibros();
        } else {
            String[] titulos = {"TIPO RECURSO", "CODIGO", "NOMBRE", "AUTOR", "ESTADO", "EDITORIAL", "DESCRIPCION"};
            String[] registros = new String[8];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Recursos recursoBusqueda = new Modelo.Recursos();
            recursoBusqueda.setCodigo(txtBuscarRECURSO.getText());
            recursoBusqueda.setNombre(txtBuscarRECURSO.getText());
            recursoBusqueda.setDescripcion(txtBuscarRECURSO.getText());
            recursoBusqueda.setTipoRecurso(txtBuscarRECURSO.getText());
            recursoBusqueda.setAutor(txtBuscarRECURSO.getText());
            recursoBusqueda.setEstado(txtBuscarRECURSO.getText());
            recursoBusqueda.setUbicacion(txtBuscarRECURSO.getText());
            recursoBusqueda.setEditorial(txtBuscarRECURSO.getText());

            List resultado = recursoBL.buscarRecursos(recursoBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Recursos recurso : recursos) {
                    //registros[0] = String.valueOf(recurso.getIdRecurso());
                    //registros[0] = String.valueOf(recurso.getIdRecurso());
                    registros[0] = recurso.getTipoRecurso();
                    registros[1] = recurso.getCodigo();
                    registros[2] = recurso.getNombre();
                    registros[3] = recurso.getAutor();
                    //registros[4] = dateFormat.format(recurso.getFecha());
                    registros[4] = recurso.getEstado();
                    //registros[6] = recurso.getUbicacion();
                    registros[5] = recurso.getEditorial();
                    registros[6] = recurso.getDescripcion();

                    model.addRow(registros);
                }
            }
            tbRecursos.setModel(model);
        }
    }//GEN-LAST:event_txtBuscarRECURSOKeyReleased

    private void librosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_librosMouseClicked
        //cambio de color entre los botones estiquetas
        setLblColor(libros);
        resetLblColor(home);
        resetLblColor(cds);

        colorRetroceder(retroceder);
        //mostrar o hacer invisible el ani
        aniHome.setVisible(false);
        aniLibros.setVisible(true);
        aniCds.setVisible(false);

        aniRetroceder.setVisible(false);
        //al hacer clic me lleve a otra ventana
        Inicio.setVisible(false);
        Recursos.setVisible(true);
        NoDisponible.setVisible(false);
        Retroceder.setVisible(false);
    }//GEN-LAST:event_librosMouseClicked

    private void cdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdsMouseClicked
        //cambio de color entre los botones estiquetas
        setLblColor(cds);
        resetLblColor(libros);
        resetLblColor(home);

        colorRetroceder(retroceder);
        //mostrar o hacer invisible el ani
        aniHome.setVisible(false);
        aniLibros.setVisible(false);
        aniCds.setVisible(true);

        aniRetroceder.setVisible(false);
        //al hacer clic me lleve a otra ventana
        Inicio.setVisible(false);
        Recursos.setVisible(false);
        NoDisponible.setVisible(true);
        Retroceder.setVisible(false);
    }//GEN-LAST:event_cdsMouseClicked
    // cambiar de color para el menu pero solo en los botones
    public void setLblColor(JLabel lbl) {
        lbl.setBackground(new Color(136, 120, 230));
    }

    public void resetLblColor(JLabel lbl) {
        lbl.setBackground(new Color(77, 54, 218));
    }

    public void colorRetroceder(JLabel lbl) {
        lbl.setBackground(new Color(62, 38, 205));
    }

    public void colorBlanco(JLabel lbl) {
        lbl.setBackground(new Color(255, 255, 255));
    }

    public void colorGris(JLabel lbl) {
        lbl.setBackground(new Color(214, 217, 224));
    }

    public void colorGrisOscuro(JLabel lbl) {
        lbl.setBackground(new Color(186, 191, 202));
    }

    public void colorGris(JPanel lbl) {
        lbl.setBackground(new Color(214, 217, 224));
    }

    public void colorGrisOscuro(JPanel lbl) {
        lbl.setBackground(new Color(186, 191, 202));
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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AvisoEmergente;
    private javax.swing.JPasswordField ContraseñaAV;
    private javax.swing.JPanel Inicio;
    private javax.swing.JPanel NoDisponible;
    private javax.swing.JPanel Recursos;
    private javax.swing.JPanel Retroceder;
    private javax.swing.JPanel aniCds;
    private javax.swing.JPanel aniHome;
    private javax.swing.JPanel aniLibros;
    private javax.swing.JPanel aniRetroceder;
    private javax.swing.JLabel bibliotecav200;
    private javax.swing.JLabel btnAceptarAV1;
    private javax.swing.JButton btnAceptarAV2;
    private javax.swing.JLabel btnCancelarAV;
    private javax.swing.JLabel buscarU1;
    private javax.swing.JLabel buscarU10;
    private javax.swing.JLabel buscarU11;
    private javax.swing.JLabel buscarU12;
    private javax.swing.JLabel buscarU13;
    private javax.swing.JLabel buscarU14;
    private javax.swing.JLabel buscarU15;
    private javax.swing.JLabel buscarU2;
    private javax.swing.JLabel buscarU3;
    private javax.swing.JLabel buscarU4;
    private javax.swing.JLabel buscarU5;
    private javax.swing.JLabel buscarU6;
    private javax.swing.JLabel buscarU7;
    private javax.swing.JLabel buscarU8;
    private javax.swing.JLabel buscarU9;
    private javax.swing.JLabel cds;
    private javax.swing.JLabel home;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel libros;
    private javax.swing.JLabel mobien;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel recursos;
    private javax.swing.JLabel retroceder;
    private javax.swing.JTable tbRecursos;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel tituloAE;
    private javax.swing.JLabel tituloAE1;
    private javax.swing.JTextField txtBuscarRECURSO;
    // End of variables declaration//GEN-END:variables
    conexion cc = new conexion();
    Connection conect = cc.obtenerConexion();

}
