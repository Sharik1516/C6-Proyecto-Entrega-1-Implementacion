package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Afiliado")
public abstract class Afiliado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    @ManyToOne
    @JoinColumn(name = "numeroDocumento")
    private Usuario idAfiliado;

    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String tipoAfiliado;
    public Afiliado(Date fechaNacimiento, String direccion, String telefono, String tipoAfiliado) {
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
    }

    public Afiliado(){;}

    public Usuario getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Usuario idAfiliado) {
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

    @Service
    public class AfiliadoService {
        @Autowired
        private AfiliadoRepository afiliadoRepository;

        public Afiliado registrarAfiliado(Afiliado afiliado) {
            return afiliadoRepository.save(afiliado);
        }
    }

    

}
