package DAO;

import Modelo.Prestamo;
import Modelo.Recursos;
import java.sql.*;
import java.util.*;
import java.math.*;

public class PrestamoDao {

    public Prestamo createValueObject() {
        return new Prestamo();
    }

    public Prestamo getObject(Connection conn, int IdPrestamo) throws NotFoundException, SQLException {

        Prestamo valueObject = createValueObject();
        valueObject.setIdPrestamo(IdPrestamo);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Prestamo valueObject) throws NotFoundException, SQLException {

        String sql = "SELECT * FROM prestamo WHERE (Id_Prestamo= ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getIdPrestamo());

            singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public List loadAll(Connection conn) throws SQLException {

        String sql = "SELECT * FROM Prestamo ORDER BY Id_Prestamo ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql), false);

        return searchResults;
    }

    public synchronized void create(Connection conn, Prestamo valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql = "INSERT INTO prestamo ( Id_Prestamo, Id_Recurso, Cod_Estudiante, "
                    + "Fecha_Prestamo, Fecha_Devolucion, Estado, "
                    + "Id_usuario_Entrada, Id_usuario_Salida, Apellido, DiasPrestacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getIdPrestamo());
            stmt.setObject(2, valueObject.getIdrecurso(), Types.INTEGER);
            stmt.setObject(3, valueObject.getCodEstudiante(), Types.INTEGER);
            stmt.setTimestamp(4, valueObject.getFechaPrestamo());
            stmt.setTimestamp(5, valueObject.getFechaDevolucion());
            stmt.setString(6, valueObject.getEstado());
            stmt.setObject(7, valueObject.getIdusuarioEntrada(), Types.INTEGER);
            stmt.setObject(8, valueObject.getIdusuarioSalida(), Types.INTEGER);
            stmt.setString(9, valueObject.getApellido());
            stmt.setObject(10, valueObject.getDiasPrestacion(), Types.INTEGER);

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                //System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public void save(Connection conn, Prestamo valueObject)
            throws NotFoundException, SQLException {

        String sql = "UPDATE prestamo SET Id_recurso = ?, Cod_Estudiante = ?, Fecha_Prestamo = ?, "
                + "Fecha_Devolucion = ?, Estado = ?, Id_usuario_Entrada = ?,Id_usuario_Salida = ?, "
                + "Apellido = ?, DiasPrestacion = ? "
                + " WHERE (Id_Prestamo= ? ) ";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, valueObject.getIdrecurso(), Types.INTEGER);
            stmt.setObject(2, valueObject.getCodEstudiante(), Types.INTEGER);
            stmt.setTimestamp(3, valueObject.getFechaPrestamo());
            stmt.setTimestamp(4, valueObject.getFechaDevolucion());
            stmt.setString(5, valueObject.getEstado());
            stmt.setObject(6, valueObject.getIdusuarioEntrada(), Types.INTEGER);
            stmt.setObject(7, valueObject.getIdusuarioSalida(), Types.INTEGER);  
            stmt.setString(8, valueObject.getApellido());
            stmt.setObject(9, valueObject.getDiasPrestacion(), Types.INTEGER);
            stmt.setInt(10, valueObject.getIdPrestamo());
            
            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        }
    }

