package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parentesco")
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idParentesco;
    private String Descripcion;
    public Parentesco(String descripcion) {
        Descripcion = descripcion;
    }
    public Parentesco() {;}
    public Integer getIdParentesco() {
        return idParentesco;
    }
    public void setIdParentesco(Integer idParentesco) {
        this.idParentesco = idParentesco;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    

}
