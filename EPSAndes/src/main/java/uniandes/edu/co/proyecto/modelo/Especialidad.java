package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idEspecialidad;
    private String nombre;
    public Especialidad(String nombre) {
        this.nombre = nombre;
    }
    public Especialidad() {
        ;
    }
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
