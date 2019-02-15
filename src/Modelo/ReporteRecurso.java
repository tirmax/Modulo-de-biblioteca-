package Modelo;
import java.sql.Timestamp;

public class ReporteRecurso {
    private int idrecurso;
    private String Codigo;
    private String Nombre;
    private java.sql.Timestamp Fecha;
    private String Editorial;
    private String Descripcion;
    private String Autor;
    private String Estado;
    private String Ubicacion;
    private String TipoRecurso;
    private Integer Idusuario;
    private String nombreUsuario;
    private java.sql.Timestamp FechaPrestamo;
    private String codigoEstudiante;

    public int getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp Fecha) {
        this.Fecha = Fecha;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getTipoRecurso() {
        return TipoRecurso;
    }

    public void setTipoRecurso(String TipoRecurso) {
        this.TipoRecurso = TipoRecurso;
    }

    public Integer getIdusuario() {
        return Idusuario;
    }

    public void setIdusuario(Integer Idusuario) {
        this.Idusuario = Idusuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Timestamp getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(Timestamp FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
    
    
}
