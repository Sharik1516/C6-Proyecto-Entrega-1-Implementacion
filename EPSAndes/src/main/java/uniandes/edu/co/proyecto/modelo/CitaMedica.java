package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "CitaMedica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCita;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @ManyToOne
    @JoinColumn(name = "idOrden")
    private OrdenDeServicio orden;

    @ManyToOne
    @JoinColumn(name = "NIT")
    private IPS NIT;

    public CitaMedica(Date fechaHora, OrdenDeServicio orden, IPS nIT) {
        this.fechaHora = fechaHora;
        this.orden = orden;
        NIT = nIT;
    }

    public CitaMedica() {;}

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public OrdenDeServicio getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeServicio orden) {
        this.orden = orden;
    }

    public IPS getNIT() {
        return NIT;
    }

    public void setNIT(IPS nIT) {
        NIT = nIT;
    }

}
