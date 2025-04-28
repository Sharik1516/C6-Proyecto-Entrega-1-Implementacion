package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Prestaciones")
public class Prestaciones {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer idPrestacion;
    @ManyToOne
    @JoinColumn(name = "idCita")
    private CitaMedica idCita;
    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio idServicio;
    private Date fechaInicio;
    private Date fechaFinal;

    public Prestaciones(Integer idPrestacion, CitaMedica idCita, Servicio idServicio, Date fechaInicio, Date fechaFinal) {
        this.idPrestacion = idPrestacion;
        this.idCita = idCita;
        this.idServicio = idServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Prestaciones() {;}

    public Integer getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(Integer idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public CitaMedica getIdCita() {
        return idCita;
    }

    public void setIdCita(CitaMedica idCita) {
        this.idCita = idCita;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    

    
    
}
