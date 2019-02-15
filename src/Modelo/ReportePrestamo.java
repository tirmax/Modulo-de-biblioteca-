package Modelo;
import java.sql.Timestamp;

public class ReportePrestamo {
    private int idrecurso;
    private int idPrestamo;
    private String Codigoestudiante;
    private java.sql.Timestamp Fechaprestamo;
    private java.sql.Timestamp FechaDevolucion;
    private String Estado;
    private String id_usuario_entrada;
    private String id_usuario_salida;
    private String apellido;
    private String DiasPrestacion;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getCodigoestudiante() {
        return Codigoestudiante;
    }

    public void setCodigoestudiante(String Codigoestudiante) {
        this.Codigoestudiante = Codigoestudiante;
    }

    public Timestamp getFechaprestamo() {
        return Fechaprestamo;
    }

    public void setFechaprestamo(Timestamp Fechaprestamo) {
        this.Fechaprestamo = Fechaprestamo;
    }

    public Timestamp getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getId_usuario_entrada() {
        return id_usuario_entrada;
    }

    public void setId_usuario_entrada(String id_usuario_entrada) {
        this.id_usuario_entrada = id_usuario_entrada;
    }

    public String getId_usuario_salida() {
        return id_usuario_salida;
    }

    public void setId_usuario_salida(String id_usuario_salida) {
        this.id_usuario_salida = id_usuario_salida;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDiasPrestacion() {
        return DiasPrestacion;
    }

    public void setDiasPrestacion(String DiasPrestacion) {
        this.DiasPrestacion = DiasPrestacion;
    }
    
    public int getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