    public void delete(Connection conn, Prestamo valueObject)
            throws NotFoundException, SQLException {

        String sql = "DELETE FROM prestamo WHERE (Id_Prestamo= ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getIdPrestamo());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void deleteAll(Connection conn) throws SQLException {

        String sql = "DELETE FROM prestamo";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            int rowcount = databaseUpdate(conn, stmt);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public int countAll(Connection conn) throws SQLException {

        String sql = "SELECT count(*) FROM prestamo";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return allRows;
    }

    public List searchByPrestamo(Connection conn, String busqueda) throws SQLException {

        List searchResults;

        String sql = "SELECT * FROM(SELECT p.*,r.Codigo,r.Nombre,r.Descripcion,ifnull(concat(ue.Nombres,' ',ue.Apellidos),'') as usuarioEntrada ,ifnull(concat(ur.Nombres,' ',ur.Apellidos),'') as usuarioSalida FROM prestamo p "
                + "JOIN recurso r ON r.Id_Recurso=p.Id_Recurso "
                + "LEFT JOIN usuario ue ON p.Id_usuario_Entrada=ue.Id_usuario "
                + "LEFT JOIN usuario ur ON p.Id_usuario_Salida=ur.Id_usuario) AS recursos ";

        if (busqueda != null && !busqueda.isEmpty()) {
            sql = sql + " WHERE usuarioEntrada like'%" + busqueda + "%' "
                    + "OR usuarioSalida like '%" + busqueda + "%' "
                    + "OR codigo like '%" + busqueda + "%' "
                    + "OR Cod_Estudiante like '%" + busqueda + "%' "
                    + "OR Nombre like '%" + busqueda + "%' "
                    + "OR Descripcion like '%" + busqueda + "%' "
                    + "OR Estado like '%" + busqueda + "%' "
                    + "OR Fecha_Prestamo ='" + busqueda + "' "
                    + "OR Fecha_Devolucion ='" + busqueda + "' "
                    + "OR Apellido like '%" + busqueda + "%' "
                    + "OR DiasPrstacion like '%" + busqueda + "%' ";
        }

        searchResults = listQuery(conn, conn.prepareStatement(sql), true);

        return searchResults;
    }

    public List searchMatching(Connection conn, Prestamo valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM prestamo p JOIN recurso r ON r.Id_Recurso=p.Id_Recurso WHERE 1=1 ");

        if (valueObject.getIdPrestamo() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_Prestamo = ").append(valueObject.getIdPrestamo()).append(" ");
        }

        if (valueObject.getCodigoRecurso() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND r.Codigo = ").append(valueObject.getCodigoRecurso()).append(" ");
        }

        if (valueObject.getIdrecurso() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_recurso = ").append(valueObject.getIdrecurso()).append(" ");
        }

        if (valueObject.getCodEstudiante() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Cod_Estudiante = ").append(valueObject.getCodEstudiante()).append(" ");
        }

        if (valueObject.getFechaPrestamo() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Fecha_Prestamo = '").append(valueObject.getFechaPrestamo()).append("' ");
        }

        if (valueObject.getFechaDevolucion() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Fecha_Devolucion = '").append(valueObject.getFechaDevolucion()).append("' ");
        }

        if (valueObject.getEstado() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND p.Estado LIKE '").append(valueObject.getEstado()).append("%' ");
        }

        if (valueObject.getIdusuarioEntrada() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_usuario_Entrada = ").append(valueObject.getIdusuarioEntrada()).append(" ");
        }

        if (valueObject.getIdusuarioSalida() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_usuario_Salida = ").append(valueObject.getIdusuarioSalida()).append(" ");
        }
        if (valueObject.getDiasPrestacion()!= null) {
            if (first) {
                first = false;
            }
            sql.append("AND Apellido = ").append(valueObject.getDiasPrestacion()).append(" ");
        }        
        if (valueObject.getDiasPrestacion()!= null) {
            if (first) {
                first = false;
            }
            sql.append("AND DiasPrestacion = ").append(valueObject.getDiasPrestacion()).append(" ");
        }        

        sql.append("ORDER BY Id_Prestamo ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()), false);
        }

        return searchResults;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }

    protected void singleQuery(Connection conn, PreparedStatement stmt, Prestamo valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setIdPrestamo(result.getInt("Id_Prestamo"));
                valueObject.setIdrecurso((Integer) result.getObject("Id_recurso"));
                valueObject.setCodEstudiante((Integer) result.getObject("Cod_Estudiante"));
                valueObject.setFechaPrestamo(result.getTimestamp("Fecha_Prestamo"));
                valueObject.setFechaDevolucion(result.getTimestamp("Fecha_Devolucion"));
                valueObject.setEstado(result.getString("Estado"));
                valueObject.setIdusuarioEntrada((Integer) result.getObject("Id_usuario_Entrada"));
                valueObject.setIdusuarioSalida((Integer) result.getObject("Id_usuario_Salida"));
                valueObject.setApellido(result.getString("Apellido"));
                valueObject.setDiasPrestacion((Integer) result.getObject("DiasPrestacion"));

            } else {
                //System.out.println("Prestamo Object Not Found!");
                throw new NotFoundException("Prestamo Object Not Found!");
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    protected List listQuery(Connection conn, PreparedStatement stmt, boolean cargarDatosRecurso) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                Prestamo temp = createValueObject();
                temp.setIdPrestamo(result.getInt("Id_Prestamo"));
                temp.setIdrecurso((Integer) result.getObject("Id_recurso"));
                temp.setCodEstudiante((Integer) result.getObject("Cod_Estudiante"));
                temp.setFechaPrestamo(result.getTimestamp("Fecha_Prestamo"));
                temp.setFechaDevolucion(result.getTimestamp("Fecha_Devolucion"));
                temp.setEstado(result.getString("Estado"));
                temp.setIdusuarioEntrada((Integer) result.getObject("Id_usuario_Entrada"));
                temp.setIdusuarioSalida((Integer) result.getObject("Id_usuario_Salida"));
                temp.setApellido(result.getString("Apellido"));
                temp.setDiasPrestacion((Integer) result.getObject("DiasPrestacion"));
                if (cargarDatosRecurso) {
                    temp.setCodigoRecurso(result.getString("codigo"));
                    temp.setDescripcionRecurso(result.getString("Descripcion"));
                    temp.setNombreUsuarioEntrega(result.getString("usuarioEntrada"));
                    temp.setNombreUsuarioSalida(result.getString("usuarioSalida"));
                }
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
