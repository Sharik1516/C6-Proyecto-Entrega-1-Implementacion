package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "ordenesServicio")
public class OrdenDeServicio {

    @Id
    private String id;

    private Date fecha;
    private String estado;
    private String idAfiliado;
    private String idMedico;
    private String idServicio;

    public OrdenDeServicio() {}

    public OrdenDeServicio(Date fecha, String estado, String idAfiliado, String idMedico, String idServicio) {
        this.fecha = fecha;
        this.estado = estado;
        this.idAfiliado = idAfiliado;
        this.idMedico = idMedico;
        this.idServicio = idServicio;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getIdAfiliado() { return idAfiliado; }
    public void setIdAfiliado(String idAfiliado) { this.idAfiliado = idAfiliado; }

    public String getIdMedico() { return idMedico; }
    public void setIdMedico(String idMedico) { this.idMedico = idMedico; }

    public String getIdServicio() { return idServicio; }
    public void setIdServicio(String idServicio) { this.idServicio = idServicio; }
}
