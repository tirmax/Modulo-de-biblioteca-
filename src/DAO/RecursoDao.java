package DAO;

import Modelo.Recursos;
import Modelo.Usuario;
import java.sql.*;
import java.util.*;
import java.math.*;

public class RecursoDao {

    public Recursos createValueObject() {
        return new Recursos();
    }

    public Recursos getObject(Connection conn, int idrecurso) throws NotFoundException, SQLException {

        Recursos valueObject = createValueObject();
        valueObject.setIdrecurso(idrecurso);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Recursos valueObject) throws NotFoundException, SQLException {

        String sql = "SELECT * FROM Recurso WHERE (id_Recurso = ? ) ";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valueObject.getIdRecurso());

            singleQuery(conn, stmt, valueObject);

        }
    }

    public List loadAll(Connection conn) throws SQLException {

        String sql = "SELECT * FROM Recurso ORDER BY id_Recurso ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public synchronized void create(Connection conn, Recursos valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql = "INSERT INTO Recurso ( Codigo, Nombre, "
                    + "Fecha, Editorial, Descripcion, "
                    + "Autor, Estado, Ubicacion, "
                    + "Tipo_Recurso, Id_usuario) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, valueObject.getCodigo(), Types.INTEGER);
            stmt.setString(2, valueObject.getNombre());
            stmt.setTimestamp(3, valueObject.getFecha());
            stmt.setString(4, valueObject.getEditorial());
            stmt.setString(5, valueObject.getDescripcion());
            stmt.setString(6, valueObject.getAutor());
            stmt.setString(7, valueObject.getEstado());
            stmt.setString(8, valueObject.getUbicacion());
            stmt.setString(9, valueObject.getTipoRecurso());
            stmt.setObject(10, valueObject.getIdusuario(), Types.INTEGER);

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

    public void save(Connection conn, Recursos valueObject)
            throws NotFoundException, SQLException {

        String sql = "UPDATE Recurso SET Codigo = ?, Nombre = ?, Fecha = ?, "
                + "Editorial = ?, Descripcion = ?, Autor = ?, "
                + "Estado = ?, Ubicacion = ?, Tipo_Recurso = ?, "
                + "Id_usuario = ? WHERE (id_Recurso = ? ) ";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, valueObject.getCodigo(), Types.INTEGER);
            stmt.setString(2, valueObject.getNombre());
            stmt.setTimestamp(3, valueObject.getFecha());
            stmt.setString(4, valueObject.getEditorial());
            stmt.setString(5, valueObject.getDescripcion());
            stmt.setString(6, valueObject.getAutor());
            stmt.setString(7, valueObject.getEstado());
            stmt.setString(8, valueObject.getUbicacion());
            stmt.setString(9, valueObject.getTipoRecurso());
            stmt.setObject(10, valueObject.getIdusuario(), Types.INTEGER);
            stmt.setInt(11, valueObject.getIdRecurso());

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

    public void delete(Connection conn, Recursos valueObject)
            throws NotFoundException, SQLException {

        String sql = "DELETE FROM Recurso WHERE (id_Recurso = ? ) ";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valueObject.getIdRecurso());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                //System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        }
    }

    public void deleteAll(Connection conn) throws SQLException {

        String sql = "DELETE FROM Recurso";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rowcount = databaseUpdate(conn, stmt);
        }
    }

    public int countAll(Connection conn) throws SQLException {

        String sql = "SELECT count(*) FROM Recurso";
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

    public List searchByLibros(Connection conn, Recursos valueObject) throws SQLException {

        List searchResults;

        StringBuffer sql = new StringBuffer("SELECT * FROM Recurso WHERE  ");

        sql.append(" Codigo LIKE '%").append(valueObject.getCodigo()).append("%' OR ");

        sql.append(" Nombre LIKE '%").append(valueObject.getNombre()).append("%' OR ");

        sql.append(" Autor LIKE '%").append(valueObject.getAutor()).append("%' OR ");

        sql.append(" Estado LIKE '%").append(valueObject.getEstado()).append("%' OR ");

        sql.append(" Ubicacion LIKE '%").append(valueObject.getUbicacion()).append("%' OR ");

        sql.append(" Editorial LIKE '%").append(valueObject.getEditorial()).append("%' OR");

        sql.append(" Descripcion LIKE '%").append(valueObject.getDescripcion()).append("%'OR ");

        sql.append(" Tipo_recurso LIKE '%").append(valueObject.getDescripcion()).append("%' ");

        sql.append("ORDER BY Id_Recurso ASC ");

        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }

    public List searchMatching(Connection conn, Recursos valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuilder sql = new StringBuilder("SELECT * FROM Recurso WHERE 1=1 ");

        if (valueObject.getIdRecurso() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND id_Recurso = ").append(valueObject.getIdRecurso()).append(" ");
        }

        if (valueObject.getCodigo() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Codigo = ").append(valueObject.getCodigo()).append(" ");
        }

        if (valueObject.getNombre() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Nombre LIKE '").append(valueObject.getNombre()).append("%' ");
        }

        if (valueObject.getFecha() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Fecha = '").append(valueObject.getFecha()).append("' ");
        }

        if (valueObject.getEditorial() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Editorial LIKE '").append(valueObject.getEditorial()).append("%' ");
        }

        if (valueObject.getDescripcion() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Descripcion LIKE '").append(valueObject.getDescripcion()).append("%' ");
        }

        if (valueObject.getAutor() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Autor LIKE '").append(valueObject.getAutor()).append("%' ");
        }

        if (valueObject.getEstado() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Estado LIKE '").append(valueObject.getEstado()).append("%' ");
        }

        if (valueObject.getUbicacion() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Ubicacion LIKE '").append(valueObject.getUbicacion()).append("%' ");
        }

        if (valueObject.getTipoRecurso() != null) {
            if (first) {
                first = false;
            }
            if (valueObject.getTipoRecurso().equals("OTRO")) {
                sql.append("AND Tipo_Recurso NOT IN ('LIBRO','CD','REVISTA')");
            } else {
                sql.append("AND Tipo_Recurso LIKE '").append(valueObject.getTipoRecurso()).append("%' ");
            }
        }

        if (valueObject.getIdusuario()
                != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_usuario = ").append(valueObject.getIdusuario()).append(" ");
        }

        sql.append(
                "ORDER BY id_Recurso ASC ");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.
        if (first) {
            searchResults = new ArrayList();
        } else {
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));
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

    protected void singleQuery(Connection conn, PreparedStatement stmt, Recursos valueObject)
            throws NotFoundException, SQLException {

        try (ResultSet result = stmt.executeQuery()) {

            if (result.next()) {

                valueObject.setIdrecurso(result.getInt("id_Recurso"));
                valueObject.setCodigo(result.getString("Codigo"));
                valueObject.setNombre(result.getString("Nombre"));
                valueObject.setFecha(result.getTimestamp("Fecha"));
                valueObject.setEditorial(result.getString("Editorial"));
                valueObject.setDescripcion(result.getString("Descripcion"));
                valueObject.setAutor(result.getString("Autor"));
                valueObject.setEstado(result.getString("Estado"));
                valueObject.setUbicacion(result.getString("Ubicacion"));
                valueObject.setTipoRecurso(result.getString("Tipo_Recurso"));
                valueObject.setIdusuario((Integer) result.getObject("Id_usuario"));

            } else {
                //System.out.println("Recursos Object Not Found!");
                throw new NotFoundException("Recurso Object Not Found!");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                Recursos temp = createValueObject();

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
