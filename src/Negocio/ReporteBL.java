
package Negocio;

import DAO.ReporteDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteBL {

    private ReporteDAO reporteDAO;

    public ReporteBL() {
        this.reporteDAO = new ReporteDAO();
    }

    public List consultarRecursos(Connection conn) {
        try {
            return this.reporteDAO.listRecursosQuery(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List consultarusos(Connection conn) {
        try {
            return this.reporteDAO.listusosQuery(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
