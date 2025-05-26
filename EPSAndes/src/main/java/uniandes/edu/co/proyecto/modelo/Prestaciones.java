package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prestaciones")
public class Prestaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPrestacion;

    @ManyToOne
    @JoinColumn(name = "id_cita")
    private CitaMedica cita;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    private Date fechaInicio;
    private Date fechaFinal;

    public Prestaciones() {}

    public Prestaciones(CitaMedica cita, Servicio servicio, Date fechaInicio, Date fechaFinal) {
        this.cita = cita;
        this.servicio = servicio;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Long getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(Long idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public CitaMedica getCita() {
        return cita;
    }

    public void setCita(CitaMedica cita) {
        this.cita = cita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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
