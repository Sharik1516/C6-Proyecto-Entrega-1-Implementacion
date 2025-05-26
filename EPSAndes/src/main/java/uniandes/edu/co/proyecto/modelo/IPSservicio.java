package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ipsServicios")
public class IPSservicio {

    @Id
    private String id;
    private String nitIPS;
    private String idServicio;
    private String disponibilidad;

    public IPSservicio() {}

    public IPSservicio(String nitIPS, String idServicio, String disponibilidad) {
        this.nitIPS = nitIPS;
        this.idServicio = idServicio;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNitIPS() {
        return nitIPS;
    }

    public void setNitIPS(String nitIPS) {
        this.nitIPS = nitIPS;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    private boolean activo;

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }
}
