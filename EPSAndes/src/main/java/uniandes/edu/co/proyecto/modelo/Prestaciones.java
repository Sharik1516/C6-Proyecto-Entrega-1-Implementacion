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
    private Date fechaHora;

    public Prestaciones(Integer idPrestacion, CitaMedica idCita, Servicio idServicio, Date fechaHora) {
        this.idPrestacion = idPrestacion;
        this.idCita = idCita;
        this.idServicio = idServicio;
        this.fechaHora = fechaHora;
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

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    
    
}
