package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name=IPS)
public abstract class IPS {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer NIT;
    private String nombre;
    private String direccion;
    private String telefono;
    private EPS idEps;
    public IPS(String nombre, String direccion, String telefono, EPS idEps) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idEps = idEps;
    }
    public Integer getNIT() {
        return NIT;
    }
    public void setNIT(Integer nIT) {
        NIT = nIT;
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
    public EPS getIdEps() {
        return idEps;
    }
    public void setIdEps(EPS idEps) {
        this.idEps = idEps;
    }

    


}
