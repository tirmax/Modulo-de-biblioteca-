package Negocio;

import DAO.NotFoundException;
import DAO.UsuarioDao;
import DAO.conexion;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBL {

    public static Usuario usuario = null;

    private UsuarioDao usuarioDao;

    public UsuarioBL() {
        this.usuarioDao = new UsuarioDao();
    }

    public Boolean validarCodigoUsuario(String login, Integer idUsuario) {
        Boolean resultado = false;
        Usuario usuario_ = new Usuario();
        usuario_.setCodigo(login);
        try {
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDao.searchMatching(conexion.obtenerConexion(), usuario_);
            Usuario validarUsuario = (usuarios != null && usuarios.size() > 0) ? usuarios.get(0) : null;
            //si no existe un usuario con ese Codigo se puede agregar
            resultado = validarUsuario == null;
            // al momento de editar se debe veririfar que el codigo del usuario recuperado no coincida con el codigo del usuario enviado a validar
            //si es diferente de nulo estamos modificando
            if (idUsuario != null) {
                //si es el mismo usuario se puede asignar el mismo codigo
                if (validarUsuario != null && validarUsuario.getIdUsuario() == idUsuario) {
                    resultado = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean verificarUsuario(String login, String pass) {
        Boolean resultado = false;
        Usuario usuario_ = new Usuario();
        usuario_.setCodigo(login);
        usuario_.setConatrseña(pass);
        try {
            List usuarios = usuarioDao.searchMatching(conexion.obtenerConexion(), usuario_);
            resultado = (usuarios != null && usuarios.size() > 0);
            usuario = (usuarios != null && usuarios.size() > 0) ? (Usuario) usuarios.get(0) : null;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List listarUsuarios() {
        try {
            return usuarioDao.loadAll(conexion.obtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List buscarUsuarios(Usuario usuario) {
        try {
            return usuarioDao.searchByNombresApellidosCodigo(conexion.obtenerConexion(), usuario);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Boolean guardarUsuario(Usuario usuario) {
        Boolean resultado = false;
        try {
            usuarioDao.create(conexion.obtenerConexion(), usuario);
            Usuario usuarioValidar = new Usuario();
            usuarioValidar.setCodigo(usuario.getCodigo());
            List usuarios = usuarioDao.searchMatching(conexion.obtenerConexion(), usuarioValidar);
            resultado = (usuarios != null && usuarios.size() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean modificarUsuario(Usuario usuario) {
        Boolean resultado = false;
        try {
            usuarioDao.save(conexion.obtenerConexion(), usuario);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean eliminarUsuario(Usuario usuario) {
        Boolean resultado = false;
        try {
            usuarioDao.delete(conexion.obtenerConexion(), usuario);
            Usuario usuarioValidar = new Usuario();
            usuarioValidar.setIdUsuario(usuario.getIdUsuario());
            List usuarios = usuarioDao.searchMatching(conexion.obtenerConexion(), usuarioValidar);
            resultado = !(usuarios != null && usuarios.size() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
