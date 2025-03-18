package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Afiliado")
public class Afiliado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idAfiliado;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String tipoAfiliado;
    private Usuario idUsuario;
    

    public Afiliado(Date fechaNacimiento, String direccion, String telefono, String tipoAfiliado, Usuario idUsuario) {
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.idUsuario = idUsuario;
    }


    public Afiliado(){;}


    public Integer getIdAfiliado() {
        return idAfiliado;
    }


    public void setIdAfiliado(Integer idAfiliado) {
        this.idAfiliado = idAfiliado;
    }


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


    public Usuario getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    

}
