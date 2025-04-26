package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer idServicio;
    private String nombre;
    private String Descripcion;
    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        Descripcion = descripcion;
    }
    public Servicio() {;}
    public Integer getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


}
