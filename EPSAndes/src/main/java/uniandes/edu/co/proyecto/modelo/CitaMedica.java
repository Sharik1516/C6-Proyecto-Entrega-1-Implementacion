package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "CitaMedica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @ManyToOne
    @JoinColumn(name = "idOrden")
    private OrdenDeServicio idOrden;

    @ManyToOne
    @JoinColumn(name = "NIT")
    private IPS ips;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idAfiliado")
    private Afiliado afiliado;

    public CitaMedica() {}

    public CitaMedica(Date fechaHora, OrdenDeServicio idOrden, IPS ips, Medico medico, Afiliado afiliado) {
        this.fechaHora = fechaHora;
        this.idOrden = idOrden;
        this.ips = ips;
        this.medico = medico;
        this.afiliado = afiliado;
    }

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

    public OrdenDeServicio getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDeServicio idOrden) {
        this.idOrden = idOrden;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

}
