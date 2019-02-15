package DAO;
import Modelo.Recursos;
import Modelo.Prestamo;
import Modelo.ReportePrestamo;
import Modelo.ReporteRecurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    public List listRecursosQuery(Connection conn) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT r.Id_Recurso,r.Codigo,r.Nombre,r.Fecha,r.Editorial,r.Descripcion,r.Autor,r.Estado,r.Ubicacion,r.Tipo_Recurso,r.Id_usuario,concat(u.Nombres,' ',u.Apellidos) AS nombreUsuario FROM recurso r "
                    + "JOIN usuario u ON r.Id_usuario=u.Id_usuario";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                ReporteRecurso temp = new ReporteRecurso();

                temp.setIdrecurso(result.getInt("id_Recurso"));
                temp.setCodigo(result.getString("Codigo"));
                temp.setNombre(result.getString("Nombre"));
                temp.setFecha(result.getTimestamp("Fecha"));
                temp.setEditorial(result.getString("Editorial"));
                temp.setDescripcion(result.getString("Descripcion"));
                temp.setAutor(result.getString("Autor"));
                temp.setEstado(result.getString("Estado"));
                temp.setUbicacion(result.getString("Ubicacion"));
                temp.setTipoRecurso(result.getString("Tipo_Recurso"));
                temp.setIdusuario((Integer) result.getObject("Id_usuario"));
                temp.setNombreUsuario(result.getString("nombreUsuario"));
                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return (List) searchResults;
    }
        public List listusosQuery(Connection conn) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT count(r.Id_Recurso) as Cantidad,r.Codigo,r.Nombre,r.Tipo_Recurso,GROUP_CONCAT(distinct p.Apellido) as Estudiantes FROM prestamo p JOIN recurso r ON p.Id_Recurso=r.Id_Recurso\n" +
                        "GROUP BY r.Id_Recurso,r.Codigo,r.Nombre\n" +
                        "ORDER BY Cantidad DESC";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                ReporteRecurso temp = new ReporteRecurso();
                //temp.setIdrecurso(result.getInt("Id_Recurso"));
                temp.setCodigo(result.getString("Codigo"));
                temp.setNombre(result.getString("Nombre"));
                temp.setTipoRecurso(result.getString("Tipo_Recurso"));
                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return (List) searchResults;
    }
}
