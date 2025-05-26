package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "afiliados")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Afiliado extends Usuario {

    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String tipoAfiliado;

    public Afiliado(String nombre, String tipoDocumento, String numeroDocumento,
                    Date fechaNacimiento, String direccion, String telefono, String tipoAfiliado) {
        super(nombre, tipoDocumento, numeroDocumento);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
    }

    public Afiliado() {}

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }
}
