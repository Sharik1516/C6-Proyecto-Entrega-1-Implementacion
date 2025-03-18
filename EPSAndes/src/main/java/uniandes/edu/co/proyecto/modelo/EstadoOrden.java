package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EstadoOrden")
public class EstadoOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEstadoOrden;

    @Column(unique = true, nullable = false)
    private String nombre;

    public EstadoOrden() {}

    public Integer getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
