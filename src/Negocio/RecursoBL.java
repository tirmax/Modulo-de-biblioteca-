package Negocio;
import DAO.NotFoundException;
import DAO.RecursoDao;
import DAO.conexion;
import Modelo.Recursos;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursoBL {

    private RecursoDao recursoDao;

    public RecursoBL() {
        this.recursoDao = new RecursoDao();
    }

    public List listarRecursos(String tipo) {
        Recursos recurso = new Recursos();
        recurso.setTipoRecurso(tipo);
        try {
            return (tipo != null) ? recursoDao.searchMatching(conexion.obtenerConexion(), recurso) : recursoDao.loadAll(conexion.obtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Boolean guardarRecurso(Recursos recurso) {
        Boolean resultado = false;
        try {
            recursoDao.create(conexion.obtenerConexion(), recurso);
            Recursos recursoValidar = new Recursos();
            recursoValidar.setCodigo(recurso.getCodigo());
            List recursos = recursoDao.searchMatching(conexion.obtenerConexion(), recursoValidar);
            resultado = (recursos != null && recursos.size() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public List listarRecursos() {
        try {
            return recursoDao.loadAll(conexion.obtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(RecursoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Boolean validarCodigoRecurso(String codigo, Integer idRecurso) {
        Boolean resultado = false;
        Recursos recurso_ = new Recursos();
        recurso_.setCodigo(codigo);
        try {
            ArrayList<Recursos> recursos = (ArrayList<Recursos>) recursoDao.searchMatching(conexion.obtenerConexion(), recurso_);
            Recursos validarRecurso = (recursos != null && recursos.size() > 0) ? recursos.get(0) : null;
            //si no existe un recurso con ese Codigo se puede agregar
            resultado = validarRecurso == null;
            // al momento de editar se debe veririfar que el codigo del usuario recuperado no coincida con el codigo del usuario enviado a validar
            //si es diferente de nulo estamos modificando
            if (idRecurso != null) {
                //si es el mismo usuario se puede asignar el mismo codigo
                if (validarRecurso != null && validarRecurso.getIdRecurso()== idRecurso) {
                    resultado = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public Boolean modificarRecurso(Recursos recurso) {
        Boolean resultado = false;
        try {
            recursoDao.save(conexion.obtenerConexion(), recurso);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
        public Boolean eliminarRecurso(Recursos recurso) {
        Boolean resultado = false;
        try {
            recursoDao.delete(conexion.obtenerConexion(), recurso);
            Recursos recursoValidar = new Recursos();
            recursoValidar.setIdrecurso(recurso.getIdRecurso());
            List recursos = recursoDao.searchMatching(conexion.obtenerConexion(), recursoValidar);
            resultado = !(recursos != null && recursos.size() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
        public List buscarRecursos(Recursos recurso) {
        try {
            return recursoDao.searchByLibros(conexion.obtenerConexion(), recurso);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
