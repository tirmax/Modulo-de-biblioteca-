package Modelo;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;



public class Recursos implements Cloneable, Serializable {

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

    public Recursos () {

    }

    public Recursos (int idrecursoIn) {

          this.idrecurso = idrecursoIn;

    }

    public int getIdRecurso() {
          return this.idrecurso;
    }
    public void setIdrecurso(int idrecursoIn) {
          this.idrecurso = idrecursoIn;
    }

    public String getCodigo() {
          return this.Codigo;
    }
    public void setCodigo(String CodigoIn) {
          this.Codigo = CodigoIn;
    }

    public String getNombre() {
          return this.Nombre;
    }
    public void setNombre(String NombreIn) {
          this.Nombre = NombreIn;
    }

    public java.sql.Timestamp getFecha() {
          return this.Fecha;
    }
    public void setFecha(java.sql.Timestamp FechaIn) {
          this.Fecha = FechaIn;
    }

    public String getEditorial() {
          return this.Editorial;
    }
    public void setEditorial(String EditorialIn) {
          this.Editorial = EditorialIn;
    }

    public String getDescripcion() {
          return this.Descripcion;
    }
    public void setDescripcion(String DescripcionIn) {
          this.Descripcion = DescripcionIn;
    }

    public String getAutor() {
          return this.Autor;
    }
    public void setAutor(String AutorIn) {
          this.Autor = AutorIn;
    }

    public String getEstado() {
          return this.Estado;
    }
    public void setEstado(String EstadoIn) {
          this.Estado = EstadoIn;
    }

    public String getUbicacion() {
          return this.Ubicacion;
    }
    public void setUbicacion(String UbicacionIn) {
          this.Ubicacion = UbicacionIn;
    }

    public String getTipoRecurso() {
          return this.TipoRecurso;
    }
    public void setTipoRecurso(String TipoRecursoIn) {
          this.TipoRecurso = TipoRecursoIn;
    }

    public Integer getIdusuario() {
          return this.Idusuario;
    }
    public void setIdusuario(Integer IdusuarioIn) {
          this.Idusuario = IdusuarioIn;
    }

    public void setAll(int idrecursoIn,
          String CodigoIn,
          String NombreIn,
          java.sql.Timestamp FechaIn,
          String EditorialIn,
          String DescripcionIn,
          String AutorIn,
          String EstadoIn,
          String UbicacionIn,
          String TipoRecursoIn,
          Integer IdusuarioIn) {
          this.idrecurso = idrecursoIn;
          this.Codigo = CodigoIn;
          this.Nombre = NombreIn;
          this.Fecha = FechaIn;
          this.Editorial = EditorialIn;
          this.Descripcion = DescripcionIn;
          this.Autor = AutorIn;
          this.Estado = EstadoIn;
          this.Ubicacion = UbicacionIn;
          this.TipoRecurso = TipoRecursoIn;
          this.Idusuario = IdusuarioIn;
    }

    public boolean hasEqualMapping(Recursos valueObject) {

          if (valueObject.getIdRecurso() != this.idrecurso) {
                    return(false);
          }
          if (this.Codigo == null) {
                    if (valueObject.getCodigo() != null)
                           return(false);
          } else if (!this.Codigo.equals(valueObject.getCodigo())) {
                    return(false);
          }
          if (this.Nombre == null) {
                    if (valueObject.getNombre() != null)
                           return(false);
          } else if (!this.Nombre.equals(valueObject.getNombre())) {
                    return(false);
          }
          if (this.Fecha == null) {
                    if (valueObject.getFecha() != null)
                           return(false);
          } else if (!this.Fecha.equals(valueObject.getFecha())) {
                    return(false);
          }
          if (this.Editorial == null) {
                    if (valueObject.getEditorial() != null)
                           return(false);
          } else if (!this.Editorial.equals(valueObject.getEditorial())) {
                    return(false);
          }
          if (this.Descripcion == null) {
                    if (valueObject.getDescripcion() != null)
                           return(false);
          } else if (!this.Descripcion.equals(valueObject.getDescripcion())) {
                    return(false);
          }
          if (this.Autor == null) {
                    if (valueObject.getAutor() != null)
                           return(false);
          } else if (!this.Autor.equals(valueObject.getAutor())) {
                    return(false);
          }
          if (this.Estado == null) {
                    if (valueObject.getEstado() != null)
                           return(false);
          } else if (!this.Estado.equals(valueObject.getEstado())) {
                    return(false);
          }
          if (this.Ubicacion == null) {
                    if (valueObject.getUbicacion() != null)
                           return(false);
          } else if (!this.Ubicacion.equals(valueObject.getUbicacion())) {
                    return(false);
          }
          if (this.TipoRecurso == null) {
                    if (valueObject.getTipoRecurso() != null)
                           return(false);
          } else if (!this.TipoRecurso.equals(valueObject.getTipoRecurso())) {
                    return(false);
          }
          if (this.Idusuario == null) {
                    if (valueObject.getIdusuario() != null)
                           return(false);
          } else if (!this.Idusuario.equals(valueObject.getIdusuario())) {
                    return(false);
          }

          return true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.getDaogenVersion());
        out.append("\nclass Recurso, mapping to table Recurso\n");
        out.append("Persistent attributes: \n"); 
        out.append("idrecurso = " + this.idrecurso + "\n"); 
        out.append("Codigo = " + this.Codigo + "\n"); 
        out.append("Nombre = " + this.Nombre + "\n"); 
        out.append("Fecha = " + this.Fecha + "\n"); 
        out.append("Editorial = " + this.Editorial + "\n"); 
        out.append("Descripcion = " + this.Descripcion + "\n"); 
        out.append("Autor = " + this.Autor + "\n"); 
        out.append("Estado = " + this.Estado + "\n"); 
        out.append("Ubicacion = " + this.Ubicacion + "\n"); 
        out.append("TipoRecurso = " + this.TipoRecurso + "\n"); 
        out.append("Idusuario = " + this.Idusuario + "\n"); 
        return out.toString();
    }

    public Object clone() {
        Recursos cloned = new Recursos();

        cloned.setIdrecurso(this.idrecurso); 
        if (this.Codigo != null)
             cloned.setCodigo(this.Codigo); 
        if (this.Nombre != null)
             cloned.setNombre(this.Nombre); 
        if (this.Fecha != null)
             cloned.setFecha((java.sql.Timestamp)this.Fecha.clone()); 
        if (this.Editorial != null)
             cloned.setEditorial(this.Editorial); 
        if (this.Descripcion != null)
             cloned.setDescripcion(this.Descripcion); 
        if (this.Autor != null)
             cloned.setAutor(this.Autor); 
        if (this.Estado != null)
             cloned.setEstado(this.Estado); 
        if (this.Ubicacion != null)
             cloned.setUbicacion(this.Ubicacion); 
        if (this.TipoRecurso != null)
             cloned.setTipoRecurso(this.TipoRecurso); 
        if (this.Idusuario != null)
             cloned.setIdusuario(this.Idusuario); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public void setIdrecurso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}