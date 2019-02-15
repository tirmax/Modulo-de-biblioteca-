package Negocio;

import DAO.NotFoundException;
//import DAO.RecursoDao;
import DAO.PrestamoDao;
import DAO.conexion;
import Modelo.Recursos;
import Modelo.Usuario;
import Modelo.Prestamo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamoBL {

    private PrestamoDao prestamoDao;

    public PrestamoBL() {
        this.prestamoDao = new PrestamoDao();
    }

    public Prestamo buscarPrestamoById(Integer idPrestamo) {
        Prestamo prestamo = new Prestamo();
        prestamo.setIdPrestamo(idPrestamo);
        try {
            return prestamoDao.getObject(conexion.obtenerConexion(), idPrestamo);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NotFoundException ex) {
            Logger.getLogger(PrestamoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Boolean guardarPrestamo(Prestamo prestamo) {
        Boolean resultado = false;
        try {
            prestamoDao.create(conexion.obtenerConexion(), prestamo);
            Prestamo prestamoValidar = new Prestamo();
            prestamoValidar.setCodigoRecurso(prestamo.getCodigoRecurso());
            prestamoValidar.setCodEstudiante(prestamo.getCodEstudiante());
            prestamoValidar.setEstado(prestamo.getEstado());
            prestamoValidar.setApellido(prestamo.getApellido());
            prestamoValidar.setDiasPrestacion(prestamo.getDiasPrestacion());
            List prestamos = prestamoDao.searchMatching(conexion.obtenerConexion(), prestamoValidar);
            resultado = (prestamos != null && prestamos.size() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List listarPrestamo() {
        try {
            return prestamoDao.loadAll(conexion.obtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Valiar si el codigo de un recursos ya existe en la tabla prestamo
     *
     * @param codigoRecurso
     * @return
     */
    public Boolean validarCodigoRecursoPrestamo(String codigoRecurso) {
        Boolean resultado = false;
        try {

            Prestamo p = new Prestamo();
            p.setCodigoRecurso(codigoRecurso);
            p.setEstado("Activo");
            ArrayList<Prestamo> prestamo = (ArrayList<Prestamo>) prestamoDao.searchMatching(conexion.obtenerConexion(), p);
            Prestamo validarPrestamo = (prestamo != null && prestamo.size() > 0) ? prestamo.get(0) : null;
            //si no existe un recurso con ese Codigo se puede agregar
            resultado = validarPrestamo == null;

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean modificarPrestamo(Prestamo prestamo) {
        Boolean resultado = false;
        try {
            prestamoDao.save(conexion.obtenerConexion(), prestamo);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List buscarPrestamo(String busqueda) {
        try {
            return prestamoDao.searchByPrestamo(conexion.obtenerConexion(), busqueda);
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
