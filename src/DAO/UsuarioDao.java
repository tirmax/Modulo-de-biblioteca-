package DAO;

import Modelo.Usuario;
import java.sql.*;
import java.util.*;
import java.math.*;

public class UsuarioDao {

    public Usuario createValueObject() {
        return new Usuario();
    }

    public Usuario getObject(Connection conn, int IdUsuario) throws NotFoundException, SQLException {

        Usuario valueObject = createValueObject();
        valueObject.setIdUsuario(IdUsuario);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Usuario valueObject) throws NotFoundException, SQLException {

        String sql = "SELECT * FROM Usuario WHERE (Id_usuario = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getIdUsuario());

            singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public List loadAll(Connection conn) throws SQLException {

        String sql = "SELECT * FROM Usuario ORDER BY Id_usuario ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
    }

    public synchronized void create(Connection conn, Usuario valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql = "INSERT INTO Usuario (Nombres, Apellidos, "
                    + "Fecha_Registro, Codigo, Contraseña, "
                    + "Rol, Estado) VALUES ( ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, valueObject.getNombres());
            stmt.setString(2, valueObject.getApellidos());
            stmt.setTimestamp(3, valueObject.getFechaRegistro());
            stmt.setString(4, valueObject.getCodigo());
            stmt.setString(5, valueObject.getConatrseña());
            stmt.setString(6, valueObject.getRol());
            stmt.setString(7, valueObject.getEstado());

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

    public void save(Connection conn, Usuario valueObject)
            throws NotFoundException, SQLException {

        String sql = "UPDATE Usuario SET Nombres = ?, Apellidos = ?, Fecha_Registro = ?, "
                + "Codigo = ?, Contraseña = ?, Rol = ?, "
                + "Estado = ? WHERE (Id_usuario = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getNombres());
            stmt.setString(2, valueObject.getApellidos());
            stmt.setTimestamp(3, valueObject.getFechaRegistro());
            stmt.setString(4, valueObject.getCodigo());
            stmt.setString(5, valueObject.getConatrseña());
            stmt.setString(6, valueObject.getRol());
            stmt.setString(7, valueObject.getEstado());

            stmt.setInt(8, valueObject.getIdUsuario());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {

                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {

                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void delete(Connection conn, Usuario valueObject)
            throws NotFoundException, SQLException {

        String sql = "DELETE FROM Usuario WHERE (Id_usuario = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getIdUsuario());

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

        String sql = "DELETE FROM Usuario";
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

        String sql = "SELECT count(*) FROM Usuario";
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

    public List searchByNombresApellidosCodigo(Connection conn, Usuario valueObject) throws SQLException {

        List searchResults;

        StringBuffer sql = new StringBuffer("SELECT * FROM Usuario WHERE  ");

        sql.append(" Nombres LIKE '%").append(valueObject.getNombres()).append("%' OR ");

        sql.append(" Apellidos LIKE '%").append(valueObject.getApellidos()).append("%' OR ");

        sql.append(" Codigo LIKE '%").append(valueObject.getCodigo()).append("%' ");

        sql.append("ORDER BY Id_usuario ASC ");

        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }

    public List searchMatching(Connection conn, Usuario valueObject) throws SQLException {

        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM Usuario WHERE 1=1 ");

        if (valueObject.getIdUsuario() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND Id_usuario = ").append(valueObject.getIdUsuario()).append(" ");
        }

        if (valueObject.getNombres() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Nombres LIKE '").append(valueObject.getNombres()).append("%' ");
        }

        if (valueObject.getApellidos() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Apellidos LIKE '").append(valueObject.getApellidos()).append("%' ");
        }

        if (valueObject.getFechaRegistro() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Fecha_Registro = '").append(valueObject.getFechaRegistro()).append("' ");
        }

        if (valueObject.getCodigo() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Codigo LIKE '").append(valueObject.getCodigo()).append("%' ");
        }

        if (valueObject.getConatrseña() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Contraseña LIKE '").append(valueObject.getConatrseña()).append("%' ");
        }

        if (valueObject.getRol() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Rol LIKE '").append(valueObject.getRol()).append("%' ");
        }

        if (valueObject.getEstado() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND Estado LIKE '").append(valueObject.getEstado()).append("%' ");
        }

        sql.append("ORDER BY Id_usuario ASC ");

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

    protected void singleQuery(Connection conn, PreparedStatement stmt, Usuario valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setIdUsuario(result.getInt("Id_usuario"));
                valueObject.setNombres(result.getString("Nombres"));
                valueObject.setApellidos(result.getString("Apellidos"));
                valueObject.setFechaRegistro(result.getTimestamp("Fecha_Registro"));
                valueObject.setCodigo(result.getString("Codigo"));
                valueObject.setConatrseña(result.getString("Contraseña"));
                valueObject.setRol(result.getString("Rol"));
                valueObject.setEstado(result.getString("Estado"));

            } else {
                //System.out.println("Usuario Object Not Found!");
                throw new NotFoundException("Usuario Object Not Found!");
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

    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                Usuario temp = createValueObject();

                temp.setIdUsuario(result.getInt("Id_usuario"));
                temp.setNombres(result.getString("Nombres"));
                temp.setApellidos(result.getString("Apellidos"));
                temp.setFechaRegistro(result.getTimestamp("Fecha_Registro"));
                temp.setCodigo(result.getString("Codigo"));
                temp.setConatrseña(result.getString("Contraseña"));
                temp.setRol(result.getString("Rol"));
                temp.setEstado(result.getString("Estado"));

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
