package Frame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import DAO.conexion;
import Modelo.Recursos;
import Negocio.RecursoBL;
import Negocio.PrestamoBL;
import Negocio.UsuarioBL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

public class Encargado extends javax.swing.JFrame {

    int x, y;

    DefaultTableModel model;
    DefaultTableModel model2;
    int idRecursoSeleccionado = -1;
    int idPrestamoSeleccionado = -1;
    String opcion = "Libros";
    private RecursoBL recursoBL;
    private PrestamoBL prestamoBL;

    //carga automaticamente la tabla libros 
    public void CargarTablaLibros() {
        // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] titulos = {"ID", "TIPO RECURSO", "CODIGO", "TITULO", "AUTOR", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "EDITORIAL", "DESCRIPCION"};
        String[] registros = new String[10];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = recursoBL.listarRecursos("LIBRO");
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Recursos recurso : recursos) {
                registros[0] = String.valueOf(recurso.getIdRecurso());
                registros[1] = recurso.getTipoRecurso();
                registros[2] = recurso.getCodigo();
                registros[3] = recurso.getNombre();
                registros[4] = recurso.getAutor();
                registros[5] = dateFormat.format(recurso.getFecha());
                registros[6] = recurso.getEstado();
                registros[7] = recurso.getUbicacion();
                registros[8] = recurso.getEditorial();
                registros[9] = recurso.getDescripcion();

                model.addRow(registros);
            }
        }
        tbLibros.setModel(model);
        tbLibros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void CargarTablacd() {
        // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
        String[] registros = new String[8];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = recursoBL.listarRecursos("CD");
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Recursos recurso : recursos) {
                registros[0] = String.valueOf(recurso.getIdRecurso());
                registros[1] = recurso.getTipoRecurso();
                registros[2] = recurso.getCodigo();
                registros[3] = recurso.getNombre();
                registros[4] = dateFormat.format(recurso.getFecha());
                registros[5] = recurso.getEstado();
                registros[6] = recurso.getUbicacion();
                registros[7] = recurso.getDescripcion();

                model.addRow(registros);
            }
        }
        tbCDS.setModel(model);
        tbCDS.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void CargarTablaREVISTAS() {
        // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
        String[] registros = new String[8];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = recursoBL.listarRecursos("REVISTA");
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Recursos recurso : recursos) {
                registros[0] = String.valueOf(recurso.getIdRecurso());
                registros[1] = recurso.getTipoRecurso();
                registros[2] = recurso.getCodigo();
                registros[3] = recurso.getNombre();
                registros[4] = dateFormat.format(recurso.getFecha());
                registros[5] = recurso.getEstado();
                registros[6] = recurso.getUbicacion();
                registros[7] = recurso.getDescripcion();

                model.addRow(registros);
            }
        }
        tbREVISTAS.setModel(model);
        tbREVISTAS.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void CargarTablaOTROS() {
        // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
        String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
        String[] registros = new String[8];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = recursoBL.listarRecursos("OTRO");
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Recursos recurso : recursos) {
                registros[0] = String.valueOf(recurso.getIdRecurso());
                registros[1] = recurso.getTipoRecurso();
                registros[2] = recurso.getCodigo();
                registros[3] = recurso.getNombre();
                registros[4] = dateFormat.format(recurso.getFecha());
                registros[5] = recurso.getEstado();
                registros[6] = recurso.getUbicacion();
                registros[7] = recurso.getDescripcion();

                model.addRow(registros);
            }
        }
        tbOTROS.setModel(model);
        tbOTROS.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void CargarTablaPRESTAMO() {
        String[] titulos = {"ID PRESTAMO", "CODIGO RECURSO", "CODIGO DEL ESTUDIANTE", "FECHA DE PRESTAMO", "FECHA DE DEVOLUCION", "ESTADO", "PRESTADO POR", "RECIBIDO POR", "APELLIDO", "DIAS DE PRESTACION"};
        String[] registros = new String[10];

        model = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setRowCount(0);
        List resultado = prestamoBL.buscarPrestamo(null);
        if (resultado != null && resultado.size() > 0) {
            //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
            ArrayList<Modelo.Prestamo> prestamos = (ArrayList<Modelo.Prestamo>) resultado;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Modelo.Prestamo prestamo : prestamos) {
                registros[0] = String.valueOf(prestamo.getIdPrestamo());
                registros[1] = String.valueOf(prestamo.getCodigoRecurso());
                registros[2] = String.valueOf(prestamo.getCodEstudiante());
                registros[3] = dateFormat.format(prestamo.getFechaPrestamo());
                registros[4] = dateFormat.format(prestamo.getFechaDevolucion());
                registros[5] = prestamo.getEstado();
                registros[6] = String.valueOf(prestamo.getNombreUsuarioEntrega());
                registros[7] = String.valueOf(prestamo.getNombreUsuarioSalida());
                registros[8] = prestamo.getApellido();
                registros[9] = String.valueOf(prestamo.getDiasPrestacion());
                

                model.addRow(registros);
            }
        }
        tbPRESTAMO.setModel(model);
        tbPRESTAMO.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    //limpia las casilla de los textos de libros
    public void limpiarTextoLibro() {
        txtTitulo.setText("");
        txtAutor.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new java.util.Date()));
        txtCodigo.setText("");
        txtEditorial.setText("");
        txtUbicacion.setText("");
        txtDescripcion.setText("");
        cbEstado.setSelectedIndex(0);
    }

    public void limpiarTextocd() {
        txtTitulo.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new java.util.Date()));
        txtCodigo.setText("");
        txtUbicacion.setText("");
        txtDescripcion.setText("");
        cbEstado.setSelectedIndex(0);
    }

    public void limpiarTextoREVISTAS() {
        txtTitulo.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new java.util.Date()));
        txtCodigo.setText("");
        txtUbicacion.setText("");
        txtDescripcion.setText("");
        cbEstado.setSelectedIndex(0);
    }

    public void limpiarTextoOTROS() {
        txtTipoDeRecursoOTROS.setText("");
        txtNombreOTROS.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaOTROS.setEnabled(false);
        txtFechaOTROS.setText(dateFormat.format(new java.util.Date()));
        txtCodigoOTROS.setText("");
        txtUbicacionOTROS.setText("");
        txtDescripcionOTROS.setText("");
        cbEstadoOTROS.setSelectedIndex(0);
    }

    public void limpiarTextoPrestamo() {
        txtCodigoRecursoPRESTAMO.setText("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaPrestamoPRESTAMO.setEnabled(false);
        txtFechaPrestamoPRESTAMO.setText(dateFormat.format(new java.util.Date()));
        txtFechaDevolucionPRESTAMOS2.setEnabled(false);
        txtFechaDevolucionPRESTAMOS2.setText(dateFormat.format(new java.util.Date()));
        txtCodigoEstudiantePRESTAMOS.setText("");
        cbEstadoPRESTAMO.setSelectedIndex(0);
    }

    //dar clic en la tabla para que ponga los datos en los campos de texto
    public Encargado() {
        recursoBL = new RecursoBL();
        prestamoBL = new PrestamoBL();
        initComponents();
        //carga los datos en la tabla
        CargarTablaLibros();
        CargarTablacd();
        CargarTablaREVISTAS();
        CargarTablaOTROS();
        CargarTablaPRESTAMO();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        txtFechaDeRegistro.setEnabled(false);
        txtFechaDeRegistro.setText(dateFormat.format(new java.util.Date()));

        tbLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
                if (tbLibros.getRowCount() > 0 && tbLibros.getSelectedRow() != -1) {
                    idRecursoSeleccionado = Integer.parseInt(tbLibros.getValueAt(tbLibros.getSelectedRow(), 0).toString());
                    txtTitulo.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 3).toString());
                    txtAutor.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 4).toString());
                    txtFechaDeRegistro.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 5).toString());
                    txtCodigo.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 2).toString());
                    txtEditorial.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 8).toString());
                    cbEstado.setSelectedItem(tbLibros.getValueAt(tbLibros.getSelectedRow(), 6).toString());
                    txtUbicacion.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 7).toString());
                    txtDescripcion.setText(tbLibros.getValueAt(tbLibros.getSelectedRow(), 9).toString());
                }
            }
        });
        txtFechacd.setEnabled(false);
        txtFechacd.setText(dateFormat.format(new java.util.Date()));

        tbCDS.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
                if (tbCDS.getRowCount() > 0 && tbCDS.getSelectedRow() != -1) {
                    idRecursoSeleccionado = Integer.parseInt(tbCDS.getValueAt(tbCDS.getSelectedRow(), 0).toString());
                    txtNombrecd.setText(tbCDS.getValueAt(tbCDS.getSelectedRow(), 3).toString());
                    txtFechacd.setText(tbCDS.getValueAt(tbCDS.getSelectedRow(), 4).toString());
                    txtCodigocd.setText(tbCDS.getValueAt(tbCDS.getSelectedRow(), 2).toString());
                    cbEstadocd.setSelectedItem(tbCDS.getValueAt(tbCDS.getSelectedRow(), 5).toString());
                    txtUbicacioncd.setText(tbCDS.getValueAt(tbCDS.getSelectedRow(), 6).toString());
                    txtDescripcioncd.setText(tbCDS.getValueAt(tbCDS.getSelectedRow(), 7).toString());
                }
            }
        });

        txtFechaREVISTAS.setEnabled(false);
        txtFechaREVISTAS.setText(dateFormat.format(new java.util.Date()));

        tbREVISTAS.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
                if (tbREVISTAS.getRowCount() > 0 && tbREVISTAS.getSelectedRow() != -1) {
                    idRecursoSeleccionado = Integer.parseInt(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 0).toString());
                    txtNombreREVISTAS.setText(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 3).toString());
                    txtFechaREVISTAS.setText(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 4).toString());
                    txtCodigoREVISTAS.setText(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 2).toString());
                    cbEstadoREVISTAS.setSelectedItem(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 5).toString());
                    txtUbicacionREVISTAS.setText(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 6).toString());
                    txtDescripcionREVISTAS.setText(tbREVISTAS.getValueAt(tbREVISTAS.getSelectedRow(), 7).toString());
                }
            }
        });

        txtFechaOTROS.setEnabled(false);
        txtFechaOTROS.setText(dateFormat.format(new java.util.Date()));

        tbOTROS.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                // String[] titulos = {"ID", "NOMBRE", "APELLIDO", "FECHA DE REGISTRO", "CODIGO", "CONTRASEÑA", "ROL", "ESTADO"};
                if (tbOTROS.getRowCount() > 0 && tbOTROS.getSelectedRow() != -1) {
                    idRecursoSeleccionado = Integer.parseInt(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 0).toString());
                    txtNombreOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 3).toString());
                    txtFechaOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 4).toString());
                    txtCodigoOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 2).toString());
                    cbEstadoOTROS.setSelectedItem(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 5).toString());
                    txtUbicacionOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 6).toString());
                    txtDescripcionOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 7).toString());
                    txtTipoDeRecursoOTROS.setText(tbOTROS.getValueAt(tbOTROS.getSelectedRow(), 1).toString());
                }
            }
        });

        txtFechaPrestamoPRESTAMO.setEnabled(false);
        txtFechaPrestamoPRESTAMO.setText(dateFormat.format(new java.util.Date()));
        txtFechaDevolucionPRESTAMOS2.setEnabled(false);
        txtFechaDevolucionPRESTAMOS2.setText(dateFormat.format(new java.util.Date()));
        cbEstadoPRESTAMO.setEnabled(false);
        tbPRESTAMO.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (tbPRESTAMO.getRowCount() > 0 && tbPRESTAMO.getSelectedRow() != -1) {
                    idPrestamoSeleccionado = Integer.parseInt(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 0).toString());
                    txtCodigoRecursoPRESTAMO.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 1).toString());
                    txtCodigoEstudiantePRESTAMOS.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 2).toString());
                    txtFechaPrestamoPRESTAMO.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 3).toString());
                    txtFechaDevolucionPRESTAMOS2.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 4).toString());
                    cbEstadoPRESTAMO.setSelectedItem(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 5).toString());
                    txtApellidoPrestamo.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 8).toString());
                    txtDiasPrestacion.setText(tbPRESTAMO.getValueAt(tbPRESTAMO.getSelectedRow(), 9).toString());

                }
            }
        });

        if (UsuarioBL.usuario != null) {
            lblUsuarioNombre.setText(UsuarioBL.usuario.getNombres() + " " + UsuarioBL.usuario.getApellidos());
        }
        this.setLocationRelativeTo(null);

        //cargarPedidosLibros();
        aniGestionar.setVisible(true);
        aniPrestamos.setVisible(false);
        aniReportes.setVisible(false);
        GestionarCDS.setVisible(false);
        GestionarRevistas.setVisible(false);
        GestionarOtros.setVisible(false);
        GestionarLibros.setVisible(false);
        Prestamos.setVisible(false);
        PedidosLibros.setVisible(false);
        Reportes.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        Minimizar = new javax.swing.JPanel();
        btnSalir2 = new javax.swing.JLabel();
        Salir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        MoverConElCursor = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblUsuarioNombre = new javax.swing.JLabel();
        cerrarSeccion = new javax.swing.JPanel();
        btnInsterfazdeUsuario = new javax.swing.JLabel();
        aniGestionar = new javax.swing.JPanel();
        btnGestionar = new javax.swing.JLabel();
        aniPrestamos = new javax.swing.JPanel();
        btnPrestamos = new javax.swing.JLabel();
        aniReportes = new javax.swing.JPanel();
        btnReportes = new javax.swing.JLabel();
        Gestionar = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        panelRevistas = new javax.swing.JPanel();
        btnRevistas = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelLibros = new javax.swing.JPanel();
        btnLibros1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelCD = new javax.swing.JPanel();
        btnCDS = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelOtros = new javax.swing.JPanel();
        btnOtros = new javax.swing.JLabel();
        tituloOtros = new javax.swing.JLabel();
        Prestamos = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        PedidosLibros = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbPRESTAMO = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtCodigoRecursoPRESTAMO = new javax.swing.JTextField();
        titulo15 = new javax.swing.JLabel();
        txtBuscarPRESTAMO = new javax.swing.JTextField();
        titulo11 = new javax.swing.JLabel();
        txtFechaDevolucionPRESTAMOS2 = new javax.swing.JTextField();
        cbEstadoPRESTAMO = new javax.swing.JComboBox<>();
        txtFechaPrestamoPRESTAMO = new javax.swing.JTextField();
        txtCodigoEstudiantePRESTAMOS = new javax.swing.JTextField();
        titulo13 = new javax.swing.JLabel();
        titulo16 = new javax.swing.JLabel();
        titulo14 = new javax.swing.JLabel();
        titulo12 = new javax.swing.JLabel();
        btnModificarPRESTAMO = new javax.swing.JButton();
        btnRegistarPRESTAMO = new javax.swing.JButton();
        autor54 = new javax.swing.JLabel();
        autor55 = new javax.swing.JLabel();
        txtDiasPrestacion = new javax.swing.JTextField();
        titulo17 = new javax.swing.JLabel();
        autor56 = new javax.swing.JLabel();
        titulo18 = new javax.swing.JLabel();
        txtApellidoPrestamo = new javax.swing.JTextField();
        autor58 = new javax.swing.JLabel();
        Reportes = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnGenerarREPORTE1 = new javax.swing.JButton();
        titulo23 = new javax.swing.JLabel();
        titulo24 = new javax.swing.JLabel();
        titulo26 = new javax.swing.JLabel();
        titulo27 = new javax.swing.JLabel();
        titulo28 = new javax.swing.JLabel();
        titulo29 = new javax.swing.JLabel();
        titulo25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        GestionarLibros = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFechaDeRegistro = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        titulo1 = new javax.swing.JLabel();
        autor1 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        estado1 = new javax.swing.JLabel();
        btnElimnarLIBRO = new javax.swing.JButton();
        txtBuscarLibro = new javax.swing.JTextField();
        buscar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtEditorial = new javax.swing.JTextField();
        btnRegistrarLIBRO = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();
        autor3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        autor4 = new javax.swing.JLabel();
        btnModificarLIBRO = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        titulo3 = new javax.swing.JLabel();
        autor5 = new javax.swing.JLabel();
        autor6 = new javax.swing.JLabel();
        autor7 = new javax.swing.JLabel();
        autor8 = new javax.swing.JLabel();
        autor9 = new javax.swing.JLabel();
        autor10 = new javax.swing.JLabel();
        autor17 = new javax.swing.JLabel();
        autor18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLibros = new javax.swing.JTable();
        GestionarCDS = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtFechacd = new javax.swing.JTextField();
        txtNombrecd = new javax.swing.JTextField();
        titulo4 = new javax.swing.JLabel();
        lbFecha2 = new javax.swing.JLabel();
        estado3 = new javax.swing.JLabel();
        btnElimnarCD = new javax.swing.JButton();
        txtBuscartodocd = new javax.swing.JTextField();
        buscar2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        btnRegistrarCD = new javax.swing.JButton();
        cbEstadocd = new javax.swing.JComboBox<>();
        autor11 = new javax.swing.JLabel();
        txtDescripcioncd = new javax.swing.JTextField();
        txtUbicacioncd = new javax.swing.JTextField();
        autor12 = new javax.swing.JLabel();
        btnModificarCD = new javax.swing.JButton();
        txtCodigocd = new javax.swing.JTextField();
        titulo5 = new javax.swing.JLabel();
        autor25 = new javax.swing.JLabel();
        autor26 = new javax.swing.JLabel();
        autor27 = new javax.swing.JLabel();
        autor28 = new javax.swing.JLabel();
        autor29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbCDS = new javax.swing.JTable();
        GestionarRevistas = new javax.swing.JPanel();
        tituloRevistas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFechaREVISTAS = new javax.swing.JTextField();
        txtNombreREVISTAS = new javax.swing.JTextField();
        titulo6 = new javax.swing.JLabel();
        lbFecha3 = new javax.swing.JLabel();
        estado4 = new javax.swing.JLabel();
        btnElimnarREVISTAS = new javax.swing.JButton();
        txtBuscartodoREVISTAS = new javax.swing.JTextField();
        buscar3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        btnRegistrarREVISTAS = new javax.swing.JButton();
        cbEstadoREVISTAS = new javax.swing.JComboBox<>();
        autor13 = new javax.swing.JLabel();
        txtDescripcionREVISTAS = new javax.swing.JTextField();
        txtUbicacionREVISTAS = new javax.swing.JTextField();
        autor14 = new javax.swing.JLabel();
        btnModificarREVISTAS = new javax.swing.JButton();
        txtCodigoREVISTAS = new javax.swing.JTextField();
        titulo7 = new javax.swing.JLabel();
        autor35 = new javax.swing.JLabel();
        autor36 = new javax.swing.JLabel();
        autor37 = new javax.swing.JLabel();
        autor38 = new javax.swing.JLabel();
        autor41 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbREVISTAS = new javax.swing.JTable();
        GestionarOtros = new javax.swing.JPanel();
        tituloRevistas1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtFechaOTROS = new javax.swing.JTextField();
        txtNombreOTROS = new javax.swing.JTextField();
        titulo8 = new javax.swing.JLabel();
        lbFecha4 = new javax.swing.JLabel();
        estado5 = new javax.swing.JLabel();
        btnElimnarOTROS = new javax.swing.JButton();
        txtBuscartodoOTROS = new javax.swing.JTextField();
        buscar4 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        btnRegistrarOTROS = new javax.swing.JButton();
        cbEstadoOTROS = new javax.swing.JComboBox<>();
        autor15 = new javax.swing.JLabel();
        txtDescripcionOTROS = new javax.swing.JTextField();
        txtUbicacionOTROS = new javax.swing.JTextField();
        autor16 = new javax.swing.JLabel();
        btnModificarOTROS = new javax.swing.JButton();
        txtCodigoOTROS = new javax.swing.JTextField();
        titulo9 = new javax.swing.JLabel();
        titulo10 = new javax.swing.JLabel();
        txtTipoDeRecursoOTROS = new javax.swing.JTextField();
        autor42 = new javax.swing.JLabel();
        autor43 = new javax.swing.JLabel();
        autor46 = new javax.swing.JLabel();
        autor47 = new javax.swing.JLabel();
        autor48 = new javax.swing.JLabel();
        autor49 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbOTROS = new javax.swing.JTable();

        modificar.setBackground(new java.awt.Color(255, 255, 255));
        modificar.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        modificar.setText("Modificar");
        modificar.setBorder(null);
        modificar.setComponentPopupMenu(jPopupMenu1);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        eliminar.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 40, 30));

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

        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 40, 30));

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
        getContentPane().add(MoverConElCursor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 80));

        Menu.setBackground(new java.awt.Color(0, 151, 247));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Encargado");
        Menu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, -1));

        lblUsuarioNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuarioNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        lblUsuarioNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioNombre.setText("Usuario");
        Menu.add(lblUsuarioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 20));

        cerrarSeccion.setBackground(new java.awt.Color(0, 130, 240));
        cerrarSeccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsterfazdeUsuario.setBackground(new java.awt.Color(51, 255, 51));
        btnInsterfazdeUsuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnInsterfazdeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnInsterfazdeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInsterfazdeUsuario.setText("Cerrar seccion");
        btnInsterfazdeUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsterfazdeUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsterfazdeUsuarioMouseClicked(evt);
            }
        });
        cerrarSeccion.add(btnInsterfazdeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        Menu.add(cerrarSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 190, 40));

        aniGestionar.setBackground(new java.awt.Color(37, 47, 67));
        aniGestionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu.add(aniGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 4, 40));

        btnGestionar.setBackground(new java.awt.Color(0, 130, 240));
        btnGestionar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnGestionar.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGestionar.setText("Gestionar recursos");
        btnGestionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionar.setOpaque(true);
        btnGestionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarMouseClicked(evt);
            }
        });
        Menu.add(btnGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 40));

        aniPrestamos.setBackground(new java.awt.Color(37, 47, 67));
        aniPrestamos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu.add(aniPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 4, 40));

        btnPrestamos.setBackground(new java.awt.Color(0, 151, 247));
        btnPrestamos.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnPrestamos.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrestamos.setText("Prestamos");
        btnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrestamos.setOpaque(true);
        btnPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrestamosMouseClicked(evt);
            }
        });
        Menu.add(btnPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 40));

        aniReportes.setBackground(new java.awt.Color(37, 47, 67));
        aniReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Menu.add(aniReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 4, 40));

        btnReportes.setBackground(new java.awt.Color(0, 151, 247));
        btnReportes.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setOpaque(true);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });
        Menu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 190, 40));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        Gestionar.setBackground(new java.awt.Color(37, 47, 67));
        Gestionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Gestionar Recursos");
        Gestionar.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        panelRevistas.setBackground(new java.awt.Color(33, 42, 58));
        panelRevistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRevistasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRevistasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRevistasMouseExited(evt);
            }
        });
        panelRevistas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRevistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRevistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/revista1.png"))); // NOI18N
        panelRevistas.add(btnRevistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Revistas");
        panelRevistas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 30));

        Gestionar.add(panelRevistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 140, 150));

        panelLibros.setBackground(new java.awt.Color(33, 42, 58));
        panelLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLibrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelLibrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelLibrosMouseExited(evt);
            }
        });
        panelLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLibros1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLibros1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/libro1.png"))); // NOI18N
        panelLibros.add(btnLibros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Libros");
        panelLibros.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 30));

        Gestionar.add(panelLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 140, 150));

        panelCD.setBackground(new java.awt.Color(33, 42, 58));
        panelCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelCDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelCDMouseExited(evt);
            }
        });
        panelCD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCDS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cds1.png"))); // NOI18N
        panelCD.add(btnCDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Cds");
        panelCD.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 30));

        Gestionar.add(panelCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 140, 150));

        panelOtros.setBackground(new java.awt.Color(33, 42, 58));
        panelOtros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOtrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelOtrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOtrosMouseExited(evt);
            }
        });
        panelOtros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOtros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Otros mas.png"))); // NOI18N
        panelOtros.add(btnOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        tituloOtros.setBackground(new java.awt.Color(255, 255, 255));
        tituloOtros.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        tituloOtros.setForeground(new java.awt.Color(255, 255, 255));
        tituloOtros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloOtros.setText("Otros");
        panelOtros.add(tituloOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 30));

        Gestionar.add(panelOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 140, 150));

        getContentPane().add(Gestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        Prestamos.setBackground(new java.awt.Color(37, 47, 67));
        Prestamos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Prestamos");
        Prestamos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        PedidosLibros.setBackground(new java.awt.Color(37, 47, 67));
        PedidosLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane9.setBorder(null);
        jScrollPane9.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbPRESTAMO.setForeground(new java.awt.Color(33, 42, 58));
        tbPRESTAMO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id de recurso", "Tipo de recurso", "Codigo", "Fecha de prestamo", "Estado", "Fecha de devolucion"
            }
        ));
        tbPRESTAMO.setComponentPopupMenu(jPopupMenu1);
        tbPRESTAMO.setFocusable(false);
        tbPRESTAMO.setGridColor(new java.awt.Color(0, 151, 247));
        tbPRESTAMO.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbPRESTAMO.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tbPRESTAMO);

        PedidosLibros.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 930, 300));

        jPanel7.setBackground(new java.awt.Color(33, 42, 58));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigoRecursoPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigoRecursoPRESTAMO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoRecursoPRESTAMO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoRecursoPRESTAMOKeyTyped(evt);
            }
        });
        jPanel7.add(txtCodigoRecursoPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 170, 20));

        titulo15.setBackground(new java.awt.Color(255, 255, 255));
        titulo15.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo15.setForeground(new java.awt.Color(255, 255, 255));
        titulo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo15.setText("Código de recurso");
        jPanel7.add(titulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 20));

        txtBuscarPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscarPRESTAMO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscarPRESTAMO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPRESTAMOKeyReleased(evt);
            }
        });
        jPanel7.add(txtBuscarPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 170, 20));

        titulo11.setBackground(new java.awt.Color(255, 255, 255));
        titulo11.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo11.setForeground(new java.awt.Color(255, 255, 255));
        titulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo11.setText("BUSCAR");
        jPanel7.add(titulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 170, 20));

        txtFechaDevolucionPRESTAMOS2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaDevolucionPRESTAMOS2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaDevolucionPRESTAMOS2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaDevolucionPRESTAMOS2KeyTyped(evt);
            }
        });
        jPanel7.add(txtFechaDevolucionPRESTAMOS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 170, 20));

        cbEstadoPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstadoPRESTAMO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel7.add(cbEstadoPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 170, 20));

        txtFechaPrestamoPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaPrestamoPRESTAMO.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaPrestamoPRESTAMO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaPrestamoPRESTAMOKeyTyped(evt);
            }
        });
        jPanel7.add(txtFechaPrestamoPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 170, 20));

        txtCodigoEstudiantePRESTAMOS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigoEstudiantePRESTAMOS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoEstudiantePRESTAMOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoEstudiantePRESTAMOSKeyTyped(evt);
            }
        });
        jPanel7.add(txtCodigoEstudiantePRESTAMOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 170, 20));

        titulo13.setBackground(new java.awt.Color(255, 255, 255));
        titulo13.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo13.setForeground(new java.awt.Color(255, 255, 255));
        titulo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo13.setText("Fecha de devolución");
        jPanel7.add(titulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, 20));

        titulo16.setBackground(new java.awt.Color(255, 255, 255));
        titulo16.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo16.setForeground(new java.awt.Color(255, 255, 255));
        titulo16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo16.setText("Estado");
        jPanel7.add(titulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, 20));

        titulo14.setBackground(new java.awt.Color(255, 255, 255));
        titulo14.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo14.setForeground(new java.awt.Color(255, 255, 255));
        titulo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo14.setText("Fecha de préstamo");
        jPanel7.add(titulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 160, 20));

        titulo12.setBackground(new java.awt.Color(255, 255, 255));
        titulo12.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo12.setForeground(new java.awt.Color(255, 255, 255));
        titulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo12.setText("Código del estudiante");
        jPanel7.add(titulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 160, 20));

        btnModificarPRESTAMO.setBackground(new java.awt.Color(33, 42, 58));
        btnModificarPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificarPRESTAMO.setForeground(new java.awt.Color(33, 42, 58));
        btnModificarPRESTAMO.setText("Liberar recurso");
        btnModificarPRESTAMO.setBorder(null);
        btnModificarPRESTAMO.setBorderPainted(false);
        btnModificarPRESTAMO.setFocusable(false);
        btnModificarPRESTAMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPRESTAMOActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificarPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 170, 20));

        btnRegistarPRESTAMO.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistarPRESTAMO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistarPRESTAMO.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistarPRESTAMO.setText("Prestar recurso");
        btnRegistarPRESTAMO.setBorder(null);
        btnRegistarPRESTAMO.setBorderPainted(false);
        btnRegistarPRESTAMO.setFocusable(false);
        btnRegistarPRESTAMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarPRESTAMOActionPerformed(evt);
            }
        });
        jPanel7.add(btnRegistarPRESTAMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 170, 20));

        autor54.setBackground(new java.awt.Color(255, 255, 255));
        autor54.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor54.setForeground(new java.awt.Color(255, 255, 255));
        autor54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor54.setText("*");
        jPanel7.add(autor54, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 20, 20));

        autor55.setBackground(new java.awt.Color(255, 255, 255));
        autor55.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor55.setForeground(new java.awt.Color(255, 255, 255));
        autor55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor55.setText("*");
        jPanel7.add(autor55, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 20, 20));

        txtDiasPrestacion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtDiasPrestacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDiasPrestacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasPrestacionKeyTyped(evt);
            }
        });
        jPanel7.add(txtDiasPrestacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 170, 20));

        titulo17.setBackground(new java.awt.Color(255, 255, 255));
        titulo17.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo17.setForeground(new java.awt.Color(255, 255, 255));
        titulo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo17.setText("Días de préstamos");
        jPanel7.add(titulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 160, 20));

        autor56.setBackground(new java.awt.Color(255, 255, 255));
        autor56.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor56.setForeground(new java.awt.Color(255, 255, 255));
        autor56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor56.setText("*");
        jPanel7.add(autor56, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 20, 20));

        titulo18.setBackground(new java.awt.Color(255, 255, 255));
        titulo18.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo18.setForeground(new java.awt.Color(255, 255, 255));
        titulo18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo18.setText("Nombre");
        jPanel7.add(titulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 70, 20));

        txtApellidoPrestamo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtApellidoPrestamo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoPrestamo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPrestamoKeyTyped(evt);
            }
        });
        jPanel7.add(txtApellidoPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 170, 20));

        autor58.setBackground(new java.awt.Color(255, 255, 255));
        autor58.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor58.setForeground(new java.awt.Color(255, 255, 255));
        autor58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor58.setText("*");
        jPanel7.add(autor58, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 20, 20));

        PedidosLibros.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 210));

        Prestamos.add(PedidosLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 520));

        getContentPane().add(Prestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        Reportes.setBackground(new java.awt.Color(37, 47, 67));
        Reportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Reportes");
        Reportes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        jPanel8.setBackground(new java.awt.Color(33, 42, 58));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarREPORTE1.setBackground(new java.awt.Color(33, 42, 58));
        btnGenerarREPORTE1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnGenerarREPORTE1.setForeground(new java.awt.Color(33, 42, 58));
        btnGenerarREPORTE1.setText("Generar reporte ");
        btnGenerarREPORTE1.setBorder(null);
        btnGenerarREPORTE1.setBorderPainted(false);
        btnGenerarREPORTE1.setFocusable(false);
        btnGenerarREPORTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarREPORTE1ActionPerformed(evt);
            }
        });
        jPanel8.add(btnGenerarREPORTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 180, 60));

        titulo23.setBackground(new java.awt.Color(255, 255, 255));
        titulo23.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo23.setForeground(new java.awt.Color(255, 255, 255));
        titulo23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo23.setText("y posteriormente imprimirlo.");
        jPanel8.add(titulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 360, 30));

        titulo24.setBackground(new java.awt.Color(255, 255, 255));
        titulo24.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo24.setForeground(new java.awt.Color(255, 255, 255));
        titulo24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo24.setText(" para analizar la informacion y sacar conclusiones");
        jPanel8.add(titulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 370, 30));

        titulo26.setBackground(new java.awt.Color(255, 255, 255));
        titulo26.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo26.setForeground(new java.awt.Color(255, 255, 255));
        titulo26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo26.setText(" de uso y estado de cada recurso.");
        jPanel8.add(titulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 360, 30));

        titulo27.setBackground(new java.awt.Color(255, 255, 255));
        titulo27.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo27.setForeground(new java.awt.Color(255, 255, 255));
        titulo27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo27.setText("en la base de datos con todos sus atributos y caracteristicas");
        jPanel8.add(titulo27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 390, 30));

        titulo28.setBackground(new java.awt.Color(255, 255, 255));
        titulo28.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo28.setForeground(new java.awt.Color(255, 255, 255));
        titulo28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo28.setText("NOTA: tenga encuenta que al generar este reporte ");
        jPanel8.add(titulo28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 360, 30));

        titulo29.setBackground(new java.awt.Color(255, 255, 255));
        titulo29.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo29.setForeground(new java.awt.Color(255, 255, 255));
        titulo29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo29.setText("Genera un reporte de los recursos que se encuentran ");
        jPanel8.add(titulo29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 360, 30));

        titulo25.setBackground(new java.awt.Color(255, 255, 255));
        titulo25.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo25.setForeground(new java.awt.Color(255, 255, 255));
        titulo25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titulo25.setText("se creara un archivo que lo prodra ejecutar en excel");
        jPanel8.add(titulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 360, 30));

        jButton1.setText("GENERAR REPORTE 2");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 180, 50));

        Reportes.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 520));

        getContentPane().add(Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        GestionarLibros.setBackground(new java.awt.Color(37, 47, 67));
        GestionarLibros.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        GestionarLibros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Gestionar Libros");
        GestionarLibros.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        jPanel2.setBackground(new java.awt.Color(33, 42, 58));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechaDeRegistro.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaDeRegistro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaDeRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaDeRegistroKeyTyped(evt);
            }
        });
        jPanel2.add(txtFechaDeRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 240, 20));

        txtAutor.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtAutor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAutorKeyTyped(evt);
            }
        });
        jPanel2.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 240, 20));

        txtTitulo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
            }
        });
        jPanel2.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 240, 20));

        titulo1.setBackground(new java.awt.Color(255, 255, 255));
        titulo1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Titulo");
        jPanel2.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, 20));

        autor1.setBackground(new java.awt.Color(255, 255, 255));
        autor1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor1.setForeground(new java.awt.Color(255, 255, 255));
        autor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor1.setText("Autor");
        jPanel2.add(autor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 110, 20));

        lbFecha.setBackground(new java.awt.Color(255, 255, 255));
        lbFecha.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("Fecha Reg");
        jPanel2.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 110, 20));

        estado1.setBackground(new java.awt.Color(255, 255, 255));
        estado1.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado1.setForeground(new java.awt.Color(255, 255, 255));
        estado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado1.setText("Estado");
        jPanel2.add(estado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 110, 20));

        btnElimnarLIBRO.setBackground(new java.awt.Color(33, 42, 58));
        btnElimnarLIBRO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnElimnarLIBRO.setForeground(new java.awt.Color(33, 42, 58));
        btnElimnarLIBRO.setText("Eliminar");
        btnElimnarLIBRO.setBorder(null);
        btnElimnarLIBRO.setBorderPainted(false);
        btnElimnarLIBRO.setFocusable(false);
        btnElimnarLIBRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimnarLIBROActionPerformed(evt);
            }
        });
        jPanel2.add(btnElimnarLIBRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 120, 20));

        txtBuscarLibro.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscarLibro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarLibroKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 240, 20));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar.setText("Buscar");
        jPanel2.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 110, 20));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 240, 10));

        txtEditorial.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtEditorial.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditorialKeyTyped(evt);
            }
        });
        jPanel2.add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 240, 20));

        btnRegistrarLIBRO.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistrarLIBRO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistrarLIBRO.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistrarLIBRO.setText("Registrar");
        btnRegistrarLIBRO.setBorder(null);
        btnRegistrarLIBRO.setBorderPainted(false);
        btnRegistrarLIBRO.setFocusable(false);
        btnRegistrarLIBRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLIBROActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarLIBRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 240, 20));

        cbEstado.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        jPanel2.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 240, 20));

        autor3.setBackground(new java.awt.Color(255, 255, 255));
        autor3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor3.setForeground(new java.awt.Color(255, 255, 255));
        autor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor3.setText("Descripcion");
        jPanel2.add(autor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 110, 20));

        txtDescripcion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 240, 20));

        txtUbicacion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtUbicacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUbicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUbicacionKeyTyped(evt);
            }
        });
        jPanel2.add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 240, 20));

        autor4.setBackground(new java.awt.Color(255, 255, 255));
        autor4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor4.setForeground(new java.awt.Color(255, 255, 255));
        autor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor4.setText("Ubicacion");
        jPanel2.add(autor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, 20));

        btnModificarLIBRO.setBackground(new java.awt.Color(33, 42, 58));
        btnModificarLIBRO.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificarLIBRO.setForeground(new java.awt.Color(33, 42, 58));
        btnModificarLIBRO.setText("Modificar");
        btnModificarLIBRO.setBorder(null);
        btnModificarLIBRO.setBorderPainted(false);
        btnModificarLIBRO.setFocusable(false);
        btnModificarLIBRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLIBROActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificarLIBRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 110, 20));

        txtCodigo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 240, 20));

        titulo3.setBackground(new java.awt.Color(255, 255, 255));
        titulo3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo3.setForeground(new java.awt.Color(255, 255, 255));
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setText("Codigo");
        jPanel2.add(titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 20));

        autor5.setBackground(new java.awt.Color(255, 255, 255));
        autor5.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor5.setForeground(new java.awt.Color(255, 255, 255));
        autor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor5.setText("Editorial");
        jPanel2.add(autor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 110, 20));

        autor6.setBackground(new java.awt.Color(255, 255, 255));
        autor6.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor6.setForeground(new java.awt.Color(255, 255, 255));
        autor6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor6.setText("*");
        jPanel2.add(autor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 20, 20));

        autor7.setBackground(new java.awt.Color(255, 255, 255));
        autor7.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor7.setForeground(new java.awt.Color(255, 255, 255));
        autor7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor7.setText("*");
        jPanel2.add(autor7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 20, 20));

        autor8.setBackground(new java.awt.Color(255, 255, 255));
        autor8.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor8.setForeground(new java.awt.Color(255, 255, 255));
        autor8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor8.setText("*");
        jPanel2.add(autor8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 20, 20));

        autor9.setBackground(new java.awt.Color(255, 255, 255));
        autor9.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor9.setForeground(new java.awt.Color(255, 255, 255));
        autor9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor9.setText("*");
        jPanel2.add(autor9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 20, 20));

        autor10.setBackground(new java.awt.Color(255, 255, 255));
        autor10.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor10.setForeground(new java.awt.Color(255, 255, 255));
        autor10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor10.setText("*");
        jPanel2.add(autor10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 20, 20));

        autor17.setBackground(new java.awt.Color(255, 255, 255));
        autor17.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor17.setForeground(new java.awt.Color(255, 255, 255));
        autor17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor17.setText("*");
        jPanel2.add(autor17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 20, 20));

        autor18.setBackground(new java.awt.Color(255, 255, 255));
        autor18.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor18.setForeground(new java.awt.Color(255, 255, 255));
        autor18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor18.setText("*");
        jPanel2.add(autor18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 20, 20));

        GestionarLibros.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 210));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbLibros.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbLibros.setForeground(new java.awt.Color(33, 42, 58));
        tbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Titulo", "Autor", "Fecha", "Estado", "Ubicacion", "Editorial", "Descripcion"
            }
        ));
        tbLibros.setComponentPopupMenu(jPopupMenu1);
        tbLibros.setFocusable(false);
        tbLibros.setGridColor(new java.awt.Color(0, 151, 247));
        tbLibros.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbLibros);

        GestionarLibros.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 930, 310));

        getContentPane().add(GestionarLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        GestionarCDS.setBackground(new java.awt.Color(37, 47, 67));
        GestionarCDS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cds");
        GestionarCDS.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        jPanel4.setBackground(new java.awt.Color(33, 42, 58));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechacd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechacd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechacd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechacdKeyTyped(evt);
            }
        });
        jPanel4.add(txtFechacd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 240, 20));

        txtNombrecd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtNombrecd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombrecd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrecdKeyTyped(evt);
            }
        });
        jPanel4.add(txtNombrecd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 240, 20));

        titulo4.setBackground(new java.awt.Color(255, 255, 255));
        titulo4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo4.setForeground(new java.awt.Color(255, 255, 255));
        titulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo4.setText("Nombre");
        jPanel4.add(titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 110, 20));

        lbFecha2.setBackground(new java.awt.Color(255, 255, 255));
        lbFecha2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        lbFecha2.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha2.setText("Fecha Reg");
        jPanel4.add(lbFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 110, 20));

        estado3.setBackground(new java.awt.Color(255, 255, 255));
        estado3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado3.setForeground(new java.awt.Color(255, 255, 255));
        estado3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado3.setText("Estado");
        jPanel4.add(estado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 110, 20));

        btnElimnarCD.setBackground(new java.awt.Color(33, 42, 58));
        btnElimnarCD.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnElimnarCD.setForeground(new java.awt.Color(33, 42, 58));
        btnElimnarCD.setText("Eliminar");
        btnElimnarCD.setBorder(null);
        btnElimnarCD.setBorderPainted(false);
        btnElimnarCD.setFocusable(false);
        btnElimnarCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimnarCDActionPerformed(evt);
            }
        });
        jPanel4.add(btnElimnarCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 120, 20));

        txtBuscartodocd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscartodocd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscartodocd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscartodocdKeyReleased(evt);
            }
        });
        jPanel4.add(txtBuscartodocd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 240, 20));

        buscar2.setBackground(new java.awt.Color(255, 255, 255));
        buscar2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscar2.setForeground(new java.awt.Color(255, 255, 255));
        buscar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar2.setText("Buscar");
        jPanel4.add(buscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 110, 20));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 240, 10));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 240, 10));

        btnRegistrarCD.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistrarCD.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistrarCD.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistrarCD.setText("Registrar");
        btnRegistrarCD.setBorder(null);
        btnRegistrarCD.setBorderPainted(false);
        btnRegistrarCD.setFocusable(false);
        btnRegistrarCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCDActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrarCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 240, 20));

        cbEstadocd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstadocd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel4.add(cbEstadocd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 240, 20));

        autor11.setBackground(new java.awt.Color(255, 255, 255));
        autor11.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor11.setForeground(new java.awt.Color(255, 255, 255));
        autor11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor11.setText("Descripcion");
        jPanel4.add(autor11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 110, 20));

        txtDescripcioncd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtDescripcioncd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcioncd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcioncdKeyTyped(evt);
            }
        });
        jPanel4.add(txtDescripcioncd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 240, 20));

        txtUbicacioncd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtUbicacioncd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUbicacioncd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUbicacioncdKeyTyped(evt);
            }
        });
        jPanel4.add(txtUbicacioncd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 240, 20));

        autor12.setBackground(new java.awt.Color(255, 255, 255));
        autor12.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor12.setForeground(new java.awt.Color(255, 255, 255));
        autor12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor12.setText("Ubicacion");
        jPanel4.add(autor12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 110, 20));

        btnModificarCD.setBackground(new java.awt.Color(33, 42, 58));
        btnModificarCD.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificarCD.setForeground(new java.awt.Color(33, 42, 58));
        btnModificarCD.setText("Modificar");
        btnModificarCD.setBorder(null);
        btnModificarCD.setBorderPainted(false);
        btnModificarCD.setFocusable(false);
        btnModificarCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCDActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificarCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 110, 20));

        txtCodigocd.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigocd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigocd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigocdKeyTyped(evt);
            }
        });
        jPanel4.add(txtCodigocd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 240, 20));

        titulo5.setBackground(new java.awt.Color(255, 255, 255));
        titulo5.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo5.setForeground(new java.awt.Color(255, 255, 255));
        titulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo5.setText("Codigo");
        jPanel4.add(titulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 110, 20));

        autor25.setBackground(new java.awt.Color(255, 255, 255));
        autor25.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor25.setForeground(new java.awt.Color(255, 255, 255));
        autor25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor25.setText("*");
        jPanel4.add(autor25, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 20, 20));

        autor26.setBackground(new java.awt.Color(255, 255, 255));
        autor26.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor26.setForeground(new java.awt.Color(255, 255, 255));
        autor26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor26.setText("*");
        jPanel4.add(autor26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 20, 20));

        autor27.setBackground(new java.awt.Color(255, 255, 255));
        autor27.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor27.setForeground(new java.awt.Color(255, 255, 255));
        autor27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor27.setText("*");
        jPanel4.add(autor27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 20, 20));

        autor28.setBackground(new java.awt.Color(255, 255, 255));
        autor28.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor28.setForeground(new java.awt.Color(255, 255, 255));
        autor28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor28.setText("*");
        jPanel4.add(autor28, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 20, 20));

        autor29.setBackground(new java.awt.Color(255, 255, 255));
        autor29.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor29.setForeground(new java.awt.Color(255, 255, 255));
        autor29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor29.setText("*");
        jPanel4.add(autor29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 20, 20));

        GestionarCDS.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 210));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbCDS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbCDS.setForeground(new java.awt.Color(33, 42, 58));
        tbCDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Fecha", "Estado", "Ubicacion", "Descripcion"
            }
        ));
        tbCDS.setComponentPopupMenu(jPopupMenu1);
        tbCDS.setFocusable(false);
        tbCDS.setGridColor(new java.awt.Color(0, 151, 247));
        tbCDS.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbCDS.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbCDS);

        GestionarCDS.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 930, 310));

        getContentPane().add(GestionarCDS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        GestionarRevistas.setBackground(new java.awt.Color(37, 47, 67));
        GestionarRevistas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloRevistas.setBackground(new java.awt.Color(255, 255, 255));
        tituloRevistas.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        tituloRevistas.setForeground(new java.awt.Color(255, 255, 255));
        tituloRevistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRevistas.setText("Revistas");
        GestionarRevistas.add(tituloRevistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        jPanel5.setBackground(new java.awt.Color(33, 42, 58));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechaREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaREVISTASKeyTyped(evt);
            }
        });
        jPanel5.add(txtFechaREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 240, 20));

        txtNombreREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtNombreREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreREVISTASKeyTyped(evt);
            }
        });
        jPanel5.add(txtNombreREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 240, 20));

        titulo6.setBackground(new java.awt.Color(255, 255, 255));
        titulo6.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo6.setForeground(new java.awt.Color(255, 255, 255));
        titulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo6.setText("Nombre");
        jPanel5.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 110, 20));

        lbFecha3.setBackground(new java.awt.Color(255, 255, 255));
        lbFecha3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        lbFecha3.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha3.setText("Fecha Reg");
        jPanel5.add(lbFecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 110, 20));

        estado4.setBackground(new java.awt.Color(255, 255, 255));
        estado4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado4.setForeground(new java.awt.Color(255, 255, 255));
        estado4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado4.setText("Estado");
        jPanel5.add(estado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 110, 20));

        btnElimnarREVISTAS.setBackground(new java.awt.Color(33, 42, 58));
        btnElimnarREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnElimnarREVISTAS.setForeground(new java.awt.Color(33, 42, 58));
        btnElimnarREVISTAS.setText("Eliminar");
        btnElimnarREVISTAS.setBorder(null);
        btnElimnarREVISTAS.setBorderPainted(false);
        btnElimnarREVISTAS.setFocusable(false);
        btnElimnarREVISTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimnarREVISTASActionPerformed(evt);
            }
        });
        jPanel5.add(btnElimnarREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 120, 20));

        txtBuscartodoREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscartodoREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscartodoREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscartodoREVISTASKeyReleased(evt);
            }
        });
        jPanel5.add(txtBuscartodoREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 240, 20));

        buscar3.setBackground(new java.awt.Color(255, 255, 255));
        buscar3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscar3.setForeground(new java.awt.Color(255, 255, 255));
        buscar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar3.setText("Buscar");
        jPanel5.add(buscar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 20));
        jPanel5.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 240, 10));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 240, 10));

        btnRegistrarREVISTAS.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistrarREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistrarREVISTAS.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistrarREVISTAS.setText("Registrar");
        btnRegistrarREVISTAS.setBorder(null);
        btnRegistrarREVISTAS.setBorderPainted(false);
        btnRegistrarREVISTAS.setFocusable(false);
        btnRegistrarREVISTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarREVISTASActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrarREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 240, 20));

        cbEstadoREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstadoREVISTAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel5.add(cbEstadoREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 240, 20));

        autor13.setBackground(new java.awt.Color(255, 255, 255));
        autor13.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor13.setForeground(new java.awt.Color(255, 255, 255));
        autor13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor13.setText("Descripcion");
        jPanel5.add(autor13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 110, 20));

        txtDescripcionREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtDescripcionREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcionREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionREVISTASKeyTyped(evt);
            }
        });
        jPanel5.add(txtDescripcionREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 240, 20));

        txtUbicacionREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtUbicacionREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUbicacionREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUbicacionREVISTASKeyTyped(evt);
            }
        });
        jPanel5.add(txtUbicacionREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 240, 20));

        autor14.setBackground(new java.awt.Color(255, 255, 255));
        autor14.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor14.setForeground(new java.awt.Color(255, 255, 255));
        autor14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor14.setText("Ubicacion");
        jPanel5.add(autor14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 110, 20));

        btnModificarREVISTAS.setBackground(new java.awt.Color(33, 42, 58));
        btnModificarREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificarREVISTAS.setForeground(new java.awt.Color(33, 42, 58));
        btnModificarREVISTAS.setText("Modificar");
        btnModificarREVISTAS.setBorder(null);
        btnModificarREVISTAS.setBorderPainted(false);
        btnModificarREVISTAS.setFocusable(false);
        btnModificarREVISTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarREVISTASActionPerformed(evt);
            }
        });
        jPanel5.add(btnModificarREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 110, 20));

        txtCodigoREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigoREVISTAS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoREVISTAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoREVISTASKeyTyped(evt);
            }
        });
        jPanel5.add(txtCodigoREVISTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 240, 20));

        titulo7.setBackground(new java.awt.Color(255, 255, 255));
        titulo7.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo7.setForeground(new java.awt.Color(255, 255, 255));
        titulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo7.setText("Codigo");
        jPanel5.add(titulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 110, 20));

        autor35.setBackground(new java.awt.Color(255, 255, 255));
        autor35.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor35.setForeground(new java.awt.Color(255, 255, 255));
        autor35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor35.setText("*");
        jPanel5.add(autor35, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 20, 20));

        autor36.setBackground(new java.awt.Color(255, 255, 255));
        autor36.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor36.setForeground(new java.awt.Color(255, 255, 255));
        autor36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor36.setText("*");
        jPanel5.add(autor36, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 20, 20));

        autor37.setBackground(new java.awt.Color(255, 255, 255));
        autor37.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor37.setForeground(new java.awt.Color(255, 255, 255));
        autor37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor37.setText("*");
        jPanel5.add(autor37, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 20, 20));

        autor38.setBackground(new java.awt.Color(255, 255, 255));
        autor38.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor38.setForeground(new java.awt.Color(255, 255, 255));
        autor38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor38.setText("*");
        jPanel5.add(autor38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 20, 20));

        autor41.setBackground(new java.awt.Color(255, 255, 255));
        autor41.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor41.setForeground(new java.awt.Color(255, 255, 255));
        autor41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor41.setText("*");
        jPanel5.add(autor41, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 20, 20));

        GestionarRevistas.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 210));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(null);
        jScrollPane7.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbREVISTAS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbREVISTAS.setForeground(new java.awt.Color(33, 42, 58));
        tbREVISTAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Fecha", "Estado", "Ubicacion", "Descripcion"
            }
        ));
        tbREVISTAS.setComponentPopupMenu(jPopupMenu1);
        tbREVISTAS.setFocusable(false);
        tbREVISTAS.setGridColor(new java.awt.Color(0, 151, 247));
        tbREVISTAS.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbREVISTAS.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbREVISTAS);

        GestionarRevistas.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 930, 310));

        getContentPane().add(GestionarRevistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        GestionarOtros.setBackground(new java.awt.Color(37, 47, 67));
        GestionarOtros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloRevistas1.setBackground(new java.awt.Color(255, 255, 255));
        tituloRevistas1.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        tituloRevistas1.setForeground(new java.awt.Color(255, 255, 255));
        tituloRevistas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRevistas1.setText("Otros recursos");
        GestionarOtros.add(tituloRevistas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        jPanel6.setBackground(new java.awt.Color(33, 42, 58));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFechaOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtFechaOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFechaOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtFechaOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 240, 20));

        txtNombreOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtNombreOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtNombreOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 240, 20));

        titulo8.setBackground(new java.awt.Color(255, 255, 255));
        titulo8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo8.setForeground(new java.awt.Color(255, 255, 255));
        titulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo8.setText("Nombre");
        jPanel6.add(titulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 110, 20));

        lbFecha4.setBackground(new java.awt.Color(255, 255, 255));
        lbFecha4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        lbFecha4.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha4.setText("Fecha Reg");
        jPanel6.add(lbFecha4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 110, 20));

        estado5.setBackground(new java.awt.Color(255, 255, 255));
        estado5.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        estado5.setForeground(new java.awt.Color(255, 255, 255));
        estado5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado5.setText("Estado");
        jPanel6.add(estado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 110, 20));

        btnElimnarOTROS.setBackground(new java.awt.Color(33, 42, 58));
        btnElimnarOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnElimnarOTROS.setForeground(new java.awt.Color(33, 42, 58));
        btnElimnarOTROS.setText("Eliminar");
        btnElimnarOTROS.setBorder(null);
        btnElimnarOTROS.setBorderPainted(false);
        btnElimnarOTROS.setFocusable(false);
        btnElimnarOTROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimnarOTROSActionPerformed(evt);
            }
        });
        jPanel6.add(btnElimnarOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 120, 20));

        txtBuscartodoOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtBuscartodoOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscartodoOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscartodoOTROSKeyReleased(evt);
            }
        });
        jPanel6.add(txtBuscartodoOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 240, 20));

        buscar4.setBackground(new java.awt.Color(255, 255, 255));
        buscar4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        buscar4.setForeground(new java.awt.Color(255, 255, 255));
        buscar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscar4.setText("Buscar");
        jPanel6.add(buscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 110, 20));
        jPanel6.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 240, 10));
        jPanel6.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 240, 10));

        btnRegistrarOTROS.setBackground(new java.awt.Color(33, 42, 58));
        btnRegistrarOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnRegistrarOTROS.setForeground(new java.awt.Color(33, 42, 58));
        btnRegistrarOTROS.setText("Registrar");
        btnRegistrarOTROS.setBorder(null);
        btnRegistrarOTROS.setBorderPainted(false);
        btnRegistrarOTROS.setFocusable(false);
        btnRegistrarOTROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarOTROSActionPerformed(evt);
            }
        });
        jPanel6.add(btnRegistrarOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 240, 20));

        cbEstadoOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbEstadoOTROS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel6.add(cbEstadoOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 240, 20));

        autor15.setBackground(new java.awt.Color(255, 255, 255));
        autor15.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor15.setForeground(new java.awt.Color(255, 255, 255));
        autor15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor15.setText("Descripcion");
        jPanel6.add(autor15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 110, 20));

        txtDescripcionOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtDescripcionOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcionOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtDescripcionOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 240, 20));

        txtUbicacionOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtUbicacionOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUbicacionOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUbicacionOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtUbicacionOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 240, 20));

        autor16.setBackground(new java.awt.Color(255, 255, 255));
        autor16.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        autor16.setForeground(new java.awt.Color(255, 255, 255));
        autor16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor16.setText("Ubicacion");
        jPanel6.add(autor16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 110, 20));

        btnModificarOTROS.setBackground(new java.awt.Color(33, 42, 58));
        btnModificarOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnModificarOTROS.setForeground(new java.awt.Color(33, 42, 58));
        btnModificarOTROS.setText("Modificar");
        btnModificarOTROS.setBorder(null);
        btnModificarOTROS.setBorderPainted(false);
        btnModificarOTROS.setFocusable(false);
        btnModificarOTROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarOTROSActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificarOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 110, 20));

        txtCodigoOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtCodigoOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodigoOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtCodigoOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 240, 20));

        titulo9.setBackground(new java.awt.Color(255, 255, 255));
        titulo9.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo9.setForeground(new java.awt.Color(255, 255, 255));
        titulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo9.setText("Codigo");
        jPanel6.add(titulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 110, 20));

        titulo10.setBackground(new java.awt.Color(255, 255, 255));
        titulo10.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        titulo10.setForeground(new java.awt.Color(255, 255, 255));
        titulo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo10.setText("Tipo de recurso");
        jPanel6.add(titulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 20));

        txtTipoDeRecursoOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        txtTipoDeRecursoOTROS.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTipoDeRecursoOTROS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoDeRecursoOTROSKeyTyped(evt);
            }
        });
        jPanel6.add(txtTipoDeRecursoOTROS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 240, 20));

        autor42.setBackground(new java.awt.Color(255, 255, 255));
        autor42.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor42.setForeground(new java.awt.Color(255, 255, 255));
        autor42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor42.setText("*");
        jPanel6.add(autor42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 20, 20));

        autor43.setBackground(new java.awt.Color(255, 255, 255));
        autor43.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor43.setForeground(new java.awt.Color(255, 255, 255));
        autor43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor43.setText("*");
        jPanel6.add(autor43, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 20, 20));

        autor46.setBackground(new java.awt.Color(255, 255, 255));
        autor46.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor46.setForeground(new java.awt.Color(255, 255, 255));
        autor46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor46.setText("*");
        jPanel6.add(autor46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 20, 20));

        autor47.setBackground(new java.awt.Color(255, 255, 255));
        autor47.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor47.setForeground(new java.awt.Color(255, 255, 255));
        autor47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor47.setText("*");
        jPanel6.add(autor47, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 20, 20));

        autor48.setBackground(new java.awt.Color(255, 255, 255));
        autor48.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor48.setForeground(new java.awt.Color(255, 255, 255));
        autor48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor48.setText("*");
        jPanel6.add(autor48, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 20, 20));

        autor49.setBackground(new java.awt.Color(255, 255, 255));
        autor49.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        autor49.setForeground(new java.awt.Color(255, 255, 255));
        autor49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autor49.setText("*");
        jPanel6.add(autor49, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 20, 20));

        GestionarOtros.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 930, 210));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(null);
        jScrollPane8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N

        tbOTROS.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tbOTROS.setForeground(new java.awt.Color(33, 42, 58));
        tbOTROS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Fecha", "Estado", "Ubicacion", "Descripcion"
            }
        ));
        tbOTROS.setComponentPopupMenu(jPopupMenu1);
        tbOTROS.setFocusable(false);
        tbOTROS.setGridColor(new java.awt.Color(0, 151, 247));
        tbOTROS.setSelectionBackground(new java.awt.Color(0, 151, 247));
        tbOTROS.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tbOTROS);

        GestionarOtros.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 930, 310));

        getContentPane().add(GestionarOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 930, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void btnGestionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarMouseClicked
        setLblColor(btnGestionar);
        resetLblColor(btnPrestamos);
        resetLblColor(btnReportes);

        Gestionar.setVisible(true);
        Prestamos.setVisible(false);
        Reportes.setVisible(false);
        GestionarCDS.setVisible(false);
        GestionarLibros.setVisible(false);
        GestionarRevistas.setVisible(false);
        GestionarOtros.setVisible(false);

        aniGestionar.setVisible(true);
        aniPrestamos.setVisible(false);
        aniReportes.setVisible(false);

    }//GEN-LAST:event_btnGestionarMouseClicked

    private void btnPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestamosMouseClicked
        resetLblColor(btnGestionar);
        setLblColor(btnPrestamos);
        resetLblColor(btnReportes);

        Gestionar.setVisible(false);
        Prestamos.setVisible(true);
        Reportes.setVisible(false);
        GestionarCDS.setVisible(false);
        GestionarLibros.setVisible(false);
        GestionarRevistas.setVisible(false);
        GestionarOtros.setVisible(false);
        Prestamos.setVisible(true);
        PedidosLibros.setVisible(true);

        aniGestionar.setVisible(false);
        aniPrestamos.setVisible(true);
        aniReportes.setVisible(false);
    }//GEN-LAST:event_btnPrestamosMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        resetLblColor(btnGestionar);
        resetLblColor(btnPrestamos);
        setLblColor(btnReportes);

        Gestionar.setVisible(false);
        Prestamos.setVisible(false);
        Reportes.setVisible(true);
        GestionarCDS.setVisible(false);
        GestionarLibros.setVisible(false);
        GestionarRevistas.setVisible(false);
        GestionarOtros.setVisible(false);

        aniGestionar.setVisible(false);
        aniPrestamos.setVisible(false);
        aniReportes.setVisible(true);
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnInsterfazdeUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsterfazdeUsuarioMouseClicked

        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere cerrar seccion", "Cerrar seccion", dialog);
        if (result == 0) {
            UsuarioBL.usuario = null;
            LoginPrincipal obj = new LoginPrincipal();
            obj.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnInsterfazdeUsuarioMouseClicked

    private void panelRevistasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRevistasMouseExited
        resetColor(panelRevistas);
    }//GEN-LAST:event_panelRevistasMouseExited

    private void panelRevistasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRevistasMouseEntered
        setColor(panelRevistas);
    }//GEN-LAST:event_panelRevistasMouseEntered

    private void panelLibrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLibrosMouseExited
        resetColor(panelLibros);
    }//GEN-LAST:event_panelLibrosMouseExited

    private void panelLibrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLibrosMouseEntered
        setColor(panelLibros);
    }//GEN-LAST:event_panelLibrosMouseEntered

    private void panelOtrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOtrosMouseExited
        resetColor(panelOtros);
    }//GEN-LAST:event_panelOtrosMouseExited

    private void panelOtrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOtrosMouseEntered
        setColor(panelOtros);
    }//GEN-LAST:event_panelOtrosMouseEntered

    private void panelCDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCDMouseExited
        resetColor(panelCD);
    }//GEN-LAST:event_panelCDMouseExited

    private void panelCDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCDMouseEntered
        setColor(panelCD);
    }//GEN-LAST:event_panelCDMouseEntered

    private void panelLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLibrosMouseClicked
        Gestionar.setVisible(false);
        Prestamos.setVisible(false);
        Reportes.setVisible(false);
        GestionarLibros.setVisible(true);
    }//GEN-LAST:event_panelLibrosMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea cerrar el programa", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_SalirMouseClicked

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered
        setColor(Salir);
    }//GEN-LAST:event_SalirMouseEntered

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited
        resetColor2(Salir);
    }//GEN-LAST:event_SalirMouseExited

    private void panelCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCDMouseClicked
        Gestionar.setVisible(false);
        Prestamos.setVisible(false);
        Reportes.setVisible(false);
        GestionarCDS.setVisible(true);

    }//GEN-LAST:event_panelCDMouseClicked

    private void txtFechaDeRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaDeRegistroKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnRegistrarLIBRO.doClick();
        }
    }//GEN-LAST:event_txtFechaDeRegistroKeyTyped

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnRegistrarLIBRO.doClick();
        }
    }//GEN-LAST:event_txtTituloKeyTyped

    private void txtAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnRegistrarLIBRO.doClick();
        }
    }//GEN-LAST:event_txtAutorKeyTyped

    private void txtEditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorialKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnRegistrarLIBRO.doClick();
        }
    }//GEN-LAST:event_txtEditorialKeyTyped

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        /*  int fila = tbLibros.getSelectedRow();
        if (fila >= 0) {
            txtCodigo.setText(tbLibros.getValueAt(fila, 0).toString());
            txtTitulo.setText(tbLibros.getValueAt(fila, 1).toString());
            txtAutor.setText(tbLibros.getValueAt(fila, 2).toString());
            txtFecha.setText(tbLibros.getValueAt(fila, 3).toString());
            txtEstado.setText(tbLibros.getValueAt(fila, 4).toString());
            txtEditorial.setText(tbLibros.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Primero tiene que seleccionar una fila para modificarla");
        }*/
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

    }//GEN-LAST:event_eliminarActionPerformed

    private void MinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseEntered
        setColor(Minimizar);
    }//GEN-LAST:event_MinimizarMouseEntered

    private void MinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseExited
        resetColor2(Minimizar);
    }//GEN-LAST:event_MinimizarMouseExited

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        this.setState(LoginPrincipal.ICONIFIED);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void MoverConElCursorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoverConElCursorMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_MoverConElCursorMouseDragged

    private void MoverConElCursorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoverConElCursorMousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_MoverConElCursorMousePressed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtUbicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtFechacdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechacdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechacdKeyTyped

    private void txtNombrecdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrecdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrecdKeyTyped

    private void txtDescripcioncdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcioncdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcioncdKeyTyped

    private void txtUbicacioncdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacioncdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacioncdKeyTyped

    private void txtCodigocdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigocdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigocdKeyTyped

    private void txtFechaREVISTASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaREVISTASKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaREVISTASKeyTyped

    private void txtNombreREVISTASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreREVISTASKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreREVISTASKeyTyped

    private void txtDescripcionREVISTASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionREVISTASKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionREVISTASKeyTyped

    private void txtUbicacionREVISTASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacionREVISTASKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionREVISTASKeyTyped

    private void txtCodigoREVISTASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoREVISTASKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoREVISTASKeyTyped

    private void txtFechaOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaOTROSKeyTyped

    private void txtNombreOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreOTROSKeyTyped

    private void txtDescripcionOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionOTROSKeyTyped

    private void txtUbicacionOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUbicacionOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionOTROSKeyTyped

    private void txtCodigoOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoOTROSKeyTyped

    private void txtTipoDeRecursoOTROSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoDeRecursoOTROSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoDeRecursoOTROSKeyTyped

    private void panelRevistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRevistasMouseClicked
        Gestionar.setVisible(false);
        Prestamos.setVisible(false);
        Reportes.setVisible(false);
        GestionarRevistas.setVisible(true);

    }//GEN-LAST:event_panelRevistasMouseClicked

    private void panelOtrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOtrosMouseClicked
        Gestionar.setVisible(false);
        Prestamos.setVisible(false);
        Reportes.setVisible(false);
        GestionarOtros.setVisible(true);

    }//GEN-LAST:event_panelOtrosMouseClicked

    private void btnRegistrarLIBROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarLIBROActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigo.getText(), null)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setNombre(txtTitulo.getText());
                recurso.setAutor(txtAutor.getText());
                recurso.setCodigo(txtCodigo.getText());
                recurso.setUbicacion(txtUbicacion.getText());
                recurso.setDescripcion(txtDescripcion.getText());
                recurso.setEditorial(txtEditorial.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaDeRegistro.getText()).getTime()));
                recurso.setTipoRecurso("LIBRO");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }
                //usuario.setConatrseña(new String(txtContraseña.getPassword()));
                if (cbEstado.getSelectedItem() != null) {
                    recurso.setEstado(cbEstado.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }
                /*if (cbRol.getSelectedItem() != null) {
                    usuario.setRol(cbRol.getSelectedItem().toString());
                } else {
                    usuario.setRol("Encargado");
                }*/
                Boolean resultado = recursoBL.guardarRecurso(recurso);
                if (resultado) {
                    CargarTablaLibros();
                    limpiarTextoLibro();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigo.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnRegistrarLIBROActionPerformed

    private void btnModificarLIBROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLIBROActionPerformed

        if (recursoBL.validarCodigoRecurso(txtCodigo.getText(), idRecursoSeleccionado)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                recurso.setNombre(txtTitulo.getText());
                recurso.setAutor(txtAutor.getText());
                recurso.setCodigo(txtCodigo.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaDeRegistro.getText()).getTime()));
                recurso.setUbicacion(txtUbicacion.getText());
                recurso.setDescripcion(txtDescripcion.getText());
                recurso.setTipoRecurso("LIBRO");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }
                if (cbEstado.getSelectedItem() != null) {
                    recurso.setEstado(cbEstado.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }
                recurso.setEditorial(txtEditorial.getText());
                Boolean resultado = recursoBL.modificarRecurso(recurso);
                if (resultado) {
                    CargarTablaLibros();
                    limpiarTextoLibro();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigo.getText() + " ya se encuentra registrado, intenta con otro.");
        }

    }//GEN-LAST:event_btnModificarLIBROActionPerformed

    private void btnElimnarLIBROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimnarLIBROActionPerformed
        if (tbLibros.getSelectedRow() != -1) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro usted seguro de eliminar el libro: " + txtTitulo.getText() + " ?.", "Salir", dialog);
            if (result == 0) {
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                Boolean resultado = recursoBL.eliminarRecurso(recurso);
                if (resultado) {
                    CargarTablaLibros();
                    limpiarTextoLibro();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro.");
        }
    }//GEN-LAST:event_btnElimnarLIBROActionPerformed

    private void txtBuscarLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarLibroKeyReleased
        if (txtBuscarLibro.getText().isEmpty()) {
            CargarTablaLibros();
        } else {
            String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "AUTOR", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "EDITORIAL", "DESCRIPCION"};
            String[] registros = new String[10];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Recursos recursoBusqueda = new Modelo.Recursos();
            recursoBusqueda.setCodigo(txtBuscarLibro.getText());
            recursoBusqueda.setNombre(txtBuscarLibro.getText());
            recursoBusqueda.setAutor(txtBuscarLibro.getText());
            recursoBusqueda.setEstado(txtBuscarLibro.getText());
            recursoBusqueda.setUbicacion(txtBuscarLibro.getText());
            recursoBusqueda.setEditorial(txtBuscarLibro.getText());

            List resultado = recursoBL.buscarRecursos(recursoBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Recursos recurso : recursos) {
                    registros[0] = String.valueOf(recurso.getIdRecurso());
                    registros[1] = recurso.getTipoRecurso();
                    registros[2] = recurso.getCodigo();
                    registros[3] = recurso.getNombre();
                    registros[4] = recurso.getAutor();
                    registros[5] = dateFormat.format(recurso.getFecha());
                    registros[6] = recurso.getEstado();
                    registros[7] = recurso.getUbicacion();
                    registros[8] = recurso.getEditorial();
                    registros[9] = recurso.getDescripcion();

                    model.addRow(registros);
                }
            }
            tbLibros.setModel(model);
        }
    }//GEN-LAST:event_txtBuscarLibroKeyReleased

    private void btnRegistrarCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCDActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigocd.getText(), null)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setNombre(txtNombrecd.getText());
                recurso.setUbicacion(txtUbicacioncd.getText());
                recurso.setCodigo(txtCodigocd.getText());
                recurso.setDescripcion(txtDescripcioncd.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechacd.getText()).getTime()));
                recurso.setTipoRecurso("CD");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }

                if (cbEstado.getSelectedItem() != null) {
                    recurso.setEstado(cbEstado.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }
                Boolean resultado = recursoBL.guardarRecurso(recurso);
                if (resultado) {
                    CargarTablacd();
                    limpiarTextocd();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigocd.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnRegistrarCDActionPerformed

    private void btnModificarCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCDActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigocd.getText(), idRecursoSeleccionado)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                recurso.setNombre(txtNombrecd.getText());
                recurso.setCodigo(txtCodigocd.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechacd.getText()).getTime()));
                recurso.setUbicacion(txtUbicacioncd.getText());
                recurso.setDescripcion(txtDescripcioncd.getText());
                recurso.setTipoRecurso("CD");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }
                if (cbEstadocd.getSelectedItem() != null) {
                    recurso.setEstado(cbEstadocd.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }

                Boolean resultado = recursoBL.modificarRecurso(recurso);
                if (resultado) {
                    CargarTablacd();
                    limpiarTextocd();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigocd.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnModificarCDActionPerformed

    private void btnElimnarCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimnarCDActionPerformed
        if (tbCDS.getSelectedRow() != -1) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro usted seguro de eliminar el libro: " + txtNombrecd.getText() + " ?.", "Salir", dialog);
            if (result == 0) {
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                Boolean resultado = recursoBL.eliminarRecurso(recurso);
                if (resultado) {
                    CargarTablacd();
                    limpiarTextocd();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro.");
        }
    }//GEN-LAST:event_btnElimnarCDActionPerformed

    private void txtBuscartodocdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscartodocdKeyReleased
        if (txtBuscartodocd.getText().isEmpty()) {
            CargarTablacd();
        } else {
            String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
            String[] registros = new String[8];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Recursos recursoBusqueda = new Modelo.Recursos();
            recursoBusqueda.setCodigo(txtBuscartodocd.getText());
            recursoBusqueda.setNombre(txtBuscartodocd.getText());
            recursoBusqueda.setEstado(txtBuscartodocd.getText());
            recursoBusqueda.setUbicacion(txtBuscartodocd.getText());

            List resultado = recursoBL.buscarRecursos(recursoBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Recursos recurso : recursos) {
                    registros[0] = String.valueOf(recurso.getIdRecurso());
                    registros[1] = recurso.getTipoRecurso();
                    registros[2] = recurso.getCodigo();
                    registros[3] = recurso.getNombre();
                    registros[4] = dateFormat.format(recurso.getFecha());
                    registros[5] = recurso.getEstado();
                    registros[6] = recurso.getUbicacion();
                    registros[7] = recurso.getDescripcion();

                    model.addRow(registros);
                }
            }
            tbCDS.setModel(model);
        }


    }//GEN-LAST:event_txtBuscartodocdKeyReleased

    private void btnRegistrarREVISTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarREVISTASActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigoREVISTAS.getText(), null)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setNombre(txtNombreREVISTAS.getText());
                recurso.setUbicacion(txtUbicacionREVISTAS.getText());
                recurso.setCodigo(txtCodigoREVISTAS.getText());
                recurso.setDescripcion(txtDescripcionREVISTAS.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaREVISTAS.getText()).getTime()));
                recurso.setTipoRecurso("REVISTA");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }

                if (cbEstadoREVISTAS.getSelectedItem() != null) {
                    recurso.setEstado(cbEstadoREVISTAS.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }
                Boolean resultado = recursoBL.guardarRecurso(recurso);
                if (resultado) {
                    CargarTablaREVISTAS();
                    limpiarTextoREVISTAS();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigoREVISTAS.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnRegistrarREVISTASActionPerformed

    private void btnModificarREVISTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarREVISTASActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigoREVISTAS.getText(), idRecursoSeleccionado)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                recurso.setNombre(txtNombreREVISTAS.getText());
                recurso.setCodigo(txtCodigoREVISTAS.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaREVISTAS.getText()).getTime()));
                recurso.setUbicacion(txtUbicacionREVISTAS.getText());
                recurso.setDescripcion(txtDescripcionREVISTAS.getText());
                recurso.setTipoRecurso("REVISTA");
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }
                if (cbEstadoREVISTAS.getSelectedItem() != null) {
                    recurso.setEstado(cbEstadoREVISTAS.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }

                Boolean resultado = recursoBL.modificarRecurso(recurso);
                if (resultado) {
                    CargarTablaREVISTAS();
                    limpiarTextoREVISTAS();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigoREVISTAS.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnModificarREVISTASActionPerformed

    private void btnElimnarREVISTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimnarREVISTASActionPerformed
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro usted seguro de eliminar la revista: " + txtNombreREVISTAS.getText() + " ?.", "Salir", dialog);

        if (tbREVISTAS.getSelectedRow() != -1) {

            if (result == 0) {
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                Boolean resultado = recursoBL.eliminarRecurso(recurso);
                if (resultado) {
                    CargarTablaREVISTAS();
                    limpiarTextoREVISTAS();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro.");
        }
    }//GEN-LAST:event_btnElimnarREVISTASActionPerformed

    private void txtBuscartodoREVISTASKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscartodoREVISTASKeyReleased
        if (txtBuscartodoREVISTAS.getText().isEmpty()) {
            CargarTablaREVISTAS();
        } else {
            String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
            String[] registros = new String[8];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Recursos recursoBusqueda = new Modelo.Recursos();
            recursoBusqueda.setCodigo(txtBuscartodoREVISTAS.getText());
            recursoBusqueda.setNombre(txtBuscartodoREVISTAS.getText());
            recursoBusqueda.setEstado(txtBuscartodoREVISTAS.getText());
            recursoBusqueda.setUbicacion(txtBuscartodoREVISTAS.getText());

            List resultado = recursoBL.buscarRecursos(recursoBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Recursos recurso : recursos) {
                    registros[0] = String.valueOf(recurso.getIdRecurso());
                    registros[1] = recurso.getTipoRecurso();
                    registros[2] = recurso.getCodigo();
                    registros[3] = recurso.getNombre();
                    registros[4] = dateFormat.format(recurso.getFecha());
                    registros[5] = recurso.getEstado();
                    registros[6] = recurso.getUbicacion();
                    registros[7] = recurso.getDescripcion();

                    model.addRow(registros);
                }
            }
            tbREVISTAS.setModel(model);
        }


    }//GEN-LAST:event_txtBuscartodoREVISTASKeyReleased

    private void btnRegistrarOTROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarOTROSActionPerformed
        if (recursoBL.validarCodigoRecurso(txtCodigoOTROS.getText(), null)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setNombre(txtNombreOTROS.getText());
                recurso.setUbicacion(txtUbicacionOTROS.getText());
                recurso.setCodigo(txtCodigoOTROS.getText());
                recurso.setDescripcion(txtDescripcionOTROS.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaOTROS.getText()).getTime()));
                recurso.setTipoRecurso(txtTipoDeRecursoOTROS.getText());
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }

                if (cbEstadoOTROS.getSelectedItem() != null) {
                    recurso.setEstado(cbEstadoOTROS.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }
                Boolean resultado = recursoBL.guardarRecurso(recurso);
                if (resultado) {
                    CargarTablaOTROS();
                    limpiarTextoOTROS();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigoOTROS.getText() + " ya se encuentra registrado, intenta con otro.");
        }
    }//GEN-LAST:event_btnRegistrarOTROSActionPerformed

    private void btnModificarOTROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarOTROSActionPerformed

        if (recursoBL.validarCodigoRecurso(txtCodigoOTROS.getText(), idRecursoSeleccionado)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                recurso.setNombre(txtNombreOTROS.getText());
                recurso.setCodigo(txtCodigoOTROS.getText());
                recurso.setFecha(new java.sql.Timestamp(dateFormat.parse(txtFechaOTROS.getText()).getTime()));
                recurso.setUbicacion(txtUbicacionOTROS.getText());
                recurso.setDescripcion(txtDescripcionOTROS.getText());
                recurso.setTipoRecurso(txtTipoDeRecursoOTROS.getText());
                if (UsuarioBL.usuario != null) {
                    recurso.setIdusuario(UsuarioBL.usuario.getIdUsuario());
                }
                if (cbEstadoOTROS.getSelectedItem() != null) {
                    recurso.setEstado(cbEstadoOTROS.getSelectedItem().toString());
                } else {
                    recurso.setEstado("Activo");
                }

                Boolean resultado = recursoBL.modificarRecurso(recurso);
                if (resultado) {
                    CargarTablaOTROS();
                    limpiarTextoOTROS();
                }
            } catch (ParseException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El Codigo " + txtCodigoOTROS.getText() + " ya se encuentra registrado, intenta con otro.");
        }

    }//GEN-LAST:event_btnModificarOTROSActionPerformed

    private void btnElimnarOTROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimnarOTROSActionPerformed
        if (tbOTROS.getSelectedRow() != -1) {
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro usted seguro de eliminar la revista: " + txtNombreOTROS.getText() + " ?.", "Salir", dialog);
            if (result == 0) {
                Modelo.Recursos recurso = new Modelo.Recursos();
                recurso.setIdrecurso(idRecursoSeleccionado);
                Boolean resultado = recursoBL.eliminarRecurso(recurso);
                if (resultado) {
                    CargarTablaOTROS();
                    limpiarTextoOTROS();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un registro.");
        }
    }//GEN-LAST:event_btnElimnarOTROSActionPerformed

    private void txtBuscartodoOTROSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscartodoOTROSKeyReleased
        if (txtBuscartodoOTROS.getText().isEmpty()) {
            CargarTablaOTROS();
        } else {
            String[] titulos = {"ID", "TIPO DE RECURSO", "CODIGO", "TITULO", "FECHA DE REGISTRO", "ESTADO", "UBICACION", "DESCRIPCION"};
            String[] registros = new String[9];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            Modelo.Recursos recursoBusqueda = new Modelo.Recursos();
            recursoBusqueda.setCodigo(txtBuscartodoOTROS.getText());
            recursoBusqueda.setNombre(txtBuscartodoOTROS.getText());
            recursoBusqueda.setEstado(txtBuscartodoOTROS.getText());
            recursoBusqueda.setUbicacion(txtBuscartodoOTROS.getText());

            List resultado = recursoBL.buscarRecursos(recursoBusqueda);
            if (resultado != null && resultado.size() > 0) {
                ArrayList<Modelo.Recursos> recursos = (ArrayList<Modelo.Recursos>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Recursos recurso : recursos) {
                    registros[0] = String.valueOf(recurso.getIdRecurso());
                    registros[1] = recurso.getTipoRecurso();
                    registros[2] = recurso.getCodigo();
                    registros[3] = recurso.getNombre();
                    registros[4] = dateFormat.format(recurso.getFecha());
                    registros[5] = recurso.getEstado();
                    registros[6] = recurso.getUbicacion();
                    registros[7] = recurso.getDescripcion();

                    model.addRow(registros);
                }
            }
            tbOTROS.setModel(model);
        }


    }//GEN-LAST:event_txtBuscartodoOTROSKeyReleased

    private void txtCodigoEstudiantePRESTAMOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoEstudiantePRESTAMOSKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoEstudiantePRESTAMOSKeyTyped

    private void txtFechaPrestamoPRESTAMOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaPrestamoPRESTAMOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPrestamoPRESTAMOKeyTyped

    private void txtCodigoRecursoPRESTAMOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoRecursoPRESTAMOKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoRecursoPRESTAMOKeyTyped

    private void btnRegistarPRESTAMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarPRESTAMOActionPerformed
        if (txtCodigoRecursoPRESTAMO.getText() == null || txtCodigoRecursoPRESTAMO.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El codigo del recurso es obligatorio.");
            return;
        }
        Recursos verificar = new Recursos();
        verificar.setCodigo(txtCodigoRecursoPRESTAMO.getText());
        List recursos = recursoBL.buscarRecursos(verificar);
        if (recursos != null && recursos.size() > 0) {
            //verificar que el recursos no se encuntre prestado
            if (prestamoBL.validarCodigoRecursoPrestamo(txtCodigoRecursoPRESTAMO.getText())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Modelo.Prestamo prestamo = new Modelo.Prestamo();
                prestamo.setCodEstudiante(Integer.parseInt(txtCodigoEstudiantePRESTAMOS.getText()));
                java.util.Date fechaActual = new java.util.Date();
                prestamo.setFechaDevolucion(new java.sql.Timestamp(fechaActual.getTime()));
                prestamo.setDiasPrestacion(Integer.parseInt(txtDiasPrestacion.getText()));
                prestamo.setApellido(txtApellidoPrestamo.getText());
                prestamo.setFechaPrestamo(prestamo.getFechaDevolucion());
                prestamo.setIdrecurso(((Recursos) recursos.get(0)).getIdRecurso());
                if (UsuarioBL.usuario != null) {
                    prestamo.setIdusuarioEntrada(UsuarioBL.usuario.getIdUsuario());
                }
                prestamo.setEstado("Activo");
                Boolean resultado = prestamoBL.guardarPrestamo(prestamo);
                if (resultado) {
                    CargarTablaPRESTAMO();
                    limpiarTextoPrestamo();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El recurso con código: " + txtCodigoRecursoPRESTAMO.getText() + " se encuentra PRESTADO.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El código del recurso: " + txtCodigoRecursoPRESTAMO.getText() + " no se encuentra registrado. Intenta con un código de recurso valido.");
        }
    }//GEN-LAST:event_btnRegistarPRESTAMOActionPerformed

    private void txtFechaDevolucionPRESTAMOS2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaDevolucionPRESTAMOS2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDevolucionPRESTAMOS2KeyTyped

    private void btnGenerarREPORTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarREPORTE1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Selecione un directorio para guardar el reporte: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                Reporte.Reporte.reporteRecursos(jfc.getSelectedFile() + "\\reporteRecursos.xls");
            }
        }
    }//GEN-LAST:event_btnGenerarREPORTE1ActionPerformed

    private void btnModificarPRESTAMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPRESTAMOActionPerformed
        if (txtCodigoRecursoPRESTAMO.getText() == null || txtCodigoRecursoPRESTAMO.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "El codigo del recurso es obligatorio.");
            return;
        }
        Recursos verificar = new Recursos();
        verificar.setCodigo(txtCodigoRecursoPRESTAMO.getText());
        List recursos = recursoBL.buscarRecursos(verificar);
        if (recursos != null && recursos.size() > 0) {
            //verificar que el recursos se encuntre prestado
            if (tbPRESTAMO.getSelectedRow() != -1) {
                try {
                    if (!prestamoBL.validarCodigoRecursoPrestamo(txtCodigoRecursoPRESTAMO.getText())) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        Modelo.Prestamo prestamo = prestamoBL.buscarPrestamoById(idPrestamoSeleccionado);
                        if (prestamo != null) {
                            prestamo.setIdPrestamo(idPrestamoSeleccionado);
                            //prestamo.setCodEstudiante(Integer.parseInt(txtCodigoEstudiantePRESTAMOS.getText()));
                            prestamo.setFechaPrestamo(new java.sql.Timestamp(dateFormat.parse(txtFechaPrestamoPRESTAMO.getText()).getTime()));
                            java.util.Date fechaActual = new java.util.Date();
                            prestamo.setFechaDevolucion(new java.sql.Timestamp(fechaActual.getTime()));
                            prestamo.setIdrecurso(((Recursos) recursos.get(0)).getIdRecurso());
                            prestamo.setApellido(txtApellidoPrestamo.getText());
                            prestamo.setDiasPrestacion(Integer.parseInt(txtDiasPrestacion.getText()));
                            if (UsuarioBL.usuario != null) {
                                prestamo.setIdusuarioSalida(UsuarioBL.usuario.getIdUsuario());
                            }
                            prestamo.setEstado("Inactivo");

                            Boolean resultado = prestamoBL.modificarPrestamo(prestamo);
                            if (resultado) {
                                CargarTablaPRESTAMO();
                                limpiarTextoPrestamo();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El recurso con codigo: " + txtCodigoRecursoPRESTAMO.getText() + ", ya se encuntra disponible.");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Seleccione un prestamo.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "El codigo de recurso: " + txtCodigoRecursoPRESTAMO.getText() + " no se encuentra registrado. Intenta con otro.");
        }
    }//GEN-LAST:event_btnModificarPRESTAMOActionPerformed

    private void txtBuscarPRESTAMOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPRESTAMOKeyReleased
        if (txtBuscarPRESTAMO.getText().isEmpty()) {
            CargarTablaPRESTAMO();
        } else {
            String[] titulos = {"ID PRESTAMO", "CODIGO RECURSO", "CODIGO DEL ESTUDIANTE", "FECHA DE PRESTAMO", "FECHA DE DEVOLUCION", "ESTADO", "USUARIO ENTRADA", "USUARIO SALIDA"};
            String[] registros = new String[8];

            model = new DefaultTableModel(null, titulos);
            model.setRowCount(0);
            List resultado = prestamoBL.buscarPrestamo(txtBuscarPRESTAMO.getText());
            if (resultado != null && resultado.size() > 0) {
                //ArrayList<Modelo.Usuario> usuarios = (ArrayList<Modelo.Usuario>) resultado;
                ArrayList<Modelo.Prestamo> prestamos = (ArrayList<Modelo.Prestamo>) resultado;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (Modelo.Prestamo prestamo : prestamos) {
                    registros[0] = String.valueOf(prestamo.getIdPrestamo());
                    registros[1] = String.valueOf(prestamo.getCodigoRecurso());
                    registros[2] = String.valueOf(prestamo.getCodEstudiante());
                    registros[3] = dateFormat.format(prestamo.getFechaPrestamo());
                    registros[4] = dateFormat.format(prestamo.getFechaDevolucion());
                    registros[5] = prestamo.getEstado();
                    registros[6] = String.valueOf(prestamo.getNombreUsuarioEntrega());
                    registros[7] = String.valueOf(prestamo.getNombreUsuarioSalida());

                    model.addRow(registros);
                }
            }
            tbPRESTAMO.setModel(model);
        }
    }//GEN-LAST:event_txtBuscarPRESTAMOKeyReleased

    private void txtDiasPrestacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasPrestacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasPrestacionKeyTyped

    private void txtApellidoPrestamoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPrestamoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPrestamoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Selecione un directorio para guardar el reporte: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                Reporte.Reporte2.reporteuso(jfc.getSelectedFile() + "\\reporteRecur.xls");
            }
        }    
    }//GEN-LAST:event_jButton1ActionPerformed
    // cambiar de color para el menu pero solo en los botones
    public void setLblColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 130, 240));
    }

    public void resetLblColor(JLabel lbl) {
        lbl.setBackground(new Color(0, 151, 247));
    }

    // cambiar de color para el gestion
    public void setColor(JPanel panel1) {
        panel1.setBackground(new java.awt.Color(58, 71, 97));
    }

    public void resetColor(JPanel panel1) {
        panel1.setBackground(new java.awt.Color(33, 42, 58));
    }

    public void resetColor2(JPanel panel1) {
        panel1.setBackground(new java.awt.Color(37, 47, 67));
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
            java.util.logging.Logger.getLogger(Encargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encargado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Encargado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Gestionar;
    private javax.swing.JPanel GestionarCDS;
    private javax.swing.JPanel GestionarLibros;
    private javax.swing.JPanel GestionarOtros;
    private javax.swing.JPanel GestionarRevistas;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Minimizar;
    private javax.swing.JLabel MoverConElCursor;
    private javax.swing.JPanel PedidosLibros;
    private javax.swing.JPanel Prestamos;
    private javax.swing.JPanel Reportes;
    private javax.swing.JPanel Salir;
    private javax.swing.JPanel aniGestionar;
    private javax.swing.JPanel aniPrestamos;
    private javax.swing.JPanel aniReportes;
    private javax.swing.JLabel autor1;
    private javax.swing.JLabel autor10;
    private javax.swing.JLabel autor11;
    private javax.swing.JLabel autor12;
    private javax.swing.JLabel autor13;
    private javax.swing.JLabel autor14;
    private javax.swing.JLabel autor15;
    private javax.swing.JLabel autor16;
    private javax.swing.JLabel autor17;
    private javax.swing.JLabel autor18;
    private javax.swing.JLabel autor25;
    private javax.swing.JLabel autor26;
    private javax.swing.JLabel autor27;
    private javax.swing.JLabel autor28;
    private javax.swing.JLabel autor29;
    private javax.swing.JLabel autor3;
    private javax.swing.JLabel autor35;
    private javax.swing.JLabel autor36;
    private javax.swing.JLabel autor37;
    private javax.swing.JLabel autor38;
    private javax.swing.JLabel autor4;
    private javax.swing.JLabel autor41;
    private javax.swing.JLabel autor42;
    private javax.swing.JLabel autor43;
    private javax.swing.JLabel autor46;
    private javax.swing.JLabel autor47;
    private javax.swing.JLabel autor48;
    private javax.swing.JLabel autor49;
    private javax.swing.JLabel autor5;
    private javax.swing.JLabel autor54;
    private javax.swing.JLabel autor55;
    private javax.swing.JLabel autor56;
    private javax.swing.JLabel autor58;
    private javax.swing.JLabel autor6;
    private javax.swing.JLabel autor7;
    private javax.swing.JLabel autor8;
    private javax.swing.JLabel autor9;
    private javax.swing.JLabel btnCDS;
    private javax.swing.JButton btnElimnarCD;
    private javax.swing.JButton btnElimnarLIBRO;
    private javax.swing.JButton btnElimnarOTROS;
    private javax.swing.JButton btnElimnarREVISTAS;
    private javax.swing.JButton btnGenerarREPORTE1;
    private javax.swing.JLabel btnGestionar;
    private javax.swing.JLabel btnInsterfazdeUsuario;
    private javax.swing.JLabel btnLibros1;
    private javax.swing.JButton btnModificarCD;
    private javax.swing.JButton btnModificarLIBRO;
    private javax.swing.JButton btnModificarOTROS;
    private javax.swing.JButton btnModificarPRESTAMO;
    private javax.swing.JButton btnModificarREVISTAS;
    private javax.swing.JLabel btnOtros;
    private javax.swing.JLabel btnPrestamos;
    private javax.swing.JButton btnRegistarPRESTAMO;
    private javax.swing.JButton btnRegistrarCD;
    private javax.swing.JButton btnRegistrarLIBRO;
    private javax.swing.JButton btnRegistrarOTROS;
    private javax.swing.JButton btnRegistrarREVISTAS;
    private javax.swing.JLabel btnReportes;
    private javax.swing.JLabel btnRevistas;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnSalir2;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel buscar2;
    private javax.swing.JLabel buscar3;
    private javax.swing.JLabel buscar4;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbEstadoOTROS;
    private javax.swing.JComboBox<String> cbEstadoPRESTAMO;
    private javax.swing.JComboBox<String> cbEstadoREVISTAS;
    private javax.swing.JComboBox<String> cbEstadocd;
    private javax.swing.JPanel cerrarSeccion;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel estado1;
    private javax.swing.JLabel estado3;
    private javax.swing.JLabel estado4;
    private javax.swing.JLabel estado5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFecha2;
    private javax.swing.JLabel lbFecha3;
    private javax.swing.JLabel lbFecha4;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JPanel panelCD;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JPanel panelOtros;
    private javax.swing.JPanel panelRevistas;
    private javax.swing.JTable tbCDS;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTable tbOTROS;
    private javax.swing.JTable tbPRESTAMO;
    private javax.swing.JTable tbREVISTAS;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo10;
    private javax.swing.JLabel titulo11;
    private javax.swing.JLabel titulo12;
    private javax.swing.JLabel titulo13;
    private javax.swing.JLabel titulo14;
    private javax.swing.JLabel titulo15;
    private javax.swing.JLabel titulo16;
    private javax.swing.JLabel titulo17;
    private javax.swing.JLabel titulo18;
    private javax.swing.JLabel titulo23;
    private javax.swing.JLabel titulo24;
    private javax.swing.JLabel titulo25;
    private javax.swing.JLabel titulo26;
    private javax.swing.JLabel titulo27;
    private javax.swing.JLabel titulo28;
    private javax.swing.JLabel titulo29;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    private javax.swing.JLabel titulo8;
    private javax.swing.JLabel titulo9;
    private javax.swing.JLabel tituloOtros;
    private javax.swing.JLabel tituloRevistas;
    private javax.swing.JLabel tituloRevistas1;
    private javax.swing.JTextField txtApellidoPrestamo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscarLibro;
    private javax.swing.JTextField txtBuscarPRESTAMO;
    private javax.swing.JTextField txtBuscartodoOTROS;
    private javax.swing.JTextField txtBuscartodoREVISTAS;
    private javax.swing.JTextField txtBuscartodocd;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoEstudiantePRESTAMOS;
    private javax.swing.JTextField txtCodigoOTROS;
    private javax.swing.JTextField txtCodigoREVISTAS;
    private javax.swing.JTextField txtCodigoRecursoPRESTAMO;
    private javax.swing.JTextField txtCodigocd;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcionOTROS;
    private javax.swing.JTextField txtDescripcionREVISTAS;
    private javax.swing.JTextField txtDescripcioncd;
    private javax.swing.JTextField txtDiasPrestacion;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtFechaDeRegistro;
    private javax.swing.JTextField txtFechaDevolucionPRESTAMOS2;
    private javax.swing.JTextField txtFechaOTROS;
    private javax.swing.JTextField txtFechaPrestamoPRESTAMO;
    private javax.swing.JTextField txtFechaREVISTAS;
    private javax.swing.JTextField txtFechacd;
    private javax.swing.JTextField txtNombreOTROS;
    private javax.swing.JTextField txtNombreREVISTAS;
    private javax.swing.JTextField txtNombrecd;
    private javax.swing.JTextField txtTipoDeRecursoOTROS;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUbicacion;
    private javax.swing.JTextField txtUbicacionOTROS;
    private javax.swing.JTextField txtUbicacionREVISTAS;
    private javax.swing.JTextField txtUbicacioncd;
    // End of variables declaration//GEN-END:variables
    conexion cc = new conexion();
    Connection conect = cc.obtenerConexion();
}
