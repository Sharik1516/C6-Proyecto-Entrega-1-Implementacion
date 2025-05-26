package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "parentescos")
public class Parentesco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParentesco;

    private String descripcion;

    public Parentesco() {}

    public Parentesco(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Long idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
