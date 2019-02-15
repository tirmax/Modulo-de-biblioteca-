package Modelo;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Prestamo implements Cloneable, Serializable {

    private int IdPrestamo;
    private Integer Idrecurso;
    private Integer CodEstudiante;
    private String Apellido;
    private Integer DiasPrestacion;
    private java.sql.Timestamp FechaPrestamo;
    private java.sql.Timestamp FechaDevolucion;
    private String Estado;
    private Integer IdusuarioEntrada;
    private Integer IdusuarioSalida;
    private Integer Idusuario;
    private String codigoRecurso;
    private String nombreRecuros;
    private String descripcionRecurso;
    private String nombreUsuarioEntrega;
    private String nombreUsuarioSalida;

    public String getNombreUsuarioSalida() {
        return nombreUsuarioSalida;
    }

    public void setNombreUsuarioSalida(String nombreUsuarioSalida) {
        this.nombreUsuarioSalida = nombreUsuarioSalida;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Integer getDiasPrestacion() {
        return DiasPrestacion;
    }

    public void setDiasPrestacion(Integer DiasPrestacion) {
        this.DiasPrestacion = DiasPrestacion;
    }
    
    public String getNombreRecuros() {
        return nombreRecuros;
    }

    public void setNombreRecuros(String nombreRecuros) {
        this.nombreRecuros = nombreRecuros;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    
    public String getCodigoRecurso() {
        return codigoRecurso;
    }

    public void setCodigoRecurso(String codigoRecurso) {
        this.codigoRecurso = codigoRecurso;
    }

    public String getNombreUsuarioEntrega() {
        return nombreUsuarioEntrega;
    }

    public void setNombreUsuarioEntrega(String nombreUsuarioEntrega) {
        this.nombreUsuarioEntrega = nombreUsuarioEntrega;
    }

    public Prestamo() {

    }

    public Prestamo(int IdPrestamoIn) {

        this.IdPrestamo = IdPrestamoIn;

    }

    public int getIdPrestamo() {
        return this.IdPrestamo;
    }

    public void setIdPrestamo(int IdPrestamoIn) {
        this.IdPrestamo = IdPrestamoIn;
    }

    public Integer getIdrecurso() {
        return this.Idrecurso;
    }

    public void setIdrecurso(Integer IdrecursoIn) {
        this.Idrecurso = IdrecursoIn;
    }

    public Integer getCodEstudiante() {
        return this.CodEstudiante;
    }

    public void setCodEstudiante(Integer CodEstudianteIn) {
        this.CodEstudiante = CodEstudianteIn;
    }
 
    public java.sql.Timestamp getFechaPrestamo() {
        return this.FechaPrestamo;
    }

    public void setFechaPrestamo(java.sql.Timestamp FechaPrestamoIn) {
        this.FechaPrestamo = FechaPrestamoIn;
    }

    public java.sql.Timestamp getFechaDevolucion() {
        return this.FechaDevolucion;
    }

    public void setFechaDevolucion(java.sql.Timestamp FechaDevolucionIn) {
        this.FechaDevolucion = FechaDevolucionIn;
    }

    public String getEstado() {
        return this.Estado;
    }

    public void setEstado(String EstadoIn) {
        this.Estado = EstadoIn;
    }

    public Integer getIdusuarioEntrada() {
        return this.IdusuarioEntrada;
    }

    public void setIdusuarioEntrada(Integer IdusuarioEntradaIn) {
        this.IdusuarioEntrada = IdusuarioEntradaIn;
    }

    public Integer getIdusuarioSalida() {
        return this.IdusuarioSalida;
    }

    public void setIdusuarioSalida(Integer IdusuarioSalidaIn) {
        this.IdusuarioSalida = IdusuarioSalidaIn;
    }

    public Integer getIdusuario() {
        return this.Idusuario;
    }

    public void setIdusuario(Integer IdusuarioIn) {
        this.Idusuario = IdusuarioIn;
    }

    public void setAll(int IdPrestamoIn,
            Integer IdrecursoIn,
            Integer CodEstudianteIn,
            String NombreIn,
            String ApellidoIn,
            Integer DiasPrestacionIn,
            java.sql.Timestamp FechaPrestamoIn,
            java.sql.Timestamp FechaDevolucionIn,
            String EstadoIn,
            Integer IdusuarioEntradaIn,
            Integer IdusuarioSalidaIn) {
        this.IdPrestamo = IdPrestamoIn;
        this.Idrecurso = IdrecursoIn;
        this.CodEstudiante = CodEstudianteIn;
        this.Apellido = ApellidoIn;
        this.DiasPrestacion = DiasPrestacionIn;
        this.FechaPrestamo = FechaPrestamoIn;
        this.FechaDevolucion = FechaDevolucionIn;
        this.Estado = EstadoIn;
        this.IdusuarioEntrada = IdusuarioEntradaIn;
        this.IdusuarioSalida = IdusuarioSalidaIn;
    }

    public boolean hasEqualMapping(Prestamo valueObject) {

        if (valueObject.getIdPrestamo() != this.IdPrestamo) {
            return (false);
        }
        if (this.Idrecurso == null) {
            if (valueObject.getIdrecurso() != null) {
                return (false);
            }
        } else if (!this.Idrecurso.equals(valueObject.getIdrecurso())) {
            return (false);
        }
        if (this.CodEstudiante == null) {
            if (valueObject.getCodEstudiante() != null) {
                return (false);
            }
        } else if (!this.CodEstudiante.equals(valueObject.getCodEstudiante())) {
            return (false);
        }

        if (this.Apellido == null) {
            if (valueObject.getApellido()!= null) {
                return (false);
            }
        } else if (!this.Apellido.equals(valueObject.getApellido())) {
            return (false);
        }
        if (this.DiasPrestacion == null) {
            if (valueObject.getDiasPrestacion()!= null) {
                return (false);
            }
        } else if (!this.DiasPrestacion.equals(valueObject.getDiasPrestacion())) {
            return (false);
        }        
        if (this.FechaPrestamo == null) {
            if (valueObject.getFechaPrestamo() != null) {
                return (false);
            }
        } else if (!this.FechaPrestamo.equals(valueObject.getFechaPrestamo())) {
            return (false);
        }
        if (this.FechaDevolucion == null) {
            if (valueObject.getFechaDevolucion() != null) {
                return (false);
            }
        } else if (!this.FechaDevolucion.equals(valueObject.getFechaDevolucion())) {
            return (false);
        }
        if (this.Estado == null) {
            if (valueObject.getEstado() != null) {
                return (false);
            }
        } else if (!this.Estado.equals(valueObject.getEstado())) {
            return (false);
        }
        if (this.IdusuarioEntrada == null) {
            if (valueObject.getIdusuarioEntrada() != null) {
                return (false);
            }
        } else if (!this.IdusuarioEntrada.equals(valueObject.getIdusuarioEntrada())) {
            return (false);
        }
        if (this.IdusuarioSalida == null) {
            if (valueObject.getIdusuarioSalida() != null) {
                return (false);
            }
        } else if (!this.IdusuarioSalida.equals(valueObject.getIdusuarioSalida())) {
            return (false);
        }

        return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Prestamo, mapping to table prestamo\n");
        out.append("Persistent attributes: \n");
        out.append("IdPrestamo = " + this.IdPrestamo + "\n");
        out.append("Idrecurso = " + this.Idrecurso + "\n");
        out.append("CodEstudiante = " + this.CodEstudiante + "\n");        
        out.append("Apellido = " + this.Apellido + "\n");
        out.append("DiasPrestacion = " + this.DiasPrestacion + "\n");
        out.append("FechaPrestamo = " + this.FechaPrestamo + "\n");
        out.append("FechaDevolucion = " + this.FechaDevolucion + "\n");
        out.append("Estado = " + this.Estado + "\n");
        out.append("IdusuarioEntrada = " + this.IdusuarioEntrada + "\n");
        out.append("IdusuarioSalida = " + this.IdusuarioSalida + "\n");
        return out.toString();
    }

    public Object clone() {
        Prestamo cloned = new Prestamo();

        cloned.setIdPrestamo(this.IdPrestamo);
        if (this.Idrecurso != null) {
            cloned.setIdrecurso(new Integer(this.Idrecurso.intValue()));
        }
        if (this.CodEstudiante != null) {
            cloned.setCodEstudiante(new Integer(this.CodEstudiante.intValue()));
        }
        if (this.Apellido != null) {
            cloned.setApellido(new String(this.Apellido));
        }
        if (this.DiasPrestacion != null) {
            cloned.setDiasPrestacion(new Integer(this.DiasPrestacion));
        }        
        if (this.FechaPrestamo != null) {
            cloned.setFechaPrestamo((java.sql.Timestamp) this.FechaPrestamo.clone());
        }
        if (this.FechaDevolucion != null) {
            cloned.setFechaDevolucion((java.sql.Timestamp) this.FechaDevolucion.clone());
        }
        if (this.Estado != null) {
            cloned.setEstado(new String(this.Estado));
        }
        if (this.IdusuarioEntrada != null) {
            cloned.setIdusuarioEntrada(new Integer(this.IdusuarioEntrada.intValue()));
        }
        if (this.IdusuarioSalida != null) {
            cloned.setIdusuarioSalida(new Integer(this.IdusuarioSalida.intValue()));
        }
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
