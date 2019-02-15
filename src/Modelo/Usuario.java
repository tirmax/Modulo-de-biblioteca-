package Modelo;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;



public class Usuario implements Cloneable, Serializable {

    private int IdUsuario;
    private String Nombres;
    private String Apellidos;
    private java.sql.Timestamp FechaRegistro;
    private String Codigo;
    private String Conatrseña;
    private String Rol;
    private String Estado;


    public Usuario () {

    }

    public Usuario (int IdUsuarioIn) {

          this.IdUsuario = IdUsuarioIn;

    }

    public int getIdUsuario() {
          return this.IdUsuario;
    }
    public void setIdUsuario(int IdUsuarioIn) {
          this.IdUsuario = IdUsuarioIn;
    }

    public String getNombres() {
          return this.Nombres;
    }
    public void setNombres(String NombresIn) {
          this.Nombres = NombresIn;
    }

    public String getApellidos() {
          return this.Apellidos;
    }
    public void setApellidos(String ApellidosIn) {
          this.Apellidos = ApellidosIn;
    }

    public java.sql.Timestamp getFechaRegistro() {
          return this.FechaRegistro;
    }
    public void setFechaRegistro(java.sql.Timestamp FechaRegistroIn) {
          this.FechaRegistro = FechaRegistroIn;
    }

    public String getCodigo() {
          return this.Codigo;
    }
    public void setCodigo(String CodigoIn) {
          this.Codigo = CodigoIn;
    }

    public String getConatrseña() {
          return this.Conatrseña;
    }
    public void setConatrseña(String ConatrseñaIn) {
          this.Conatrseña = ConatrseñaIn;
    }

    public String getRol() {
          return this.Rol;
    }
    public void setRol(String RolIn) {
          this.Rol = RolIn;
    }

    public String getEstado() {
          return this.Estado;
    }
    public void setEstado(String EstadoIn) {
          this.Estado = EstadoIn;
    }

    public void setAll(int IdUsuarioIn,
          String NombresIn,
          String ApellidosIn,
          java.sql.Timestamp FechaRegistroIn,
          String CodigoIn,
          String ConatrseñaIn,
          String RolIn,
          String EstadoIn) {
          this.IdUsuario = IdUsuarioIn;
          this.Nombres = NombresIn;
          this.Apellidos = ApellidosIn;
          this.FechaRegistro = FechaRegistroIn;
          this.Codigo = CodigoIn;
          this.Conatrseña = ConatrseñaIn;
          this.Rol = RolIn;
          this.Estado = EstadoIn;
    }

    public boolean hasEqualMapping(Usuario valueObject) {

          if (valueObject.getIdUsuario() != this.IdUsuario) {
                    return(false);
          }
          if (this.Nombres == null) {
                    if (valueObject.getNombres() != null)
                           return(false);
          } else if (!this.Nombres.equals(valueObject.getNombres())) {
                    return(false);
          }
          if (this.Apellidos == null) {
                    if (valueObject.getApellidos() != null)
                           return(false);
          } else if (!this.Apellidos.equals(valueObject.getApellidos())) {
                    return(false);
          }
          if (this.FechaRegistro == null) {
                    if (valueObject.getFechaRegistro() != null)
                           return(false);
          } else if (!this.FechaRegistro.equals(valueObject.getFechaRegistro())) {
                    return(false);
          }
          if (this.Codigo == null) {
                    if (valueObject.getCodigo() != null)
                           return(false);
          } else if (!this.Codigo.equals(valueObject.getCodigo())) {
                    return(false);
          }
          if (this.Conatrseña == null) {
                    if (valueObject.getConatrseña() != null)
                           return(false);
          } else if (!this.Conatrseña.equals(valueObject.getConatrseña())) {
                    return(false);
          }
          if (this.Rol == null) {
                    if (valueObject.getRol() != null)
                           return(false);
          } else if (!this.Rol.equals(valueObject.getRol())) {
                    return(false);
          }
          if (this.Estado == null) {
                    if (valueObject.getEstado() != null)
                           return(false);
          } else if (!this.Estado.equals(valueObject.getEstado())) {
                    return(false);
          }

          return true;
    }


    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Usuario, mapping to table Usuario\n");
        out.append("Persistent attributes: \n"); 
        out.append("IdUsuario = " + this.IdUsuario + "\n"); 
        out.append("Nombres = " + this.Nombres + "\n"); 
        out.append("Apellidos = " + this.Apellidos + "\n"); 
        out.append("FechaRegistro = " + this.FechaRegistro + "\n"); 
        out.append("Codigo = " + this.Codigo + "\n"); 
        out.append("Conatrseña = " + this.Conatrseña + "\n"); 
        out.append("Rol = " + this.Rol + "\n"); 
        out.append("Estado = " + this.Estado + "\n"); 
        return out.toString();
    }


    public Object clone() {
        Usuario cloned = new Usuario();

        cloned.setIdUsuario(this.IdUsuario); 
        if (this.Nombres != null)
             cloned.setNombres(new String(this.Nombres)); 
        if (this.Apellidos != null)
             cloned.setApellidos(new String(this.Apellidos)); 
        if (this.FechaRegistro != null)
             cloned.setFechaRegistro((java.sql.Timestamp)this.FechaRegistro.clone()); 
        if (this.Codigo != null)
             cloned.setCodigo(new String(this.Codigo)); 
        if (this.Conatrseña != null)
             cloned.setConatrseña(new String(this.Conatrseña)); 
        if (this.Rol != null)
             cloned.setRol(new String(this.Rol)); 
        if (this.Estado != null)
             cloned.setEstado(new String(this.Estado)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
