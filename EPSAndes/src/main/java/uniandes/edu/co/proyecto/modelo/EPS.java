package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name=EPS)
public abstract class EPS {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idEPS;
    private String nombre;
    private String direccion;
    private String telefono;
    public EPS(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public EPS(){;}

    public Integer getIdEPS() {
        return idEPS;
    }

    public void setIdEPS(Integer idEPS) {
        this.idEPS = idEPS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    

}
